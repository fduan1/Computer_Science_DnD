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
        stringToBinary(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(fileName + ".dc");
        String s = "";
        String decoded = "";
        recreateDictionary(fileName.substring(0, fileName.length() - 3) + ".dty");
        HashMap<String, String> d = dictionary;
        while (br.ready()) {
            s += "" + (char) br.read();
            if (dictionary.containsKey(s)) {
                if (!dictionary.get(s).equals("EOF")) {
                    decoded += dictionary.get(s);
                    s = "";
                } else {
                    break;
                }
            }
        }

        pw.write(decoded);
        br.close();
        pw.close();
    }

    public static void recreateDictionary(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (br.ready()) {
            String line = br.readLine();
            String[] key = line.split(", ");
            if (key.length != 1) {
                dictionary.put(key[1], key[0]);
            } else {
                String code =br.readLine().substring(2);
                dictionary.put(code, "\n");
            }
        }
        br.close();
    }

    public static void stringToBinary(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String chars = "";
        while (br.ready()) {
            String ch = Integer.toBinaryString(br.read());
            while (ch.length() != 8) {
                ch = "0" + ch;
            }
            chars += ch;
        }
        PrintWriter pw = new PrintWriter(fileName);
        pw.write(chars);
        br.close();
        pw.close();
    }

}
