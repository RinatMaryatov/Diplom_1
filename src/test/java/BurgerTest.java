import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final Burger burger = new Burger();
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;

    private final List<Bun> buns = List.of(new Bun("black bun", 100.50F));

    @Test
    public void checkSetBun() {
        burger.setBuns(buns.get(0));
        String bunName = "black bun";
        assertEquals(bunName, burger.bun.getName());
    }

    @Test
    public void checkGetPrice() {
        Mockito.when(ingredient1.getPrice()).thenReturn(319.01F);
        Mockito.when(ingredient2.getPrice()).thenReturn(240.04F);
        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedPrice = 760.05F;
        assertEquals("Incorrect price for a burger with 2 ingredients",expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void checkGetReceipt() {
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getName()).thenReturn("sour cream");
        Mockito.when(ingredient1.getPrice()).thenReturn(200F);

        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getName()).thenReturn("cutlet");
        Mockito.when(ingredient2.getPrice()).thenReturn(200F);

        Mockito.when(ingredient3.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient3.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient3.getPrice()).thenReturn(99F);

        burger.setBuns(buns.get(0));
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        String expectedReceipt = "(==== " + burger.bun.getName() + " ====)" + "\r\n"
                + "= sauce sour cream =" + "\r\n"
                + "= filling cutlet =" + "\r\n"
                + "= filling dinosaur =" + "\r\n"
                + "(==== black bun ====)" + "\r\n\n"
                + "Price: 700,000000" + "\r\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void checkRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);

        int index = burger.ingredients.indexOf(ingredient1);
        burger.removeIngredient(index);

        assertFalse("Can't remove ingredient from burger", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void moveIngredientIsSuccess() {
        Mockito.when(ingredient1.getName()).thenReturn("ingredientName");

        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        int currentIndex = burger.ingredients.indexOf(ingredient1);
        int newIndex = burger.ingredients.indexOf(ingredient2);

        burger.moveIngredient(currentIndex, newIndex);
        MatcherAssert.assertThat("Can't move ingredient in burger", ingredient1.getName(), equalTo(burger.ingredients.get(newIndex).getName())
        );
    }
}