package view;

import controler.BasicBowPoolSingleton;
import controler.ShootingLaneControllerSingleton;
import model.Bow;
import model.Customer;
import model.PlaySession;
import model.ShootingLane;

import static view.Input.*;

public class Main {
    ShootingLaneControllerSingleton myLanes = ShootingLaneControllerSingleton.getInstance();
    BasicBowPoolSingleton myBows = BasicBowPoolSingleton.getInstance();
    public void mainMenu() {
        System.out.println("-----------------------");
        System.out.println("Archery shooting range manager");
        System.out.println("1.Guest management");
        System.out.println("2.Lane management");
        System.out.print("Enter choice: ");
        int choice = intInput();
        switch (choice) {
            case 1:
                guestMenu();
                break;
            case 2:
                laneManagementMenu();
                break;
        }
    }
    public void guestMenu() {
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
    public void laneManagementMenu() {
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
                    for (ShootingLane lane : ShootingLaneControllerSingleton.laneList) {
                        System.out.println(lane);
                        break;
                    }
                case 2:
                    for (ShootingLane lane : ShootingLaneControllerSingleton.inUse) {
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
    public void guestInput() {
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

    private void autoLaneMenu(PlaySession playSession) {
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

    public void manualLaneAssign(PlaySession playSession) {
        System.out.println("~~~~~~~~~~");
        System.out.println("Enter lane id: ");
        int id = intInput();
        myLanes.getLane(id, playSession);
        autoStartMenu(playSession);
    }

    public void autoStartMenu(PlaySession playSession) {
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
    public void activeLaneMenu() {
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
