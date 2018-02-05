package Pck_View_Consulta;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;

import Pck_View.View_Model;
import Pck_Control.Control_Preenche_Componentes;
import Pck_Model.Model_Sql;

public class View_Consulta extends View_Model
{
	private static final long serialVersionUID = 1L;
	
	Control_Preenche_Componentes obj_pc = new Control_Preenche_Componentes();
	
	private JTextField jtf_titulo;
	private JTextField jtf_subtitulo;
	
	private ButtonGroup bg_consulta;
	
	private JRadioButton jrb_titulo;
	private JRadioButton jrb_subtitulo;
	
	public View_Consulta()
	{
		inicia_componentes();
		Eventos();
		cria_tabela(Model_Sql.getConsultaGeral());
		//clique_tabela();
	}
	
	public void inicia_componentes()
	{
		this.setTitle("Consulta");
		jp_cadastro.setLayout(new FlowLayout(0,0,30));
		jp_cadastro.setPreferredSize(new Dimension(400,440));
		
		bg_consulta = new ButtonGroup();
		
		jrb_titulo = new JRadioButton("Título: ");
		jrb_titulo.setPreferredSize(new Dimension(150,20));
		bg_consulta.add(jrb_titulo);
		jp_cadastro.add(jrb_titulo);
		
		jtf_titulo = new JTextField();
		jtf_titulo.setPreferredSize(new Dimension(200,20));
		jtf_titulo.setEnabled(false);
		jp_cadastro.add(jtf_titulo);
		
		jrb_subtitulo = new JRadioButton("Subtitulo: ");
		jrb_subtitulo.setPreferredSize(new Dimension(150,20));
		bg_consulta.add(jrb_subtitulo);
		jp_cadastro.add(jrb_subtitulo);
		
		jtf_subtitulo = new JTextField();
		jtf_subtitulo.setPreferredSize(new Dimension(200,20));
		jtf_subtitulo.setEnabled(false);
		jp_cadastro.add(jtf_subtitulo);
		
		super.jb_alterar.setEnabled(false);
		super.jb_remover.setEnabled(false);
	}
	
	public void Eventos()
	{
		jrb_titulo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				jtf_titulo.setEnabled(true);
				jtf_subtitulo.setEnabled(false);
			}
		});	
		
		jrb_subtitulo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				jtf_titulo.setEnabled(false);
				jtf_subtitulo.setEnabled(true);
			}
		});	
		
		super.jb_inserir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(jrb_titulo.isSelected())
				{
					cria_tabela1(Model_Sql.getConsultaTitulo(),jtf_titulo.getText());
				}
				else if (jrb_subtitulo.isSelected())
				{
					cria_tabela1(Model_Sql.getConsultaSubtitulo(),jtf_subtitulo.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Não há nenhum tipo de consulta selecionado","Erro!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});	
				
		super.jb_limpar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				jtf_titulo.setText("");
				jtf_subtitulo.setText("");
				jrb_titulo.setSelected(false);
				jrb_subtitulo.setSelected(false);
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
	
	public void cria_tabela(String sql)
	{
		super.jt_tabela = new JTable();
		jt_tabela.setModel(obj_pc.preenche_jtable(sql));
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
	
	public void cria_tabela1(String sql, String parametro)
	{
		super.jt_tabela = new JTable();
		jt_tabela.setModel(obj_pc.preenche_jtable1(sql, parametro));
		super.jt_tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		super.jt_tabela.setAutoCreateRowSorter(true);
		super.jt_tabela.getTableHeader().setReorderingAllowed(false);
		
		int column_count = super.jt_tabela.getColumnCount();
		for(int i=1;i<column_count;i++)
		{
			super.jt_tabela.getColumnModel().getColumn(i).setMinWidth(150);
		}
		super.jsp_tabela.setViewportView(super.jt_tabela);
	}
}
