package classes;

public class CEO extends BusinessObject {

  public CEO() {
  }

  public CEO(int id, String name) {
    super(id, name);
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
}
