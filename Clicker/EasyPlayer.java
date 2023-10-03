public class EasyPlayer extends Player {
    private long points;
    private int cps = 1, priceCps = 50, priceCpsX = 500, pow = 2, pricePow = 25, pricePowX = 250;

    public EasyPlayer(long points, int cps, int priceCps, int priceCpsX, int pow, int pricePow, int pricePowX) {
        super(points, cps, priceCps, priceCpsX, pow, pricePow, pricePowX);
    }

    @Override
    public void load(){
        try{
            FileInputStream fis = new FileInputStream("easy-save.uwu");
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
            PrintWriter pw = new PrintWriter("easy-save.uwu");
            pw.println(this.points + " " + this.cps + " " + this.priceCps + " " + this.priceCpsX + " " +
                    this.pow + " " + this.pricePow + " " + this.pricePowX);
            pw.flush();
            pw.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

}
