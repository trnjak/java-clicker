import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Player implements Players{
    private long points;
    private int cps = 0, priceCps = 100, priceCpsX = 1000, pow = 1, pricePow = 50, pricePowX = 500;

    @Override
    public void load(){
        try{
            FileInputStream fis = new FileInputStream("save.uwu");
            Scanner in = new Scanner(fis);
            this.points = in.nextLong();
            this.cps = in.nextInt();
            this.priceCps = in.nextInt();
            this.priceCpsX = in.nextInt();
            this.pow = in.nextInt();
            this.pricePow = in.nextInt();
            this.pricePowX = in.nextInt();
            Graphics.settingText(new Player(this.points, this.cps, this.priceCps, this.priceCpsX,
                    this.pow, this.pricePow, this.pricePowX));
            in.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void save(){
        try{
            PrintWriter pw = new PrintWriter("save.uwu");
            pw.println(this.points + " " + this.cps + " " + this.priceCps + " " + this.priceCpsX + " " +
                    this.pow + " " + this.pricePow + " " + this.pricePowX);
            pw.flush();
            pw.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public Player(long points, int cps, int priceCps, int priceCpsX, int pow, int pricePow, int pricePowX) {
        this.points = points;
        this.cps = cps;
        this.priceCps = priceCps;
        this.priceCpsX = priceCpsX;
        this.pow = pow;
        this.pricePow = pricePow;
        this.pricePowX = pricePowX;
    }

    public long getPoints() {
        return points;
    }
    public void setPoints(long points) {
        this.points = points;
    }

    public int getCps() {
        return cps;
    }
    public void setCps(int cps) {
        this.cps = cps;
    }

    public int getPriceCps() {
        return priceCps;
    }
    public void setPriceCps(int priceCps) {
        this.priceCps = priceCps;
    }

    public int getPriceCpsX() {
        return priceCpsX;
    }
    public void setPriceCpsX(int priceCpsX) {
        this.priceCpsX = priceCpsX;
    }

    public int getPow() {
        return pow;
    }
    public void setPow(int pow) {
        this.pow = pow;
    }

    public int getPricePow() {
        return pricePow;
    }
    public void setPricePow(int pricePow) {
        this.pricePow = pricePow;
    }

    public int getPricePowX() {
        return pricePowX;
    }
    public void setPricePowX(int pricePowX) {
        this.pricePowX = pricePowX;
    }
}
