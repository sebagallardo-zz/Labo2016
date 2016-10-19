package practicas.cuatro;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class Visualizador extends JFrame {
	/* VARIABLES A USAR */
    java.io.File file;
	public static final String DEFAULT_CHARSET = "UTF-8";
    JScrollPane scrollPane;
    
    /* FIN VARIABLES */

    class ReadAndLoad {

        private List<String[]> read(java.io.File file){

            try (Stream<String> stream = Files.lines(Paths.get(file.toURI()))){
                
                return stream
                        .map(s -> s.split(":"))
                        .collect(Collectors.toList());

            } catch (IOException e1) {
                e1.printStackTrace();
            }
			return null;
        }
            
        private JTable load(List<String[]> list){
            String[] tableHeader 	= list.remove(0);
            DefaultTableModel model = new DefaultTableModel(tableHeader, 0);
            JTable table 			= new JTable(model);
            
            list.forEach(s -> model.addRow(s));
            
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
            return table;
        }
    }
    
	
    public Visualizador() {

        initUI();
    }

    private void initUI() {
    
        this.setLayout(new BorderLayout());
        scroll();
        buttonAndFileChooser();
        basicInit();
    }
    
    private void basicInit(){
    	createMenuBar();
    	setTitle("Visualizador de Archivos");
    	pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    private void scroll(){
    	scrollPane = 
    			new JScrollPane(
    					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
    					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
    			);
        scrollPane.setPreferredSize(new Dimension(550, 350));
        this.add(scrollPane, BorderLayout.NORTH);
    }
    
    private void buttonAndFileChooser(){
    	
    	JFileChooser  fileDialog 	= new JFileChooser();
        JButton abrir 				= new JButton("Open File");
        
        this.add(abrir, BorderLayout.SOUTH);
        abrir.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileDialog.showOpenDialog(Visualizador.this);
                
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    
                    file = fileDialog.getSelectedFile();
                    ReadAndLoad leer = new ReadAndLoad();
                    scrollPane.setViewportView(leer.load(leer.read(file)));
                    Visualizador.this.pack();
                }
            }
        });
        	
    }

    private void createMenuBar() {

    	JMenuBar menubar	= new JMenuBar();
        JMenu file 			= new JMenu("File");
        JMenuItem exitMItem = new JMenuItem("Exit");
        
        menubar.add(file);
        
        file.setMnemonic(KeyEvent.VK_F);
        file.add(exitMItem);
        
        exitMItem.setMnemonic(KeyEvent.VK_E);
        exitMItem.setAccelerator(
        		KeyStroke
        		.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK)
        );
        exitMItem.setToolTipText("Exit application");
        exitMItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			    System.exit(0);
			}
		});

        setJMenuBar(menubar);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Visualizador ex = new Visualizador();
            ex.setVisible(true);
        });
    }
}