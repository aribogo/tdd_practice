package partidaDeTenis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.RETURNS_SELF;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;



class PartidaTest {
	
	@Mock
	private Jogador jogador1 = mock(Jogador.class);
	
	@Mock
	private Jogador jogador2 = mock(Jogador.class); 
	
	
	@InjectMocks
	private Partida partida;
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	
	@BeforeEach
	void setUp() {
		partida = new Partida();
		Mockito.lenient().when(jogador2.getNome()).thenReturn("Mariazinha");
		Mockito.lenient().when(jogador1.getNome()).thenReturn("Carlinhos");
		partida.inicializacaoDaPontuacaoeSet(jogador1, jogador2);
		
	}

	private void outputPrint() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	void testJogadaSemPontuacao() {
		
		Mockito.lenient().when(jogador1.jogar()).thenReturn(0);
		
		outputPrint();
		
		partida.jogada(jogador1, jogador2);
		
		assertEquals("0", partida.getContagemDaPontuacaoDoJogador(jogador1));
		
		assertEquals("Carlinhos não pontuou...", outputStreamCaptor.toString()
			      .trim());
	
	}
	
	@Test
	void testJogadaPontuacaoAbaixo30() {
		
		Mockito.lenient().when(jogador1.jogar()).thenReturn(1);
		
		outputPrint();
		
		partida.jogada(jogador1, jogador2);
		
		assertEquals("15", partida.getContagemDaPontuacaoDoJogador(jogador1));
		
		assertEquals("Carlinhos pontuou! \n Carlinhos : 15 \n Mariazinha : 0", outputStreamCaptor.toString()
			      .trim());
	
	}
	
	@Test
	void testJogadaPontuacaoDeuceComPontuacao30DoJogadorvez() {
		
		Mockito.lenient().when(jogador1.jogar()).thenReturn(1);
		
		Mockito.lenient().when(jogador2.jogar()).thenReturn(1);	
		
		partida.jogada(jogador1, jogador2);
		partida.jogada(jogador1, jogador2);
		
		
		partida.jogada(jogador2, jogador1);
		partida.jogada(jogador2, jogador1);
		partida.jogada(jogador2, jogador1);
		
		
		outputPrint();
		
		partida.jogada(jogador1, jogador2);
		
		assertEquals("Deuce", partida.getContagemDaPontuacaoDoJogador(jogador1));
		
		assertEquals("Carlinhos pontuou! \n Carlinhos : Deuce \n Mariazinha : Deuce", outputStreamCaptor.toString()
			      .trim());
	
	}
	
	@Test
	void testJogadaPontuacaoDeucePontuacaoAdvantageDoAdversário() {
		
		Mockito.lenient().when(jogador1.jogar()).thenReturn(1);
		
		Mockito.lenient().when(jogador2.jogar()).thenReturn(1);	
		
		partida.jogada(jogador1, jogador2);
		partida.jogada(jogador1, jogador2);
		partida.jogada(jogador1, jogador2);
		
		
		partida.jogada(jogador2, jogador1);
		partida.jogada(jogador2, jogador1);
		partida.jogada(jogador2, jogador1);
		partida.jogada(jogador2, jogador1);
		
		
		outputPrint();
		
		partida.jogada(jogador1, jogador2);
		
		assertEquals("Deuce", partida.getContagemDaPontuacaoDoJogador(jogador1));
		
		assertEquals("Carlinhos pontuou! \n Carlinhos : Deuce \n Mariazinha : Deuce", outputStreamCaptor.toString()
			      .trim());
	
	}
	
	@Test
	void testJogadaPontuacao30() {
		
		Mockito.lenient().when(jogador1.jogar()).thenReturn(1);
		
		Mockito.lenient().when(jogador2.jogar()).thenReturn(1);	
		
		partida.jogada(jogador1, jogador2);
		partida.jogada(jogador1, jogador2);
		
		
		partida.jogada(jogador2, jogador1);
		

		outputPrint();
		
		partida.jogada(jogador1, jogador2);
		
		assertEquals("40", partida.getContagemDaPontuacaoDoJogador(jogador1));
		
		assertEquals("Carlinhos pontuou! \n Carlinhos : 40 \n Mariazinha : 15", outputStreamCaptor.toString()
			      .trim());
	
	}
	
	@Test
	void testJogadaPontuacaoAdvantage() {
		
		Mockito.lenient().when(jogador1.jogar()).thenReturn(1);
		
		Mockito.lenient().when(jogador2.jogar()).thenReturn(1);	
		
		partida.jogada(jogador1, jogador2);
		partida.jogada(jogador1, jogador2);
		partida.jogada(jogador1, jogador2);
		
		
		partida.jogada(jogador2, jogador1);
		partida.jogada(jogador2, jogador1);
		partida.jogada(jogador2, jogador1);
		

		outputPrint();
		
		partida.jogada(jogador1, jogador2);
		
		assertEquals("Advantage", partida.getContagemDaPontuacaoDoJogador(jogador1));
		
		assertEquals("Carlinhos pontuou! \n Carlinhos : Advantage \n Mariazinha : 40", outputStreamCaptor.toString()
			      .trim());
	
	}
	
	@Test
	void testJogadaGanhadorAdvantage() {
		
		Mockito.lenient().when(jogador1.jogar()).thenReturn(1);
		
		Mockito.lenient().when(jogador2.jogar()).thenReturn(1);	
		
		partida.jogada(jogador1, jogador2);
		partida.jogada(jogador1, jogador2);
		partida.jogada(jogador1, jogador2);		
		
		partida.jogada(jogador2, jogador1);
		partida.jogada(jogador2, jogador1);
		partida.jogada(jogador2, jogador1);
		
		partida.jogada(jogador1, jogador2);
		

		outputPrint();
		
		partida.jogada(jogador1, jogador2);
		
		assertEquals("0", partida.getContagemDaPontuacaoDoJogador(jogador1));
		
		assertEquals("Carlinhos pontuou! \n Carlinhos : Vencedor \n Mariazinha : Perdedor", outputStreamCaptor.toString()
			      .trim());
	
	}
	
	@Test
	void testJogadaGanhador40() {
		
		Mockito.lenient().when(jogador1.jogar()).thenReturn(1);
		
		Mockito.lenient().when(jogador2.jogar()).thenReturn(1);	
		
		partida.jogada(jogador1, jogador2);
		partida.jogada(jogador1, jogador2);
		partida.jogada(jogador1, jogador2);		
		
		
		partida.jogada(jogador2, jogador1);
		partida.jogada(jogador2, jogador1);

		outputPrint();
		
		partida.jogada(jogador1, jogador2);
		
		assertEquals("0", partida.getContagemDaPontuacaoDoJogador(jogador1));
		
		assertEquals("Carlinhos pontuou! \n Carlinhos : Vencedor \n Mariazinha : Perdedor", outputStreamCaptor.toString()
			      .trim());
	
	}
	
	

}
