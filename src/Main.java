import classes.Customer;
import classes.Pants;
import classes.Skirt;
import classes.TShirt;
import classes.builder.PantsBuilder;
import classes.builder.SkirtBuilder;
import classes.builder.TShirtBuilder;
import classes.singleton.OrderService;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    test();
  }

  public static void start() {

  }

  public static void test() {
    OrderService orderService = OrderService.getInstance();

    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("Clothes-on-Demand Store");
      if (orderService.getCustomerList().isEmpty()) {
        System.out.println("1. 📝 Register as a new Customer");
      } else {
        System.out.println("1. 📝 Register as a new Customer");
        System.out.println("2. 🔒 Login");
      }
      System.out.println("0. ❌ Exit program");

      System.out.print("Input 💬: ");
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          registerNewCustomer(sc, orderService);
          break;
        case 2:
          login(sc, orderService);
          break;
        case 0:
          System.out.println("Exiting program");
          System.exit(0);
        default:
          System.out.println("Invalid input");
      }
    }
  }

  private static void registerNewCustomer(Scanner sc, OrderService orderService) {
    System.out.println("📝 Enter your first name");
    sc.nextLine();
    System.out.print("Input 💬: ");
    String name = sc.nextLine();

    System.out.println("🏠 Enter your address");
    System.out.print("Input 💬: ");
    String address = sc.nextLine();

    System.out.println("✉️ Enter your email");
    System.out.print("Input 💬: ");
    String eMail = sc.nextLine();

    Customer newCustomer = new Customer(name, address, eMail);

    orderService.addCustomer(newCustomer);

    System.out.println("✅ Registration successful.");
    System.out.println("Your personal ID is: 🆔 " + newCustomer.getId());

  }
  private static void login(Scanner sc, OrderService orderService) {
    System.out.println("✉️ Enter email:");
    System.out.print("Input 💬: ");
    String eMail = sc.next();

    for (Customer customer : orderService.getCustomerList()) {
      if (customer.geteMail().equals(eMail)) {
        Customer loggedInCustomer = customer;
        System.out.println("✅ Login successful.");
        System.out.println("Welcome, " + loggedInCustomer.getName() + "!");
        System.out.println("Your personal ID is: 🆔 " + loggedInCustomer.getId());
        clothingMenu(sc, orderService, loggedInCustomer);
        return;
      }
    }

    System.out.println("‼️ No Customer exist with email: " + eMail);
  }

  private static void clothingMenu(Scanner sc, OrderService orderService, Customer loggedInCustomer) {

    while (true) {
      System.out.println("Clothing Menu");
      System.out.println("1. 👖 Pants");
      System.out.println("2. 👗 Skirt");
      System.out.println("3. 👕 T-Shirt");
      System.out.println("4. 🛒 Shopping Cart");
      System.out.println("5. 🧾 Receipts");
      System.out.println("6. 🔓 Log out");
      System.out.println("0. ❌ Exit program");
      System.out.print("Input 💬: ");
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          pantsMenu(sc, orderService, loggedInCustomer);
          break;
        case 2:
          skirtMenu(sc, orderService, loggedInCustomer);
          break;
        case 3:
          tShirtMenu(sc, orderService, loggedInCustomer);
          break;
        case 4:
          shoppingCartMenu(sc, orderService, loggedInCustomer);
          break;
        case 5:
          orderService.printReceipts(loggedInCustomer);
          break;
        case 6:
          loggedInCustomer = null;
          System.out.println("Logged out successfully");
          return;
        case 0:
          System.out.println("Exiting program");
          System.exit(0);
        default:
          System.out.println("Invalid choice");
      }
    }
  }
  private static void shoppingCartMenu(Scanner sc, OrderService orderService, Customer loggedInCustomer) {
    while (true) {
      System.out.println("🛒 Shopping Cart");
      orderService.printShoppingCart(loggedInCustomer);
      System.out.println();
      System.out.println("1. 📦 Order");
      System.out.println("2. ❌ Clear");
      System.out.println("6. 🔙 Back");
      System.out.print("Input 💬: ");
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          if (!orderService.getShoppingCart().isEmpty()) {
            orderService.setUpObservers();
            orderService.placeOrder(loggedInCustomer);
            return;
          } else {
            System.out.println("‼️ ShoppingCart is empty");
            System.out.println();
            break;
          }
        case 2:
            orderService.clearShoppingCart(loggedInCustomer);
            break;

        case 6:
          System.out.println();
          return;
      }
    }
  }
  private static void pantsMenu(Scanner sc, OrderService orderService, Customer loggedInCustomer) {

    boolean materialCheck = false;
    boolean sizeCheck = false;
    boolean colorCheck = false;
    boolean fitCheck = false;
    boolean lengthCheck = false;

    String material = "";
    String size = "";
    String color = "";
    String fit = "";
    String length = "";

    System.out.println("👖 Order Pants 👖");
    while (true) {
      while (!materialCheck || !sizeCheck || !colorCheck || !fitCheck || !lengthCheck) {
        if (!materialCheck) {
          System.out.println("1. Choose Material");
        }
        if (!sizeCheck) {
          System.out.println("2. Choose Size");
        }
        if (!colorCheck) {
          System.out.println("3. Choose Color");
        }
        if (!fitCheck) {
          System.out.println("4. Choose Fit");
        }
        if (!lengthCheck) {
          System.out.println("5. Choose Length");
        }
        System.out.println("6. 🔙 Back");
        System.out.print("Input 💬: ");
        int choice = sc.nextInt();

        // Inner switch
        switch (choice) {
          case 1:
            System.out.println();
            System.out.println("Pick your Material");
            System.out.println("1. Cotton");
            System.out.println("2. Jeans");
            System.out.print("Input 💬: ");
            int materialChoice = sc.nextInt();

            // Inner inner switch
            switch (materialChoice) {
              case 1:
                material = "Cotton";
                materialCheck = true;
                break;
              case 2:
                material = "Jeans";
                materialCheck = true;
                break;
              default:
                materialCheck = false;
                break;
            }
            break;

          case 2:
            System.out.println();
            System.out.println("Pick your Size");
            System.out.println("1. Medium");
            System.out.println("2. Large");
            System.out.print("Input 💬: ");
            int sizeChoice = sc.nextInt();

            // Inner inner switch
            switch (sizeChoice) {
              case 1:
                size = "M";
                sizeCheck = true;
                break;
              case 2:
                size = "L";
                sizeCheck = true;
                break;
              default:
                sizeCheck = false;
                break;
            }
            break;

          case 3:
            System.out.println();
            System.out.println("Pick your Color");
            System.out.println("1. Black");
            System.out.println("2. Blue");
            System.out.print("Input 💬: ");
            int colorChoice = sc.nextInt();

            switch (colorChoice) {
              case 1:
                color = "Black";
                colorCheck = true;
                break;
              case 2:
                color = "Blue";
                colorCheck = true;
                break;
              default:
                colorCheck = false;
                break;
            }
            break;

          case 4:
            System.out.println();
            System.out.println("Pick your Fit");
            System.out.println("1. Slim");
            System.out.println("2. Skinny");
            System.out.println("3. Baggy");
            System.out.print("Input 💬: ");
            int fitChoice = sc.nextInt();

            switch (fitChoice) {
              case 1:
                fit = "Slim";
                fitCheck = true;
                break;
              case 2:
                fit = "Skinny";
                fitCheck = true;
                break;
              case 3:
                fit = "Baggy";
                fitCheck = true;
                break;
              default:
                fitCheck = false;
                break;
            }
            break;

          case 5:
            System.out.println();
            System.out.println("Pick your Length");
            System.out.println("1. Short");
            System.out.println("2. Medium");
            System.out.println("3. Long");
            System.out.print("Input 💬: ");
            int lengthChoice = sc.nextInt();

            switch (lengthChoice) {
              case 1:
                length = "Short";
                lengthCheck = true;
                break;
              case 2:
                length = "Medium";
                lengthCheck = true;
                break;
              case 3:
                length = "Long";
                lengthCheck = true;
                break;
            }
            break;

          case 6:
            System.out.println("Going back");
            return;

        }
        if (materialCheck && sizeCheck && colorCheck && fitCheck && lengthCheck) {
          createPants(orderService, loggedInCustomer, material, size, color, fit, length);

          return;
        }
      }
    }
  }
  private static void createPants(OrderService orderService, Customer loggedInCustomer, String material, String size, String color, String fit, String length) {
    // Create Pants
    PantsBuilder pantsBuilder = new PantsBuilder();
    Pants pants = pantsBuilder
        .addId(loggedInCustomer.getId())
        .addName("Pants")
        .addSize(size)
        .addPrice(59.99)
        .addMaterial(material)
        .addColor(color)
        .addFit(fit)
        .addLength(length)
        .build();

    // Add pants to list
    orderService.addToShoppingCart(loggedInCustomer, pants);
  }
  private static void skirtMenu(Scanner sc, OrderService orderService, Customer loggedInCustomer) {

    boolean materialCheck = false;
    boolean sizeCheck = false;
    boolean colorCheck = false;
    boolean waistCheck = false;
    boolean patternCheck = false;

    String material = "";
    String size = "";
    String color = "";
    String waistLine = "";
    String pattern = "";

    System.out.println("👗 Order Skirt 👗");
    while (true) {
      while (!materialCheck || !sizeCheck || !colorCheck || !waistCheck || !patternCheck) {
        if (!materialCheck) {
          System.out.println("1. Choose Material");
        }
        if (!sizeCheck) {
          System.out.println("2. Choose Size");
        }
        if (!colorCheck) {
          System.out.println("3. Choose Color");
        }
        if (!waistCheck) {
          System.out.println("4. Choose Waistline");
        }
        if (!patternCheck) {
          System.out.println("5. Choose Pattern");
        }
        System.out.println("6. 🔙 Back");
        System.out.print("Input 💬: ");
        int choice = sc.nextInt();

        // Inner switch
        switch (choice) {
          case 1:
            System.out.println();
            System.out.println("Pick your Material");
            System.out.println("1. Cotton");
            System.out.println("2. Wool");
            System.out.print("Input 💬: ");
            int materialChoice = sc.nextInt();

            // Inner inner switch
            switch (materialChoice) {
              case 1:
                material = "Cotton";
                materialCheck = true;
                break;
              case 2:
                material = "Wool";
                materialCheck = true;
                break;
              default:
                materialCheck = false;
                break;
            }
            break;

          case 2:
            System.out.println();
            System.out.println("Pick your Size");
            System.out.println("1. Small");
            System.out.println("2. Medium");
            System.out.print("Input 💬: ");
            int sizeChoice = sc.nextInt();

            // Inner inner switch
            switch (sizeChoice) {
              case 1:
                size = "S";
                sizeCheck = true;
                break;
              case 2:
                size = "M";
                sizeCheck = true;
                break;
              default:
                sizeCheck = false;
                break;
            }
            break;

          case 3:
            System.out.println();
            System.out.println("Pick your Color");
            System.out.println("1. Green");
            System.out.println("2. Yellow");
            System.out.print("Input 💬: ");
            int colorChoice = sc.nextInt();

            switch (colorChoice) {
              case 1:
                color = "Green";
                colorCheck = true;
                break;
              case 2:
                color = "Yellow";
                colorCheck = true;
                break;
              default:
                colorCheck = false;
                break;
            }
            break;

          case 4:
            System.out.println();
            System.out.println("Pick your Waistline");
            System.out.println("1. Low");
            System.out.println("2. Medium");
            System.out.println("3. High");
            System.out.print("Input 💬: ");
            int fitChoice = sc.nextInt();

            switch (fitChoice) {
              case 1:
                waistLine = "Low";
                waistCheck = true;
                break;
              case 2:
                waistLine = "Medium";
                waistCheck = true;
                break;
              case 3:
                waistLine = "High";
                waistCheck = true;
                break;
              default:
                waistCheck = false;
                break;
            }
            break;

          case 5:
            System.out.println();
            System.out.println("Pick your Pattern");
            System.out.println("1. Checkered");
            System.out.println("2. Solid");
            System.out.println("3. Stripes");
            System.out.print("Input 💬: ");
            int lengthChoice = sc.nextInt();

            switch (lengthChoice) {
              case 1:
                pattern = "Checkered";
                patternCheck = true;
                break;
              case 2:
                pattern = "Solid";
                patternCheck = true;
                break;
              case 3:
                pattern = "Stripes";
                patternCheck = true;
                break;
            }
            break;

          case 6:
            System.out.println("Going back");
            return;

        }
        if (materialCheck && sizeCheck && colorCheck && waistCheck && patternCheck) {
          createSkirt(orderService, loggedInCustomer, material, size, color, waistLine, pattern);

          return;
        }
      }
    }
  }
  private static void createSkirt(OrderService orderService, Customer loggedInCustomer, String material, String size, String color, String waistLine, String pattern) {
    // Create Pants
    SkirtBuilder skirtBuilder = new SkirtBuilder();
    Skirt skirt = skirtBuilder
        .addId(loggedInCustomer.getId())
        .addName("Skirt")
        .addSize(size)
        .addPrice(15.99)
        .addMaterial(material)
        .addColor(color)
        .addWaistLine(waistLine)
        .addPattern(pattern)
        .build();

    // Add pants to list
    orderService.addToShoppingCart(loggedInCustomer, skirt);
  }
  private static void tShirtMenu(Scanner sc, OrderService orderService, Customer loggedInCustomer) {

    boolean materialCheck = false;
    boolean sizeCheck = false;
    boolean colorCheck = false;
    boolean sleeveCheck = false;
    boolean neckCheck = false;

    String material = "";
    String size = "";
    String color = "";
    String sleeves = "";
    String neck = "";

    System.out.println("👕 Order T-Shirt 👕");
    while (true) {
      while (!materialCheck || !sizeCheck || !colorCheck || !sleeveCheck || !neckCheck) {
        if (!materialCheck) {
          System.out.println("1. Choose Material");
        }
        if (!sizeCheck) {
          System.out.println("2. Choose Size");
        }
        if (!colorCheck) {
          System.out.println("3. Choose Color");
        }
        if (!sleeveCheck) {
          System.out.println("4. Choose Sleeves");
        }
        if (!neckCheck) {
          System.out.println("5. Choose Neck");
        }
        System.out.println("6. 🔙 Back");
        System.out.print("Input 💬: ");
        int choice = sc.nextInt();

        // Inner switch
        switch (choice) {
          case 1:
            System.out.println();
            System.out.println("Pick your Material");
            System.out.println("1. Cotton");
            System.out.println("2. Polyester");
            System.out.print("Input 💬: ");
            int materialChoice = sc.nextInt();

            // Inner inner switch
            switch (materialChoice) {
              case 1:
                material = "Cotton";
                materialCheck = true;
                break;
              case 2:
                material = "Polyester";
                materialCheck = true;
                break;
              default:
                materialCheck = false;
                break;
            }
            break;

          case 2:
            System.out.println();
            System.out.println("Pick your Size");
            System.out.println("1. Medium");
            System.out.println("2. Large");
            System.out.print("Input 💬: ");
            int sizeChoice = sc.nextInt();

            // Inner inner switch
            switch (sizeChoice) {
              case 1:
                size = "M";
                sizeCheck = true;
                break;
              case 2:
                size = "L";
                sizeCheck = true;
                break;
              default:
                sizeCheck = false;
                break;
            }
            break;

          case 3:
            System.out.println();
            System.out.println("Pick your Color");
            System.out.println("1. Black");
            System.out.println("2. White");
            System.out.print("Input 💬: ");
            int colorChoice = sc.nextInt();

            switch (colorChoice) {
              case 1:
                color = "Black";
                colorCheck = true;
                break;
              case 2:
                color = "White";
                colorCheck = true;
                break;
              default:
                colorCheck = false;
                break;
            }
            break;

          case 4:
            System.out.println();
            System.out.println("Pick your Sleeves");
            System.out.println("1. Sleeveless");
            System.out.println("2. Short");
            System.out.println("3. Long");
            System.out.print("Input 💬: ");
            int fitChoice = sc.nextInt();

            switch (fitChoice) {
              case 1:
                sleeves = "Sleeveless";
                sleeveCheck = true;
                break;
              case 2:
                sleeves = "Short";
                sleeveCheck = true;
                break;
              case 3:
                sleeves = "Long";
                sleeveCheck = true;
                break;
              default:
                sleeveCheck = false;
                break;
            }
            break;

          case 5:
            System.out.println();
            System.out.println("Pick your Neck");
            System.out.println("1. Crewneck");
            System.out.println("2. Turtleneck");
            System.out.println("3. V-Neck");
            System.out.print("Input 💬: ");
            int lengthChoice = sc.nextInt();

            switch (lengthChoice) {
              case 1:
                neck = "Crewneck";
                neckCheck = true;
                break;
              case 2:
                neck = "Turtleneck";
                neckCheck = true;
                break;
              case 3:
                neck = "V-Neck";
                neckCheck = true;
                break;
              default:
                neckCheck = false;
                break;
            }
            break;

          case 6:
            System.out.println("Going back");
            return;

        }
        if (materialCheck && sizeCheck && colorCheck && sleeveCheck && neckCheck) {
          createTShirt(orderService, loggedInCustomer, material, size, color, sleeves, neck);

          return;
        }
      }
    }
  }
  private static void createTShirt(OrderService orderService, Customer loggedInCustomer, String material, String size, String color, String sleeves, String neck) {
    // Create Pants
    TShirtBuilder tShirtBuilder = new TShirtBuilder();
    TShirt tShirt = tShirtBuilder
        .addId(loggedInCustomer.getId())
        .addName("T-Shirt")
        .addSize(size)
        .addPrice(8.49)
        .addMaterial(material)
        .addColor(color)
        .addSleeves(sleeves)
        .addNeck(neck)
        .build();

    // Add pants to list
    orderService.addToShoppingCart(loggedInCustomer, tShirt);
  }
}