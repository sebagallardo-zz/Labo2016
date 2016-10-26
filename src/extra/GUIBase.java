package extra;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class GUIBase extends JFrame {
	
	public GUIBase(){
		iniMenu();
		basicGUI();
		setLocationRelativeTo(null);
		this.setLayout(new FlowLayout());
	}
	
	public void setBase(){
		setLocationRelativeTo(null);
	}
	
	
	private void basicGUI(){
		setTitle("GUIBase");
		setSize(920, 480);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void iniMenu() {

        JMenuBar menubar	= new JMenuBar();
//        ImageIcon icon 		= new ImageIcon(getClass().getResource("exit24.png"));
        JMenu file 			= new JMenu("File");
        JMenuItem exitMItem = new JMenuItem("Exit"/*, icon*/);
        
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

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                GUIBase ex = new GUIBase();
                ex.setVisible(true);
            }
        });
    }
	
}