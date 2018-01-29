package Pck_Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Pck_Dao.Dao_connection;

public class Database_Creation {
	
	Connection conexao = null;
	
	static PreparedStatement obj_pst;
	
	public static void Database() {
		try
		{
			Dao_connection obj_connection = new Dao_connection();
			obj_connection.getConnection();
			
			//cria tabela A01_GENERO
			String A01_GENERO = "CREATE TABLE A01_GENERO ("+
								"A01_ID        INTEGER          PRIMARY KEY NOT NULL,"+
								"A01_GENERO    VARCHAR2(150)    NOT NULL"+
								");";
			obj_pst = obj_connection.getConnection().prepareStatement(A01_GENERO);
			obj_pst.execute();
			
			//cria tabela A02_DISQUETEIRA
			String A02_DISQUETEIRA = "CREATE TABLE A02_DISQUETEIRA ("+
									 "A02_ID             INTEGER        PRIMARY KEY NOT NULL,"+
									 "A02_DISQUETEIRA    INTEGER        NOT NULL"+
									 ");";
			
			obj_pst = obj_connection.getConnection().prepareStatement(A02_DISQUETEIRA);
			obj_pst.execute();
			
			//cria tabela A03_LOCAL
			String A03_LOCAL = "CREATE TABLE A03_LOCAL ("+
							   "A03_ID        INTEGER        NOT NULL,"+
							   "A02_ID        INTEGER        NOT NULL,"+
							   "A03_PAG       INTEGER        NOT NULL,"+
							   "A03_CASELA    INTEGER        NOT NULL,"+
							   "FOREIGN KEY (A02_ID) REFERENCES A02_DISQUETEIRA (A02_ID),"+
							   "PRIMARY KEY (A03_ID, A02_ID)"+
							   ");";
			obj_pst = obj_connection.getConnection().prepareStatement(A03_LOCAL);
			obj_pst.execute();
			
			//cria tabela A04_FILMES
			String A04_FILMES = "CREATE TABLE A04_FILMES ("+
								"A04_ID           INTEGER            PRIMARY KEY NOT NULL,"+
								"A04_TITULO       VARCHAR2(256)      NOT NULL,"+
								"A04_SUBTITULO    VARCHAR2(256)      NOT NULL"+
								");";
			obj_pst = obj_connection.getConnection().prepareStatement(A04_FILMES);
			obj_pst.execute();
			
			//cria tabela A05_GENERO_FILME
			String A05_GENERO_FILME = "CREATE TABLE A05_GENERO_FILME ("+
									  "A05_ID        INTEGER        PRIMARY KEY NOT NULL,"+
									  "A04_ID        INTEGER,"+
									  "A01_ID        INTEGER,"+
									  "FOREIGN KEY (A04_ID) REFERENCES A04_FILMES (A04_ID),"+
									  "FOREIGN KEY (A01_ID) REFERENCES A01_GENERO (A01_ID)"+
									  ");";
			obj_pst = obj_connection.getConnection().prepareStatement(A05_GENERO_FILME);
			obj_pst.execute();
			
			//cria tabela A06_LOCAL_FILME
			String A06_LOCAL_FILME = "CREATE TABLE A06_LOCAL_FILME ("+
									 "A06_ID        INTEGER        PRIMARY KEY NOT NULL,"+
									 "A02_ID        INTEGER,"+
									 "A03_ID        INTEGER,"+
									 "A04_ID        INTEGER,"+
									 "FOREIGN KEY (A02_ID,A03_ID) REFERENCES A03_LOCAL (A02_ID,A03_ID),"+
									 "FOREIGN KEY (A04_ID) REFERENCES A04_FILMES (A04_ID)"+
									 ");";
			
			obj_pst = obj_connection.getConnection().prepareStatement(A06_LOCAL_FILME);
			obj_pst.execute();
		}
		catch (SQLException erro) 
		{
			System.out.println("Erro na execução do script do banco de dados: "+erro);
			JOptionPane.showMessageDialog(null,"Erro cração do banco de dados! "+erro,"Erro!",JOptionPane.ERROR_MESSAGE);
		}
	}

}
