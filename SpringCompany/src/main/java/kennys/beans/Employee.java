package kennys.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Employee {
	
	private String name;
	private String jobPosition;
	private String level;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(String name, String jobPosition, String level) {
		super();
		this.name = name;
		this.jobPosition = jobPosition;
		this.level = level;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getJobPosition() {
		return jobPosition;
	}


	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", jobPosition=" + jobPosition + ", level=" + level + "]";
	}

}
