import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_9328 {

	public static int[] di = new int[] {-1, +1, 0, 0};
	public static int[] dj = new int[] {0, 0, -1, +1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			String[] parser = br.readLine().split(" ");
			int R = Integer.parseInt(parser[0]);
			int C = Integer.parseInt(parser[1]);
			char[][] map = new char[R + 2][C + 2];
			int[][] visited_keys = new int[R + 2][C + 2]; // 해당 지점에 도착했을 때, key의 갯수를 가지고 있음!!!!.
			int[][] visited_docs = new int[R + 2][C + 2];
			Queue<Node> q = new LinkedList<>();
			//////////////////////////////////////////////////////////////
			for (int i = 1; i <= R; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 1; j <= C; j++) {
					map[i][j] = tmp[j - 1];
				}
			}
			//////////////////////////////////////////////////////////////
			for (int i = 0; i < R + 2; i++) {
				for (int j = 0; j < C + 2; j++) {
					if (i == 0 || i == R + 1 || j == 0 || j == C + 1)
						map[i][j] = '.';
				}
			}
			for (int i = 0; i < R + 2; i++) {
				Arrays.fill(visited_keys[i], -1);
				Arrays.fill(visited_docs[i], -1);
			}
				
			//////////////////////////////////////////////////////////////
			String keys = br.readLine();
			if (keys.equals("0"))
				keys = "";
			//////////////////////////////////////////////////////////////
			visited_keys[0][0] = keys.length();
			visited_docs[0][0] = 0;
			q.add(new Node(0, 0, 0));
			int ans = 0;
			while (!q.isEmpty()) {
				Node cur = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int next_i = cur.i + di[dir];
					int next_j = cur.j + dj[dir];
					if (next_i >= 0 && next_i < R + 2 && next_j >= 0 && next_j < C + 2
							&& map[next_i][next_j] != '*'
							&& (visited_keys[next_i][next_j] == -1 || visited_keys[next_i][next_j] < keys.length()
							    || visited_docs[next_i][next_j] == -1 || visited_docs[next_i][next_j] < cur.docs)) {
						
						char next_char = map[next_i][next_j];
						
						if (next_char == '.') {
							visited_keys[next_i][next_j] = keys.length();
							visited_docs[next_i][next_j] = cur.docs;
							q.add(new Node(next_i, next_j, cur.docs));
							
						} else if (next_char == '$') {
							ans++;
							map[next_i][next_j] = '.';
							visited_keys[next_i][next_j] = keys.length();
							visited_docs[next_i][next_j] = cur.docs + 1;
							q.add(new Node(next_i, next_j, cur.docs + 1));
							
						} else if ((int)next_char >= 97 && (int)next_char <= 122) {
							// 키를 먹은 경우.
							if (keys.indexOf(next_char) != -1) {
								visited_keys[next_i][next_j] = keys.length();
								visited_docs[next_i][next_j] = cur.docs;
								q.add(new Node(next_i, next_j, cur.docs));
							} else {
								keys += map[next_i][next_j];
								visited_keys[next_i][next_j] = keys.length();
								visited_docs[next_i][next_j] = cur.docs;
								q.add(new Node(next_i, next_j, cur.docs));
							}
							map[next_i][next_j] = '.';
							
						} else if ((int)next_char >= 65 && (int)next_char <= 90) {
							// 문을 만난 경우.
							if (keys.indexOf(next_char + 32) != -1) {
								visited_keys[next_i][next_j] = keys.length();
								visited_docs[next_i][next_j] = cur.docs;
								q.add(new Node(next_i, next_j, cur.docs));
								map[next_i][next_j] = '.';
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
		br.close();
	}
	
	public static class Node {
		public int i;
		public int j;
		public int docs;
		public Node(int i, int j, int docs) {
			this.i = i;
			this.j = j;
			this.docs = docs;
		}
	}
	
}
