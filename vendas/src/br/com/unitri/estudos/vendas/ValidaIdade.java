package br.com.unitri.estudos.vendas;

public class ValidaIdade implements RegraPedido {

	public boolean validar(Pedido pedido) {
		
		if(pedido.getComprador().getIdade() < 18) 
			return false;
		
		return true;
	}

}