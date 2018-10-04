import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		String second = sc.nextLine();
		System.out.println(first);
		System.out.println(second);
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
	
}
