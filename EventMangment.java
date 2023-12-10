
import java.time.LocalDate;
import java.util.*;
public class EventMangment {
	
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		
		//creating default services
		Service s1=new Service(2);
		s1.insertAtFront("Dinner");
		s1.insertAtFront("Balloons");
		
		Service s2=new Service(4);
		s2.insertAtFront("Dinner");
		s2.insertAtFront("Balloons");
		s2.insertAtFront("DJ");
		s2.insertAtFront("Cake");
		
		
		
		Service s3=new Service(5);
		s3.insertAtFront("Dinner");
		s3.insertAtFront("Decoration");
		s3.insertAtFront("DJ");
		s3.insertAtFront("Cake");
		s3.insertAtFront("Special effects");
		
		String[] venues= {"La Salle","Pine Castle","Verde","Shehab Garden","Five Stars"};
		
		String[] eventnames=new String[100];
		eventnames[0]="Khalid Assidi's Birthday";
		eventnames[1]="Ali & Sara Wedding";
		eventnames[2]="Lycee Pascal School Graduate Party";
		eventnames[3]="Aya bride to be";
		eventnames[4]="Nour and Yassine gender reveal";
		
		//creating events
		Event ev1 = new Event(eventnames[0], venues[0], s3, LocalDate.of(2024, 7, 1));
		Event ev2 = new Event(eventnames[1], venues[3], s1, LocalDate.of(2024, 7, 19));
		Event ev3 = new Event(eventnames[2], venues[4], s3, LocalDate.of(2025, 11, 30));
		Event ev4 = new Event(eventnames[3], venues[2], s2, LocalDate.of(2028, 10, 20));
		Event ev5 = new Event(eventnames[4], venues[1], s1, LocalDate.of(2024, 8, 25));
		
		//priority queues
		PQ total=new PQ();
		total.enqueue(ev1,ev1.d);
		total.enqueue(ev2,ev2.d);
		total.enqueue(ev3, ev3.d);
		total.enqueue(ev4,ev4.d);
		total.enqueue(ev5, ev5.d);
		
		PQ pq=new PQ();
		pq.enqueue(ev1,ev1.d);
		
		PQ pq1=new PQ();
		pq1.enqueue(ev2,ev2.d);
		pq1.enqueue(ev3, ev3.d);
		
		PQ pq2=new PQ();
		pq2.enqueue(ev4,ev4.d);
		pq2.enqueue(ev5, ev5.d);
		
		//creating employees
		Employee e=new Employee("Ali",25,"Ali@gmail.com","81/875***",pq);
		Employee e1=new Employee("Shadi",28,"Shadi@gmail.com","70/324***",pq1);
		Employee e2=new Employee("Houssam",33,"Houssam@gmail.com","76/532***",pq2);
		
		//adding employees to the list
		LinkedList list=new LinkedList();
		list.insertAtBack(e);
		list.insertAtBack(e1);
		list.insertAtBack(e2);
		
		System.out.println("Choose you action: ");
		System.out.println("1-Add an event ");
		System.out.println("2-Delete latest event");
		System.out.println("3-Display an events information");
		System.out.println("4-Add an employee ");
		System.out.println("5-Remove an employee ");
		System.out.println("6-Show list of employees ");
		System.out.println("7-Display employee information ");
		System.out.println("-1 to Exit the Event Mangment System");
		while(true) {
		int action=x.nextInt();
		if(action==1) {
			System.out.println("What is the event name?");
			String name=x.next();
					//venue
			System.out.println("Where is the event will take place?");
			String ven=x.next();
					//date
			System.out.println("Enter event date");
			System.out.print("Year: ");
			int year=x.nextInt();
			System.out.print("Month: ");
			int month=x.nextInt();
			System.out.print("Day: ");
			int day=x.nextInt();
			
					//services
			System.out.println("How many services do you want?");
			int a=x.nextInt();
			Service s=new Service(a);
			System.out.println("What are they: ");
			for(int i=0;i<a;i++) {
				s.insertAtFront(x.next());
			}
					//constructing a new event for the user
			Event user=new Event(name,ven,s,LocalDate.of(year ,month ,day));
					//event display
			System.out.println("The event consistes of: ");
			user.display();
			System.out.print("Select an employee to manage the event: ");
			list.display();
			String nameM=x.next();
			total.enqueue(user, LocalDate.of(year ,month ,day));
			list.searchem(nameM).q.enqueue(user, LocalDate.of(year ,month ,day));
			list.searchem(nameM).display();	
			System.out.println();
			System.out.println("Done");
			System.out.println();
			System.out.println();
			mainmenue();
		}
		else if(action==2) {
			System.out.println(total.dequeue().name+" was removed");
			System.out.println("New list: ");
			total.display();
			System.out.println();
			System.out.println();
			mainmenue();
		}
		else if(action==3) {
			total.display();
			System.out.println();
			System.out.println("Choose an event to view information: ");
			System.out.println("(ex. 1 is to view \"Khalid Assidi's Birthday\")");
			int view=x.nextInt();
			total.evAtPos(view).display();
			System.out.println();
			System.out.println();
			mainmenue();
		}
		else if(action==4) {
			
			System.out.println("name: ");
			String na=x.next();
			System.out.println("age: ");
			int age=x.nextInt();
			System.out.println("email: ");
			String email=x.next();
			System.out.println("Phone number: ");
			String nb=x.next();
			System.out.println("Which event you want to assign them to: ");
			total.display();
			System.out.println();
			System.out.println("(ex. 1 is to assign \"Khalid Assidi's Birthday\" to your employee)");
			int assign=x.nextInt();
			PQ pqnew=new PQ();
			pqnew.enqueue(total.evAtPos(assign), total.evAtPos(assign).d);
			Employee enew=new Employee(na,age,email,nb,pqnew);
			
			list.insertAtBack(enew);
			list.display();
			System.out.println();
			System.out.println();
			mainmenue();
		}
		else if(action==5) {
			list.display();
			System.out.println("Who do you want to remove: ");
			String remove=x.next();
			list.Remove(remove);
			list.display();
			System.out.println();
			System.out.println();
			mainmenue();
		}
		else if(action==6) {
			System.out.println();
			System.out.println();
			mainmenue();
			list.display();
		}
		else if(action==7) {
			list.display();
			System.out.println("Who do you want to view: ");
			System.out.println("(ex. 1 is to view the first employee's information");
			int vi=x.nextInt();
			list.searchWithindexes(vi).display();
			System.out.println();
			System.out.println();
			mainmenue();
			
		}
		else if(action==-1) {
			System.out.println("System Shutting Down............");
		}
		else {
			break;
		}
		}
	}
	
	public static void mainmenue() {
		System.out.println("Choose you action: ");
		System.out.println("1-Add an event ");
		System.out.println("2-Delete latest event");
		System.out.println("3-Display an events information");
		System.out.println("4-Add an employee ");
		System.out.println("5-Remove an employee ");
		System.out.println("6-Show list of employees ");
		System.out.println("7-Display employee information ");
		System.out.println("-1 to Exit the Event Mangment System");
	}

}