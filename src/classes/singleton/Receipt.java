package classes.singleton;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
  private int id;
  private String name;
  List<Object> items = new ArrayList<>();

  public Receipt() {
  }

  public Receipt(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public void addToReceipt(Object object) {
    items.add(object);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Object> getItems() {
    return items;
  }
}