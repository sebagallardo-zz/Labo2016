package practicas.cuatro;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


@SuppressWarnings("serial")
public class ListaColores extends JFrame {

	DefaultListModel<String> colores 
					= new DefaultListModel<>();
	
	JList<String> list 
					= new JList<String>(colores);
	
	JTextField text = new JTextField(20);
	JButton agregar = new JButton("Agregar");
	JButton borrar 	= new JButton("Borrar");
	
	
    public ListaColores() {

        initUI();
    }

    private void initUI() {
        
        createMenuBar();
        setList();
        this.add(text);
        setButtons();
        basicInit(); 
    }
    
    private void basicInit(){
    	this.setLayout(new FlowLayout());
    	setTitle("Lista de Colores");
    	pack();
    	//setSize(750, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    private void setList(){
    	    	
    	colores.addElement("Amarillo");
    	colores.addElement("Azul");
    	colores.addElement("Rojo");
    	colores.addElement("Verde");

      	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0); // list.setVisibleRowCount(4); 
        
    	
    	JScrollPane listScrollPane = new JScrollPane(list); 
    	listScrollPane.setPreferredSize(new Dimension(120, 100));
    	
    	this.add(listScrollPane);
    }
    
    
    private void setButtons(){
    	
    	agregar.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e){
    			colores.addElement(text.getText());
    		}
    		
    	});
    	
    	borrar.addActionListener(new ActionListener(){
    		
    		public void actionPerformed(ActionEvent e){
    			if (list.isSelectionEmpty()) { return; }
    			colores.remove(list.getSelectedIndex());
    			list.setSelectedIndex(list.getLeadSelectionIndex());
    		}
    	});
  
    	this.add(agregar);
    	this.add(borrar);
 	
    	
    }

    private void createMenuBar() {

        JMenuBar menubar 	= new JMenuBar();
        JMenu file 			= new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem eMenuItem = new JMenuItem("Exit");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        file.add(eMenuItem);

        menubar.add(file);

        setJMenuBar(menubar);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ListaColores ex = new ListaColores();
            ex.setVisible(true);
        });
    }
}