package exercicio7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VendedorTest {


	@Test
	void testBonificacao() {
		Vendedor vendedor = new Vendedor("Marisa", 3000, 20);
		double bonificacao = vendedor.bonificacao();
		assertEquals(6000.0, bonificacao);
	}

}
