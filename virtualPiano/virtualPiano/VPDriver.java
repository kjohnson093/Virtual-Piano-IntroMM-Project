/*
 * Main driver class for virtual piano
 * 
 * @authors Jeremiah Jordan, Keondre Johnson
 */
package virtualPiano;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.JFrame;

public class VPDriver {

	public static void main(String[] args) throws MidiUnavailableException {
		
		PianoRoll piano = new PianoRoll();
		JFrame frame = new JFrame("Virtual Piano");
        frame.setSize(970, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(piano);
        frame.setVisible(true);
        piano.requestFocus();
	}
}