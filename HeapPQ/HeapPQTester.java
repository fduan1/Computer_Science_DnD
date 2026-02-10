public class HeapPQTester {
    public static void main(String[] args) {
        HeapPQ heap = new HeapPQ<>();
        heap.add(24);
        heap.add(25);
        heap.add(9);
        heap.add(1);
        heap.add(6);
        heap.add(5);
        heap.add(4);
        heap.add(3);
        heap.add(2);
        heap.add(20);
        for (int i = 0; i < heap.size(); i++) {
            System.out.println(heap);
        }
        heap.removeMin();
        for (int i = 0; i < heap.size(); i++) {
            System.out.println(heap);
        }
    }

}
