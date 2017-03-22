package br.com.unitri.estudos.vendas;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {
	
	private static List<Usuario> usuarios = new ArrayList<Usuario>();

	public static String salvar(Usuario usuario) {
		
		usuarios.add(usuario);
		
		return usuario.getId();
	}
	
	public static Usuario buscaPorId(String id) {
		
		for(Usuario usuario : usuarios) {
			if(usuario.getId() == id)
				return usuario;
		}
		
		throw new RuntimeException("Usuario não encontrado.");
	}
	
	public static Usuario buscaPorNome(String nome) {
		
		for(Usuario usuario : usuarios) {
			if(usuario.getNome().equals(nome))
				return usuario;
		}
		
		throw new RuntimeException("Usuario não encontrado.");
	}
	
}
