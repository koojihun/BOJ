import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13913 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] visited = new boolean[150001];
		int[] prev = new int[150001]; // 이전 지점을 가지고 있는 배열. 
		                              // ex) prev[36] = 18 이라는 뜻은 36 지점에 오기 전에 18 지점에서 왔다는 것이다. 
		Queue<Integer> q= new LinkedList<>();
		visited[N] = true;
		q.add(N);
		q.add(0);
		prev[N] = -1;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			int cost = q.poll();
			if (cur == K) {
				System.out.println(cost);
				ArrayList<Integer> ans = new ArrayList<>();
				while (cur != -1) {
					ans.add(cur);
					cur = prev[cur];
				}
				for (int cnt = ans.size() - 1; cnt >= 0; cnt--)
					System.out.println(ans.get(cnt) + " ");
			} else {
				if (cur - 1 >= 0 && !visited[cur - 1]) {
					visited[cur - 1] = true;
					prev[cur - 1] = cur;
					q.add(cur - 1);
					q.add(cost + 1);
				}
				if (cur + 1 <= K && !visited[cur + 1]) {
					visited[cur + 1] = true;
					prev[cur + 1] = cur;
					q.add(cur + 1);
					q.add(cost + 1);
				}
				if (cur <= 75000 && !visited[cur * 2]) {
					visited[cur * 2] = true;
					prev[cur * 2] = cur;
					q.add(cur * 2);
					q.add(cost + 1);
				}
			}
		}
		
		sc.close();
	}

}
