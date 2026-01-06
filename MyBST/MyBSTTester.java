public class MyBSTTester {
    public static void main(String[] args) {
        MyBST<String> tree = new MyBST<String>();
        tree.add("maple");
        tree.add("apple");
        tree.add("oak");
        tree.add("sap");
        tree.add("zebra");
        tree.add("birch");

        System.out.println(tree);
    }

}
