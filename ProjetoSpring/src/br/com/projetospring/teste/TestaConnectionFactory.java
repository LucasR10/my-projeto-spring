/**
 * 
 */
package br.com.projetospring.teste;

// faz as importa��es de classes necess�rias para o funcionamento do programa
import java.sql.Connection; // conex�o SQL para Java
import java.sql.DriverManager; // driver de conex�o SQL para Java
import java.sql.SQLException; // classe para tratamento de exce��es

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
		System.out.println("Conex�o aberta!");
		connection.close();
	}

}
