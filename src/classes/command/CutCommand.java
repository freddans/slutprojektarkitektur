package classes.command;

import classes.Pants;
import classes.Skirt;
import classes.TShirt;
import classes.builder.PantsBuilder;
import classes.builder.SkirtBuilder;
import classes.builder.TShirtBuilder;

public class CutCommand implements CommandInterface {
  private Object item;
  PantsBuilder pantsBuilder;
  SkirtBuilder skirtBuilder;
  TShirtBuilder tShirtBuilder;

  public CutCommand(Object item, PantsBuilder pantsBuilder) {
    this.item = item;
    this.pantsBuilder = pantsBuilder;
  }

  public CutCommand(Object item, SkirtBuilder skirtBuilder) {
    this.item = item;
    this.skirtBuilder = skirtBuilder;
  }

  public CutCommand(Object item, TShirtBuilder tShirtBuilder) {
    this.item = item;
    this.tShirtBuilder = tShirtBuilder;
  }

  @Override
  public String decorate() {

    // Pants
    if (item instanceof Pants) {
      Pants pants = ((Pants) item);
      pantsBuilder.addLength(pantsBuilder.getChosenLength());

      return "✂️ Cutting pants to " + pants.getLength();
    }
    // TShirt
    else if (item instanceof TShirt) {
      TShirt tShirt = ((TShirt) item);
      tShirtBuilder.addSleeves(tShirtBuilder.getChosenSleeves());

      return "✂️ Cutting sleeves to " + tShirt.getSleeves();

    }
    // Skirt
    else if (item instanceof Skirt) {
      Skirt skirt = ((Skirt) item);
      skirtBuilder.addWaistLine(skirtBuilder.getChosenWaistLine());

      return "✂️ Cutting waistline to " + skirt.getWaistLine();

    }
    return null;
  }
}




