// made by marko trnjak (https://trnjak.github.io)
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;

public class ResetCheck extends JFrame implements ActionListener {
    int x = 1;
    Color bg = new Color(0x546A76), fg = new Color(0xFAD4D8);
    JLabel warning = new JLabel("ARE YOU SURE YOU WANT TO RESET? THIS WILL OVERWRITE THE SAVE FILE.");
    JButton yes = new JButton("YES"), no = new JButton("NO");
    JPanel panel = new JPanel();
    public ResetCheck() {
        try{
            FileInputStream fis = new FileInputStream("scale.uwu");
            Scanner in = new Scanner(fis);
            x = in.nextInt();
            in.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
        this.setTitle("RESET?");
        this.setSize(250*x, 75*x);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(bg);

        yes.setFont(new Font("", Font.BOLD, 12*x));
        yes.setForeground(fg);
        yes.setBackground(bg);
        yes.setBorder(new LineBorder(fg));
        yes.setFocusable(false);
        yes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        yes.addActionListener(this);
        yes.setPreferredSize(new Dimension(125*x, 125*x));

        no.setFont(new Font("", Font.BOLD, 12*x));
        no.setForeground(fg);
        no.setBackground(bg);
        no.setBorder(new LineBorder(fg));
        no.setFocusable(false);
        no.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        no.addActionListener(this);
        no.setPreferredSize(new Dimension(125*x, 125*x));

        warning.setFont(new Font("", Font.BOLD, 12*x));
        warning.setForeground(fg);
        warning.setHorizontalAlignment(0);

        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(50*x, 50*x));
        panel.setBackground(bg);

        panel.add(yes, BorderLayout.WEST);
        panel.add(no, BorderLayout.EAST);

        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == yes){
            Clicker.reset();
            this.dispose();
        }
        if(e.getSource() == no){
            this.dispose();
        }
    }
}