package classes.singleton;

import classes.*;
import classes.builder.PantsBuilder;
import classes.builder.SkirtBuilder;
import classes.builder.TShirtBuilder;
import classes.command.*;
import classes.observer.CeoSensor;
import classes.observer.OrderSubject;

import java.util.*;

public class OrderService {
  private static Map<Pants, PantsBuilder> pantsBuilderMap;
  private static Map<Skirt, SkirtBuilder> skirtBuilderMap;
  private static Map<TShirt, TShirtBuilder> tShirtBuilderMap;
  private static OrderService instance;
  private final List<CommandInterface> commandList;
  private Map<Integer, Map<Integer, Object>> shoppingCart;
  private Map<Integer, Integer> orderCounter;
  private List<Receipt> receiptList = new ArrayList<>();
  private List<Customer> customerList;
  private CEO ceo;
  private OrderSubject orderPlaced;
  private OrderSubject orderComplete;
  private CeoSensor ceoSensor;
  private final Processor processor;

  public OrderService() {
    this.pantsBuilderMap = new HashMap<>();
    this.skirtBuilderMap = new HashMap<>();
    this.tShirtBuilderMap = new HashMap<>();
    this.shoppingCart = new HashMap<>();
    this.orderCounter = new HashMap<>();
    this.ceo = new CEO(1, "Wigells VD");
    this.processor = new Processor();
    this.customerList = new ArrayList<>();
    this.commandList = new ArrayList<>();
  }

  public static synchronized OrderService getInstance() {
    if (instance == null) {
      instance = new OrderService();
    } else {
      instance.getInstance();
    }
    return instance;
  }

  public void addToPantsBuilderMap(Pants pants, PantsBuilder pantsBuilder) {
    pantsBuilderMap.put(pants, pantsBuilder);
  }

  public void addToSkirtBuilderMap(Skirt skirt, SkirtBuilder skirtBuilder) {
    skirtBuilderMap.put(skirt, skirtBuilder);
  }

  public void addToTShirtBuilderMap(TShirt tShirt, TShirtBuilder tShirtBuilder) {
    tShirtBuilderMap.put(tShirt, tShirtBuilder);
  }

  public void setUpObservers() {
    ceoSensor = new CeoSensor(ceo.getName());

    orderPlaced = new OrderSubject("ℹ️ item is being manufactured ℹ️");
    orderComplete = new OrderSubject("✅ item done ✅");

    orderPlaced.registerObserver(ceoSensor);
    orderComplete.registerObserver(ceoSensor);
  }

  public void placeOrder(Customer customer) {
    changeItemToCommand(customer);
    createReceipt(customer);
    addCommandToProcessor();
    sendToDecorate(customer);
    resetCommandList();
  }

  public void createReceipt(Customer customer) {
    Receipt receipt = new Receipt(customer.getId(), "receipt");
    double pantsPrice = 0;
    double tShirtPrice = 0;
    double skirtPrice = 0;
    Date theDate = new Date();

    List<Object> clothesToBeAdded = new ArrayList<>();

    Map<Integer, Object> customerShoppingCart = getShoppingCart(customer);
    if (customerShoppingCart != null) {
      for (Map.Entry<Integer, Object> entry : customerShoppingCart.entrySet()) {
        Object item = entry.getValue();
        if (item.toString().contains("Pants")) {
          Pants pants = ((Pants) item);
          clothesToBeAdded.add(pants);
          pantsPrice += pants.getPrice();

        } else if (item.toString().contains("Skirt")) {
          Skirt skirt = ((Skirt) item);
          clothesToBeAdded.add(skirt);
          skirtPrice += skirt.getPrice();

        } else if (item.toString().contains("TShirt")) {
          TShirt tShirt = ((TShirt) item);
          clothesToBeAdded.add(tShirt);
          tShirtPrice += tShirtPrice;

        }
      }
    }

    double totalPrice = pantsPrice + tShirtPrice + skirtPrice;

    receipt.addToReceipt(theDate);
    for (Object item : clothesToBeAdded) {
      receipt.addToReceipt(item);
    }
    receipt.addToReceipt("Total cost: $" + totalPrice);
    receiptList.add(receipt);
    System.out.println("🧾 Receipt created");
  }

  public void printReceipts(Customer customer) {
    double totalCost = 0;

    for (Receipt receipt : receiptList) {
      if (receipt.getId() == customer.getId()) {
        System.out.println("-------------------------------");
        List<Object> items = receipt.getItems();

        for (Object item : items) {
          if (item instanceof Date) {
            System.out.println("📅 " + item);
            System.out.println("-------------------------------");
          } else if (item instanceof Pants) {
            System.out.println("👖 " + item);
            totalCost += ((Pants) item).getPrice();
          } else if (item instanceof TShirt) {
            System.out.println("👕 " + item);
            totalCost += ((TShirt) item).getPrice();
          } else if (item instanceof Skirt) {
            System.out.println("👗 " + item);
            totalCost += ((Skirt) item).getPrice();
          }
        }
        System.out.println("💰 Total cost: $" + totalCost);
        totalCost = 0;
        System.out.println();
      }
    }

    Map<Integer, Object> customerShoppingCart = getShoppingCart(customer);
  }

