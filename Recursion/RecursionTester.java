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
    }
}
