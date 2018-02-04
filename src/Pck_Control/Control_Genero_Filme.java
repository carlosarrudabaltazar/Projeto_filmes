package Pck_Control;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Pck_Model.Model_Sql;
import Pck_Dao.Dao_connection;
import Pck_Control.Control_Preenche_Componentes;
import Pck_Model.Model_Genero_Filme;

public class Control_Genero_Filme 
{
	Dao_connection obj_connection = new Dao_connection();
	Control_Preenche_Componentes obj_pc = new Control_Preenche_Componentes();
	Model_Genero_Filme obj_model = new Model_Genero_Filme();
	
	PreparedStatement obj_pst;
	
	public void inserir(int a04_id, int a01_id)
	{
		obj_model.setA05_id(obj_pc.pega_id(Model_Sql.getPegaCodGeneroFilme()));
		obj_model.setA04_id(a04_id);
		obj_model.setA01_id(a01_id);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getInsertGeneroFilme());
			obj_pst.setInt(1,obj_model.getA05_id());
			obj_pst.setInt(2,obj_model.getA04_id());
			obj_pst.setInt(3,obj_model.getA01_id());
			obj_pst.execute();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao inserir registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void alterar(int a05_id, int a04_id, int a01_id)
	{
		obj_model.setA05_id(a05_id);
		obj_model.setA04_id(a04_id);
		obj_model.setA01_id(a01_id);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getAlterGeneroFilme());
			obj_pst.setInt(1,obj_model.getA04_id());
			obj_pst.setInt(2,obj_model.getA01_id());
			obj_pst.setInt(3,obj_model.getA05_id());
			obj_pst.executeUpdate();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao alterar registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void remover(int a05_id)
	{
		obj_model.setA05_id(a05_id);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getDeleteGeneroFilme());
			obj_pst.setInt(1,obj_model.getA05_id());
			obj_pst.execute();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao remover registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}
}
