import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class MyFrameMieux extends JFrame{
    Scanner sc = new Scanner(System.in);

    public MyFrameMieux(){
        super("SuperHero");
        setSize(700,300);
        JPanel pan = new JPanel();
        JLabel firstname = new JLabel("FirstName");
        JLabel lastName = new JLabel("LastName");
        JLabel phone = new JLabel("Phone");
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        System.out.println("tu veux quoi ?");
        int nbr = sc.nextInt();
        for (int i = 0; i < nbr; i++){
            cp.add(new Button("Button" + (i+1)));
        }
        setVisible(true);
    }

    public static void main(String[] args){
        MyFrameMieux f = new MyFrameMieux();
    }

}