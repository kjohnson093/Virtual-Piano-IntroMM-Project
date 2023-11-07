package virtualPiano;

import java.awt.event.*;
import javax.sound.midi.*;
import javax.swing.*;

public class PianoRoll {

	public static void main(String[] args) throws MidiUnavailableException { 
		// Create synth object	
		Synthesizer synth;
		synth = MidiSystem.getSynthesizer();
		synth.open();  

		// Get array of MidiChannels, all sounds must be generated through a channel
		final MidiChannel[] mc = synth.getChannels();

		// Create instrument object from default sound bank.
		Instrument[] instr = synth.getDefaultSoundbank().getInstruments();

		// Instruments are used to choose what instrument the sound is played with.
		synth.loadInstrument(instr[90]);

		// Simple button for making a sound 
		JFrame frame = new JFrame("Sound1");                
		JPanel pane = new JPanel();                         
		JButton button1 = new JButton("Click me!");            
		frame.getContentPane().add(pane);                   
		pane.add(button1);                                     
		frame.pack();                                       
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.show();

		// Action listener for button to create sound
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// "On MidiChannel 5, play note on 60 at velocity 600."
				mc[5].noteOn(60,600);
				mc[5].noteOn(64,600);
				mc[5].noteOn(67,600);
			}
		});  
	}        
}
