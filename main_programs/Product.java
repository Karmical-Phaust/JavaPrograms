package main_programs;

//đối tượng sản phẩm:
public class Product implements Comparable<Product> {
	private String IDcode;
	private String title;
	private int quantity;
	private double price;
	
	public Product(String id, String title, int quant, double p) {
		this.IDcode = id;
		this.title = title;
		this.quantity = quant;
		this.price = p;
	}

	public String getIDcode() {
		return IDcode;
	}

	public void setIDcode(String iDcode) {
		IDcode = iDcode;
	}

	//các getter (và setter) cho đối tượng:
	public String getTitle() {return title;}

	public void setTitle(String title) {this.title = title;}

	public int getQuantity() {return quantity;}

	public void setQuantity(int quantity) {this.quantity = quantity;}

	public double getPrice() {return price;}

	public void setPrice(double price) {this.price = price;}
	
	//ghi đè toString để trả về chuỗi:
	@Override
	public String toString() {
		return this.IDcode + " | " + this.title + " | " + this.quantity + " | " + this.price;
	}
	
	//ghi đè phần so sánh:
	@Override
	public int compareTo(Product p) {
		return (this.getIDcode()).compareTo(p.getIDcode());
	}

}