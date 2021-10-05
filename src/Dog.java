import java.util.Random;

public class Dog extends Tamagotchi{
    boolean needsAWalk = false;


    public Dog(String name){
        super(name);
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
    public void sleep(){
        if (this.energy > 6){
            System.out.println(this.name + " is not tired. Its energy is too high. Do something else with " + this.name + " before sleeping.");
        }
        else if (this.energy > 1){
            System.out.println(this.name + " is a bit tired and falls asleep relatively fast. Energy is restored fully.");
            this.energy = 10;
            System.out.println(this.name + " also got a little bit more hungry.");
            this.hunger = this.hunger - 3;
            this.needsAWalk = true;

        }
        else {
            System.out.println(this.name + " is exhausted, and falls asleep like a rock, but sleeps so much that energy is only restored to 8." );
            System.out.println(this.name + " also got a little bit more hungry.");
            this.hunger = this.hunger - 3;
            this.needsAWalk = true;
        }
    }



    @Override
    public void walkOrCutNails(){
        Random random = new Random();
        boolean isWeatherBad = random.nextBoolean();

        if (needsAWalk == true) {
            if (isWeatherBad == true) {
                System.out.println("You take " + this.name + " for a walk, but it is raining and you only want to do a small walk.");
                this.energy = this.energy - 1;
            } else {
                System.out.println("You take " + this.name + " for a nice walk. The sun is shining and all is good. You walk for hours and hours.");
                System.out.println(this.name + " is exhausted from the walk and properly needs food and sleep soon");
                this.hunger = this.hunger - 4;
                this.energy = this.energy - 4;
            }
            needsAWalk = false;
            System.out.println("        ,,,\n" +
                    "       /   \\\n" +
                    "      | o o |\n" +
                    "     (|  ^  |)\n" +
                    "       \\___/\n" +
                    "         | _ _ _ _ _ _ _ _,,\n" +
                    "        /|                ()            \n" +
                    "       / |                  \\\n" +
                    "      /  |                   \\\n" +
                    "         |                    \\  /)-_-(\\    \n" +
                    "         |                     \\  (o o)     \n" +
                    "         |                .-----\\_/\\o/      \n" +
                    "        / \\              /  __      /       \n" +
                    "       /   \\         \\__/^ /  \\_\\ |/        \n" +
                    "      /     \\             \\\\     ||         \n" +
                    "     /       \\            //     ||         \n" +
                    "    /         \\           |\\     |\\   ");
        }
        else {
            System.out.println(this.name + " does not need a walk. Do something else with him.");
        }
    }

    @Override
    public void deathToy(String toy){
        if (toy.equals("Chocolatepiece")){
            System.out.println(this.name + " plays with the " + toy + ". Dogs are highly allergic to chocolate. You try to take him to the vet but it is too late.");
            this.isDead = true;
        }
        else{
            System.out.println(this.name + " is playing with " + toy + ".");
            System.out.println("It is so much fun, but " + this.name + " lost a bit of energy and got a little bit more hungry.");
            this.energy = this.energy - 3;
            this.hunger = this.hunger - 1;
        }
    }


    @Override
    public String toString() {
        return "\n" + name + "'s stats are now:" +
                "\nAge = " + age + " years old" +
                "\nHunger = " + hunger + " of 10" +
                "\nEnergy = " + energy + " of 10" +
                "\nneedsAWalk = " + needsAWalk +
                "\nisDead = " + isDead + "";
    }
}
