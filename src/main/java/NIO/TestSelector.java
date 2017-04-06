package NIO;

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

/**
 * Created by fupeng on 2017/4/6.
 */
public class TestSelector {
    private void startServer() throws IOException{
        Selector selector = Selector.open();
        {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ServerSocket ss = ssc.socket();
            InetSocketAddress address = new InetSocketAddress(9000);

            ss.bind(address);
            System.out.println("ssc 0:"+ssc);
            System.out.println("ss 0:"+ ss);
            SelectionKey acceptKey = ssc.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("acceptKey:"+acceptKey);
            pringKeyInfo(acceptKey);
            System.out.println("Going to listen on 9000");
        }

        while (true){
            System.out.println("=====================\nstart select ...");
            int num = selector.select();
            System.out.println("NIOServer : Number of  keys after select operation:"+num);

            Set<SelectionKey> seleectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = seleectionKeys.iterator();

            while(it.hasNext()){
                SelectionKey key = it.next();

                System.out.println("key:"+key);
                pringKeyInfo(key);

                it.remove();

                if((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT){
                    System.out.println("select ACCEPT");
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);

                    System.out.println("ssc 1:"+ ssc);
                    System.out.println("sc 1:"+sc);

                    SelectionKey newKey = sc.register(selector,SelectionKey.OP_READ);
                    System.out.println("new key:"+ newKey);
                    pringKeyInfo(newKey);
                }else  if( (key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ){
                    SocketChannel sc =  (SocketChannel) key.channel();
                    System.out.println("sc 2:" + sc);

                    int nbyte = 0;

                    ByteBuffer echoBuffer = ByteBuffer.allocate(1024);

                    while(true){
                        echoBuffer.clear();
                        int  r = sc.read(echoBuffer);
                        if (r<=0) break;

//                        echoBuffer.putChar('f');

                        echoBuffer.flip();

                        sc.write(echoBuffer);
                        nbyte += r;
                    }
                    System.out.println("recv:"+echoBuffer.get());

                    System.out.println("echo" + nbyte+" from " + sc);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    System.out.println("else");
                    System.out.println(key.readyOps());
                }
            }

        }
    }

    private static void pringKeyInfo(SelectionKey sk){
        String s = new String();

        s = "Att:" + (sk.attachment() == null ? "no" : "yes");
        s+= ",Read:"+sk.isReadable();

        System.out.println(s);
    }
    public static void main(String[] args) {
        try {
            new TestSelector().startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
