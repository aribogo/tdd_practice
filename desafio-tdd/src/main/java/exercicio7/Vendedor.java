package exercicio7;

public class Vendedor extends Funcionario{

		public Vendedor(String nome, double salario, int ideade) {
			super(nome, salario, ideade);

		}

		@Override
		/**
		 * @InheritDoc Bonificacao de 3.000 reais
		 */
		public double bonificacao() {
			double salarioFinal = super.getSalario() + 3000;
			return salarioFinal;
		}

	
}
