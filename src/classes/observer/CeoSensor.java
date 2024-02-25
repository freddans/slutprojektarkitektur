package classes.observer;

public class CeoSensor implements Observer {
  private String name;

  public CeoSensor(String name) {
    this.name = name;
  }

  @Override
  public void update(Subject subject) {
    System.out.println(name + " notified: " + subject);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
