import java.util.Arrays;
import java.util.HashMap;

public class DynamicProgramming {

    private static HashMap<scavKey, Integer> pathways = new HashMap<>();
    private static HashMap<cookieKey, Integer> cookies = new HashMap<>();
    private static HashMap<jobKey, Integer> payments = new HashMap<>();

    // Every day for the rest of the year, you're going to be given a choice between two jobs to do:
    // one that is LOW stress, and one that is HIGH stress. Each job pays out a dollar amount;
    // *usually* the high stress jobs pay more. However, after doing a high stress job, you need to
    // REST for a day.

    // Given a list of all the payouts for all the low stress and high stress jobs,
    // what is the most amount of money you can get?

    // You can assume lowPayouts.length == highPayouts.length
    public static int hiLoStress(int[] lowPayouts, int[] highPayouts) {
        return dayjobs(lowPayouts, highPayouts, 0);
    }

    public static int dayjobs(int[] lowPayouts, int[] highPayouts, int day) {
        jobKey high = new jobKey(day, highPayouts, lowPayouts, true);
        jobKey low = new jobKey(day, highPayouts, lowPayouts, false);
        if (payments.containsKey(high)) {
            return payments.get(high);
        }
        if (highPayouts.length - day == 1) {
            if (highPayouts[day] > lowPayouts[day]) {
                payments.put(high, highPayouts[day]);
                return payments.get(high);
            } else {
                payments.put(low, lowPayouts[day]);
                return payments.get(low);
            }
        }
        if (highPayouts.length - day == 0) {
            return 0;
        }
        if (!(day + 2 >= highPayouts.length)) {
            payments.put(high, highPayouts[day] + dayjobs(lowPayouts, highPayouts, day + 2));
        }
        payments.put(low, lowPayouts[day] + dayjobs(lowPayouts, highPayouts, day + 1));

        if (payments.get(high) > payments.get(low)) {
            return payments.get(high);
        } else {
            return payments.get(low);
        }
    }


    // You are partaking in a scavenger hunt!
    // You've gotten a secret map to find many of the more difficult
    // items, but they are only available at VERY specific times at
    // specific places. You have an array, times[], that lists at which
    // MINUTE an item is available, in increasing order.
    // Items in the ScavHunt are worth varying numbers of points.
    // You also have an array, points[], same length as times[],
    // that lists how many points each of the corresponding items is worth.
    // Problem is: to get from one location to the other takes 5 minutes,
    // so if there is an item, for example, available at time 23 and another
    // at time 27, it's just not possible for you to make it to both: you'll
    // have to choose!
    // Write a method that returns the maximum POINTS you can get.
    public static int scavHunt(int[] times, int[] points) {
        return findMaxPoints(times, points, 0);
    }

    public static int findMaxPoints(int[] times, int[] points, int index) {
         HashMap<scavKey, Integer> paths = pathways;
        if (index >= times.length) {
            return 0;
        }
        scavKey currentNode = new scavKey(index, points, times);
        if (pathways.containsKey(currentNode)) {
            return pathways.get(currentNode);
        }
        if (times.length - index == 1) {
            pathways.put(currentNode, points[index]);
            return pathways.get(currentNode);
        }

        int nextIndex = index + 5;
        for (int i = index; i < nextIndex; i++) {
            if (i >= times.length) {
                break;
            }
            if (times[i] >= times[index] + 5) {
                nextIndex = i;
            }
        }
        int chose = points[0] + findMaxPoints(times, points, nextIndex);
        scavKey nextNode = new scavKey(times[index + 1], points, times);
        int dont = findMaxPoints(times, points, index + 1);

        if (chose > dont) {
            pathways.put(currentNode, chose);
            return pathways.get(currentNode);
        } else {
            pathways.put(nextNode, dont);
            return pathways.get(nextNode);
        }

    }


    /*
     * Uses memoization to calculate the route which grants the most cookies, starting at [0][0],
     * only going right or down at each point
     */
    public static int dynamicCookies(int[][] cookieGrid) {
        return recursiveCookies(0, 0, cookieGrid, 0);
    }

    public static int recursiveCookies(int row, int col, int[][] cookieGrid, int numCookies) {
        // CODE THIS
        int numRows = cookieGrid.length;
        int numCols = cookieGrid[0].length;
        cookieKey currentPoint = new cookieKey(row * 10 + col, cookieGrid);
        if (!validPoint(row, col, numRows, numCols)) {
            return 0;
        }
        if (cookieGrid[row][col] == -1) {
            return numCookies;
        }
        if (row == numRows - 1 && col == numCols - 1) {
            cookies.put(currentPoint, numCookies + cookieGrid[row][col]);
            return numCookies + cookieGrid[row][col];
        }
        cookieKey downPoint = new cookieKey((row + 1) * 10 + col, cookieGrid);
        cookieKey rightPoint = new cookieKey(row * 10 + col + 1, cookieGrid);

        cookies.put(downPoint,
                recursiveCookies(row + 1, col, cookieGrid, numCookies + cookieGrid[row][col]));
        cookies.put(rightPoint,
                recursiveCookies(row, col + 1, cookieGrid, numCookies + cookieGrid[row][col]));

        if (cookies.get(downPoint) > cookies.get(rightPoint)) {
            return cookies.get(downPoint);
        } else {
            return cookies.get(rightPoint);
        }
    }

    private static boolean validPoint(int row, int col, int numRows, int numCols) {
        // Write this if you want
        if (row >= 0 && row < numRows && col >= 0 && col < numCols) {
            return true;
        }
        return false;
    }



}
