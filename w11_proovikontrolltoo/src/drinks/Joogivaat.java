package drinks;

public class Joogivaat {

    private float capacity; // (L)
    private float volume; // volume of currently held drink
    private Jook drink;

    public Joogivaat(float capacity, float volume, Jook drink) {
        this.capacity = capacity;
        this.volume = volume;
        this.drink = drink;
    }

    public void fill(Joogipudel bottle) {
        if (bottle.getDrink() != null) return;
        if (bottle.getVolume() > this.volume) return;

        this.volume -= bottle.getVolume();
        bottle.setDrink(this.drink);
    }

    public float getCapacity() {
        return this.capacity;
    }

    public float getVolume() {
        return this.volume;
    }

}
