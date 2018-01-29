package Pck_View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JOptionPane;

import Pck_Database.Database_Creation;

public class View_Initial extends JFrame{
	private static final long serialVersionUID = 1L;
	
	JPanel jp_logo;
	JPanel jp_barra;
	JLabel jl_logo;
	JLabel jl_autor;
	
	ImageIcon img_logo;
	ImageIcon img_icone;
	
	static JProgressBar jpb_inicial;

	public View_Initial()
	{
		Inicia_Componentes();
	}
	
	public void Inicia_Componentes()
	{
		img_icone = new ImageIcon(getClass().getResource("/Pck_Images/Movie.jpg"));
		
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setIconImage(img_icone.getImage());
		this.setLayout(new BorderLayout());
		
		jp_logo = new JPanel();
		jp_logo.setBackground(Color.white);
		jp_logo.setLayout(new BorderLayout());
		getContentPane().add("Center",jp_logo);
		
			img_logo = new ImageIcon(getClass().getResource("/Pck_Images/Movie.jpg"));
			
			jl_logo = new JLabel(img_logo);
			jp_logo.add("Center", jl_logo);
			
			jl_autor = new JLabel("Controle de acervo \t © 2016 Carlos Arruda Baltazar \t TODOS OS DIREITOS RESERVADOS");
			jp_logo.add("South", jl_autor);
		
		jp_barra = new JPanel();
		jp_barra.setLayout(new BorderLayout());
		getContentPane().add("South",jp_barra);
		
			jpb_inicial = new JProgressBar();
			jpb_inicial.setStringPainted(true);
			jpb_inicial.setValue(0);
			jp_barra.add("Center",jpb_inicial);
	}
	
	public static void main(String[]args)
	{
		View_Initial obj_view = new View_Initial();
		obj_view.setVisible(true);
		for(int i=0;i<=100;i++)
		
		{    
			try 
			{  
				jpb_inicial.setValue(i);  
				jpb_inicial.setString(i + "%");  
				Thread.sleep(20);
				if(i==50)
				{
					jpb_inicial.setString(i + "% Criando Bando de Dados");
					File bd = new File("Movies.db");
					if(bd.exists() != true)
					{
						System.out.println("Criando o banco de dados.");
						
						Database_Creation.Database();
						System.out.println("Banco de dados criado com sucesso.");
					}
				}
				if(i==100)
				{
					jpb_inicial.setString(i + "% Iniciando Aplicação");
					obj_view.dispose();
					View_Principal obj_principal = new View_Principal();
					obj_principal.setVisible(true);
				}
			} 
			catch (InterruptedException e) 
			{  
				JOptionPane.showMessageDialog(null,"Erro ao Iniciar o Software"+e.toString());  
			}	
        }
	}
}
