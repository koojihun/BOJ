import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_4991 {

	public static int[] di = new int[] {-1, +1, 0, 0};
	public static int[] dj = new int[] {0, 0, -1, +1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parser = br.readLine().split(" ");
		int w = Integer.parseInt(parser[0]);
		int h = Integer.parseInt(parser[1]);
		///////////////////////////////////////////////////
		if (h == 0 && w == 0)
			return;
		///////////////////////////////////////////////////
		char[][] map = new char[h][w];
		int[][] visited = new int[h][w];
		for (int i = 0; i < h; i++) {
			Arrays.fill(visited[i], -1);
		}
		int dirtyCount = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < h; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < w; j++) {
				map[i][j] = tmp[j];
				if (map[i][j] == '*')
					dirtyCount++;
				else if (map[i][j] == 'o') {
					visited[i][j] = 0;
					q.add(i);
					q.add(j);
					q.add(0); // cost
					q.add(0); // 지금까지 청소한 구역의 갯수.
				}
			}
		}
		///////////////////////////////////////////////////
		while (!q.isEmpty()) {
			int i = q.poll();
			int j = q.poll();
			int cost = q.poll();
			int count = q.poll();
			if (count == dirtyCount) {
				System.out.println(cost);
				return;
			} else {
				for (int dir = 0; dir < 4; dir++) {
					int next_i = i + di[dir];
					int next_j = j + dj[dir];
					if (next_i >= 0 && next_i < h && next_j >= 0 && next_j < w && 
							(visited[next_i][next_j] == -1 || visited[next_i][next_j] < count)
							&& map[next_i][next_j] != 'x') {
						char next = map[next_i][next_j];
						if (next == '.') {
							visited[next_i][next_j] = count;
							q.add(next_i);
							q.add(next_j);
							q.add(cost + 1);
							q.add(count);
						} else if (next == '*') {
							System.out.println("i = " + next_i + ", j = " + next_j + ", cost = " + (cost + 1) + ", count = " + (count + 1));
							q.clear();
							for (int cnt = 0; cnt < h; cnt++)
								Arrays.fill(visited[cnt], -1);
							visited[next_i][next_j] = count + 1;
							q.add(next_i);
							q.add(next_j);
							q.add(cost + 1);
							q.add(count + 1);
						} else if (next == 'o') {
							visited[next_i][next_j] = count;
							q.add(next_i);
							q.add(next_j);
							q.add(cost + 1);
							q.add(count);
						}
					}
				}
			}
		}
		System.out.println(-1);
		br.close();
	}

}
