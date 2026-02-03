import java.io.*;
import java.util.*;

import javax.management.QueryEval;

// You are allowed (and expected!) to use either Java's ArrayDeque or LinkedList class to make stacks and queues

public class CookieMonster {

	private int[][] cookieGrid;
	private int numRows;
	private int numCols;

	// Constructs a CookieMonster from a file with format:
	// numRows numCols
	// <<rest of the grid, with spaces in between the numbers>>
	public CookieMonster(String fileName) {
		int row = 0;
		int col = 0;
		try {
			Scanner input = new Scanner(new File(fileName));

			numRows = input.nextInt();
			numCols = input.nextInt();
			cookieGrid = new int[numRows][numCols];

			for (row = 0; row < numRows; row++)
				for (col = 0; col < numCols; col++)
					cookieGrid[row][col] = input.nextInt();

			input.close();
		} catch (Exception e) {
			System.out.print("Error creating maze: " + e.toString());
			System.out.println("Error occurred at row: " + row + ", col: " + col);
		}

	}

	public CookieMonster(int[][] cookieGrid) {
		this.cookieGrid = cookieGrid;
		this.numRows = cookieGrid.length;
		this.numCols = cookieGrid[0].length;
	}

	// You may find it VERY helpful to write this helper method. Or not!
	private boolean validPoint(int row, int col) {
		// Write this if you want
		if (row >= 0 && row < numRows && col >= 0 && col < numCols) {
			return true;
		}
		return false;
	}

	/*
	 * RECURSIVELY calculates the route which grants the most cookies.
	 * Returns the maximum number of cookies attainable.
	 */
	public int recursiveCookies() {
		return recursiveCookies(0, 0, 0);
	}

	// Returns the maximum number of cookies edible starting from (and including)
	// cookieGrid[row][col]
	// 1 by 1 grid with just a landmine
	public int recursiveCookies(int row, int col, int numCookies) {
		// CODE THIS
		if (!validPoint(row, col)) {
			return -1;
		}
		if (cookieGrid[row][col] == -1) {
			return numCookies;
		}
		if (row == numRows - 1 && col == numCols - 1) {
			return numCookies + cookieGrid[row][col];
		}
		int down = recursiveCookies(row + 1, col, numCookies + cookieGrid[row][col]);
		int right = recursiveCookies(row, col + 1, numCookies + cookieGrid[row][col]);
		if (right > down) {
			return right;
		} else {
			return down;
		}
	}

	/*
	 * Calculate which route grants the most cookies using a QUEUE.
	 * Returns the maximum number of cookies attainable.
	 */
	/*
	 * From any given position, always add the path right before adding the path
	 * down
	 */
	public int queueCookies() {
		// CODE THIS
		if (cookieGrid[0][0] == -1) {
			return 0;
		}
		Queue<OrphanScout> orphans = new LinkedList<>();
		int r = 0;
		int c = 0;
		int greatestCookie = 0;
		int numCookies = cookieGrid[r][c];
		OrphanScout orphan = new OrphanScout(r, c, numCookies);
		orphans.add(orphan);
		while (!orphans.isEmpty()) {
			r = orphans.peek().getEndingRow();
			c = orphans.peek().getEndingCol();
			numCookies = orphans.peek().getCookiesDiscovered();
			if (orphans.peek().getCookiesDiscovered() > greatestCookie) {
				greatestCookie = orphans.remove().getCookiesDiscovered();
			} else {
				orphans.remove();
			}
			if (validPoint(r + 1, c) && cookieGrid[r + 1][c] != -1) {
				orphans.add(new OrphanScout(r + 1, c, numCookies + cookieGrid[r + 1][c]));
			}
			if (validPoint(r, c + 1) && cookieGrid[r][c + 1] != -1) {
				orphans.add(new OrphanScout(r, c + 1, numCookies + cookieGrid[r][c + 1]));
			}
		}
		return greatestCookie;
	}

	/*
	 * Calculate which route grants the most cookies using a stack.
	 * Returns the maximum number of cookies attainable.
	 */
	/*
	 * From any given position, always add the path right before adding the path
	 * down
	 */
	public int stackCookies() {
		// CODE THIS
		if (cookieGrid[0][0] == -1) {
			return 0;
		}
		Stack<OrphanScout> orphans = new Stack<>();
		int r = 0;
		int c = 0;
		int greatestCookie = 0;
		int numCookies = cookieGrid[r][c];
		OrphanScout orphan = new OrphanScout(r, c, numCookies);
		orphans.push(orphan);
		while (!orphans.empty()) {
			r = orphans.peek().getEndingRow();
			c = orphans.peek().getEndingCol();
			numCookies = orphans.peek().getCookiesDiscovered();
			if (orphans.peek().getCookiesDiscovered() > greatestCookie) {
				greatestCookie = orphans.pop().getCookiesDiscovered();
			} else {
				orphans.pop();
			}
			if (validPoint(r + 1, c) && cookieGrid[r + 1][c] != -1) {
				orphans.push(new OrphanScout(r + 1, c, numCookies + cookieGrid[r + 1][c]));
			}
			if (validPoint(r, c + 1) && cookieGrid[r][c + 1] != -1) {
				orphans.push(new OrphanScout(r, c + 1, numCookies + cookieGrid[r][c + 1]));
			}
		}
		return greatestCookie;
	}

}
