package Pck_Control;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Pck_Model.Model_Sql;
import Pck_Dao.Dao_connection;
import Pck_Control.Control_Preenche_Componentes;
import Pck_Model.Model_Local;

public class Control_Local 
{
	Dao_connection obj_connection = new Dao_connection();
	Control_Preenche_Componentes obj_pc = new Control_Preenche_Componentes();
	Model_Local obj_model = new Model_Local();
	
	PreparedStatement obj_pst;
	
	public int inserir(int a02_id, int a03_pag, int a03_casela)
	{
		obj_model.setA03_id(obj_pc.pega_id(Model_Sql.getPegaCodLocal()));
		obj_model.setA02_id(a02_id);
		obj_model.setA03_pag(a03_pag);
		obj_model.setA03_casela(a03_casela);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getInsertLocal());
			obj_pst.setInt(1,obj_model.getA03_id());
			obj_pst.setInt(2,obj_model.getA02_id());
			obj_pst.setInt(3,obj_model.getA03_pag());
			obj_pst.setInt(4,obj_model.getA03_casela());
			obj_pst.execute();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao inserir registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
		
		return obj_model.getA03_id();
	}
	
	public void alterar(int a03_id, int a02_id, int a03_pag, int a03_casela)
	{
		obj_model.setA03_id(a03_id);
		obj_model.setA02_id(a02_id);
		obj_model.setA03_pag(a03_pag);
		obj_model.setA03_casela(a03_casela);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getAlterLocal());
			obj_pst.setInt(1,obj_model.getA03_pag());
			obj_pst.setInt(2,obj_model.getA03_casela());
			obj_pst.setInt(3,obj_model.getA02_id());
			obj_pst.setInt(4,obj_model.getA03_id());
			obj_pst.executeUpdate();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao alterar registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void remover(int a03_id)
	{
		obj_model.setA03_id(a03_id);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getDeleteLocal());
			obj_pst.setInt(1,obj_model.getA03_id());
			obj_pst.execute();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao remover registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}
}
