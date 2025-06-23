package InputOutputStreams;

import com.sun.tools.javac.Main;

import java.io.*;

public class InputOutputStream {

    public static void main(String[] args) {
        InputStream is = null;

        {
            try {
                is = new FileInputStream("C:/Learn/PlanA/src/InputOutputStreams/Input.txt");
                int x;
                while((x = is.read()) != -1) {
                    System.out.print((char) x);
                }
            is.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        try {
            OutputStream os = new FileOutputStream("C:/Learn/PlanA/src/InputOutputStreams/Output.txt");
            String data = "Hi Naveen!!! Output Stream";
            os.write(data.getBytes());
            os.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
