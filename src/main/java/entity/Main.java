package entity;

public class Main {

    public static void main(String[] args){

        User user = new User(1, "admin", "admin");
        System.out.println(user.toString());

        Product product = new Product((long) 1, "Supreme", 100, 85, "Black", 5);
        System.out.println(product.toString());

        Boots boots = new Boots((long) 2, "Adidas", 150, 50, "Brown", 2,
                45, true);
        System.out.println(boots.toString());

        Cloth cloth = new Cloth((long) 3, "Nike", 200, 90, "Orange", 3,
                "XL", "Cotton");
        System.out.println(cloth.toString());

        product.setPrice(200);
        System.out.println(product.toString());

        boots.setProductCount(10);
        System.out.println(boots.toString());
    }
}
