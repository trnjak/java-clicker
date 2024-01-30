// made by marko trnjak (https://trnjak.github.io) 
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

public class LoadPicker implements ActionListener {
    int x = 1;
    JFrame LoadPicker = new JFrame("CHOOSE SAVE FILE");
    Color bg = new Color(0x546A76), fg = new Color(0xFAD4D8);
    public LoadPicker() {
        try{
            FileInputStream fis = new FileInputStream("scale.uwu");
            Scanner in = new Scanner(fis);
            x = in.nextInt();
            in.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        LoadPicker.setTitle("CHOOSE SAVE FILE");
        LoadPicker.setSize(250*x, 250*x);
        LoadPicker.setResizable(false);
        LoadPicker.setDefaultCloseOperation(3);
        LoadPicker.setLocationRelativeTo(null);
        LoadPicker.setAlwaysOnTop(true);
        LoadPicker.setLayout(new FlowLayout());
        LoadPicker.getContentPane().setBackground(bg);
        
        try {
            int i = 0;
            for (String str : listFilesUsingFilesList(".")) {
                if(str.startsWith("save")){
                    JButton button = new JButton(str);
                    File save = new File(str);
                    try {
                        button.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/SoyuzGroteskBold.otf")).deriveFont(16f*x));
                    } catch (Exception e) {
                        button.setFont(new Font("Consolas", Font.BOLD, 16*x));
                    }
                    button.setForeground(fg);
                    button.setBackground(bg);
                    button.setBorder(new LineBorder(fg));
                    button.setFocusable(false);
                    button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    button.addActionListener(this);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e){
                            new Clicker(x, save);
                        }
                    });
                    LoadPicker.add(button);
                    i++;
                }
            }
            if(i == 0){
                LoadPicker.setSize(250*x, 65*x);
                JLabel j = new JLabel("NO SAVE FILES FOUND");
                try {
                    j.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/SoyuzGroteskBold.otf")).deriveFont(16f*x));
                } catch (Exception e) {
                    j.setFont(new Font("Consolas", Font.BOLD, 16*x));
                }
                j.setForeground(fg);
                j.setBackground(bg);
                LoadPicker.add(j);
                JButton button = new JButton("GO BACK?");
                try {
                    button.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("../fonts/SoyuzGroteskBold.otf")).deriveFont(16f*x));
                } catch (Exception e) {
                    button.setFont(new Font("Consolas", Font.BOLD, 16*x));
                }
                button.setForeground(fg);
                button.setBackground(bg);
                button.setBorder(new LineBorder(fg));
                button.setFocusable(false);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                button.addActionListener(this);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        new StartPage();
                    }
                });
                LoadPicker.add(button);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        LoadPicker.setVisible(true);   
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        LoadPicker.dispose();
    }
    public Set<String> listFilesUsingFilesList(String dir) throws IOException { // code from https://www.baeldung.com/java-list-directory-files
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
            .filter(file -> !Files.isDirectory(file))
            .map(Path::getFileName)
            .map(Path::toString)
            .collect(Collectors.toSet());
        }
    }
}