import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Popup extends JFrame implements ActionListener{
    
 
JButton ok;   
    
    Popup(){
        getContentPane().setBackground(Color.black);
        setLayout(null);


        JLabel heading = new JLabel("Invalid username and password");
        heading.setBounds(80,40,250,25);
        heading.setFont(new Font("Mongolian Baiti",Font.PLAIN,17));
        heading.setForeground(Color.orange);
        add(heading);

        ok = new JButton("OK");
        ok.setBounds(150,80,80,30);
        ok.setBackground(Color.orange);
        ok.addActionListener(this);
        add(ok);


        setSize(400,200);
        setLocation(600,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==ok){
        setVisible(false);
        dispose();;
        }
    }

    public static void main(String[] args) {
        new Popup();
       
    }
}
