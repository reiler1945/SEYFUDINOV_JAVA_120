class Program {
	public static void main(String[] args) {
		// initialization списка
		SList list = new SList();
		SList temp = list;
		for (int i = 0; i < 10; i++) {
			temp.value = i * 5;
			temp.next = new SList();
			temp = temp.next;	
		};
		// print list
		System.out.println("Straight:");
		temp = list;
		while (temp.next != null) {
			System.out.println("value = " + temp.value);
			temp = temp.next;	
		};
		// do reverse
		SList previous = null;
		SList current = list;
		SList forward; 
		while (current != null) {
			forward = current.next;
			current.next = previous;
			previous = current;
			current = forward;
		}
		// print reverse list
		System.out.println("Reverse:");
		temp = previous;
		while (temp.next != null) {
			System.out.println("value = " + temp.value);
			temp = temp.next;	
		}
	}
}

class SList {
	int value;
	SList next;
}