package classes.command;

import classes.TShirt;

public class TShirtCommand implements CommandInterface {
  private TShirt tShirt;

  public TShirtCommand(TShirt tShirt) {
    this.tShirt = tShirt;
  }

  @Override
  public String decorate() {
    String sleeveInfo = "";
    String neckInfo = "";
    if (!tShirt.getSleeves().isEmpty() && !tShirt.getNeck().isEmpty()) {
      if (tShirt.getSleeves().contains("Sleeveless")) {
        sleeveInfo = "✂️ Cutting to";
      } else if (tShirt.getSleeves().contains("Short")) {
        sleeveInfo = "✂️ Cutting sleeves";
      } else if (tShirt.getSleeves().contains("Long")) {
        sleeveInfo = "🧵 Sowing sleeves";
      }
      if (tShirt.getNeck().contains("V-Neck")) {
        neckInfo = "✂️ Cutting";
      } else if (tShirt.getNeck().contains("Turtleneck") || tShirt.getNeck().contains("Crewneck")) {
        neckInfo = "🧵 Sowing on";
      }
    }
    return "📝 Decorating T-Shirt:\n" + sleeveInfo + " " + tShirt.getSleeves() + "\n" + neckInfo + " " + tShirt.getNeck();
  }
}
