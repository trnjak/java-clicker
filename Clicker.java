/*
    Made by Marko (makisushi) https://github.com/makiesushi
*/
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Clicker{
    static long points = 0;
    static int cps = 0;
    static int priceCps = 100;
    static int priceCpsX = 1000;
    static int pow = 1;
    static int pricePow = 50;
    static int pricePowX = 500;

    static JFrame window = new JFrame("JavaClicker");
    static JButton button = new JButton("Click!");

    static JLabel textPoints = new JLabel(String.valueOf(points));
    static JLabel textPow = new JLabel("[POW]: " + pow);
    static JLabel textCps = new JLabel("[CPS]: " + cps);
    static JLabel textBought = new JLabel("");

    static JButton powPlus = new JButton("[+1 POW]: " + pricePow);
    static JButton powX = new JButton("[+10 POW]: " + pricePowX);
    static JButton cpsPlus = new JButton("[+1 CPS]: " + priceCps);
    static JButton cpsX = new JButton("[+10 CPS]: " + priceCpsX);

    static JButton reset = new JButton("RESET");

    static void window(){
        window.setLayout(null);  
        window.getContentPane().setBackground(new Color(162, 195, 164));
        window.setSize(500, 500);  
        window.setLocationRelativeTo(null);
        window.setResizable(false);  
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        window.setVisible(true);    
    }

    static void button(){
        button.setBounds(350, 390, 100, 50);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(new Color(32, 30, 80));
        button.setForeground(new Color(196, 241, 190));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                points = points + pow;
                textPoints.setText(String.valueOf(points));
            }
        });
        window.add(button);
    }  

    static void text(){
        textPoints.setBounds(50,400, 400,30);
        textPoints.setFont(new Font("Dialog", Font.BOLD, 20));  
        textPoints.setForeground(new Color(32, 30, 80));
        window.add(textPoints);

        textPow.setBounds(50,70, 400,30);  
        textPow.setFont(new Font("Dialog", Font.BOLD, 15));
        textPow.setForeground(new Color(32, 30, 80));
        window.add(textPow);

        textCps.setBounds(50,210, 400,30);  
        textCps.setFont(new Font("Dialog", Font.BOLD, 15));
        textCps.setForeground(new Color(32, 30, 80));
        window.add(textCps);

        textBought.setBounds(50,140, 400,30);  
        textBought.setFont(new Font("Dialog", Font.BOLD, 15));
        textBought.setForeground(new Color(32, 30, 80));
        window.add(textBought);
    }

    static void shop(){
        powPlus.setBounds(250, 30, 200, 30);
        powPlus.setFocusPainted(false);
        powPlus.setBorderPainted(false);
        powPlus.setBackground(new Color(32, 30, 80));
        powPlus.setForeground(new Color(196, 241, 190));
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
        window.add(powPlus);

        powX.setBounds(250, 100, 200, 30);
        powX.setFocusPainted(false);
        powX.setBorderPainted(false);
        powX.setBackground(new Color(32, 30, 80));
        powX.setForeground(new Color(196, 241, 190));
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
        window.add(powX);

        cpsPlus.setBounds(250, 170, 200, 30);
        cpsPlus.setFocusPainted(false);
        cpsPlus.setBorderPainted(false);
        cpsPlus.setBackground(new Color(32, 30, 80));
        cpsPlus.setForeground(new Color(196, 241, 190));
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
        window.add(cpsPlus);

        cpsX.setBounds(250, 240, 200, 30);
        cpsX.setFocusPainted(false);
        cpsX.setBorderPainted(false);
        cpsX.setBackground(new Color(32, 30, 80));
        cpsX.setForeground(new Color(196, 241, 190));
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
        window.add(cpsX);
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

    static void load(){
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

    static void save(){
        try{
            PrintWriter pw = new PrintWriter("save.uwu");
            pw.println(points + " " + cps + " " + priceCps + " " + priceCpsX + " " + pow + " " + pricePow + " " + pricePowX);
            pw.flush();
            pw.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    static void reset(){
        reset.setBounds(20, 10, 100, 25);
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);
        reset.setBackground(new Color(32, 30, 80));
        reset.setForeground(new Color(196, 241, 190));
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
        window.add(reset);
    }

    public static void main(String[] args) throws InterruptedException{
        window();
        button();
        text();
        shop();
        reset();
        load();
        while(true){
            points = points + cps;
            textPoints.setText(String.valueOf(points));
            textBought.setText("");
            save();
            Thread.sleep(1000);
        }
    }

}