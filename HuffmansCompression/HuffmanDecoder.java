import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanDecoder {
    static HashMap<String, String> dictionary = new HashMap<>();

    public static void decode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(fileName + ".dty");
        String s = "";
        String decoded = "";
        while (br.ready()) {
            s += "" + (char) br.read();
            if (dictionary.containsKey(s)) {
                if (!dictionary.get(s).equals("EOF")) {
                    decoded += dictionary.get(s);
                    s = "";
                } else {
                    br.close();
                }
            }
        }

        pw.write(decoded);

        pw.close();
    }

    public static void recreateDictionary(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String c = "";
        String nx = "";
        int index = 0;
        while (br.ready()) {
            c = "" + (char) br.read();
            index++;
            nx = "" + (char) br.read();
            index++;
            if ((c + nx).equals(", ")) {
                String line = br.readLine();
                dictionary.put(line.substring(index), line.substring(index - 2)) ;
            }
        }

        br.close();
    }
}
