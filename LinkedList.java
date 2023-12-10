
public class LinkedList {
  
	Node first;
	
	public LinkedList() {
		this.first=null;
	}
	public void insertAtFront(Employee a) {
		Node p=new Node(a);
		p.next=first;
		first=p;
	}


	public void insertAtBack(Employee a) {
		Node p=new Node(a);
		Node current=first;
		if(!isEmpty()) {
			while(current.next!=null) {
				current=current.next;
			}
			current.next=p;
		}
		else first=p;
		
	}

	public void Remove(String n) {
		Node current=first;
		Node prev=null;
		
		boolean flag=false;
		if(first.e.name.equals(n)) {
			first =first.next;
			flag=true;
		}
		
		else {
			while(current.next!=null) {
				if(current.next.e.name.equals(n)) {
					prev=current;
					flag=true;
				}
				current=current.next;
			}
			if(flag==true ) {
				prev.next=prev.next.next;
				System.out.println("Done");
				
			}
			else current.next=null;
		}
		
	}


	public void display() {
		Node current=first;
		System.out.print("List of employees: ");
		while(current.next !=null) {
			System.out.print(current.e.name+"-");
			current=current.next;
		}
		System.out.print(current.e.name);
		System.out.println();
	}
	
	public void displayevents() {
		Node current=first;
		System.out.print("List of events: ");
		while(current.next !=null) {
			current.e.displayEvents();
			System.out.println(" - ");
			current=current.next;
		}
		current.e.displayEvents();
		
	}
	
	public Employee searchWithindexes(int t) {
		
		Node current=first;
		int count=1;
		while(current!=null && count!=t) {
			count++;
			current=current.next;
		}
		return current.e;
		
	}
	
	public boolean search(String n) {
		
		Node current=first;
		
		
		while(current!=null) {
			if (current.e.name.equals(n)) {
				return true;
			}
			
			current=current.next;
		}
		return false;
		
	}
	public Employee searchem(String n) {
		
		Node current=first;
		Employee em=new Employee();
		
		while(current!=null) {
			if (current.e.name.equals(n)) {
				em=current.e;
			}
			
			current=current.next;
		}
		return em;
		
	}
	public boolean isEmpty() {
		return first==null;
	}
}
