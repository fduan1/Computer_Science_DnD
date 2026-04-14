import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RLECompression {

    // Creates a compressed version with fileName + ".rle.bw"
    public static void compress(String fileName) throws IOException {
        bwTransform(fileName);
        encode(fileName + ".bw");
    }

    // Decompresses a .rle.bw file
    public static void decompress(String fileName) throws IOException {
        decode(fileName);
        invertBWTransform(fileName.substring(0, fileName.length() - 4));
    }

    // Encodes the contents of a file using the RLE compression scheme:
    // single characters are left alone, and runs of 2+ characters are encoded as
    // that letter twice, followed by the length of the run, cast as a char
    public static void encode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(fileName + ".rle");

        char previousChar = (char) br.read();
        int count = 1;

        while (br.ready()) {
            char c = (char) br.read();
            // TO-DO:
            // Now here: do things with the char you just read, dependent on the char you
            // just read
            if (c == previousChar) {
                count++;
            } else {
                if (count > 1) {
                    pw.write("" + previousChar + previousChar + count);
                } else {
                    pw.write("" + previousChar);
                }
                count = 1;
            }
            previousChar = c;
        }
        if (count > 1) {
            pw.write("" + previousChar + previousChar + count);
        } else {
            pw.write("" + previousChar);
        }

        br.close();
        pw.close();
    }

    // Decodes the above scheme
    public static void decode(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        PrintWriter pw = new PrintWriter(fileName.substring(0, fileName.length() - 4));

        char previousChar = (char) br.read();

        while (br.ready()) {
            char c = (char) br.read();
            // TO-DO:
            // Now here: do things with the char you just read, dependent on the char you
            // just read
            if (!(c >= '0' && c <= '9')) {
                if (c == previousChar) {
                    int count = (char) br.read() - '0';
                    for (int i = 0; i < count; i++) {
                        pw.write("" + c);
                    }
                    previousChar = (char) br.read();
                } else {
                    pw.write(previousChar);
                    previousChar = c;
                }
            }
        }
        pw.write(previousChar);

        br.close();
        pw.close();
    }

    public static void bwTransform(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        // Add a null character at the beginning, as a
        // "beginning of file" character
        StringBuilder originalText = new StringBuilder("" + '\0');

        while (br.ready()) {
            char c = (char) br.read();
            originalText.append(c);
        }
        br.close();

        String[] rotations = new String[originalText.length()];
        String encodedText = "";
        // TO-DO:
        // Now do the Burrows-Wheeler Transform
        for (int i = 1; i < originalText.length() + 1; i++) {
            rotations[i - 1] = new String(originalText.substring(i) + '\0' + originalText.substring(0, i));
        }
        rotations = alphabetize(rotations);
        for (int i = 0; i < originalText.length(); i++) {
            encodedText += "" + rotations[i].charAt(originalText.length());
        }
        // And then write the transformation into a file
        PrintWriter pw = new PrintWriter(fileName + ".bw");
        pw.write(encodedText);
        pw.close();
    }

    public static String[] alphabetize(String[] original) {
        ArrayList<String> alphabetized = new ArrayList<>();
        for (String str : original) {
            alphabetized.add(str);
        }
        alphabetized.sort(String::compareTo);
        String[] sorted = new String[original.length];
        sorted = alphabetized.toArray(sorted);
        return sorted;
    }

    public static void invertBWTransform(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        StringBuilder originalText = new StringBuilder();

        while (br.ready()) {
            char c = (char) br.read();
            originalText.append(c);
        }
        br.close();

        String[] reconstructions = new String[originalText.length()];
        for (int i = 0; i < reconstructions.length; i++) {
            reconstructions[i] = "" + originalText.charAt(i);
        }
        // TO-DO
        // Now undo the Burrows-Wheeler transform
        for (int i = 0; i < originalText.length()-1; i++) {
            reconstructions = alphabetize(reconstructions);
            for (int j = 0; j < reconstructions.length; j++) {
                reconstructions[j] = originalText.charAt(j) + reconstructions[j].toString();
            }
        }

        String decodedText = reconstructions[originalText.length()-1];
        // TO-DO
        // And write the appropriate reconstruction into the file, without the null char
        PrintWriter pw = new PrintWriter(fileName.substring(0, fileName.length() - 3));
        pw.write(decodedText.toString());
        pw.close();
    }
}
