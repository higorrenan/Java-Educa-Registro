package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Módulo de conexão **/
	// Parâmentros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/educa?useTimezone=true&ampserveTimezone=UTC";
	private String use = "root";
	private String password = "higor123";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, use, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// teste de conexão
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void inserirContato(JavaBeans contato) {

		String create = "insert into  contatos (nome_contato,fone_contato,email_contato) values (?,?,?)";

		try {
			// abrir a conexão
			Connection con = conectar();
			// prepara a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome_contato());
			pst.setString(2, contato.getFone_contato());
			pst.setString(3, contato.getEmail_contato());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD READ
	public ArrayList<JavaBeans> listarcontatos() {
		// Criando um objeto para acessar a class JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome_contato";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O laço abaixo será executado enquanto houver contatos
			while (rs.next()) {
				// variaveis de apoio que recebem os dados do banco
				String id_contato = rs.getString(1);
				String nome_contato = rs.getString(2);
				String fone_contato = rs.getString(3);
				String email_contato = rs.getString(4);
				// populando o ArrayList
				contatos.add(new JavaBeans(id_contato, nome_contato, fone_contato, email_contato));
			}
			con.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// CRUD UPDATE

	public void selecionarContato(JavaBeans contato) {

		String read2 = "select * from contatos where id_contato= ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getId_contato());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Setar as variáveis JavaBeans
				contato.setId_contato(rs.getString(1));
				contato.setNome_contato(rs.getString(2));
				contato.setFone_contato(rs.getString(3));
				contato.setEmail_contato(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// Editar contato

	public void alteraContato(JavaBeans contato) {
		String creat = "update contatos set nome_contato=?,fone_contato=?,email_contato=? where id_contato=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(creat);
			pst.setString(1, contato.getNome_contato());
			pst.setString(2, contato.getFone_contato());
			pst.setString(3, contato.getEmail_contato());
			pst.setString(4, contato.getId_contato());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	//CRUD DELET
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where id_contato=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1,contato.getId_contato());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	
		
	}
}
