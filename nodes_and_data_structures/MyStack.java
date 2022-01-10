package nodes_and_data_structures;

import main_programs.*;

//phần ngăn xếp:
public class MyStack {
	
	private Nodes head;
	
	public MyStack() {head = null;}
	
	public void push(Product a) {
		Nodes n = new Nodes(a);
		n.setNextNode(this.head);
		this.head = n;
	}
	
	private int length() {
		Nodes curr = this.head;
		int i = 0;
		while (curr != null) {i++; curr = curr.getNextNode();}
		return i;
	}
	
	public Product pop() {
		Nodes n = this.head;
		if (this.head != null) {
			this.head = this.head.getNextNode();
			Product pr = n.getData();
			return pr;
		}
		return null;
	}
	
	public Product[] popAll() {
		Product[] arr = new Product[this.length()];
		Nodes curr = new Nodes(this.pop());
		int i = 0;
		while(curr != null) {
			arr[i] = curr.getData();
			i++;
			curr = new Nodes(this.pop());
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