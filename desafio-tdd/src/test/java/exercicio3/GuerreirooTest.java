package exercicio3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

class GuerreirooTest {

	@Mock
	private MyRandomUtility myRandomUtilityMock = mock(MyRandomUtility.class);
	
	@InjectMocks
	private Guerreiro guerreiro;

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		guerreiro = new Guerreiro("Elesis", 100, 3, 10, 3, 10, 1, myRandomUtilityMock);
		System.setOut(new PrintStream(outputStreamCaptor));
	}


	@Test
	void testLvlUp() {
		guerreiro.lvlUp();

		assertEquals(2, guerreiro.getLevel());
		assertEquals(6, guerreiro.getMana());
		assertEquals(8, guerreiro.getInteligencia());
		assertEquals(20, guerreiro.getForca());
		assertEquals(110, guerreiro.getVida());
	}
	
	@Test
	void testAttack() {
		
		Mockito.lenient().when(myRandomUtilityMock.getRandom()).thenReturn(10);
		
		guerreiro.attack();	
		
		assertEquals("O ataque foi de 20 pontos.", outputStreamCaptor.toString()
			      .trim());
	}

	@Test
	void testAprenderHabilidade() {
		guerreiro.aprenderHabilidade("Trilha de Espadachim");

		assertEquals("[Trilha de Espadachim]", guerreiro.getHabilidades().toString());
	}

	@Test
	void testListarHabilidades() {
		guerreiro.aprenderHabilidade("Trilha de Espadachim");
		guerreiro.aprenderHabilidade("Corte em cruz");

		guerreiro.listarHabilidades();

		assertEquals("Trilha de Espadachim" + "\nCorte em cruz", outputStreamCaptor.toString().trim());

	}

}
