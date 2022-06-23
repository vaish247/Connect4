package connect4main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ajith
 *
 */
public class MyActionListener implements ActionListener {
    /**
     * @param e
     * @param board
     */
    public void actionPerformed(ActionEvent e, Board board) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton jb = (JButton) source;
            System.out.println("JButton: " + jb.getText());
        }/*w  w    w .   d e   mo  2  s    .  c  o m */
    }
}