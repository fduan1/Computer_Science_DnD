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
            Nucleotide[] values2 = {C, A, C, C};

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
            System.out.println();
            System.out.println(nodes);


            DoublyLinkedList newNodes = new DoublyLinkedList(values);
            DoublyLinkedList addedseg = new DoublyLinkedList(values);
            DoublyLinkedList addedseg2 = new DoublyLinkedList(values);
            System.out.println("\nnew nodes before:" + newNodes);
            newNodes.addSegmentToEnd(addedseg);
            newNodes.addSegmentToEnd(addedseg2);
            System.out.println("new nodes add seg x2:" + newNodes);
            ListNode2<Nucleotide> nodeBefore = newNodes.getHead();
            newNodes.removeCCCCCCCCGGGGGGGG(nodeBefore);
            System.out.println("new ndoes with remove 16:" + newNodes + "\n");
            System.out.println(nodes);
            DoublyLinkedList seg = new DoublyLinkedList(values2);
            System.out.println(seg);
            nodes.deleteSegment(seg);
            System.out.println(nodes);

            nodes.deleteLastThree();
            System.out.println(nodes);

            nodes.replaceEveryAWithTAC();
            System.out.println(nodes);

        }

    }

}
