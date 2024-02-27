package classes.command;

import classes.Pants;
import classes.Skirt;
import classes.TShirt;

public class CutCommand implements CommandInterface {
  private Object item;

  public CutCommand(Object item) {
    this.item = item;
  }

  @Override
  public String decorate() {

    // Pants
    if (item instanceof Pants) {
      Pants pants = ((Pants) item);
      if (pants.getLength().contains("Short") || pants.getLength().contains("Medium") || pants.getLength().contains("Long")) {
        return "✂️ Cutting pants to " + pants.getLength();
      }
    }
    // TShirt
    else if (item instanceof TShirt) {
      TShirt tShirt = ((TShirt) item);
      if (tShirt.getSleeves().contains("Sleeveless") || tShirt.getSleeves().contains("Short") || tShirt.getSleeves().contains("Long")) {
        return "✂️ Cutting sleeves to " + tShirt.getSleeves();
      }
    }
    // Skirt
    else if (item instanceof Skirt) {
      Skirt skirt = ((Skirt) item);
      if (skirt.getWaistLine().contains("Low") || skirt.getWaistLine().contains("Medium") || skirt.getWaistLine().contains("High")) {
        return "✂️ Cutting waistline to " + skirt.getWaistLine();
      }
    }
    return null;
  }
}




