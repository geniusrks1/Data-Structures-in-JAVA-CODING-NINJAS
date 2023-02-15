import java.util.*;

public class Solution {

	int solve(String[] board, int n, int m) {
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					if (hasCycle(board, -1, -1, i, j, visited,n,m)) {
						return 1;
					}
				}
			}
		}
		return 0;
	}

	public static boolean hasCycle(String[] board, int fromX, int fromY, int i, int j, boolean[][] visited, int n,
			int m) {

		if (visited[i][j]) {
			return true;
		}

		int[] X_dir = { 1, 0, 0, -1 };
		int[] Y_dir = { 0, 1, -1, 0 };
		visited[i][j] = true;
		for (int l = 0; l < 4; l++) {
			int x = X_dir[l] + i;
			int y = Y_dir[l] + j;
			if (x == fromX && y == fromY) 
				continue;
			

			if ( x >= 0 && y >= 0
					&& x < n && y <m
					&& board[x].charAt(y) == board[i].charAt(j)
					&& hasCycle(board, i, j, x, y, visited,n,m))
					return true;
	
		}
		return false;

	}

}
