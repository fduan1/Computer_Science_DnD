import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanDecoder {
    // static HashMap<String, String> dictionary = new HashMap<>();

    public static void decode(String fileName) throws IOException {
        PrintWriter pw = new PrintWriter(fileName + ".dc");
        String s = "";
        String decoded = "";
        HashMap<String, String> dictionary = recreateDictionary(fileName);
        stringToBinary(fileName, dictionary);
        BufferedReader br = new BufferedReader(new FileReader(fileName + ".tmp"));

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

    public static HashMap<String, String> recreateDictionary(String fileName) throws IOException {
        HashMap<String, String> dictionary = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while (br.ready()) {
            String line = br.readLine();
            String[] key = line.split(", ");
            if (key.length == 1) {
                String code = br.readLine();
                if (code == null || code.equals("")) {
                    break;
                }
                code = code.substring(2);
                dictionary.put(code, "\n");
            } else if (key.length != 1) {
                dictionary.put(key[1], key[0]);
            }
        }
        br.close();
        return dictionary;
    }

    public static void stringToBinary(String fileName, HashMap<String, String> dictionary)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String chars = "";
        for (int i = 0; i < dictionary.size() + 2; i++) {
            br.readLine();
        }
        if (dictionary.containsValue("\n")) {
            br.readLine();
        }
        while (br.ready()) {
            String ch = Integer.toBinaryString(br.read());
            while (ch.length() != 8) {
                ch = "0" + ch;
            }
            chars += ch;
        }
        PrintWriter pw = new PrintWriter(fileName + ".tmp");
        pw.write(chars);
        br.close();
        pw.close();
    }

}
