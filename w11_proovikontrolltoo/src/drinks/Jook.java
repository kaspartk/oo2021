package drinks;

public class Jook {

    private String name;
    private float price; // Per 1 L
    private float density;

    public Jook(String name, float price, float density) {
        this.name = name;
        this.price = price;
        this.density = density;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public float getDensity() {
        return this.density;
    }
}
