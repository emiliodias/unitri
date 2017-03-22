package br.com.unitri.estudos.vendas;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPedidos {
	
	private static List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public static void salvar(Pedido pedido) {
		pedidos.add(pedido);
	}
	
}
