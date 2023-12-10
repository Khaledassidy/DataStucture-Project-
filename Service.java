
public class Service {
	private String[] a;
	private int currentNb;
	
	public Service(int size) {
		a = new String[size];
		currentNb = 0;
	}

	public boolean isEmpty() {
		return (currentNb == 0);
	}

	public boolean isFull() {
		return (currentNb == a.length);
	}
	public void display() {
		for (int i = 0; i < currentNb; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
	}

	public boolean search(String value) {
		for (int i = 0; i < currentNb; i++) {
			if (a[i] == value)
				return true;
		}
		return false;
	}
	public boolean insertAtFront(String value) {
		if (!isFull()) {
			for (int i = currentNb - 1; i >=0; i--) {
				a[i + 1] = a[i];
			}
			a[0] = value;
			currentNb++;
			return true;
		} else
			return false;
	}
	public boolean DeleteElement(String value) {
		if (!isEmpty()) {
				for (int i = 0; i < currentNb; i++) {
					if(a[i]==value) {
						a[i]=a[currentNb-1];
						currentNb--;
					}
					
				}
				
				return true;
			
		} else
			return false;
	}
	
}
