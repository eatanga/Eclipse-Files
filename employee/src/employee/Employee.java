package employee;

public class Employee {
		private String name;
		private double monthlySalary;
		private int age;

//no arg default constructor	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	//constructor that sets name instance
	public Employee(String name) {
		this.name = name;
	}
	
	public double calculateYearlySalary(Employee employee) {
		double yearlySalary = 0;
		yearlySalary = employee.getMonthlySalary() * 12;
		return yearlySalary;

	}

	public double calculateAppraisal(Employee employee) {
		double appraisal = 0;

		if (employee.getMonthlySalary() < 10000) {
			appraisal = 500;
		} else {
			appraisal = 1000;
		}

		return appraisal;
	}

//getters and setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getMonthlySalary() {
		return monthlySalary;
	}


	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	
}
