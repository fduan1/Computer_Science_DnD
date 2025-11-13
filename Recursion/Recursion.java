import java.lang.reflect.Array;
import java.util.ArrayList;

public class Recursion {

	// Prints the value of every node in the singly linked list with the given head,
	// but in reverse
	public static void printListInReverse(ListNode head) {
		if (head.getNext() == null) {
			System.out.print(head.getValue());
		} else {
			printListInReverse(head.getNext());
			System.out.print(head.getValue());
		}
	}

	// For the given 2D array of Strings, replaces the String at index[r][c]
	// with "infected" unless the String is "vaccinated";
	// also, any Strings they are orthogonally adjacent to
	// that are not "vaccinated" will also be infected, and any adjacent to
	// them as well etc.
	// Infecting someone who is already infected has no effect
	// Trying to infect outside the confines of the grid also has no effect
	// Precondition: grid has no null entries
	public static void infect(String[][] grid, int r, int c) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
			;
		} else if (!grid[r][c].equals("v") && !grid[r][c].equals("i")) {
			grid[r][c] = "i";
			infect(grid, r + 1, c);
			infect(grid, r - 1, c);
			infect(grid, r, c + 1);
			infect(grid, r, c - 1);
		}
	}

	// How many subsets are there of the numbers 1...n
	// that don't contain any consecutive integers?
	// e.g. for n = 4, the subsets are {}, {1}, {2}, {3}, {4},
	// {1, 3}, {1, 4}, {2, 4}
	// The other subsets of 1,2,3,4 that DO contain consecutive integers are
	// {1,2}, {2,3}, {3,4}, {1,2,3}, {1,2,4}, {1,3,4}, {1,2,3,4}
	// n=6: {}, {1}, {2}, {3}, {4}, {5}, {6}, {1, 3}, {1, 4}, {1,5}, {1,6}, {2, 4},
	// {2,5}, {2,6},
	// {3,5}, {3,6}, {4,6}, {1,3,5}, {1,4,6}, {2,4,6}
	// 2 to 5 to 8 to 13 to 20
	// Precondition: n > 0
	public static long countNonConsecutiveSubsets(int n) {
		if (n <= 1) {
			return n + 1; // one for itself and one for empty
		}
		return countNonConsecutiveSubsets(n - 1) + countNonConsecutiveSubsets(n - 2);
	}

	// A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
	// How many different ways can they jump up n stairs?
	// Jumping 1-1-2 is considered different than jumping 1-2-1
	// n = 2: 1-1; 2
	// n = 3: 1-1-1; 1-2; 2-1; 3
	// n =
	// Precondition: n > 0
	public static long countWaysToJumpUpStairs(int n) {
		if (n <= 2) {
			return n;
		}
		if (n == 3) {
			return 4;
		}
		return countWaysToJumpUpStairs(n - 1) + countWaysToJumpUpStairs(n - 2)
				+ countWaysToJumpUpStairs(n - 3);
	}

	// // Everything above this line does NOT require a recursive helper method
	// // ----------------------------------
	// // Everything below this line requires a recursive helper method
	// // Any recursive helper method you write MUST have a comment describing:
	// // 1) what the helper method does/returns
	// // 2) your description must include role of each parameter in the helper
	// method

	// Prints all the subsets of str on separate lines
	// You may assume that str has no repeated characters
	// For example, subsets("abc") would print out "", "a", "b", "c", "ab", "ac",
	// "bc", "abc"
	// Order is your choice
	public static void printSubsets(String str) {
		System.out.println(makeSubsetList(str));
	}

	// returns a list of all subsets
	// n is the length of the string entered,subsets is the return and starts as an
	// exact copy of the earlier shorter version, new sets is the new sets added to
	// the total from the additional char (last)
	public static ArrayList<String> makeSubsetList(String str) {
		int n = str.length();
		ArrayList<String> subsets = new ArrayList<>();
		if (n <= 1) {
			subsets.add("");
			subsets.add(str);
			return subsets;
		}
		char last = str.charAt(n - 1);
		subsets = makeSubsetList(str.substring(0, n - 1));
		ArrayList<String> newSets = makeSubsetList(str.substring(0, n - 1));
		for (int i = 0; i < newSets.size(); i++) {
			subsets.set(i, newSets.get(i) + last);
		}
		subsets.addAll(newSets);
		return subsets;
	}

	// List contains a single String to start.
	// Prints all the permutations of str on separate lines
	// You may assume that str has no repeated characters
	// For example, permute("abc") could print out "abc", "acb", "bac", "bca",
	// "cab", "cba"
	// Order is your choice
	public static void printPermutations(String str) {
		System.out.println(makePermutationsList(str).toString());
	}

	// same as n-1, but add last char at every index
	// length is length of smaller list of permutations * str
	// for str length, add old permutations with c at index 0 up to n
	// um idk how to do that efficiently so.......
	public static ArrayList<String> makePermutationsList(String str) {
		int n = str.length();
		ArrayList<String> permutations = new ArrayList<>();
		if (n <= 1) {
			permutations.add(str);
			return permutations;
		}
		char last = str.charAt(n - 1);
		ArrayList<String> oldPermutations = makePermutationsList(str.substring(0, n - 1));
		for (int j = 0; j < oldPermutations.size(); j++) {
			for (int i = 0; i < n; i++) {
				String newPermutationFront = oldPermutations.get(j).substring(0, i);
				String newPermutationBack = oldPermutations.get(j).substring(i);
				permutations.add(newPermutationFront + last + newPermutationBack);
			}
		}
		return permutations;
	}

	// Performs a mergeSort on the given array of ints
	// Precondition: you may assume there are NO duplicates!!!
	public static void mergeSort(int[] ints) {
		int[] sorted = sort(ints);
		for (int i = 0; i < ints.length; i++) {
			ints[i] = sorted[i];
		}
	}

	// this splits up an int array in 2 and uses merge() to recombine into sorteds
	public static int[] sort(int[] ints) {
		if (ints.length <= 1) {
			return ints;
		}
		int[] first = new int[ints.length / 2];
		if (ints.length % 2 == 1) {
			first = new int[ints.length / 2 + 1];
		}
		int[] second = new int[ints.length / 2];
		for (int i = 0; i < first.length; i++) {
			first[i] = ints[i];
			if (i != second.length) {
				second[i] = ints[first.length + i];
			}
		}
		return merge(sort(first), sort(second));
	}

	// this merges 2 seperate sorted arrays into a single, larger, sorted array
	// not recursion
	public static int[] merge(int[] first, int[] second) {
		int[] mergedList = new int[first.length + second.length];
		int j = 0;
		int listPosition = 0;
		for (int i = 0; i < first.length; listPosition++) {
			if (first[i] < second[j]) {
				mergedList[listPosition] = first[i];
				j--;
			} else {
				mergedList[listPosition] = second[j];
				i--;
			}
			j++;
			i++;
			if (j >= second.length) {
				for (int n = 1; n <= first.length - i; n++) {
					mergedList[mergedList.length - n] = first[first.length - n];
				}
				break;
			} else if (i >= first.length) {
				for (int n = 1; n <= second.length - j; n++) {
					mergedList[mergedList.length - n] = second[second.length - n];
				}
				break;
			}
		}
		return mergedList;
	}

	// Performs a quickSort on the given array of ints
	// Use the middle element (index n/2) as the pivot
	// Precondition: you may assume there are NO duplicates!!!
	public static void quickSort(int[] ints) {
		int[] sorted = quickSort(ints.length / 2, ints);
	}

	public static ArrayList<Integer> quickSort(int pivotLocation, int[] ints) {
		int pivot = ints[pivotLocation];
		// base cases
		if (ints.length <= 1) {
			return new ArrayList<Integer>().addAll(ints);
		}
		// split
		ArrayList<Integer> firstInts = new ArrayList<>();
		ArrayList<Integer> secondInts = new ArrayList<>();
		for (int i = 0; i < ints.length; i++) {
			if (ints[i] < pivot) {
				firstInts.add(ints[i]);
			}
			if (ints[i] > pivot) {
				secondInts.add(ints[i]);
			}
		}
		return combineWithPivot(pivot, quickSort(first.size() / 2, first), second);
	}

	public static ArrayList<Integer> combineWithPivot(int pivot, ArrayList<Integer> first,
			ArrayList<Integer> second) {
		ArrayList<Integer> mergedList = new ArrayList<>();
		mergedList.addAll(first);
		mergedList.add(pivot);
		mergedList.addAll(second);
		return mergedList;
	}



	// Prints a sequence of moves (one on each line)
	// to complete a Towers of Hanoi problem:
	// disks start on tower 0 and must end on tower 2.
	// The towers are number 0, 1, 2, and each move should be of
	// the form "1 -> 2", meaning "take the top disk of tower 1 and
	// put it on tower 2" etc.
	// solve one smaller to middle, move bottom to target, solve one smaller again to target
	public static void solveHanoi(int startingDisks) {
		System.out.println(createHanoiSequence(startingDisks, 0, 2, 1));
	}

	// creates an arraylist of the hanoir sequence with tower inputs of start, target, free
	public static ArrayList<String> createHanoiSequence(int startingDisks, int starter, int target,
			int free) {
		ArrayList<String> moves = new ArrayList<>();
		if (startingDisks == 1) {
			moves.add("" + starter + "->" + target);
			return moves;
		}
		if (startingDisks == 2) {
			moves.add(starter + "->" + free);
			moves.add(starter + "->" + target);
			moves.add(free + "->" + target);
			return moves;
		}
		moves.addAll(createHanoiSequence(startingDisks - 1, starter, free, target));
		moves.add(starter + "->" + target);
		moves.addAll(createHanoiSequence(startingDisks - 1, free, target, starter));
		return moves;
	}

	// You are partaking in a scavenger hunt!
	// You've gotten a secret map to find many of the more difficult
	// items, but they are only available at VERY specific times at
	// specific places. You have an array, times[], that lists at which
	// MINUTE an item is available. Times is sorted in ascending order.
	// Items in the ScavHunt are worth varying numbers of points.
	// You also have an array, points[], same length as times[],
	// that lists how many points each of the corresponding items is worth.
	// Problem is: to get from one location to the other takes 5 minutes,
	// so if there is an item, for example, available at time 23 and another
	// at time 27, it's just not possible for you to make it to both: you'll
	// have to choose!
	// (but you COULD make it from a place at time 23 to another at time 28)
	// Write a method that returns the maximum POINTS you can get.
	// For example, if times = [3, 7, 9]
	// and points = [10, 15, 10]
	// Then the best possible result is getting the item at time 3 and the one at
	// time 9
	// for a total of 20 points, so it would return 20.
	public static int scavHunt(int[] times, int[] points) {
		return findMaxReward(0, times, points);
	}

	public static int findMaxReward(int startingIndex, int[] times, int[] points) {
		if (startingIndex == times.length - 1) {
			return points[times.length - 1];
		}
		if (startingIndex >= times.length) {
			return 0;
		}
		int nextIndex = startingIndex + 5;
		for (int i = startingIndex; i < nextIndex; i++) {
			if (i >= times.length) {
				break;
			}
			if (times[i] >= times[startingIndex] + 5) {
				nextIndex = i;
			}
		}
		int chosen = points[startingIndex] + findMaxReward(nextIndex, times, points);
		int notChosen = findMaxReward(startingIndex + 1, times, points);
		if (chosen > notChosen) {
			return chosen;
		} else {
			return notChosen;
		}
	}

}
