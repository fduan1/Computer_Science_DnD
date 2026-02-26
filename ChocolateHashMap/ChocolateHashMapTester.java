public class ChocolateHashMapTester {

    static class KeyWithHash {
        private final String label;
        private final int forcedHash;

        KeyWithHash(String label, int forcedHash) {
            this.label = label;
            this.forcedHash = forcedHash;
        }

        @Override
        public int hashCode() {
            return forcedHash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof KeyWithHash))
                return false;
            KeyWithHash other = (KeyWithHash) o;
            return this.label.equals(other.label);
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public static void main(String[] args) {
        ChocolateHashMap<KeyWithHash, String> map1 = new ChocolateHashMap<>();
        ChocolateHashMap<String, String> map = new ChocolateHashMap<>();

        String value = "hello";
        String key = "HI-230";

        KeyWithHash a = new KeyWithHash("A", 3); // b3
        KeyWithHash b = new KeyWithHash("B", 13); // b3 (collision)
        KeyWithHash c = new KeyWithHash("C", 7); // b7

        map1.put(a, "Milk");
        map1.put(b, "Dark");
        map1.put(c, "White");

        String s = map.toString();
        System.out.println(s);
        System.out.println(map.put(key, value));
        map.get(key);
        System.out.println(map.containsKey(key));
        System.out.println(map.containsValue(value));
        System.out.println(map.getBuckets());
        System.out.println(map.toString());
        map.rehash(200);

        map.remove(key);
        map.currentLoadFactor();

    }

}
