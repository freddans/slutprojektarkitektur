package classes.command;

import classes.Pants;
import classes.Skirt;
import classes.TShirt;

public class SewCommand implements CommandInterface {
  private Object item;

  public SewCommand(Object item) {
    this.item = item;
  }

  @Override
  public String decorate() {

    // Pants
    if (item instanceof Pants) {
      Pants pants = ((Pants) item);

      if (pants.getFit().contains("Skinny") || pants.getFit().contains("Slim")) {
        return "🧵 Sowing a tighter fit to " + pants.getFit();
      } else if (pants.getFit().contains("Baggy")) {
        return "🧵 Sowing a wider fit to " + pants.getFit();
      }
    }
    // TShirt
    else if (item instanceof TShirt) {
      TShirt tShirt = ((TShirt) item);

      if (tShirt.getNeck().contains("Crewneck") || tShirt.getNeck().contains("Turtleneck") || tShirt.getNeck().contains("Polo")) {
        return "🧵 Sowing on a " + tShirt.getNeck();
      }
    }
    // Skirt
    else if (item instanceof Skirt) {
      Skirt skirt = ((Skirt) item);
      if (skirt.getPattern().contains("Stripes") || skirt.getPattern().contains("Checkered") || skirt.getPattern().contains("Wavy")) {
        return "🧵 Sowing a " + skirt.getPattern() + " pattern";
      }
    }
    return null;
  }
}
