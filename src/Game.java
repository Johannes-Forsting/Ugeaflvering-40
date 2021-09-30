

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
        while (animal[0].isDead == false){
            System.out.println(animal[0]);
            chooseActivity(animal, animalChosen);
            animal[0].checkForDeath();
        }
        System.out.println(name + " is dead. You no longer have a pet.");



    }

    public static void chooseActivity(Tamagotchi[] animal, String animalChosen){
        Scanner scanner = new Scanner(System.in);
        try {
            int activity = scanner.nextInt();
            if (activity > 0 && activity < 5){
                switch (activity){
                    case 1:
                        System.out.println("Sleep");
                        animal[0].sleep();
                        break;
                    case 2:
                        //Play
                        break;
                    case 3:
                        //Scratch
                        break;
                    case 4:
                        System.out.println("celebrate birthday");
                        animal[0].celebrateBirthday();
                        break;
                    case 5:
                        //walt dog or cut nails on rat
                        break;
                    case 6:
                        //Exit game
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
