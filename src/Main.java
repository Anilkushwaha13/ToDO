import page.FrontPage;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        JFrame frame = new FrontPage();
        frame.setTitle("To Do List");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        frame.setResizable(false);

        // Calculate window position to center on screen
        int x = (screenWidth - frame.getWidth()) / 2;
        int y = (screenHeight - frame.getHeight()) / 2;

        // Set window position
        frame.setLocation(x, y);


    }
    }
