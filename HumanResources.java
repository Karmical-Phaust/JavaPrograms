import java.util.*;
public class HumanResources {
	
	//phần mã chính - main part:
	public static void main(String[] args) {

		//phần khai báo toàn bộ Scanner và Array list - declaration part:
		
		Scanner i = new Scanner(System.in);
		Scanner ii = new Scanner(System.in);
		Scanner iii = new Scanner(System.in);
		
		Scanner i1 = new Scanner(System.in);
		Scanner i2 = new Scanner(System.in);
		Scanner i3 = new Scanner(System.in);
		Scanner i4 = new Scanner(System.in);
		Scanner i5 = new Scanner(System.in);
		
		ArrayList<Employee> StaffsList = new ArrayList<Employee>();
		ArrayList<Manager> ManagersList = new ArrayList<Manager>();
		ArrayList<Department> DepartmentsList = new ArrayList<Department>();
		
		
		//phần thông tin gốc có sẵn - original information:
		
		Employee a = new Employee("000000", "Test", 18, 1.5, "20/02/202020", "Typo department", 0, 2.5);
		StaffsList.add(a);
		Employee b = new Employee("000001", "Test Clarify", 20, 1.2, "20/02/202020", "Information department", 0, 2.2);
		StaffsList.add(b);
		Employee c = new Employee("000002", "Test Verify", 23, 1, "20/02/202020", "Information department", 0, 2);
		StaffsList.add(c);
		
		Manager g = new Manager("111111", "Testa", 24, 2, "20/02/181818", "Information department", 0, "Project Leader");
		ManagersList.add(g);
		Manager h = new Manager("111222", "Testam", 25, 2, "20/02/161616", "Typo department", 0, "Technical Leader");
		ManagersList.add(h);
		Manager j = new Manager("222222", "Testament", 28, 2.2, "20/02/101010", "Information department", 0, "Business Leader");
		ManagersList.add(j);
		
		Department d = new Department("020202", "Information department", 200);
		DepartmentsList.add(d);
		Department e = new Department("030303", "Typo department", 75);
		DepartmentsList.add(e);
		Department f = new Department("040404", "Investing department", 40);
		DepartmentsList.add(f);
		
		
		//phần tác vụ chính - main part:
		for (;;) {
		    System.out.print("Please choose a task or q to quit (1 to show employees list, 2 to show managers list, 3 to show departments list, 4 to find staff members by department,\n5 to find a staff member by name or ID, 6 to add a new staff member, \"sort\" to sort all staff members by salary order): ");
		    String ent = i.nextLine();
		    System.out.println();
		    
		    //hiển thị danh sách nhân viên - display employees list:
		    if (ent.equals("1")) {
		    	
		    	staffInfo(StaffsList);
		    	
		    } /*hiển thị danh sách quản lý - display managers list: */ else if (ent.equals("2")) {
		    	
		    	managerInfo(ManagersList);
		    	
		    } /*hiển thị danh sách bộ phận - display departments list: */ else if (ent.equals("3")) {
		    	
		    	departmentInfo(DepartmentsList);
		    	
		    } /*tìm thành viên qua một bộ phận cụ thể - department staff(s) finder: */ else if (ent.equals("4")) {
		    	for (;;) {
					System.out.print("Please enter the correct department name or q to quit: ");
					String deNa = i.nextLine();
					System.out.println();
					if (!deNa.equals("q")) {
				        staffInfoByDe(StaffsList, ManagersList, deNa);
					} else {
						System.out.println("Function closed");
						System.out.println();
						break;
					}
				}
		    } /*tìm thành viên bằng tên hoặc ID - staff finder: */ else if (ent.equals("5")) {
			    	for (;;) {
			    		
						System.out.print("Please enter the name or the ID of the staff member or q to quit: ");
						String name = i.nextLine();
						System.out.println();
						
						if (!name.equals("q")) {
							
					        staffFinder(StaffsList, ManagersList, name);
					        
						} else {
							
							System.out.println("Function closed");
							System.out.println();
							break;
							
						}
					}
		    } /*thêm thành viên - staff adder*/ else if (ent.equals("6")) {
					for (;;) {
						
						System.out.print("Would you like to add a new staff? (1 for yes and 2 for no): ");
						String yOn = ii.next();
						System.out.println();
						
						if (yOn.equals("1")) {
							
							System.out.print("Would it be an employee or a manager? (1 for employee or 2 for manager): ");
							String eOm = iii.next();
							System.out.println();
							
							if (eOm.equals("1")) {
								
							    System.out.println("Start adding a new employee: ");
							    newStaff(i1, i2, i3, i4, i5, StaffsList, ManagersList, eOm);
							    
							} else if (eOm.equals("2")) {
								
								System.out.println("Start adding a new manager: ");
								newStaff(i1, i2, i3, i4, i5, StaffsList, ManagersList, eOm);
								
							} else {
								
								System.out.println("No type of staff member found");
								System.out.println();
								
							}
						} else if (yOn.equals("2")) {
							
							System.out.println("Function closed");
							System.out.println();
							break;
							
						} else {
							
							System.out.println("Please enter a valid answer");
							System.out.println();
							
						}
					}
		    } /*hiển thị thông tin thành viên công ty theo thứ tự mức lương - salary ordered staffs info display*/ else if (ent.equals("sort")) {
		    	
		    	System.out.print("Would you like to see employees list or managers list? (1 for employee or 2 for manager): ");
		    	String oOt = ii.next();
		    	System.out.println();
		    	
		    	if (oOt.equals("1")) {
		    		for (;;) {
		    			
		    			System.out.print("In which order? (1 for ascending or 2 for descending): ");
		    			String aOd = iii.next();
		    			System.out.println();
		    			
		    			if (aOd.equals("1")) {
		    				
		    	            EmSalarySort(StaffsList, aOd);
		    	            break;
		    	            
		    			} else if (aOd.equals("2")) {
		    				
		    	            EmSalarySort(StaffsList, aOd);
		    	            break;
		    	            
		    			} else {
		    				
		    				System.out.println("Please enter a valid input");
		    				System.out.println();
		    				
		    			}
		    		}
		    	} else if (oOt.equals("2")) {
		    		for (;;) {
		    			
		    			System.out.print("In which order? (1 for ascending or 2 for descending): ");
		    			String aOd = iii.next();
		    			System.out.println();
		    			
		    			if (aOd.equals("1")) {
		    				
		    				MaSalarySort(ManagersList, aOd);
		    	            break;
		    	            
		    			} else if (aOd.equals("2")) {
		    				
		    				MaSalarySort(ManagersList, aOd);
		    	            break;
		    	            
		    			} else {
		    				
		    				System.out.println("Please enter a valid input");
		    				System.out.println();
		    				
		    			}
		    		}
		    	} else {
		    		
					System.out.println("No valid list found");
					System.out.println();
					
				}
		    } else if (ent.equals("q")) {
		    	
		    	System.out.println("Function closed");
				System.out.println();
		    	break;
		    	
		    } else {
		    	
		    	System.out.println("No function found");
		    	System.out.println();
		    	
		    }
		}

	}
	
