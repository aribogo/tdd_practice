package exercicio1;

public class Veiculo {


		private String marca;
		private String modelo;
		private String placa;
		private String cor;
		private float km;
		private boolean isLigado;
		private int litrosCombustivel;
		private int velocidade;
		private double preco;


		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getPlaca() {
			return placa;
		}

		public void setPlaca(String placa) {
			this.placa = placa;
		}

		public String getCor() {
			return cor;
		}

		public void setCor(String cor) {
			this.cor = cor;
		}

		public float getKm() {
			return km;
		}

		public void setKm(float km) {
			this.km = km;
		}

		public boolean isLigado() {
			return isLigado;
		}

		public void setLigado(boolean isLigado) {
			this.isLigado = isLigado;
		}

		public int getLitrosCombustivel() {
			return litrosCombustivel;
		}

		public void setLitrosCombustivel(int litrosCombustivel) {
			this.litrosCombustivel = litrosCombustivel;
		}

		public int getVelocidade() {
			return velocidade;
		}

		public void setVelocidade(int velocidade) {
			this.velocidade = velocidade;
		}

		public double getPreco() {
			return preco;
		}

		public void setPreco(double preco) {
			this.preco = preco;
		}

		// Métodos
		/**
		 * Acelera um veculo adicionando 20 unidades na velocidade.
		 * 
		 * @return a nova velocidade do veculo.
		 */
		public int acelerar() {
			velocidade += 20;
			System.out.println("Acelerando...");
			return velocidade;
		}

		/**
		 * Abastece o veculo adicionando valor at o limite do tanque.
		 * 
		 * @param combustivel Quantidade de litros a ser abastecido.
		 * @return quantidade de combustvel no tanque aps abastecer.
		 */
		public int abastecer(int combustivel) {
			if (combustivel > 60) {
				System.out.println("Tanque no suporta mais que 60 litros!");
			} else if ((combustivel + litrosCombustivel) > 60) {
				int quantMaxima = 60 - litrosCombustivel;

				System.out.format("\n\nEste valor ultrapassara a quantidade maxima de combustivel! Seu carro atualmente esta com %d litros. Voce pode colocar no maximo %d litros\n\n", litrosCombustivel, quantMaxima);


			} else {
				litrosCombustivel += combustivel;
			}
			return litrosCombustivel;
		}

		/**
		 * Freia um veculo retirando 20 unidades na velocidade; Avisaa se estiver.
		 * parado
		 * 
		 * @return a nova velocidade do veculo.
		 */
		public int frear() {
			if (velocidade != 0) {
				velocidade -= 20;
				System.out.println("Freando...");
			} else {
				System.out.println("Voce esta parado!\n");
			}
			return velocidade;
		}

		/**
		 * Muda a cor do veculo.
		 * 
		 * @param corV Cor para ser adicionado ao veculo.
		 */
		public void pintar(String corV) {
			cor = corV;
		}

		/**
		 * Liga o veculo; Avisa se o veculo j est ligado.
		 */
		public void ligar() {
			if (isLigado) {
				System.out.println("O veculo ja esta ligado!");
			} else {
				System.out.println("Ligando o veiculo...");
				isLigado = true;
			}
		}

		/**
		 * Desliga o veculo; 
		 * Avisa se o veculo estiver em movimento.
		 */
		public void desligar() {
			if (isLigado && velocidade == 0) {
				System.out.println("Desligando o veculo...");
				isLigado = false;
			} else if (velocidade != 0) {
				System.out.println("O veculo so pode ser desligado quando estiver parado!");
			} else {
				System.out.println("O veiculo ja esta desligado.");
			}
		}

	
}
