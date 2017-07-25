package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {
	public void salvar(Fabricante fabricante) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, fabricante.getDescricao());

		comando.executeUpdate();
	}

	public void excluir(Fabricante fabricante) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE idFabricante = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, fabricante.getIdFabricante());

		comando.executeUpdate();
	}

	public void editar(Fabricante fabricante) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante SET ");
		sql.append("descricao = ? " );
		sql.append("WHERE idFabricante = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, fabricante.getDescricao());
		comando.setLong(2, fabricante.getIdFabricante());

		comando.executeUpdate();		
	}
	
	public Fabricante buscarPorIdFabricante(Fabricante fabricante) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idFabricante, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE idFabricante = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, fabricante.getIdFabricante());
		
		ResultSet resultado = comando.executeQuery();		
		
		Fabricante retorno = null;
		
		if(resultado.next()) {
			retorno = new Fabricante();
			retorno.setIdFabricante(resultado.getLong("idFabricante"));
			retorno.setDescricao(resultado.getString("descricao"));
		}
		
		return retorno;
	} 
	
	public ArrayList<Fabricante> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idFabricante, descricao ");
		sql.append("from fabricante ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		
		while(resultado.next()) {
			Fabricante fabricante = new Fabricante();
			fabricante.setIdFabricante(resultado.getLong("idFabricante"));
			fabricante.setDescricao(resultado.getString("descricao"));
			
			lista.add(fabricante);
		}
		
		return lista;
	}
	
	public ArrayList<Fabricante> buscarPorDescricao(Fabricante fabricante) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idFabricante, descricao ");
		sql.append("from fabricante ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1,"%" + fabricante.getDescricao() + "%");
		
		ResultSet resultado = comando.executeQuery();		
		
		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
		
		while(resultado.next()) {
			Fabricante item = new Fabricante();
			item.setIdFabricante(resultado.getLong("idFabricante"));
			item.setDescricao(resultado.getString("descricao"));
			
			lista.add(item);
		}
		
		return lista;
		
	}
	public static void main(String[] args) {
	  /*
	  //-- INCLUIR --
	  
	  Fabricante f1 = new Fabricante(); f1.setDescricao("Descricao 1");
	  
	  Fabricante f2 = new Fabricante(); f2.setDescricao("Descricao 2");
	  
	  FabricanteDAO fdao = new FabricanteDAO();
	  
	  try { 
	  	  fdao.salvar(f1); 
	  	  fdao.salvar(f2);
	  
	  	  System.out.println("Fabricante salvo com sucesso!"); 
	  } catch (SQLException e){ 
	  	  System.out.println("Erro ao tentar salvar fabricante!");
	  	  e.printStackTrace(); 
	  }
		 
	  */
		
	  /*
	  //-- EXCLUIR --
	  
	  Fabricante f1 = new Fabricante();
	  
	  f1.setIdFabricante(1L);
	  
	  Fabricante f2 = new Fabricante();
	  
	  f2.setIdFabricante(2L);
	  
	  FabricanteDAO fdao = new FabricanteDAO();
	  
	  try { 
	  	  fdao.excluir(f1); 
	  	  fdao.excluir(f2);
	  
	  	  System.out.println("Fabricante removido com sucesso!"); 
	  } catch (SQLException e) { 
	  	  System.out.println("Erro ao excluir o fabricante!");
	  	  e.printStackTrace(); 
	  }
	 */
		
	 /*
	  //-- ALTERAR --
	  
	  Fabricante f1 = new Fabricante();
	  
	  f1.setDescricao("Descricao 3");
	  f1.setIdFabricante(3L);
	  
	  Fabricante f2 = new Fabricante();
	  
	  f2.setDescricao("Descricao 4");
	  f2.setIdFabricante(4L);
	  
	  FabricanteDAO fdao = new FabricanteDAO();
	  
	  try { 
		  fdao.editar(f1); 
		  fdao.editar(f2);
	  
	  	  System.out.println("Fabricante alterado com sucesso!"); 
	  } catch (SQLException e) { 
	  	  System.out.println("Erro ao alterar o fabricante!");
	      e.printStackTrace(); 
	}
	*/
	 /*
	  //-- buscarPorIdFabricante --
	  
	  Fabricante f1 = new Fabricante();
	  
	  f1.setIdFabricante(3L);
	  
	  Fabricante f2 = new Fabricante();
	  
	  f2.setIdFabricante(4L);
	  
	  FabricanteDAO fdao = new FabricanteDAO();
	  
	  try { 		  
		  Fabricante f3 = fdao.buscarPorIdFabricante(f1);
		  Fabricante f4 = fdao.buscarPorIdFabricante(f2);
  
	  	  System.out.println("Resultado 1: " + f3);
	  	  System.out.println("Resultado 2: " + f4);
	  } catch (SQLException e) { 
	  	  System.out.println("Erro ao alterar o fabricante!");
	      e.printStackTrace(); 
	  }
	  */
	  /*
	  //-- listar --
	  
	  FabricanteDAO fdao = new FabricanteDAO();
	  
	  try { 		  
		  ArrayList<Fabricante> lista = fdao.listar();
		  
		  for(Fabricante fabricante : lista) {
			  System.out.println("Resultado: " + fabricante);
		  }
		  
	  } catch (SQLException e) { 
	  	  System.out.println("Erro ao listar todos os fabricantes!");
	      e.printStackTrace(); 
	  }
	  */
		
	  /*
		//buscarPorDescricao
		Fabricante f1 = new Fabricante();
		f1.setDescricao("3");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try {
			ArrayList<Fabricante> lista = fdao.buscarPorDescricao(f1);
		
			for(Fabricante fabricante : lista) {
				System.out.println("Resultado: " + fabricante);
			}
		}catch(SQLException e) {
			System.out.println("Ocorreu um erro ao pesquisar um fabricante!");
			e.printStackTrace();
		}
	   */
	}
}
