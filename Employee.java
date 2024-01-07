
public class Employee {
	String name;
	int age;
	String email;
	String pn;
	PQ q;
	
	public Employee() {
		super();
	}
	
	public Employee(String n,int a,String e,String pn,PQ q) {
		this.name=n;
		this.age=a;
		this.email=e;
		this.pn=pn;
		this.q=q;
	}
	
	public void display() {
		System.out.println("Name: "+name+"\nAge: "+age+"\nEmail: "+email+"\nPhone Number: "+pn+"\nManaging Events: ");
		q.display();
	}
	public void displayContact() {
		System.out.println("Email: "+email+"\nPhone Number: "+pn);
	}
	public void displayEvents() {
		q.display();
	}
	
}
