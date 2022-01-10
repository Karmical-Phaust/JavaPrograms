public class Department {
	
	String departmentCode;
	String departmentName;
	int employeeNumber;
	
	public Department(String deCode, String deName, int employees) {
		departmentCode = deCode;
		departmentName = deName;
		employeeNumber = employees;
	}
	
	public String toString() {
		System.out.println("Department's name: " + departmentName);
		System.out.println("Department's code: " + departmentCode);
		System.out.println("Number of employees: " + employeeNumber);
		return null;
	}
}
