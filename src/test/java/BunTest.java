import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters()
    public static Object[][] getData() {
        return new Object[][] {
                {"first bun", 100},
                {"second bun", 200},
                {"third bun", 300},
                {"fourth bun", 400},
                {"fifth bun", 500},
                {" bun", 100},
                {" bun ", 100},
                {"bun ", 100},
                {"", 100},
                {null, 100},
                {"bun", 0},
                {"bun", -0.1f},
                {null, -0},
                {"", -100000}
        };
    }

    @Test
    public void getNameBunNameShouldBeReturnedTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Should be bun's name displayed" ,bunName, bun.getName());
    }

    @Test
    public void getPriceBunPriceShouldBeReturnedTest() {
        Bun bun = new Bun(bunName, bunPrice);
        assertEquals("Should be bun's price displayed", bunPrice, bun.getPrice(), 0);
    }
}
