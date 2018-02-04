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
							   "FOREIGN KEY (A02_ID) REFERENCES A02_DISQUETEIRA (A02_ID) ON DELETE CASCADE,"+
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
									  "FOREIGN KEY (A04_ID) REFERENCES A04_FILMES (A04_ID) ON DELETE CASCADE,"+
									  "FOREIGN KEY (A01_ID) REFERENCES A01_GENERO (A01_ID) ON DELETE CASCADE"+
									  ");";
			obj_pst = obj_connection.getConnection().prepareStatement(A05_GENERO_FILME);
			obj_pst.execute();
			
			//cria tabela A06_LOCAL_FILME
			String A06_LOCAL_FILME = "CREATE TABLE A06_LOCAL_FILME ("+
									 "A06_ID        INTEGER        PRIMARY KEY NOT NULL,"+
									 "A02_ID        INTEGER,"+
									 "A03_ID        INTEGER,"+
									 "A04_ID        INTEGER,"+
									 "FOREIGN KEY (A02_ID,A03_ID) REFERENCES A03_LOCAL (A02_ID,A03_ID) ON DELETE CASCADE,"+
									 "FOREIGN KEY (A04_ID) REFERENCES A04_FILMES (A04_ID) ON DELETE CASCADE"+
									 ");";
			
			obj_pst = obj_connection.getConnection().prepareStatement(A06_LOCAL_FILME);
			obj_pst.execute();
			
			//alimenta tabela genero
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (1,'Ação');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (2,'Animação');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (3,'Aventura');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (4,'Cinema de arte');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (5,'Chanchada');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (6,'Cinema catástrofe');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (7,'Comédia');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (8,'Comédia romântica');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (9,'Comédia dramática');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (10,'Comédia de ação');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (11,'Cult');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (12,'Dança');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (13,'Documentários');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (14,'Drama');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (15,'Espionagem');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (16,'Erótico');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (17,'Fantasia');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (18,'Faroeste');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (19,'Ficção Científica');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (20,'Série');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (21,'Guerra');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (22,'Machinima');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (23,'Masala');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (24,'Musical');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (25,'Filme noir');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (26,'Policial');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (27,'Pornochanchada');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (28,'Pornográfico');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (29,'Robologia');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (30,'Romance');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (31,'Seriado');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (32,'Suspense');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (33,'Terror');");
			obj_pst.execute();
			obj_pst = obj_connection.getConnection().prepareStatement("INSERT INTO A01_GENERO (A01_ID,A01_GENERO) VALUES (34,'Trash');");
			obj_pst.execute();

			obj_pst.close();
		}
		catch (SQLException erro) 
		{
			System.out.println("Erro na execu��o do script do banco de dados: "+erro);
			JOptionPane.showMessageDialog(null,"Erro cra��o do banco de dados! "+erro,"Erro!",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
