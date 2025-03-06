import java.util.*;

public class PhysicsCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to your Physics Helper!");
        System.out.println();
        System.out.print("1. Calculator\n2. Table Generator\n3. Practice Problems\n4. Exit\n");
        System.out.println();
        System.out.print("Out of the options above which would you like to explore?: ");
        int user = in.nextInt();

        switch(user){
            case 1: calculator(); break;
            case 2: tabler(); break;
            case 3: practice();
            default: System.out.println("Please enter a valid input");
        }
        in.close();
    }
    public static void calculator(){
        Scanner in = new Scanner(System.in);
        boolean run = true;

        while (run == true){
            System.out.println("Welcome to your physics calculator!");
            System.out.print("1. Position\n2. Velocity\n3. Acceleration\n4. Fluid Pressure\n");
            System.out.print("Which equation would you like to find: ");
            int user = in.nextInt();

            if (user == 1){
                System.out.print("Enter initial position here: ");
                double position = in.nextInt();
                System.out.print("Enter initial velocity here (m/s): ");
                double velo = in.nextInt();
                System.out.print("Enter time elapsed here (seconds): ");
                double time = in.nextInt();
                System.out.print("Enter acceleration here (m/s)^2: ");
                double acceleration = in.nextInt();

                double answer = position + (velo * time) + (.5 * acceleration) * Math.pow(time, 2);
                System.out.printf("The position is %.2f\n", answer);

            }
            else if (user == 2){
                System.out.print("Enter initial position here: ");
                double inPos = in.nextInt();
                System.out.print("Enter final position here: ");
                double finPos = in.nextInt();
                System.out.print("Enter initial time here (seconds): ");
                double inTime = in.nextInt();
                System.out.print("Enter final time here (seconds): ");
                double finTime = in.nextInt();

                double position = finPos - inPos;
                double time = finTime - inTime;

                double answer = position/time;
                System.out.printf("The velocity is %.2f meters per second\n", answer);

            }
            else if (user == 3){
                System.out.print("Enter initial velocity here: ");
                double inVelo = in.nextInt();
                System.out.print("Enter final velocity here: ");
                double finVelo = in.nextInt();
                System.out.print("Enter initial time here (seconds): ");
                double inTime = in.nextInt();
                System.out.print("Enter final time here (seconds): ");
                double finTime = in.nextInt();

                double velocity = finVelo - inVelo;
                double time = finTime - inTime;

                double answer = velocity/time;
                System.out.printf("The acceleration is %.2f meters per second squared\n", answer);

            }
            else if (user == 4){
                System.out.println("Fluid pressure calculator:\n1. Absolute pressure\n2. Bernoulli's equation");
                System.out.print("Which formula would you like to use?: ");
                int choice = in.nextInt();

                if (choice == 1){
                    System.out.print("Enter gauge pressure here: ");
                    double pressure = in.nextDouble();
                    System.out.print("Enter atmospheric pressure here: ");
                    double atmosphere = in.nextDouble();

                    double answer = pressure + atmosphere;
                    System.out.printf("The absolute pressure is %.2f PSI\n", answer);
                }
                else if (choice == 2){
                    System.out.print("Enter the fluid density here: ");
                    double dense = in.nextDouble();
                    System.out.print("Enter the acceleration due to gravity here: ");
                    double accel = in.nextDouble();
                    System.out.print("Enter the velocity at the first point here: ");
                    double velo1 = in.nextDouble();                   
                    System.out.print("Enter the height at the first point here: ");
                    double height1 = in.nextDouble();
                    System.out.print("Enter the pressure at the second point here: ");
                    double pressure2 = in.nextDouble();                   
                    System.out.print("Enter the velocity at the second point here: ");
                    double velo2 = in.nextDouble();                   
                    System.out.print("Enter the height at the second point here: ");
                    double height2 = in.nextDouble();

                    double leftSide = ((.5) * dense * Math.pow(velo1, 2)) + (dense * accel * height1);
                    double rightSide = pressure2 + ((.5) * dense * Math.pow(velo2, 2)) + (dense * accel * height2);
                    double answer = rightSide - leftSide;

                    System.out.printf("The pressure at point 1 is %.2f PSI\n", answer);

                }
            }
            else {run = false;}

            System.out.print("Would you like to continue? (y/n): ");
            String cont = in.next();
            if (cont.toLowerCase().compareTo("n") == 0){
                run = false;
            System.out.println("Thank you for using our Physics Calculator!");
            break;
            }
        }
        in.close();
    }

    public static void tabler(){
        Scanner in = new Scanner(System.in);
        System.out.println("You have chosen the table generator");
        System.out.println("1. Time/Velocity/Time table\n2. Air pressure");
        System.out.print("\nWhich table would you like generate?: ");
        int user = in.nextInt();

        switch(user){
            case 1: {
                System.out.print("Enter time elapsed here: ");
        double time = in.nextInt();
        System.out.print("Enter initial velocity here: ");
        double vi = in.nextInt();
        System.out.print("Enter initial position here: ");
        double xi = in.nextInt();
        System.out.print("Enter acceleration here: ");
        double accel = in.nextInt();
        System.out.println("Time(s) | Velocity()m/s | Position(m)");
        System.out.println("--------+---------------+-----------------------");

        for (int i = 0; i < time; i++){
            double vf = vi + accel * i;
            double xf = xi + vi * i + (0.5) * accel * Math.pow(i, 2);

            System.out.printf("%d\t|\t%.2f\t|\t%.2f \n", i, vf, xf);
        }
            }

            case 2:{
                System.out.print("Enter the density of the air here: ");
                double density = in.nextDouble();
                System.out.print("Enter the acceleration due to gravity here: ");
                double accel = in.nextDouble();
                System.out.print("Enter the change in vertical height here (thousands): ");
                double height = in.nextDouble();
                System.out.println("Height(ft)\t|\tAir Pressure");
                System.out.println("------------+----------------------------------------");
                for (int i = 0; i < height; i++){
                    double pressure = density * accel * (i * 1000);
                    System.out.printf("%d\t\t|\t%.2f\t|\n", i * 1000, pressure);
                }
            }
        }

        
        in.close();
    }

    public static void practice(){
        Scanner in = new Scanner(System.in);
        System.out.print("1. Position\n2. Velocity\n3. Acceleration\n\n");
        System.out.print("Which kind of practice problem would you like?: ");
        int user = in.nextInt();

        switch(user){
            case 1: {
                break;
            }
            case 2: {
                Random random = new Random();
                if (random.nextInt(1, 3) == 1){
                    double position = random.nextDouble(0.0, 15.0);
                    double time = random.nextDouble(0.0, 15.0);

                    System.out.printf("Given the position is %.1f and the time elapsed is %.1f, calculate the velocity: ", position, time);
                    double answer = in.nextDouble();
                    if (answer >= position/time - 0.01 && answer <= position/time + 0.01){
                        System.out.println("Correct!!");
                    }else{System.out.println("Sorry that's incorrect.");}
                    System.out.println(position/time);

                }
                else if (random.nextInt(1,3) == 2){
                    double velocity = random.nextDouble(0.0, 15.0);
                    double time = random.nextDouble(0.0, 15.0);

                    System.out.printf("Given the velocity is %.1f and the time elapsed is %.1f, calculate the position: ", velocity, time);
                    double answer = in.nextDouble();
                    if (answer >= velocity * time - 0.01 && answer <= velocity * time + 0.01){
                        System.out.println("Correct!!"); 
                    }else{System.out.println("Sorry that's incorrect.");}
                    System.out.println(velocity * time);
                }
                else {
                    double velocity = random.nextDouble(0.0, 15.0);
                    double position = random.nextDouble(0.0, 15.0);

                    System.out.printf("Given the velocity is %.1f and the position is %.1f, calculate the time elapsed: ", velocity, position);
                    double answer = in.nextDouble();
                    if (answer >= position/velocity - 0.01 && answer <= position/velocity + 0.01){
                        System.out.println("Correct!!"); 
                    }else{System.out.println("Sorry that's incorrect.");}
                    System.out.println(position/velocity);

                }break;
            }
            default:{System.out.println("Please enter a valid input");}
        }
    }
}
