package ua.univer.lesson10;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProgramUI {
    static Logger LOGGER = Logger.getLogger("ProgramUI");
    public static void main(String[] args) {
        JFrame win = new JFrame();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(300, 400);
        JPanel panel = new JPanel();
        JTextField text = new JTextField("                   ");
        JButton btn = new JButton("Ok");
        btn.addActionListener(e -> new Thread(
                () -> {
                    for (int i = 0; i < 100; i++) {
                        text.setText("Hi " + i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException interruptedException) {
                            LOGGER.log(Level.WARNING, "Interrupted!", e);
                            // Restore interrupted state...
                            Thread.currentThread().interrupt();
                        }
                    }
                }).start());

        panel.add(text);
        panel.add(btn);
        win.setContentPane(panel);
        win.setVisible(true);


    }
}
