import java.util.Scanner;
public class lab4 {
   public static void main(String[] args){
       Scanner in = new Scanner(System.in);


       while (true) {
           System.out.println("Choose an option:");
           System.out.println("1. Position: x = xÃ¢â€šâ‚¬ + vÃ¢â€šâ‚¬t + (Ã‚Â½)atÃ‚Â²");
           System.out.println("2. Velocity: v = ÃŽâ€x / ÃŽâ€t");
           System.out.println("3. Acceleration: a = ÃŽâ€v / ÃŽâ€t");
           System.out.println("4. Absolute Fluid Pressure: P = P0 + Ïgh");
           System.out.println("5. Bernoulliâ€™s equation: P1 + Ïgy1 + (Â½)Ïv12 = P2 + Ïgy2 + (Â½)Ïv22. Solves for P2.");
           System.out.println("6. Exit");
           System.out.print("Enter your choice: ");


           int option = in.nextInt();
           String wordOption = in.nextLine();


           //option 1


           if ((option == 1) || (wordOption.toLowerCase().contains("position"))) {
               System.out.println("Alright for option 1");
               System.out.println("Enter initial position: ");
               double initialPosition = in.nextDouble();


               System.out.println("Enter initial initial velocity: ");
               double initialVelocity = in.nextDouble();


               System.out.println("Enter Time ");
               double time = in.nextDouble();


               System.out.println(" Enter Acceleration ");
               double acceleration = in.nextDouble();
              
               System.out.println("position " + ((initialPosition + (initialVelocity*time) + (0.5*acceleration*Math.pow(time, 2)))));


               //option 2
          
            } else if ((option == 2) || (wordOption.toLowerCase().contains("velocity"))) {
               System.out.println(" Enter Displacement ");
               double displacement = in.nextDouble();


               System.out.println(" Enter change in time");
               double changeInTime = in.nextDouble();


               System.out.println("The Velocity " + (displacement / changeInTime));


               //option 3
              
           } else if ((option == 3) || (wordOption.toLowerCase().contains("acceleration"))) {
               System.out.println("Executing Option 3");
              
               System.out.println("Enter change in velocity");
               double CIV = in.nextDouble();


               System.out.println("change in time");
               double CIT = in.nextDouble();


               System.out.println("The Acceleration " + (CIV / CIT));


               //option 4


           } else if ((option == 4) || (wordOption.toLowerCase().contains("fluid"))) {
               System.out.println("Enter initial pressure P0:");
               double initialPressure = in.nextDouble();
               System.out.println("Enter density Ï:");
               double density = in.nextDouble();
               System.out.println("Enter height h:");
               double height = in.nextDouble();
               System.out.println("The Absolute Fluid Pressure P is " + (initialPressure + (density*9.81*height)));


           } else if ((option == 5) || (wordOption.toLowerCase().contains("bernoulli"))) {
               System.out.println("Enter pressure 1 P1:");
               double p1 = in.nextDouble();
               System.out.println("Enter density Ï:");
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


           } else if ((option == 6) || (wordOption.toLowerCase().contains("exit"))) {
               System.out.println("Exiting...");
               break;
           }
           else {
               System.out.println("Invalid option. Please try again.");
           }
       }
       in.close();
   }
}
