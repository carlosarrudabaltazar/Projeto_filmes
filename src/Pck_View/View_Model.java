package Pck_View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class View_Model extends JDialog{
	
	private static final long serialVersionUID = 1L;

	protected ImageIcon img_icone;
	protected ImageIcon img_inserir;
	protected ImageIcon img_alterar;
	protected ImageIcon img_remover;
	protected ImageIcon img_limpar;
	protected ImageIcon img_sair;
	
	protected JPanel jp_principal;
	protected JPanel jp_botoes;
	protected JPanel jp_cadastro;
	
	protected JScrollPane jsp_cadastro;
	protected JScrollPane jsp_tabela;
	
	protected JButton jb_inserir;
	protected JButton jb_alterar;
	protected JButton jb_remover;
	protected JButton jb_limpar;
	protected JButton jb_sair;
	
	protected JTable jt_tabela;
	
	public View_Model()
	{
		img_icone = new ImageIcon(getClass().getResource("/Pck_Imagens/Logo_corinto_branco.png"));
		
		img_inserir = new ImageIcon(getClass().getResource("/Pck_Imagens/img_inserir.png"));
		img_alterar = new ImageIcon(getClass().getResource("/Pck_Imagens/img_alterar.png"));
		img_remover = new ImageIcon(getClass().getResource("/Pck_Imagens/img_remover.png"));
		img_limpar = new ImageIcon(getClass().getResource("/Pck_Imagens/img_limpar.png"));
		img_sair = new ImageIcon(getClass().getResource("/Pck_Imagens/img_sair.png"));
		
		this.setTitle("Título");
		this.setSize(800,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setIconImage(img_icone.getImage());
		this.setLayout(new BorderLayout());
		
		jp_botoes = new JPanel();
		jp_botoes.setLayout(new FlowLayout(0,5,5));
		this.getContentPane().add("North",jp_botoes);
		
			jb_inserir = new JButton();
			jb_inserir.setIcon(img_inserir);
			jb_inserir.setToolTipText("Inserir");
			jb_inserir.setPreferredSize(new Dimension(50,50));
			jp_botoes.add(jb_inserir);
			
			jb_alterar = new JButton();
			jb_alterar.setIcon(img_alterar);
			jb_alterar.setToolTipText("Alterar");
			jb_alterar.setPreferredSize(new Dimension(50,50));
			jp_botoes.add(jb_alterar);
			
			jb_remover = new JButton();
			jb_remover.setIcon(img_remover);
			jb_remover.setToolTipText("Remover");
			jb_remover.setPreferredSize(new Dimension(50,50));
			jp_botoes.add(jb_remover);
			
			jb_limpar = new JButton();
			jb_limpar.setIcon(img_limpar);
			jb_limpar.setToolTipText("Limpar");
			jb_limpar.setPreferredSize(new Dimension(50,50));
			jp_botoes.add(jb_limpar);
			
			jb_sair = new JButton();
			jb_sair.setIcon(img_sair);
			jb_sair.setToolTipText("sair");
			jb_sair.setPreferredSize(new Dimension(50,50));
			jp_botoes.add(jb_sair);
		
		jp_principal = new JPanel();
		jp_principal.setLayout(new GridLayout(1,2));
		this.getContentPane().add("Center",jp_principal);
		
			jsp_cadastro = new JScrollPane();
			
				jp_cadastro = new JPanel();
				jsp_cadastro.setViewportView(jp_cadastro);
				jp_principal.add(jsp_cadastro);
				
			jsp_tabela = new JScrollPane();
			
				jt_tabela = new JTable();
				jsp_tabela.setViewportView(jt_tabela);
				jp_principal.add(jsp_tabela);
	}
	
}
