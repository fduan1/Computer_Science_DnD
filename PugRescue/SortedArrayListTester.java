public class SortedArrayListTester {

    public static void main(String[] args) {
        MyArrayList<String> arr = new SortedArrayList<String>();
        arr.add("apple");
        arr.add("aardvark");
        arr.add("axe");
        arr.add("green");
        arr.add("zebra");
        arr.add("mouse");
        arr.add("cat");
        arr.add("smile");
        arr.add("bowl");
        System.out.println(arr);
        System.out.println(arr.contains("aardvark") + "," + arr.contains("axelotl"));
        System.out.println(arr.remove("smile") + "," + arr.remove("axelotl"));
        System.out.println(arr);
    }

}
