package classes.command;

import classes.Skirt;

public class SkirtCommand implements CommandInterface {
  private Skirt skirt;

  public SkirtCommand(Skirt skirt) {
    this.skirt = skirt;
  }

  @Override
  public String decorate() {
    String waistInfo = "";
    String patternInfo = "";
    if (!skirt.getWaistLine().isEmpty() && !skirt.getPattern().isEmpty()) {
      if (skirt.getWaistLine().contains("High") || skirt.getWaistLine().contains("Medium") || skirt.getWaistLine().contains("Low")) {
        waistInfo = "🧵 Sowing waistline";
      }
      if (skirt.getPattern().contains("Stripes")) {
        patternInfo = "🧵 Sowing on";
      } else if (skirt.getPattern().contains("Solid")) {
        patternInfo = "🚫 Leaving pattern";
      } else if (skirt.getPattern().contains("Checkered")) {
        patternInfo = "🎨 Panting pattern";
      }
    }
    return "📝 Decorating Skirt:\n" + waistInfo + " " + skirt.getWaistLine() + "\n" + patternInfo + " " + skirt.getPattern();
  }
}
