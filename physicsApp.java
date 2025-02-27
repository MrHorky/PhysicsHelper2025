import java.util.Scanner;

public class physicsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] menu = {"Calculators", "Table Generator", "Practice Problems", "Exit"};
            int[] numbers = {1, 2, 3, 4};

            System.out.println("Choose equation to solve: ");

            for (int i = 0; i < numbers.length; i++) {
                System.out.printf("\t %d. %s\n", numbers[i], menu[i]);
            }

            int option = scanner.nextInt();

            while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5) {
                System.out.println("Invalid option");
                System.out.println("Choose an option from the list: ");

                for (int i = 0; i < numbers.length; i++) {
                    System.out.printf("\t %d. %s\n", numbers[i], menu[i]);
                }
            
                option = scanner.nextInt();
            }

            switch (option) {
                case 1 -> calculators(scanner);
                case 2 -> tableGenerator(scanner);
                case 3 -> practiceProblems(scanner);
                case 4 -> {
                }
            }
        }
    }

    public static void calculators(Scanner scanner) {
        String[] options = {"Position", "Velocity", "Acceleration", "Angular Speed", "Angle of Movement"};
        int[] nums = {1, 2, 3, 4, 5};
        
        System.out.println("Choose equation to solve: ");

        for (int i = 0; i < nums.length; i++) {
            System.out.printf("\t %d. %s\n", nums[i], options[i]);
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
            System.out.println("Invalid option");
            System.out.println("Choose equation to solve: ");

            for (int i = 0; i < nums.length; i++) {
                System.out.printf("\t %d. %s\n", nums[i], options[i]);
            }
        
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                position(scanner);
                break;
            case 2:
                velocity(scanner);
                break;
            case 3:
                acceleration(scanner);
                break;
            case 4:
                angularSpeed(scanner);
                break;
            case 5:
                angleOfMov(scanner);
                break;
            default:
                break;
        }
    }

    public static void tableGenerator(Scanner scanner) {
        System.out.println("Enter seconds to simulate, initial acceleration, initial veloocity, initial position: ");
        double seconds = scanner.nextDouble();
        double acceleration = scanner.nextDouble();
        double velocity = scanner.nextDouble();
        double position = scanner.nextDouble();


    }

    public static void practiceProblems(Scanner scanner) {
        System.out.println("HI");
    }

    public static void position(Scanner scanner) {
        System.out.println("Enter initial position, velocity, time and acceleration: ");
        double initPos = scanner.nextDouble();
        double initVelo = scanner.nextDouble();
        double time = scanner.nextDouble();
        double acc = scanner.nextDouble();

        double currPos = (initPos + initVelo) * time + ((1.0 / 2.0) * acc * Math.pow(time, 2));
        System.out.printf("The current position is: %.2f\n", currPos); 
    }

    public static void velocity(Scanner scanner) {
        System.out.println("\nEnter final position, initial position, final time and initial time: ");
        double finalPos = scanner.nextDouble();
        double initPos = scanner.nextDouble();
        double finalTime = scanner.nextDouble();
        double initTime = scanner.nextDouble();

        double finalVelo = (finalPos - initPos) / (finalTime - initTime);
        System.out.printf("The final velocity is: %.2f\n", finalVelo);
    }

    public static void acceleration(Scanner scanner) {
        System.out.println("Enter final velocity, initial velocity, final time and initial time: ");
        double finalVelo = scanner.nextDouble();
        double initVelo = scanner.nextDouble();
        double finalTime = scanner.nextDouble();
        double initTime = scanner.nextDouble();

        double finalAcc = (finalVelo - initVelo) / (finalTime - initTime);
        System.out.printf("The acceleration is: %.2f\n", finalAcc);
    }

    public static void angularSpeed(Scanner scanner) {
        System.out.println("Enter initial velocity, acceleration and time: ");
        double initVelo = scanner.nextDouble();
        double acc = scanner.nextDouble();
        double time = scanner.nextDouble();

        double angularSpd = initVelo + (acc * time);
        System.out.printf("The angular speed is: %.2f\n", angularSpd);
    }

    public static void angleOfMov(Scanner scanner) {
        System.out.println("Enter initial position, initial velocity, time and acceleration: ");
        double initPos = scanner.nextDouble();
        double initVelo = scanner.nextDouble();
        double time = scanner.nextDouble();
        double acc = scanner.nextDouble();

        double angleOfMovement = initPos + (initVelo * time) + ((1.0 / 2.0) * acc * Math.pow(time, 2));
        System.out.printf("The angle of movement is: %.2f\n", angleOfMovement);
    }
}