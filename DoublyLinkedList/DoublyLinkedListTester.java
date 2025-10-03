import java.util.concurrent.atomic.DoubleAccumulator;

public class DoublyLinkedListTester {
    public class LinkedListTester {
        public static void main(String[] args) {
            Nucleotide[] values = {Nucleotide.C, Nucleotide.G, Nucleotide.A, Nucleotide.A,
                    Nucleotide.G, Nucleotide.T, Nucleotide.C};
            DoublyLinkedList nodes = new DoublyLinkedList(values);
            Nucleotide A = Nucleotide.A;
            Nucleotide G = Nucleotide.G;
            Nucleotide C = Nucleotide.C;
            Nucleotide T = Nucleotide.T;

            System.out.println(nodes);
            System.out.println(nodes.get(1));
            nodes.add(1, A);
            System.out.println(nodes);
            nodes.add(G);
            nodes.add(C);
            nodes.add(C);
            nodes.add(C);
            nodes.add(T);
            System.out.println(nodes);
            nodes.remove(T);
            nodes.remove(0);
            nodes.set(6, A);
            System.out.println(nodes);
            nodes.add(T);
            nodes.add(4, T);
            System.out.println(nodes);
            DoublyLinkedList newNodes = new DoublyLinkedList(values);
            nodes.addSegmentToEnd(newNodes);
            System.out.println(nodes);
            ListNode2<Nucleotide> nodeBefore = nodes.getHead();
            nodes.removeCCCCCCCCGGGGGGGG(nodeBefore);
            System.out.println(nodes);

        }

    }

}
