package exercicio7;

public class Main {

	public static void main(String[] args) {
		
		Funcionario g1 = new Gerente("Carla", 7000, 40);
		Funcionario s1 = new Supervisor("Adriano", 5000, 30);
		Funcionario v1 = new Vendedor("Marisa", 3000, 20);

		System.out.format("O salario da gerente %s (%d anos) foi de %.2f reais\n", g1.getNome(), g1.getIdade(), g1.bonificacao());
		System.out.format("O salario do supervisor %s (%d anos) foi de %.2f reais\n", s1.getNome(), s1.getIdade(), s1.bonificacao());
		System.out.format("O salario da vendedora %s (%d anos) foi de %.2f reais\n", v1.getNome(), v1.getIdade(), v1.bonificacao());


	}

}
