import java.util.List;

public class Mixture implements Ingredient
{
    public final int RATIO;
    private List<Ingredient> ingredients;
    public Mixture(List<Ingredient> ingredients, int RATIO)
    {
        this.ingredients=ingredients;
        this.RATIO=RATIO;
    }
    public void getIngredient(int ratio)
    {
        for (Ingredient ingredient:ingredients)
        {
            ingredient.getIngredient(RATIO*ratio);
           // System.out.println(ingredient+" "+r+" "+RATIO);
        }
    }
    public List<AtomaryIngredient> getAtomaryIngredients(int ratio)
    {
       getIngredient(ratio);
        List<AtomaryIngredient> atomaryIngredients=AtomaryIngredient.getIngredients();
        return atomaryIngredients;
    }
}
