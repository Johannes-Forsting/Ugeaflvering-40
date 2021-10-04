

import java.util.Scanner;
import java.util.SortedMap;

public class Game {
    public static Scanner scanner = new Scanner(System.in);
    public static String[] toys = {"Ball", "Teddybear", "Squeekytoy", "Dehumidifier", "Chewtoy", "Chocolatepiece"};
    public static String toy = "";
    public static void main(String[] args) {
        Tamagotchi animal = new Tamagotchi("");
        String animalChosen = chooseAnimal();
        String name = chooseName(animalChosen);

        switch (animalChosen){
            case "Naked mole rat":
                animal = new NakedMoleRat(name);
                break;
            case "Dog":
                    animal = new Dog(name);
                break;
        }


        while (animal.isDead == false){
            printDog();
            System.out.println(animal);
            callOptions(animalChosen, name);
            chooseActivity(animal, animalChosen);
            animal.checkForDeath();
        }
        System.out.println(name + " is dead. You no longer have a pet.");



    }

    //ASCII art af hund
    public static void printDog(){

    }

    public static void callOptions(String animal, String name){
        String walkOrCut = animal.equals("Dog") ? "Take for a walk" : "Cut nails";
        System.out.println("\nWhat would you like to do with " + name + "?");
        System.out.println("Press 1 for: Sleep");
        System.out.println("Press 2 for: Play");
        System.out.println("Press 3 for: Feed");
        System.out.println("Press 4 for: Scratch");
        System.out.println("Press 5 for: " + walkOrCut);
        System.out.println("Press 6 for: Celebrate birthday!");
        System.out.println("Press 7 for: EXIT");

    }

    public static void chooseActivity(Tamagotchi animal, String animalChosen){
        try {
            int activity = scanner.nextInt();
            if (activity > 0 && activity < 8){
                switch (activity){
                    case 1:
                        System.out.println("Sleep");
                        animal.sleep();
                        break;
                    case 2:
                        toy = chooseToy(animal);
                        animal.playWithToy(toy);
                        break;
                    case 3:
                        animal.feedAnimal();
                        break;
                    case 4:
                        animal.scratch();
                        break;
                    case 5:
                        animal.walkOrCutNails();
                        break;
                    case 6:
                        animal.celebrateBirthday(animalChosen);
                        break;
                    case 7:
                        animal.isDead = true;
                        break;
                }

            }
            else{
                throw new Exception();
            }
        }
        catch (Exception notAInteger){
            scanner.nextLine();
            System.out.println("Please only write within the numbers on the screen.");

        }
    }

    public static String chooseToy(Tamagotchi animal){
        System.out.println("What toy should " + animal.name + " play with?");
        for (int i = 0; i < toys.length; i++){
            System.out.println("Press " + (i + 1) + " for: " +  toys[i]);
        }

        while (true){
            try{
                int choice = scanner.nextInt();
                if (choice > 0 && choice <= toys.length){
                    toy = toys[choice - 1];
                    break;
                }
                else{
                    throw new Exception();
                }
            }
            catch (Exception e){
                scanner.nextLine();
                System.out.println("Only write a number between " + 1 + " and " + toys.length);
            }
        }

        return toy;
    }








    public static String chooseName(String animal){
        Scanner scanner = new Scanner(System.in);
        String name = "";
        while (true){
            boolean containsWrongChar = false;
            System.out.println("What do you want to call your " + animal + "?");
            name = scanner.nextLine();
            for (int i = 0; i < name.length(); i++) {
                char x = name.charAt(i);
                if (!Character.isLetter(x)){
                    containsWrongChar = true;
                    break;
                }
            }
            if (containsWrongChar == true){
                System.out.println("Your pets name can only contain letters.");
            }
            else{
                break;
            }
        }
        return name;
    }


    public static String chooseAnimal(){
        Scanner scanner = new Scanner(System.in);
        String returnStatement = "";
        while (true){
            System.out.println("Do you want to create a dog or a Naked mole rat?");
            System.out.println("Press 1 for dog. \nPress 2 for naked mole rat.");
            try{
                int choice = scanner.nextInt();
                if (choice == 1){
                    returnStatement = "Dog";
                    break;
                }
                else if (choice == 2){
                    returnStatement = "Naked mole rat";
                    break;
                }
                else{
                    throw new Exception();
                }
            }
            catch (Exception e){
                scanner.nextLine();
                System.out.println("I dont understand that. Please only write \"1\" or \"2\".");
            }
        }
        return returnStatement;
    }
}
