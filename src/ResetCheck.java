// made by marko trnjak (https://trnjak.github.io)
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*; 
import java.awt.*;

public class ResetCheck extends JFrame implements ActionListener {
    Color bg = new Color(0x546A76), fg = new Color(0xFAD4D8);
    JLabel warning = new JLabel("ARE YOU SURE YOU WANT TO RESET? THIS WILL OVERWRITE THE SAVE FILE.");
    JButton yes = new JButton("YES"), no = new JButton("NO");
    JPanel panel = new JPanel();
    public ResetCheck() {
        this.setTitle("RESET?");
        this.setSize(500, 150);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(bg);

        yes.setFont(new Font("", Font.BOLD, 24));
        yes.setForeground(fg);
        yes.setBackground(bg);
        yes.setBorder(new LineBorder(fg));
        yes.setFocusable(false);
        yes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        yes.addActionListener(this);
        yes.setPreferredSize(new Dimension(250, 250));

        no.setFont(new Font("", Font.BOLD, 24));
        no.setForeground(fg);
        no.setBackground(bg);
        no.setBorder(new LineBorder(fg));
        no.setFocusable(false);
        no.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        no.addActionListener(this);
        no.setPreferredSize(new Dimension(250, 250));

        warning.setFont(new Font("", Font.BOLD, 24));
        warning.setForeground(fg);
        warning.setHorizontalAlignment(0);

        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(100, 100));
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