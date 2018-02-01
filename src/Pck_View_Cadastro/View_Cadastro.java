package Pck_View_Cadastro;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import Pck_View.View_Model;
import Pck_Control.Control_Preenche_Componentes;
import Pck_Model.Model_Sql;

public class View_Cadastro extends View_Model
{
	private static final long serialVersionUID = 1L;
	
	Control_Preenche_Componentes obj_pc = new Control_Preenche_Componentes();

	private JComboBox<String> jcb_genero;
	
	private JLabel jl_genero;
	private JLabel jl_titulo;
	private JLabel jl_subtitulo;
	private JLabel jl_disqueteira;
	private JLabel jl_pag;
	private JLabel jl_casela;
	
	private JTextField jtf_titulo;
	private JTextField jtf_subtitulo;
	
	private SpinnerNumberModel snm_disqueteira;
	private SpinnerNumberModel snm_pag;
	private SpinnerNumberModel snm_casela;
	
	private JSpinner js_disqueteira;
	private JSpinner js_pag;
	private JSpinner js_casela;
	
	
	ArrayList<Integer> codigo_genero;
	
	public View_Cadastro()
	{
		inicia_componentes();
		eventos();
		cria_tabela();
		clique_tabela();
	}
	
	public void inicia_componentes() 
	{
		this.setTitle("Cadastro de título");
		jp_cadastro.setLayout(new FlowLayout(0,0,30));
		jp_cadastro.setPreferredSize(new Dimension(400,440));
		
		jl_genero = new JLabel("Genero: ",JLabel.RIGHT);
		jl_genero.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(jl_genero);
		
		jcb_genero = new JComboBox<String>();
		codigo_genero = obj_pc.preenche_jcombobox(Model_Sql.getConsultaGenero(), "A01_ID", "A01_GENERO", jcb_genero);
		jcb_genero.setPreferredSize(new Dimension(200,20));
		jp_cadastro.add(jcb_genero);
		
		jl_titulo = new JLabel("Título: ",JLabel.RIGHT);
		jl_titulo.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(jl_titulo);
		
		jtf_titulo = new JTextField();
		jtf_titulo.setPreferredSize(new Dimension(200,20));
		jp_cadastro.add(jtf_titulo);
		
		jl_subtitulo = new JLabel("Subtítulo: ",JLabel.RIGHT);
		jl_subtitulo.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(jl_subtitulo);
		
		jtf_subtitulo = new JTextField();
		jtf_subtitulo.setPreferredSize(new Dimension(200,20));
		jp_cadastro.add(jtf_subtitulo);
		
		jl_disqueteira = new JLabel("Disqueteira: ",JLabel.RIGHT);
		jl_disqueteira.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(jl_disqueteira);
		
		snm_disqueteira = new SpinnerNumberModel(1,1,1000,1);
		js_disqueteira = new JSpinner(snm_disqueteira);
		js_disqueteira.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(js_disqueteira);
		
		jl_pag = new JLabel("Página: ",JLabel.RIGHT);
		jl_pag.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(jl_pag);
		
		snm_pag = new SpinnerNumberModel(1,1,1000,1);
		js_pag = new JSpinner(snm_pag);
		js_pag.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(js_pag);
		
		jl_casela = new JLabel("Casela: ",JLabel.RIGHT);
		jl_casela.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(jl_casela);
		
		snm_casela = new SpinnerNumberModel(1,1,1000,1);
		js_casela = new JSpinner(snm_casela);
		js_casela.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(js_casela);
	}
	
	public void eventos() 
	{
		
	}
	
	public void cria_tabela()
	{
		super.jt_tabela = new JTable();
		jt_tabela.setModel(obj_pc.preenche_jtable(Model_Sql.getConsultaGeral()));
		super.jt_tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		super.jt_tabela.setAutoCreateRowSorter(true);
		super.jt_tabela.getTableHeader().setReorderingAllowed(false);
		super.jt_tabela.getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
		super.jt_tabela.getColumnModel().getColumn( 0 ).setMinWidth( 0 );
		super.jt_tabela.getTableHeader().getColumnModel().getColumn( 0 ).setMaxWidth( 0 );
		super.jt_tabela.getTableHeader().getColumnModel().getColumn( 0 ).setMinWidth( 0 );
		int column_count = super.jt_tabela.getColumnCount();
		for(int i=1;i<column_count;i++)
		{
			super.jt_tabela.getColumnModel().getColumn(i).setMinWidth(150);
		}
		super.jsp_tabela.setViewportView(super.jt_tabela);
	}
	
	public void clique_tabela()
	{
		jt_tabela.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e) 
			{
				JTable alvo = (JTable) e.getSource();
				int linha = alvo.getSelectedRow();
				
				//a04_codigo = Integer.parseInt(jt_tabela.getValueAt(linha,0).toString());
				
				//jtf_nome.setText(jt_tabela.getValueAt(linha,1).toString());
			}
		});
	}
}
