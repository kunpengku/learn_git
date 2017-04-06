package NIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by fupeng on 2017/4/6.
 */
public class TestChannel {
    public static void main(String[] args) throws IOException{
        File file = new File("data.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        FileChannel channel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String s = "java nio";

        buffer.put(s.getBytes());
        buffer.flip();

        channel.write(buffer);
        channel.close();

        outputStream.close();
    }
}
