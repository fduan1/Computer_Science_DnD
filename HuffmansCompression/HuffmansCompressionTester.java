import java.io.IOException;

public class HuffmansCompressionTester {
    public static void main(String[] args) {
        try {
            String freq = HuffmansCompression.encode("text.txt").toString();
            System.out.println(freq);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
