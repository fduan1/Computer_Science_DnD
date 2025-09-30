import java.util.concurrent.atomic.DoubleAccumulator;

public class DoublyLinkedListTester {
public class LinkedListTester {
    public static void main(String[] args) {
        Nucleotide[] values = {Nucleotide.C, Nucleotide.G, Nucleotide.A, Nucleotide.A, Nucleotide.G, Nucleotide.T, Nucleotide.C};
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
        nodes.remove(A);
        nodes.remove(0);
        nodes.set(6, G);
        System.out.println(nodes);
        nodes.add(T);
        nodes.add(4, T);
        System.out.println(nodes);
        nodes.remove(C);
        System.out.println(nodes);
        System.out.println(nodes);

    }

}

}
