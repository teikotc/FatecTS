package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.modelo.Usuario;

public class UC07CadastrarUsuario {

	private static Usuario usuario;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usuario = new Usuario();
		usuario.setRa("1010");
		usuario.setNome("João");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test(expected = RuntimeException.class)
	public void CT01UC06CadastrarUsuario_com_nome_invalido_branco(){
		usuario.setNome("");
	}
	
	@Test(expected = RuntimeException.class)
	public void CT02UC06CadastrarUsuario_com_nome_invalido_null() {
		usuario.setNome(null);
	}

	@Test(expected = RuntimeException.class)
	public void CT03UC06CadastrarUsuario_com_ra_invalido_branco(){
		usuario.setRa("");
	}
	
	@Test(expected = RuntimeException.class)
	public void CT04UC06CadastrarUsuario_com_ra_invalido_null(){
		usuario.setRa(null);
	}



}
