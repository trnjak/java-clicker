// made by marko trnjak (https://trnjak.github.io)
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.awt.*;

public class NewGame extends JFrame implements ActionListener {
    int x = 1;
    Color bg = new Color(0x546A76), fg = new Color(0xFAD4D8);

    JFileChooser chooser = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter("UWU save file", "uwu");

    JButton newGame = new JButton("NEW GAME"), loadGame = new JButton("LOAD GAME");
    JPanel panel = new JPanel();
    public NewGame(StartPage sp){
        try{
            FileInputStream fis = new FileInputStream("scale.uwu");
            Scanner in = new Scanner(fis);
            x = in.nextInt();
            in.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        this.setTitle("PLAY!");
        this.setSize(250*x, 75*x);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(bg);

        chooser.setPreferredSize(new Dimension(300*x, 250*x));
        chooser.setFileFilter(filter);

        newGame.setFont(new Font("", Font.BOLD, 12*x));
        newGame.setForeground(fg);
        newGame.setBackground(bg);
        newGame.setBorder(new LineBorder(fg));
        newGame.setFocusable(false);
        newGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        newGame.addActionListener(this);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                sp.dispose();
            }
        });
        newGame.setPreferredSize(new Dimension(125*x, 125*x));

        loadGame.setFont(new Font("", Font.BOLD, 12*x));
        loadGame.setForeground(fg);
        loadGame.setBackground(bg);
        loadGame.setBorder(new LineBorder(fg));
        loadGame.setFocusable(false);
        loadGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loadGame.addActionListener(this);
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                chooser.showOpenDialog(null);
                if(chooser.getSelectedFile().getName().endsWith("uwu")){
                    sp.dispose();
                }
            }
        });
        loadGame.setPreferredSize(new Dimension(125*x, 125*x));

        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(50*x, 50*x));
        panel.setBackground(bg);

        panel.add(newGame, BorderLayout.WEST);
        panel.add(loadGame, BorderLayout.EAST);

        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == newGame){
            File save = new File("save.uwu");
            if(new File("save.uwu").isFile()){
                int i = 1;
                while(new File("save"+i+".uwu").isFile()){
                    i++;
                }
                save = new File("save"+i+".uwu");
            }
            try {
                save.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            this.dispose();
            new Clicker(x, save);
        }
        if(e.getSource() == loadGame){
            if(chooser.getSelectedFile().getName().endsWith("uwu")){
                this.dispose();
                new Clicker(x, chooser.getSelectedFile());
            }
        }
    }
}