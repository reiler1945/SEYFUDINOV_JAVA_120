class Program {
	public static void main(String[] args) {
		// initialization
		SList list = new SList();
		SList temp = list;
		for (int i = 0; i < 10; i++) {
			temp.value = i * 5;
			temp.next = new SList();
			temp = temp.next;	
		};
		// print list
		temp = list;
		while (temp.next != null) {
			System.out.println("value = " + temp.value);
			temp = temp.next;	
		};
		// do revers
		SList rlist = null;
		SList head, previous;
		head = list;
		previous = null;
		while (list.next != null) {
			temp = list.next.next;
			System.out.println("Я здесь. value = " + head.value);	
			if (head.next == null) {
				System.out.println("Я здесь. value = " + head.value);	
			}
			head.next = previous;
			previous = list;
			head = list.next;
			list = temp;
		}; 
		rlist = head;
		// print list
		temp = rlist;
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