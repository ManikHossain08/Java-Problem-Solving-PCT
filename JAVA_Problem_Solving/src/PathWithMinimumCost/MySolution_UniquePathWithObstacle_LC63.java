package PathWithMinimumCost;

import java.util.Scanner;

public class MySolution_UniquePathWithObstacle_LC63 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		int[][] paths = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				paths[i][j] = sc.nextInt();
			}
		}
		System.out.print(uniquePathsWithObstacles(paths));

		sc.close();
	}

	public static int uniquePathsWithObstacles(int[][] paths) {

		if (paths[0][0] == 1)
			return 0;
		else
			paths[0][0] = 1;

		// initialize all row
		for (int row = 1; row < paths.length; row++) {
			if (paths[row][0] == 0 && paths[row-1][0] == 1)
				paths[row][0] = 1;
			else {
				paths[row][0] = 0;
				//break;
			}
		}
		// initialize all columns
		for (int col = 1; col < paths[0].length; col++) {
			if (paths[0][col] == 0 && paths[0][col-1] == 1)
				paths[0][col] = 1;
			else {
				paths[0][col] = 0;
				//break;
			}
		}

		for (int row = 1; row < paths.length; row++) {
			for (int col = 1; col < paths[0].length; col++) {
				if (paths[row][col] == 1)
					paths[row][col] = 0;
				else {
					paths[row][col] = paths[row - 1][col] + paths[row][col - 1];
				}
			}
		}

		return paths[paths.length - 1][paths[0].length - 1];
	}
}
