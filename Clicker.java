// made by marko trnjak (https://trnjak.github.io)
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Clicker extends JFrame {

    public static void main(String[] args) {
        new Window();
        load();
        while(true){
            Clicker.points = Clicker.points + Clicker.cps;
            Clicker.textPoints.setText(String.valueOf(Clicker.points));
            Clicker.textBought.setText("");
            Clicker.save();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    Color bg = new Color(0x546A76), fg = new Color(0xFAD4D8);

    static long points = 0;
    static int cps = 0;
    static int priceCps = 100;
    static int priceCpsX = 1000;
    static int pow = 1;
    static int pricePow = 50;
    static int pricePowX = 500;

    JButton button = new JButton("Click!");

    static JLabel textPoints = new JLabel(String.valueOf(points));
    static JLabel textPow = new JLabel("[POW]: " + pow);
    static JLabel textCps = new JLabel("[CPS]: " + cps);
    static JLabel textBought = new JLabel("");

    static JButton powPlus = new JButton("[+1 POW]: " + pricePow);
    static JButton powX = new JButton("[+10 POW]: " + pricePowX);
    static JButton cpsPlus = new JButton("[+1 CPS]: " + priceCps);
    static JButton cpsX = new JButton("[+10 CPS]: " + priceCpsX);

    JButton reset = new JButton("RESET");

    public Clicker(){
        this.setTitle("Java Clicker!");
        this.setLayout(null);  
        this.getContentPane().setBackground(bg);
        this.setSize(500*2, 500*2);  
        this.setLocationRelativeTo(null);
        this.setResizable(false);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);  

        button.setBounds(350*2, 390*2, 100*2, 50*2);
        button.setFont(new Font("", Font.BOLD, 15*2));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(fg);
        button.setForeground(bg);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                points = points + pow;
                textPoints.setText(String.valueOf(points));
            }
        });
        this.add(button);

        textPoints.setBounds(50*2,400*2, 400*2,30*2);
        textPoints.setFont(new Font("", Font.BOLD, 20*2));  
        textPoints.setForeground(fg);
        this.add(textPoints);

        textPow.setBounds(50*2, 70*2, 400*2,30*2);  
        textPow.setFont(new Font("", Font.BOLD, 15*2));
        textPow.setForeground(fg);
        this.add(textPow);

        textCps.setBounds(50*2, 210*2, 400*2, 30*2);  
        textCps.setFont(new Font("", Font.BOLD, 15*2));
        textCps.setForeground(fg);
        this.add(textCps);

        textBought.setBounds(50*2, 140*2, 400*2,30*2);  
        textBought.setFont(new Font("", Font.BOLD, 15*2));
        textBought.setForeground(fg);
        this.add(textBought);

        powPlus.setBounds(250*2, 30*2, 200*2, 30*2);
        powPlus.setFont(new Font("", Font.BOLD, 15*2));
        powPlus.setFocusPainted(false);
        powPlus.setBorderPainted(false);
        powPlus.setBackground(fg);
        powPlus.setForeground(bg);
        powPlus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        powPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(points >= pricePow){
                    points = points - pricePow;
                    pow++;
                    pricePow = pricePow + (int) (pricePow * 0.15);
                    textBought.setText("Bought!");
                    textPoints.setText(String.valueOf(points));
                    textPow.setText("[POW]: " + pow);
                    powPlus.setText("[+1 POW]: " + pricePow);
                }
                else{
                    textBought.setText("Not enough points!");
                }
            }
        });
        this.add(powPlus);

        powX.setBounds(250*2, 100*2, 200*2, 30*2);
        powX.setFont(new Font("", Font.BOLD, 15*2));
        powX.setFocusPainted(false);
        powX.setBorderPainted(false);
        powX.setBackground(fg);
        powX.setForeground(bg);
        powX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        powX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(points >= pricePowX){
                    points = points - pricePowX;
                    pow = pow + 10;
                    pricePowX = pricePowX + (int) (pricePowX * 0.15);
                    textBought.setText("Bought!");
                    textPoints.setText(String.valueOf(points));
                    textPow.setText("[POW]: " + pow);
                    powX.setText("[+10 POW]: " + pricePowX);
                }
                else{
                    textBought.setText("Not enough points!");
                }
            }
        });
        this.add(powX);

        cpsPlus.setBounds(250*2, 170*2, 200*2, 30*2);
        cpsPlus.setFont(new Font("", Font.BOLD, 15*2));
        cpsPlus.setFocusPainted(false);
        cpsPlus.setBorderPainted(false);
        cpsPlus.setBackground(fg);
        cpsPlus.setForeground(bg);
        cpsPlus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cpsPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(points >= priceCps){
                    points = points - priceCps;
                    cps++;
                    priceCps = priceCps + (int) (priceCps * 0.30);
                    textBought.setText("Bought!");
                    textPoints.setText(String.valueOf(points));
                    textCps.setText("[CPS]: " + cps);
                    cpsPlus.setText("[+1 CPS]: " + priceCps);
                }
                else{
                    textBought.setText("Not enough points!");
                }
            }
        });
        this.add(cpsPlus);

        cpsX.setBounds(250*2, 240*2, 200*2, 30*2);
        cpsX.setFont(new Font("", Font.BOLD, 15*2));
        cpsX.setFocusPainted(false);
        cpsX.setBorderPainted(false);
        cpsX.setBackground(fg);
        cpsX.setForeground(bg);
        cpsX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cpsX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(points >= priceCpsX){
                    points = points - priceCpsX;
                    cps = cps + 10;
                    priceCpsX = priceCpsX + (int) (priceCpsX * 0.30);
                    textBought.setText("Bought!");
                    textPoints.setText(String.valueOf(points));
                    textCps.setText("[CPS]: " + cps);
                    cpsX.setText("[+10 CPS]: " + priceCpsX);
                }
                else{
                    textBought.setText("Not enough points!");
                }
            }
        });
        this.add(cpsX);

        settingText();

        reset.setBounds(20*2, 10*2, 100*2, 25*2);
        reset.setFont(new Font("", Font.BOLD, 15*2));
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);
        reset.setBackground(fg);
        reset.setForeground(bg);
        reset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    PrintWriter pw = new PrintWriter("save.uwu");
                    points = 0;
                    cps = 0;
                    priceCps = 100;
                    priceCpsX = 1000;
                    pow = 1;
                    pricePow = 50;
                    pricePowX = 500;
                    pw.println(points + " " + cps + " " + priceCps + " " + priceCpsX + " " + pow + " " + pricePow + " " + pricePowX);
                    pw.flush();
                    pw.close();
                    settingText();
                    save();
                }catch (FileNotFoundException d){
                    System.out.println(d.getMessage());
                }
            }
        });
        this.add(reset);
    }

    static void settingText(){
        textPoints.setText(String.valueOf(points));
        textCps.setText("[CPS]: " + Integer.toString(cps));
        cpsPlus.setText("[+1 CPS]: " + Integer.toString(priceCps));
        cpsX.setText("[+10 CPS]: " + Integer.toString(priceCpsX));
        textPow.setText("[POW]: " + Integer.toString(pow));
        powPlus.setText("[+1 POW]: " + Integer.toString(pricePow));
        powX.setText("[+10 POW]: " + Integer.toString(pricePowX));
    }

    public static void load(){
        try{
            FileInputStream fis = new FileInputStream("save.uwu");
            Scanner in = new Scanner(fis);
            points = in.nextLong();
            cps = in.nextInt();
            priceCps = in.nextInt();
            priceCpsX = in.nextInt();
            pow = in.nextInt();
            pricePow = in.nextInt();
            pricePowX = in.nextInt();
            settingText();
            in.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public static void save(){
        try{
            PrintWriter pw = new PrintWriter("save.uwu");
            pw.println(points + " " + cps + " " + priceCps + " " + priceCpsX + " " + pow + " " + pricePow + " " + pricePowX);
            pw.flush();
            pw.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}