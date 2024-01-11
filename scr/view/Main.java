package view;

import controler.BasicBowController;
import controler.BasicBowPoolSingleton;
import controler.ShootingLaneControllerSingleton;
import model.*;

import static view.Input.*;

public class Main {
    public static void main(String[] args) {
        mainMenu();
    }
    static ShootingLaneControllerSingleton myLanes = ShootingLaneControllerSingleton.getInstance();
    static BasicBowPoolSingleton myBows = BasicBowPoolSingleton.getInstance();
    static BasicBowController myBowList = BasicBowController.getInstance();
    public static void mainMenu() {
        while (true) {
            System.out.println("-----------------------");
            System.out.println("Archery shooting range manager");
            System.out.println("1.Guest management");
            System.out.println("2.Lane management");
            System.out.println("3.Bow management");
            System.out.println("0.Exit");
            System.out.print("Enter choice: ");
            int choice = intInput();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    guestMenu();
                    break;
                case 2:
                    laneManagementMenu();
                    break;
                case 3:
                    bowManagementMenu();
                    break;
                default:
                    System.out.println("invalid input");
            }
        }
    }

    private static void bowManagementMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("**********");
            System.out.println("Bow management menu");
            System.out.println("1.New Bow");
            System.out.println("2.Remove Bow");
            System.out.println("3.Show list");
            System.out.println("0.Main Menu");
            System.out.print("Enter choice: ");
            choice = intInput();
            switch (choice) {
                case 1:
                    System.out.println("Enter poundage: ");
                    int poundage = intInput();
                    myBowList.addNewBasicBow(new BasicBow(poundage));
                    break;
                case 2:
                    System.out.println("Enter id: ");
                    int id = intInput();
                    for (Bow bow: myBowList.getBasicBowList()){
                        if (bow.getId() == id) {
                            myBowList.deleteByID(id);
                            break;
                        }
                    }
                    System.out.println("There is no bow id: " + id);
                    break;
                case 3:
                    for (Bow bow: myBowList.getBasicBowList()){
                        System.out.println(bow);
                    }
                    break;
                case 0:
                    mainMenu();
                    break;
                default:
                    System.out.println("Please input again");
            }
        }
    }

    public static void guestMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("**********");
            System.out.println("Guest menu");
            System.out.println("1.New guest");
            System.out.println("0.Main Menu");
            System.out.print("Enter choice: ");
            choice = intInput();
            switch (choice) {
                case 1:
                    guestInput();
                    break;
                case 0:
                    mainMenu();
                    break;
                default:
                    System.out.println("Please input again");
            }
        }
    }
    public static void laneManagementMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("**********");
            System.out.println("1.Lane list");
            System.out.println("2.Active Lane list");
            System.out.println("0.Main Menu");
            System.out.print("Enter choice: ");
            choice = intInput();
            switch (choice) {
                case 1:
                    for (ShootingLane lane : myLanes.laneList) {
                        System.out.println(lane);
                    }
                    break;
                case 2:
                    for (ShootingLane lane : myLanes.inUse) {
                        System.out.println(lane);
                    }
                    activeLaneMenu();
                    break;
                case 0:
                    mainMenu();
                    break;
                default:
                    System.out.println("Please input again");
            }
        }
    }
    public static void guestInput() {
        System.out.println("~~~~~~~~~~");
        System.out.println("Enter guest's name: ");
        String name = stringInput();
        System.out.println("Enter guest's phone numbers: ");
        String phoneNum = stringInput();
        Customer walkInGuest = new Customer(name, phoneNum);
        Bow bow = myBows.getBasicBow();
        PlaySession playSession = new PlaySession(bow, walkInGuest);
        autoLaneMenu(playSession);
    }

    private static void autoLaneMenu(PlaySession playSession) {
        System.out.println("Auto Lane assign? y/n");
        while (true) {
            String ans = stringInput();
            if (ans.equalsIgnoreCase("y")) {
                myLanes.getLane(playSession);
                autoStartMenu(playSession);
                break;
            } else if (ans.equalsIgnoreCase("n")) {
                manualLaneAssign(playSession);
                break;
            }else {
                System.out.println("Sorry, I didn't catch that. Please answer y/n");
            }
        }
    }

    public static void manualLaneAssign(PlaySession playSession) {
        System.out.println("~~~~~~~~~~");
        System.out.println("Enter lane id: ");
        int id = intInput();
        myLanes.getLane(id, playSession);
        autoStartMenu(playSession);
    }

    public static void autoStartMenu(PlaySession playSession) {
        System.out.println("Do you want to start now? y/n");
        while (true) {
            String ans = stringInput();
            if (ans.equalsIgnoreCase("y")) {
                playSession.startSession();
                break;
            } else if (ans.equalsIgnoreCase("n")) {
                return;
            }else {
                System.out.println("Sorry, I didn't catch that. Please answer y/n");
            }
        }
    }
    public static void activeLaneMenu() {
        System.out.println("Enter lane id: ");
        int id = intInput();
        ShootingLane shootingLane = myLanes.getActiveLaneById(id);
        if (shootingLane == null) {
            return;
        }
        PlaySession playSession = shootingLane.getPlaySession();
        int choice = -1;
        while (choice != 0) {
            System.out.println("**********");
            System.out.println("Active Lane Menu");
            System.out.println("1.Start session");
            System.out.println("2.End session");
            System.out.println("0.Main menu");
            System.out.print("Enter choice: ");
            choice = intInput();
            switch (choice) {
                case 1:
                    playSession.startSession();
                    break;
                case 2:
                    playSession.endSesstion();
                    System.out.println("Price: " + playSession.getPrice());
                    myLanes.releaseLane(id);
                    break;
                case 0:
                    mainMenu();
                    break;
                default:
                    System.out.println("Please input again");
            }
        }
    }
}
