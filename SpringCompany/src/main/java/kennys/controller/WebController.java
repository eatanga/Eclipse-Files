package kennys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kennys.beans.Department;
import kennys.repository.DepartmentRepository;



@Controller
public class WebController {
	@Autowired
	DepartmentRepository repo;
	
	@GetMapping({"/", "viewAll"})
	public String viewAllDepartments(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewDepartment(model);
		}
		model.addAttribute("departments", repo.findAll());
		return "results";
	}
	@GetMapping("/inputDepartment")
	public String addNewDepartment(Model model) {
		Department c = new Department();
		model.addAttribute("newDepartment", c);
		return "input";
	}
	@PostMapping("/inputContact")
	public String addNewDepartment(@ModelAttribute Department c, Model model) {
		repo.save(c);
		return viewAllDepartments(model);
	}
	@GetMapping("/edit/{id}")
	public String showUpdateDepartment(@PathVariable("id") long id, Model model) {
		Department c = repo.findById(id).orElse(null);
		model.addAttribute("newDepartment", c);
		return "input";
	}
	@PostMapping("/update/{id}")
	public String reviseContact(Department c, Model model) {
		repo.save(c);
		return viewAllDepartments(model);
	}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Department c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllDepartments(model);
	}
	
}
