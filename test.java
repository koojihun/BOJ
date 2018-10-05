
public class test {

	public static void main(String[] args) {
		String a = "1";
		Node n = new Node(a);
		a += 10;
		n.print();
		System.out.println(a);
		
	}
	
	public static class Node {
		public String arr;
		public Node(String arr) {
			this.arr = arr;
		}
		public void print() {
			System.out.println(arr);
		}
	}
	
}
