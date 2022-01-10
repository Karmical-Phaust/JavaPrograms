package nodes_and_data_structures;

//phần ngăn xếp dùng để chuyển đổi nhị phân:
public class BiStack {
	
private NodeStack head;
	
	public void push(int a) {
		NodeStack n = new NodeStack(a);
		n.setNextNode(this.head);
		this.head = n;
	}
	
	private int length() {
		NodeStack curr = this.head;
		int i = 0;
		while (curr != null) {i++; curr = curr.getNextNode();}
		return i;
	}
	
	public NodeStack pop() {
		NodeStack n = this.head;
		if (this.head != null) {this.head = this.head.getNextNode();}
		return n;
	}
	
	public int[] popAll() {
		int[] arr = new int[this.length()];
		NodeStack curr = this.pop();
		int i = 0;
		while(curr != null) {
			arr[i] = curr.getData();
			i++;
			curr = this.pop();
		}
		return arr;
	}
	
}

//node dữ liệu số nguyên dùng cho việc chuyển đổi nhị phân:
class NodeStack {
	
	private int data;
	private NodeStack nextNode;
	
	public NodeStack(int a) {
		this.data = a;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NodeStack getNextNode() {
		return this.nextNode;
	}
	
	public void setNextNode(NodeStack n) {
		this.nextNode = n;
	}
	
}