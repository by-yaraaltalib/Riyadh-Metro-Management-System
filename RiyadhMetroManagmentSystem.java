package com.mycompany.riyadhmetromanagmentsystem;

import java.util.Scanner;

public class RiyadhMetroManagmentSystem {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // ---------------- Subsystems ----------------
        TicketingSystem ticketing = new TicketingSystem();
        MaintenanceSystem maintenance = new MaintenanceSystem();
        MetroNetwork metro = new MetroNetwork();
        StationDirectory directory = new StationDirectory();

        // --------------- Main Loop ----------------
        while (true) {
            printMainScreen();
            int selection = readInt();
            switch (selection) {
                case 1:
                    ticketingMenu(ticketing);
                    break;
                case 2:
                    maintenanceMenu(maintenance);
                    break;
                case 3:
                    metroMenu(metro);
                    break;
                case 4:
                    directoryMenu(directory);
                    break;
                case 5:
                    integrationMenu(ticketing, metro, directory, maintenance);
                    break;
                case 6:
                    System.out.println("Exiting the system...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // --------------- Main Screen ----------------
    private static void printMainScreen() {
        System.out.println("\n=====================================");
        System.out.println(" Riyadh Metro Management System");
        System.out.println("=====================================");
        System.out.println("1. Ticketing & Passenger Processing");
        System.out.println("2. Maintenance Management System");
        System.out.println("3. Metro Lines & Station Network");
        System.out.println("4. Station Directory & Search");
        System.out.println("5. Integration & Quick Reports");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    // ---------------- Ticketing Menu ----------------
    private static void ticketingMenu(TicketingSystem ticketing) {
        while (true) {
            System.out.println("\n--- Ticketing & Passenger Processing ---");
            System.out.println("1. Add new passenger to a machine");
            System.out.println("2. Serve next passenger at a machine");
            System.out.println("3. Who is next (peek) for a machine");
            System.out.println("4. Display all waiting passengers");
            System.out.println("5. Display waiting counts per machine");
            System.out.println("6. Average waiting time (2 min per passenger)");
            System.out.println("7. Back to main menu");
            System.out.print("Choose: ");
            int c = readInt();
            switch (c) {
                // fill methods
                case 7:
                    return;
                default:
                    System.out.println("Option not implemented yet.");
            }
        }
    }

    // ---------------- Maintenance Menu ----------------
    private static void maintenanceMenu(MaintenanceSystem maintenance) {
        while (true) {
            System.out.println("\n--- Maintenance Management ---");
            System.out.println("1. Submit new maintenance request");
            System.out.println("2. Assign work to next available team");
            System.out.println("3. View most critical pending request");
            System.out.println("4. Display all pending maintenance (sorted)");
            System.out.println("5. Update priority of existing request");
            System.out.println("6. Back to main menu");System.out.print("Choose: ");
            int c = readInt();
            switch (c) {
                // fill methods
                case 6:
                    return;
                default:
                    System.out.println("Option not implemented yet.");
            }
        }
    }

    // ---------------- Metro Menu ----------------
    private static void metroMenu(MetroNetwork metro) {
        while (true) {
            System.out.println("\n--- Metro Lines & Station Network ---");
            System.out.println("Choose line: 1. Orange 2. Yellow 3. Green 4. Back");
            System.out.print("Line: ");
            int lineChoice = readInt();
            CircularLine line = null;
            String lineName = "";

            switch (lineChoice) {
                case 1:
                    line = metro.line1;
                    lineName = "Line 1 (Orange)";
                    break;
                case 2:
                    line = metro.line2;
                    lineName = "Line 2 (Yellow)";
                    break;
                case 3:
                    line = metro.line3;
                    lineName = "Line 3 (Green)";
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid line.");
                    continue;
            }

            while (true) {
                System.out.println("\n--- " + lineName + " ---");
                System.out.println("1. Add station at beginning");
                System.out.println("2. Add station at end");
                System.out.println("3. Insert station between two stations");
                System.out.println("4. Remove station");
                System.out.println("5. Find station");
                System.out.println("6. Display forward");
                System.out.println("7. Display backward");
                System.out.println("8. Count stations");
                System.out.println("9. Shortest route between two stations");
                System.out.println("10. Duration time between two stations");
                System.out.println("11. Back to lines selection");
                System.out.print("Choose: ");
                int opt = readInt();
                switch (opt) {
                    // fill methods
                    case 11:
                        break;
                    default:
                        System.out.println("Option not implemented yet.");
                }
                if (opt == 11) break;
            }
        }
    }

    // ---------------- Station Directory Menu ----------------
    private static void directoryMenu(StationDirectory directory) {
        while (true) {
            System.out.println("\n--- Station Directory & Search ---");
            System.out.println("1. Add new station to directory");
            System.out.println("2. Search station by ID");
            System.out.println("3. Find stations within ID range");
            System.out.println("4. Update station information");
            System.out.println("5. Remove station");
            System.out.println("6. Display all stations (sorted by ID)");
            System.out.println("7. Find min ID station");
            System.out.println("8. Find max ID station");
            System.out.println("9. Check if station ID exists");
            System.out.println("10. Back to main menu");
            System.out.print("Choose: ");
            int c = readInt();
            switch (c) {
                // fill methods
                case 10:
                    return;
                default:
                    System.out.println("Option not implemented yet.");
            }
        }
    }

    // ---------------- Integration Menu ----------------
    private static void integrationMenu(TicketingSystem ticketing, MetroNetwork metro,
                                        StationDirectory directory, MaintenanceSystem maintenance) {
        while (true) {
            System.out.println("\n--- Integration & Quick Reports ---");
            System.out.println("1. Show all lines forward");
            System.out.println("2. Ticketing summary (per machine + average wait)");
            System.out.println("3. Next maintenance job");
            System.out.println("4. List stations (inorder)");
            System.out.println("5. Back to main menu");
            System.out.print("Choose: ");
            int c = readInt();
            switch (c) {
                // fill methods
                case 5:
                    return;
                default:
                    System.out.println("Option not implemented yet.");
            }
        }
    }
}