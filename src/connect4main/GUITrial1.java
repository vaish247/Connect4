package connect4main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author ajith
 *
 */
public class GUITrial1 extends JFrame implements ActionListener {
  JFrame f;
  private JPanel buttonPanel;
  private JPanel controlButton;
  JButton[] contbuttons;
  Board board;
  JButton[][] buttons;
  int count = 0;
  JLabel textArea;
  JLabel tf;

  GUITrial1(Board board) {
    this.board = board;
    setTitle("Connect4-Trial");
    buttonPanel = new JPanel();
    buttonPanel.setBounds(250, 250, 500, 500);
    buttonPanel.setLayout(new GridLayout(9, 9));
    buttons = new JButton[9][9];
    textArea = new JLabel();
    tf = new JLabel(); // text field
    tf.setBounds(250, 50, 500, 125);

    for (int i = 0; i < 9; i++) {
      for (int z = 0; z < 9; z++) {
        buttons[i][z] = new JButton();
        buttons[i][z].setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        buttons[i][z].setBackground(Color.WHITE);
//        RenderedImages.scale(55, 55);
//        Image image = RenderedImages.blueCircle;
//        ImageIcon icon = new ImageIcon(image);
//        buttons[i][z].setIcon(icon);
        buttonPanel.add(buttons[i][z]);
      }
    }
    controlButton = new JPanel();
    controlButton.setBounds(250, 750, 500, 50);
    controlButton.setLayout(new GridLayout(1, 9));
    contbuttons = new JButton[9];
    for (int i = 0; i < 9; i++) {
      contbuttons[i] = new JButton();
      contbuttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
      contbuttons[i].setBackground(Color.RED);
//      RenderedImages.scale(55, 55);
//      Image image = RenderedImages.redCircle;
//      ImageIcon icon = new ImageIcon(image);
//      contbuttons[i].setIcon(icon);
      contbuttons[i].addActionListener(this);
      controlButton.add(contbuttons[i]);
    }
    add(tf);
    add(controlButton);
    add(buttonPanel);
    setSize(1000, 1000);
    setLayout(null);
    setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    boolean gameStop = false;
    ;
    for (int i = 0; i < contbuttons.length; i++) {
      if (e.getSource().equals(contbuttons[i])) {
        System.out.println(i + 1);
        Connect4 conn = new Connect4();
        if (!board.theWin) {
          this.board = conn.run(i + 1, board);
          if (board.blueTurn) {
            RenderedImages.scale(55, 55);
            Image image = RenderedImages.blueCircle;
            ImageIcon icon = new ImageIcon(image);
            buttons[board.latestTilePos.getY()][board.latestTilePos.getX()].setIcon(icon);
          } else {
            RenderedImages.scale(55, 55);
            Image image = RenderedImages.redCircle;
            ImageIcon icon = new ImageIcon(image);
            buttons[board.latestTilePos.getY()][board.latestTilePos.getX()].setIcon(icon);
          }
          if (board.theWin) {
            Font f = new Font("serif", Font.PLAIN, 110);
            tf.setText("YOU WIN");
            tf.setFont(f);
          }
        }
      } else {
        //
      }

    }

  }

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    Board game = new Board(9);
    new GUITrial1(game);

  }

}
