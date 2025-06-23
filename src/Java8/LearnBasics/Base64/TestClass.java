package Java8.LearnBasics.Base64;

import java.util.Base64;

//A new class Base64 is added that contains static methods
// for obtaining encoders and decoders for the Base64 encoding scheme.
public class TestClass {

    public static void main(String[] args) {
        //Encoding
        Base64.Encoder encoder =  Base64.getEncoder();
        String text ="Hi Naveen!!! How are you?";
        byte[] bytes =  text.getBytes();
        String encode = encoder.encodeToString(bytes);
        System.out.println(encode);

        //Decoding
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytess = decoder.decode(encode);
        String decode = new String(bytess);
        System.out.println(decode);


        // URL Encoding
        Base64.Encoder be = Base64.getUrlEncoder();
        byte[] url = "https://www.studytonight.com".getBytes();
        String encodeUrl = be.encodeToString(url);
        System.out.println(encodeUrl);
        // URL Decoding
        Base64.Decoder bd = Base64.getUrlDecoder();
        byte[] decodeUrl = bd.decode(encodeUrl);
        String dUrl = new String(decodeUrl);
        System.out.println(dUrl);
    }
}
