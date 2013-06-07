package imp.view;

import java.awt.Container;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

public class MainScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6771442546801658873L;

	JPanel pane = new JPanel();
	
	
	public MainScreen()
	{
		super("ImpudentSQL v0.1");
		setBounds(200, 200, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con =  this.getContentPane();
		con.add(pane);
		GroupLayout gl_pane = new GroupLayout(pane);
		gl_pane.setHorizontalGroup(
			gl_pane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 594, Short.MAX_VALUE)
		);
		gl_pane.setVerticalGroup(
			gl_pane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 472, Short.MAX_VALUE)
		);
		pane.setLayout(gl_pane);
		
		
		// Menu bar code
		JMenuBar menuBar;
		JMenu menuFile, menuHelp;
		JMenuItem export, options, quit, about;
		
		// Make menu bar
		menuBar = new JMenuBar();
		
		// Add File, Help
		menuFile = new JMenu("File");
		menuHelp = new JMenu("Help");
		
		// Add buttons
		export = new JMenuItem("Export Results as XML",
                KeyEvent.VK_X);
		menuFile.add(export);
		options = new JMenuItem("Options",
                KeyEvent.VK_O);
		menuFile.add(options);
		quit = new JMenuItem("Quit",
                KeyEvent.VK_Q);
		menuFile.add(quit);
		
		about = new JMenuItem("Quit",
                KeyEvent.VK_Q);
		menuFile.add(quit);
		
		// Set key helpers
		menuFile.setMnemonic(KeyEvent.VK_F);
		menuHelp.setMnemonic(KeyEvent.VK_H);
		
		// Add menu items to the bar
		menuBar.add(menuFile);
		menuBar.add(menuHelp);
		
		this.setJMenuBar(menuBar);
		
		
		
		setVisible(true);
		setResizable(false);
	}
}