package classes;

abstract class Clothing extends BusinessObject {
  private String size;
  private double price;
  private String material;
  private String color;

  public Clothing() {
  }

  public Clothing(int id, String name) {
    super(id, name);
  }

  public Clothing(int id, String name, String size, double price, String material, String color) {
    super(id, name);
    this.size = size;
    this.price = price;
    this.material = material;
    this.color = color;
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

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
