package enterprise;

import enterprise.Entity.StoreDao;
import enterprise.Entity.Item;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@SessionScoped
public class StoreManagement implements Serializable{
    private List<Item> itemList;
    private Item selectItem;
    private boolean isNewItem=false;


    public Item getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(Item selectItem) {
        this.selectItem = selectItem;
    }
    public void load(){
        int storeId=1;
        itemList=StoreDao.getAllItem(storeId);

    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
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
            selectItem.setStoreId(1);
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
        Logger log=Logger.getLogger("xx");
        log.log(Level.INFO,"test"+ selectItem.getName());
        return null;
    }

}
