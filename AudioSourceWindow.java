import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.util.*;
import java.io.*;

class AudioSourceWindow extends JDialog implements ActionListener{

JComboBox<AudioCombo> jcb;
JLabel                audioInputsLabel;
JButton               audioTestButton;
AudioSourceWindow(){



    jcb = new JComboBox<AudioCombo>();
    audioInputsLabel = new JLabel("Audio Inputs");
    audioTestButton = new JButton("Audio Test");
    audioTestButton.setActionCommand("TESTAUDIO");
    audioTestButton.addActionListener(this);

    ArrayList<AudioCombo> audioInputs = new ArrayList<AudioCombo>();
    Mixer.Info[] mixers = AudioSystem.getMixerInfo();
    for (Mixer.Info mixerInfo : mixers){
        audioInputs.add(new AudioCombo(mixerInfo.getName(), mixerInfo));
    }
    for (AudioCombo ac : audioInputs){
        jcb.addItem(ac);
    }

    setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    
    constraints.gridx = 0;
    constraints.gridy = 0;
    add(audioInputsLabel,constraints);
    constraints.gridx = 0;
    constraints.gridy = 1;
    add(jcb,constraints);
    constraints.gridx = 0;
    constraints.gridy = 2;
    add(audioTestButton,constraints);
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
public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("TESTAUDIO")){
        AudioCombo ac = (AudioCombo)jcb.getSelectedItem();
        System.out.println(ac);

        try{
            AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100,16,2,4,44100,false);

            DataLine.Info dataInfo = new DataLine.Info(TargetDataLine.class,audioFormat);
            if(!AudioSystem.isLineSupported(dataInfo)){
                JOptionPane.showMessageDialog(null, "Audio Line not supported.");
            }
            TargetDataLine targetDataLine = (TargetDataLine)AudioSystem.getLine(dataInfo);
            targetDataLine.open();
            JOptionPane.showMessageDialog(null, "Start recording.");
            targetDataLine.start();

            Thread audioRecorderThread = new Thread()
            {
                @Override public void run(){
                    AudioInputStream recordingStream = new AudioInputStream(targetDataLine);
                    File outputFile = new File("record.wav");
                    try{
                        AudioSystem.write(recordingStream,AudioFileFormat.Type.WAVE,outputFile);
                    }
                    catch(IOException ioe){
                        JOptionPane.showMessageDialog(null, "Error writing to file.");
                    }
                    JOptionPane.showMessageDialog(null, "Recording finished.");
                }
            };
            audioRecorderThread.start();
            JOptionPane.showMessageDialog(null, "Stop recording.");
            targetDataLine.stop();
            targetDataLine.close();


        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Audio Line unavailable.");
        }
    }
}

}

class AudioCombo{

    private String key;
    private Mixer.Info value;

    AudioCombo(){

    }
    AudioCombo(String key, Mixer.Info value){

        this.key = key;
        this.value = value;
        
    }

    public String getKey(){
        return this.key;
    }
    public Mixer.Info getValue(){
        return this.value;
    }
    public void setKey(String key){
        this.key = key;
    }
    public void setValue(Mixer.Info value){
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

}