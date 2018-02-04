package Pck_View_Cadastro;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

import Pck_View.View_Model;
import Pck_Control.Control_Preenche_Componentes;
import Pck_Control.Control_Disqueteira;
import Pck_Model.Model_Sql;

public class View_Cadastro_Disqueteira extends View_Model
{
	private static final long serialVersionUID = 1L;
	
	Control_Preenche_Componentes obj_pc = new Control_Preenche_Componentes();
	Control_Disqueteira obj_control = new Control_Disqueteira();
	
	JLabel jl_disqueteira;
	
	SpinnerNumberModel smn_disqueteira;
	
	JSpinner js_disqueteira;
	
	int a02_id;
	
	public View_Cadastro_Disqueteira()
	{
		Inicia_Componentes();
		Eventos();
		cria_tabela();
		clique_tabela(js_disqueteira);
	}
	
	public void Inicia_Componentes()
	{
		this.setTitle("Cadastro de Disqueteira");
		jp_cadastro.setLayout(new FlowLayout(0,0,30));
		jp_cadastro.setPreferredSize(new Dimension(400,440));
		
		jl_disqueteira = new JLabel("Disqueteira: ",JLabel.RIGHT);
		jl_disqueteira.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(jl_disqueteira);
		
		smn_disqueteira = new SpinnerNumberModel(1,1,1000,1);
		js_disqueteira = new JSpinner(smn_disqueteira);
		js_disqueteira.setPreferredSize(new Dimension(150,20));
		jp_cadastro.add(js_disqueteira);
	}
	
	public void Eventos() 
	{
		super.jb_inserir.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				obj_control.inserir((Integer) js_disqueteira.getValue());
				cria_tabela();
				clique_tabela(js_disqueteira);
			}
		});
		
		super.jb_alterar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				obj_control.alterar(a02_id,Integer.parseInt(js_disqueteira.getValue().toString()));
				cria_tabela();
				clique_tabela(js_disqueteira);
			}
		});
		
		super.jb_remover.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				obj_control.remover(a02_id);
				cria_tabela();
				clique_tabela(js_disqueteira);
			}
		});
		
		super.jb_limpar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				js_disqueteira.setValue(1);
				cria_tabela();
				clique_tabela(js_disqueteira);
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
		jt_tabela.setModel(obj_pc.preenche_jtable(Model_Sql.getConsultaDisqueteira()));
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
	
	public void clique_tabela(JSpinner js_spinner)
	{
		jt_tabela.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e) 
			{
				JTable alvo = (JTable) e.getSource();
				int linha = alvo.getSelectedRow();
				
				a02_id = Integer.parseInt(jt_tabela.getValueAt(linha,0).toString());
				js_spinner.setValue(jt_tabela.getValueAt(linha,1));
			}
		});
	}
}
