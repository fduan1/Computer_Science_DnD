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


    public static ArrayList<ListNode<String>> encode(String fileName) throws IOException {
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
        ArrayList<ListNode<String>> sortedFrequencies = new ArrayList<>();
        for (String key : keys) {
            sortedAdd(sortedFrequencies, new ListNode<String>(key, frequencies.get(key)));
        }



        br.close();
        return sortedFrequencies;
    }

    public static void sortedAdd(ArrayList<ListNode<String>> list, ListNode<String> obj) {
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

    public static int binarySearch(ArrayList<ListNode<String>> list, ListNode<String> obj, int low,
            int high) {
        if (high >= low) {
            int mid = (high + low) / 2;
            if (high - low <= 2) {
                return mid;
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
