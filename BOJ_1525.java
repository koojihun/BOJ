import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1525 {

	public static int[] di = new int[] {-1, +1, 0, 0};
	public static int[] dj = new int[] {0, 0, -1, +1};
	public static final String target = "123456780"; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Node> q = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		String input = "";
		for (int cnt = 0; cnt < 9; cnt++)
			input += String.valueOf(sc.nextInt());
		//////////////////////////////////////////////
		visited.add(input);
		q.add(new Node(input, 0));
		while (!q.isEmpty()) {
			Node cur_node = q.poll();
			/////////////////////////////////////////////////
			String cur_str = cur_node.str;
			int cur_cost = cur_node.cost;
			//////////////////////////////////////////////////
			if (cur_str.equals(target)) {
				System.out.println(cur_cost);
				sc.close();
				return;
			} else {
				int i = findi(cur_str);
				int j = findj(cur_str);
				for (int dir = 0; dir < 4; dir++) {
					int next_i = i + di[dir];
					int next_j = j + dj[dir];
					if (next_i >= 0 && next_i < 3 && next_j >= 0 && next_j < 3) {
						String next = swap(cur_str, i, j, next_i, next_j);
						if (!visited.contains(next)) {
							visited.add(next);
							q.add(new Node(next, cur_cost + 1));
						}
					}
				}
			}
		}
		System.out.println(-1);
		sc.close();
	}
	
	public static String swap(String str, int i, int j, int next_i, int next_j) {
		StringBuilder sb = new StringBuilder(str);
		int left = i * 3 + j;
		int right = next_i * 3 + next_j;
		char tmp = str.charAt(left);
		sb.setCharAt(left, str.charAt(right));
		sb.setCharAt(right, tmp);
		return sb.toString();
	}
	
	public static int findj(String str) {
		for (int idx = 0; idx < str.length(); idx++) {
			if (str.charAt(idx) == '0') {
				return idx % 3;
			}
		}
		System.out.println("fuck");
		return -1;
	}
	
	public static int findi(String str) {
		for (int idx = 0; idx < str.length(); idx++) {
			if (str.charAt(idx) == '0') {
				return idx / 3;
			}
		}
		return -1;
	}
	
	public static class Node {
		String str;
		int cost;
		public Node(String str, int cost) {
			this.str = str;
			this.cost = cost;
		}
	}

}
