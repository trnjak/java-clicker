public class EasyPlayer extends Player {
    private long points;
    private int cps = 1, priceCps = 50, priceCpsX = 500, pow = 2, pricePow = 25, pricePowX = 250;

    public EasyPlayer(long points, int cps, int priceCps, int priceCpsX, int pow, int pricePow, int pricePowX) {
        super(points, cps, priceCps, priceCpsX, pow, pricePow, pricePowX);
    }

}