	//phần hàm hiển thị danh sách nhân viên - employees info display:
	public static void staffInfo(ArrayList<Employee> StaffsList) {
		for (int i = 0; i < StaffsList.size() ; i++) {
			
			StaffsList.get(i).displayInformation();
			System.out.println("Employee's salary: " + String.format("%.1f", StaffsList.get(i).calculateSalary()));
			System.out.println();
			
		}
	}
	
	//phần hàm hiển thị danh sách quản lý - managers info display:
	public static void managerInfo(ArrayList<Manager> ManagersList) {
		for (int i = 0; i < ManagersList.size() ; i++) {
			
			ManagersList.get(i).displayInformation();
			
			System.out.println("Manager's salary: " + String.format("%.1f", ManagersList.get(i).calculateSalary()));
			System.out.println();
			
		}
	}
	
	//phần hàm hiển thị danh sách các bộ phận - departments info display:
	public static void departmentInfo(ArrayList<Department> DepartmentsList) {
		for (int i = 0; i < DepartmentsList.size() ; i++) {
			
			DepartmentsList.get(i).toString();
			System.out.println();
			
		}
	}
	
	//phần hàm tìm các thành viên của một bộ phận cụ thể - find staff info by department:
	public static void staffInfoByDe(ArrayList<Employee> StaffsList, ArrayList<Manager> ManagersList, String dep) {
		int count = 0;
		
		for (int i = 0; i < StaffsList.size() ; i++) {
			if (StaffsList.get(i).getDepartment().equals(dep)) {
				
			    StaffsList.get(i).displayInformation();
			    System.out.println("Employee's salary: " + String.format("%.1f", StaffsList.get(i).calculateSalary()));    
			    System.out.println();
			    count++;
			    
			}
		}
		
		for (int i = 0; i < ManagersList.size(); i++) {
			if (ManagersList.get(i).getDepartment().equals(dep)) {
				
				ManagersList.get(i).displayInformation();
				System.out.println("Manager's salary: " + String.format("%.1f", ManagersList.get(i).calculateSalary()));
				System.out.println();
				count++;
				
			}
		}
		
		if (count == 0) {
			
			System.out.println("No staff info or department found");
			System.out.println();
			
		}
		
		count = 0;
	}
	
