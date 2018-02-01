package enterprise;

import enterprise.Entity.*;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@SessionScoped
public class StoreManagement implements Serializable{
    private int storeId=1;
    private List<Item> itemList;
    private Item selectItem;
    private boolean isNewItem=false;
    private List<Order> orders;


    public Item getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(Item selectItem) {
        this.selectItem = selectItem;
    }
    public void load(){
        int storeId=1;
        selectItem=new Item();
        itemList=StoreDao.getAllItem(storeId);
        List<Order> list=OrderDao.getAllUncompleteOrderByStore(storeId);


        orders=list;

    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void deleteItem(){

        itemList.remove(selectItem);
        StoreDao.deleteItem(selectItem);
    }
    public void resetSelectItem(ActionEvent event){
        selectItem=new Item();
        isNewItem=true;



    }
    public String saveItem(){
        if(isNewItem) {
            selectItem.setStoreId(storeId);
            StoreDao.save(selectItem);
            isNewItem=false;
        }
        else{
            StoreDao.update(selectItem);
        }
        return null;

    }

    public String update(Item item){
        selectItem=item;
        return null;
    }

    public void orderComplete(Order order){
        orders.remove(order);
        Logger logger=Logger.getLogger("xx");
        logger.log(Level.INFO,"size"+orders.size()+" "+order.getOrderId());
        OrderDao.completeOrder(order);

    }
    public void imageUpload(FileUploadEvent event) {
        Logger logger=Logger.getLogger("hefeiLogger");
        logger.log(Level.INFO,event.getFile().getFileName());
        try {

            selectItem.setPicture(IOUtils.toByteArray(event.getFile().getInputstream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
