package model.dao;

import model.entity.Carro;
import model.entity.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class CarroDAO {

	public void inserir(Carro carro) {
		ConectaBD con = new ConectaBD();
		String sql = "INSERT INTO carro(numeroChassi, placa, modelo, marca, valor) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, carro.getNumeroChassi());
			pst.setString(2, carro.getPlaca());
			pst.setString(3, carro.getModelo());
			pst.setString(4, carro.getMarca());
			pst.setDouble(5, carro.getValor());
			pst.execute();
			System.out.println(carro.getModelo() + " placa " + carro.getPlaca() + " inserido!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Carro consultar(int idCarro) {
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM carro WHERE idcarro = ?";
		Carro c = null;
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, idCarro);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				int numeroChassi = rs.getInt("numeroChassi");
				String placa = rs.getString("placa");
				String modelo = rs.getString("modelo");
				String marca = rs.getString("marca");
				double valor = rs.getDouble("valor");
				c = new Carro(numeroChassi, placa, modelo, marca, valor);
				c.setIdCarro(idCarro);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return c;
	}
	
	public List<Carro> consultarTodos() {
		ConectaBD con = new ConectaBD();
		String sql = "SELECT * FROM carro";
		List<Carro> lista = new LinkedList<Carro>();
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Carro carro = new Carro();
				int idCarro = rs.getInt("idcarro");
				int numeroChassi = rs.getInt("numeroChassi");
				String placa = rs.getString("placa");
				String modelo = rs.getString("modelo");
				String marca = rs.getString("marca");
				double valor = rs.getDouble("valor");
				carro.setIdCarro(idCarro);
				carro.setNumeroChassi(numeroChassi);
				carro.setPlaca(placa);
				carro.setModelo(modelo);
				carro.setMarca(marca);
				carro.setValor(valor);
				lista.add(carro);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return lista;
	}
	
	public boolean deletar(int idCarro) {
		ConectaBD con = new ConectaBD();
		String sql = "DELETE FROM carro WHERE idcarro = ?";
		try {
			PreparedStatement pst = con.getConexao().prepareStatement(sql);
			pst.setInt(1, idCarro);
			pst.execute();
			return pst.getUpdateCount() > 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	public boolean atualizar(String opcao, int idCarro, String info) {
		ConectaBD con = new ConectaBD();
		String sql = "UPDATE carro SET ${opcao} = ? WHERE idcarro = ?";
		sql = sql.replace("${opcao}", opcao);
		
		if (opcao == "numeroChassi") {
			int numChassi;
			numChassi = Integer.parseInt(info);
			try {
				PreparedStatement pst = con.getConexao().prepareStatement(sql);
				pst.setInt(1, numChassi);
				pst.setInt(2, idCarro);
				pst.execute();
				return pst.getUpdateCount() > 0;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (opcao == "valor") {
			double vlr;
			vlr = Double.parseDouble(info);
			try {
				PreparedStatement pst = con.getConexao().prepareStatement(sql);
				pst.setDouble(1, vlr);
				pst.setInt(2, idCarro);
				pst.execute();
				return pst.getUpdateCount() > 0;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			try {
				PreparedStatement pst = con.getConexao().prepareStatement(sql);
				pst.setString(1, info);
				pst.setInt(2, idCarro);
				pst.execute();
				return pst.getUpdateCount() > 0;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return false;
	}

}
