package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.dadosDeTeste.ObtemLivro;
import br.emprestimo.modelo.Livro;

public class UC06CadastrarLivro {

	private static Livro livro;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		livro = ObtemLivro.comDadosValidos();
		livro = ObtemLivro.comDadosInvalidos_branco();
		livro = ObtemLivro.comISBNInvalido_nulo();
		
	}


	
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test(expected = RuntimeException.class)
	public void CT01UC06CadastrarLivro_com_isbn_invalido_branco() {
		livro.setIsbn("");
	}

	@Test(expected = RuntimeException.class)
	public void CT02UC06CadastrarLivro_com_isbn_invalido_null() {
		livro.setIsbn(null);
	}
	
	@Test
	public void CT03UC06CadastrarLivro_com_isbn_valido(){
		assertEquals("121212", livro.getIsbn());
	}

	@Test(expected = RuntimeException.class)
	public void CT04UC06CadastrarLivro_com_titulo_invalido_branco() {
		livro.setTitulo("");
	}

	@Test(expected = RuntimeException.class)
	public void CT05UC06CadastrarLivro_com_titulo_invalido_null() {
		livro.setTitulo(null);
	}
	
	@Test(expected = RuntimeException.class)
	public void CT06UC06CadastrarLivro_com_autor_invalido_branco(){
		livro.setAutor("");
	}
	
	@Test(expected = RuntimeException.class)
	public void CT07UC06CadastrarLivro_com_autor_invalido_null(){
		livro.setAutor(null);
	}
	
	@Test
	public void CT08UC06CadastrarLivro_com_titulo_valido(){
		assertEquals("Engenharia de Software", livro.getTitulo());
	}
	
	@Test
	public void CT09UC06CadastrarLivro_com_autor_valido(){
		assertEquals("Pressman", livro.getAutor());
	}
	
	

}
