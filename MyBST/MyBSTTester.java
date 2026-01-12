public class MyBSTTester {
    public static void main(String[] args) {
        MyBST<String> tree = new MyBST<String>();
        tree.add("m");
        tree.add("a");
        tree.add("o");
        tree.add("n");
        tree.add("s");
        tree.add("z");
        tree.add("b");
        tree.add("y");
        tree.add("u");
        tree.add("j");
        System.err.println(tree.add("p"));
        System.out.println(tree.add("n"));
        System.out.println(tree.add("s"));
        System.out.println(tree);

        System.out.println(tree.remove("u"));

        System.out.println(tree.remove("s"));

        System.out.println(tree);
        System.out.println(tree.remove("m"));
        System.out.println(tree);

    }

}
