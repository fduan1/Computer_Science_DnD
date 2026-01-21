public class MyBSTTester {
    public static void main(String[] args) {
        // MyBST<String> tree = new MyBST<String>();
        // tree.add("m");
        // tree.add("a");
        // tree.add("o");
        // tree.add("n");
        // tree.add("s");
        // tree.add("z");
        // tree.add("b");
        // tree.add("y");
        // tree.add("u");
        // tree.add("j");
        // System.err.println(tree.add("p"));
        // System.out.println(tree.add("n"));
        // System.out.println(tree.add("s"));
        // System.out.println(tree);

        // System.out.println(tree.remove("u"));

        // System.out.println(tree.remove("s"));

        // System.out.println(tree);
        // System.out.println(tree.remove("m"));
        // System.out.println(tree);

        MyBST<Integer> intTree = new MyBST<Integer>();
        // intTree.add(1);
        // System.out.println(intTree);
        // intTree.remove(1);
        // System.out.println(intTree);

        // intTree.add(1);
        // intTree.add(2);
        // intTree.add(3);
        // intTree.add(3);
        // intTree.add(4);
        // intTree.add(5);
        // System.out.println(intTree);
        // intTree.remove(1);
        // System.out.println(intTree);

        intTree = new MyBST<Integer>();
        intTree.add(1);
        intTree.add(4);
        intTree.add(3);
        intTree.add(2);
        System.out.println(intTree);
        intTree.remove(1);
        System.out.println(intTree);

        intTree = new MyBST<Integer>();
        intTree.add(1);
        intTree.add(5);
        intTree.add(3);
        intTree.add(4);
        System.out.println(intTree);
        intTree.remove(1);
        System.out.println(intTree);
        intTree.remove(intTree.min());
        System.out.println(intTree);
        intTree.remove(intTree.min());
        System.out.println(intTree);
        intTree.remove(intTree.min());
        System.out.println(intTree);

        
        System.out.println(intTree.max());
        System.out.println(intTree.min());


        // cases for remove
        // add 1, remove 1 (replacement none cause leaf)
        // add 1, 2, remove 1 (replacement is 2)
        // add 1, 3, 2, remove 1 (replacement 2)
        // add 1, 4, 3, .... 2, remove 1 (replacement 2)
        // add 1, 5, 3, 4, remove 1 (replacement 3, reorient 4 and 5)
    }

}
