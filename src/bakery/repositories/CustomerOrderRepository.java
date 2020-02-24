package bakery.repositories;

import bakery.domain.ProductDetail;

import java.util.ArrayList;

public class CustomerOrderRepository {
    public static ArrayList<ProductDetail> productRepository = new ArrayList<>();

    public CustomerOrderRepository (ArrayList<ProductDetail> productRepository) {
        this.productRepository = productRepository;
    }

    public static void addingValue() {
        ProductDetail vegemiteScroll3 = new ProductDetail("Vegemite Scroll","VS5",3,6.99);
        ProductDetail vegemiteScroll5 = new ProductDetail("Vegemite Scroll","VS5",5,8.99);
        ProductDetail blueberryMuffin2 = new ProductDetail("Blueberry Muffin","MB11",2,9.95);
        ProductDetail blueberryMuffin3 = new ProductDetail("Blueberry Muffin","MB11",5,16.95);
        ProductDetail blueberryMuffin5 = new ProductDetail("Blueberry Muffin","MB11",8,24.95);
        ProductDetail croissant3 = new ProductDetail("Croissant","CF",3,5.95);
        ProductDetail croissant5 = new ProductDetail("Croissant","CF",5,9.95);
        ProductDetail croissant9 = new ProductDetail("Croissant","CF",9,16.95);
        productRepository.add(vegemiteScroll3);
        productRepository.add(vegemiteScroll5);
        productRepository.add(blueberryMuffin2);
        productRepository.add(blueberryMuffin3);
        productRepository.add(blueberryMuffin5);
        productRepository.add(croissant3);
        productRepository.add(croissant5);
        productRepository.add(croissant9);
    }

    public ArrayList<ProductDetail> getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ArrayList<ProductDetail> productRepository) {
        this.productRepository = productRepository;
    }


}
