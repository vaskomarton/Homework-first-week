import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskLogic {
    static int numbersOfTextFields = 2;
    static int numberOfActionButtons = 1;
    static int numbersOfResults = 1;
    static String[] buttonDescription = {"test"};
    static String[] resultTexts = {"result"};
    static String taskDescription = "test";

    public TaskLogic() {
    }


    public static void task1(){
        int myNumbersOfTextFields = 0;
        int myNumberOfActionButtons = 0;
        int myNumberOfResults = 6;
        taskDescription = "1. task: Just have a look what i think about this expressions.";
        String[] myResultTexts ={"I think it is:","I think it is:","I think it is:","I think it is:","I think it is:","I think it is:"};
        TaskPanel one = new TaskPanel(taskDescription,buttonDescription,myResultTexts,myNumbersOfTextFields,myNumberOfActionButtons,myNumberOfResults);
        one.resultTextArray[0].setText("0");
        one.resultTextArray[1].setText("n-false?");
        one.resultTextArray[2].setText("true");
        one.resultTextArray[3].setText("false");
        one.resultTextArray[4].setText("4");
        one.resultTextArray[5].setText("false");
        one.backToMenu.setBounds(100, MenuPanel.SCREEN_HEIGHT- MenuPanel.SCREEN_HEIGHT/12-100, MenuPanel.SCREEN_WIDTH/6, MenuPanel.SCREEN_HEIGHT/12);
    }
    public static void task2(){
        buttonDescription[0] = "Modulo";
        taskDescription = "2. task: Provide two numbers. Result will show the leftover after the division";
        TaskPanel two = new TaskPanel(taskDescription,buttonDescription,resultTexts,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        two.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String firstNumberAsString = getIntAsStringFromJTextField(two.textFieldArray[0]);
                    String secondNumberAsString = getIntAsStringFromJTextField(two.textFieldArray[1]);
                    if (errorMessageCheck(firstNumberAsString)){
                        two.resultTextArray[0].setText(firstNumberAsString);
                    } else if (errorMessageCheck(secondNumberAsString)) {
                        two.resultTextArray[0].setText(secondNumberAsString);
                    }else {
                        int firstNumber = Integer.valueOf(firstNumberAsString);
                        int secondNumber = Integer.valueOf(secondNumberAsString);
                        try {
                            two.resultTextArray[0].setText(firstNumber-secondNumber*(firstNumber/secondNumber) + " is the leftover");
                        } catch (ArithmeticException divisionByZero){
                            two.resultTextArray[0].setText("Division with 0 is not healthy");
                        }
                    }
                } catch (NumberFormatException exception){
                    two.resultTextArray[0].setText("Please provide whole numbers");
                }
            }
        });
    }
    public static void task3(){
        int numbersOfTextFields = 3;
        buttonDescription[0] = "Average";
        taskDescription = "3. task: Provide three numbers. Result will show the average";
        TaskPanel three = new TaskPanel(taskDescription,buttonDescription,resultTexts,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        three.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstNumberAsString = getIntAsStringFromJTextField(three.textFieldArray[0]);
                String secondNumberAsString = getIntAsStringFromJTextField(three.textFieldArray[1]);
                String thirdNumberAsString = getIntAsStringFromJTextField(three.textFieldArray[2]);
                if (errorMessageCheck(firstNumberAsString)){
                    three.resultTextArray[0].setText(firstNumberAsString);
                } else if (errorMessageCheck(secondNumberAsString)) {
                    three.resultTextArray[0].setText(secondNumberAsString);
                } else if (errorMessageCheck(thirdNumberAsString)) {
                    three.resultTextArray[0].setText(thirdNumberAsString);
                } else {
                    int firsNumber = Integer.valueOf(firstNumberAsString);
                    int seondNumber = Integer.valueOf(secondNumberAsString);
                    int thirNumber = Integer.valueOf(thirdNumberAsString);
                    double answerDouble = (int) (((double)(firsNumber+seondNumber+thirNumber)/3)*10);
                    three.resultTextArray[0].setText(answerDouble/10 + " is the result");
                }
            }
        });
    }
    public static void task4(){
        int numbersOfTextFields = 1;
        buttonDescription[0] = "Greetings";
        taskDescription = "4. task: What is your Name?";
        TaskPanel four = new TaskPanel(taskDescription,buttonDescription,resultTexts,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        four.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                four.resultTextArray[0].setText("Hello " + four.textFieldArray[0].getText() + ", nice to meet you");
            }
        });
    }
    public static void task5(){
        taskDescription = "5. task: Provide two number, we calculate x+y, x-y, x*y, x/y";
        buttonDescription[0] = "Calculate";
        int numbersOfResults = 4;
        String[] resultTextsFive = {"x+y", "x-y", "x*y", "x/y"};
        TaskPanel five = new TaskPanel(taskDescription,buttonDescription,resultTextsFive,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        five.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstNumberAsString = getIntAsStringFromJTextField(five.textFieldArray[0]);
                String secondNumberAsString = getIntAsStringFromJTextField(five.textFieldArray[1]);
                if (errorMessageCheck(firstNumberAsString)){
                    for (int i = 0; i < five.resultTextArray.length; i++) {
                        five.resultTextArray[i].setText(firstNumberAsString);
                    }
                } else if (errorMessageCheck(secondNumberAsString)) {
                    for (int i = 0; i < five.resultTextArray.length; i++) {
                        five.resultTextArray[i].setText(secondNumberAsString);
                    }
                }else {
                    int firstNumber = Integer.valueOf(firstNumberAsString);
                    int secondNumber = Integer.valueOf(secondNumberAsString);
                    //+
                    five.resultTextArray[0].setText(firstNumber + secondNumber + "");
                    //-
                    five.resultTextArray[1].setText(firstNumber-secondNumber + "");
                    //*
                    five.resultTextArray[2].setText(firstNumber*secondNumber+ "");
                    // divison
                    try {
                        if (secondNumber == 0){
                            Exception ArithmeticException = null;
                            throw ArithmeticException;
                        }
                        five.resultTextArray[3].setText((double)firstNumber/secondNumber + "");
                    } catch (ArithmeticException divisionByZero){
                        five.resultTextArray[3].setText("Division with 0 is not healthy");
                    } catch (Exception ex) {
                        five.resultTextArray[3].setText("Division with 0 is not healthy");
                    }
                }
            }
        });
    }
    public static void task6(){
        taskDescription = "6. task: Provide 2 character.";
        buttonDescription[0] = "Concatenation";
        TaskPanel six = new TaskPanel(taskDescription,buttonDescription,resultTexts,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        six.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstChar = getString(six.textFieldArray[0]);
                String secondChar = getString(six.textFieldArray[1]);
                if (firstChar.length() == 1 && secondChar.length() == 1){
                    six.resultTextArray[0].setText(firstChar + secondChar);
                } else {
                    six.resultTextArray[0].setText("Characters are expected");
                }

            }
        });
    }
    public static void task7(){
        int numbersOfTextFields = 1;
        buttonDescription[0] = "Check";
        taskDescription = "7. task: Is the number greater then 0?";
        TaskPanel seven = new TaskPanel(taskDescription,buttonDescription,resultTexts,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        seven.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = getDoubleAsString(seven.textFieldArray[0]);
                if(number.equals("Please provide number. Format: '1', '4.23'")){
                    seven.resultTextArray[0].setText(number);
                } else {
                    seven.resultTextArray[0].setText((Double.valueOf(number) > 0) + "");
                }
            }
        });
    }
    public static void task8(){
        int myNumberOfActionButtons = 2, myNumbersOfResults = 0, myNumbersOfTextFields = 0;
        String[] myButtonDescription = {"Option 1", "Option 2"};
        taskDescription = "8. task: Which number is bigger? Choose a type of solution";
        TaskPanel eight = new TaskPanel(taskDescription,myButtonDescription,resultTexts,myNumbersOfTextFields,myNumberOfActionButtons,myNumbersOfResults);
        String mytaskDescription = "Which number is bigger?";
        myButtonDescription[0] = "Calculate";
        myButtonDescription[1] = "Back to option selection";
        eight.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override //Option 1
            public void actionPerformed(ActionEvent e) {
                task8Option1();
            }
        });
        eight.actionButtonArray[1].addActionListener(new ActionListener() {
            @Override // Option 2
            public void actionPerformed(ActionEvent e) {
                task8Option2();
            }
        });
    }
    private static void task8Option1(){
        String myTaskDescription = "8. task option1: Which number is bigger?";
        String[] myButtonDescription= {"Calculate","Back to option selection"};
        int myNumberOfActionButtons = 2;
        TaskPanel task8Option1 = new TaskPanel(myTaskDescription,myButtonDescription,resultTexts,numbersOfTextFields,myNumberOfActionButtons,numbersOfResults);

        task8Option1.textFieldArray[1].setBounds(100,150, TaskPanel.CONTENT_WIDTH, TaskPanel.CONTENT_HEIGHT*2);
        Font font = new Font("Courier", Font.BOLD,22);
        task8Option1.textFieldArray[1].setFont(font);
        // xPosition, yPosition, CONTENT_WIDTH, CONTENT_HEIGHT
        task8Option1.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstNumber = getIntAsStringFromJTextField(task8Option1.textFieldArray[0]);
                String secondNumber = getIntAsStringFromJTextField(task8Option1.textFieldArray[1]);
                if (errorMessageCheck(firstNumber)){
                    task8Option1.resultTextArray[0].setText(firstNumber);
                } else if (errorMessageCheck(secondNumber)) {
                    task8Option1.resultTextArray[0].setText(secondNumber);
                } else {
                    task8Option1.resultTextArray[0].setText(secondNumber + " is bigger.");
                }
            }
        });
        task8Option1.actionButtonArray[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task8();
            }
        });
    }
    private static void task8Option2(){
        String myTaskDescription = "8. task option2: Which number is bigger?";
        String[] myButtonDescription= {"Calculate","Back to option selection"};
        int myNumberOfActionButtons = 2;

        TaskPanel task8Option2 = new TaskPanel(myTaskDescription,myButtonDescription,resultTexts,numbersOfTextFields,myNumberOfActionButtons,numbersOfResults);

        task8Option2.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstNumber = getDoubleAsString(task8Option2.textFieldArray[0]);
                String secondNumber = getDoubleAsString(task8Option2.textFieldArray[1]);
                if (errorMessageCheck(firstNumber)){
                    task8Option2.resultTextArray[0].setText(firstNumber);
                } else if (errorMessageCheck(secondNumber)) {
                    task8Option2.resultTextArray[0].setText(secondNumber);
                } else {
                    if (Double.valueOf(firstNumber) > Double.valueOf(secondNumber)){

                        task8Option2.resultTextArray[0].setText(firstNumber + " is bigger.");
                    } else {
                        task8Option2.resultTextArray[0].setText(secondNumber + " is bigger.");
                    }
                }
            }
        });
        task8Option2.actionButtonArray[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task8();
            }
        });
    }
    public static void task9(){
        int myNumbersOfTextFields = 1;
        String[] buttonDescription = {"Power"};
        taskDescription = "9. task: Take a number and power it.";
        TaskPanel nine = new TaskPanel(taskDescription,buttonDescription,resultTexts,myNumbersOfTextFields,numberOfActionButtons,numbersOfResults);
        nine.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = getDoubleAsString(nine.textFieldArray[0]);
                if (errorMessageCheck(number)){
                    nine.resultTextArray[0].setText(number);
                }else {
                    nine.resultTextArray[0].setText(Double.valueOf(number)*Double.valueOf(number) + "");
                }
            }
        });
    }
    public static void task10(){
        String[] buttonDescription = {"Calculate"};
        String taskDescription = "10. task: Provide a base and the power";
        TaskPanel ten = new TaskPanel(taskDescription,buttonDescription,resultTexts,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        ten.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstNumber = getIntAsStringFromJTextField(ten.textFieldArray[0]);
                String secondNumber = getIntAsStringFromJTextField(ten.textFieldArray[1]);
                if (errorMessageCheck(firstNumber)){
                    ten.resultTextArray[0].setText(firstNumber);
                } else if (errorMessageCheck(secondNumber)) {
                    ten.resultTextArray[0].setText(secondNumber);
                } else {
                    ten.resultTextArray[0].setText(Math.pow(Integer.valueOf(firstNumber),Integer.valueOf(secondNumber)) + "");
                }
            }
        });
    }
    public static void task11(){
        int numbersOfTextFields = 1;
        int numberOfActionButtons = 1;
        String[] buttonDescription = {"Calculate"};
        String taskDescription = "11. task: Calculate the square root of the input";
        TaskPanel eleven = new TaskPanel(taskDescription,buttonDescription,resultTexts,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        eleven.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = getIntAsStringFromJTextField(eleven.textFieldArray[0]);
                if (errorMessageCheck(number)){
                    eleven.resultTextArray[0].setText(number);
                } else{
                    eleven.resultTextArray[0].setText(Math.sqrt(Integer.valueOf(number)) + "");
                }
            }
        });
    }
    public static void task12(){
        int myNumbersOfTextFields = 0;
        String[] buttonDescription = {"Generate"};
        String taskDescription = "12. task: Generate a random number";
        TaskPanel twelve = new TaskPanel(taskDescription,buttonDescription,resultTexts,myNumbersOfTextFields,numberOfActionButtons,numbersOfResults);
        int min =0 ;
        int max = 9;

        twelve.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                twelve.resultTextArray[0].setText((int)(Math.random()*(max-min+1)+min) + "");
            }
        });
    }
    public static void task13(){
        int numbersOfTextFields = 2;
        int numberOfActionButtons = 1;
        String[] buttonDescription = {"Generate"};
        String taskDescription = "13. task: Generate a random number between the given bounds";
        TaskPanel thirteen = new TaskPanel(taskDescription,buttonDescription,resultTexts,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        thirteen.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstNumber = getIntAsStringFromJTextField(thirteen.textFieldArray[0]);
                String secondNumber = getIntAsStringFromJTextField(thirteen.textFieldArray[1]);
                if (errorMessageCheck(firstNumber)){
                    thirteen.resultTextArray[0].setText(firstNumber);
                } else if (errorMessageCheck(secondNumber)) {
                    thirteen.resultTextArray[0].setText(secondNumber);
                } else {
                    int max;
                    int min;
                    if (Integer.valueOf(firstNumber) > Integer.valueOf(secondNumber)){
                        max = Integer.valueOf(firstNumber);
                        min = Integer.valueOf(secondNumber);
                    } else {
                        max = Integer.valueOf(secondNumber);
                        min = Integer.valueOf(firstNumber);
                    }
                    thirteen.resultTextArray[0].setText((int)(Math.random()*(max-min+1)+min) + "");
                }

            }
        });
    }
    public static void task14(){
        int myNumbersOfTextFields = 1;
        int numberOfActionButtons = 1;
        buttonDescription[0] = "Count";
        taskDescription = "14. task: Count the length of the input";
        TaskPanel fourteen = new TaskPanel(taskDescription,buttonDescription,resultTexts,myNumbersOfTextFields,numberOfActionButtons,numbersOfResults);
        fourteen.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = fourteen.textFieldArray[0].getText();
                fourteen.resultTextArray[0].setText(input.length() + "");
            }
        });
    }
    public static void task15(){
        int numbersOfTextFields = 1;
        String[] buttonDescription = {"Convert to text"};
        String taskDescription = "15. task: We convert a number into 'text'";
        TaskPanel fifteen = new TaskPanel(taskDescription,buttonDescription,resultTexts,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        fifteen.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numberAsText = getDoubleAsString(fifteen.textFieldArray[0]);
                if(errorMessageCheck(numberAsText)){
                    fifteen.resultTextArray[0].setText(numberAsText);
                }else {
                    fifteen.resultTextArray[0].setText("text");
                }
            }
        });
    }
    public static void task16(){
        int numbersOfTextFields = 1;
        buttonDescription[0] = "Greetings";
        taskDescription = "16. task: What is your Name?";
        TaskPanel sixteen = new TaskPanel(taskDescription,buttonDescription,resultTexts,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        sixteen.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sixteen.resultTextArray[0].setText(String.format("Üdvözöllek, kedves %s! Jó, hogy újra itt vagy!",sixteen.textFieldArray[0].getText()));
            }
        });
    }
    public static void task17(){
        buttonDescription[0] = "Comparison";
        taskDescription = "17. task: Are the two input same?";
        TaskPanel seventeen = new TaskPanel(taskDescription,buttonDescription,resultTexts,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        seventeen.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seventeen.textFieldArray[0].getText().equals(seventeen.textFieldArray[1].getText())){
                    seventeen.resultTextArray[0].setText("They are same");
                } else {
                    seventeen.resultTextArray[0].setText("They are not same");
                }
            }
        });
    }
    public static void task18(){
        int numbersOfTextFields = 1;
        buttonDescription[0] = "Calculate";
        taskDescription = "18. task: Is there more then one word in the input?";
        TaskPanel eighteen = new TaskPanel(taskDescription,buttonDescription,resultTexts,numbersOfTextFields,numberOfActionButtons,numbersOfResults);
        eighteen.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = eighteen.textFieldArray[0].getText();
                boolean firstWordFound = false;
                boolean spaceBetweenFound = false;
                boolean secondWordFound = false;
                for (int i = 0; i < input.length(); i++) {
                    if (!firstWordFound){
                        if (input.charAt(i) != ' '){
                            firstWordFound = true;
                        }
                    } else if (!spaceBetweenFound) {
                        if (input.charAt(i) == ' '){
                            spaceBetweenFound = true;
                        }
                    } else if (!secondWordFound) {
                        if (input.charAt(i) != ' '){
                            secondWordFound = true;

                        }
                    }
                }
                if (secondWordFound){
                    eighteen.resultTextArray[0].setText("There are more then one word");
                } else {
                    eighteen.resultTextArray[0].setText("There are not at least two word");
                }
            }
        });
    }
    public static void task19(){
        int myNumbersOfTextFields = 0;
        buttonDescription[0] = "cut some text";
        taskDescription = "19. task: First and last character of:\"There is nothing either good or bad, but thinking makes it so\"";
        TaskPanel nineteen = new TaskPanel(taskDescription,buttonDescription,resultTexts,myNumbersOfTextFields,numberOfActionButtons,numbersOfResults);
        nineteen.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = "There is nothing either good or bad, but thinking makes it so";
                nineteen.resultTextArray[0].setText(String.valueOf(text.charAt(0)) + " and " + String.valueOf(text.charAt(text.length() - 1)));
            }
        });
    }
    public static void task20(){
        int myNumbersOfTextFields = 2;
        int myNumberOfResults = 2;
        String[] myResultTexts = {"Result of custom text", "Result of second text"};
        buttonDescription[0] = "cut some text";
        taskDescription = "20. task: Find the first and last \"t\" in text. One of them is not changeable";
        TaskPanel twenty = new TaskPanel(taskDescription,buttonDescription,myResultTexts,myNumbersOfTextFields,numberOfActionButtons,myNumberOfResults);
        twenty.textFieldArray[1].setText("There is nothing either good or bad, but thinking makes it so");
        twenty.textFieldArray[1].setFocusable(false);
        twenty.textFieldArray[1].setEnabled(false);
        twenty.textFieldArray[1].setBounds(100,150,400,25);
        twenty.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = "There is nothing either good or bad, but thinking makes it so";
                int indexOfFirstT = -1;
                int indexOfLastT = -1;
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) == 't'){
                        if (indexOfFirstT == -1){
                            indexOfFirstT = i;
                        }
                        indexOfLastT = i;
                    }
                }
                if (indexOfFirstT == -1){
                    twenty.resultTextArray[1].setText("There are no \"t\" in the text");
                } else {
                    twenty.resultTextArray[1].setText(indexOfFirstT + " is 1. and " + indexOfLastT + " is the last index ");
                }
                String text2 = twenty.textFieldArray[0].getText();
                int indexOfFirstT1 = -1;
                int indexOfLastT1 = -1;
                for (int i = 0; i < text2.length(); i++) {
                    if (text2.charAt(i) == 't'){
                        if (indexOfFirstT1 == -1){
                            indexOfFirstT1 = i;
                        }
                        indexOfLastT1 = i;
                    }
                }
                if (indexOfFirstT1 == -1){
                    twenty.resultTextArray[0].setText("There are no \"t\" in the text");
                } else {
                    twenty.resultTextArray[0].setText(indexOfFirstT1 + " is the 1. and " + indexOfLastT1 + " is the last index");
                }
            }
        });
    }
    public static void task21(){
        int myNumbersOfTextFields = 2;
        int myNumberOfResults = 2;
        String[] myResultTexts = {"Result of custom text", "Result of second text"};
        buttonDescription[0] = "cut some text";
        taskDescription = "21. task: Replace all \".\" with \"-\".";
        TaskPanel twentyone = new TaskPanel(taskDescription,buttonDescription,myResultTexts,myNumbersOfTextFields,numberOfActionButtons,myNumberOfResults);
        twentyone.textFieldArray[1].setText("2021.05.05");
        twentyone.textFieldArray[1].setFocusable(false);
        twentyone.textFieldArray[1].setEnabled(false);
        twentyone.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] text = twentyone.textFieldArray[1].getText().toCharArray();
                boolean dot = false;
                for (int i = 0; i < text.length; i++) {
                    if (text[i] == '.'){
                        text[i] = '-';
                        dot = true;
                    }
                }
                if (dot){
                    twentyone.resultTextArray[1].setText(String.valueOf(text));
                } else {
                    twentyone.resultTextArray[1].setText("There are no \".\" in the text");
                }

                char[] text2 = twentyone.textFieldArray[0].getText().toCharArray();
                boolean dot2 = false;
                for (int i = 0; i < text2.length; i++) {
                    if (text2[i] == '.'){
                        text2[i] = '-';
                        dot2 = true;
                    }
                }
                if (dot2){
                    twentyone.resultTextArray[0].setText(String.valueOf(text2));
                } else {
                    twentyone.resultTextArray[0].setText("There are no \".\" in the text");
                }
            }
        });
    }
    public static void task22(){
        int myNumbersOfTextFields = 1;
        buttonDescription[0] = "Count";
        taskDescription = "22. task: Count the length of a number";
        TaskPanel twentytwo = new TaskPanel(taskDescription,buttonDescription,resultTexts,myNumbersOfTextFields,numberOfActionButtons,numbersOfResults);
        twentytwo.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = getIntAsStringFromJTextField(twentytwo.textFieldArray[0]);
                if (errorMessageCheck(number)){
                    twentytwo.resultTextArray[0].setText(number);
                } else {
                    twentytwo.resultTextArray[0].setText(number.length() + " is the length");
                }
            }
        });
    }
    public static void task23(){
        int myNumbersOfTextFields = 2;
        int myNumberOfResults = 2;
        String[] myResultTexts = {"Result of custom text", "Result of second text"};
        buttonDescription[0] = "cut some text";
        taskDescription = "23. task: Return the first 10 character of the sentences";
        TaskPanel twentythree = new TaskPanel(taskDescription,buttonDescription,myResultTexts,myNumbersOfTextFields,numberOfActionButtons,myNumberOfResults);
        twentythree.textFieldArray[1].setText("In a hole in the ground there lived a hobbit.");
        twentythree.textFieldArray[1].setFocusable(false);
        twentythree.textFieldArray[1].setEnabled(false);
        twentythree.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = twentythree.textFieldArray[1].getText();
                if (text.length() < 10){
                    twentythree.resultTextArray[1].setText("The text is not long enough");
                }else {
                    text += " ";
                    twentythree.resultTextArray[1].setText(text.substring(0,10));
                }
                String text2 = twentythree.textFieldArray[0].getText();
                if (text2.length() < 10){
                    twentythree.resultTextArray[0].setText("The text is not long enough");
                }else {
                    text2 += " ";
                    twentythree.resultTextArray[0].setText(text2.substring(0,10));
                }
            }
        });
    }
    public static void task24(){
        int myNumbersOfTextFields = 2;
        int myNumberOfResults = 2;
        String[] myResultTexts = {"Result of custom text", "Result of second text"};
        buttonDescription[0] = "cut some text";
        taskDescription = "24. task: Return the first word of the sentences";
        TaskPanel twentyfour = new TaskPanel(taskDescription,buttonDescription,myResultTexts,myNumbersOfTextFields,numberOfActionButtons,myNumberOfResults);
        twentyfour.textFieldArray[1].setText("In a hole in the ground there lived a hobbit.");
        twentyfour.textFieldArray[1].setFocusable(false);
        twentyfour.textFieldArray[1].setEnabled(false);
        twentyfour.actionButtonArray[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = twentyfour.textFieldArray[1].getText() + " ";
                int startingIndex = -1;
                int endingIndex = -1;
                boolean charFound = false;
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) != ' ' && !charFound){
                        startingIndex = i;
                        charFound  = true;
                    } else if (text.charAt(i) == ' ' && charFound){
                        endingIndex = i;
                        i = text.length();
                    }
                }
                if (charFound){
                    twentyfour.resultTextArray[1].setText(text.substring(startingIndex,endingIndex));
                } else {
                    twentyfour.resultTextArray[1].setText("No word found");
                }
                String text2 = twentyfour.textFieldArray[0].getText() + " ";
                int startingIndex2 = -1;
                int endingIndex2 = -1;
                boolean charFound2 = false;
                for (int i = 0; i < text2.length(); i++) {
                    if (text2.charAt(i) != ' ' && !charFound2){
                        startingIndex2 = i;
                        charFound2  = true;
                    } else if (text2.charAt(i) == ' ' && charFound2){
                        endingIndex2 = i;
                        i = text2.length();
                    }
                }
                if (charFound2){
                    twentyfour.resultTextArray[0].setText(text2.substring(startingIndex2,endingIndex2));
                } else {
                    twentyfour.resultTextArray[0].setText("No word found");
                }
            }
        });
    }

    private static String getIntAsStringFromJTextField(JTextField textField){
        try {
            int number = Integer.valueOf(textField.getText());
            return String.valueOf(number);
        } catch (NumberFormatException exception){
            return "Please provide whole number";
        }

    }
    private  static String getDoubleAsString(JTextField textField){
        try {
            double number = Double.valueOf(textField.getText());
            return String.valueOf(number);
        } catch (NumberFormatException exception){
            return "Please provide number. Format: '1', '4.23'";
        }
    }
    private static String getString(JTextField textField){
        return textField.getText();
    }

    private static boolean errorMessageCheck (String input){
        try {
            Double.valueOf(input);
            return false;
        } catch (NumberFormatException exception){
            return true;
        }
    }
}
