
import java.time.LocalDate;

public class PQNode {
	LocalDate priority;
	Event data;
	PQNode next;
	public PQNode(Event e,LocalDate p) {
		this.data=e;
		this.priority=p;
	}
	public void display() {
		System.out.println("On "+this.priority+": ");
		data.display();
	}
}