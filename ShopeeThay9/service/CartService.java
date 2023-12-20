package service;

import entity.Cart;
import entity.CartLineItem;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CartService {

    private static List<Cart> cartList = new ArrayList<>();

    private static ProductService productService = new ProductService();

    static {
        cartList.add(new Cart(1, new ArrayList<>(), 0));
        cartList.add(new Cart(2, new ArrayList<>(), 0));
        cartList.add(new Cart(3, new ArrayList<>(), 0));
        cartList.add(new Cart(4, new ArrayList<>(), 0));
    }

    public Cart addToCart(int customerId, Integer productId, int quantity) {
        Cart currentCart = findCartByCustomerId(customerId);
        List<CartLineItem> cartLineItemList = currentCart.getCartLineItemList();

        Product product = productService.getById(productId);
        long subTotalPrice = product.getPrice() * quantity;
        cartLineItemList.add(new CartLineItem(productId, quantity, subTotalPrice));

        return currentCart;

    }

    private Cart findCartByCustomerId(int customerId) {
        for(Cart element : cartList){
            if(element.getCustomerId() == customerId){
                return element;
            }
        }
        return null;
    }
}
