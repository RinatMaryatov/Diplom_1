import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.hamcrest.CoreMatchers.equalTo;
public class IngredientTest {
    private Ingredient ingredient;
    private final IngredientType expectedIngredientType = IngredientType.SAUCE;
    private final String expectedName = "sauceName";
    private final float expectedPrice = 50f;
    @Before
    public void prepareData() {
        this.ingredient = new Ingredient(
                expectedIngredientType,
                expectedName,
                expectedPrice
        );
    }
    @Test
    public void getPriceIsSuccess() {
        MatcherAssert.assertThat("Got incorrect ingredient's price", ingredient.getPrice(),equalTo(expectedPrice));
    }
    @Test
    public void getNameIsSuccess() {
        MatcherAssert.assertThat("Got incorrect ingredient's naming Возвращается некорректное наименование ингредиента", ingredient.getName(), equalTo(expectedName));
    }
    @Test
    public void getTypeIsSuccess() {
        MatcherAssert.assertThat("Got incorrect ingredient's type", ingredient.getType(), equalTo(expectedIngredientType));
    }
}
