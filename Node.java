
public class Node {
	Employee e;
	Node next;
	
	public Node(Employee e) {
		this.e=e;
	}
	public void display() {
		e.display();
	}
}