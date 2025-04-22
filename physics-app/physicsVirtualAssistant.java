
import java.util.Scanner;

public class physicsVirtualAssistant {

    public static final Scanner scanner = new Scanner(System.in);

    public static String getGreeting() {
        return "Hello, let's talk.";
    }

    public static String getResponse(String statement) {
        String response = "";

        if (statement.contains("no") || statement.contains("No")) {
            response = "Why so negative?";
        } 
        else if (statement.contains("Elliot") || statement.contains("elliot")) {
            response = "Yes, Elliot is the ruler of the observable Universe and all Domains thereof.";
        }
        else if (statement.contains("Jason") || statement.contains("jason")) {
            response = "Jason should have added the keywords himself so that he would get something cool said about him. But he didn't!";
        }
        else if (statement.contains("Sun") || statement.contains("sun")) {
            response = "The sun is very hot.";
        }
        else if (statement.contains("mother") || statement.contains("father") || statement.contains("sister") || statement.contains("brother")) {
            response = "Tell me more about your family.";
        }
        else if (statement.contains("dog") || statement.contains("cat")) {
            response = "Tell me more about your pets.";
        }
        else if (statement.contains("Mr. Horky")) {
            response = "He sounds like a loser.";
        }
        else if (statement.contains("I like") || statement.contains("i like")) {
            int position = statement.toLowerCase().indexOf("i like") + 6;
            String likedThing = statement.substring(position).trim();
            response = "What do you like about " + likedThing + "?";
        }
        else if (statement.contains("I want") || statement.contains("i want")) {
            int position = statement.toLowerCase().indexOf("i want") + 6;
            String wantedThing = statement.substring(position).trim();
            response = "Would you be happy if you had " + wantedThing + "?";
        }
        else if (statement.contains("add") || statement.contains("plus") || statement.contains("+") || (statement.toLowerCase().contains("what is") && statement.contains("+"))) {
            int sum = add(statement);
            response = String.format("%d", sum);
        }
        else if (statement.contains("subtract") || statement.contains("minus") || statement.contains("-") || (statement.toLowerCase().contains("what is") && statement.contains("-"))) {
            int difference = subtract(statement);
            response = String.format("%d", difference);
        }
        else if (statement.contains("multiply") || statement.contains("times") || statement.contains("*") || (statement.toLowerCase().contains("what is") && statement.contains("*"))) {
            int product = multiply(statement);
            response = String.format("%d", product);
        }
        else if (statement.contains("divide") || statement.contains("/") || statement.contains("divided by") || (statement.toLowerCase().contains("what is") && statement.contains("/"))) {
            try {
                int quotient = divide(statement);
                response = String.format("%d", quotient);
            }
            catch (ArithmeticException ae) {
                response = "Error " + ae.getMessage();
            }
        }
        else if (statement.toLowerCase().contains("square root") || statement.toLowerCase().contains("sqrt")) {
            double result = squareRoot(statement);
            response = String.format("%.2f", result);
        }
        else if (statement.toLowerCase().contains("^") || statement.toLowerCase().contains("to the power of") || statement.toLowerCase().contains("raised to the")) {
            int result = exponentiate(statement);
            response = String.format("%d", result);
        }
        else if (statement.toLowerCase().contains("modulo") || statement.toLowerCase().contains("mod") || statement.contains("%")) {
            int result = modulo(statement);
            response = String.format("%d", result);
        }
        else if (statement.toLowerCase().contains("absolute value") || statement.toLowerCase().contains("abs") || statement.toLowerCase().contains("what is the absolute value of")) {
            int result = absoluteValue(statement);
            response = String.format("%d", result);
        }
        else if (statement.toLowerCase().contains("volume") && statement.toLowerCase().contains("sphere")) {
            double result = sphereVolume(statement);
            response = String.format("%.2f", result);
        }
        else if (statement.toLowerCase().contains("area") && statement.toLowerCase().contains("rectangle")) {
            int result = rectangleArea(statement);
            response = String.format("%d", result);
        }
        else if (statement.toLowerCase().contains("quadratic") || (statement.toLowerCase().contains("solve") && statement.toLowerCase().contains("equation"))) {
            String result = quadraticEquation(statement);
            response = result;
        }
        else if (statement.toLowerCase().contains("pythagorean") || (statement.toLowerCase().contains("triangle") && statement.toLowerCase().contains("hypotenuse"))) {
            double result = pythagoreanTheorem(statement);
            response = String.format("%.2f", result);
        }
        else if (statement.trim().length() == 0) {
            response = "Say something, please.";
        }
        else {
            response = getRandomResponse();
        }

        return response;
    }

