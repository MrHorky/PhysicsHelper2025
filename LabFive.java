import java.util.Scanner;
public class LabFive {
    public static void main(String[] args) {
        System.out.println("Meow Meow Meow Meow Meow Meow Meow Meow Meow Meow");
        Scanner scan = new Scanner(System.in);
        boolean meow = true;
        while (meow){
        System.out.println("1. Calculators\n2. Table Generators\n3. Practice Problems\n4. Exit\n");
        int option = scan.nextInt();
        switch(option) {
            case 1:
                calculator(scan);
                break;
            case 2:
                tabler(scan);
                break;
            case 3:
                System.out.println("Practice Problems");
                break;
            default:
                meow = false;
                break;
        }
    } 
    }


    public static void calculator(Scanner scan) {
        //Scanner scan = new Scanner(System.in);
        String flag = "Y";
        int meow = 0;
        String[] options = {"1. Position: \n", "2. Velocity: \n", "3. Acceleration: \n", "4: Projectile Motion X-Direction: \n", "5. Projectile Motion Y-Direction: \n"};
        while (flag.contains("Y")) {
            for (int i = 0; i <= options.length-1; i++) {
                System.out.print(options[i]);
            }
            //System.out.println("Enter a number to select the equation to solve:\n" + "1. Position\n" + "2. Velocity\n" +"3. Acceleration\n"+"4.Projectile motion x-direction\n" + "5. Projectile motion y-direction");
            int check = scan.nextInt();
            if (check == 1) {
                System.out.println("Enter an initial value: ");
                double x0 = scan.nextDouble();
                System.out.println("Enter initial velocity: ");
                double v0 = scan.nextDouble();
                System.out.println("Enter a time: ");
                double t = scan.nextDouble();
                System.out.println("Enter an acceleration: ");
                double a = scan.nextDouble();
                double position = x0 + (v0*t) + (.5*a*Math.pow(t, 2));
                System.out.println("The current position is: " + position);
            } else if (check == 2) {
                System.out.println("Enter a x1 position: ");
                double x1 = scan.nextDouble();
                System.out.println("Enter the x2 position: ");
                double x2 = scan.nextDouble();
                System.out.println("Enter start time: ");
                double t1 = scan.nextDouble();
                System.out.println("Enter an end time: ");
                double t2 = scan.nextDouble();
                double changeTime = t2-t1;
                double changePosition = x2-x1;
                double velocity = changePosition/changeTime;
                System.out.println("The velocity is: " + velocity);
            } else if (check == 3) {
                System.out.println("Enter an initial time: ");
                double t1 = scan.nextDouble();
                System.out.println("Enter the end time: ");
                double t2 = scan.nextDouble();
                System.out.println("Enter start velocity: ");
                double v1 = scan.nextDouble();
                System.out.println("Enter an end velocity: ");
                double v2 = scan.nextDouble();
                double changeVel = v2-v1;
                double changeTime = t2-t1;
                double acc = changeVel/changeTime;
                System.out.println("The velocity is: " + acc);
            } else if (check == 4) {
                System.out.println("Enter a initial x value: ");
                double x0 = scan.nextDouble();
                System.out.println("Enter initival x velocity value: ");
                double v0 = scan.nextDouble();
                System.out.println("Enter a time: ");
                double t = scan.nextDouble();
                double answer = x0 + (v0*t);
                System.out.println("The x-position is: " + answer);
            } else if (check == 5) {
                System.out.println("Enter intial y value: ");
                double y0 = scan.nextDouble();
                System.out.println("Enter intial y velocity value: ");
                double v0 = scan.nextDouble();
                System.out.println("Enter a time: ");
                double t = scan.nextDouble();
                double g = 9.8;
                double solution = y0 + (v0*t) - (.5*g*Math.pow(t,2));
                System.out.println("The final y value is: " + solution);
               
            } else {
                System.out.println("Unknown Value Please: Please try again");
            }
            meow++;
            System.out.println("Would you like to solve another equation?: ");
            flag = scan.next();
            if (meow == 1) {
            System.out.println("Thank you for solving an equation!");
            } else {
                System.out.println("Thank you for solving multiple equations!");
            }
        }
    }
    public static void tabler(Scanner scan) {
        System.out.println("Enter a number of seconds to simulate: ");
        double t = scan.nextDouble();
        System.out.println("Enter initial acceleration in m/s^2: ");
        double a0 = scan.nextDouble();
        System.out.println("Enter initial x velocity in m/s: ");
        double vx0 = scan.nextDouble();
        System.out.println("Enter initial x position in m: ");
        double x0 = scan.nextDouble();
        System.out.println("Enter initial y position in m: ");
        double y0 = scan.nextDouble();
        System.out.println("Enter initial y velocity in m/s: ");
        double vy0 = scan.nextDouble();
        System.out.println("t(s)\t|v(m/s)\t|x(m)\t|y(m)");
        System.out.println("--------+-------+-----");
        for (int i = 0;i<t+1;i++){
            double y = y0 + vy0*i-.5*9.8*Math.pow(i, 2);
            if (y <= 0){
                y = 0;
            }
            System.out.println(i + "\t|"+ vx0 + "\t|" + x0 + "\t" + y);
            vx0 = vx0 + a0;
            x0 = x0 + vx0;
            
        }
    }
 }
 