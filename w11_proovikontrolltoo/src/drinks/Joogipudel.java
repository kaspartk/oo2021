package drinks;

public class Joogipudel {

    private String type;
    private float volume; // Litres
    private float tareValue;
    private float mass; // Bottle mass
    private Jook drink; // null -> empty, not null -> full

    public Joogipudel(String type, float volume, float tareValue, float mass) {
        this.type = type;
        this.volume = volume;
        this.tareValue = tareValue;
        this.mass = mass;
    }

    public Joogipudel(String type, float volume, float tareValue, float mass, Jook drink) {
        this.type = type;
        this.volume = volume;
        this.tareValue = tareValue;
        this.mass = mass;
        this.drink = drink;
    }

    public String getType() {
        return this.type;
    }

    public float getVolume() {
        return this.volume;
    }

    public float getTareValue() {
        return this.tareValue;
    }

    public float getMass() {
        return this.mass;
    }

    public Jook getDrink() {
        return this.drink;
    }

    public void setDrink(Jook drink) {
        this.drink = drink;
    }

    public float getTotalMass() {
        if (this.drink == null) return this.mass;
        return this.mass + this.volume * this.drink.getDensity();
    }

    public float getTotalPrice() {
        if (this.drink == null) return this.tareValue;
        return this.tareValue + this.volume * this.drink.getPrice();
    }
}

/** Koosta klass Jook, millel on nimetus, liitri omahind ning erikaal. 
Koosta klass Joogipudel, millel on maht, pudelityyp, mass ning taara maksumus. 
Samuti sees olev Jook, mis võib ka puududa. Koosta Joogipudeli jaoks käsklus, 
mis leiaks Joogipudeli massi koos Joogiga (juhul kui see olemas), samuti käsklus 
sellise komplekti omahinna leidmiseks. Koosta tööks automaattestid.

* Koosta klass Joogivaat, millel on ruumala ning sees oleva Joogi kogus 
liitrites. Koosta käsk etteantud Joogipudeli täitmiseks (juhul kui Jooki jagub). 
Koosta käsklus kogu Joogivaaditäie Joogi villimiseks Joogipudelitesse. 
Koosta töö kontrolliks automaattestid.

* Koosta Joogipudelite Kasti jaoks klass. Väljadeks kastityyp, kastihind, 
kastimass ning pesade arv (mitu pudelit mahub). Loo käsklused kasti ja sinna 
kuuluvate pudelite ühise massi ja omahinna arvutamiseks. Loo käsklus 
Joogivaadist Kasti sisse pudelite villimiseks. Koosta automaattestid.*/
