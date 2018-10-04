import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_12851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] costMap = new int[150001];
		Arrays.fill(costMap, -1);
		Queue<Integer> q = new LinkedList<>();
		costMap[N] = 0;
		q.add(N);
		q.add(0);
		int ans = Integer.MAX_VALUE;
		int ansCnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			int cost = q.poll();
			if (cur == K) {
				ans = cost;
				ansCnt++;
			} else {
				if (cur - 1 >= 0 && (costMap[cur - 1] >= cost + 1 || costMap[cur - 1] == -1)) {
					costMap[cur - 1] = cost + 1;
					q.add(cur - 1);
					q.add(cost + 1);
				}
				if (cur < K && (costMap[cur + 1] >= cost + 1 || costMap[cur + 1] == -1)) {
					costMap[cur + 1] = cost + 1;
					q.add(cur + 1);
					q.add(cost + 1);
				}
				if (cur <= 75000 && (costMap[cur * 2] >= cost + 1 || costMap[cur * 2] == -1)) {
					costMap[cur * 2] = cost + 1;
					q.add(cur * 2);
					q.add(cost + 1);
				}
			}
		}
		System.out.println(ans);
		System.out.println(ansCnt);
		sc.close();
	}

}
