package Pck_View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Pck_View_Cadastro.View_Cadastro_Disqueteira;
import Pck_View_Cadastro.View_Cadastro_Titulo;
import Pck_View_Consulta.View_Consulta;

public class View_Principal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	ImageIcon img_icone;
	ImageIcon img_logo;
	
	JMenuBar jmb_principal;
	
	JMenu jm_cadastro;
	
	JMenuItem jmi_cadastro_titulo;
	JMenuItem jmi_cadastro_disqueteira;
	JMenuItem jmi_consulta;
	//JMenuItem jmi_relatorio;
	//JMenuItem jmi_sobre;
	
	JLabel jl_logo;
	
	JLabel jl_autor;
	
	public View_Principal()
	{
		Inicia_Componentes();
		Define_Eventos();
	}
	
	public void Inicia_Componentes()
	{
		img_icone = new ImageIcon(getClass().getResource("/Pck_Images/Movie.jpg"));
		img_logo = new ImageIcon(getClass().getResource("/Pck_Images/Movie.jpg"));
		
		this.setTitle("Controle de acervo ALPHA v1.0");
		this.setSize(800,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setIconImage(img_icone.getImage());
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jmb_principal = new JMenuBar();
		jmb_principal.setLayout(new FlowLayout(0,5,5));
		getContentPane().add("North",jmb_principal);
		
			jm_cadastro = new JMenu("Cadastro");
			jmb_principal.add(jm_cadastro);
			
				jmi_cadastro_titulo = new JMenuItem("Cadastrar Título");
				jm_cadastro.add(jmi_cadastro_titulo);
				
				jmi_cadastro_disqueteira = new JMenuItem("Cadastrar Disqueteira");
				jm_cadastro.add(jmi_cadastro_disqueteira);
			
			jmi_consulta = new JMenuItem("Consulta");
			jmb_principal.add(jmi_consulta);
			
			/*
			jmi_relatorio = new JMenuItem("Relatórios");
			jmb_principal.add(jmi_relatorio);
			
			jmi_sobre = new JMenuItem("Sobre");
			jmb_principal.add(jmi_sobre);
			*/
			
		jl_logo = new JLabel(img_logo);
		getContentPane().add("Center",jl_logo);
		
		jl_autor = new JLabel("©‎ 2016 Carlos Arruda Baltazar \t TODOS OS DIREITOS RESERVADOS");
		getContentPane().add("South",jl_autor);
	}
	
	public void Define_Eventos()
	{
		jmi_cadastro_titulo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				View_Cadastro_Titulo obj_titulo = new View_Cadastro_Titulo();
				obj_titulo.setVisible(true);
			}
		});
		
		jmi_cadastro_disqueteira.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				View_Cadastro_Disqueteira obj_disqueteira = new View_Cadastro_Disqueteira();
				obj_disqueteira.setVisible(true);
			}
		});
		
		jmi_consulta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				View_Consulta obj_consulta = new View_Consulta();
				obj_consulta.setVisible(true);
			}
		});
	}

}
