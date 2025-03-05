import java.util.Scanner;
public class PhysicsCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What option would you like to choose? Enter the number.");
        System.out.println("1. Calculators");
        System.out.println("2. Tabler");
        System.out.println("3. Practice Problems");
        System.out.println("4. Exit");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                calculators(in);
                break;
            case 2:
                tabler(in);
                break;
            case 3:
                practiceProblems(in);
                break;
            case 4:
                break;
            default:
                System.out.println("Enter a valid option.");
                break;
        }
    }
    
    public static void calculators(Scanner in) {  
        while (true) {
            System.out.println("Choose a calculator:");
            System.out.println("1. Position: x = xâ‚€ + vâ‚€t + (Â½)atÂ²");
            System.out.println("2. Velocity: v = Î”x / Î”t");
            System.out.println("3. Acceleration: a = Î”v / Î”t");
            System.out.println("4. Absolute Fluid Pressure: P = P0 + ρgh");
            System.out.println("5. Bernoulli’s equation: P1 + ρgy1 + (½)ρv12 = P2 + ρgy2 + (½)ρv22. Solves for P2.");
            System.out.println("6. Exit");
            
            int option = in.nextInt();
            String wordOption = in.nextLine();

            //option 1
            if ((option == 1) || (wordOption.toLowerCase().contains("position"))) {
                System.out.println("Enter initial position: ");
                double initialPosition = in.nextDouble();
                System.out.println("Enter initial initial velocity: ");
                double initialVelocity = in.nextDouble();
                System.out.println("Enter time ");
                double time = in.nextDouble();
                System.out.println("Enter acceleration ");
                double acceleration = in.nextDouble();
                System.out.println("Position = " + ((initialPosition + (initialVelocity*time) + (0.5*acceleration*Math.pow(time, 2)))));
            //option 2
             } else if ((option == 2) || (wordOption.toLowerCase().contains("velocity"))) {
                System.out.println(" Enter Displacement ");
                double displacement = in.nextDouble();
                System.out.println(" Enter change in time");
                double changeInTime = in.nextDouble();
                System.out.println("Velocity = " + (displacement / changeInTime));
            //option 3    
            } else if ((option == 3) || (wordOption.toLowerCase().contains("acceleration"))) { 
                System.out.println("Enter change in velocity");
                double CIV = in.nextDouble();
                System.out.println("Enter change in time");
                double CIT = in.nextDouble();
                System.out.println("Acceleration = " + (CIV / CIT));
            //option 4
            } else if ((option == 4) || (wordOption.toLowerCase().contains("fluid"))) {
                System.out.println("Enter initial pressure P0:");
                double initialPressure = in.nextDouble();
                System.out.println("Enter density ρ:");
                double density = in.nextDouble();
                System.out.println("Enter height h:");
                double height = in.nextDouble();
                System.out.println("The Absolute Fluid Pressure P is " + (initialPressure + (density*9.81*height)));
            //option 5
            } else if ((option == 5) || (wordOption.toLowerCase().contains("bernoulli"))) {
                System.out.println("Enter pressure 1 P1:");
                double p1 = in.nextDouble();
                System.out.println("Enter density ρ:");
                double density = in.nextDouble();
                System.out.println("Enter y1:");
                double y1 = in.nextDouble();
                System.out.println("Enter velocity 1:");
                double v1 = in.nextDouble();
                System.out.println("Enter y2:");
                double y2 = in.nextDouble(); 
                System.out.println("Enter velocity 2:");
                double v2 = in.nextDouble();
                System.out.println("The Pressure 2 P2 is " + (p1 + (density*9.81*y1) + (0.5*density*Math.pow(v1, 2)) - (density*9.81*y2) - (0.5*density*Math.pow(v2, 2))));
            //exit option
            } else if ((option == 6) || (wordOption.toLowerCase().contains("exit"))) {
                System.out.println("Exiting...");
                break;
            }
            else {System.out.println("Invalid option. Please try again.");}
        }
    }
    
    public static void tabler(Scanner in) {
        System.out.println("Which tabler would you like to use?");
        System.out.println("1. Accceleration Tabler");
        System.out.println("2. Angle Tabler");
        System.out.println("3. Exit");
        int tableChoice = in.nextInt();
        switch (tableChoice) {
            case 1:
                System.out.print("Enter the number of seconds to simulate: ");
                double seconds = in.nextDouble();
                System.out.print("Enter initial acceleration (m/sec^2): ");
                double initialAccelerationTable = in.nextDouble();
                System.out.print("Enter initial velocity (m/sec): ");
                double initialVelocityTable = in.nextDouble();
                System.out.print("Enter initial position (m): ");
                double initialPositionTable = in.nextDouble();
                System.out.print("t(s)    |v(m/s) |x(m)\n");
                System.out.print("–-------+-------+----\n");
                for (double i = 0; i <= seconds; i++) {
                    double positionTable = ((initialPositionTable + (initialVelocityTable*i) + (0.5*initialAccelerationTable*Math.pow(i, 2))));
                    double velocityCurrent = 0;
                    if (i == 0) {velocityCurrent = 0;}
                    else if (i > 0) {velocityCurrent = positionTable/i;}
                    else System.out.println("how");
                    System.out.printf("%.2f\t|%.2f\t|%.2f\n", i, velocityCurrent, positionTable);
                }
                break;
            case 2:
                System.out.print("Enter a number of seconds to simulate: ");
                seconds = in.nextDouble();
                System.out.print("Enter the initial angle θ: ");
                double initialAngle = in.nextDouble();
                System.out.print("Enter initial angular speed (m/s): ");
                double angularSpeed = in.nextDouble();
                System.out.print("Enter angular acceleration (m/sec^2): ");
                double angularAcceleration = in.nextDouble();
                System.out.print("t(s)    |⍵(m/s) |θ(deg.)\n");
                System.out.print("–-------+-------+-------\n");
                for (double i = 0; i <= seconds; i++) {
                    double angleTable = ((initialAngle + (angularSpeed*i) + (0.5*angularAcceleration*Math.pow(i, 2))));
                    double velocityCurrent = 0;
                    if (i == 0) {velocityCurrent = 0;}
                    else if (i > 0) {velocityCurrent = angleTable/i;}
                    else System.out.println("how");
                    System.out.printf("%.2f\t|%.2f\t|%.2f\n", i, velocityCurrent, angleTable);
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Enter a valid option.");
                break;
        }
    }    
    
    public static void practiceProblems(Scanner in) {

    }
}

