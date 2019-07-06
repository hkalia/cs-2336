import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestMyFirstGUI {
    public static void main(String[] args) {
        MyFirstGUI myWindow = new MyFirstGUI();
        myWindow.setTitle("My First GUI");
        myWindow.setSize(300, 200);

        myWindow.setVisible(true);
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyFirstGUI extends JFrame implements ActionListener, MouseListener {
    JPanel myFirstPanel;
    JButton okButton, cxlButton;
    JLabel msgLabel;

    MyFirstGUI() {
        super();

        myFirstPanel = new JPanel();
        okButton = new JButton("OK");
        cxlButton = new JButton("Cancel");
        msgLabel = new JLabel("Your message here");

        add(myFirstPanel, BorderLayout.CENTER);
        myFirstPanel.add(okButton);
        myFirstPanel.add(cxlButton);
        myFirstPanel.add(msgLabel);

        okButton.addActionListener(this);
        cxlButton.addActionListener(this);
        okButton.addMouseListener(this);
        cxlButton.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            msgLabel.setText("OK Button was Clicked");
        } else if (e.getSource() == cxlButton) {
            msgLabel.setText("Cancel Button was Clicked");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == okButton) {
            msgLabel.setText("OK? you are choking me");
        } else if (e.getSource() == cxlButton) {
            msgLabel.setText("Cancel? fine be that way");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == okButton) {
            msgLabel.setText("OK button is released");
        } else if (e.getSource() == cxlButton) {
            msgLabel.setText("Cancel button is released");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}