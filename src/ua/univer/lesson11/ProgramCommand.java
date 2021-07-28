package ua.univer.lesson11;

import java.util.ArrayList;
import java.util.List;

interface Command{
    void execute(String value);
}
public class ProgramCommand {
    public static void main(String[] args) {

        List<Command> availableCommands = new ArrayList<>();
// Old style with anonymous class
        availableCommands.add(new Command() {
            @Override
            public void execute(String value) {
                System.out.println(value);
            }
        });
// New style with lambdas
        availableCommands.add(value -> {
            System.out.println(value+value);
        });

        for (var command : availableCommands) {
            command.execute(" World ");
        }
    }
}
