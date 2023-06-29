package model.dao;

import model.entity.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class PessoaDAO {
	
	public void inserir(Pessoa pessoa) {
		ConectaBD con = new ConectaBD();
		String sql = "INSERT INTO pessoa(nome, email) VALUES (?, ?)";
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setString(1, pessoa.getNome());
			pst.setString(2, pessoa.getEmail());
			pst.execute();
			System.out.println(pessoa.getNome() + " inserido!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Pessoa consultar(int id) {
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM pessoa WHERE idpessoa = ?";
		Pessoa p = null;
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				p = new Pessoa(nome, email);
				p.setId(id);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}
	
	public List<Pessoa> consultarTodos() {
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM pessoa";
		List<Pessoa> lista = new LinkedList<Pessoa>();
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				int id = rs.getInt("idpessoa");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				pessoa.setId(id);
				pessoa.setNome(nome);
				pessoa.setEmail(email);
				lista.add(pessoa);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return lista;
	}
	
	public boolean deletar(int id) {
		ConectaBD con = new ConectaBD();
		String sql = "DELETE FROM pessoa WHERE idpessoa = ?";
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			return pst.getUpdateCount() > 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean atualizarNome(int id, String nome) {
		ConectaBD con = new ConectaBD();
		String sql = "UPDATE pessoa SET nome = ? WHERE idpessoa = ?";
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setString(1, nome);
			pst.setInt(2, id);
			pst.execute();
			return pst.getUpdateCount() > 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean atualizarEmail(int id, String email) {
		ConectaBD con = new ConectaBD();
		String sql = "UPDATE pessoa SET email = ? WHERE idpessoa = ?";
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setString(1, email);
			pst.setInt(2, id);
			pst.execute();
			return pst.getUpdateCount() > 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
