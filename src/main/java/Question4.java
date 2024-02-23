
/**
 * N 个人（编号 1~N）围成一圈，从编号为1的开始报数，从1报到M，报道M的人出来，下一个人继续重新从1开始报数，编程求最后一个人的编号。
 */
class Question4 {

	public static int lastOut(int n, int m) {

		int gap = m - 1;
		Node head = null;
		Node next = head = new Node(-1, null);
		for (int i = 1; i <= n; i++) {
			Node newNode = new Node(i, null);
			next.next = newNode;
			next = newNode;
		}
		next.next = head.next;// 首位相连，串联起来

		int i = 0;
		while (head.next != null && head != head.next) {
			if (i < gap) {
				head = head.next;
				i++;
			} else {
				i = 0;
				// 删除节点
				Node temp = head.next.next;
				head.next.next = null;
				System.out.println("out:" + head.next.val);
				head.next = temp;
			}
		}

		return head.val;
		// 时间复杂的 O(m*n)
		// 空间复杂度 O(n)
	}

	static class Node {
		int val;
		Node next;

		Node(int val, Node n) {
			this.val = val;
			next = n;
		}
	}

	public static void main(String[] args) {
		int n = 3, m = 2;
		System.out.println(lastOut(n, m));
		n = 5;
		m = 9;
		System.out.println(lastOut(n, m));

		n = 5;
		m = 1;
		System.out.println(lastOut(n, m));
	}
}