    private static int add(String statement) {
        int firstNum = 0;
        int secondNum = 0;
        boolean foundFirstNum = false;

        String currentNum = "";

        for (char c : statement.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum += c;
            }
            else if (!currentNum.isEmpty()) {
                if (!foundFirstNum) {
                    firstNum = Integer.parseInt(currentNum);
                    foundFirstNum = true;
                }
                else {
                    secondNum = Integer.parseInt(currentNum);
                }
                
                currentNum = "";
            }
        }

        if (!currentNum.isEmpty()) {
            if (!foundFirstNum) {
                firstNum = Integer.parseInt(currentNum);
            }
            else {
                secondNum = Integer.parseInt(currentNum);
            }
        }

        return firstNum + secondNum;
    }

    private static int subtract(String statement) {
        int firstNum = 0;
        int secondNum = 0;
        boolean foundFirstNum = false;

        String currentNum = "";

        for (char c : statement.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum += c;
            }
            else if (!currentNum.isEmpty()) {
                if (!foundFirstNum) {
                    firstNum = Integer.parseInt(currentNum);
                    foundFirstNum = true;
                }
                else {
                    secondNum = Integer.parseInt(currentNum);
                }
                
                currentNum = "";
            }
        }

        if (!currentNum.isEmpty()) {
            if (!foundFirstNum) {
                firstNum = Integer.parseInt(currentNum);
            }
            else {
                secondNum = Integer.parseInt(currentNum);
            }
        }

        return firstNum - secondNum;
    }

    private static int multiply(String statement) {
        int firstNum = 0;
        int secondNum = 0;
        boolean foundFirstNum = false;

        String currentNum = "";

        for (char c : statement.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum += c;
            }
            else if (!currentNum.isEmpty()) {
                if (!foundFirstNum) {
                    firstNum = Integer.parseInt(currentNum);
                    foundFirstNum = true;
                }
                else {
                    secondNum = Integer.parseInt(currentNum);
                }
                
                currentNum = "";
            }
        }

        if (!currentNum.isEmpty()) {
            if (!foundFirstNum) {
                firstNum = Integer.parseInt(currentNum);
            }
            else {
                secondNum = Integer.parseInt(currentNum);
            }
        }

        return firstNum * secondNum;
    }

    private static int divide(String statement) {
        int firstNum = 0;
        int secondNum = 0;
        boolean foundFirstNum = false;

        String currentNum = "";

        for (char c : statement.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum += c;
            }
            else if (!currentNum.isEmpty()) {
                if (!foundFirstNum) {
                    firstNum = Integer.parseInt(currentNum);
                    foundFirstNum = true;
                }
                else {
                    secondNum = Integer.parseInt(currentNum);
                }
                
                currentNum = "";
            }
        }

        if (!currentNum.isEmpty()) {
            if (!foundFirstNum) {
                firstNum = Integer.parseInt(currentNum);
            }
            else {
                secondNum = Integer.parseInt(currentNum);
            }
        }

        if (secondNum == 0) throw new ArithmeticException("Division by zero is not allowed");

        return firstNum / secondNum;
    }

    private static double squareRoot(String statement) {
        int num = 0;
        String currentNum = "";

        for (char c : statement.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum += c;
            }
            else if (!currentNum.isEmpty()) {
                num = Integer.parseInt(currentNum);
                currentNum = "";
            }
        }

        if (!currentNum.isEmpty()) {
            num = Integer.parseInt(currentNum);
        }

        return Math.sqrt(num);
    }

    private static int exponentiate(String statement) {
        int base = 0;
        int exponent = 0;
        boolean foundBase = false;

        String currentNum = "";

        for (char c : statement.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum += c;
            }
            else if (!currentNum.isEmpty()) {
                if (!foundBase) {
                    base = Integer.parseInt(currentNum);
                    foundBase = true;
                }
                else {
                    exponent = Integer.parseInt(currentNum);
                }
                
                currentNum = "";
            }
        }

        if (!currentNum.isEmpty()) {
            if (!foundBase) {
                base = Integer.parseInt(currentNum);
            }
            else {
                exponent = Integer.parseInt(currentNum);
            }
        }

        return (int) Math.pow(base, exponent);
    }

    private static int modulo(String statement) {
        int firstNum = 0;
        int secondNum = 0;
        boolean foundFirstNum = false;

        String currentNum = "";

        for (char c : statement.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum += c;
            }
            else if (!currentNum.isEmpty()) {
                if (!foundFirstNum) {
                    firstNum = Integer.parseInt(currentNum);
                    foundFirstNum = true;
                }
                else {
                    secondNum = Integer.parseInt(currentNum);
                }
                
                currentNum = "";
            }
        }

        if (!currentNum.isEmpty()) {
            if (!foundFirstNum) {
                firstNum = Integer.parseInt(currentNum);
            }
            else {
                secondNum = Integer.parseInt(currentNum);
            }
        }

        return firstNum % secondNum;
    }

    private static int absoluteValue(String statement) {
        int num = 0;
        boolean isNegative = false;

        String currentNum = "";

        for (int i = 0; i < statement.length(); i++) {
            char c = statement.charAt(i);
            
            if (c == '-' && i + 1 < statement.length() && Character.isDigit(statement.charAt(i + 1))) {
                isNegative = true;
            }
            else if (Character.isDigit(c)) {
                currentNum += c;
            }
            else if (!currentNum.isEmpty()) {
                num = Integer.parseInt(currentNum);
                if (isNegative) {
                    num = -num;
                    isNegative = false;
                }
                currentNum = "";
            }
        }

        if (!currentNum.isEmpty()) {
            num = Integer.parseInt(currentNum);
            if (isNegative) {
                num = -num;
            }
        }

        return Math.abs(num);
    }

    private static double sphereVolume(String statement) {
        int radius = 0;
        String currentNum = "";

        for (char c : statement.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum += c;
            }
            else if (!currentNum.isEmpty()) {
                radius = Integer.parseInt(currentNum);
                currentNum = "";
            }
        }

        if (!currentNum.isEmpty()) {
            radius = Integer.parseInt(currentNum);
        }

        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    private static int rectangleArea(String statement) {
        int length = 0;
        int width = 0;
        boolean foundLength = false;

        String currentNum = "";

        for (char c : statement.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNum += c;
            }
            else if (!currentNum.isEmpty()) {
                if (!foundLength) {
                    length = Integer.parseInt(currentNum);
                    foundLength = true;
                }
                else {
                    width = Integer.parseInt(currentNum);
                }
                
                currentNum = "";
            }
        }

        if (!currentNum.isEmpty()) {
            if (!foundLength) {
                length = Integer.parseInt(currentNum);
            }
            else {
                width = Integer.parseInt(currentNum);
            }
        }

        return length * width;
    }

    private static String quadraticEquation(String statement) {
        int a = 0;
        int b = 0;
        int c = 0;
        int numCount = 0;

        String currentNum = "";

        for (char ch : statement.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNum += ch;
            }
            else if (!currentNum.isEmpty()) {
                int value = Integer.parseInt(currentNum);
                
                switch (numCount) {
                    case 0 -> a = value;
                    case 1 -> b = value;
                    case 2 -> c = value;
                    default -> {
                    }
                }
                
                numCount++;
                currentNum = "";
            }
        }

        if (!currentNum.isEmpty()) {
            int value = Integer.parseInt(currentNum);
            
            switch (numCount) {
                case 0 -> a = value;
                case 1 -> b = value;
                case 2 -> c = value;
                default -> {
                }
            }
        }

        double discriminant = b * b - 4 * a * c;
        
        if (discriminant < 0) {
            return "No real solutions (discriminant < 0)";
        } 
        else if (discriminant == 0) {
            double x = -b / (2.0 * a);
            return String.format("One solution: x = %.2f", x);
        } 
        else {
            double x1 = (-b + Math.sqrt(discriminant)) / (2.0 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2.0 * a);

            return String.format("Two solutions: x1 = %.2f, x2 = %.2f", x1, x2);
        }
    }

    private static double pythagoreanTheorem(String statement) {
        int a = 0;
        int b = 0;
        int c = 0;
        int numCount = 0;

        String currentNum = "";

        for (char ch : statement.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNum += ch;
            }
            else if (!currentNum.isEmpty()) {
                int value = Integer.parseInt(currentNum);
                
                switch (numCount) {
                    case 0 -> a = value;
                    case 1 -> b = value;
                    case 2 -> c = value;
                    default -> {
                    }
                }
                
                numCount++;
                currentNum = "";
            }
        }

        if (!currentNum.isEmpty()) {
            int value = Integer.parseInt(currentNum);
            
            switch (numCount) {
                case 0 -> a = value;
                case 1 -> b = value;
                case 2 -> c = value;
                default -> {
                }
            }
        }
        
        if (c > 0) {
            if (a > 0 && b == 0) {
                return Math.sqrt(c * c - a * a);
            } 
            else if (a == 0 && b > 0) {
                return Math.sqrt(c * c - b * b);
            }
        }
        
        return Math.sqrt(a * a + b * b);
    }
    
    private static String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);

        String response = "";
        
        switch (whichResponse) {
            case 0 -> response = "Interesting, tell me more.";
            case 1 -> response = "Hmmm.";
            case 2 -> response = "Do you really think so?";
            case 3 -> response = "You don't say.";
            case 4 -> response = "The HORSE is a noble animal.";
            case 5 -> response = "You should go give Mr. Farrar five dollars.";
            default -> {
            }
        }

        return response;
    }
    
    public static void main(String[] args) {    
        System.out.println(getGreeting());
        String statement = scanner.nextLine();
        
        while (!statement.equals("Bye")) {
            System.out.println(getResponse(statement));
            statement = scanner.nextLine();
        }
    }
}