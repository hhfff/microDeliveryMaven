package enterprise;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Util {
    private String companyName="tomato inc";
}
