package br.usjt.arqsw18.pipoca.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.arqsw18.pipoca.model.entity.Filme;
import br.usjt.arqsw18.pipoca.model.entity.Genero;
import br.usjt.arqsw18.pipoca.model.service.FilmeService;
import br.usjt.arqsw18.pipoca.model.service.GeneroService;

@Controller
public class ManterFilmesController {
	
	private FilmeService filmeService;
	private GeneroService generoService;
	public ManterFilmesController() {
		filmeService = new FilmeService();
	}
	
	@RequestMapping("/inserir")
	public String inserirFilme(Filme filme, Model model) {
		try {
			
			filme = filmeService.inserirFilme(filme);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
		model.addAttribute("filme",filme);
		return "Resultado";
	}
	
	@RequestMapping("/novo")
	public String novoFilme(Model model) {
		try {
			generoService = new GeneroService();
			ArrayList<Genero> generos = generoService.listarGeneros();
			model.addAttribute("generos", generos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "NovoFilme";
	}

}
