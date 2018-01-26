package enterprise;

import enterprise.Entity.StoreDao;
import enterprise.Entity.Item;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named("enterpriseMain")
@SessionScoped
public class Main implements Serializable{
    private List<Item> itemList;
    private Item selectItem;
    private boolean firstTimeCall=true;


    public Item getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(Item selectItem) {
        this.selectItem = selectItem;
    }

    public Main(){


    }

    public void load(){
        StoreDao e=new StoreDao();
        //itemList=e.getAllItem();


    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    public void update(){
        StoreDao dao=new StoreDao();

        dao.update(selectItem);


    }
    public void deleteItem(){

        itemList.remove(selectItem);

        StoreDao dao=new StoreDao();

        dao.deleteItem(selectItem);
            //load();


       //


    }
    public void newItem(){

    }
    private String s;
    public String getS(){
        return itemList.size()+"";
    }

}
