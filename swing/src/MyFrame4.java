import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.*;

public class MyFrame4 extends JFrame implements KeyListener{
    JButton[] buttons;
    int n;

    public MyFrame4(int n){
        super("SuperHero");
        this.n = n;
        buttons = new JButton[n];
        setSize(700,300);
        JPanel pan = new JPanel();
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        for (int i = 0; i < n; i++){
            buttons[i] = new JButton("Button" + (i));
            cp.add(buttons[i]);
            buttons[i].setBackground(java.awt.Color.BLUE);
            buttons[i].addKeyListener(this);
        }
        setVisible(true);
    }

    public static void main(String[] args){
        System.out.println("Tu veux combien ?");
        Scanner sc = new Scanner(System.in);
        int nbr = sc.nextInt();
        MyFrame4 f = new MyFrame4(nbr);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        for(JButton bt : buttons){
            bt.setBackground(java.awt.Color.BLUE);
        }
        if (c >= '0' && c <= '9'){
            buttons[c-'0'].requestFocus();
            buttons[c-'0'].setBackground(java.awt.Color.RED);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("toi kaka");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("toi kiki");
    }

    
}