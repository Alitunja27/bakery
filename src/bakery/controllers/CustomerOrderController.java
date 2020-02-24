package bakery.controllers;

import bakery.repositories.CustomerOrderRepository;
import bakery.services.CustomerOrderService;

import java.util.Scanner;

public class CustomerOrderController {

    public static void userRequirement (){
        boolean verification = false;
        String productOption = new String();
        while (verification != true) {
            System.out.println("What would you like to order? Vegemite Scroll (VS5), Blueberry Muffin (MB11) or Croissant (CF)");
            productOption = new Scanner(System.in).nextLine();
            if (productOption.equalsIgnoreCase("VS5") || productOption.equalsIgnoreCase("MB11") || productOption.equalsIgnoreCase("CF")) {
                verification = true;
            } else {
                System.out.println("Sorry, this is not a possible option, try again.");
            }
        }
        System.out.println("How many do you want?");
        Integer productQuantity = new Scanner(System.in).nextInt();

        CustomerOrderRepository.addingValue();
        CustomerOrderService.sortOrder(productOption, productQuantity);
    }

}
