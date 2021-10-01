

import java.util.Scanner;
import java.util.SortedMap;

public class Game {
    public static void main(String[] args) {
        String[] toys = {"Ball", "Teddybear", "Squeekytoy", "dehumidifier", "Chewtoy", "Chocolatepiece"};
        Tamagotchi[] animal = new Tamagotchi[1];
        String animalChosen = chooseAnimal();
        String name = chooseName(animalChosen);

        switch (animalChosen){
            case "Naked mole rat":
                animal[0] = new NakedMoleRat(name);
                break;
            case "Dog":
                    animal[0] = new Dog(name);
                break;
        }
        animal[0].soutRules();
        while (animal[0].isDead == false){
            System.out.println(animal[0]);
            callOptions(animalChosen, name);
            chooseActivity(animal, animalChosen);
            animal[0].checkForDeath();
        }
        System.out.println(name + " is dead. You no longer have a pet.");



    }

    public static void callOptions(String animal, String name){
        String walkOrCut = animal.equals("Dog") ? "Take for a walk" : "Cut nails";
        System.out.println("What would you like to do with " + name + "?");
        System.out.println("Press 1 for: Sleep");
        System.out.println("Press 2 for: Play");
        System.out.println("Press 3 for: Feed");
        System.out.println("Press 4 for: Scratch");
        System.out.println("Press 5 for: " + walkOrCut);
        System.out.println("Press 6 for: Celebrate birthday!");
        System.out.println("Press 7 for: EXIT");

    }

    public static void chooseActivity(Tamagotchi[] animal, String animalChosen){
        Scanner scanner = new Scanner(System.in);
        try {
            int activity = scanner.nextInt();
            if (activity > 0 && activity < 8){
                switch (activity){
                    case 1:
                        System.out.println("Sleep");
                        animal[0].sleep();
                        break;
                    case 2:
                        //Play
                        break;
                    case 3:
                        //Feed
                        break;
                    case 4:
                        animal[0].scratch();
                        break;
                    case 5:
                        animal[0].walkOrCutNails();
                    case 6:
                        animal[0].celebrateBirthday();
                        break;
                    case 7:
                        animal[0].isDead = true;
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
