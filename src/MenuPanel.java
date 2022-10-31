import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    static Toolkit tk = Toolkit.getDefaultToolkit();
    public static final int SCREEN_WIDTH= (int) tk.getScreenSize().getWidth() -100;
    public static final int SCREEN_HEIGHT = (int) tk.getScreenSize().getHeight() - 100;

    static final Dimension SCREEN = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    public MenuPanel() {
        this.setFocusable(true);
        this.setPreferredSize(SCREEN);
        this.setBackground(Color.BLACK);

        // I hate layouts
        this.setLayout(null);
        // I hate layouts

        JLabel question = new JLabel();
        question.setBounds(20,20,SCREEN_WIDTH-40,40);
        question.setText("Choose a task");
        question.setHorizontalAlignment(JLabel.CENTER);
        question.setForeground(Color.GREEN);
        this.add(question);
        question.setVisible(true);

        JButton[][] tasks = new JButton[8][3];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 3; col++) {
                tasks[row][col] = createButton(row, col);
                this.add(tasks[row][col]);
            }
        }
    }
    public JButton createButton(int row, int col){
        JButton newButton = new JButton();
        int buttonWidth = SCREEN_WIDTH/6;
        int verticalSpacing = buttonWidth/3;
        int buttonHeight = SCREEN_HEIGHT/12;
        int horizontalSpacing = buttonHeight*5;

        newButton.setBounds(horizontalSpacing+col*horizontalSpacing, verticalSpacing+row*verticalSpacing,buttonWidth,buttonHeight);
        newButton.setText(String.format("%d. task",col+1+row*3));
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtonAction(newButton);
            }
        });
        newButton.setForeground(Color.blue);
        newButton.setBackground(Color.cyan);
        newButton.setVisible(true);
        newButton.setFocusable(false);

        return newButton;
    }

    public void setButtonAction(JButton actualButton){
        String[] actionButtonDescription;
        switch (actualButton.getText()){
            case "1. task":
                TaskLogic.task1();
                break;
            case "2. task":
                TaskLogic.task2();
                break;
            case "3. task":
                TaskLogic.task3();
                break;
            case "4. task":
                TaskLogic.task4();
                break;
            case "5. task":
                TaskLogic.task5();
                break;
            case "6. task":
                TaskLogic.task6();
                break;
            case "7. task":
                TaskLogic.task7();
                break;
            case "8. task":
                TaskLogic.task8();
                break;
            case "9. task":
                TaskLogic.task9();
                break;
            case "10. task":
                TaskLogic.task10();
                break;
            case "11. task":
                TaskLogic.task11();
                break;
            case "12. task":
                TaskLogic.task12();
                break;
            case "13. task":
                TaskLogic.task13();
                break;
            case "14. task":
                TaskLogic.task14();
                break;
            case "15. task":
                TaskLogic.task15();
                break;
            case "16. task":
                TaskLogic.task16();
                break;
            case "17. task":
                TaskLogic.task17();
                break;
            case "18. task":
                TaskLogic.task18();
                break;
            case "19. task":
                TaskLogic.task19();
                break;
            case "20. task":
                TaskLogic.task20();
                break;
            case "21. task":
                TaskLogic.task21();
                break;
            case "22. task":
                TaskLogic.task22();
                break;
            case "23. task":
                TaskLogic.task23();
                break;
            case "24. task":
                TaskLogic.task24();
                /*
                actionButtonDescription = new String[1];
                actionButtonDescription[0] = "No action";
                TaskPanel twentyfour = createTask("Not implemened yet",actionButtonDescription,1,1);
                JLabel label = new JLabel();
                label.setBounds(300, 400,300, 50);
                JTextField testTeyt = TaskPanel.textFieldGenerator(100,300);

                testTeyt.addActionListener((e) -> {
                    twentyfour.description.setText("Try this");
                });
                twentyfour.add(testTeyt);
                testTeyt.setVisible(true);
                break;

                 */
            default:
        }
    }
}
