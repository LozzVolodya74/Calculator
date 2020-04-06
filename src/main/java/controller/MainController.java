package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import services.Service;


@Controller
public class MainController {
	
	@RequestMapping(value = "/main")
	public String main (Model model) {
		model.addAttribute("data", "0");
		return "main-page";
	}
	
	@Autowired
	private Service service;
	
	@RequestMapping(value = "/data/{press}")
	public String data (@PathVariable String press, Model model) {
		
		String rez = "";
        if (!press.equals("=")) {
            service.setUserInput(press);
            rez = service.getUserInput();
        } else {
        	service.setUserInput(press);
            rez = service.getResult();
        }
		model.addAttribute("data", rez);
		return "main-page";
	}
	
}
