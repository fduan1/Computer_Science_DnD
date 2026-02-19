
public class MyHashMap {

    public static int hashFunction(String str) {
        str = str.toLowerCase();
        if (str.contains(" ")) {
            String str1 = str.substring(str.indexOf(' '));
            str = str.substring(0, str.indexOf(' '));
            str = str + str1.trim();
        }
        int strValue = 0;
        for (int i = 0; i < str.length(); i++) {
            strValue += (int) (str.charAt(i) - 97) * i;
        }
        return strValue % 500;
    }



}
