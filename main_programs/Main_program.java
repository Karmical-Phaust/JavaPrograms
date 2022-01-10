package main_programs;

import java.util.*;
import nodes_and_data_structures.*;

//phần chương trình chính:
public class Main_program {

	public static String src = "src/Data/";
	
	public static void main(String[] args) {
		
		Scanner i = new Scanner(System.in);
		boolean exit = false;
		boolean loaded = false;
		Linked_list a = null;
		while (true) {
			showMenu();
			int choice = i.nextInt();
			switch (choice) {
				case 0:
					exit = true;
					break;
				case 1:
					System.out.println();
					System.out.println("File data list: ");
					showList();
					if (!loaded) {
						a = loadToLl();
						loaded = true;
					} else {
						System.out.println();
						loadToLl();
					}
					break;
				case 2:
					if (loaded) {
						System.out.println();
						saveLlToFile(a);
						System.out.println("Saved the current list!!");
						System.out.println();
					} else {deNull();}
					break;
				case 3:
					if (loaded) {
						System.out.println();
						System.out.println("Current list: ");
						showList();
						System.out.println(a);
					} else {deNull();}
					break;
				case 4:
					if (loaded) {
						System.out.println();
						inputLl(a, exit);
						System.out.println();
					} else {deNull();}
					break;
				case 5:
					if (loaded) {
						System.out.println();
						searchByID(a, exit);
						System.out.println();
					} else {deNull();}
					break;
				case 6:
					if (loaded) {
						System.out.println();
						deleteByID(a, exit);
						System.out.println();
					} else {deNull();}
					break;
				case 7:
					if (loaded) {
						System.out.println();
						System.out.println("Sorted list: ");
						returnSortedLl(a);
						System.out.println();
					} else {deNull();}
					break;
				case 8:
					if (loaded) {
						System.out.println();
						System.out.print("First product's quantity (" + a.getFirst().getQuantity() + ") to binary: ");
						quantToBinary(a);
						System.out.println();
						System.out.println();
					} else {deNull();}
					break;
				case 9:
					System.out.println();
					System.out.println("File data stack: ");
					showList();
					loadToStack();
					break;
				case 10:
					System.out.println();
					System.out.println("File data list: ");
					showList();
					loadToQueue();
					break;
				default:
					System.out.println();
					System.out.println("There's no such option...");
					System.out.println();
					break;
			}
			
			if (exit) {
				inputLl(a, exit);
				System.out.println();
				System.out.println("Bye!");
				i.close();
				break;
			}
		}
	
	}
	
	//các phần chương trình phụ: 
	public static void showMenu() {
		System.out.println("Option list:");
		System.out.println("1. Load data from file and display");
		System.out.println("2. Save product list to file");
		System.out.println("3. Display current linked list data");
		System.out.println("4. Input & add to the end of current list");
		System.out.println("5. Search product by ID");
		System.out.println("6. Delete product by ID");
		System.out.println("7. Sort products by ID");
		System.out.println("8. Convert first product's quantity to binary");
		System.out.println("9. Load file data to stack and display");
		System.out.println("10. Load file data to queue and display");
		System.out.println("0. Exit");
		System.out.print("Choose one of this options: ");
		 }
	
	public static void showList() {
		System.out.println("ID | Title | Quantity | Price");
	}
	
	public static void deNull() {
		System.out.println();
		System.out.println("There's no linked list!!");
		System.out.println();
	}
	
	//tải lên danh sách móc nối:
	public static Linked_list loadToLl() {
		String[] str = IO_program.inputReadFromFiles(src + "data.txt");
		Linked_list a = new Linked_list();
		for (int i = 0; i < str.length; i++) {
			String[] fls = str[i].split("\\|" + "\\s", 0);
			fls[0] = fls[0].replaceAll("\\s", "");
			a.insertTail(fls[0],fls[1], reInt(fls[2]), reDb(fls[3]));
		}
		System.out.println(a);
		return a;
	}
	
