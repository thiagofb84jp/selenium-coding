package br.pb.selenium.seuBarriga.test;

import org.junit.Test;

import static br.pb.selenium.utils.DataGenerator.*;

import br.pb.selenium.core.Core;
import br.pb.selenium.seuBarriga.page.SeuBarrigaPage;

public class SeuBarrigaTest extends Core {
	
	private static final String URL_SEU_BARRIGA = "https://srbarriga.herokuapp.com/login";
	
	SeuBarrigaPage seuBarriga = new SeuBarrigaPage(driver);
	
	public SeuBarrigaTest() {
		driver.get(URL_SEU_BARRIGA);
	}
	
	@Test
	public void adicionarNovoUsuario() {
		seuBarriga.clicarLinkNovoUsuario();
		
		seuBarriga.escreverNome(genNome());
		seuBarriga.escreverEmail(genEmail());
		seuBarriga.escreverSenha(genSenha());
		seuBarriga.cadastrar();
		
		seuBarriga.validarMsgCadastroUsuario("Usuário inserido com sucesso");		
	}
}