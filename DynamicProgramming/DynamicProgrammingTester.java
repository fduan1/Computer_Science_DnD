public class DynamicProgrammingTester {
    public static void main(String[] args) {

        int[] sites = {5, 9, 11, 12, 14, 16, 17, 20, 24, 25, 29, 30, 33, 34, 39, 41, 45, 46, 47, 50,
                57, 59, 61, 64, 65, 71, 74, 75, 76, 77, 79, 82, 85, 86, 88, 90, 92, 93, 98, 100};
        int[] revenues = {8, 2, 8, 8, 9, 1, 5, 6, 5, 8, 4, 7, 8, 3, 1, 7, 8, 8, 4, 2, 8, 9, 2, 1, 4,
                5, 6, 1, 3, 6, 6, 6, 10, 2, 3, 10, 4, 3, 2, 9};
        System.out.println(DynamicProgramming.scavHunt(sites, revenues));


    }
}
