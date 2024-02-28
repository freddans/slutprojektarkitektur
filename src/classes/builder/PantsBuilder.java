package classes.builder;

import classes.Pants;

public class PantsBuilder {
  private Pants pants = new Pants();
  private String chosenFit;
  private String chosenLength;

  public PantsBuilder addId(int id) {
    if (id <= 0) {
      throw new RuntimeException("Missing id");
    } else {
      pants.setId(id);
      return this;
    }
  }

  public PantsBuilder addName(String name) {
    if (name == null) {
      throw new RuntimeException("Missing name");
    } else {
      pants.setName(name);
      return this;
    }
  }

  public PantsBuilder addSize(String size) {
    if (size == null) {
      throw new RuntimeException("Missing size");
    } else {
      pants.setSize(size);
      return this;
    }
  }

  public PantsBuilder addPrice(double price) {
    if (price <= 0) {
      throw new RuntimeException("Missing price");
    } else {
      pants.setPrice(price);
      return this;
    }
  }

  public PantsBuilder addMaterial(String material) {
    if (material == null) {
      throw new RuntimeException("Missing material");
    } else {
      pants.setMaterial(material);
      return this;
    }
  }

  public PantsBuilder addColor(String color) {
    if (color == null) {
      throw new RuntimeException("Missing color");
    } else {
      pants.setColor(color);
      return this;
    }
  }

  public PantsBuilder addFit(String fit) {
    if (fit == null) {
      throw new RuntimeException("Missing fit");
    } else {
      pants.setFit(fit);
      return this;
    }
  }

  public PantsBuilder addLength(String length) {
    if (length == null) {
      throw new RuntimeException("Missing length");
    } else {
      pants.setLength(length);
      return this;
    }
  }

  public String getChosenFit() {
    return chosenFit;
  }

  public void setChosenFit(String chosenFit) {
    this.chosenFit = chosenFit;
  }

  public String getChosenLength() {
    return chosenLength;
  }

  public void setChosenLength(String chosenLength) {
    this.chosenLength = chosenLength;
  }

  public Pants build() {
    return pants;
  }
}
