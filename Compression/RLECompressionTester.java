import java.io.IOException;

public class RLECompressionTester {
    public static void main(String[] args) {
        RLECompression newFile = new RLECompression();
        try {
            RLECompression.encode("generic.txt");
            RLECompression.decode("decodethis.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
