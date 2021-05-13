package w15;

public class Line implements LineSolver {

    private double slope;
    private double intercept;

    public Line(double slope, double intercept) {
        this.slope = slope;
        this.intercept = intercept;
    }

    @Override
    public double solve(double x) {
        return this.slope * x + this.intercept;
    }

    public static <T extends LineSolver> double[] solveArray(double[] x, T line) {
        double[] y = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = line.solve(x[i]);
        }
        return y;
    }

    public double getSlope() {
        return this.slope;
    }

    public double getIntercept() {
        return this.intercept;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public void setIntercept(double intercept) {
        this.intercept = intercept;
    }


}


/**
* Koosta liides joone y-i väärtuse leidmiseks vastavalt x-i väärtusele. 
Koosta automaattestid kontrollimaks mitut punkti sirgel y=3x. Koosta realiseeriv 
klass, millele antakse konstruktoris ette x-i kordaja. Kontrolli klassi 
eksemplari oskuste vastavust testidele.

* Loo teine realiseeriv klass, millele saab ette anda kordaja ja vabaliikme. 
Kontrolli selle klassi tööd liidese kaudu testidega joontele y=3x ning y=3x+2. 
Koosta funktsioon, mis saab parameetriks x-ide massiivi ning liidesele vastava 
y-koordinaate arvutava klassi ning tagastab vastavate y-ite massiivi. Kontrolli 
klasside ja funktsiooni tööd automaattestidega.

* Sisend loetakse failist, kuhu sisestatakse a, b ja x-i vähim ja suurim 
väärtus. Tulemuste arvutamiseks kasutatakse eelnevalt loodud ja testitud 
funktsiooni, realiseeriv klass valitakse vastavalt b väärtusele - nulli puhul 
esimene lihtsam variant. Koosta faili lugeva rakenduse väljundi kontrolliks 
automaattest.


 */