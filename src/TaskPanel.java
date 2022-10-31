import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TaskPanel extends JPanel{
    static int SCREEN_WIDTH = MenuPanel.SCREEN_WIDTH;
    static int SCREEN_HEIGHT = MenuPanel.SCREEN_HEIGHT;
    static int CONTENT_WIDTH = 300;
    static int CONTENT_HEIGHT = 25;
    Dimension SCREEN = MenuPanel.SCREEN;
    public static JLabel description;
    JButton actionButton;
    JButton[] actionButtonArray;
    public static JTextField[] textFieldArray;
    public static JLabel[] resultLabelArray;
    public static JTextField[] resultTextArray;
    JButton backToMenu;
    public TaskPanel(String taskDescription,String[] actionButtonDescription,String[] resultTexts, int numbersOfTextFields, int numberOfActionButtons, int numberOfResults) {
        this.setFocusable(true);
        this.setPreferredSize(SCREEN);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        // Write the task description.
        description = new JLabel();
        description.setBounds(20,20,SCREEN_WIDTH-40,40);
        //description.setText("");  // get text later in MenuPanel
        description.setHorizontalAlignment(JLabel.CENTER);
        description.setForeground(Color.GREEN);
        description.setText(taskDescription);
        this.add(description);
        description.setVisible(true);
        //Input panel/s
        textFieldArray = new JTextField[numbersOfTextFields];
        for (int i = 0; i < numbersOfTextFields; i++) {
            JTextField inputField = textFieldGenerator(100,100 + 50 * i);
            textFieldArray[i] = inputField;
            this.add(inputField);
        }
        //Action button/s
        actionButtonArray= new JButton[numberOfActionButtons];
        for (int i = 0; i < numberOfActionButtons; i++) {
            JButton actualActionButton;
            try {
                actualActionButton = actionButton(actionButtonDescription[i], 450, 100 + 50 * i);
                actionButtonArray[i] = actualActionButton;
                this.add(actualActionButton);
            } catch (ArrayIndexOutOfBoundsException e){
                actualActionButton = actionButton("", 450, 100 + 50 * i);
                actionButtonArray[i] = actualActionButton;
                this.add(actualActionButton);
            }
        }
        resultLabelArray = new JLabel[numberOfResults];
        resultTextArray = new JTextField[numberOfResults];
        for (int i = 0; i < numberOfResults; i++) {
            resultLabelArray[i] = resultLabel(700,100 + 100 * i,resultTexts[i]);
            resultTextArray[i] = resultFieldGenerator(700, 150 + 100*i);
            this.add(resultLabelArray[i]);
            resultLabelArray[i].setVisible(true);
            this.add(resultTextArray[i]);
            resultTextArray[i].setVisible(true);
        }

        //back to menu
        backToMenu = backToMenu();
        this.add(backToMenu);
        backToMenu.setVisible(true);

        //
        Main.homeworkFrame.getContentPane().removeAll();
        Main.homeworkFrame.getContentPane().add(this);
        Main.homeworkFrame.getContentPane().revalidate();
        Main.homeworkFrame.getContentPane().repaint();
    }

    public JButton backToMenu(){
        JButton backToMenuButton = new JButton();
        int buttonWidth = SCREEN_WIDTH/6;
        int buttonHeight = SCREEN_HEIGHT/12;
        backToMenuButton.setBounds(SCREEN_WIDTH/2, SCREEN_HEIGHT-buttonHeight-100, buttonWidth, buttonHeight);
        backToMenuButton.setText("Back to menu");
        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.homeworkFrame.getContentPane().removeAll();
                Main.homeworkFrame.getContentPane().add(Main.homeworkFrame.getMenu());
                Main.homeworkFrame.getContentPane().revalidate();
                Main.homeworkFrame.getContentPane().repaint();
            }
        });
        backToMenuButton.setForeground(Color.blue);
        backToMenuButton.setBackground(Color.cyan);
        backToMenuButton.setVisible(true);
        backToMenuButton.setFocusable(false);
        return backToMenuButton;
    }

    public static JTextField textFieldGenerator(int xPosition, int yPosition) {
        JTextField textBox = new JTextField(20);
        textBox.setBounds(xPosition, yPosition, CONTENT_WIDTH, CONTENT_HEIGHT);
        textBox.setVisible(true);
        textBox.setFocusable(true);
        textBox.setEditable(true);
        return textBox;
    }

    public JButton actionButton(String buttonDescription, int yPosition, int xPosition){
        actionButton = new JButton();
        actionButton.setBounds(yPosition,xPosition,CONTENT_WIDTH/2, CONTENT_HEIGHT);
        actionButton.setText(buttonDescription);
        actionButton.setVisible(true);
        actionButton.setFocusable(false);
        return actionButton;
    }
    private static JTextField resultFieldGenerator(int xPosition, int yPosition) {
        JTextField textBox = new JTextField(20);
        textBox.setBounds(xPosition, yPosition, CONTENT_WIDTH, CONTENT_HEIGHT);
        textBox.setBackground(Color.DARK_GRAY);
        textBox.setForeground(Color.CYAN);
        textBox.setVisible(true);
        textBox.setFocusable(false);
        textBox.setEditable(true);
        return textBox;
    }

    private static JLabel resultLabel(int xPosition, int yPosition, String resultText){
        JLabel resultLabel = new JLabel();
        resultLabel.setBounds(xPosition,yPosition,CONTENT_WIDTH,CONTENT_HEIGHT);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        resultLabel.setText(resultText);
        resultLabel.setForeground(Color.GREEN);
        resultLabel.setBackground(Color.BLUE);
        return resultLabel;
    }
}
