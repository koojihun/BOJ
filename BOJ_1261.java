import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1261 {

	public static int N;
	public static int M;
	public static int[][] map;
	public static int[][] costMap;
	public static int[] di = new int[] {-1, +1, 0, 0};
	public static int[] dj = new int[] {0, 0, -1, +1};
	public static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); N = sc.nextInt(); sc.nextLine();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = sc.nextLine();
			for (int j = 0; j < tmp.length(); j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		//////////////////////////////////////////
		costMap = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(costMap[i], -1);
		//////////////////////////////////////////
		costMap[0][0] = 0;
		backTrack(0, 0, 0);
		System.out.println(ans);
		sc.close();
	}
	
	public static void backTrack(int i, int j, int total) {
		// (i, j) == ÀÌ¹Ì ¹âÀº À§Ä¡! ÀÌ¹Ì ¹âÀº!
		if (i == N - 1 && j == M - 1) {
			ans = Math.min(ans, total);
		} else {
			for (int dir = 0; dir < 4; dir++) {
				int next_i = i + di[dir];
				int next_j = j + dj[dir];
				if (next_i >= 0 && next_i < N && next_j >= 0 && next_j < M) {
					if (map[next_i][next_j] == 1) {
						if (costMap[next_i][next_j] == -1 || costMap[next_i][next_j] > total + 1) {
							costMap[next_i][next_j] = total + 1;
							backTrack(next_i, next_j, total + 1);
						}
					} else {
						if (costMap[next_i][next_j] == -1 || costMap[next_i][next_j] > total) {
							costMap[next_i][next_j] = total;
							backTrack(next_i, next_j, total);
						}
					}
				}
			}
		}
	}

}
