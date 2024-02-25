package classes.builder;

import classes.TShirt;

public class TShirtBuilder {
  private TShirt tShirt = new TShirt();

  public TShirtBuilder addId(int id) {
    if (id <= 0) {
      throw new RuntimeException("Missing id");
    } else {
      tShirt.setId(id);
      return this;
    }
  }

  public TShirtBuilder addName(String name) {
    if (name == null) {
      throw new RuntimeException("Missing name");
    } else {
      tShirt.setName(name);
      return this;
    }
  }

  public TShirtBuilder addSize(String size) {
    if (size == null) {
      throw new RuntimeException("Missing size");
    } else {
      tShirt.setSize(size);
      return this;
    }
  }

  public TShirtBuilder addPrice(double price) {
    if (price <= 0) {
      throw new RuntimeException("Missing price");
    } else {
      tShirt.setPrice(price);
      return this;
    }
  }

  public TShirtBuilder addMaterial(String material) {
    if (material == null) {
      throw new RuntimeException("Missing material");
    } else {
      tShirt.setMaterial(material);
      return this;
    }
  }

  public TShirtBuilder addColor(String color) {
    if (color == null) {
      throw new RuntimeException("Missing color");
    } else {
      tShirt.setColor(color);
      return this;
    }
  }

  public TShirtBuilder addSleeves(String sleeves) {
    if (sleeves == null) {
      throw new RuntimeException("Missing sleeves");
    } else {
      tShirt.setSleeves(sleeves);
      return this;
    }
  }

  public TShirtBuilder addNeck(String neck) {
    if (neck == null) {
      throw new RuntimeException("Missing neck");
    } else {
      tShirt.setNeck(neck);
      return this;
    }
  }

  public TShirt build() {
    return tShirt;
  }
}