	//nhập dữ liệu:
	public static void inputLl(Linked_list a, boolean exit) {
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		Scanner nums = new Scanner(System.in);
		if (!exit) {
			System.out.print("Input new ID: ");
			String id = s1.next();
			System.out.print("Input Product's Name: ");
			String title = s2.nextLine();
			System.out.print("Input Product's quantity: ");
			int quant = nums.nextInt();
			System.out.print("Input Product's price: ");
			double p = nums.nextDouble();
			a.insertTail(id, title, quant, p);
		} else {
			s1.close();
			s2.close();
			nums.close();
		}
	}
	
	//lưu dữ liệu:
	public static void saveLlToFile(Linked_list a) {
		IO_program.outputWriteToFiles(src + "data.txt", a);
	}
	
	public static int reInt(String a) {
		a = a.replaceAll(" ", "");
		return Integer.parseInt(a);
	}
	
	public static double reDb(String a) {
		a = a.replaceAll(" ", "");
		return Double.parseDouble(a);
	}
	
	//tìm kiếm:
	public static void searchByID(Linked_list a, boolean exit) {
		Scanner iI = new Scanner(System.in);
		if (!exit) {
			System.out.print("Input ID to search: ");
			String id = iI.next();
			Product res = a.search(id);
			if (res != null) {
				System.out.println("Product information: " + res);
			} else {
				System.out.println("No product matches");
			}
		} else {iI.close();}
	}
	
	//xóa dữ liệu:
	public static void deleteByID(Linked_list a, boolean exit) {
		Scanner iI = new Scanner(System.in);
		if (!exit) {
			System.out.print("Input ID to delete: ");
			String id = iI.next();
			boolean dOn = a.deleteByID(id);
			if (dOn) {
				System.out.println("Item deleted!");
			} else {
				System.out.println("No product matches");
			}
		} else {iI.close();}
	}
	
	
	public static Product[] mergeSortLl(Linked_list a) {
		Product[] prs = a.iter();
		prs = Algorithms.mSort(prs);
		return prs;
	}
	
	//sắp xếp tăng dần bằng thuật toán sắp xếp trộn:
	public static void returnSortedLl(Linked_list a) {
		Product[] prs = mergeSortLl(a);
		a.resetLl();
		for (int c = 0; c < prs.length; c++) {
			a.insertTail(prs[c]);
		}
		System.out.println(a);
	}
	
	//chuyển số lượng từ số nguyên sang nhị phân:
	public static void quantToBinary(Linked_list a) {
		int quant = a.getFirst().getQuantity();
		BiStack b = new BiStack();
		toBinary(quant, b);
		int[] res = b.popAll();
		for (int c = 0; c < res.length; c++) {System.out.print(res[c]);}
	}
	
	public static void toBinary(int i, BiStack stk) {
		if (i == 0) {stk.push(i); return;}
		stk.push(i%2);
		toBinary(i/2, stk);
	}
	
	//tải lên ngăn xếp (ngược):
	public static void loadToStack() {
		String[] str = IO_program.inputReadFromFiles(src + "data.txt");
		MyStack stk = new MyStack();
		for (int i = 0; i < str.length; i++) {
			String[] fls = str[i].split("\\|" + "\\s", 0);
			fls[0] = fls[0].replaceAll(" ", "");
			stk.push(new Product(fls[0], fls[1], reInt(fls[2]), reDb(fls[3]) ));
		}
		System.out.println(stk);
	}
	
	//tải lên hàng:
	public static void loadToQueue() {
		String[] str = IO_program.inputReadFromFiles(src + "data.txt");
		MyQueue que = new MyQueue();
		for (int i = 0; i < str.length; i++) {
			String[] fls = str[i].split("\\|" + "\\s", 0);
			que.enQueue( new Product(fls[0],fls[1], reInt(fls[2]), reDb(fls[3])));
		}
		System.out.println(que);
	}

}