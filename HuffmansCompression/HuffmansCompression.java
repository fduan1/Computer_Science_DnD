import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HuffmansCompression {


    public static void encode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        StringBuilder originalText = new StringBuilder();
        while (br.ready()) {
            char c = (char) br.read();
            originalText.append(c);
        }
        br.close();

        new ArrayList<>()
        
        for (int i = 0; i < originalText.length(); i++) {
            if (originalText[i])
        }


    }
}
