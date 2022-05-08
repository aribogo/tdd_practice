package exercicio7;

public class Supervisor extends Funcionario {

		public Supervisor(String nome, double salario, int ideade) {
			super(nome, salario, ideade);
		}

		public Supervisor() {
			super();
		}

		
		@Override
		/**
		 * @InheritDoc Bonificacao de 5.000 reais
		 */
		public double bonificacao() {
			double salarioFinal = super.getSalario() + 5000;
			return salarioFinal;
		}

	
}
