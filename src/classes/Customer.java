package classes;

public class Customer extends BusinessObject {
  private static int nextId = 1;
  private String address;
  private String eMail;

  public Customer() {
  }

  public Customer(String name, String address, String eMail) {
    super(getNextId(), name);
    this.address = address;
    this.eMail = eMail;
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

  public static int getNextId() {
    return nextId++;
  }

  public static void setNextId(int nextId) {
    Customer.nextId = nextId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String geteMail() {
    return eMail;
  }

  public void seteMail(String eMail) {
    this.eMail = eMail;
  }
}
