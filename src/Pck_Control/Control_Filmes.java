package Pck_Control;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Pck_Model.Model_Sql;
import Pck_Dao.Dao_connection;
import Pck_Control.Control_Preenche_Componentes;
import Pck_Model.Model_Filmes;

public class Control_Filmes 
{
	Dao_connection obj_connection = new Dao_connection();
	Control_Preenche_Componentes obj_pc = new Control_Preenche_Componentes();
	Model_Filmes obj_model = new Model_Filmes();
	
	PreparedStatement obj_pst;
	
	public int inserir(String a04_titulo, String a04_subtitulo)
	{
		obj_model.setA04_id(obj_pc.pega_id(Model_Sql.getPegaCodFilme()));
		obj_model.setA04_titulo(a04_titulo);
		obj_model.setA04_subtitulo(a04_subtitulo);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getInsertFilme());
			obj_pst.setInt(1,obj_model.getA04_id());
			obj_pst.setString(2,obj_model.getA04_titulo());
			obj_pst.setString(3,obj_model.getA04_subtitulo());
			obj_pst.execute();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao inserir registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
		
		return obj_model.getA04_id();
	}
	
	public void alterar(int a04_id, String a04_titulo, String a04_subtitulo)
	{
		obj_model.setA04_id(a04_id);
		obj_model.setA04_titulo(a04_titulo);
		obj_model.setA04_subtitulo(a04_subtitulo);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getAlterFilme());
			obj_pst.setString(1,obj_model.getA04_titulo());
			obj_pst.setString(2,obj_model.getA04_subtitulo());
			obj_pst.setInt(3,obj_model.getA04_id());
			obj_pst.executeUpdate();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao alterar registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void remover(int a04_id)
	{
		obj_model.setA04_id(a04_id);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getDeleteFilme());
			obj_pst.setInt(1,obj_model.getA04_id());
			obj_pst.execute();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao remover registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}
}
