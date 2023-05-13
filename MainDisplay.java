import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

class MainDisplay extends JFrame implements ActionListener{

    JLabel tabLabel;
    JLabel buttonLabel;
    
    JPanel mainPanel;
    JPanel buttonPanel;
    JPanel buttonPanelHolder;
    JPanel tabPanel;

    JTextArea tabArea;
    
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu optionsMenu;
    JMenu audioMenu;

MainDisplay(){

    tabLabel = new JLabel("Tabs for [song]");
    buttonLabel = new JLabel("Options");

    mainPanel = new JPanel();
    buttonPanel = new JPanel();
    buttonPanelHolder = new JPanel();
    tabPanel = new JPanel();
    tabArea = new JTextArea("Hello");
    
    button1 = new JButton("Start Tabbing");
    button2 = new JButton("Stop Tabbing");
    button3 = new JButton("Edit Tab");
    button4 = new JButton("Clear Tab");
    button5 = new JButton("Add to Tab");

    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    optionsMenu = new JMenu("Options");
    audioMenu = new JMenu("Audio Settings");

    fileMenu.add(createNewItem("New File","NEWFILE",this, KeyEvent.VK_N, KeyEvent.VK_N, "Create a new a file."));
    fileMenu.add(createNewItem("Open File","OPENFILE",this, KeyEvent.VK_O, KeyEvent.VK_O, "Open a file."));
    fileMenu.add(createNewItem("Save File","SAVEFILE",this, KeyEvent.VK_S, KeyEvent.VK_S, "Save an existing file."));
    
    optionsMenu.add(createNewItem("Settings","OPENSETTINGS",this, KeyEvent.VK_Q, KeyEvent.VK_Q, "Open the settings window."));
    
    audioMenu.add(createNewItem("Audio Source","AUDIOSOURCE",this, KeyEvent.VK_A, KeyEvent.VK_A, "Open the audio source window."));
    
    menuBar.add(fileMenu);
    menuBar.add(optionsMenu);
    menuBar.add(audioMenu);

    setLayout(new GridBagLayout());
    mainPanel.setLayout(new GridBagLayout());
    buttonPanel.setLayout(new GridBagLayout());
    buttonPanelHolder.setLayout(new GridBagLayout());
    tabPanel.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    
    constraints.anchor = GridBagConstraints.WEST;
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weighty = .1;
    tabPanel.add(tabLabel,constraints);
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.weighty = .9;
    constraints.ipadx = 750;
    constraints.ipady = 500;
    tabPanel.add(tabArea,constraints);

    constraints.fill = GridBagConstraints.HORIZONTAL;
    // constraints.weightx = 0.5;

    constraints.ipadx = 150;
    constraints.ipady = 5;

    constraints.gridx = 0;
    constraints.gridy = 0;
    buttonPanel.add(button1,constraints);

    constraints.gridx = 0;
    constraints.gridy = 1;
    buttonPanel.add(button2,constraints);

    constraints.gridx = 0;
    constraints.gridy = 2;
    buttonPanel.add(button3,constraints);

    constraints.gridx = 0;
    constraints.gridy = 3;
    buttonPanel.add(button4,constraints);

    constraints.gridx = 0;
    constraints.gridy = 4;
    buttonPanel.add(button5,constraints);
    
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.ipadx = 20;
    constraints.ipady = 10;
    buttonPanelHolder.add(buttonLabel,constraints);
    
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.ipadx = 50;
    constraints.ipady = 100;
    buttonPanelHolder.add(buttonPanel,constraints);
    
    constraints.weightx = 0.5;
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.ipadx = 10;
    constraints.ipady = 50;
    constraints.anchor = GridBagConstraints.WEST;
    mainPanel.add(tabPanel,constraints);

    constraints.weightx = 0.5;
    constraints.gridx = 1;
    constraints.gridy = 0;
    constraints.ipadx = 10;
    constraints.ipady = 50;
    constraints.anchor = GridBagConstraints.EAST;
    mainPanel.add(buttonPanelHolder,constraints);



    setJMenuBar(menuBar);
    add(mainPanel);

    Border border = BorderFactory.createLineBorder(Color.BLACK);
    tabArea.setBorder(BorderFactory.createCompoundBorder(border,
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
    buttonPanel.setBorder(BorderFactory.createCompoundBorder(border,
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    setupMainFrame(75,75,"Tab Creator");

}
void setupMainFrame(int xScreenPercentage,
                    int yScreenPercentage,
                    String title          )
{
	Toolkit    tk;												//Mainframe code
	Dimension   d;

	setDefaultCloseOperation(EXIT_ON_CLOSE);

	tk = Toolkit.getDefaultToolkit();
	d = tk.getScreenSize();
	setSize(xScreenPercentage * d.width/100,
	        yScreenPercentage * d.height/100);

	setLocation((100-xScreenPercentage)*d.width/200,
	            (100-yScreenPercentage)*d.height/200);

	setTitle(title);  // For the title bar

	setMinimumSize(new Dimension(600,600));

	setVisible(true);

}  // end of setupMainFrame()

private JMenuItem createNewItem(String name,
						  String actCom,
						  ActionListener menuListener,
						  int mnemonic,
						  int keyCode,
						  String toolTipText)
{
	JMenuItem item;												//create menu items

	item = new JMenuItem(name,mnemonic);
	item.setAccelerator(KeyStroke.getKeyStroke(keyCode, KeyEvent.ALT_DOWN_MASK));
	item.setToolTipText(toolTipText);
	item.setActionCommand(actCom);
	item.addActionListener(menuListener);

	return item;
}

public void actionPerformed(ActionEvent ae){
    
    if(ae.getActionCommand().equals("NEWFILE")){
        System.out.println(ae.getActionCommand());
    }
    if(ae.getActionCommand().equals("OPENFILE")){
        System.out.println(ae.getActionCommand());
    }
    if(ae.getActionCommand().equals("SAVEFILE")){
        System.out.println(ae.getActionCommand());
    }
    if(ae.getActionCommand().equals("OPENSETTINGS")){
        System.out.println(ae.getActionCommand());
    }
    if(ae.getActionCommand().equals("AUDIOSOURCE")){
        System.out.println(ae.getActionCommand());
        AudioSourceWindow asw = new AudioSourceWindow();
    }


}
}