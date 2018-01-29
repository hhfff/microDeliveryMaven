package enterprise;


import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class CheckOut implements Serializable{

    @Inject
    private StoreDetail storeDetail;

}
