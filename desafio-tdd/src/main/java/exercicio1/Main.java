package exercicio1;

public class Main {

	public static void main(String[] args) {

		// Cria objeto veiculo
		Veiculo carro = new Veiculo();

		// Teste acelerar
		System.out.println("Metodo acelerar");
		carro.acelerar();
		System.out.println(carro.getVelocidade());
		carro.acelerar();
		System.out.println(carro.getVelocidade());
		System.out.println();

		// Teste frear
		System.out.println("Metodo frear");
		carro.frear();
		System.out.println(carro.getVelocidade());
		carro.frear();
		System.out.println(carro.getVelocidade());
		carro.frear();
		System.out.println();

		// Teste Abastecer
		System.out.println("Metodo abastecer");
		System.out.println(carro.getLitrosCombustivel());
		carro.abastecer(10);
		System.out.println(carro.getLitrosCombustivel());
		carro.abastecer(70);
		carro.abastecer(60);
		carro.abastecer(50);
		System.out.println(carro.getLitrosCombustivel());
		System.out.println();

		// Pintar carro
		System.out.println("Metodo pintar");
		System.out.println(carro.getCor());
		carro.pintar("Preto");
		System.out.println(carro.getCor());
		System.out.println();

		// Ligar veculo
		System.out.println("Metodo ligar");
		carro.ligar();
		System.out.println();

		// Desligar veculo
		System.out.println("Metodo desligar");
		carro.acelerar();
		carro.desligar();

	}

}
