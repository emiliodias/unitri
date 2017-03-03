package br.com.unitri.topicos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.unitri.topicos.model.Produto;

@Controller
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response) {

		List<Produto> produtos = new ArrayList<Produto>();
		
		Produto p1 = new Produto();
		p1.setId(1l);
		p1.setNome("Roupa 1");
		p1.setValor("R$ 50,00");
		p1.setDescricao("Roupa muito boa.");
		
		Produto p2 = new Produto();
		p2.setId(2l);
		p2.setNome("Roupa 2");
		p2.setValor("R$ 50,00");
		p2.setDescricao("Roupa muito boa.");
		
		produtos.add(p1);
		produtos.add(p2);
		
		ModelAndView modelView = new ModelAndView("index");
		modelView.addObject("produtos", produtos);
		
		return modelView;
	}
	
}