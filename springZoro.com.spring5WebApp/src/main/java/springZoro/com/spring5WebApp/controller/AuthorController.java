package springZoro.com.spring5WebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springZoro.com.spring5WebApp.repositories.AuthorRepository;





@Controller
public class AuthorController {

	
	private AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		 
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model){
		
		model.addAttribute("authors", authorRepository.findAll());
		
		return "authors";
	}
}

