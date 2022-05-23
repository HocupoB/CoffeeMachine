
import java.util.Scanner;



public class CoffeeMachine {
    public static Scanner scanOption = new Scanner (System.in);
    public static Scanner scanType = new Scanner (System.in);
    public static Scanner scanFill = new Scanner (System.in);
    public static int cups;
    public static int disposableCups = 9;
    public static int money = 550;
    public static int water = 400;
    public static int milk = 540;
    public static int coffeeBeans =  120;
    
    public static void displayIngredients(){     
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans +" g of coffee beans");
        System.out.println(disposableCups +" disposable cups");
        System.out.println("$"+money +" of money");
    } 
    
    public static void run(){
        boolean run = true;
        while(run){
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String option = scanOption.nextLine();
            switch(option){
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    displayIngredients();
                    break;
                case "exit":
                    run = false;
                    break;
                default:
                    System.out.println("Wrong input action");
                    break;
            }
        }
    }

    public static void buyCoffee(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String typeOfCoffee = scanType.next();
        switch(typeOfCoffee){
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappucino();
                break;
            case "back":
                break;   
            default:    
                System.out.println("Wrong input for coffee!");
                break;
             
        }
    }
    public static void makeEspresso(){
        if(water >=250 && coffeeBeans>=16 && disposableCups>=1){
            water -=250;
            coffeeBeans -= 16;
            money += 4;
            disposableCups --; 
            System.out.println("I have enough resources, making you a coffee!");
        } else if(water < 250){
            System.out.println("Sorry, not enough water!");
                       
        } else if(coffeeBeans < 16){
            System.out.println("Sorry, not enough coffee beans!");
                       
        }

    }
    public static void makeLatte(){
        if( water >=350 && coffeeBeans>=20 && disposableCups>=1 && milk >=75){
            water -=350;
            milk -= 75;
            coffeeBeans -= 20;
            money += 7;
            disposableCups --;
            System.out.println("I have enough resources, making you a coffee!");
        } else if(water < 350){
            System.out.println("Sorry, not enough water!");
                       
        } else if(coffeeBeans < 20){
            System.out.println("Sorry, not enough coffee beans!");
                       
        }else if(milk < 75){
            System.out.println("Sorry, not enough milk!");
                       
        }
    }
    public static void makeCappucino(){
        if( water >=200 && coffeeBeans>=12 && disposableCups>=1 && milk >=100){
            water -=200;
            milk -= 100;
            coffeeBeans -= 12;
            money += 6;
            disposableCups --;
            System.out.println("I have enough resources, making you a coffee!");
        } else if(water < 200){
            System.out.println("Sorry, not enough water!");
                       
        } else if(coffeeBeans < 12){
            System.out.println("Sorry, not enough coffee beans!");
                       
        }else if(milk < 100){
            System.out.println("Sorry, not enough milk!");
                       
        }
    }    
    public static void fill(){
        
        System.out.println("Write how many ml of water you want to add:");
        water += scanFill.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanFill.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanFill.nextInt();
        
        
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCups += scanFill.nextInt();

    }
    public static void takeMoney(){
        System.out.println("I gave you $" + money);
        money = 0;
    } 


    public static void main(String[] args) {
        run();


    }
}
