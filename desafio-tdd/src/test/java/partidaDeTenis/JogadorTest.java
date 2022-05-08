package partidaDeTenis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


class JogadorTest {

	@Mock
	private MyRandomUtility myRandomUtilityMock = mock(MyRandomUtility.class);
	
	@InjectMocks
	Jogador jogador;
	
	@BeforeEach
	public void setUp() {
		 jogador = new Jogador("Jogador", myRandomUtilityMock);
	}


	@Test
	void testJogarRetornando0() {
		Mockito.lenient().when(myRandomUtilityMock.getRandom()).thenReturn(0);
		
		int pontuou = jogador.jogar();
		
		assertEquals(0, pontuou);
	}
	
	@Test
	void testJogarRetornando1() {
		Mockito.lenient().when(myRandomUtilityMock.getRandom()).thenReturn(1);
		
		int pontuou = jogador.jogar();
		
		assertEquals(1, pontuou);
	}

}
