package Pck_Control;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Pck_Model.Model_Sql;
import Pck_Dao.Dao_connection;
import Pck_Control.Control_Preenche_Componentes;
import Pck_Model.Model_Disqueteira;

public class Control_Disqueteira 
{
	Dao_connection obj_connection = new Dao_connection();
	Model_Disqueteira obj_disqueteira = new Model_Disqueteira();
	Control_Preenche_Componentes obj_pc = new Control_Preenche_Componentes();
	
	PreparedStatement obj_pst;
	
	public void inserir(int a02_disqueteira)
	{
		obj_disqueteira.setA02_disqueteira(a02_disqueteira);
		obj_disqueteira.setA02_id(obj_pc.pega_id(Model_Sql.getPegaCodDisqueteira()));
		
		try
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getInsertDisqueteira());
			obj_pst.setInt(1,obj_disqueteira.getA02_id());
			obj_pst.setInt(2,obj_disqueteira.getA02_disqueteira());
			obj_pst.execute();
			
			obj_pst.close();
		}
		catch(SQLException erro)
		{
			JOptionPane.showMessageDialog(null,"Falha ao inserir registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void alterar(int a02_id, int a02_disqueteira)
	{
		obj_disqueteira.setA02_id(a02_id);
		obj_disqueteira.setA02_disqueteira(a02_disqueteira);
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getAlterDisqueteira());
			obj_pst.setInt(1,obj_disqueteira.getA02_disqueteira());
			obj_pst.setInt(2,obj_disqueteira.getA02_id());
			obj_pst.executeUpdate();
			
			obj_pst.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao alterar registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void remover(int a02_id)
	{
		obj_disqueteira.setA02_id(a02_id);
		
		try
		{
			obj_pst = obj_connection.getConnection().prepareStatement(Model_Sql.getDeleteDisqueteira());
			obj_pst.setInt(1,obj_disqueteira.getA02_id());
			obj_pst.execute();
			
			obj_pst.close();
		}
		catch(SQLException erro)
		{
			JOptionPane.showMessageDialog(null,"Falha ao inserir registro! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}

}
