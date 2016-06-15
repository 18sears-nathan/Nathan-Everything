import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GUISHIT{

  public static void main(String[] args) {

    JFrame f = new JFrame("DID BUSH DO IT?");
    f.setSize(500, 500);
    f.setLocation(1000,200);
    final JTextArea textArea = new JTextArea(10, 40);
    f.getContentPane().add(BorderLayout.CENTER, textArea);
    final JButton beams = new JButton("JET FUEL?");
    f.getContentPane().add(BorderLayout.SOUTH, beams);
    final JButton fuel = new JButton("STEEL BEAMS"); 
    f.getContentPane().add(BorderLayout.NORTH, fuel);
    beams.addActionListener(new ActionListener() {
    
    	
    	
        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.append("DOES NOT MELT\n");

        }
    });

    f.setVisible(true);

  }

}