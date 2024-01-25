import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener {
    Dimension d = new Dimension(150, 150);
    Color bg = new Color(0x546A76), fg = new Color(0xFAD4D8);
    JPanel top = new JPanel(), left = new JPanel(), right = new JPanel(), bottom = new JPanel(), center = new JPanel();
    JButton button = new JButton("CLICK TO ENTER!");
    public Window(){
        this.setTitle("WELCOME");
        this.setSize(1024, 768);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        button.setFont(new Font("", Font.BOLD, 69));
        button.setForeground(fg);
        button.setBackground(bg);
        button.setFocusable(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(null);
        button.addActionListener(this);

        top.setPreferredSize(d);
        left.setPreferredSize(d);
        right.setPreferredSize(d);
        bottom.setPreferredSize(d);
        
        top.setBackground(bg);
        left.setBackground(bg);
        right.setBackground(bg);
        bottom.setBackground(bg);

        center.setPreferredSize(new Dimension(1000, 1000));
        center.setLayout(new BorderLayout());
        center.setBackground(bg);
        center.add(button, BorderLayout.CENTER);

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
            new Clicker();
        }
    }
}