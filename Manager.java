public class Manager extends Staff implements ICalculator, Comparable<Manager> {

	String title;
	String title1 = "Business Leader";
	String title2 = "Project Leader";
	String title3 = "Technical Leader";
	private double MaSalary;
	private int CompareSalary;
	
	public Manager(String ID, String name, int age, double CoefSalary, String start, String de, int abs, String title) {
		super.staffID = ID;
		super.staffName = name;
		super.staffAge = age;
		super.staffCoefSalary = CoefSalary;
		super.startDate = start;
		super.department = de;
		super.absents = abs;
		this.title = title;
	}
	
	public void displayInformation() {
		System.out.println("Manager's ID: " + super.staffID);
		System.out.println("Manager's name: " + super.staffName);
		System.out.println("Manager's age: " + super.staffAge);
		System.out.println("Manager's coefficients salary: " + super.staffCoefSalary);
		System.out.println("Manager's first date of work: " + super.startDate);
		System.out.println("Manager's department: " + super.department);
		System.out.println("Manager's absent dates: " + super.absents);
		System.out.println("Manager's title: " + this.title);
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getName() {
		return super.staffName;
	}
	
	public String getID() {
		return super.staffID;
	}
	
	public String getDepartment() {
		return super.department;
	}
	
	public double calculateSalary() {
		if (title.equals(title1) || title.equals(title2) || title.equals(title3)) {
			if (title.equals(title1)) {
				this.MaSalary = ((super.staffCoefSalary * 5000000) + 8000000);
			} else if (title.equals(title2)) {
				this.MaSalary = ((super.staffCoefSalary * 5000000) + 5000000);
			} else {
				this.MaSalary = ((super.staffCoefSalary * 5000000) + 6000000);
			}
			return this.MaSalary;
		} else {
			this.MaSalary = (super.staffCoefSalary * 5000000);
			return this.MaSalary;
		}
	}
	
	public Integer getSa() {
		this.CompareSalary = (int)this.MaSalary;
		return this.CompareSalary;
	}
	
	@Override
    public int compareTo(Manager ma) {
        return this.getSa().compareTo(ma.getSa());
    }

}
