package Pck_Control;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Pck_Model.Model_Sql;
import Pck_Dao.Dao_connection;
import Pck_Control.Control_Preenche_Componentes;
import Pck_Model.Model_Local_Filme;

public class Control_Local_Filme 
{
	Dao_connection obj_connection = new Dao_connection();
	Control_Preenche_Componentes obj_pc = new Control_Preenche_Componentes();
	Model_Local_Filme obj_model = new Model_Local_Filme();
	
	PreparedStatement obj_pst;
	
	public void inserir(int a03_id, int a04_id)
	{
				
		obj_model.setA06_id(obj_pc.pega_id(Model_Sql.getPegaCodLocalFilme()));
		obj_model.setA03_id(a03_id);
		obj_model.setA04_id(a04_id);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getInsertLocalFilme());
			obj_pst.setInt(1,obj_model.getA06_id());
			obj_pst.setInt(2,obj_model.getA03_id());
			obj_pst.setInt(3,obj_model.getA04_id());
			obj_pst.execute();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao inserir registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void alterar(int a06_id, int a03_id, int a04_id)
	{
		obj_model.setA06_id(a06_id);
		obj_model.setA03_id(a03_id);
		obj_model.setA04_id(a04_id);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getAlterLocalFilme());
			obj_pst.setInt(1,obj_model.getA03_id());
			obj_pst.setInt(2,obj_model.getA04_id());
			obj_pst.setInt(3,obj_model.getA06_id());
			obj_pst.executeUpdate();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao alterar registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void remover(int a06_id)
	{
		obj_model.setA06_id(a06_id);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getDeleteLocalFilme());
			obj_pst.setInt(1,obj_model.getA06_id());
			obj_pst.execute();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao remover registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}
}
