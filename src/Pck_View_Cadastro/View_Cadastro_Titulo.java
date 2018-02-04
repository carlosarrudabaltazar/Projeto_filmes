package Pck_View_Cadastro;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Pck_Control.Control_Filmes;
import Pck_Control.Control_Genero_Filme;
import Pck_Control.Control_Local;
import Pck_Control.Control_Local_Filme;

public class View_Cadastro_Titulo extends View_Model
{
	private static final long serialVersionUID = 1L;
	
	Control_Preenche_Componentes obj_pc = new Control_Preenche_Componentes();
	Control_Filmes obj_ctrl_filme = new Control_Filmes();
	Control_Genero_Filme obj_ctrl_gen_filme = new Control_Genero_Filme();
	Control_Local obj_ctrl_local = new Control_Local();
	Control_Local_Filme obj_ctrl_local_filme = new Control_Local_Filme();
	
	private JComboBox<String> jcb_genero;
	private JComboBox<String> jcb_disqueteira;
	
	private JLabel jl_genero;
	private JLabel jl_titulo;
	private JLabel jl_subtitulo;
	private JLabel jl_disqueteira;
	private JLabel jl_pag;
	private JLabel jl_casela;
	
	private JTextField jtf_titulo;
	private JTextField jtf_subtitulo;
	
	private SpinnerNumberModel snm_pag;
	private SpinnerNumberModel snm_casela;
	
	private JSpinner js_pag;
	private JSpinner js_casela;
		
	ArrayList<Integer> codigo_genero;
	ArrayList<Integer> codigo_disqueteira;
	
	int [] aux = new int[2];
	
	int a01_id;
	int a02_id;
	int a03_id;
	int a04_id;
	int a05_id;
	int a06_id;
	
	public View_Cadastro_Titulo()
	{
		inicia_componentes();
		Eventos();
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
		codigo_genero = obj_pc.preenche_jcombobox(Model_Sql.getConsultaGenero(), "ID", "GENERO", jcb_genero);
		jcb_genero.setPreferredSize(new Dimension(200,20));
		jp_cadastro.add(jcb_genero);
		
		jl_titulo = new JLabel("Título: ",JLabel.RIGHT);
		jl_titulo.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(jl_titulo);
		
		jtf_titulo = new JTextField();
		jtf_titulo.setPreferredSize(new Dimension(200,20));
		jtf_titulo.setEnabled(false);
		jp_cadastro.add(jtf_titulo);
		
		jl_subtitulo = new JLabel("Subtitulo: ",JLabel.RIGHT);
		jl_subtitulo.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(jl_subtitulo);
		
		jtf_subtitulo = new JTextField();
		jtf_subtitulo.setPreferredSize(new Dimension(200,20));
		jtf_subtitulo.setEnabled(false);
		jp_cadastro.add(jtf_subtitulo);
		
		jl_disqueteira = new JLabel("Disqueteira: ",JLabel.RIGHT);
		jl_disqueteira.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(jl_disqueteira);
		
		jcb_disqueteira = new JComboBox<String>();
		codigo_disqueteira = obj_pc.preenche_jcombobox(Model_Sql.getConsultaDisqueteira(), "ID", "DISQUETEIRA", jcb_disqueteira);
		jcb_disqueteira.setPreferredSize(new Dimension(200,20));
		jcb_disqueteira.setEnabled(false);
		jp_cadastro.add(jcb_disqueteira);
		
		jl_pag = new JLabel("Página: ",JLabel.RIGHT);
		jl_pag.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(jl_pag);
		
		snm_pag = new SpinnerNumberModel(1,1,1000,1);
		js_pag = new JSpinner(snm_pag);
		js_pag.setPreferredSize(new Dimension(150,20));
		js_pag.setEnabled(false);
		jp_cadastro.add(js_pag);
		
		jl_casela = new JLabel("Casela: ",JLabel.RIGHT);
		jl_casela.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(jl_casela);
		
		snm_casela = new SpinnerNumberModel(1,1,1000,1);
		js_casela = new JSpinner(snm_casela);
		js_casela.setPreferredSize(new Dimension(150,20));
		js_casela.setEnabled(false);
		jp_cadastro.add(js_casela);
	}
	
