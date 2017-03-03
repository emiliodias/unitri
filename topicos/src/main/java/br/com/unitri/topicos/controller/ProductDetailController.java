package br.com.unitri.topicos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.unitri.topicos.model.Produto;

@Controller
public class ProductDetailController {

	@RequestMapping("/productDetail/{id}")
	public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") Long id) {

		List<Produto> produtos = new ArrayList<Produto>();
		
		Produto p1 = new Produto();
		p1.setNome("Roupa 1");
		p1.setValor("R$ 50,00");
		p1.setDescricao("Roupa muito boa.");
		
		produtos.add(p1);
		
		ModelAndView modelView = new ModelAndView("product-details");
		//modelView.addObject("produtos", produtos);
		
		return modelView;
	}
	
}