package Pck_Model;

public class Model_Sql 
{
	private static final String pega_cod_filme = "SELECT MAX(A04_ID) + 1 AS ID FROM A04_FILMES;";
	private static final String insert_filme = "INSERT INTO A04_FILMES (A04_ID,A04_TITULO,A04_SUBTITULO) VALUES (?,?,?);";
	private static final String delete_filme = "DELETE FROM A04_FILMES WHERE A04_ID = ?;";
	private static final String alter_filme = "UPDATE A04_FILMES SET A04_TITULO = ?, A04_SUBTITULO = ? WHERE A04_ID = ?;";
	
	private static final String pega_cod_local_filme = "SELECT MAX(A06_ID) + 1 AS ID FROM A06_LOCAL_FILME;";
	private static final String insert_local_filme = "INSERT INTO A06_LOCAL_FILME (A06_ID,A03_ID,A04_ID) VALUES (?,?,?);";
	private static final String delete_local_filme = "DELETE FROM A06_LOCAL_FILME WHERE A06_ID = ?;";
	private static final String alter_local_filme = "UPDATE A06_LOCAL_FILME SET A03_ID =?, A04_ID = ? WHERE A06_ID = ?;";
	
	private static final String pega_cod_disqueteira = "SELECT MAX(A02_ID) + 1 AS ID FROM A02_DISQUETEIRA;";
	private static final String insert_disqueteira = "INSERT INTO A02_DISQUETEIRA (A02_ID,A02_DISQUETEIRA) VALUES (?,?);";
	private static final String delete_disqueteira = "DELETE FROM A02_DISQUETEIRA WHERE A02_ID = ?;";
	private static final String alter_disqueteira = "UPDATE A02_DISQUETEIRA SET A02_DISQUETEIRA = ? WHERE A02_ID = ?;";
	
	private static final String pega_cod_genero_filme = "SELECT MAX(A05_ID) + 1 AS ID FROM A05_GENERO_FILME;";
	private static final String insert_genero_filme = "INSERT INTO A05_GENERO_FILME (A05_ID, A04_ID, A01_ID) VALUES (?,?,?);";
	private static final String delete_genero_filme = "DELETE FROM A05_GENERO_FILME WHERE A05_ID = ?";
	private static final String alter_genero_filme = "UPDATE A05_GENERO_FILME SET A04_ID = ?, A01_ID = ? WHERE A05_ID = ?;";
	
	private static final String pega_cod_local = "SELECT MAX(A03_ID) + 1 AS ID FROM A03_LOCAL;";
	private static final String insert_local = "INSERT INTO A03_LOCAL (A03_ID,A02_ID,A03_PAG,A03_CASELA) VALUES (?,?,?,?);";
	private static final String delete_local = "DELETE FROM A03_LOCAL WHERE A03_ID = ?;";
	private static final String alter_local = "UPDATE A03_LOCAL SET A03_PAG = ?, A03_CASELA = ?, A02_ID = ? WHERE A03_ID = ?;";
	
	private static final String consulta_geral = "SELECT GEN.A01_ID, DISQUE.A02_ID, LOCAL.A03_ID, FILMES.A04_ID, GENF.A05_ID, LOCALF.A06_ID, FILMES.A04_TITULO AS TITULO, FILMES.A04_SUBTITULO AS SUBTITULO, GEN.A01_GENERO AS GENERO, DISQUE.A02_DISQUETEIRA AS DISQUETEIRA, LOCAL.A03_PAG AS PAGINA, LOCAL.A03_CASELA AS CASELA FROM A01_GENERO GEN, A02_DISQUETEIRA DISQUE, A03_LOCAL LOCAL, A04_FILMES FILMES, A05_GENERO_FILME GENF, A06_LOCAL_FILME LOCALF WHERE DISQUE.A02_ID = LOCAL.A02_ID AND GENF.A01_ID = GEN.A01_ID AND GENF.A04_ID = FILMES.A04_ID AND LOCALF.A04_ID = FILMES.A04_ID AND LOCALF.A03_ID = LOCAL.A03_ID;";
	private static final String consulta_titulo = "";
	private static final String consulta_subtitulo = "";
	private static final String consulta_genero = "SELECT A01_ID AS ID, A01_GENERO AS GENERO FROM A01_GENERO;";
	private static final String consulta_disqueteira = "SELECT A02_ID AS ID, A02_DISQUETEIRA AS DISQUETEIRA FROM A02_DISQUETEIRA;";
	public static String getPegaCodFilme() {
		return pega_cod_filme;
	}
	public static String getInsertFilme() {
		return insert_filme;
	}
	public static String getDeleteFilme() {
		return delete_filme;
	}
	public static String getAlterFilme() {
		return alter_filme;
	}
	public static String getPegaCodLocalFilme() {
		return pega_cod_local_filme;
	}
	public static String getInsertLocalFilme() {
		return insert_local_filme;
	}
	public static String getDeleteLocalFilme() {
		return delete_local_filme;
	}
	public static String getAlterLocalFilme() {
		return alter_local_filme;
	}
	public static String getPegaCodDisqueteira() {
		return pega_cod_disqueteira;
	}
	public static String getInsertDisqueteira() {
		return insert_disqueteira;
	}
	public static String getDeleteDisqueteira() {
		return delete_disqueteira;
	}
	public static String getAlterDisqueteira() {
		return alter_disqueteira;
	}
	public static String getPegaCodGeneroFilme() {
		return pega_cod_genero_filme;
	}
	public static String getInsertGeneroFilme() {
		return insert_genero_filme;
	}
	public static String getDeleteGeneroFilme() {
		return delete_genero_filme;
	}
	public static String getAlterGeneroFilme() {
		return alter_genero_filme;
	}
	public static String getPegaCodLocal() {
		return pega_cod_local;
	}
	public static String getInsertLocal() {
		return insert_local;
	}
	public static String getDeleteLocal() {
		return delete_local;
	}
	public static String getAlterLocal() {
		return alter_local;
	}
	public static String getConsultaGeral() {
		return consulta_geral;
	}
	public static String getConsultaTitulo() {
		return consulta_titulo;
	}
	public static String getConsultaSubtitulo() {
		return consulta_subtitulo;
	}
	public static String getConsultaGenero() {
		return consulta_genero;
	}
	public static String getConsultaDisqueteira() {
		return consulta_disqueteira;
	}
	
}
