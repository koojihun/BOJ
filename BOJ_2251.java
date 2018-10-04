import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2251 {

	public static int[] full;
	public static ArrayList<Integer> ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		full = new int[3];
		full[0] = sc.nextInt(); full[1] = sc.nextInt(); full[2] = sc.nextInt();
		boolean[][] visited = new boolean[full[0] + 1][full[1] + 1];
		ans = new ArrayList<>();
		///////////////////////////////////////////////////
		Queue<Integer> q = new LinkedList<>();
		///////////////////////////////////////////////////
		visited[0][0] = true;
		q.add(0); q.add(0); q.add(full[2]);
		while (!q.isEmpty()) {
			int[] cur = new int[3];
			int[] original = new int[3];
			cur[0] = original[0] = q.poll();
			cur[1] = original[1] = q.poll();
			cur[2] = original[2] = q.poll();
			if (cur[0] == 0)
				ans.add(cur[2]);
			///////////////////////////////
			for (int from = 0; from < 3; from++) {
				for (int to = 0; to < 3; to++) {
					if (from == to)
						continue;
					/////////////////////////////////////////
					if (cur[from] > 0 && cur[to] < full[to]) {
						int possibleAmount = full[to] - cur[to];
						if (cur[from] <= possibleAmount) {
							cur[to] += cur[from];
							cur[from] = 0;
						} else {
							cur[from] -= possibleAmount;
							cur[to] = full[to];
						}
						if (!visited[cur[0]][cur[1]]) {
							visited[cur[0]][cur[1]] = true;
							q.add(cur[0]); q.add(cur[1]); q.add(cur[2]);
						}
						cur[0] = original[0];
						cur[1] = original[1];
						cur[2] = original[2];
					}
				}
			}
		}
		ans.sort(null);
		for (int tmp : ans)
			System.out.print(tmp + " ");
		sc.close();
	}

}
