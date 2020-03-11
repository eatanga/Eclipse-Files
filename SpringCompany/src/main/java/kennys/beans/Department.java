package kennys.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import kennys.beans.Employee;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String departmentName;
	private String departmentPhone;
	private String departmentBranch;
	@Autowired
	private Employee employee;
	
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
		this.departmentBranch = "Des Moines";
	}
	 public Department(String departmentName) {
		 super();
		 this.departmentName = departmentName;
	 }
	public Department( String departmentName, String departmentPhone, String departmentBranch) {
		super();
		this.departmentName = departmentName;
		this.departmentPhone = departmentPhone;
		this.departmentBranch = departmentBranch;
	
	}
	public Department(long id, String departmentName, String departmentPhone, String departmentBranch) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentPhone = departmentPhone;
		this.departmentBranch = departmentBranch;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentPhone() {
		return departmentPhone;
	}
	public void setDepartmentPhone(String departmentPhone) {
		this.departmentPhone = departmentPhone;
	}
	public String getDepartmentBranch() {
		return departmentBranch;
	}
	public void setDepartmentBranch(String departmentBranch) {
		this.departmentBranch = departmentBranch;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", departmentPhone=" + departmentPhone
				+ ", departmentBranch=" + departmentBranch + ", employee=" + employee + "]";
	}
	

	
}
