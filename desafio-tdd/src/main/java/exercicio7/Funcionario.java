package exercicio7;

public class Funcionario {

	private String nome;
	private double salario;
	private int idade;


	public Funcionario(String nome, double salario, int ideade) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.idade = ideade;
	}

	
	public Funcionario() {
	}


	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	/**
	 * Calculo da bonificao de cada funcionario (gerente, supervisor e vendedor).
	 * 
	 * @return o salraio com a bonificacao
	 */
	public double bonificacao() {
		return salario;
	}

}
