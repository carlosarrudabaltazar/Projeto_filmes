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

public class View_Principal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	ImageIcon img_icone;
	ImageIcon img_logo;
	
	JMenuBar jmb_principal;
	
	JMenu jm_cadastro;
	JMenu jm_consulta;
	JMenu jm_relatorio;
	JMenu jm_sobre;
	
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
			
			jm_consulta = new JMenu("Consulta");
			jmb_principal.add(jm_consulta);
			
			jm_relatorio = new JMenu("Relatórios");
			jmb_principal.add(jm_relatorio);
			
			jm_sobre = new JMenu("Sobre");
			jmb_principal.add(jm_sobre);
			
		jl_logo = new JLabel(img_logo);
		getContentPane().add("Center",jl_logo);
		
		jl_autor = new JLabel("© 2016 Carlos Arruda Baltazar \t TODOS OS DIREITOS RESERVADOS");
		getContentPane().add("South",jl_autor);
	}
	
	public void Define_Eventos()
	{
		
	}

}
