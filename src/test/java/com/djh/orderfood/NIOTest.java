package com.djh.orderfood;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket ss = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(11000);
        ss.bind(address); //1
        serverChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT); //2
        while (true) {
            try {
                selector.select(); // //3
            } catch (IOException ex) {
                ex.printStackTrace();
                // handle in a proper way 
                break;
            }
            Set readyKeys = selector.selectedKeys(); //4
            Iterator iterator = readyKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove(); //5
                try {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel)
                                key.channel();
                        SocketChannel client = server.accept(); //6
                        System.out.println("Accepted connection from " +
                                client);
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_WRITE |
                                SelectionKey.OP_READ, ByteBuffer.allocate(100)); //7
                    }
                    if (key.isReadable()) { //8
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer[] byteBuffers = new ByteBuffer[1024];
                        long read = client.read(byteBuffers);
                        String s = byteBuffers.toString();
                        System.out.println("s = " + s);
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        client.read(output); //9
                    }
                    if (key.isWritable()) { //10
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        output.flip();
                        client.write(output); //11
                        output.compact();
                    }
                } catch (IOException ex) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException cex) {
                    }
                }
            }
        }
    }
}
