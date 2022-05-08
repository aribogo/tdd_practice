package exercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VeiculoTest {

	private Veiculo veiculo;

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	private void getSysOut() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@BeforeEach
	public void setUp() {
		veiculo = new Veiculo();
		veiculo.setKm(1000);
		veiculo.setMarca("marca qualquer");
		veiculo.setModelo("modelo qualquer");
		veiculo.setPreco(20000.00);
		
	}


	@Test
	public void testAcelerar() {

		getSysOut();
		veiculo.acelerar();

		assertEquals(20, veiculo.getVelocidade());
		assertEquals("Acelerando...", outputStreamCaptor.toString().trim());
	}


	@Test
	public void testAbastecerMenosDe60Litros() {

		veiculo.abastecer(50);
		assertEquals(50, veiculo.getLitrosCombustivel());

	}


	@Test
	public void testAbastecerMaisDe60Litros() {
		getSysOut();
		veiculo.abastecer(61);
		assertEquals(0, veiculo.getLitrosCombustivel());

		assertEquals("Tanque no suporta mais que 60 litros!", outputStreamCaptor.toString().trim());

	}


	@Test
	public void testAbastecerMenosDe60LitrosMasQueTotalUltrapasse60L() {

		veiculo.abastecer(50);
		getSysOut();
		veiculo.abastecer(20);

		assertEquals(50, veiculo.getLitrosCombustivel());
		assertEquals("Este valor ultrapassara a quantidade maxima de combustivel!"
				+ " Seu carro atualmente esta com 50 litros."
				+ " Voce pode colocar no maximo 10 litros", outputStreamCaptor.toString().trim());

	}


	@Test
	public void testFrearComVeiculoParado() {
		getSysOut();
		veiculo.frear();

		assertEquals(0, veiculo.getVelocidade());
		assertEquals("Voce esta parado!", outputStreamCaptor.toString().trim());
	}


	@Test
	public void testFrearComVeiculoEmMovimento() {
		veiculo.acelerar();
		getSysOut();
		veiculo.frear();

		assertEquals(0, veiculo.getVelocidade());
		assertEquals("Freando...", outputStreamCaptor.toString().trim());
	}


	@Test
	public void testPintar() {
		
		veiculo.pintar("amarelo");

		assertEquals("amarelo", veiculo.getCor());
	}


	@Test
	public void testLigarCarroLigado() {
		veiculo.ligar();
		getSysOut();
		veiculo.ligar();

		assertTrue(veiculo.isLigado());
		assertEquals("O veculo ja esta ligado!", outputStreamCaptor.toString().trim());
	}


	@Test
	public void testLigarCarroDesligado() {
		getSysOut();
		veiculo.ligar();

		assertTrue(veiculo.isLigado());
		assertEquals("Ligando o veiculo...", outputStreamCaptor.toString().trim());
	}


	@Test
	public void testDesligarCarroLigado() {
		veiculo.ligar();
		getSysOut();
		veiculo.desligar();

		assertFalse(veiculo.isLigado());
		assertEquals("Desligando o veculo...", outputStreamCaptor.toString().trim());
	}


	@Test
	public void testDesligarCarroLigadoVelocidadeMaiorQueZero() {
		veiculo.ligar();
		veiculo.acelerar();
		getSysOut();
		veiculo.desligar();

		assertTrue(veiculo.isLigado());
		assertEquals("O veculo so pode ser desligado quando estiver parado!", outputStreamCaptor.toString().trim());
	}


	@Test
	public void testDesligarCarroDesligado() {
		getSysOut();
		veiculo.desligar();

		assertFalse(veiculo.isLigado());
		assertEquals("O veiculo ja esta desligado.", outputStreamCaptor.toString().trim());
	}

}
