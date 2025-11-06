public class RecursionTester {
    public static void main(String[] args) {
        ListNode head = new ListNode("a", new ListNode("b", new ListNode("c", new ListNode("d", new ListNode("e")))));

        Recursion.printListInReverse(head);
        System.out.println();
        System.out.println();

        String[][] grid = {{"a", "b", "c", "d", "v"}, {"i", "v", "i", "i", "e"}, {"v", "b", "v", "v", "d"}, {"a", "b", "c", "d", "e"}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + ", ");
            }
            System.out.println();
        }
        Recursion.infect(grid, 2, 1);
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println(Recursion.countNonConsecutiveSubsets(5)); // 13
        System.out.println(Recursion.countWaysToJumpUpStairs(6)); // 24

        Recursion.printSubsets("abcd");

        Recursion.printPermutations("abcd");
        int[] list = {3, 1, 4, 6, -2, 0, 7};
        Recursion.mergeSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
        }
        System.out.println();

        Recursion.solveHanoi(5);
        System.out.println(Recursion.createHanoiSequence(5, 0, 2, 1).size());
    }
}
