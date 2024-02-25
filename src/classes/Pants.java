package classes;

public class Pants extends Clothing {
  public static int nextId = 1;
  private String fit;
  private String length;

  public Pants() {
  }

  public Pants(String name, String size, double price, String material, String color, String fit, String length) {
    super(getNextId(), name, size, price, material, color);
    this.fit = fit;
    this.length = length;
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
    Pants.nextId = nextId;
  }

  public String getFit() {
    return fit;
  }

  public void setFit(String fit) {
    this.fit = fit;
  }

  public String getLength() {
    return length;
  }

  public void setLength(String length) {
    this.length = length;
  }

  @Override
  public String toString() {
    return "Pants {size: " + this.getSize() + ", price: $" + this.getPrice() + ", material: " + this.getMaterial() + ", color: " + this.getColor() + ", fit: " + fit + ", length: " + length + "}";
  }
}
