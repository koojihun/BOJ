import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[150001];
		visited[N] = true;
		q.add(N);
		q.add(0);
		while (!q.isEmpty()) {
			int cur = q.poll();
			int cost = q.poll();
			if (cur == K) {
				System.out.println(cost);
				sc.close();
				return;
			} else {
				if (cur <= 75000 && !visited[cur * 2]) {
					visited[cur * 2] = true;
					q.add(cur * 2);
					q.add(cost + 1);
				}
				if (cur - 1 >= 0 && !visited[cur - 1]) {
					visited[cur - 1] = true;
					q.add(cur - 1);
					q.add(cost + 1);
				}
				if (cur + 1 <= K && !visited[cur + 1]) {
					visited[cur + 1] = true;
					q.add(cur + 1);
					q.add(cost + 1);
				}
			}
		}
		sc.close();
	}

}