	//phần hàm tìm thành viên trong công ty bằng tên hoặc ID - Name or ID finder:
	public static void staffFinder(ArrayList<Employee> StaffsList, ArrayList<Manager> ManagersList, String in) {
		int count = 0;
		
		for (int i = 0; i < StaffsList.size(); i++) {
			if (StaffsList.get(i).getName().equals(in) || StaffsList.get(i).getID().equals(in)) {
				
				StaffsList.get(i).displayInformation();
				System.out.println("Employee's salary: " + String.format("%.1f", StaffsList.get(i).calculateSalary()));
				System.out.println();
				count++;
				
			}
		}
		
		for (int i = 0; i < ManagersList.size(); i++) {
			if (ManagersList.get(i).getName().equals(in) || ManagersList.get(i).getID().equals(in)) {
				
				ManagersList.get(i).displayInformation();
				System.out.println("Manager's salary: " + String.format("%.1f", ManagersList.get(i).calculateSalary()));
				System.out.println();
				count++;
				
			}
		}
		
		if (count == 0) {
			
			System.out.println("No employee or manager found");
			System.out.println();
			
		}
		
		count = 0;
	}
	
	//phần hàm thêm thành viên - staff adder:
	public static void newStaff(Scanner i1, Scanner i2, Scanner i3, Scanner i4, Scanner i5, ArrayList<Employee> StaffsList, ArrayList<Manager> ManagersList, String eOm) {
		System.out.print("Nhập ID nhân viên: ");
		String id = i1.next();
		
		System.out.print("Nhập tên nhân viên: ");
		String name = i2.nextLine();
		
		System.out.print("Nhập số tuổi nhân viên: ");
		int age = i2.nextInt();
		
		System.out.print("Nhập hệ số lương của nhân viên: ");
		double coefSa = i3.nextDouble();
		
		System.out.print("Nhập ngày bắt đầu nhân viên: ");
		String stDa = i4.nextLine();
		
		System.out.print("Nhập cơ sở của nhân viên: ");
		String Dept = i4.nextLine();
		
		System.out.print("Nhập số ngày nghỉ: ");
		int abs = i2.nextInt();
		
		System.out.print("Nhập số giờ làm thêm: ");
		double eH = i3.nextDouble();
		
		Employee em = new Employee(id, name, age, coefSa, stDa, Dept, abs, eH);
		StaffsList.add(em);
	}
	
	//phần hàm hiển thị các nhân viên theo thứ tự lương - salary order display of employees info:
	public static void EmSalarySort(ArrayList<Employee> StaffsList, String aOd) {
		for (int i = 0; i < StaffsList.size(); i++) {
			StaffsList.get(i).calculateSalary();
		}
		
		if (aOd.equals("1")) {
		    Collections.sort(StaffsList);
		} else if (aOd.equals("2")) {
			Collections.sort(StaffsList, Collections.reverseOrder());
		}
		
		for (int co = 0; co < StaffsList.size(); co++) {
			
		    StaffsList.get(co).displayInformation();
		    System.out.println("Employee's salary: " + String.format("%.2f", StaffsList.get(co).calculateSalary()));
		    System.out.println();
		    
		}
	}
	
	//phần hàm hiển thị các quản lý theo thứ tự lương - salary order display of managers info:
	public static void MaSalarySort(ArrayList<Manager> ManagersList, String aOd) {
		for (int i = 0; i < ManagersList.size(); i++) {
			ManagersList.get(i).calculateSalary();
		}
		
		if (aOd.equals("1")) {
			Collections.sort(ManagersList);
		} else if (aOd.equals("2")) {
			Collections.sort(ManagersList, Collections.reverseOrder());
		}
		
		for (int co = 0; co < ManagersList.size(); co++) {
			
			ManagersList.get(co).displayInformation();
		    System.out.println("Employee's salary: " + ManagersList.get(co).calculateSalary());
		    System.out.println();
		    
		}
	}

}