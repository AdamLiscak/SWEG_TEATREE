import java.util.ArrayList;
import java.util.List;

public class AtomaryIngredient implements Ingredient
{
    private static List<AtomaryIngredient> ingredients=new ArrayList();
    public final String NAME;
    private int price;
    private int ratio;

    public AtomaryIngredient(String NAME, int price, int RATIO)
    {
        this.NAME = NAME;
        this.price = price;
        this.ratio = RATIO;
    }
    public void setRatio(int ratio)
    {
        this.ratio=ratio;
    }
    public int getRatio()
    {
        return this.ratio;
    }
    public int getPrice()
    {
        return this.price;
    }
    public void setPrice(int price)
    {
        this.price=price;
    }
    public static List<AtomaryIngredient> getIngredients()
    {
        return ingredients;
    }
    @Override
    public String toString() {
        return NAME+" "+price+" "+ratio;
    }
    @Override
    public void getIngredient(int ratio)
    {
        ingredients.add(new AtomaryIngredient(NAME,price,(this.ratio*ratio)));
    }
}
