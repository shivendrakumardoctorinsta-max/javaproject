package factorypattern;

public class FactoryImplementation {
    public static void main(String[] args) {
        Icecream vanilla = new Icecream();
        vanilla.createIcecream("Cone", "Vanilla", "Cherry");
        

    }

}

class Icecream{
    public void createIcecream(String type, String flavor, String toppings){
        System.out.println(flavor + " Flavor " + type + " Icreame with "+toppings );
    }
}
