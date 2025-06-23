package InputOutputStreams;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStream {
    public static void main(String[] args) throws IOException {
        String data ="Amala";

        FileOutputStream fos = new FileOutputStream("C:/Learn/PlanA/src/InputOutputStreams/Output.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        bos.write(data.getBytes());
        bos.close();

    }
}
