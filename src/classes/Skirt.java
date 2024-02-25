package classes;

public class Skirt extends Clothing {
  private static int nextId = 1;
  private String waistLine;
  private String pattern;

  public Skirt() {
  }

  public Skirt(String name, String size, double price, String material, String color, String waistLine, String pattern) {
    super(getNextId(), name, size, price, material, color);
    this.waistLine = waistLine;
    this.pattern = pattern;
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
    Skirt.nextId = nextId;
  }

  public String getWaistLine() {
    return waistLine;
  }

  public void setWaistLine(String waistLine) {
    this.waistLine = waistLine;
  }

  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  @Override
  public String toString() {
    return "Skirt {size: " + this.getSize() + ", price: $" + this.getPrice() + ", material: " + this.getMaterial() + ", color: " + this.getColor() + ", waistline: " + waistLine + ", pattern: " + pattern + "}";
  }
}
