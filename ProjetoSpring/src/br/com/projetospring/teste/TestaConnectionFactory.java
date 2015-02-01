/**
 * 
 */
package br.com.projetospring.teste;

// faz as importações de classes necessárias para o funcionamento do programa
import java.sql.Connection; // conexão SQL para Java
import java.sql.DriverManager; // driver de conexão SQL para Java
import java.sql.SQLException; // classe para tratamento de exceções

/**
 * @author Joelson
 *
 */

public class TestaConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
		} catch (SQLException excecao) {
			throw new RuntimeException(excecao);
		}
	}

	public static void main(String[] args) throws SQLException {
		Connection connection = new TestaConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
		connection.close();
	}

}