  public void changeItemToCommand(Customer customer) {
    Map<Integer, Object> customerShoppingCart = getShoppingCart(customer);

    // cutcommand
    if (customerShoppingCart != null) {
      for (Map.Entry<Integer, Object> entry : customerShoppingCart.entrySet()) {
        Object item = entry.getValue();

        // Pants
        if (item instanceof Pants) {
          Pants pants = ((Pants) item);
          PantsBuilder pantsBuilder = pantsBuilderMap.get(pants);

          // ska klippas LENGTH
          CutCommand cutCommand = new CutCommand(item, pantsBuilder);
          addCutCommand(cutCommand);

          SewCommand sewCommand = new SewCommand(item, pantsBuilder);
          addSewCommand(sewCommand);

        }

        // Skirt
        if (item instanceof Skirt) {
          Skirt skirt = ((Skirt) item);
          SkirtBuilder skirtBuilder = skirtBuilderMap.get(skirt);

          CutCommand cutCommand = new CutCommand(item, skirtBuilder);
          addCutCommand(cutCommand);

          SewCommand sewCommand = new SewCommand(item, skirtBuilder);
          addSewCommand(sewCommand);

        }

        // TShirt
        if (item instanceof TShirt) {
          TShirt tShirt = ((TShirt) item);
          TShirtBuilder tShirtBuilder = tShirtBuilderMap.get(tShirt);

          CutCommand cutCommand = new CutCommand(item, tShirtBuilder);
          addCutCommand(cutCommand);

          SewCommand sewCommand = new SewCommand(item, tShirtBuilder);
          addSewCommand(sewCommand);

        }
      }
    }
  }

  public void addCutCommand(CutCommand cutCommand) {
    commandList.add(cutCommand);
  }

  public void addSewCommand(SewCommand sewCommand) {
    commandList.add(sewCommand);
  }

  public void resetCommandList() {
    commandList.clear();
  }

  public void addCommandToProcessor() {
    processor.clearCommands();

    for (CommandInterface item : commandList) {

      processor.addCommand(item);
    }
  }

  public void sendToDecorate(Customer customer) {
    orderPlaced.notifyObserver();

    processor.execute();
    orderComplete.notifyObserver();
    clearShoppingCart(customer);
  }

  public void addToShoppingCart(Customer customer, Object item) {
    int orderId = getNextOrderId(customer);
    if (shoppingCart.containsKey(customer.getId())) {
      shoppingCart.get(customer.getId()).put(orderId, item);
    } else {
      // Create new List
      Map<Integer, Object> orderMap = new HashMap<>();
      orderMap.put(orderId, item);
      shoppingCart.put(customer.getId(), orderMap);
    }
  }

  public void printShoppingCart(Customer customer) {
    double totalPrice = 0;
    int totalItems = 0;
    Map<Integer, Object> customerShoppingCart = getShoppingCart(customer);
    System.out.println(customer.getName() + "'s shopping cart: ");

    if (customerShoppingCart != null) {
      for (Map.Entry<Integer, Object> entry : customerShoppingCart.entrySet()) {
        Object item = entry.getValue();
        if (item instanceof Pants) {
          Pants pants = ((Pants) item);

          System.out.println("👖 " + pants.getName());
          totalPrice += ((Pants) item).getPrice();
          totalItems++;


        } else if (item instanceof Skirt) {
          Skirt skirt = ((Skirt) item);

          System.out.println("👗 " + skirt.getName());
          totalPrice += ((Skirt) item).getPrice();
          totalItems++;
        } else if (item instanceof TShirt) {
          TShirt tShirt = ((TShirt) item);
          System.out.println("👕 " + tShirt.getName());
          totalPrice += ((TShirt) item).getPrice();
          totalItems++;

        }
      }
      System.out.println();
      System.out.println("📦 Total items in shopping cart: " + totalItems);
      System.out.println("💰 Total price: $" + totalPrice);
    } else {
      System.out.println("Shopping cart is empty");
    }
  }

  public void clearShoppingCart(Customer customer) {
    if (shoppingCart.containsKey(customer.getId())) {
      shoppingCart.get(customer.getId()).clear();
      System.out.println("Cleared shopping cart for " + customer.getName());
    } else {
      System.out.println("Shopping cart is empty");
    }
  }

  public void addCustomer(Customer customer) {
    customerList.add(customer);
  }

  public Map<Integer, Map<Integer, Object>> getShoppingCart() {
    return shoppingCart;
  }

  public List<Customer> getCustomerList() {
    return customerList;
  }

  public Map<Integer, Object> getShoppingCart(Customer customer) {
    return shoppingCart.get(customer.getId());
  }

  private int getNextOrderId(Customer customer) {
    int orderId = orderCounter.getOrDefault(customer.getId(), 0) + 1;
    orderCounter.put(customer.getId(), orderId);
    return orderId;
  }
}