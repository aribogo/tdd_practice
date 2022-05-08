package exercicio2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideoGameTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private VideoGame videoGame;
	
	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	void testCalculaImpostoVideoGameUsado() {
		videoGame = new VideoGame();
		videoGame.setNome("PS4");
		videoGame.setMarca("Sony");
		videoGame.setModelo("Slim");
		videoGame.setPreco(1800);
		videoGame.setQtd(100);
		videoGame.setUsado(true);
		videoGame.calculaImposto();
		
		assertEquals("O imposto do video-game PS4 (usado) sera de 450,00 reais.", outputStreamCaptor.toString()
			      .trim());
		
	}
	
	@Test
	void testCalculaImpostoVideoGameNovo() {
		videoGame = new VideoGame("PS4", 1800, 100, "Sony", "Slim", false);
		videoGame.calculaImposto();
		
		assertEquals("O imposto do video-game PS4 (novo) sera de 810,00 reais.", outputStreamCaptor.toString()
			      .trim());
		
	}

}
