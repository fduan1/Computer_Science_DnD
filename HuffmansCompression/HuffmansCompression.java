import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class HuffmansCompression {


    public static HashMap<String, Integer> encode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        HashMap<String, Integer> frequencies = new HashMap<>();

        while (br.ready()) {
            String c = "" + (char) br.read();
            if (!frequencies.containsKey(c)) {
                frequencies.put(c, 1);
            } else {
                Integer oldFrequency = frequencies.get(c);
                frequencies.replace(c, oldFrequency + 1);
            }
        }
        
        
        

        br.close();
        return frequencies;
    }
}
