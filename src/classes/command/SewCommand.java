package classes.command;

import classes.Pants;
import classes.Skirt;
import classes.TShirt;
import classes.builder.PantsBuilder;
import classes.builder.SkirtBuilder;
import classes.builder.TShirtBuilder;

public class SewCommand implements CommandInterface {
  private Object item;
  PantsBuilder pantsBuilder;
  SkirtBuilder skirtBuilder;
  TShirtBuilder tShirtBuilder;

  public SewCommand(Object item, PantsBuilder pantsBuilder) {
    this.item = item;
    this.pantsBuilder = pantsBuilder;
  }

  public SewCommand(Object item, SkirtBuilder skirtBuilder) {
    this.item = item;
    this.skirtBuilder = skirtBuilder;
  }

  public SewCommand(Object item, TShirtBuilder tShirtBuilder) {
    this.item = item;
    this.tShirtBuilder = tShirtBuilder;
  }

  @Override
  public String decorate() {

    // Pants
    if (item instanceof Pants) {
      Pants pants = ((Pants) item);

      if (pantsBuilder.getChosenFit().contains("Skinny") || pantsBuilder.getChosenFit().contains("Slim")) {
        pantsBuilder.addFit(pantsBuilder.getChosenFit());

        return "🧵 Sowing a tighter fit to " + pants.getFit();
      } else if (pantsBuilder.getChosenFit().contains("Baggy")) {
        pantsBuilder.addFit(pantsBuilder.getChosenFit());

        return "🧵 Sowing a wider fit to " + pants.getFit();
      }
    }
    // TShirt
    else if (item instanceof TShirt) {
      TShirt tShirt = ((TShirt) item);

      tShirtBuilder.addNeck(tShirtBuilder.getChosenNeck());

      return "🧵 Sowing on a " + tShirt.getNeck();
    }
    // Skirt
    else if (item instanceof Skirt) {
      Skirt skirt = ((Skirt) item);

      skirtBuilder.addPattern(skirtBuilder.getChosenPattern());

      return "🧵 Sowing a " + skirt.getPattern() + " pattern";
    }
    return null;
  }

}
