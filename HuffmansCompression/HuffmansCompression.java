import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class HuffmansCompression {

    public static void compress(String fileName) throws IOException {
        createDictionary(fileName + "Dictionary" + ".txt", assignBinary(createTree(createFrequencyList(fileName))));
    }

    public static ArrayList<BinaryNode<String>> createFrequencyList(String fileName) throws IOException {
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
        ArrayList<String> keys = new ArrayList<>(frequencies.keySet());
        ArrayList<BinaryNode<String>> sortedFrequencies = new ArrayList<>();
        for (String key : keys) {
            sortedAdd(sortedFrequencies, new BinaryNode<String>(key, frequencies.get(key)));
        }
        sortedAdd(sortedFrequencies, new BinaryNode<String>("EOF", 1));

        br.close();
        return sortedFrequencies;
    }

    public static BinaryNode<String> createTree(ArrayList<BinaryNode<String>> freqList) {
        for (int i = 0; i < freqList.size() - 1; i++) {
            if (!freqList.get(i).hasParent()) {
                int newFreq = freqList.get(i).getFrequency() + freqList.get(i + 1).getFrequency();
                BinaryNode<String> newNode = new BinaryNode<String>(null, newFreq);
                newNode.setLeft(freqList.remove(i));
                newNode.setRight(freqList.remove(i));
                newNode.getLeft().setParent(newNode);
                newNode.getRight().setParent(newNode);
                sortedAdd(freqList, newNode);
                i--;
            }

        }
        return freqList.getLast();
    }

    public static String assignBinary(BinaryNode<String> node) {
        String definition = "";
        if (node.hasParent()) {
            definition = "" + node.getParent().getBinary();
        }
        if (node.isLeft()) {
            definition += "0";
        } else if (node.isRight()) {
            definition += "1";
        }
        node.setBinary(definition);

        if (node.isLeaf()) {
            return node.getValue() + ", " + node.getBinary() + "\n";
        }
        return assignBinary(node.getLeft()) + assignBinary(node.getRight());
    }

    public static void createDictionary(String fileName, String str) throws IOException {
        PrintWriter pw = new PrintWriter(fileName + ".bw");
        pw.write(str);
        pw.close();
    }

    public static void sortedAdd(ArrayList<BinaryNode<String>> list, BinaryNode<String> obj) {
        if (list.size() == 0) {
            list.add(0, obj);
        } else if (obj.getFrequency() < list.get(0).getFrequency()) {
            list.add(0, obj);
        } else if (obj.getFrequency() > list.get(list.size() - 1).getFrequency()) {
            list.add(list.size(), obj);
        } else {
            list.add(binarySearch(list, obj, 0, list.size() - 1), obj);
        }
    }

    public static int binarySearch(ArrayList<BinaryNode<String>> list, BinaryNode<String> obj, int low,
            int high) {
        if (high >= low) {
            int mid = (high + low) / 2;
            if ((high + low) % 2 == 1) {
                mid++;
            }
            if (high - low <= 2) {
                return high;
            }
            if (obj.getFrequency() < list.get(mid).getFrequency()) {
                return binarySearch(list, obj, low, mid - 1);
            }
            if (obj.getFrequency() > list.get(mid).getFrequency()) {
                return binarySearch(list, obj, mid + 1, high);
            }
        }
        return -1;
    }
}
