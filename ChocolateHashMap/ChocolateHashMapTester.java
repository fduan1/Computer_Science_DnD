public class ChocolateHashMapTester {
    public static void main(String[] args) {
        ChocolateHashMap<String, String> map = new ChocolateHashMap<>();
        String value = "hello";
        String key = "HI-230";

        System.out.println(map.put(key, value));
        map.get(key);
        map.rehash(200);
        System.out.println(map.containsKey(key));
        System.out.println(map.containsValue(value));
        System.out.println(map.getBuckets());
        System.out.println(map.toString());

        map.remove(key);
        map.currentLoadFactor();

    }

}
