package InputOutputStreams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArray {
    public static void main(String[] args) {
        String data = "Hi Adhavan!!!My Son";
        ByteArrayInputStream bis = new ByteArrayInputStream(data.getBytes());
        int x;
        while((x = bis.read()) != -1) {
            System.out.print((char) x);
        }
        try {
            bis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        byte[] arr = {1,2,3,4};
        String h = "Adithiyan";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            bos.write(h.getBytes());
            System.out.println(bos.toString());
            byte[] arr1 = bos.toByteArray();
            System.out.println("size " + bos.size());
            for (byte b : arr1) {
                System.out.print((char) b);
            }
            bos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
