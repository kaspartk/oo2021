package drinks;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DrinksTests {

    // javac -d ./out ./src/drinks/Jook.java
    // javac -d ./out ./src/drinks/Joogipudel.java
    // javac -d ./out ./src/drinks/Jook.java ./src/drinks/Joogipudel.java

    // Compile and run tests (Mac and Linux) (For windows replace ':' with ';')
    // javac -d ./out -cp ./lib/hamcrest-all-1.3.jar:./lib/junit-4.12.jar ./src/drinks/Jook.java ./src/drinks/Joogipudel.java ./src/drinks/Joogivaat.java ./src/drinks/Joogikast.java ./src/drinks/DrinksTests.java
    // java -cp ./out:./lib/hamcrest-all-1.3.jar:./lib/junit-4.12.jar org.junit.runner.JUnitCore drinks.DrinksTests

    // Compile and run tests (For windows, replace ':' with ';') 
    // javac -d ./out -cp ./lib/hamcrest-all-1.3.jar;./lib/junit-4.12.jar;. ./src/drinks/Jook.java ./src/drinks/Joogipudel.java ./src/drinks/Joogivaat.java ./src/drinks/Joogikast.java ./src/drinks/DrinksTests.java
    // java -cp ./out;./lib/hamcrest-all-1.3.jar;./lib/junit-4.12.jar org.junit.runner.JUnitCore drinks.DrinksTests

    // public static void main(String[] args) {}

    // Windows - do in cmd, powershell is a douche
    // javac -d ./out -cp "./lib/hamcrest-all-1.3.jar;./lib/junit-4.12.jar;." ./src/drinks/Jook.java ./src/drinks/Joogipudel.java ./src/drinks/Joogivaat.java ./src/drinks/Joogikast.java ./src/drinks/DrinksTests.java
    // java -cp "./lib/hamcrest-all-1.3.jar;./lib/junit-4.12.jar;./out/" org.junit.runner.JUnitCore drinks.DrinksTests

    @Test
    public void testDrinkBottleCalculatesTotalMass() {
        Jook cocacola = new Jook("Coca-Cola", 0.79f, 1.2f);
        Jook mineralWater = new Jook("Borjomi", 1.89f, 1.1f);

        Joogipudel pet2L = new Joogipudel("PET", 2f, 0.1f, 0.025f, cocacola);
        Joogipudel glass05L = new Joogipudel("Glass", 0.5f, 0.1f, 0.1f);
        glass05L.setDrink(mineralWater);

        double d1 = pet2L.getTotalMass();
        double d2 = glass05L.getTotalMass();

        assertThat(d1, is(Matchers.closeTo(2.425, 0.001)));
        assertThat(d2, is(Matchers.closeTo(0.65, 0.001)));
    }


    @Test
    public void testDrinkBottleCalculatesTotalPrice() {
        Jook cocacola = new Jook("Coca-Cola", 0.79f, 1.2f);
        Jook mineralWater = new Jook("Borjomi", 1.89f, 1.1f);

        Joogipudel pet2L = new Joogipudel("PET", 2f, 0.1f, 0.025f, cocacola);
        Joogipudel glass05L = new Joogipudel("Glass", 0.5f, 0.1f, 0.1f);
        glass05L.setDrink(mineralWater);

        double d1 = pet2L.getTotalPrice();
        double d2 = glass05L.getTotalPrice();

        assertThat(d1, is(Matchers.closeTo(1.68, 0.001)));
        assertThat(d2, is(Matchers.closeTo(1.045, 0.001)));
    }


    @Test
    public void testBarrelShouldFillBottle() {
        Jook auraLemon = new Jook("Aura sidrunivesi", 1.29f, 1.05f);
        Joogivaat barrel = new Joogivaat(20f, 2.6f, auraLemon);
        Joogipudel metallic = new Joogipudel("Aluminum", 1f, 1.99f, 0.1f);

        assertThat(metallic.getDrink(), is(nullValue()));

        barrel.fill(metallic);

        assertThat(metallic.getDrink(), is(auraLemon));

        double d1 = barrel.getVolume();

        assertThat(d1, is(Matchers.closeTo(1.6, 0.001)));

        barrel.fill(metallic); // Can't double fill
        d1 = barrel.getVolume();

        assertThat(d1, is(Matchers.closeTo(1.6, 0.001)));
    }


    @Test
    public void testBarrelShouldNotFillBottle() {
        Jook auraLemon = new Jook("Aura sidrunivesi", 1.29f, 1.05f);
        Joogivaat barrel = new Joogivaat(20f, 0.6f, auraLemon);
        Joogipudel metallic = new Joogipudel("Aluminum", 1f, 1.99f, 0.1f);

        assertThat(metallic.getDrink(), is(nullValue()));

        barrel.fill(metallic);

        assertThat(metallic.getDrink(), is(nullValue()));

        double d1 = barrel.getVolume();

        assertThat(d1, is(Matchers.closeTo(0.6, 0.001)));
    }


    @Test
    public void testBarrelShouldNotDoubleFillBottle() {
        Jook auraLemon = new Jook("Aura sidrunivesi", 1.29f, 1.05f);
        Joogivaat barrel = new Joogivaat(20f, 3.6f, auraLemon);
        Joogipudel metallic = new Joogipudel("Aluminum", 1f, 1.99f, 0.1f, auraLemon);

        assertThat(metallic.getDrink(), is(auraLemon));

        barrel.fill(metallic);

        assertThat(metallic.getDrink(), is(auraLemon));

        double d1 = barrel.getVolume();

        assertThat(d1, is(Matchers.closeTo(3.6, 0.001)));
    }

    @Test
    public void testCrateCanFillBottles() {
        Jook auraLemon = new Jook("Aura sidrunivesi", 1.29f, 1.05f);
        Joogivaat barrel = new Joogivaat(20f, 3.6f, auraLemon);

        Joogipudel pet2L = new Joogipudel("PET", 2f, 0.1f, 0.025f);
        Joogipudel glass05L = new Joogipudel("Glass", 0.5f, 0.1f, 0.1f);
        Joogipudel metallic = new Joogipudel("Aluminum", 1f, 1.99f, 0.1f, 
            auraLemon);

        Joogipudel[] bottles = new Joogipudel[6];
        bottles[0] = pet2L;
        bottles[1] = glass05L;
        bottles[2] = metallic;

        Joogikast crate = new Joogikast("Wooden crate", 2.5f, 1f, bottles);

        double d1 = crate.getTotalPrice();
        double d2 = crate.getTotalMass();

        assertThat(d1, is(Matchers.closeTo(5.98, 0.001)));
        assertThat(d2, is(Matchers.closeTo(2.275, 0.001)));

        crate.fill(barrel);

        d1 = crate.getTotalPrice();
        d2 = crate.getTotalMass();

        assertThat(d1, is(Matchers.closeTo(9.205, 0.001)));
        assertThat(d2, is(Matchers.closeTo(4.9, 0.001)));
    }

}
