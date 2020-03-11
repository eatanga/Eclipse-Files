package kennys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kennys.beans.Department;
import kennys.beans.Employee;
import kennys.controller.BeanConfiguration;
import kennys.repository.DepartmentRepository;


@SpringBootApplication
public class SpringCompanyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringCompanyApplication.class, args);
	
	
	
	  /*ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class); 
	  Department d = appContext.getBean("department",Department.class);
	  System.out.println(d.toString());*/
	} 
	@Autowired
	DepartmentRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);

		// Using an existing bean
		Department a = appContext.getBean("department", Department.class);
		a.setDepartmentBranch("Algoona");
		repo.save(a);

		// Creating a bean to use – not managed by Spring
		Department d = new Department("Dried Fruits", "888-888-887", "Perry");
		Employee e = new Employee("Nikki Johnson", "Senior Manager", "Omega 001");
		d.setEmployee(e);
		repo.save(d);

		List<Department> allMyDepartments = repo.findAll();
		for (Department employees : allMyDepartments) {
			System.out.println(employees.toString());
		}
		((AbstractApplicationContext) appContext).close();
	}
}