	public void Eventos() 
	{
		jcb_genero.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				jtf_titulo.setEnabled(true);
				jtf_subtitulo.setEnabled(true);
				jcb_disqueteira.setEnabled(true);

				cria_tabela();
				clique_tabela();
			}
		});
		
		jcb_disqueteira.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				js_pag.setEnabled(true);
				js_casela.setEnabled(true);

				cria_tabela();
				clique_tabela();
			}
		});
		
		super.jb_inserir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				a04_id = obj_ctrl_filme.inserir(jtf_titulo.getText(), jtf_subtitulo.getText());
				a03_id = obj_ctrl_local.inserir(codigo_disqueteira.get(jcb_disqueteira.getSelectedIndex()), Integer.parseInt(js_pag.getValue().toString()), Integer.parseInt(js_casela.getValue().toString()));
				obj_ctrl_gen_filme.inserir(a04_id,codigo_genero.get(jcb_genero.getSelectedIndex()));
				obj_ctrl_local_filme.inserir(a03_id, a04_id);
				
				jcb_genero.setSelectedIndex(0);
				jtf_titulo.setText("");
				jtf_subtitulo.setText("");
				jcb_disqueteira.setSelectedIndex(0);
				js_pag.setValue(1);
				js_casela.setValue(1);
				
				jcb_genero.setSelectedIndex(0);
				jtf_titulo.setText("");
				jtf_subtitulo.setText("");
				jcb_disqueteira.setSelectedIndex(0);
				js_pag.setValue(1);
				js_casela.setValue(1);
				
				cria_tabela();
				clique_tabela();
			}
		});
		
		super.jb_alterar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				obj_ctrl_filme.alterar(a04_id, jtf_titulo.getText(), jtf_subtitulo.getText());
				obj_ctrl_local.alterar(a03_id, codigo_disqueteira.get(jcb_disqueteira.getSelectedIndex()), Integer.parseInt(js_pag.getValue().toString()), Integer.parseInt(js_casela.getValue().toString()));
				obj_ctrl_gen_filme.alterar(a05_id, a04_id, codigo_genero.get(jcb_genero.getSelectedIndex()));
				obj_ctrl_local_filme.alterar(a06_id, a03_id, a04_id);
				
				jcb_genero.setSelectedIndex(0);
				jtf_titulo.setText("");
				jtf_subtitulo.setText("");
				jcb_disqueteira.setSelectedIndex(0);
				js_pag.setValue(1);
				js_casela.setValue(1);
				
				cria_tabela();
				clique_tabela();
			}
		});
		
		super.jb_remover.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				obj_ctrl_filme.remover(a04_id);
				obj_ctrl_gen_filme.remover(a05_id);
				obj_ctrl_local.remover(a03_id);
				obj_ctrl_local_filme.remover(a06_id);
				
				jcb_genero.setSelectedIndex(0);
				jtf_titulo.setText("");
				jtf_subtitulo.setText("");
				jcb_disqueteira.setSelectedIndex(0);
				js_pag.setValue(1);
				js_casela.setValue(1);

				cria_tabela();
				clique_tabela();
			}
		});
		
		super.jb_limpar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				jcb_genero.setSelectedIndex(0);
				jtf_titulo.setText("");
				jtf_subtitulo.setText("");
				jcb_disqueteira.setSelectedIndex(0);
				js_pag.setValue(1);
				js_casela.setValue(1);

				cria_tabela();
				clique_tabela();
			}
		});
		
		super.jb_sair.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});		
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
		
		super.jt_tabela.getColumnModel().getColumn( 1 ).setMaxWidth( 0 );
		super.jt_tabela.getColumnModel().getColumn( 1 ).setMinWidth( 0 );
		super.jt_tabela.getTableHeader().getColumnModel().getColumn( 1 ).setMaxWidth( 0 );
		super.jt_tabela.getTableHeader().getColumnModel().getColumn( 1 ).setMinWidth( 0 );
		
		super.jt_tabela.getColumnModel().getColumn( 2 ).setMaxWidth( 0 );
		super.jt_tabela.getColumnModel().getColumn( 2 ).setMinWidth( 0 );
		super.jt_tabela.getTableHeader().getColumnModel().getColumn( 2 ).setMaxWidth( 0 );
		super.jt_tabela.getTableHeader().getColumnModel().getColumn( 2 ).setMinWidth( 0 );
		
		super.jt_tabela.getColumnModel().getColumn( 3 ).setMaxWidth( 0 );
		super.jt_tabela.getColumnModel().getColumn( 3 ).setMinWidth( 0 );
		super.jt_tabela.getTableHeader().getColumnModel().getColumn( 3 ).setMaxWidth( 0 );
		super.jt_tabela.getTableHeader().getColumnModel().getColumn( 3 ).setMinWidth( 0 );
		
		super.jt_tabela.getColumnModel().getColumn( 4 ).setMaxWidth( 0 );
		super.jt_tabela.getColumnModel().getColumn( 4 ).setMinWidth( 0 );
		super.jt_tabela.getTableHeader().getColumnModel().getColumn( 4 ).setMaxWidth( 0 );
		super.jt_tabela.getTableHeader().getColumnModel().getColumn( 4 ).setMinWidth( 0 );
		
		super.jt_tabela.getColumnModel().getColumn( 5 ).setMaxWidth( 0 );
		super.jt_tabela.getColumnModel().getColumn( 5 ).setMinWidth( 0 );
		super.jt_tabela.getTableHeader().getColumnModel().getColumn( 5 ).setMaxWidth( 0 );
		super.jt_tabela.getTableHeader().getColumnModel().getColumn( 5 ).setMinWidth( 0 );
		
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
				
				a01_id = Integer.parseInt(jt_tabela.getValueAt(linha,0).toString());
				a02_id = Integer.parseInt(jt_tabela.getValueAt(linha,1).toString());
				a03_id = Integer.parseInt(jt_tabela.getValueAt(linha,2).toString());
				a04_id = Integer.parseInt(jt_tabela.getValueAt(linha,3).toString());
				a05_id = Integer.parseInt(jt_tabela.getValueAt(linha,4).toString());
				a06_id = Integer.parseInt(jt_tabela.getValueAt(linha,5).toString());
				
				jcb_genero.setSelectedIndex(a01_id);
				jtf_titulo.setText(jt_tabela.getValueAt(linha,6).toString());
				jtf_subtitulo.setText(jt_tabela.getValueAt(linha,7).toString());
				jcb_disqueteira.setSelectedIndex(a02_id);
				js_pag.setValue(Integer.parseInt(jt_tabela.getValueAt(linha,10).toString()));
				js_casela.setValue(Integer.parseInt(jt_tabela.getValueAt(linha,11).toString()));
			}
		});
	}
}
