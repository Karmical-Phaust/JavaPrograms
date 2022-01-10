package nodes_and_data_structures;

import main_programs.*;

//phần hàng:
public class MyQueue {
	
	private Nodes head, tail;
	
	public MyQueue() {head = tail = null;}
	
	private boolean isEmp() {return (head == null);}
	
	public void enQueue(Product a) {
		
		Nodes n = new Nodes(a);
		if (this.isEmp()) {
			head = tail = n;
		} else {
			this.tail.setNextNode(n);
			this.tail = this.tail.getNextNode();
		}
		
	}
	
	public Product deQueue() {
		
		if (this.isEmp()) {
			return null;
		} else {
			Product a = this.head.getData();
			this.head = this.head.getNextNode();
			if (this.head == null) {this.tail = null;}
			return a;
		}
		
	}
	
	private int length() {
		Nodes curr = this.head;
		int i = 0;
		while (curr != null) {i++; curr = curr.getNextNode();}
		return i;
	}
	
	public Product[] deQueueAll() {
		Product[] arr = new Product[this.length()];
		Nodes curr = new Nodes(this.deQueue());
		int i = 0;
		while(curr != null) {
			arr[i] = curr.getData();
			i++;
			curr = new Nodes(this.deQueue());
		}
		return arr;
	}
	
	@Override
	public String toString() {
		String res = "";
		Nodes curr = this.head;
		
		while(curr != null) {
			res += curr;
			res += "\n";
			curr = curr.getNextNode();
		}
		
		return res;
	}

}