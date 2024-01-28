// made by marko trnjak (https://trnjak.github.io)
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import java.io.*;
import java.util.*;

public class Clicker extends JFrame {

    public static void main(String[] args) {
        new StartPage();
        load();
        while(true){
            points = points + cps;
            textPoints.setText(String.valueOf(points));
            textBought.setText("");
            save();
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

    public Clicker(int x){
        this.setTitle("JAVAX SUCKS!");
        this.setLayout(null);  
        this.getContentPane().setBackground(bg);
        this.setSize(500*x, 500*x);  
        this.setLocationRelativeTo(null);
        this.setResizable(false);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);  

        button.setBounds(350*x, 390*x, 100*x, 50*x);
        try {
            button.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/VladivostokRegular.otf")).deriveFont(16f*x));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        textPoints.setBounds(50*x,400*x, 400*x,30*x);
        try {
            textPoints.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/VladivostokRegular.otf")).deriveFont(24f*x));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textPoints.setForeground(fg);
        this.add(textPoints);

        textPow.setBounds(50*x, 70*x, 400*x,30*x);  
        try {
            textPow.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/VladivostokRegular.otf")).deriveFont(16f*x));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textPow.setForeground(fg);
        this.add(textPow);

        textCps.setBounds(50*x, 210*x, 400*x, 30*x);  
        try {
            textCps.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/VladivostokRegular.otf")).deriveFont(16f*x));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textCps.setForeground(fg);
        this.add(textCps);

        textBought.setBounds(50*x, 140*x, 400*x,30*x);  
        try {
            textBought.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/VladivostokRegular.otf")).deriveFont(16f*x));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textBought.setForeground(fg);
        this.add(textBought);

        powPlus.setBounds(250*x, 30*x, 200*x, 30*x);
        try {
            powPlus.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/VladivostokRegular.otf")).deriveFont(16f*x));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        powX.setBounds(250*x, 100*x, 200*x, 30*x);  
        try {
            powX.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/VladivostokRegular.otf")).deriveFont(16f*x));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        cpsPlus.setBounds(250*x, 170*x, 200*x, 30*x);
        try {
            cpsPlus.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/VladivostokRegular.otf")).deriveFont(16f*x));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        cpsX.setBounds(250*x, 240*x, 200*x, 30*x);  
        try {
            cpsX.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/VladivostokRegular.otf")).deriveFont(16f*x));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        reset.setBounds(20*x, 10*x, 100*x, 25*x);
        try {
            reset.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/VladivostokRegular.otf")).deriveFont(16f*x));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);
        reset.setBackground(fg);
        reset.setForeground(bg);
        reset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(null,"THIS WILL RESET THE GAME AND OVERWRITE THE SAVE FILE","RESET",JOptionPane.OK_CANCEL_OPTION);
                if(ans == 0){
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