package Pck_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.sqlite.SQLiteConfig;

public class Dao_connection {
	
	public static Connection obj_connection = null;
	PreparedStatement obj_pst;
	
	private final static String URL = "jdbc:sqlite:Movies.db";
	
	public Connection getConnection()
	{
		if(obj_connection == null)
		{
			try
			{
				SQLiteConfig sqconf= new SQLiteConfig();
				sqconf.enforceForeignKeys(true);
				obj_connection = sqconf.createConnection(URL);
				obj_pst = obj_connection.prepareStatement("PRAGMA foreign_key = ON");
				obj_pst.execute();
			}
			catch (SQLException erro)
			{
				JOptionPane.showMessageDialog(null, "A conexão com o banco de dados falhou! "+erro);
				System.out.println("Falha na conexão: "+erro);
			}
		}
		return obj_connection;
	}
	
	public static void close()
	{
		if(obj_connection != null)
		{
			try
			{
				obj_connection.close();
				obj_connection = null;
			}
			catch(SQLException erro)
			{
				JOptionPane.showMessageDialog(null, "Problemas com o encerramento da conexção com o banco de dados!: "+erro);
				System.out.println("Problemas com o encerramento da conexção com o banco de dados!: "+erro);
			}
		}
	}
}
