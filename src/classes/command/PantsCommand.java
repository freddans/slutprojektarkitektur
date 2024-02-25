package classes.command;

import classes.Pants;

public class PantsCommand implements CommandInterface {
  private Pants pants;

  public PantsCommand(Pants pants) {
    this.pants = pants;
  }

  @Override
  public String decorate() {
    String fitInfo = "";
    String lengthInfo = "";
    if (!pants.getFit().isEmpty() && !pants.getLength().isEmpty()) {
      if (pants.getFit().contains("Slim") || pants.getFit().contains("Skinny")) {
        fitInfo = "🧵 Sowing a tighter fit to";
      } else if (pants.getFit().contains("Baggy")) {
        fitInfo = "🧵 Sowing a wider fit to";
      }
      if (pants.getLength().contains("Short") || pants.getLength().contains("Medium")) {
        lengthInfo = "✂️ Cutting pants to";
      } else if (pants.getLength().contains("Long")) {
        lengthInfo = "📎 Adding fabric for length";
      }
    }

    return "📝 Decorating Pants:\n" + fitInfo + " " + pants.getFit() + "\n" + lengthInfo + " " + pants.getLength();
  }
}
