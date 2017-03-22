package br.com.unitri.estudos.vendas;


public class Sistema {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Jose");
		usuario.setIdade(18);
		
		String id = RepositorioUsuarios.salvar(usuario);
		
		Produto produto = new Produto();
		produto.setDescricao("Otimo produto");
		produto.setNome("TV");
		produto.setValor(1234);
		
		RepositorioProdutos.salvar(produto);
		
		Pedido pedido = new Pedido(new ValidaIdade());
		pedido.setComprador(usuario);
		pedido.addProduto(produto);
		
		pedido.submeter();
		
		System.out.println(RepositorioUsuarios.buscaPorNome("Jose").getId());
		
		System.out.println(RepositorioUsuarios.buscaPorId(id).getNome());
		
	}
	
}
