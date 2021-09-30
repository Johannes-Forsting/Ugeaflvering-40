public class Dog extends Tamagotchi{
    boolean needsAWalk;


    public Dog(String name){
        super(name);
        this.needsAWalk = false;
    }

    //Alle regler til hunde
    public void soutRules(){
        System.out.println("So you have adopted a dog. Dogs are not called man's best friend for no reason.");
        System.out.println("They are cute and playfull, but they also need alot of attention.");
        System.out.println("If both " + this.name + "'s hunger and energy drops to 0 or below it will be exhausted die.");
        System.out.println("If its energy OR hunger drops to -5 or below it will be exhausted and die");
        System.out.println("And remember that dogs are highly alergic to chocolate 🙄.");
        System.out.println("Now lets start the life of your Tamagotchi!!!");
    }


    @Override
    public String toString() {
        return name + "'s stats are now:" +
                "\nAge = " + age + " years old" +
                "\nHunger = " + hunger + " of 10" +
                "\nEnergy = " + energy + " of 10" +
                "\nneedsAWalk = " + needsAWalk +
                "\nisDead = " + isDead + "";
    }
}
