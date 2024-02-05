/**
 * ACS-3913 Assignment 3
 */

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.crypto.Mac;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.IOException;


public class RemoteControlApp{
    private JLabel[] labels;
    RemoteControl remoteControl;

    /** Loads and sets up the remote control */
    public void loadRemote(){
        Light kitchenLight = new Light("Kitchen");
        Stereo stereo = new Stereo("Living Room");
        CeilingFan fan = new CeilingFan("Living Room Fan");

        LightOnCommand kitchenLightOn =
            new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff =
            new LightOffCommand(kitchenLight);

        StereoOnWithCDCommand stereoOnWithCD =
            new StereoOnWithCDCommand(stereo);
        StereoOffCommand  stereoOff =
            new StereoOffCommand(stereo);

        CeilingFanMediumCommand fanOn = new CeilingFanMediumCommand(fan);
        CeilingFanOffCommand fanOff = new CeilingFanOffCommand(fan);

        Command [] partyOn = {kitchenLightOn, stereoOnWithCD, fanOn};
        Command [] partyOff = {kitchenLightOff, stereoOff, fanOff};

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        setRemoteCommand(0, kitchenLightOn, kitchenLightOff, "Kitchen Light");
        setRemoteCommand(1, stereoOnWithCD, stereoOff, "Stereo");
        setRemoteCommand(6, partyOnMacro, partyOffMacro, "Party");
        System.out.println("\n------ Remote Control App Sim -------\n");
    }

    /** Sets the command and label text */
    private void setRemoteCommand(int slot, Command onCommand, Command offCommand,
    String description){
        remoteControl.setCommand(slot, onCommand, offCommand);
        labels[slot].setText(description);
    }

    public static void main(String[] args) {
        RemoteControlApp remoteControlApp = new RemoteControlApp();
        remoteControlApp.createAndShowGUI();
    }

    public void createAndShowGUI(){
        Configuration config = Configuration.getConfiguration();

        final int NUM_COMMANDS = config.getNumberOfOption();
        final int REMOTE_HEIGHT = config.getHeight();
        final int REMOTE_WIDTH = 300;

        remoteControl = new RemoteControl();

        // Create the buttons and labels
        JLabel onLabel = new JLabel("on");
        JLabel offLabel = new JLabel("off");
        JButton[] onButtons = new JButton[NUM_COMMANDS];
        JButton[] offButtons = new JButton[NUM_COMMANDS];
        labels = new JLabel[NUM_COMMANDS];
        JButton undoButton = new JButton("UNDO");
        JButton redoButton = new JButton("REDO");

        for (int i=0; i<NUM_COMMANDS; i++){
            onButtons[i] = new JButton(" ");
            offButtons[i] = new JButton(" ");
            labels[i] = new JLabel("no command");
        }

        // Set actions on the buttons using lambda expressions
        for (int i=0; i<NUM_COMMANDS; i++){
            final int I = i;
            onButtons[i].addActionListener(event ->
                    remoteControl.onButtonWasPushed(I));
            offButtons[i].addActionListener(event ->
                    remoteControl.offButtonWasPushed(I));
        }


        /** Executes when the undoButton is clicked */
        undoButton.addActionListener(event -> {
                // add UNDO code here
                remoteControl.undoButtonWasPushed();
            });

        /** Executes when the redoButton is clicked */
        redoButton.addActionListener(event -> {
                // add redo code here
                remoteControl.redoButtonWasPushed();
            });


        // Create and set up the window and content pane
        JFrame frame = new JFrame("Remote Control");
        frame.setSize(new Dimension(REMOTE_WIDTH,REMOTE_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        JButton button;
        pane.setLayout(new GridBagLayout());
        pane.setPreferredSize(new Dimension(REMOTE_WIDTH, REMOTE_HEIGHT));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);

        //  Window listener for closing events
        frame.addWindowListener(new WindowAdapter(){
            /** Executes when the GUI is closed */
            public void windowClosing(WindowEvent e)  {
                try {
                    Logger logger = Logger.getLogger();
                     logger.close();
                } catch (IOException exception) {
                    System.out.println(exception + "Listener");
                }
            }
        });

        // Add the buttons and labels onto the pane
        c.gridy = 0; c.gridx=1;
        pane.add(onLabel, c);
        c.gridy = 0; c.gridx=2;
        pane.add(offLabel, c);
        for (int i=0; i<NUM_COMMANDS; i++){
            c.gridy = i+1;
            c.gridx = 0;
            pane.add(labels[i], c);
            c.gridx = 1;
            pane.add(onButtons[i], c);
            c.gridx = 2;
            pane.add(offButtons[i], c);
        }
        c.gridy = NUM_COMMANDS + 1;
        c.gridx = 1;
        pane.add(undoButton, c);
        c.gridy = NUM_COMMANDS + 1;
        c.gridx=2;
        pane.add(redoButton, c);

        // Display the window
        frame.pack();
        frame.setVisible(true);

        // Load the remote
        loadRemote();
    }
}
