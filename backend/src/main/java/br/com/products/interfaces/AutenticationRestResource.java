package br.com.products.interfaces;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class AutenticationRestResource {
	@GetMapping("/auth")
	public String getAll() {
		return "GetAll";
	}
	
	@PostMapping("")
	public String postAuth() {
		return "postAll";
	}
	
	
}
