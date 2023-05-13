import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

class AudioSourceWindow extends JDialog{


AudioSourceWindow(){

    setupMainFrame(35,40, "Audio Settings");

}

void setupMainFrame(int xScreenPercentage,
                    int yScreenPercentage,
                    String title          )
{
	Toolkit    tk;												//Mainframe code
	Dimension   d;

    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
}