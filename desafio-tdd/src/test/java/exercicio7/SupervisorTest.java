package exercicio7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SupervisorTest {


	@Test
	void testBonificacao() {
		Supervisor supervisor = new Supervisor();
		supervisor.setNome("Adriano");
		supervisor.setSalario(5000);
		supervisor.setIdade(30);
		double bonificacao = supervisor.bonificacao();
		assertEquals(10000.0, bonificacao);
	}

}
