package service;

import api.ProductService;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceTest {



    @Test
    public void testGetAllProductsPositive() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(10L, "Adidas", 100, 5, "Brown", 5, "XL", "Cotton"));
        products.add(new Boots(20L, "Nike", 200, 10, "Black", 2, 45, true));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productService.getAllProducts();

        //expected
        Assert.assertEquals(products, productsFromTestClass);
    }

    @Test
    public void testGetAllProductsNegative() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(10L, "Adidas", 100, 5, "Brown", 5, "XL", "Cotton"));
        products.add(new Boots(20L, "Nike", 200, 10, "Black", 2, 45, true));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(new ArrayList<Product>(products));
        products.add(new Cloth(31L, "Spodnie", 44, 0, "White", 3, "S", "COTTON"));
        List<Product> listFromTestClass = productService.getAllProducts();

        //expected
        Assert.assertNotEquals(products, listFromTestClass);
    }

    @Test
    public void testGetCountProductsWithProducts() {
        //is
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(10L, "Adidas", 100, 5, "Brown", 5, "XL", "Cotton"));
        products.add(new Boots(20L, "Nike", 200, 10, "Black", 2, 45, true));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.getCountProducts();

        //expected
        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetCountProductsWithoutProducs() {
        //is
        List<Product> products = new ArrayList<Product>();

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.getCountProducts();

        //expected
        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetProductsByName() {
        //is
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(10L, "T-SHIRT", 35, 3, "Black", 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(25L, "Nike", 250, 5, "Brown", 13, 45, true));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("T-SHIRT");

        //expected
        Assert.assertEquals(cloth, product);
    }

    @Test
    public void testGetProductByProductNameWhenNoExist() {
        //is
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(35L, "T-SHIRT", 35, 3, "Black", 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(21L, "Boots", 35, 5, "Black", 4, 38, true));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product product = productService.getProductByProductName("JAKIS-PRODUKT");

        //expected
        Assert.assertEquals(null, product);
    }

    @Test
    public void testIsProductOnWareHouseWhenIs() {
        //is
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(35L, "T-SHIRT", 35, 3, "Black", 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(21L, "Boots", 35, 5, "Black", 4, 38, true));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWareHouse = productService.isProductOnWarehouse("T-SHIRT");

        //expected
        Assert.assertTrue(isProductOnWareHouse);
    }

    @Test
    public void testIsProductOnWareHouseWhenIsNot() {
        //is
        List<Product> products = new ArrayList<Product>();
        Product cloth = new Cloth(35l, "T-SHIRT", 35, 3, "Black", 4, "XL", "COTTON");
        products.add(cloth);
        products.add(new Boots(21L, "Boots", 35, 5, "Black", 4, 38, true));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductOnWareHouse = productService.isProductOnWarehouse("Supreme");

        //expected
        Assert.assertFalse(isProductOnWareHouse);
    }

    @Test
    public void testIsProductExistByNameWhenExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(21l, "Boots", 35, 1, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist("Boots");

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByNameWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(21l, "Boots", 35, 1, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist("Inny produkt");

        Assert.assertFalse(isProductExist);
    }

    @Test
    public void testIsProductExistByIdWhenExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(2l, "Boots", 35, 2, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist(2l);

        Assert.assertTrue(isProductExist);
    }

    @Test
    public void testIsProductExistByIdWhenNoExist() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Boots(21l, "Boots", 35, 2, "Black", 0, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean isProductExist = productService.isProductExist(5l);

        Assert.assertFalse(isProductExist);
    }



}
