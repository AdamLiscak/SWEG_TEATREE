import java.util.ArrayList;
import java.util.List;

public class MixtureCalculations
{
    public static void main(String args[])
    {
        ArrayList<Ingredient> ingredients=new ArrayList<>();
        ingredients.add(new AtomaryIngredient("Fenchel",20,2));
        ingredients.add(new AtomaryIngredient("Anis",100,2));
        ingredients.add(new AtomaryIngredient("Kamille",5,1));
        Mixture FAK= new Mixture(ingredients,4);
        ArrayList<Ingredient> ingredients1=new ArrayList<>();
        ingredients1.add(FAK);
        ingredients1.add(new AtomaryIngredient("Pfefferminze",50,1));
        Mixture PFAK=new Mixture(ingredients1,1);
        List<AtomaryIngredient> atomaryIngredients = solve(PFAK,125);
        printWeights(atomaryIngredients);
        printPrice(atomaryIngredients);


    }
    private static int calculateWeightedSum(List<AtomaryIngredient> atomaryIngredients)
    {
        int sum=0;
        for (AtomaryIngredient atomaryIngredient: atomaryIngredients)
        {
            sum+=atomaryIngredient.getRatio();
        }
        return sum;
    }
    private static float getSolvent(int sum, int equals )
    {
        return (float)equals/(float)sum;
    }
    private static void getPrice(float solvent, List<AtomaryIngredient> atomaryIngredients)
    {
        for (AtomaryIngredient atomaryIngredient: atomaryIngredients)
        {
            atomaryIngredient.setPrice((int)Math.ceil((float)atomaryIngredient.getPrice()*atomaryIngredient.getRatio()/10000000));
        }
    }
    private static void getQuantity(float solvent,List<AtomaryIngredient> atomaryIngredients)
    {
        for (AtomaryIngredient atomaryIngredient: atomaryIngredients)
        {
            atomaryIngredient.setRatio((int)Math.ceil(atomaryIngredient.getRatio()*solvent*100000));
        }
    }
    public static List<AtomaryIngredient> solve(Mixture m, int equals)
    {
        List<AtomaryIngredient> atomaryIngredients=m.getAtomaryIngredients(1);
        int sum=calculateWeightedSum(atomaryIngredients);
        float solvent=getSolvent(sum,equals);
        getQuantity(solvent,atomaryIngredients);
        getPrice(solvent,atomaryIngredients);
        return atomaryIngredients;

    }
    public static void printPrice(List<AtomaryIngredient> atomaryIngredients)
    {
        int sum=0;
        for (AtomaryIngredient atomaryIngredient: atomaryIngredients)
        {
            sum+=atomaryIngredient.getPrice();
        }
        System.out.println("Gesamtpreis: "+sum+" Cent");
    }
    public static void printWeights(List<AtomaryIngredient> atomaryIngredients)
    {
        for (AtomaryIngredient atomaryIngredient: atomaryIngredients)
        {
            System.out.println(atomaryIngredient.NAME+": "+(((float)atomaryIngredient.getRatio())/100000)+" g");
        }
    }

}
