import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_3055 {

	public static int[] di = new int[] {-1, +1, 0, 0};
	public static int[] dj = new int[] {0, 0, -1, +1};
	public static int R;
	public static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parser = br.readLine().split(" ");
		R = Integer.parseInt(parser[0]);
		int C = Integer.parseInt(parser[1]);
		map = new char[R][C];
		int[][] costMap = new int[R][C];
		for (int i = 0; i < R; i++)
			Arrays.fill(costMap[i], -1);
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				char tmpChar = tmp.charAt(j);
				map[i][j] = tmpChar;
				if (tmpChar == '*') {
					costMap[i][j] = 0;
					q.add(i);
					q.add(j);
					q.add(0);
					q.add(0); // 물이라는 뜻.
				} else if (tmpChar == 'S') {
					costMap[i][j] = 0;
					q.add(i);
					q.add(j);
					q.add(0);
					q.add(1); // 고슴도치라는 뜻.
				}
			}
		}
		///////////////////////////////////////////
		while (!q.isEmpty()) {
			int i = q.poll();
			int j = q.poll();
			int cost = q.poll();
			int isGo = q.poll();
			if (isGo == 1 && map[i][j] == '*')
				continue;
			if (map[i][j] == 'D') {
				System.out.println(cost);
				return;
			} else {
				if (isGo == 1) {
					for (int dir = 0; dir < 4; dir++) {
						int next_i = i + di[dir];
						int next_j = j + dj[dir];
						if (next_i >= 0 && next_i < R && next_j >= 0 && next_j < C) {
							if (map[next_i][next_j] == '.' || map[next_i][next_j] == 'D') {
								if (costMap[next_i][next_j] == -1 || costMap[next_i][next_j ] > cost + 1) {
									costMap[next_i][next_j] = cost + 1;
									q.add(next_i);
									q.add(next_j);
									q.add(cost + 1);
									q.add(isGo);
								}
							}
						}
					}
				} else if (isGo == 0) {
					for (int dir = 0; dir < 4; dir++) {
						int next_i = i + di[dir];
						int next_j = j + dj[dir];
						if (next_i >= 0 && next_i < R && next_j >= 0 && next_j < C) {
							if (map[next_i][next_j] != 'X' && map[next_i][next_j] != 'D'
									&& map[next_i][next_j] != '*') {
								      // 이 부분은 물끼리 부딫힐 수도 있으니까!!!
								if (costMap[next_i][next_j] == -1 || costMap[next_i][next_j] >= cost + 1) {
									map[next_i][next_j] = '*';
									costMap[next_i][next_j] = cost + 1;
									q.add(next_i);
									q.add(next_j);
									q.add(cost + 1);
									q.add(isGo);
								}
							}
						}
					}
				}
			}
		}
		System.out.println("KAKTUS");
		br.close();
	}
	
}
