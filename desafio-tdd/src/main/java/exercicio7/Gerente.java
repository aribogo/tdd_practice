package exercicio7;

public class Gerente extends Funcionario {

	public Gerente(String nome, double salario, int ideade) {
		super(nome, salario, ideade);

	}


	@Override
	/**
	 * @InheritDoc Bonificacao de 10.000 reais
	 */
	public double bonificacao() {
		double salarioFinal = super.getSalario() + 10000;
		return salarioFinal;
	}

}
