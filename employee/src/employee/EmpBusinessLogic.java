package employee;

public class EmpBusinessLogic {
	public double calculateYearlySalary(Employee employee) {
		return employee.calculateYearlySalary(employee);
	}
	
	public double calculateAppraisal(Employee employee) {
		return employee.calculateAppraisal(employee);
	}

	public boolean isRetirementAge(Employee employee) {
		if(employee.getAge()>=65) {
			return true;
		}else {
			return false;
		}
	}
}
