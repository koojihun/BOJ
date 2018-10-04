import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9019 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			boolean[] visited = new boolean[10000];
			int[] prevVal = new int[10000];
			char[] prevDir = new char[10000];
			Queue<Integer> q = new LinkedList<>();
			int left = sc.nextInt();
			int right = sc.nextInt();
			visited[left] = true;
			prevVal[left] = -1;
			prevDir[left] = 'e';
			q.add(left);
			q.add(0);
			while (!q.isEmpty()) {
				int cur = q.poll();
				int cost = q.poll();
				if (cur == right) {
					String ans = "";
					while (prevVal[cur] != -1) {
						ans = prevDir[cur] + ans;
						cur = prevVal[cur];
					}
					System.out.println(ans);
					break;
				} else {
					int d_ = d(cur);
					int s_ = s(cur);
					int l_ = l(cur);
					int r_ = r(cur);
					if (!visited[d_]) {
						prevVal[d_] = cur;
						prevDir[d_] = 'D';
						visited[d_] = true;
						q.add(d_);
						q.add(cost + 1);
					}
					if (!visited[s_]) {
						prevVal[s_] = cur;
						prevDir[s_] = 'S';
						visited[s_] = true;
						q.add(s_);
						q.add(cost + 1);
					}
					if (!visited[l_]) {
						prevVal[l_] = cur;
						prevDir[l_] = 'L';
						visited[l_] = true;
						q.add(l_);
						q.add(cost + 1);
					}
					if (!visited[r_]) {
						prevVal[r_] = cur;
						prevDir[r_] = 'R';
						visited[r_] = true;
						q.add(r_);
						q.add(cost + 1);
					}
				}
			}
		}
		sc.close();
	}
	
	public static int d(int mem) {
		return (2 * mem) % 10000;
	}
	
	public static int s(int mem) {
		if (mem == 0)
			return 9999;
		else
			return mem - 1;
	}
	
	public static int l(int mem) {
		int d1 = mem / 1000;
		int left = mem % 1000;
		return left * 10 + d1;
	}
	
	public static int r(int mem) {
		int d4 = mem % 10;
		int left = mem / 10;
		return d4 * 1000 + left;
	}
	
}
