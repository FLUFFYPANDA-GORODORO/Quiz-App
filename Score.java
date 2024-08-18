import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Score extends JFrame implements ActionListener{
    JButton exit,Goback;
    String name;
    Score(String name , int score){
            String query="insert into marks values(?,?)";
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/Quiz","root","gaurav@123");  
            // Statement stmt=con.createStatement();  
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2, score);
            pstmt.executeUpdate();
            con.close();  
            }catch(Exception e){ 
                System.out.println(e);
            } 

        
        getContentPane().setBackground(Color.white);
        setLayout(null);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/score.png"));
        Image i2 =  i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);  
        image.setBounds(0,200,300,250);
        add(image);

        JLabel heading = new JLabel("Thank You " + name + " for solving the quiz");
        heading.setBounds(45,30,700,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,26));
        add(heading);

        JLabel score1 = new JLabel("Your Score is " + score);
        score1.setBounds(350,200,300,30);
        score1.setFont(new Font("Tahoma",Font.PLAIN,26));
        add(score1);

        exit = new JButton("Exit");
        exit.setBounds(375,270,120,30);
        exit.setBackground(new Color(30,144,255));
        exit.addActionListener(this);
        add(exit);
        
        Goback = new JButton("Dashboard");
        Goback.setBounds(375,320,120,30);
        Goback.setBackground(new Color(30,144,255));
        Goback.addActionListener(this);
        add(Goback);
        
        
        
        setSize(750,550);
        setLocation(400,150);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            dispose();
        }
        if(ae.getSource()==Goback){
            new select(name);
            setVisible(false);
        }
       
       
    }
    // public static void main(String[] args){
    //     new Score("User",0);
    // }
}
   


