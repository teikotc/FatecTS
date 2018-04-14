package br.emprestimo.testeUnitario;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.modelo.Emprestimo;
import br.emprestimo.modelo.Livro;
import br.emprestimo.modelo.Usuario;
import br.emprestimo.servico.ServicoEmprestimo;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class UC01RegistraEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;
	static private Emprestimo emprestimo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		usuario.setRa("11111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
		emprestimo = new Emprestimo();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test
	public void CT01UC01FB_registrar_emprestimo_com_sucesso() {
		assertNotNull(servico.empresta(livro, usuario));
	}
	@Test(expected=RuntimeException.class)
	public void CT02UC01FB_registrar_emprestimo_com_dados_invalidos() {
		assertNotNull(servico.empresta(null, usuario));
	}
	@Test
	public void CT03UC01FB_registrar_emprestimo_com_dados_invalidos(){
		try{
			servico.empresta(null, usuario);
			fail ("deveria lan�ar uma exce��o");
		}catch(RuntimeException e){
			assertEquals("Dados inv�lidos.", e.getMessage());
		}
	}
	@Test
	public void CT04UC01FB_registrar_emprestimo_com_sucesso_validacao_da_data() {
		//acao
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/YYYY");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		emprestimo = servico.empresta(livro, usuario);
		String dataObtida = emprestimo.getDataDevolucao();
		//verificacao
	    assertTrue(dataEsperada.equals(dataObtida));
	}
	
	@Test(expected = RuntimeException.class)
	public void CT05UC01Livro_com_nome_invalido_nulo(){
		emprestimo.setLivro(null);
	}
	
	@Test
	public void CT06UC01Livro_valido(){
		equals(emprestimo.getLivro());
	}
	
	@Test
	public void CT07UC01FB_registrar_emprestimo_com_data_valida(){
		assertTrue(emprestimo.validaData("29/03/2000"));
	}
	
	@Test
	public void CT08UC01FB_registrar_emprestimo_com_data_invalida(){
		Emprestimo emprestimo2 = new Emprestimo();
		try{
			emprestimo2.setDataEmprestimo("30/02/2000");
			fail ("Deveria lan�ar uma exce��o");
		}catch (Exception e){
			assertEquals("Data invalida", e.getMessage());
		}
	}
	
	@Test
	public void CT09UC01RegistrarEmprestimo_com_data_invalida(){
		assertTrue(emprestimo.validaData("30-02-2000"));
	}
	
	
	@Test(expected = RuntimeException.class)
	public void CT09UC01FB_registrar_emprestimo_com_data_invalida(){
		emprestimo.validaData(null);
	}
	
	
	@Test(expected = RuntimeException.class)
	public void CT10UC01Usuario_invalido(){
		emprestimo.setUsuario(null);
	}
	
	@Test(expected = RuntimeException.class)
	public void CT14Livro_invalidoNulo(){
		emprestimo.setLivro(null);
	}
	
	
	@Test
	public void CT11UC01Usuario_invalido(){
		equals(emprestimo.getUsuario());
	}
	

}
