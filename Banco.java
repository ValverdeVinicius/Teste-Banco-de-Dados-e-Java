import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Banco {

	public void incluir(Pessoa pessoa) {
		final String usuario = "postgres";
		final String senha = "1234";
		final String url ="jdbc:postgresql://localhost:5432/postgres";
		final String instrucao_insert = "INSERT INTO pessoas(id, nome) VALUES (?, ?)";
		final String driverBanco = "org.postgresql.Driver";
		
		try {
			Class.forName(driverBanco);
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			PreparedStatement preparedStatement = conexao.prepareStatement(instrucao_insert);
			preparedStatement.setInt(1, pessoa.getId());
			preparedStatement.setString(2, pessoa.getNome());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Execução realizada");
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	public void excluir(Pessoa pessoa) {
		final String usuario = "postgres";
		final String senha = "1234";
		final String url ="jdbc:postgresql://localhost:5432/postgres";
		final String instrucao_delete = "DELETE FROM pessoas WHERE id =?;";
		final String driverBanco = "org.postgresql.Driver";
		
		try {
			Class.forName(driverBanco);
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			PreparedStatement preparedStatement = conexao.prepareStatement(instrucao_delete);
			preparedStatement.setInt(1, pessoa.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Execução realizada");
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	public void alterar(Pessoa pessoa) {
		final String usuario = "postgres";
		final String senha = "1234";
		final String url ="jdbc:postgresql://localhost:5432/postgres";
		final String instrucao_update = "UPDATE pessoas SET id=?, nome=?;";
		final String driverBanco = "org.postgresql.Driver";
		
		try {
			Class.forName(driverBanco);
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			PreparedStatement preparedStatement = conexao.prepareStatement(instrucao_update);
			preparedStatement.setInt(1, pessoa.getId());
			preparedStatement.setString(2, pessoa.getNome());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Execução realizada");
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	public void consultar(Pessoa pessoa) {
		final String usuario = "postgres";
		final String senha = "1234";
		final String url ="jdbc:postgresql://localhost:5432/postgres";
		final String instrucao_select = "SELECT * FROM pessoas;";
		final String driverBanco = "org.postgresql.Driver";
		
		try {
			Class.forName(driverBanco);
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			PreparedStatement preparedStatement = conexao.prepareStatement(instrucao_select);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				System.out.println("Id: "+ id+ " Nome: "+ nome);
			}
			
			System.out.println("Execução realizada");
			
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}

}