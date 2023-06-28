package entidades;

public class Operador extends Funcionario{

	public Operador() {
		
	}
	
	public Operador(int id, String cpf, String nome, float salario) {
	
		super.setId(id);
		super.setCpf(cpf);
		super.setNome(nome);
		super.setSalario(salario);

	}
	
	public Operador(String cpf, String nome, float salario) {


		super.setCpf(cpf);
		super.setNome(nome);
		super.setSalario(salario);

	}
	
}
