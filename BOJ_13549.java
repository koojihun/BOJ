import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13549 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] costMap = new int[200001];
		Arrays.fill(costMap,-1);
		Queue<Integer> q = new LinkedList<>();
		costMap[N] = 0;
		q.add(N);
		q.add(0);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int cost = q.poll();
			if (cur < K && (costMap[cur + 1] == -1 || costMap[cur + 1] > cost + 1)) {
				costMap[cur + 1] = cost + 1; // 이문제에서는 이게 방문표시. cost로 따지기 때문에.
				q.add(cur + 1);
				q.add(cost + 1);
			}
			if (cur - 1 >= 0 && (costMap[cur - 1] == -1 || costMap[cur - 1] > cost + 1)) {
				costMap[cur - 1] = cost + 1;
				q.add(cur - 1);
				q.add(cost + 1);
			}
			if (cur < K && (costMap[cur * 2] == -1 || costMap[cur * 2] > cost)) {
				costMap[cur * 2] = cost;
				q.add(cur * 2);
				q.add(cost);
			}
		}
		
		System.out.println(costMap[K]);
		sc.close();
	}
}
