import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame3 extends JFrame implements ActionListener{
    int n = 0;
    JButton[] buttons;

    public MyFrame3(int n){
        super("SuperHero");
        this.n = n;
        buttons = new JButton[n];
        setSize(700,300);
        JPanel pan = new JPanel();
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        for (int i = 0; i < n; i++){
            buttons[i] = new JButton("Button" + (i+1));
            cp.add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        for (int i = 0; i < n; i++){
            if (source == buttons[i]){
                System.out.println("Button " + (i+1) + " pressed");
            }
        }
    }

    public static void main(String[] args){
        MyFrame3 f = new MyFrame3(10);
    }

}