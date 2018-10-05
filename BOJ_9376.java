import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_9376 {

	public static int R;
	public static int C;
	public static int[] di = new int[] {-1, +1, 0, 0};
	public static int[] dj = new int[] {0, 0, -1, +1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			String[] parser = br.readLine().split(" ");
			R = Integer.parseInt(parser[0]);
			C = Integer.parseInt(parser[1]);
			boolean isFirst = true;
			char[][] map = new char[R][C];
			boolean[][][] visited = new boolean[2][R][C];
			Queue<Node> q = new LinkedList<>(); 
			for (int i = 0; i < R; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					map[i][j] = tmp[j];
					if (map[i][j] == '$') {
						if(isFirst) {
							visited[0][i][j] = true;
							q.add(new Node(0, i, j));
							isFirst = false;
						} else {
							visited[1][i][j] = true;
							q.add(new Node(1, i, j));
						}
					}
				}
			}
			ArrayList<Node> firstAns = new ArrayList<>();
			ArrayList<Node> secondAns = new ArrayList<>();
			////////////////////////////////////////////////////////////
			while (!q.isEmpty()) {
				Node cur = q.poll();
				if (cur.i == 0 || cur.j == 0 || cur.i == R - 1 || cur.j == C - 1) {
					if (cur.who == 0) {
						firstAns.add(cur);
					} else {
						secondAns.add(cur);
					}
				} else {
					for (int dir = 0; dir < 4; dir++) {
						int next_i = cur.i + di[dir];
						int next_j = cur.j + dj[dir];
						if (next_i >= 0 && next_i < R && next_j >= 0 && next_j < C && !visited[cur.who][next_i][next_j]) {
							if (map[next_i][next_j] == '.' || map[next_i][next_j] == '$') {
								visited[cur.who][next_i][next_j] = true;
								q.add(new Node(cur.who, next_i, next_j, cur.opened));
							} else if (map[next_i][next_j] == '#') {
								visited[cur.who][next_i][next_j] = true;
								q.add(new Node(cur.who, next_i, next_j, cur.opened, next_i, next_j);
							}
						}
					}
				}
			}
		}
		br.close();
	}
	
	public static class Node {
		public int who;
		public int i;
		public int j;
		public int cost;
		public boolean[][] opened;
		public Node(int who, int i, int j) {
			this.who = who;
			this.i = i;
			this.j = j;
			this.opened = new boolean[R][C];
		}
		public Node(int who, int i, int j, boolean[][] opened, int new_i, int new_j) {
			this.who = who;
			this.i = i;
			this.j = j;
			this.opened = new boolean[R][C];
			for (int ii = 0; ii < R; ii++) {
				for (int jj = 0; jj < C; jj++) {
					this.opened[ii][jj] = opened[ii][jj];
				}
			}
			this.opened[new_i][new_j] = true;
		}
		public Node(int who, int i, int j, boolean[][] opened) {
			this.who = who;
			this.i = i;
			this.j = j;
			this.opened = new boolean[R][C];
			for (int ii = 0; ii < R; ii++) {
				for (int jj = 0; jj < C; jj++) {
					this.opened[ii][jj] = opened[ii][jj];
				}
			}
		}
	}

}
