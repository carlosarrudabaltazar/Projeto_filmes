package Pck_View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Pck_View_Cadastro.View_Cadastro;

public class View_Principal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	ImageIcon img_icone;
	ImageIcon img_logo;
	
	JMenuBar jmb_principal;
	
	JMenuItem jmi_cadastro;
	JMenuItem jmi_consulta;
	JMenuItem jmi_relatorio;
	JMenuItem jmi_sobre;
	
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
		
			jmi_cadastro = new JMenuItem("Cadastro");
			jmb_principal.add(jmi_cadastro);
			
			jmi_consulta = new JMenuItem("Consulta");
			jmb_principal.add(jmi_consulta);
			
			jmi_relatorio = new JMenuItem("Relatórios");
			jmb_principal.add(jmi_relatorio);
			
			jmi_sobre = new JMenuItem("Sobre");
			jmb_principal.add(jmi_sobre);
			
		jl_logo = new JLabel(img_logo);
		getContentPane().add("Center",jl_logo);
		
		jl_autor = new JLabel("© 2016 Carlos Arruda Baltazar \t TODOS OS DIREITOS RESERVADOS");
		getContentPane().add("South",jl_autor);
	}
	
	public void Define_Eventos()
	{
		jmi_cadastro.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				View_Cadastro obj_cadastro = new View_Cadastro();
				obj_cadastro.setVisible(true);
			}
		});
	}

}
