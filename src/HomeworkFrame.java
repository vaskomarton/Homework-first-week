import javax.swing.*;
import java.awt.*;

public class HomeworkFrame extends JFrame {
    MenuPanel menu;
    public HomeworkFrame() {
        menu = new MenuPanel();
        this.add(menu);
        this.setTitle("Homework");
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public MenuPanel getMenu() {
        return menu;
    }
}
