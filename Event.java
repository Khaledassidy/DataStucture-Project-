
import java.time.LocalDate;

public class Event {
	String venue;
	String name;
	Service service;
	LocalDate d;
	public Event(String na,String v,Service c,LocalDate d) {
		this.name=na;
		this.venue=v;
		this.service=c;
		this.d=d;
	}
	public void display() {
		System.out.println("Name: "+name+"\nVenue: "+venue+"\nDate: "+d+"\nServices: ");
		service.display();
	}
}