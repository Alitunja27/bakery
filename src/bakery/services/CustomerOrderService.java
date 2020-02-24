package bakery.services;

import bakery.domain.ProductCombination;
import bakery.repositories.CustomerOrderRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerOrderService {

    public static void sortOrder(String productOption, Integer productQuantity){
        if(productOption.equalsIgnoreCase("VS5")){
            List<Integer> packList = new ArrayList<>();
            List<Double> packListPrice = new ArrayList<>();
            for (int i = 0; i < CustomerOrderRepository.productRepository.size(); i++) {
                if (CustomerOrderRepository.productRepository.get(i).getProductCode().equalsIgnoreCase("VS5")) {
                    packList.add(CustomerOrderRepository.productRepository.get(i).getProductPack());
                    packListPrice.add(CustomerOrderRepository.productRepository.get(i).getProductPrice());
                }
            }
            sortingProduct(packList,productQuantity,packListPrice,productOption);
        }
        if(productOption.equalsIgnoreCase("MB11")){
            List<Integer> packList = new ArrayList<>();
            List<Double> packListPrice = new ArrayList<>();
            for (int i = 0; i < CustomerOrderRepository.productRepository.size(); i++) {
                if (CustomerOrderRepository.productRepository.get(i).getProductCode().equalsIgnoreCase("MB11")) {
                    packList.add(CustomerOrderRepository.productRepository.get(i).getProductPack());
                    packListPrice.add(CustomerOrderRepository.productRepository.get(i).getProductPrice());
                }
            }
            sortingProduct(packList,productQuantity,packListPrice,productOption);
        }
        if(productOption.equalsIgnoreCase("CF")){
            List<Integer> packList = new ArrayList<>();
            List<Double> packListPrice = new ArrayList<>();
            for (int i = 0; i < CustomerOrderRepository.productRepository.size(); i++) {
                if (CustomerOrderRepository.productRepository.get(i).getProductCode().equalsIgnoreCase("CF")) {
                    packList.add(CustomerOrderRepository.productRepository.get(i).getProductPack());
                    packListPrice.add(CustomerOrderRepository.productRepository.get(i).getProductPrice());
                }
            }
            sortingProduct(packList,productQuantity,packListPrice,productOption);
        }
    }



    public static List<List<Integer>> packageCombination (List<Integer> productList, Integer customerOrder) {
        List<List<Integer>> packageCombinationList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(productList, 0, customerOrder, 0, temp, packageCombinationList);
        return packageCombinationList;

    }

    private static void helper(List<Integer> productList, int start, int target, int sum,
                        List<Integer> list, List<List<Integer>> result){
        if(sum>target){
            return;
        }

        if(sum==target){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<productList.size(); i++){
            list.add(productList.get(i));
            helper(productList, i, target, sum+productList.get(i), list, result);
            list.remove(list.size()-1);
        }
    }

    private static void sortingProduct (List<Integer> packList,Integer productQuantity,List<Double> packListPrice,String productOption){
        List<List<Integer>> packageCombinationList = packageCombination(packList,productQuantity);
        if (packageCombinationList.size()==0){
            System.out.println("There is no possible combination for " + productQuantity + " product quantity");
        }else {
            List<Integer> counter = new ArrayList<>();
            for(int i=0; i<packageCombinationList.size();i++){
                counter.add(packageCombinationList.get(i).size());
            }
            Integer combinationIndex = 0;
            if (packageCombinationList.size()>1){
                for(int i=1;i<counter.size();i++){
                    if(counter.get(combinationIndex)>counter.get(i)){
                        combinationIndex=i;
                    }
                }
            }
            HashMap<Integer,Integer> orderHashMap = new HashMap<>();
            for (int j=0; j<packageCombinationList.get(combinationIndex).size();j++){
                int x=0;
                for (int k=0; k<packageCombinationList.get(combinationIndex).size();k++){
                    if(packageCombinationList.get(combinationIndex).get(j) == packageCombinationList.get(combinationIndex).get(k)){
                        x=x+1;
                    }
                }
                orderHashMap.put(packageCombinationList.get(combinationIndex).get(j),x);
            }
            List<Integer> keyList = new ArrayList<Integer>(orderHashMap.keySet());
            List<Integer> valueList = new ArrayList<Integer>(orderHashMap.values());
            List<ProductCombination> finalOrderList = new ArrayList<>();
            for(int i=0;i<packList.size();i++) {
                for (int j = 0; j < keyList.size(); j++) {
                    if (packList.get(i) == keyList.get(j)){
                        Double price = packListPrice.get(i);
                        ProductCombination productCombination = new ProductCombination(keyList.get(j),valueList.get(j),price);
                        finalOrderList.add(productCombination);
                    }
                }
            }
            Double total = 0.00;
            for(int i=0;i<finalOrderList.size();i++){
                total = total + (finalOrderList.get(i).getOrderTotalPrice()*valueList.get(i));
            }
            System.out.println(productQuantity + " " + productOption.toUpperCase() + " $" + String.format("%.2f",total));
            for(int i=0;i<finalOrderList.size();i++){
                System.out.println("\t\t" + valueList.get(i) + " X " + keyList.get(i) + " $" + finalOrderList.get(i).getOrderTotalPrice());
            }

        }
    }

}
