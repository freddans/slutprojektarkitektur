package classes.builder;

import classes.Skirt;

public class SkirtBuilder {
  private Skirt skirt = new Skirt();
  private String chosenPattern;
  private String chosenWaistLine;

  public SkirtBuilder addId(int id) {
    if (id <= 0) {
      throw new RuntimeException("Missing id");
    }
    skirt.setId(id);
    return this;
  }

  public SkirtBuilder addName(String name) {
    if (name == null) {
      throw new RuntimeException("Missing name");
    } else {
      skirt.setName(name);
      return this;
    }
  }

  public SkirtBuilder addSize(String size) {
    if (size == null) {
      throw new RuntimeException("Missing size");
    } else {
      skirt.setSize(size);
      return this;
    }
  }

  public SkirtBuilder addPrice(double price) {
    if (price <= 0) {
      throw new RuntimeException("Missing price");
    } else {
      skirt.setPrice(price);
      return this;
    }
  }

  public SkirtBuilder addMaterial(String material) {
    if (material == null) {
      throw new RuntimeException("Missing material");
    } else {
      skirt.setMaterial(material);
      return this;
    }
  }

  public SkirtBuilder addColor(String color) {
    if (color == null) {
      throw new RuntimeException("Missing color");
    } else {
      skirt.setColor(color);
      return this;
    }
  }

  public SkirtBuilder addWaistLine(String waistLine) {
    if (waistLine == null) {
      throw new RuntimeException("Missing waistline");
    } else {
      skirt.setWaistLine(waistLine);
      return this;
    }
  }

  public SkirtBuilder addPattern(String pattern) {
    if (pattern == null) {
      throw new RuntimeException("Missing pattern");
    } else {
      skirt.setPattern(pattern);
      return this;
    }
  }

  public String getChosenPattern() {
    return chosenPattern;
  }

  public void setChosenPattern(String chosenPattern) {
    this.chosenPattern = chosenPattern;
  }

  public String getChosenWaistLine() {
    return chosenWaistLine;
  }

  public void setChosenWaistLine(String chosenWaistLine) {
    this.chosenWaistLine = chosenWaistLine;
  }

  public Skirt build() {
    return skirt;
  }
}
