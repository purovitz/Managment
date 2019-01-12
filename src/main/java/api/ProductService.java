package api;

import entity.Product;

import java.util.List;

public interface ProductService {

    //metoda odpowiedzialna za zwrocenie wszystkich products
    List<Product> getAllProducts();
    //metoda odpowiedzialna za zwrocenie ilosci produktow na liscie
    Integer getCountProducts();
    //metoda odpowiedzialna za zwrocenie Product poprzez productName - jezeli nie istnieje to null
    Product getProductByProductName(String productName);
    //sprawdzenie czy ilość produktu jest większa od 0 dla konkretnego productName
    boolean isProductOnWarehouse(String productName);
    //sprawdzenie czy produkt o podanym productName istnieje
    boolean isProductExist(String productName);
    //sprawdzenie czy produkt o podanym id istnieje
    boolean isProductExist(Long productId);
}
