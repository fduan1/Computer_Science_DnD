import java.io.IOException;
import java.util.ArrayList;

public class HuffmansCompressionTester {
    public static void main(String[] args) {
        try {
            ArrayList<BinaryNode<String>> freq = HuffmansCompression.createFrequencyList("text.txt");
            System.out.println(freq);
            System.out.println(HuffmansCompression.assignBinary(HuffmansCompression.createTree(freq)));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
