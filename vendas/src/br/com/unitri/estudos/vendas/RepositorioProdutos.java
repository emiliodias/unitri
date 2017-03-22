package br.com.unitri.estudos.vendas;

import java.util.ArrayList;
import java.util.List;

public class RepositorioProdutos {
	
	private static List<Produto> produtos = new ArrayList<Produto>();
	
	public static void salvar(Produto produto) {
		produtos.add(produto);
	}
	
}