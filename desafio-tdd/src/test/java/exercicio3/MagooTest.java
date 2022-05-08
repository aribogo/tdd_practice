package exercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

class MagooTest {

	@Mock
	private MyRandomUtility myRandomUtilityMock = mock(MyRandomUtility.class);

	@InjectMocks
	private Mago mago; 

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
	Personagem personagem = new Personagem();	
	
	@BeforeEach
	public void setUp() {
		Mago amy = new Mago("Amy", 100, 10, 10, 10, 3, 1);
		Guerreiro elesis = new Guerreiro("Elesis", 100, 3, 10, 3, 10, 1);
		Guerreiro lass = new Guerreiro("Lass", 100, 3, 10, 3, 10, 1);
		mago = new Mago("Arme", 100, 10, 10, 10, 3, 1, myRandomUtilityMock);
		System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@Test
	void testGetTotalPersonagens() {
		
		int totalPersonagens = personagem.getTotalPersonagens();
		
		assertEquals(4, totalPersonagens);

	}

	@Test
	void testAttack() {
		
		Mockito.lenient().when(myRandomUtilityMock.getRandom()).thenReturn(10);
		
		mago.attack();	
		
		assertEquals("O ataque foi de 20 pontos.", outputStreamCaptor.toString()
			      .trim());
	}
	
	@Test
	void testLvlUp() {
		mago.lvlUp();
		
		assertEquals(2, mago.getLevel());
		assertEquals(20, mago.getMana());
		assertEquals(20, mago.getInteligencia());
		assertEquals(6, mago.getForca());
		assertEquals(105, mago.getVida());
	}
	

	@Test
	void testAprenderHabilidade() {
		mago.aprenderMagia("Nevoa sombria");
		
		assertEquals("[Nevoa sombria]", mago.getMagia().toString());
	}

	@Test
	void testListarHabilidades() {
		mago.aprenderMagia("Nevoa sombria");
		mago.aprenderMagia("Teleportar");
		
		mago.listarMagias();
		
		assertEquals("Nevoa sombria"
				+ "\nTeleportar", outputStreamCaptor.toString()
			      .trim());
	}

	
}
