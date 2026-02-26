/**
 * ChocolateHashMap<K,V>
 *
 * A custom hash map (separate chaining) built for a fictional chocolate factory
 * inventory system.
 * Each bucket is a circular DOUBLY-linked list with a sentinel BatchNode.
 *
 * You are responsible for implementing the methods marked TODO.
 */
public class ChocolateHashMap<K, V> {
    private BatchNode<ChocolateEntry<K, V>>[] buckets;
    private int objectCount;
    private double loadFactorLimit;

    // Constructor: creates a hash map with the given initial bucket size and load
    // factor limit
    @SuppressWarnings("unchecked")
    public ChocolateHashMap(int bucketCount, double loadFactorLimit) {
        this.buckets = (BatchNode<ChocolateEntry<K, V>>[]) new BatchNode[bucketCount];
        fillArrayWithSentinels(buckets);
        this.objectCount = 0;
        this.loadFactorLimit = loadFactorLimit;
    }

    // Constructor: creates an empty hash map with default parameters
    public ChocolateHashMap() {
        this(10, 0.75);
    }

    private static void fillArrayWithSentinels(BatchNode[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new BatchNode();
        }
    }

    // Return a pointer to the bucket array
    public BatchNode<ChocolateEntry<K, V>>[] getBuckets() {
        return this.buckets;
    }

    // Returns true if this map is empty; otherwise returns false.
    public boolean isEmpty() {
        return (objectCount == 0);
    }

    // Returns the number of entries in this map.
    public int size() {
        return objectCount;
    }

    // Return the bucket index for the key
    // Use .hashCode(), but be aware that hashCode can return negative numbers!
    // NOTE: Math.abs(Integer.MIN_VALUE) is still negative. Consider masking the
    // sign bit.
    private int whichBucket(K key) {
        // TODO: implement
        return (int) (Math.abs(key.hashCode() % buckets.length));
    }

    // Returns the current load factor (objCount / buckets)
    public double currentLoadFactor() {
        return (double) size() / buckets.length;
    }

    // Return true if the key exists as a key in the map, otherwise false.
    // Use the .equals method to check equality.
    public boolean containsKey(K key) {
        // TODO: implement
        if (buckets[whichBucket(key)].getNext().isSentinel()) {
            return false;
        }
        BatchNode<ChocolateEntry<K, V>> bucket = buckets[whichBucket(key)];
        for (BatchNode<ChocolateEntry<K, V>> i = bucket.getNext(); i != bucket; i = i.getNext()) {
            if (i.getEntry().getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    // Return true if the value exists as a value in the map, otherwise false.
    // Use the .equals method to check equality.
    public boolean containsValue(V value) {
        // TODO: implement
        for (int i = 0; i < buckets.length; i++) {
            for (BatchNode<ChocolateEntry<K, V>> j = buckets[i].getNext(); j != buckets[i]; j = j.getNext()) {
                if (j.getEntry().getValue() == value || j.getEntry().getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Puts a key-value pair into the map.
    // If the key already exists in the map you should *not* add the key-value pair.
    // Return true if the pair was added; false if the key already exists.
    // If a pair should be added, add it to the END of the bucket.
    // After adding the pair, check if the load factor is greater than the limit.
    // - If so, you must call rehash with double the current bucket size.
    public boolean put(K key, V value) {
        // TODO: implement
        if (containsKey(key)) {
            return false;
        }
        BatchNode<ChocolateEntry<K, V>> newBatch = new BatchNode<ChocolateEntry<K, V>>(
                new ChocolateEntry<>(key, value));
        int bucket = whichBucket(key);
        buckets[whichBucket(key)].insertBefore(newBatch);
        objectCount++;
        if (currentLoadFactor() > loadFactorLimit) {
            rehash(buckets.length * 2);
        }
        return true;
    }

    // Returns the value associated with the key in the map.
    // If the key is not in the map, then return null.
    public V get(K key) {
        // TODO: implement
        if (!containsKey(key)) {
            return null;
        }
        for (BatchNode<ChocolateEntry<K, V>> j = buckets[whichBucket(key)].getNext(); j != buckets[whichBucket(
                key)]; j = j
                        .getNext()) {
            if (j.getEntry().getKey().equals(key)) {
                return j.getEntry().getValue();
            }
        }
        return null;

    }

    // Remove the pair associated with the key.
    // Return true if successful, false if the key did not exist.
    public boolean remove(K key) {
        // TODO: implement
        if (!containsKey(key)) {
            return false;
        }
        for (BatchNode<ChocolateEntry<K, V>> j = buckets[whichBucket(key)].getNext(); j != buckets[whichBucket(
                key)]; j = j
                        .getNext()) {
            if (j.getEntry().getKey().equals(key)) {
                j.unlink();
                objectCount--;
                return true;
            }
        }
        return false;
    }

    // Rehash the map so that it contains the given number of buckets
    // Loop through all existing buckets, from 0 to length
    // Rehash each object into the new bucket array in the order they appear on the
    // original chain.
    // I.e. if a bucket originally has (sentinel)->J->Z->K, then J will be rehashed
    // first,
    // followed by Z, then K.
    @SuppressWarnings("unchecked")
    public void rehash(int newBucketCount) {
        // TODO: implement
        BatchNode<ChocolateEntry<K, V>>[] oldBuckets = buckets;
        buckets = (BatchNode<ChocolateEntry<K, V>>[]) new BatchNode[newBucketCount];
        fillArrayWithSentinels(buckets);
        for (int i = 0; i < oldBuckets.length; i++) {
            if (!oldBuckets[i].getNext().equals(oldBuckets[i])) {
                BatchNode<ChocolateEntry<K, V>> bucket = oldBuckets[i];
                for (BatchNode<ChocolateEntry<K, V>> j = bucket.getNext(); j != bucket; j = j.getNext()) {
                    BatchNode<ChocolateEntry<K, V>> copy = new BatchNode<>(j.getEntry());
                    buckets[whichBucket(j.getEntry().getKey())].insertBefore(copy);
                }
            }
        }
    }

    // The output should be in the following format:
    // [ n, k | { b#: k1,v1 k2,v2 k3,v3 } { b#: k1,v1 k2,v2 } ]
    // n is the objCount
    // k is the number of buckets
    // For each bucket that contains objects, create a substring that indicates the
    // bucket index
    // And list all of the items in the bucket (in the order they appear)
    // Example (using chocolate-themed data):
    // [ 3, 10 | { b3: LOT-70,DARK LOT-12,MILK } { b7: LOT-99,WHITE } ]
    @Override
    public String toString() {
        // TODO: implement
        String str = "[ " + objectCount + ", " + buckets.length + " | ";
        for (int i = 0; i < buckets.length; i++) {
            if (!buckets[i].getNext().equals(buckets[i])) {
                str += " { b" + i + ": ";
                for (BatchNode<ChocolateEntry<K, V>> j = buckets[i].getNext(); j != buckets[i]; j = j.getNext()) {
                    str += "" + j.getEntry() + ",";
                    str = str.substring(0, str.length() - 1);
                    str += " ";
                }
                str += "}";
            }
        }
        return str + "]";
    }
}
