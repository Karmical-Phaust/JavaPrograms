package nodes_and_data_structures;

import main_programs.*;

//các nodes cho danh sách móc nối, ngăn xếp và hàng:
public class Nodes {
	private Product data;
	private Nodes prevNode;
	private Nodes nextNode;
	
	public Nodes(String id, String title, int quant, double p) {
		Product pr = new Product(id, title, quant, p);
		this.data = pr;
	}
	
	public Nodes(Product a) {this.data = a;}

	//các getter (và setter) cho các node:
	public Product getData() {
		return data;
	}

	public void setData(Product data) {this.data = data;}
	
	public void setData(String id, String title, int quant, double p) {
		Product pr = new Product(id, title, quant, p);
		this.data = pr;
	}

	public Nodes getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Nodes prevNode) {
		this.prevNode = prevNode;
	}

	public Nodes getNextNode() {
		return nextNode;
	}

	public void setNextNode(Nodes nextNode) {
		this.nextNode = nextNode;
	}
	
	//ghi đè toString để trả về chuỗi:
	@Override
	public String toString() {
		return this.data.toString();
	}

}