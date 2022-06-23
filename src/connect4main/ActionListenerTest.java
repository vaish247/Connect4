package connect4main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
 
/**
 * @author ajith
 *
 */
public class ActionListenerTest implements ActionListener {
 
    JButton button;
    JFrame frame;
    JTextArea textArea;
    JPanel buttonPanel;
 
    /**
     * 
     */
    public ActionListenerTest() {
        button = new JButton("Click Me");
        frame = new JFrame("ActionListener Test");
        textArea = new JTextArea(5, 40);
        


 
        button.addActionListener(this);
        textArea.setLineWrap(true);
        frame.setLayout(new BorderLayout());
        frame.add(textArea, BorderLayout.NORTH);
        frame.add(button, BorderLayout.SOUTH);
        frame.pack();
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.setText(textArea.getText().concat("You have clicked the button\n"));
    }
 
    /**
     * @param args
     */
    public static void main(String args[]) {
        ActionListenerTest test = new ActionListenerTest();
    }
}