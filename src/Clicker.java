// made by marko trnjak (https://trnjak.github.io)
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Clicker extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new StartPage();
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

    File currentSave = new File("save.uwu");

    public Clicker(int x, File save){
        try{
            load(save);
            currentSave = save;
        }catch(Exception e){
            System.out.println("new game, empty file");
            currentSave = save;
        }

        this.setTitle("Something - the Swing clicker game!");
        this.setLayout(null);  
        this.getContentPane().setBackground(bg);
        this.setSize(500*x, 500*x);  
        this.setLocationRelativeTo(null);
        this.setResizable(false);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);  

        button.setBounds(350*x, 390*x, 100*x, 50*x);
        button.setFont(new Font("", Font.BOLD, 16*x));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(fg);
        button.setForeground(bg);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(this);
        this.add(button);

        textPoints.setBounds(50*x,400*x, 400*x,30*x);
        textPoints.setFont(new Font("", Font.BOLD, 24*x));
        textPoints.setForeground(fg);
        this.add(textPoints);

        textPow.setBounds(50*x, 70*x, 400*x,30*x);  
        textPow.setFont(new Font("", Font.BOLD, 16*x));
        textPow.setForeground(fg);
        this.add(textPow);

        textCps.setBounds(50*x, 210*x, 400*x, 30*x);  
        textCps.setFont(new Font("", Font.BOLD, 16*x));
        textCps.setForeground(fg);
        this.add(textCps);

        textBought.setBounds(50*x, 140*x, 400*x,30*x);  
        textBought.setFont(new Font("", Font.BOLD, 16*x));
        textBought.setForeground(fg);
        this.add(textBought);

        powPlus.setBounds(250*x, 30*x, 200*x, 30*x);
        powPlus.setFont(new Font("", Font.BOLD, 16*x));
        powPlus.setFocusPainted(false);
        powPlus.setBorderPainted(false);
        powPlus.setBackground(fg);
        powPlus.setForeground(bg);
        powPlus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        powPlus.addActionListener(this);
        this.add(powPlus);

        powX.setBounds(250*x, 100*x, 200*x, 30*x);  
        powX.setFont(new Font("", Font.BOLD, 16*x));
        powX.setFocusPainted(false);
        powX.setBorderPainted(false);
        powX.setBackground(fg);
        powX.setForeground(bg);
        powX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        powX.addActionListener(this);
        this.add(powX);

        cpsPlus.setBounds(250*x, 170*x, 200*x, 30*x);
        cpsPlus.setFont(new Font("", Font.BOLD, 16*x));
        cpsPlus.setFocusPainted(false);
        cpsPlus.setBorderPainted(false);
        cpsPlus.setBackground(fg);
        cpsPlus.setForeground(bg);
        cpsPlus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cpsPlus.addActionListener(this);
        this.add(cpsPlus);

        cpsX.setBounds(250*x, 240*x, 200*x, 30*x);  
        cpsX.setFont(new Font("", Font.BOLD, 16*x));
        cpsX.setFocusPainted(false);
        cpsX.setBorderPainted(false);
        cpsX.setBackground(fg);
        cpsX.setForeground(bg);
        cpsX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cpsX.addActionListener(this);
        this.add(cpsX);

        settingText();

        reset.setBounds(20*x, 10*x, 100*x, 25*x);
        reset.setFont(new Font("", Font.BOLD, 16*x));
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);
        reset.setBackground(fg);
        reset.setForeground(bg);
        reset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reset.addActionListener(this);
        this.add(reset);

        run(save);
    }

    private void run(File save){
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable toRun = new Runnable() {
            public void run() {
                points = points + cps;
                textPoints.setText(String.valueOf(points));
                textBought.setText("");
                save(save);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        };
        scheduler.scheduleAtFixedRate(toRun, 1, 1, TimeUnit.SECONDS);
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

    public static void load(File save){
        try{
            FileInputStream fis = new FileInputStream(save);
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

    public static void save(File save){
        try{
            PrintWriter pw = new PrintWriter(save);
            pw.println(points + " " + cps + " " + priceCps + " " + priceCpsX + " " + pow + " " + pricePow + " " + pricePowX);
            pw.flush();
            pw.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public static void reset(File save){
        try{
            PrintWriter pw = new PrintWriter(save);
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
            save(save);
        }catch (FileNotFoundException d){
            System.out.println(d.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            points = points + pow;
            textPoints.setText(String.valueOf(points));
        }
        if(e.getSource() == powPlus){
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
        if(e.getSource() == powX){
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
        if(e.getSource() == cpsPlus){
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
        if(e.getSource() == cpsX){
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
        if(e.getSource() == reset){
            new ResetCheck(this);
        }
    }
}