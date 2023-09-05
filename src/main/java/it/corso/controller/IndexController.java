package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.service.UtenteService;

// localhost:8080
@Controller
@RequestMapping("/")
public class IndexController
{
	@Autowired
	private UtenteService utenteService;
	
	@GetMapping
	public String getPage(
			@RequestParam(name = "fe", required = false) String errore,
			Model model)
	{
		model.addAttribute("errore", errore != null);
		return "index";
	}
	
	@PostMapping
	public String registraUtente(
			@RequestParam("nome") String nome,
			@RequestParam("username") String username,
			@RequestParam("password") String password)
	{
		if(!utenteService.controlloDatiUtente(nome, username, password))
			return "redirect:/?fe";
		utenteService.registrazioneUtente(nome, username, password);
		return "redirect:/";
	}
}