package exercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LivroTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private Livro livro;
	
	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	void testCalculaImpostoTemaEducativo() {
		livro = new Livro();
		livro.setNome("JAVA POO");
		livro.setPreco(20);
		livro.setQtd(50);
		livro.setAutor("GFT");
		livro.setTema("educativo");
		livro.setQtdPag(500);
		livro.calculaImposto();
		
		assertEquals("Livros educativos nao possuem imposto, dessa forma, o imposto do livro JAVA POO de tema educativo sera de 00.00 reais.", outputStreamCaptor.toString()
			      .trim());
		
	}
	

	@Test
	void testCalculaImpostoTemaNaoEducativo() {
		livro = new Livro("Senhor dos Aneis", 60, 30,"J. R. R. Tolkien", "fantasia", 500);
		livro.calculaImposto();
		
		assertEquals("O imposto do livro Senhor dos Aneis de tema fantasia sera de 6,00 reais.", outputStreamCaptor.toString()
			      .trim());
		
	}

}
