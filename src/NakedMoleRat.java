import java.util.Scanner;

public class NakedMoleRat extends Tamagotchi{
    public boolean isMoist;
    public boolean needsNailsCut;

    public NakedMoleRat(String name){
        super(name);
        this.isMoist = true;
        this.needsNailsCut = false;
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


    @Override
    public String toString() {
        return name + "'s stats are now:" +
                "\nAge = " + age + " years old" +
                "\nHunger = " + hunger + " of 10" +
                "\nEnergy = " + energy + " of 10" +
                "\nisMoist = " + isMoist +
                "\nisDead = " + isDead + "";
    }
}
