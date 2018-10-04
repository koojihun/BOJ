import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14226 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		boolean[][] visited = new boolean[2001][2001];
		// 이 문제에서 하나의 상태는 (현재 화면의 이모티콘 수, 현재 클립보드에 있는 이모티콘 수)로 표현할 것이다.
		int start_screen = 1;
		int start_clip = 0;
		Queue<Integer> q = new LinkedList<>();
		visited[1][0] = true;
		q.add(start_screen);
		q.add(start_clip);
		q.add(0);
		while (!q.isEmpty()) {
			int cur_screen = q.poll();
			int cur_clip = q.poll();
			int cost = q.poll();
			if (cur_screen == S) {
				System.out.println(cost);
				break;
			} else {
				if (cur_screen < S && cur_screen > cur_clip && !visited[cur_screen][cur_screen]) {
					visited[cur_screen][cur_screen] = true;
					q.add(cur_screen);
					q.add(cur_screen);
					q.add(cost + 1);
				}
				if (cur_screen < S && !visited[cur_screen + cur_clip][cur_clip]) {
					visited[cur_screen + cur_clip][cur_clip] = true;
					q.add(cur_screen + cur_clip);
					q.add(cur_clip);
					q.add(cost + 1);
				}
				if (cur_screen - 1 >= 0 && !visited[cur_screen - 1][cur_clip]) {
					visited[cur_screen - 1][cur_clip] = true;
					q.add(cur_screen - 1);
					q.add(cur_clip);
					q.add(cost + 1);
				}
			}
		}
		sc.close();
	}

}
