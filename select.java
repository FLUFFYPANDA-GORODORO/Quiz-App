import java.awt.*;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;



public class select extends JFrame implements ActionListener{
    JButton next;
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup bg;
    JLabel heading;
    String name;
    select(String name){
       

        System.out.println(name);
        getContentPane().setBackground(Color.white);
        setLayout(null);   

        heading = new JLabel("Welcome "+name+" To Our Quiz App");
        heading.setBounds(450,100,800,50);
        heading.setFont(new Font("Dailog",Font.PLAIN,30));
        add(heading);

        opt1 = new JRadioButton("Java");
        opt1.setBounds(520,220,200,30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dailog",Font.PLAIN,20));
        add(opt1);

        opt2 = new JRadioButton("C");
        opt2.setBounds(520,300,200,30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dailog",Font.PLAIN,20));
        add(opt2);

        opt3 = new JRadioButton("C++");
        opt3.setBounds(920,220,200,30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dailog",Font.PLAIN,20));
        add(opt3);

        opt4 = new JRadioButton("Javascript");
        opt4.setBounds(920,300,200,30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dailog",Font.PLAIN,20));
        add(opt4);

        bg = new ButtonGroup();
        bg.add(opt1);
        bg.add(opt2);
        bg.add(opt3);
        bg.add(opt4);

        next = new JButton("Next");
        next.setBounds(640,550,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,20));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);


        
        setSize(1500,780);
        setLocation(20,20);
        setVisible(true);     
    }
  
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
          
       
            if(opt1.isSelected()){
                String sub= opt1.getActionCommand();
                System.out.println(sub);
                new Quiz(name,sub);
                setVisible(false);
            }
            if(opt2.isSelected()){
                String sub= opt2.getActionCommand();
                System.out.println(sub);
                new Quiz(name,sub);
                setVisible(false);
               
            }
            if(opt3.isSelected()){
                String sub= opt3.getActionCommand();
                System.out.println(sub);
                new Quiz(name,sub);
                setVisible(false);
                
            }
            if(opt4.isSelected()){
                String sub= opt4.getActionCommand();
                System.out.println(sub);
                new Quiz(name,sub);
                setVisible(false);
                
            }
        }
    }

    //   public static void main(String args[]){
    //     new select();
    // }
}
