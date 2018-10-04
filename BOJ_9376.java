import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_9376 {

	public static int R;
	public static int C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			String[] parser = br.readLine().split(" ");
			R = Integer.parseInt(parser[0]);
			C = Integer.parseInt(parser[1]);
			boolean isFirst = true;
			char[][] map = new char[R][C];
			boolean[][][] visited1 = new boolean[2][R][C];
			Queue<Node> q = new LinkedList<>(); 
			for (int i = 0; i < R; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					map[i][j] = tmp[j];
					if (j == '$') {
						if(isFirst) {
							q.add(new Node(0, i, j, 0));
							isFirst = false;
						} else {
							q.add(new Node(1, i, j, 0));
						}
					}
				}
			}
			////////////////////////////////////////////////////////////
			for (int i = 0; i < R; i++)
				System.out.println(map[i]);
		}
		br.close();
	}
	
	public static class Node {
		public int who;
		public int i;
		public int j;
		public int cost;
		public boolean[][] opened;
		public Node(int who, int i, int j, int cost) {
			this.who = who;
			this.i = i;
			this.j = j;
			this.cost = cost;
			this.opened = new boolean[R][C];
		}
	}

}
