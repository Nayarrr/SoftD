import java.awt.*;
import javax.swing.*;

public class MyFrame2 extends JFrame{

    String firstname;
    String lastname;
    int phone;

    public MyFrame2(){
        super("SuperHero");
        setSize(700,300);
        setTitle("User Info");

        JLabel firstname = new JLabel("FirstName");
        JLabel lastname = new JLabel("LastName");
        JLabel phone = new JLabel("Phone");

        JTextField firstnameField = new JTextField();
        JTextField lastnameField = new JTextField();
        JTextField phoneField = new JTextField();

        JTextArea textArea = new JTextArea(15, 5);

        firstname.setHorizontalAlignment(SwingConstants.RIGHT);
        lastname.setHorizontalAlignment(SwingConstants.RIGHT);
        phone.setHorizontalAlignment(SwingConstants.RIGHT);

        JButton resume = new JButton("Resume");
        JButton quit = new JButton("Quit");


    
        Container cp = getContentPane();
        
        resume.addActionListener( r -> {
            String info = "FirstName: " + firstnameField.getText() + "\n" +
                          "LastName: " + lastnameField.getText() + "\n" +
                          "Phone: " + phoneField.getText() + "\n";
            textArea.setText(info);
        });

        quit.addActionListener(q -> System.exit(0));

        JPanel pNorth = new JPanel(new GridLayout(3,2,5,5));
        JPanel pSouth = new JPanel();
        pSouth.add(resume);
        pSouth.add(quit);
        pNorth.add(firstname);
        pNorth.add(firstnameField);
        pNorth.add(lastname);
        pNorth.add(lastnameField);
        pNorth.add(phone);
        pNorth.add(phoneField);

        cp.add(pNorth, BorderLayout.NORTH);
        cp.add(pSouth, BorderLayout.SOUTH);
        cp.add(textArea, BorderLayout.CENTER);
        
        setVisible(true);
    }

    public static void main(String[] args){
        MyFrame2 f = new MyFrame2();
    }3extends JFr

}