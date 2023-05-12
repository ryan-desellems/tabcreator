import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class MainDisplay extends JFrame{

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
    
    button1 = new JButton("Button");
    button2 = new JButton("Button");
    button3 = new JButton("Button");
    button4 = new JButton("Button");
    button5 = new JButton("Button");

    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    optionsMenu = new JMenu("Options");
    audioMenu = new JMenu("Audio Settings");

    fileMenu.add(createMenuItem("New File"));
    fileMenu.add(createMenuItem("Open File"));
    fileMenu.add(createMenuItem("Save File"));

    optionsMenu.add(createMenuItem("Settings"));

    audioMenu.add(createMenuItem("Choose Audio Source"));
    
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
    constraints.ipadx = 500;
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

JMenuItem createMenuItem(String menuName){
    return new JMenuItem(menuName);
}

}