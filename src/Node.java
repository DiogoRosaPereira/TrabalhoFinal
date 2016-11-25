public class Node {
	public  String dado;
	Node next;
	Node back;
	
	public Node(String dado) {
		this.dado = dado;
		this.next = null;
		this.back = null;
	}
	public Node getBack() {
		return back;
	}
	public void setBack(Node back) {
		this.back = back;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getNext() {
		return next;
	}

}