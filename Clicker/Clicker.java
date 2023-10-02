import java.util.Scanner;
/*
    Made by Marko (makisushi) https://github.com/makiesushi
*/
public class Clicker{

    public static void main(String[] args) throws InterruptedException{
        Player p;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("0 - regular mode\n" + "1 - easy mode, NO SAVES");
            int n = in.nextInt();
            if(n == 0){
                p = new Player(0, 0, 100, 1000, 1, 50, 500);
                p.load();
                Graphics.settingText(p);
                break;
            }
            else if(n == 1){
                p = new EasyPlayer(0, 1, 50, 500, 2, 25, 250);
                Graphics.settingText(p);
                break;
            }
            else{
                System.out.println("Wrong number!");
            }
        }
        in.close();
        Graphics g = new Graphics(p);
        while(true){
            p.setPoints(p.getPoints()+p.getCps());
            g.getTextPoints().setText(String.valueOf(p.getPoints()));
            g.getTextBought().setText("");
            p.save();
            Thread.sleep(1000);
        }
    }

}