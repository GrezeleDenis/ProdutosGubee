package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	// parâmetros de conexão
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/produto";

	private String user = "postgres";
	private String password = "postgres";

	// metodos de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void inserirProduto(JavaBeans produto) {
		String create = "insert into contatos (nome, descrição, mercadoalvo, tecnologias) values (?, ?, ?, ?)";
		try {
			// abrir a coxão com o banco
			Connection con = conectar();
			// Preparar a Query para execução no db
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parametros (?) pelo conteudo nas variaveis javabeans
			pst.setString(1, produto.getNomepro());
			pst.setString(2, produto.getDescripro());
			pst.setString(3, produto.getMercapro());
			pst.setString(4, produto.getTecnopro());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexão com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	

	public ArrayList<JavaBeans> listarProdutos() {
		//criando um objeto para acessar a classe javabeans
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		String read = "select * from produtos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String codpro = rs.getString(1);
				String nomepro = rs.getString(2);
				String descripro = rs.getString(3);
				String mercapro = rs.getString(4);
				String tecnopro = rs.getString(5);
				produtos.add(new JavaBeans(codpro, nomepro, descripro, mercapro, tecnopro));
			}
			con.close();
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
//	//teste de conexão
//	public void testeConexao() {
//		try {
//			Connection con = conectar();
//			System.out.println(con);
//			con.close();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}

}
