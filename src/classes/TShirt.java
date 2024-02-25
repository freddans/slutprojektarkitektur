package classes;

public class TShirt extends Clothing {
  private static int nextId = 1;
  private String sleeves;
  private String neck;

  public TShirt() {
  }

  public TShirt(String name, String size, double price, String material, String color, String sleeves, String neck) {
    super(getNextId(), name, size, price, material, color);
    this.sleeves = sleeves;
    this.neck = neck;
  }

  @Override
  public int getId() {
    return super.getId();
  }

  @Override
  public void setId(int id) {
    super.setId(id);
  }

  @Override
  public String getName() {
    return super.getName();
  }

  @Override
  public void setName(String name) {
    super.setName(name);
  }

  @Override
  public String getSize() {
    return super.getSize();
  }

  @Override
  public void setSize(String size) {
    super.setSize(size);
  }

  @Override
  public double getPrice() {
    return super.getPrice();
  }

  @Override
  public void setPrice(double price) {
    super.setPrice(price);
  }

  @Override
  public String getMaterial() {
    return super.getMaterial();
  }

  @Override
  public void setMaterial(String material) {
    super.setMaterial(material);
  }

  @Override
  public String getColor() {
    return super.getColor();
  }

  @Override
  public void setColor(String color) {
    super.setColor(color);
  }

  public static int getNextId() {
    return nextId++;
  }

  public static void setNextId(int nextId) {
    TShirt.nextId = nextId;
  }

  public String getSleeves() {
    return sleeves;
  }

  public void setSleeves(String sleeves) {
    this.sleeves = sleeves;
  }

  public String getNeck() {
    return neck;
  }

  public void setNeck(String neck) {
    this.neck = neck;
  }

  @Override
  public String toString() {
    return "TShirt {size: " + this.getSize() + ", price: $" + this.getPrice() + ", material: " + this.getMaterial() + ", color: " + this.getColor() + ", sleeves: " + sleeves + ", neck: " + neck + "}";
  }
}
