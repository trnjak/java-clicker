import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics {
    JFrame window = new JFrame("JavaClicker");
    JButton button = new JButton("Click!");

    static JLabel textPoints = new JLabel();
    static JLabel textPow = new JLabel();
    static JLabel textCps = new JLabel();
    static JLabel textBought = new JLabel();

    static JButton powPlus = new JButton();
    static JButton powX = new JButton();
    static JButton cpsPlus = new JButton();
    static JButton cpsX = new JButton();

    public static void settingText(Player p){
        textPoints.setText(String.valueOf(p.getPoints()));
        textCps.setText("[CPS]: " + p.getCps());
        cpsPlus.setText("[+1 CPS]: " + p.getPriceCps());
        cpsX.setText("[+10 CPS]: " + p.getPriceCpsX());
        textPow.setText("[POW]: " + p.getPow());
        powPlus.setText("[+1 POW]: " + p.getPricePow());
        powX.setText("[+10 POW]: " + p.getPricePowX());
    }

    public Graphics(Player p) {
        Color background = new Color(17, 13, 14);
        Color foreground = new Color(243, 228, 198);
        textPoints.setText(String.valueOf(p.getPoints()));
        textCps.setText("[CPS]: " + p.getCps());
        cpsPlus.setText("[+1 CPS]: " + p.getPriceCps());
        cpsX.setText("[+10 CPS]: " + p.getPriceCpsX());
        textPow.setText("[POW]: " + p.getPow());
        powPlus.setText("[+1 POW]: " + p.getPricePow());
        powX.setText("[+10 POW]: " + p.getPricePowX());

        window.setLayout(null);
        window.getContentPane().setBackground(background);
        window.setSize(500, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        button.setBounds(350, 390, 100, 50);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(foreground);
        button.setForeground(background);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.setPoints(p.getPoints()+p.getPow());
                textPoints.setText(String.valueOf(p.getPoints()));
            }
        });
        window.add(button);

        textPoints.setBounds(50,400, 400,30);
        textPoints.setFont(new Font("Dialog", Font.BOLD, 20));
        textPoints.setForeground(foreground);
        window.add(textPoints);

        textPow.setBounds(50,70, 400,30);
        textPow.setFont(new Font("Dialog", Font.BOLD, 15));
        textPow.setForeground(foreground);
        window.add(textPow);

        textCps.setBounds(50,210, 400,30);
        textCps.setFont(new Font("Dialog", Font.BOLD, 15));
        textCps.setForeground(foreground);
        window.add(textCps);

        textBought.setBounds(50,140, 400,30);
        textBought.setFont(new Font("Dialog", Font.BOLD, 15));
        textBought.setForeground(foreground);
        window.add(textBought);

        powPlus.setBounds(250, 30, 200, 30);
        powPlus.setFocusPainted(false);
        powPlus.setBorderPainted(false);
        powPlus.setBackground(foreground);
        powPlus.setForeground(background);
        powPlus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        powPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(p.getPoints() >= p.getPricePow()){
                    p.setPoints(p.getPoints()-p.getPricePow());
                    p.setPow(p.getPow()+1);
                    p.setPricePow(p.getPricePow()+(int)(p.getPricePow()*0.15));
                    textBought.setText("Bought!");
                    textPoints.setText(String.valueOf(p.getPoints()));
                    textPow.setText("[POW]: " + p.getPow());
                    powPlus.setText("[+1 POW]: " + p.getPricePow());
                }
                else{
                    textBought.setText("Not enough points!");
                }
            }
        });
        window.add(powPlus);

        powX.setBounds(250, 100, 200, 30);
        powX.setFocusPainted(false);
        powX.setBorderPainted(false);
        powX.setBackground(foreground);
        powX.setForeground(background);
        powX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        powX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(p.getPoints() >= p.getPricePow()){
                    p.setPoints(p.getPoints()-p.getPricePowX());
                    p.setPow(p.getPow()+10);
                    p.setPricePowX(p.getPricePowX()+(int)(p.getPricePow()*0.15));
                    textBought.setText("Bought!");
                    textPoints.setText(String.valueOf(p.getPoints()));
                    textPow.setText("[POW]: " + p.getPow());
                    powX.setText("[+10 POW]: " + p.getPricePow());
                }
                else{
                    textBought.setText("Not enough points!");
                }
            }
        });
        window.add(powX);

        cpsPlus.setBounds(250, 170, 200, 30);
        cpsPlus.setFocusPainted(false);
        cpsPlus.setBorderPainted(false);
        cpsPlus.setBackground(foreground);
        cpsPlus.setForeground(background);
        cpsPlus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cpsPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(p.getPoints() >= p.getPriceCps()){
                    p.setPoints(p.getPoints()-p.getPriceCps());
                    p.setCps(p.getCps()+1);
                    p.setPriceCps(p.getPriceCps()+(int)(p.getPriceCps()*0.30));
                    textBought.setText("Bought!");
                    textPoints.setText(String.valueOf(p.getPoints()));
                    textCps.setText("[CPS]: " + p.getCps());
                    cpsPlus.setText("[+1 CPS]: " + p.getPriceCps());
                }
                else{
                    textBought.setText("Not enough points!");
                }
            }
        });
        window.add(cpsPlus);

        cpsX.setBounds(250, 240, 200, 30);
        cpsX.setFocusPainted(false);
        cpsX.setBorderPainted(false);
        cpsX.setBackground(foreground);
        cpsX.setForeground(background);
        cpsX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cpsX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(p.getPoints() >= p.getPriceCpsX()){
                    p.setPoints(p.getPoints()-p.getPriceCpsX());
                    p.setCps(p.getCps()+10);
                    p.setPriceCpsX(p.getPriceCpsX()+(int)(p.getPriceCpsX()*0.30));
                    textBought.setText("Bought!");
                    textPoints.setText(String.valueOf(p.getPoints()));
                    textCps.setText("[CPS]: " + p.getCps());
                    cpsX.setText("[+10 CPS]: " + p.getPriceCpsX());
                }
                else{
                    textBought.setText("Not enough points!");
                }
            }
        });
        window.add(cpsX);
    }

    public JFrame getWindow() {
        return window;
    }

    public JButton getButton() {
        return button;
    }

    public JLabel getTextPoints() {
        return textPoints;
    }

    public JLabel getTextPow() {
        return textPow;
    }

    public JLabel getTextCps() {
        return textCps;
    }

    public JLabel getTextBought() {
        return textBought;
    }

    public JButton getPowPlus() {
        return powPlus;
    }

    public JButton getPowX() {
        return powX;
    }

    public JButton getCpsPlus() {
        return cpsPlus;
    }

    public JButton getCpsX() {
        return cpsX;
    }
}