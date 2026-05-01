import java.io.IOException;
import java.util.ArrayList;

public class HuffmansCompressionTester {
    public static void main(String[] args) {
        try {
            ArrayList<BinaryNode<String>> freq = HuffmansCompression.createFrequencyList("text.txt");
            System.out.println(freq);
            System.out.println(HuffmansCompression.assignBinary(HuffmansCompression.createTree(freq)));
            HuffmansCompression.compress("text.txt");
            System.out.println(HuffmansCompression.assignBinary(
                    HuffmansCompression.createTree(HuffmansCompression.createFrequencyList("theiss.txt"))));
            HuffmansCompression.compress("theiss.txt");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
