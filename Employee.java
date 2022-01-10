public class Employee extends Staff implements ICalculator, Comparable<Employee> {
	
	double extraHours;
	private double EmSalary;
	private int CompareSalary;
	
	public Employee(String ID, String name, int age, double CoefSalary, String start, String de, int abs, double extraHours) {
		super.staffID = ID;
		super.staffName = name;
		super.staffAge = age;
		super.staffCoefSalary = CoefSalary;
		super.startDate = start;
		super.department = de;
		super.absents = abs;
		this.extraHours = extraHours;
	}
	
	public void displayInformation() {
		System.out.println("Employee's ID: " + super.staffID);
		System.out.println("Employee's name: " + super.staffName);
		System.out.println("Employee's age: " + super.staffAge);
		System.out.println("Employee's coefficients salary: " + super.staffCoefSalary);
		System.out.println("Employee's first date of work: " + super.startDate);
		System.out.println("Employee's department: " + super.department);
		System.out.println("Employee's absent dates: " + super.absents);
	}
	
	public double calculateSalary() {
		this.EmSalary = ((super.staffCoefSalary * 3000000) + (extraHours * 200000));
		return this.EmSalary;
	}
	
	public String getDepartment() {
		return super.department;
	}
	
	public String getName() {
		return super.staffName;
	}
	
	public String getID() {
		return super.staffID;
	}
	
	public Integer getSa() {
		this.CompareSalary = (int)this.EmSalary;
		return this.CompareSalary;
	}
	
	@Override
    public int compareTo(Employee em) {
        return this.getSa().compareTo(em.getSa());
    }
}