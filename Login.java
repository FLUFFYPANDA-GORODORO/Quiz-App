// package Exam_App.Quiz;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;  
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton sign_in,cancel;
    JTextField tfname,pass;
    int count=0;
    String u,p,c;
    int flag=0;
    

    Login(){
       
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/img10.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(900,80,600,605);
        add(image);

        JLabel heading = new JLabel("Login");
        heading.setBounds(190,130,850,100);
        heading.setFont(new Font("Mongolian Baiti",Font.PLAIN,72));
        heading.setForeground(Color.orange);
        add(heading);
        
        JLabel name = new JLabel("Username ");
        name.setBounds(180,235,850,100);
        name.setFont(new Font("Mongolian Baiti",Font.PLAIN,20));
        name.setForeground(Color.orange);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(180,310,540,30);
        tfname.setFont(new Font("Times New Roman",Font.PLAIN,15));
        add(tfname);

        JLabel password = new JLabel("Password ");
        password.setBounds(180,365,850,100);
        password.setFont(new Font("Mongolian Baiti",Font.PLAIN,20));
        password.setForeground(Color.orange);
        add(password);

        pass = new JTextField();
        pass.setBounds(180,440,540,40);
        pass.setFont(new Font("Times New Roman",Font.PLAIN,15));
        pass.setForeground(Color.orange);
        add(pass);





        sign_in = new JButton("Login");
        sign_in.setBounds(270,540,100,40);
        sign_in.setBackground(Color.orange);
        sign_in.addActionListener(this);
        add(sign_in);

        cancel = new JButton("Back");
        cancel.setBounds(480,540,100,40);
        cancel.setBackground(Color.orange);
        cancel.addActionListener(this);
        add(cancel);



        setSize(1500,780);
        setLocation(20,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==sign_in){ 

            String user=tfname.getText();
            String pwd=pass.getText();
            System.out.println(user+" "+pwd);
            String query ="select * from users where username= ?";
           
            

            try{  
                Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/Quiz","root","gaurav@123");   
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, user);
                ResultSet rs=pstmt.executeQuery();
                while(rs.next()){  
                u=rs.getString(1);
                p=rs.getString(2);
                c=rs.getString(3);
                    count=count+1;
                    System.out.println(u+" "+p);
                }
                System.out.println(count);
               
                

                con.close();  
                }catch(Exception e){ 
                    System.out.println(e);
                } 
                
                
                if(user.equals(u) && pwd.equals(p))
                {
                    setVisible(false); 
                    new select(user);
                    dispose(); 
                } 
                else{
                    count=0;
                    new Popup();

                    
                }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
 
    public static void main(String[] args) {
        new Login();       
    }
}

 
