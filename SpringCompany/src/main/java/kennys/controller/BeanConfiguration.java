package kennys.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kennys.beans.Department;
import kennys.beans.Employee;



@Configuration
public class BeanConfiguration {
	@Bean
	public Department department() {
		Department bean = new Department("Fresh Vegetables");
		// bean.setDepartmentName("Fresh Vegetables");
		// bean.setDepartmentPhone("888-888-888");
		// bean.departmentBranch("Algona");
		return bean;
	}

	@Bean
	public Employee address() {
		Employee bean = new Employee("James Carter", "Manager", "Alpha 003");
	return bean;
	}

}
