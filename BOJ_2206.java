import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2206 {
	
	public static int[] di = new int[] {-1, +1, 0, 0};
	public static int[] dj = new int[] {0, 0, -1, +1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parser = br.readLine().split(" ");
		int N = Integer.parseInt(parser[0]);
		int M = Integer.parseInt(parser[1]);
		char[][] map = new char[N][M];
		boolean[][][] visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		// 입력완료.
		/////////////////////////////////////////////
		Queue<Integer> q = new LinkedList<>();
		visited[0][0][1] = true;
		q.add(0); // start i
		q.add(0); // start j
		q.add(1); // cost
		q.add(1); // 벽을 부실수 있는지 없는지.
		while (!q.isEmpty()) {
			int i = q.poll();
			int j = q.poll();
			int cost = q.poll();
			int b = q.poll();
			if (i == N - 1 && j == M - 1) {
				System.out.println(cost);
				return;
			} else {
				for (int dir = 0; dir < 4; dir++) {
					int next_i = i + di[dir];
					int next_j = j + dj[dir];
					if (next_i >= 0 && next_i < N && next_j >= 0 && next_j < M) {
						if (!visited[next_i][next_j][b]) {
							if (map[next_i][next_j] == '1') {
								if (b == 0)
									continue;
								else if (b == 1) {
									visited[next_i][next_j][0] = true;
									q.add(next_i);
									q.add(next_j);
									q.add(cost + 1);
									q.add(0);
								}
							} else {
								visited[next_i][next_j][b] = true;
								q.add(next_i);
								q.add(next_j);
								q.add(cost + 1);
								q.add(b);
							}
						}
					}
				}
			}
		}
		System.out.println(-1);
		br.close();
	}
}
