package classes.command;

import java.util.ArrayList;
import java.util.List;

public class Processor {
  List<CommandInterface> pipeline = new ArrayList<>();

  public void addCommand(CommandInterface command) {
    pipeline.add(command);
  }

  public void execute() {
    for (CommandInterface command : pipeline) {
      System.out.println(command.decorate());
    }
  }

  public void clearCommands() {
    pipeline.clear();
  }
}
