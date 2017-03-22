package br.com.unitri.estudos.vendas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Pedido {

	private String id;
	
	private List<Produto> produtos = new ArrayList<Produto>();
	
	private Usuario comprador;
	
	private List<RegraPedido> regras = new ArrayList<RegraPedido>();
	
	public Pedido(RegraPedido... regras) {
		
		UUID id = UUID.randomUUID();
		
		this.id = id.toString(); 
		 
		this.regras = Arrays.asList(regras);
	}
	
	public void addProduto(Produto produto) {
		produtos.add(produto);
	}

	public void submeter() {
		
		for(RegraPedido regra : regras) {
			boolean response = regra.validar(this);
			if(response == false)
				throw new RuntimeException("O pedido não pode ser submetido");
		}
		
		RepositorioPedidos.salvar(this);
		
	}

	public String getId() {
		return id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Usuario getComprador() {
		return comprador;
	}


	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}
	
}
