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


        // cases for remove
        // add 1, remove 1 (replacement none cause leaf)
        // add 1, 2, remove 1 (replacement is 2)
        // add 1, 3, 2, remove 1 (replacement 2)
        // add 1, 4, 3, .... 2, remove 1 (replacement 2)
        // add a, 5, 3, 4, remove 1 (replacement 3, reorient 4 and 5)
    }

}
