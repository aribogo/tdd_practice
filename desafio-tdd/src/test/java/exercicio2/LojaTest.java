package exercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LojaTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private Loja loja;

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
		loja = new Loja("GFT", "74.428.491/0001-02");
	}

	@Test
	void testListaLivrosVazia() {
		loja.listaLivros();

		assertEquals("A loja no tem livros no seu estoque.", outputStreamCaptor.toString().trim());
	}

	@Test
	void testListaLivros() {

		Livro l2 = new Livro("Senhor dos Aneis", 60, 30, "J. R. R. Tolkien", "fantasia", 500);
		Livro l3 = new Livro("JAVA POO", 20, 50, "GFT", "educativo", 500);

		List<Livro> livros = new ArrayList<Livro>();
		livros.add(l2);
		livros.add(l3);

		loja.setLivros(livros);

		loja.listaLivros();
		
		String output = outputStreamCaptor.toString().trim();

		assertEquals("Livro Senhor dos Aneis, autor J. R. R. Tolkien, tema fantasia, 500 paginas, preco 60.0 reais, quantidade 30"
				+ "\nLivro JAVA POO, autor GFT, tema educativo, 500 paginas, preco 20.0 reais, quantidade 50", output);

	}

	@Test
	void testListaVideoGamesVazia() {
		loja.listaVideoGames();

		assertEquals("A loja no tem video-games no seu estoque.", outputStreamCaptor.toString().trim());
	}
	

	@Test
	void testListaVideoGames() {

		VideoGame ps4Usado = new VideoGame("PS4", 1000, 7, "Sony", "Slim", true);
		VideoGame xbox = new VideoGame("Xbox", 1500, 500, "Microsoft", "One", false);

		List<VideoGame> videoGames = new ArrayList<VideoGame>();
		videoGames.add(ps4Usado);
		videoGames.add(xbox);

		loja.setVideoGames(videoGames);;

		loja.listaVideoGames();
		
		String output = outputStreamCaptor.toString().trim();

		assertEquals("VideoGame PS4, modelo Slim, usado, valor 1000.0, quantidade 7"
				+ "\nVideoGame Xbox, modelo One, novo, valor 1500.0, quantidade 500", output);

	}

	@Test
	void testCalculaPatrimonio() {
		
		Livro l1 = new Livro("Harry Potter", 40, 50, "J.K. Rolling", "fantasia", 300);
		Livro l2 = new Livro("Senhor dos Anis", 60, 30, "J. R. R. Tolkien", "fantasia", 500);
		Livro l3 = new Livro("JAVA POO", 20, 50, "GFT", "educativo", 500);

		
		VideoGame ps4 = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
		VideoGame ps4Usado = new VideoGame("PS4", 1000, 7, "Sony", "Slim", true);
		VideoGame xbox = new VideoGame("Xbox", 1500, 500, "Microsoft", "One", false);

		
		List<Livro> livros = new ArrayList<Livro>();
		livros.add(l3);
		livros.add(l2);
		livros.add(l1);

		
		List<VideoGame> videoGames = new ArrayList<VideoGame>();
		videoGames.add(ps4);
		videoGames.add(ps4Usado);
		videoGames.add(xbox);
		
		loja.setLivros(livros);
		loja.setVideoGames(videoGames);
		
		loja.calculaPatrimonio();
		
		assertEquals("O patrimonio total da loja GFT de 941800,00 reais", outputStreamCaptor.toString().trim());

	}

}
