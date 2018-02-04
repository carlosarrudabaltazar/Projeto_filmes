package Pck_Control;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Pck_Dao.Dao_connection;

public class Control_Preenche_Componentes 
{
	Dao_connection obj_connection = new Dao_connection();
	
	PreparedStatement obj_pst;
	ResultSet obj_rs;
	
	public DefaultTableModel preenche_jtable(String sql)
	{
		int qtd_colunas = 0;
		int j = 1;
		
		DefaultTableModel dtm = new DefaultTableModel(new String []{},0)
		{
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		
		try
		{
			obj_connection.getConnection();
			
			obj_pst = Dao_connection.obj_connection.prepareStatement(sql);
			obj_rs = obj_pst.executeQuery();
			
			qtd_colunas = obj_rs.getMetaData().getColumnCount();
			
			for(int i = 1; i <= qtd_colunas; i++)
			{
				dtm.addColumn(obj_rs.getMetaData().getColumnName(i));
			}
			
			while(obj_rs.next())
			{
				try
				{
					String[] dados = new String[qtd_colunas];
					String aux = null;
					
					for(int i = 1; i <= qtd_colunas; i++)
					{
						aux = obj_rs.getString(i);
						
						if((aux == null) || (aux == " "))
						{
							dados[i-1] = "-";
						}
						else
						{
							dados[i-1] = obj_rs.getString(i);
						}
						dtm.isCellEditable(j,i);
					}
					dtm.addRow(dados);
					j++;
				}
				catch(SQLException erro)
				{
					System.out.println("erro de sql "+erro.toString());
				}
			}
			
			obj_rs.close();
			obj_pst.close();
		}
		catch (Exception erro)
		{
			JOptionPane.showMessageDialog(null,"Falha ao preencher a tabela! "+erro.toString(),"Erro",JOptionPane.ERROR_MESSAGE);
		}
		return dtm;
	}
	
	public ArrayList<Integer> preenche_jcombobox(String sql, String codigo, String descricao, JComboBox<String> jcb)
	{
		ArrayList<Integer> list_codigo = new ArrayList<Integer>();
		list_codigo.clear();
		
		jcb.removeAllItems();
		
		obj_connection.getConnection();
		
		try
		{
			obj_pst = obj_connection.getConnection().prepareStatement(sql);
			obj_rs = obj_pst.executeQuery();
			
			while(obj_rs.next())
			{
				jcb.addItem(obj_rs.getString(descricao));
				list_codigo.add(obj_rs.getInt(codigo));
			}
			
			obj_pst.close();
			obj_rs.close();
		}
		catch(Exception erro)
		{
			JOptionPane.showMessageDialog(null,"Falha ao preencher a jcombobox! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
		
		return list_codigo;
	}
	
	public int pega_id (String sql)
	{
		int id = 0;
		
		try 
		{
			obj_pst = obj_connection.getConnection().prepareStatement(sql);
			obj_rs = obj_pst.executeQuery();
			
			id = obj_rs.getInt("ID");
			
			obj_pst.close();
			obj_rs.close();
		} 
		catch (SQLException erro) 
		{
			JOptionPane.showMessageDialog(null,"Falha ao selecionar o maior ID! "+erro.toString(),"Erro!",JOptionPane.ERROR_MESSAGE);
		}
				
		return id;
	}

}
