import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class MyFrame1 extends JFrame{
    Scanner sc = new Scanner(System.in);

    public MyFrame1(){
        super("SuperHero");
        setSize(700,300);
        JPanel pan = new JPanel();
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
        MyFrame1 f = new MyFrame1();
    }

    
}