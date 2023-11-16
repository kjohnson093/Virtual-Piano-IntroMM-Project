package virtualPiano;

import java.awt.Dimension;
import java.awt.event.*;
import javax.sound.midi.*;
import javax.swing.*;

public class PianoRoll extends JFrame implements KeyListener{
	private Synthesizer synth = MidiSystem.getSynthesizer(); 
	// Get array of MidiChannels, all sounds must be generated through a channel
	private final MidiChannel[] mc = synth.getChannels();
	// Create instrument object from default sound bank.
	private Instrument[] instr = synth.getDefaultSoundbank().getInstruments();
	private JFrame frame; //frame for displaying PianoGUI

	public PianoRoll() throws MidiUnavailableException {
		this.synth.open();  

		// Instruments are used to choose what instrument the sound is played with.
		this.synth.loadInstrument(instr[90]);

		// Set Piano Roll focusable to allow keyboard input
		this.setFocusable(true);

		frame = new JFrame("Virtual Piano");  
		frame.setPreferredSize(new Dimension(1000,400));
		JPanel pane = new JPanel();     
		JButton button1 = new JButton("Click me!");            
		frame.getContentPane().add(pane);                   
		pane.add(button1);                                     
		frame.pack();                                       
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.show();
		frame.setFocusable(true); //set frame focusable to allow keyboard input
		frame.addKeyListener(this); //Add key listener to frame to current piano roll

		//Button Example
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mc[5].noteOn(60,600);
				mc[5].noteOn(64,600);
				mc[5].noteOn(67,600);
			}
		});


	}


	@Override
	public void keyTyped(KeyEvent e) {


	}
	
	/* Primary method for handling keyboard input and converting it to MIDI output.
	 * The virtual piano is 28 keys from C3 to E5 following a traditional B&W piano 
	 * pattern. The white keys are from Q-P and Z-M, and the black keys are the 
	 * number/letter keys above and between the corresponding white keys.
	 * 
	 * Key pattern from https://www.onlinepianist.com/virtual-piano 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();		
		//Plays C3 if 'Q' pressed
		if (keyCode == KeyEvent.VK_Q) {
			mc[5].noteOn(48,300);
		}
		//C#3, '2'
		if (keyCode == KeyEvent.VK_2) {
			mc[5].noteOn(49,600);
		}
		//D3, 'W'
		if (keyCode == KeyEvent.VK_W) {
			mc[5].noteOn(50,600);
		}
		//D#3, '3'
		if (keyCode == KeyEvent.VK_3) {
			mc[5].noteOn(51,600);
		}
		//E3, 'E'
		if (keyCode == KeyEvent.VK_E) {
			mc[5].noteOn(52,600);
		}

		//F3, 'R'
		if (keyCode == KeyEvent.VK_R) {
			mc[5].noteOn(53,600);
		}
		//F#3, '5'
		if (keyCode == KeyEvent.VK_5) {
			mc[5].noteOn(54,600);
		}
		//G3, 'T'
		if (keyCode == KeyEvent.VK_T) {
			mc[5].noteOn(55,600);
		}
		//G#3, '6'
		if (keyCode == KeyEvent.VK_6) {
			mc[5].noteOn(56,600);
		}
		//A3, 'Y'
		if (keyCode == KeyEvent.VK_Y) {
			mc[5].noteOn(57,600);
		}
		//A#3, '7'
		if (keyCode == KeyEvent.VK_7) {
			mc[5].noteOn(58,600);
		}
		//B3, 'U'
		if (keyCode == KeyEvent.VK_U) {
			mc[5].noteOn(59,600);
		}

		//C4, 'I'
		if (keyCode == KeyEvent.VK_I) {
			mc[5].noteOn(60,600);
		}
		//C#4, '9'
		if (keyCode == KeyEvent.VK_9) {
			mc[5].noteOn(61,600);
		}
		//D4, 'O'
		if (keyCode == KeyEvent.VK_O) {
			mc[5].noteOn(62,600);
		}
		//D#4, '0'
		if (keyCode == KeyEvent.VK_0) {
			mc[5].noteOn(63,600);
		}
		//E4, 'P'
		if (keyCode == KeyEvent.VK_P) {
			mc[5].noteOn(64,600);
		}

		//F4, 'Z'
		if (keyCode == KeyEvent.VK_Z) {
			mc[5].noteOn(65,600);
		}
		//F#4, 'S'
		if (keyCode == KeyEvent.VK_S) {
			mc[5].noteOn(66,600);
		}
		//G4, 'X'
		if (keyCode == KeyEvent.VK_X) {
			mc[5].noteOn(67,600);
		}
		//G#4, 'D'
		if (keyCode == KeyEvent.VK_D) {
			mc[5].noteOn(68,600);
		}
		//A4, 'C'
		if (keyCode == KeyEvent.VK_C) {
			mc[5].noteOn(69,600);
		}
		//A#4, 'F'
		if (keyCode == KeyEvent.VK_F) {
			mc[5].noteOn(70,600);
		}
		//B4, 'V'
		if (keyCode == KeyEvent.VK_V) {
			mc[5].noteOn(71,600);
		}

		//C5, 'B'
		if (keyCode == KeyEvent.VK_B) {
			mc[5].noteOn(72,600);
		}
		//C#5, 'H'
		if (keyCode == KeyEvent.VK_H) {
			mc[5].noteOn(73,600);
		}
		//D5, 'N'
		if (keyCode == KeyEvent.VK_N) {
			mc[5].noteOn(74,600);
		}
		//D#5, 'J'
		if (keyCode == KeyEvent.VK_J) {
			mc[5].noteOn(75,600);
		}
		//E5, 'M'
		if (keyCode == KeyEvent.VK_M) {
			mc[5].noteOn(76,600);
		}


	}

	@Override
	public void keyReleased(KeyEvent e) {

	}        
}
