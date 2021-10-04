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

    //Checker om dyret er ød ved at tjekke alder, energy og hunger.
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

    //Fodrer dyret
    public void feedAnimal(){
        if (this.hunger < 8) {
            System.out.println("You fill the feeding-bowl of " + this.name + ". He eats it all and his hunger is restored.");
            this.hunger = 10;
        }
        else{
            System.out.println("You fill the feeding-bowl of " + this.name + ", bu the is not hungry yet. He just sniffs it and walk away.");
        }
    }

    //Nusser/klør sit dyr
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
    public void celebrateBirthday(String animalChosen){
        if (animalChosen.equals("Naked mole rat")){
            growNails();
        }
        System.out.println("You celebrate " + this.name +"'s birthday. Its a cheerfull day with love and laughter.");
        System.out.println("But enjoy it while you can. Animals dont live forever.");
        this.age = this.age + 1;
        this.hunger = 10;
        this.energy = 10;
    }

    //Gør at neglene vokser på rotten
    public void growNails(){
    }

    //Sove metode. Begge dyr overrider så der er ikke noget funktion her.
    public void sleep(){
    }

    //Standard metode som bliver kørt hvis ingen af de 2 dræbere bliver valgt.
    public void playWithToy(String toy){

        if (toy.equals("Dehumidifier") || toy.equals("Chocolatepiece")) {
            deathToy(toy);
        }
        else{
            System.out.println(this.name + " is playing with " + toy + ".");
            System.out.println("It is so much fun, but " + this.name + " lost a bit of energy and got a little bit more hungry.");
            this.energy = this.energy - 3;
            this.hunger = this.hunger - 1;
        }
    }

    //Hvis man vælger dræberlegetøjet for en af dyrene dræber man dyret med denne metode
    public void deathToy(String toy){
    }



}
