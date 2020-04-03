package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Shoe;
import dmacc.repository.ShoeRepository;





@Controller
public class WebController {
	@Autowired
	ShoeRepository repo;
	
	@GetMapping({"/", "viewAll"})
	public String viewAllShoes(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewShoe(model);
		}
		model.addAttribute("shoes", repo.findAll());
		return "results";
	}
	@GetMapping("/inputShoe")
	public String addNewShoe(Model model) {
		Shoe c = new Shoe();
		model.addAttribute("newShoe", c);
		return "input";
	}
	@PostMapping("/inputShoe")
	public String addNewShoe(@ModelAttribute Shoe c, Model model) {
		repo.save(c);
		return viewAllShoes(model);
	}
	@GetMapping("/edit/{id}")
	public String showUpdateShoe(@PathVariable("id") long id, Model model) {
		Shoe c = repo.findById(id).orElse(null);
		model.addAttribute("newShoe", c);
		return "input";
	}
	@PostMapping("/update/{id}")
	public String reviseShoe(Shoe c, Model model) {
		repo.save(c);
		return viewAllShoes(model);
	}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Shoe c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllShoes(model);
	}
	
}