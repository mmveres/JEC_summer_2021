package ua.univer.lesson10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramPriority {
    static Thread thL;
    static Thread thR;

    public static void main(String[] args) {
        JFrame win = new JFrame();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(400, 300);
        JPanel panel = new JPanel();
        JButton btnLM = new JButton("-");
        btnLM.addActionListener(
                e -> {
                    if (thL.getPriority() > Thread.MIN_PRIORITY) thL.setPriority(thL.getPriority() - 1);
                    System.out.println(thL.getPriority());
                }
        );
        JButton btnLP = new JButton("+");
        btnLP.addActionListener(
                e -> {
                    if (thL.getPriority() < Thread.MAX_PRIORITY) thL.setPriority(thL.getPriority() + 1);
                    System.out.println(thL.getPriority());
                }
        );
        JSlider slider = new JSlider(0, 100, 50);
        JButton btnRM = new JButton("-");
        btnRM.addActionListener(
                e -> {
                    if (thR.getPriority() > Thread.MIN_PRIORITY) thR.setPriority(thR.getPriority() - 1);
                    System.out.println(thR.getPriority());
                }
        );
        JButton btnRP = new JButton("+");
        btnRP.addActionListener(
                e -> {
                    if (thR.getPriority() < Thread.MAX_PRIORITY) thR.setPriority(thR.getPriority() + 1);
                    System.out.println(thR.getPriority());
                }
        );
        JButton btnOk = new JButton("Ok");
        btnOk.addActionListener(
                e -> {
                    thL = new Thread(
                            () -> {
                                while (true)
                                    synchronized (slider){
                                    if (slider.getValue() > slider.getMinimum())
                                        slider.setValue(slider.getValue() - 1);
                                }
                            }
                    );
                    thR = new Thread(
                            () -> {
                                while (true)
                                    synchronized (slider){
                                    if (slider.getValue() < slider.getMaximum())
                                        slider.setValue(slider.getValue() + 1);
                                }
                            }
                    );
                    thL.setDaemon(true);
                    thR.setDaemon(true);
                    thL.start();
                    thR.start();
                });
        panel.add(btnLM);
        panel.add(btnLP);
        panel.add(slider);
        panel.add(btnRM);
        panel.add(btnRP);
        panel.add(btnOk);
        win.setContentPane(panel);
        win.setVisible(true);
    }
}
