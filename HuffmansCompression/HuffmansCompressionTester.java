import java.io.IOException;
import java.util.ArrayList;

public class HuffmansCompressionTester {
    public static void main(String[] args) {
        try {
            // ArrayList<BinaryNode<String>> freq =
            // HuffmansCompression.createFrequencyList("text.txt");
            // System.out.println(freq);
            // System.out.println(HuffmansCompression.assignBinary(HuffmansCompression.createTree(freq)));
            // HuffmanEncoder.compress("text.txt");
            // HuffmanDecoder.decode("text.txt.hc");

            // HuffmanEncoder.compress("theiss.txt");
            // HuffmanDecoder.decode("theiss.txt.hc");

            // HuffmanEncoder.compress("ABCDEFG.txt");
            // HuffmanDecoder.decode("ABCDEFG.txt.hc");

            // HuffmanDecoder.decode("Harvard-Westlake Robotics FRC Team 1148 Sponsor Information
            // 25-26.txt.hc");

            // HuffmanEncoder.compress("gatsby.txt.hc");
            HuffmanDecoder.decode("gatsby.txt.hc");



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
