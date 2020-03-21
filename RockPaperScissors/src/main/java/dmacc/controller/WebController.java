package dmacc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.beans.Game;

@Controller
public class WebController {
	@GetMapping("/playagame")
	public String playGame(@RequestParam(name="choice",required=false) String theChoice, Model model) {
	if(theChoice == null) {
		return "index";
	}
	Game theOutcome = new Game(theChoice);
	model.addAttribute("game", theOutcome);
	return "results";
	}

}
