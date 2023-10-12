package homeworks.test;

import org.assertj.core.api.Assertions;
import seminars.first.Shop.Product;
import seminars.first.Shop.Shop;

import java.util.*;
import java.util.stream.Collectors;

public class TestShop {

    List<Product> sampleProducts;
    Product mostExpensiveSample;
    final int productListLength = 50;


    public static void main(String[] args) {
        TestShop testShop = new TestShop();
        testShop.fillSampleProducts(testShop.productListLength);

        testShop.testShopSortProductsByPrisePositive();
        testShop.testShopSortProductsByPriseNegativeNull();
        testShop.testShopSortProductsByPriseNegativeEmpty();

        testShop.testGetMostExpensiveProductPositive();
        testShop.testGetMostExpensiveProductNegativeNull();
        testShop.testGetMostExpensiveProductNegativeEmpty();
        testShop.testGetMostExpensiveProductPositiveExtraProd();

    }

    /*Test SortProductsByPrise by comparing to sorted sample*/
    void testShopSortProductsByPrisePositive() {
        Shop shop = new Shop();
        shop.setProducts(sampleProducts);
        Assertions.assertThat(shop.sortProductsByPrice()).isEqualTo(sortedSampleProducts());
    }

    /*Test SortProductsByPrise exception when product list is empty*/
    void testShopSortProductsByPriseNegativeEmpty() {
        Shop shop = new Shop();
        shop.setProducts(new ArrayList<>());
        Assertions.assertThatThrownBy(shop::sortProductsByPrice).isInstanceOf(NoSuchElementException.class);
    }

    /*Test SortProductsByPrise exception when product list is null*/
    void testShopSortProductsByPriseNegativeNull() {
        Shop shop = new Shop();
        Assertions.assertThatThrownBy(shop::sortProductsByPrice).isInstanceOf(IllegalStateException.class);
    }

    /*Test getMostExpensiveProductNegative by comparing to most expensive sample */
    void testGetMostExpensiveProductPositive() {
        Shop shop = new Shop();
        shop.setProducts(sampleProducts);
        Assertions.assertThat(shop.getMostExpensiveProduct()).isEqualTo(mostExpensiveSample);
    }

    /*Test getMostExpensiveProductNegative by comparing costs of products*/
    void testGetMostExpensiveProductPositiveExtraProd() {
        Shop shop = new Shop();

        shop.setProducts(
                new ArrayList<>() {{
                    addAll(sampleProducts);
                    Product p = new Product();
                    p.setTitle("Double");
                    p.setCost(mostExpensiveSample.getCost() + 1);
                    add(p);
                }});

        Assertions.assertThat(shop.getMostExpensiveProduct().getCost())
                .isEqualTo(mostExpensiveSample.getCost() + 1);
    }

    /*Test getMostExpensiveProductNegative exception when product list is empty*/
    void testGetMostExpensiveProductNegativeEmpty() {
        Shop shop = new Shop();
        shop.setProducts(new ArrayList<>());
        Assertions.assertThatThrownBy(shop::getMostExpensiveProduct).isInstanceOf(NoSuchElementException.class);
    }

    /*Test getMostExpensiveProductNegative exception when product list is null*/
    void testGetMostExpensiveProductNegativeNull() {
        Shop shop = new Shop();
        Assertions.assertThatThrownBy(shop::getMostExpensiveProduct).isInstanceOf(IllegalStateException.class);
    }

    // Setup section
    void fillSampleProducts(int len) {
        Random random = new Random(12345);
        sampleProducts = new ArrayList<>();
        mostExpensiveSample = null;
        for (int i = len; i >= 0; i--) {
            Product product = new Product();
            product.setTitle(String.format("Product %d", i));
            product.setCost(10 + random.nextInt(1000));
            mostExpensiveSample = mostExpensiveSample == null ?
                    product : mostExpensiveSample.getCost() < product.getCost() ?
                    product : mostExpensiveSample;
            sampleProducts.add(product);
        }
    }

    List<Product> sortedSampleProducts() {
        return sampleProducts.stream().sorted(Comparator.comparingInt(Product::getCost)).collect(Collectors.toList());
    }
}
