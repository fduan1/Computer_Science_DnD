public class LinkedListTester {
    public static void main(String[] args) {
        String[] values = {"a", "b", "c", "d"};
        SinglyLinkedList<String> nodes = new SinglyLinkedList<String>(values);
        nodes.add(1, "a");
        nodes.add("b");
        nodes.add("c");
        nodes.add("c");
        nodes.add("c");
        nodes.add("c");

        System.out.println(nodes.get(1));
        System.out.println(nodes);
        nodes.remove("a");
        nodes.set(6, "f");
        System.out.println(nodes);
        nodes.remove(0);
        System.out.println(nodes);
        nodes.add("h");
        nodes.add(4, "g");
        System.out.println(nodes);
        System.out.println(nodes.indexOf("h"));
        System.out.println(nodes.indexOf("e"));
        System.out.println(nodes.contains("g"));
        System.out.println(nodes.remove("g"));
        System.out.println(nodes);

    }

}
