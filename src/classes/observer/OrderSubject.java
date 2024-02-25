package classes.observer;

import java.util.ArrayList;

public class OrderSubject implements Subject {
  private String message;
  private ArrayList<Observer> observers = new ArrayList<>();

  public OrderSubject() {
  }

  public OrderSubject(String message) {
    this.message = message;
  }

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObserver() {
    for (Observer observer : observers) {
      observer.update(this);
    }
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ArrayList<Observer> getObservers() {
    return observers;
  }

  public void setObservers(ArrayList<Observer> observers) {
    this.observers = observers;
  }

  @Override
  public String toString() {
    return message;
  }
}
