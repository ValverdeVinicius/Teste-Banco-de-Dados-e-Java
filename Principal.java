import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		int opcao = 0;
		Scanner s = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		Banco banco = new Banco();
		
		
		System.out.println("Digite o id da pessoa: ");
		pessoa.setId(s.nextInt());
		
		System.out.println("Digite o nome da pessoa: ");
		pessoa.setNome(s.next());
		
		System.out.println("Digite 1 para incluir uma pessoa, 2 para excluir, 3 para atualizar, 4 para consultar");
		opcao = s.nextInt();
		switch(opcao) {
		
		case 1: 
			banco.incluir(pessoa);
			
		case 2:
			banco.excluir(pessoa);
			
		case 3:
			banco.alterar(pessoa);
			
		case 4:
			banco.consultar(pessoa);
		
		}

	}

}
