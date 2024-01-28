// made by marko trnjak (https://trnjak.github.io) 
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class StartPage extends JFrame implements ActionListener {
    int x = 1;
    Dimension d = new Dimension(150, 150);
    Color bg = new Color(0x546A76), fg = new Color(0xFAD4D8);
    JLabel title = new JLabel("SOMETHING");
    JPanel top = new JPanel(), left = new JPanel(), right = new JPanel(), bottom = new JPanel(), center = new JPanel();
    JButton button = new JButton("PLAY!"), settings = new JButton("SCALE: " + x + "X");
    public StartPage(){
        try{
            FileInputStream fis = new FileInputStream("scale.uwu");
            Scanner in = new Scanner(fis);
            x = in.nextInt();
            in.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        settings.setText("SCALE: "+ x + "X");

        this.setTitle("Something - the Swing clicker game!");
        this.setSize(500*x, 500*x);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        button.setFont(new Font("", Font.BOLD, 24*x));
        button.setForeground(fg);
        button.setBackground(bg);
        button.setBorder(new LineBorder(fg));
        button.setFocusable(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(this);

        
        settings.setFont(new Font("", Font.BOLD, 24*x));
        settings.setForeground(fg);
        settings.setBackground(bg);
        settings.setBorder(new LineBorder(fg));
        settings.setFocusable(false);
        settings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        settings.addActionListener(this);

        title.setFont(new Font("", Font.BOLD, 24*x));
        title.setForeground(fg);
        title.setBorder(new LineBorder(fg));
        title.setHorizontalAlignment(0);

        top.setPreferredSize(d);
        left.setPreferredSize(d);
        right.setPreferredSize(d);
        bottom.setPreferredSize(d);
        
        top.setBackground(bg);
        left.setBackground(bg);
        right.setBackground(bg);    
        bottom.setBackground(bg);

        center.setPreferredSize(new Dimension(500*x, 500*x));
        center.setLayout(new BorderLayout());
        center.setBackground(bg);
        center.add(title, BorderLayout.NORTH);
        center.add(button, BorderLayout.CENTER);
        center.add(settings, BorderLayout.SOUTH);

        this.add(top, BorderLayout.NORTH);
        this.add(left, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);
        this.add(right, BorderLayout.EAST);
        this.add(bottom, BorderLayout.SOUTH);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            this.dispose();
            new Clicker(x);
        }
        if(e.getSource() == settings){
            x += 1;
            if(x < 4){
                settings.setText("SCALE: "+ x + "X");
                try{
                    PrintWriter pw = new PrintWriter("scale.uwu");
                    pw.println(x);
                    pw.flush();
                    pw.close();
                }catch (FileNotFoundException fnf){
                    System.out.println(fnf.getMessage());
                }
                this.dispose();
                new StartPage();
            }
            else{
                x = 1;
                settings.setText("SCALE: "+ x + "X");
                try{
                    PrintWriter pw = new PrintWriter("scale.uwu");
                    pw.println(x);
                    pw.flush();
                    pw.close();
                }catch (FileNotFoundException fnf){
                    System.out.println(fnf.getMessage());
                }
                this.dispose();
                new StartPage();
            }
        }
    }
}