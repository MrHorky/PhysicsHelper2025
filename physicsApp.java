import java.util.Random;
import java.util.Scanner;

public class physicsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] menu = {"Calculators", "Table Generator", "Practice Problems", "Exit"};
            int[] numbers = {1, 2, 3, 4};

            System.out.println("Choose equation to solve: ");

            for (int i = 0; i < numbers.length; i++) {
                System.out.printf("\t%d. %s\n", numbers[i], menu[i]);
            }

            int option = scanner.nextInt();

            while (option != 1 && option != 2 && option != 3 && option != 4) {
                System.out.println("Invalid option");
                System.out.println("Choose an option from the list: ");

                for (int i = 0; i < numbers.length; i++) {
                    System.out.printf("\t%d. %s\n", numbers[i], menu[i]);
                }
            
                option = scanner.nextInt();
            }

            switch (option) {
                case 1 -> calculators(scanner);
                case 2 -> tableGenerator(scanner);
                case 3 -> practiceProblems(scanner);
                case 4 -> {
                    return;
                }
            }
        }
    }

    public static void calculators(Scanner scanner) {
        String[] options = {"Position", "Velocity", "Acceleration", "Angular Speed", "Angle of Movement"};
        int[] nums = {1, 2, 3, 4, 5};
        
        System.out.println("Choose equation to solve: ");

        for (int i = 0; i < nums.length; i++) {
            System.out.printf("\t%d. %s\n", nums[i], options[i]);
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
            System.out.println("Invalid option");
            System.out.println("Choose equation to solve: ");

            for (int i = 0; i < nums.length; i++) {
                System.out.printf("\t%d. %s\n", nums[i], options[i]);
            }
        
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1 -> position(scanner);
            case 2 -> velocity(scanner);
            case 3 -> acceleration(scanner);
            case 4 -> angularSpeed(scanner);
            case 5 -> angleOfMov(scanner);
            default -> {
            }
        }
    }

    public static void tableGenerator(Scanner scanner) {
        String[] options = {"Regular Table", "Projectile Motion"};
        int[] optionNums = {1, 2};

        System.out.println("Choose table type to generate: ");

        for (int i = 0; i < optionNums.length; i++) {
            System.out.printf("\t%d. %s\n", optionNums[i], options[i]);
        }

        int tableChoice = scanner.nextInt();
        scanner.nextLine();

        while (tableChoice != 1 && tableChoice != 2) {
            System.out.println("Invalid option");
            System.out.println("Choose table to type generator: ");

            for (int i = 0; i < optionNums.length; i++) {
                System.out.printf("\t%d. %s\n", optionNums[i], options[i]);
            }
        
            tableChoice = scanner.nextInt();
        }

        switch (tableChoice) {
            case 1 -> {
                System.out.println("Enter seconds to simulate, initial acceleration, initial veloocity, initial position: ");
                double seconds = scanner.nextDouble();
                double acceleration = scanner.nextDouble();
                double velocity = scanner.nextDouble();
                double position = scanner.nextDouble();

                System.out.println("Time (s) | Velocity (m/s) | Position (x) ");
                System.out.println("---------+----------------+-------------");

                for (int i = 0; i <= seconds; i++) {
                    double currentVelo = velocity + (acceleration * i);
                    double currentPos = position + (velocity * i) + (0.5 * acceleration * i * i);

                    System.out.printf("%-9d| %-15.2f| %-12.2f%n", i, currentVelo, currentPos);
                }
            }
            case 2 -> {
                System.out.println("Enter seconds to simulate, initial position, initial velocity for x values: ");
                double time = scanner.nextDouble();
                double initPosX = scanner.nextDouble();
                double initVeloX = scanner.nextDouble();

                System.out.println("Enter initial position, initial velocity for y values: ");
                double initPosY = scanner.nextDouble();
                double initVeloY = scanner.nextDouble();

                final double GRAVITY = -9.18;

                System.out.println("Time (s) | Position (x) | Position (y) ");
                System.out.println("---------+--------------+--------------");

                for (int i = 0; i <= time; i++) {
                    double motionX = (initPosX + initVeloX) * i;
                    double motionY = ((initPosY + initVeloY) * i) - ((.5) * GRAVITY *(Math.pow(i, 2)));

                    System.out.printf("%-9d| %-12.2f| %-12.2f%n", i, motionX, motionY);
                }
            }
            default -> {
            }
        }
    }

    public static void practiceProblems(Scanner scanner) {
        Random rand = new Random();
        String[] problemTypes = {"Position", "Velocity", "Acceleration"};
        int[] nums = {1, 2, 3};
        
        System.out.println("What type of problem would you like to solve?: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("\t %d. %s\n", nums[i], problemTypes[i]);
        }
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        while (choice > 3 && choice != 0) {
            System.out.println("Invalid option. Choose again:");
            for (int i = 0; i < nums.length; i++) {
                System.out.printf("\t %d. %s\n", nums[i], problemTypes[i]);
            }
            choice = scanner.nextInt();
            scanner.nextLine();
        }
        
        double userAnswer, correctAnswer;
        switch (choice) {
            case 1 -> {
                double initPos = rand.nextDouble() * 50;
                double initVelo = rand.nextDouble() * 20;
                double t = rand.nextDouble() * 10 + 1;
                double a = rand.nextDouble() * 10;
        
                int unknown = rand.nextInt(4);
                switch (unknown) {
                    case 0 -> {
                        correctAnswer = initPos + (initVelo * t) + (0.5 * a * t * t);
                        System.out.printf("Given x₀ = %.2f, v₀ = %.2f, t = %.2f, a = %.2f, calculate x: ", initPos, initVelo, t, a);
                    }
                    case 1 -> {
                        correctAnswer = (initVelo * t) + (0.5 * a * t * t);
                        System.out.printf("Given x = ?, v₀ = %.2f, t = %.2f, a = %.2f, calculate x₀: ", initVelo, t, a);
                    }
                    case 2 -> {
                        correctAnswer = (initPos - (0.5 * a * t * t)) / t;
                        System.out.printf("Given x = %.2f, x₀ = %.2f, t = %.2f, a = %.2f, calculate v₀: ", initPos, initPos, t, a);
                    }
                    default -> {
                        correctAnswer = (initPos - (initVelo * t)) / (0.5 * t * t);
                        System.out.printf("Given x = %.2f, x₀ = %.2f, v₀ = %.2f, t = %.2f, calculate a: ", initPos, initPos, initVelo, t);
                    }
                }
            }
            case 2 -> {
                double deltaX = rand.nextDouble() * 50;
                double deltaT = rand.nextDouble() * 10 + 1;
        
                if (rand.nextBoolean()) {
                    correctAnswer = deltaX / deltaT;
                    System.out.printf("Given Δx = %.2f and Δt = %.2f, calculate v: ", deltaX, deltaT);
                } 
                else {
                    correctAnswer = deltaT * (deltaX / deltaT);
                    System.out.printf("Given v = %.2f and Δt = %.2f, calculate Δx: ", deltaX / deltaT, deltaT);
                }
            }
            case 3 -> {
                double deltaV = rand.nextDouble() * 20;
                double deltaT = rand.nextDouble() * 10 + 1;
                if (rand.nextBoolean()) {
                    correctAnswer = deltaV / deltaT;
                    System.out.printf("Given Δv = %.2f and Δt = %.2f, calculate a: ", deltaV, deltaT);
                } 
                else {
                    correctAnswer = deltaT * (deltaV / deltaT);
                    System.out.printf("Given a = %.2f and Δt = %.2f, calculate Δv: ", deltaV / deltaT, deltaT);
                }
            }
            default -> {
                return;
            }
        }
        
        userAnswer = scanner.nextDouble();
        if (Math.abs(userAnswer - correctAnswer) < 0.01) {
            System.out.println("Correct!");
        } 
        else {
            System.out.printf("Incorrect! The correct answer is %.2f\n", correctAnswer);
        }    
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