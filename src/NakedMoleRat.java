import java.util.Scanner;

public class NakedMoleRat extends Tamagotchi{

    public boolean isMoist = true;
    public boolean needsNailsCut = false;

    //Constructor
    public NakedMoleRat(String name){
        super(name);
    }

    //Alle regler til Naked mole rat
    public void soutRules(){
        System.out.println("So you have adopted a naked mole rat. Naked mole rats a cute and very alive.");
        System.out.println("They are small but will fill your heart with love. Their skin is very precious since it has no hair to protect it.");
        System.out.println("If both " + this.name + "'s hunger and energy drops to 0 or below it will be exhausted die.");
        System.out.println("If its energy OR hunger drops to -5 or below it will be exhausted and die");
        System.out.println("If a naked mole rats skin gets too dry it will unfortunately die.");
        System.out.println("So be carefull what you let it play with, and remember to take care of its night routine.");
        System.out.println("Now lets start the life of your Tamagotchi!!!");
    }

    //Vokser bare neglene på den hårløse pungrotte
    @Override
    public void growNails(){
        this.needsNailsCut = true;
    }


    //Metode som klipper dens negle, men kun hvis den har brug for det.
    @Override
    public void walkOrCutNails(){
        if (this.needsNailsCut == true){
            System.out.println("You cut " + this.name + "'s nails. He doesn't like it so he spends a lot of energy when you do it.");
            this.energy = this.energy - 4;
            this.needsNailsCut = false;
        }
        else {
            System.out.println(this.name + " does not need a trim. Naked mole rats only need to get their nails cut once a year.");
        }
    }

    //Metode der spørg om man vil smørre sin pungrotte ind i fugtighedscreme. Hvis man ikke gør det inden den sover så tørre den ind og dør.
    public void moisturise(){
        Scanner scanner = new Scanner(System.in);
        String moistChoice = "";
        while (true){
            moistChoice = scanner.nextLine();
            if (moistChoice.equalsIgnoreCase("yes")){
                System.out.println("You grab your bottle of rat-moisturiser and squirt it on your naked mole rat. It seems to enjoy it.");
                System.out.println(this.name + " has now been moistureised.");
                this.isMoist = true;
            }
            else if (moistChoice.equalsIgnoreCase("no")){
                System.out.println("You put " + this.name + " to sleep without moisturising. Such cruelness!");
                this.isMoist = false;
            }
            else{
                System.out.println("I dont understand. Write \"yes\" or \"no\"");
            }
            break;
        }
    }

    //Sove metode. Inden den udføres kører moisturise metoden
    @Override
    public void sleep(){
        System.out.println(this.name + " needs to be moisturised before sleeping. Would you like to moistureise " + this.name + "?");
        moisturise();
        if (this.isMoist == false){
            this.isDead = true;
        }
        else{
            this.energy = 10;
            this.hunger = this.hunger - 3;
        }
    }

    //Metode der tjekekr om man har valgt Dehumidifier. Hvis man har, tørre den indog dør.
    @Override
    public void deathToy(String toy){
        if (toy.equals("Dehumidifier")){
            System.out.println(this.name + " plays with the " + toy + ". It slowly dries him out and he dies. Watch out for dehydrators when you own a naked mole rat.");
            this.isDead = true;
        }
        else{
            System.out.println(this.name + " is playing with " + toy + ".");
            System.out.println("It is so much fun, but " + this.name + " lost a bit of energy and got a little bit more hungry.");
            this.energy = this.energy - 3;
            this.hunger = this.hunger - 1;
        }
    }

    //To string metode til at printe dyrets stats i hver runde.
    @Override
    public String toString() {
        return "\n" + name + "'s stats are now:" +
                "\nAge = " + age + " years old" +
                "\nHunger = " + hunger + " of 10" +
                "\nEnergy = " + energy + " of 10" +
                "\nisMoist = " + isMoist +
                "\nneedsNailsCut = " + needsNailsCut +
                "\nisDead = " + isDead + "";
    }
}
