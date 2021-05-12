package drinks;

public class Joogikast {

    private String type;
    private float price;
    private float mass;
    private int sockets;
    private Joogipudel[] bottles;

    public Joogikast(String type, float price, float mass, int sockets) {
        this.type = type;
        this.price = price;
        this.mass = mass;
        this.sockets = sockets;
        this.bottles = new Joogipudel[sockets];
    }

    public Joogikast(String type, float price, float mass, 
        Joogipudel[] bottles) {
        
        this.type = type;
        this.price = price;
        this.mass = mass;
        this.sockets = bottles.length;
        this.bottles = bottles;
    }

    public void fill(Joogivaat barrel) {
        for (Joogipudel each : this.bottles) {
            if (each == null) continue;
            barrel.fill(each);
        }
    }

    public float getTotalMass() {
        float sum = this.mass;

        for (Joogipudel each : this.bottles) {
            if (each == null) continue;
            sum += each.getTotalMass();
        }

        return sum;
    }

    public float getTotalPrice() {
        float sum = this.price;

        for (Joogipudel each : this.bottles) {
            if (each == null) continue;
            sum += each.getTotalPrice();
        }
        
        return sum;
    }

    public boolean addBottle(Joogipudel bottle) {
        
        for (int i = 0; i < this.sockets; i++) {
            if (this.bottles[i] == null) {
                this.bottles[i] = bottle;
                return true;
            }
        }
        
        return false;
    }

    public String getType() {
        return this.type;
    }

    public float getPrice() {
        return this.price;
    }

    public float getMass() {
        return this.mass;
    }

    public int getSockets() {
        return this.sockets;
    }

    public Joogipudel[] getBottles() {
        return this.bottles;
    }

}
