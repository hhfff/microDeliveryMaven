package enterprise.Entity;


import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Named
@Table(name = "orderItem")
public class OrderItem {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "itemId")
    private int itemId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "orderId")
    private int orderId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
