package exercicio7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GerenteTest {
	

	@Test
	void testBonificacao() {
		Gerente gerente = new Gerente("Carla", 7000, 40);
		double bonificacao = gerente.bonificacao();
		assertEquals(17000.0, bonificacao);
	}

}
