public class EasyPlayer extends Player {
    private long points;
    private int cps = 1, priceCps = 50, priceCpsX = 500, pow = 2, pricePow = 25, pricePowX = 250;

    public EasyPlayer(long points, int cps, int priceCps, int priceCpsX, int pow, int pricePow, int pricePowX) {
        super(points, cps, priceCps, priceCpsX, pow, pricePow, pricePowX);
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

}
