import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178 {

	public static int[] di = new int[] {-1, +1, 0, 0};
	public static int[] dj = new int[] {0, 0, -1, +1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parser = br.readLine().split(" ");
		int N = Integer.parseInt(parser[0]);
		int M = Integer.parseInt(parser[1]);
		char[][] map = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		///////////////////////////////////////////////////
		Queue<Integer> q = new LinkedList<>();
		visited[0][0] = true;
		q.add(0);
		q.add(0);
		q.add(1);
		
		while (!q.isEmpty()) {
			int i = q.poll();
			int j = q.poll();
			int cost = q.poll();
			if (i == N - 1 && j == M - 1) {
				System.out.println(cost);
				break;
			} else {
				for (int dir = 0; dir < 4; dir++) {
					int next_i = i + di[dir];
					int next_j = j + dj[dir];
					if (next_i >= 0 && next_i < N && next_j >= 0 && next_j < M && !visited[next_i][next_j] && map[next_i][next_j] == '1') {
						visited[next_i][next_j] = true;
						q.add(next_i);
						q.add(next_j);
						q.add(cost + 1);
					}
				}
			}
		}
		
		br.close();
	}

}
