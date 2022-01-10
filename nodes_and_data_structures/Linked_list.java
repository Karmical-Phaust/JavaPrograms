package nodes_and_data_structures;

import main_programs.*;

//phần danh sách móc nối:
public class Linked_list {
	
	private Nodes head,tail;
	
	public Linked_list() {head = tail = null;}
	
	public void insertTail(String id, String title, int quant, double p) {Product pr = new Product(id, title, quant, p); insertTail(pr);}
	
	public void insertTail(Product a) {
		Nodes n = new Nodes(a);
		n.setPrevNode(this.tail);
		if (n.getPrevNode() != null) {
			n.getPrevNode().setNextNode(n);
		}
		this.tail = n;
		this.setHead();
	}
	
	public void resetLl() {
		Nodes next, prev;
		while(this.head != null) {
			next = this.head.getNextNode();
			this.head = null;
			this.head = next;
		}
		this.head = null;
		while(this.tail != null) {
			prev = this.tail.getPrevNode();
			this.tail = null;
			this.tail = prev;
		}
		this.tail = null;
	}
	
	public int length() {
		Nodes curr = this.tail;
		int l = 0;
		while(curr != null) {
			l++;
			curr = curr.getPrevNode();
		}
		return l;
	}
	
	public void setHead() {
		Nodes curr = this.tail;
		while(true) {
			if (curr.getPrevNode() == null) {
				this.head = curr;
				break;
			}
			curr = curr.getPrevNode();
		}
	}
	
	public Product getFirst() {
		return this.head.getData();
	}
	
	public Product[] iter() {
		Product[] arr = new Product[this.length()];
		Nodes curr = this.head;
		int i = 0;
		while(curr != null) {
			arr[i] = curr.getData();
			i++;
			curr = curr.getNextNode();
		}
		return arr;
	}
	
	public Product search(String id) {
		Nodes curr = this.head;
		Product res = null;
		while(curr != null) {
			if (id.compareTo(curr.getData().getIDcode()) == 0) {
				res = curr.getData();
				break;
			}
			curr = curr.getNextNode();
		}
		return res;
	}
	
	public boolean deleteByID(String id) {
		Nodes curr = this.head;
		boolean deleted = false;
		while(curr != null) {
			if (id.compareTo(curr.getData().getIDcode()) == 0) {
				
				if (curr.getPrevNode() != null) {
					curr.getPrevNode().setNextNode(curr.getNextNode());
				}
				
				if (curr.getNextNode() != null) {
					curr.getNextNode().setPrevNode(curr.getPrevNode());
				}
				curr = null;
				deleted = true;
				break;
			}
			curr = curr.getNextNode();
		}
		curr = null;
		this.setHead();
		return deleted;
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
		
		if (res.equals("")) {
			return null;
		}
		return res;
	}

}
