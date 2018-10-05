import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2667 {

	public static int N;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[] di = new int[] {-1, +1, 0, 0};
	public static int[] dj = new int[] {0, 0, -1, +1};
	public static int ansCount = 0;
	public static ArrayList<Integer> ans = new ArrayList<>();
	public static int tmp_ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		///////////////////////////////////////////////////////
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1' && !visited[i][j]) {
					ansCount++;
					tmp_ans = 1;
					visited[i][j] = true;
					dfs(i, j);
					ans.add(tmp_ans);
				}
			}
		}
		System.out.println(ansCount);
		ans.sort(null);
		for (int tmp : ans)
			System.out.println(tmp);
		br.close();
	}
	
	public static void dfs(int i, int j) {
		for (int dir = 0; dir < 4; dir++) {
			int next_i = i + di[dir];
			int next_j = j + dj[dir];
			if (next_i >= 0 && next_i < N && next_j >= 0 && next_j < N && !visited[next_i][next_j] && map[next_i][next_j] == '1') {
				visited[next_i][next_j] = true;
				tmp_ans++;
				dfs(next_i, next_j);
			}
		}
	}

}
