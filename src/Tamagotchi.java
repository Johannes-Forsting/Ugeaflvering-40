import java.util.Random;

public class Tamagotchi {
    public String name;
    public int age = 0;
    public int hunger = 10;
    public int energy = 10;
    public boolean isDead = false;

    public Tamagotchi (String name){
        this.name = name;
    }

    public void soutRules(){
    }

    public void walkOrCutNails(){
    }

    public void checkForDeath(){
        if (this.age > 30){
            this.isDead = true;
        }
        else if (this.hunger <= -5 || this.energy <= -5){
            this.isDead = true;
        }
        else if (this.hunger <=0 && this.energy <= 0){
            this.isDead = true;
        }
    }


    public void scratch(){
        Random random = new Random();
        boolean shortScratch = random.nextBoolean();
        if (shortScratch == true){
            System.out.println("You start scratching " + this.name + ". He does not seem to enjoy i much so you only scratch for 5 minutes.");
            this.energy = this.energy - 1;
            this.hunger = this.hunger - 1;
        }
        else {
            System.out.println("You start scratching " + this.name + ". He seems to love it, so you keep going for atleast 30 minutes.");
            this.energy = this.energy - 2;
            this.hunger = this.hunger - 1;
        }
    }



    //Celebrate birthday. Der er gået et års tid og din tamagotchi er blevet 1 år ældre.
    public void celebrateBirthday(){
        System.out.println("You celebrate " + this.name +"'s birthday. Its a cheerfull day with love and laughter.");
        System.out.println("But enjoy it while you can. Animals dont live forever.");
        this.age = this.age + 1;
        this.hunger = 10;
        this.energy = 10;
    }

    //Sove metode. Bliver kun brugt af dog, da nake mole rat overrider den og laver sin egen metode.
    public void sleep(){
        if (this.energy > 6){
            System.out.println(this.name + " is not tired. Its energy is too high. Do something else with " + this.name + " before sleeping.");
        }
        else if (this.energy > 1){
            System.out.println(this.name + " is a bit tired and falls asleep relatively fast. Energy is restored fully.");
            this.energy = 10;
            System.out.println(this.name + " also got a little bit more hungry.");
            this.hunger = this.hunger - 3;
        }
        else {
            System.out.println(this.name + " is exhausted, and falls asleep like a rock, but sleeps so much that energy is only restored to 8." );
            System.out.println(this.name + " also got a little bit more hungry.");
            this.hunger = this.hunger - 3;
        }
    }

    //Standard metode som bliver kørt hvis ingen af de 2 dræbere bliver valgt.
    public void playWithToy(String toy){
        System.out.println(this.name + " is playing with " + toy + ".");
        System.out.println("It is so much fun, but " + this.name + " lost a bit of energy and got a little bit more hungry.");
        this.energy = this.energy - 3;
        this.hunger = this.hunger - 1;
    }



}
