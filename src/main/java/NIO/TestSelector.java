package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
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

//                    while(true){
                        echoBuffer.clear();

                        echoBuffer.put("a".getBytes());
                        echoBuffer.put("b".getBytes());
                    System.out.println("position:"+echoBuffer.position());
                        int  r = sc.read(echoBuffer);

                    System.out.println("position:"+echoBuffer.position());
                        echoBuffer.put("c".getBytes());
                    System.out.println("position:"+echoBuffer.position());
                        echoBuffer.put("d".getBytes());
                    echoBuffer.put("\n".getBytes());
//                        if (r<=1) break;
//                        echoBuffer.rewind();
                        echoBuffer.flip();

                    System.out.println(getString(echoBuffer));

                        sc.write(echoBuffer);

                        nbyte += r;
//                    }
//                    System.out.println("recv:"+echoBuffer.get());

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

    public static String getString(ByteBuffer buffer) {
        Charset charset = null;
        CharsetDecoder decoder = null;
        CharBuffer charBuffer = null;
        try {
            charset = Charset.forName("UTF-8");
            decoder = charset.newDecoder();
            //用这个的话，只能输出来一次结果，第二次显示为空
// charBuffer = decoder.decode(buffer);
            charBuffer = decoder.decode(buffer.asReadOnlyBuffer());
            return charBuffer.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "error";
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
