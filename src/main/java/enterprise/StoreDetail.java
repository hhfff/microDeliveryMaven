package enterprise;

import enterprise.Entity.Cart;
import enterprise.Entity.Item;
import enterprise.Entity.StoreDao;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Named
@SessionScoped
public class StoreDetail implements Serializable{
    private Cart cart=new Cart();
    private String totalPrice;


    private List<Item> storeItems;


    public void loadStoreItem(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        String storeId = request.getParameter("storeId");
        Logger log= Logger.getLogger("xx");
        log.log(Level.INFO,storeId+"size");
        if(storeId!=null) storeItems =StoreDao.getAllItem(Integer.parseInt(storeId));


    }
    //cart
    public void addToCart(Item item){


        cart.addToCart(item);
    }

    public String getTotalPrice() {
        return cart.getTotalPrice()+"";
    }

    public void setTotalPrice(String totalPrice) {

        this.totalPrice = totalPrice;
    }



    public List<Item> getStoreItems() {
        return storeItems;
    }

    public void setStoreItems(List<Item> storeStoreItems) {
        this.storeItems = storeStoreItems;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
