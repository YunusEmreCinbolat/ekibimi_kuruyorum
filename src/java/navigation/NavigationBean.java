package navigation;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named(value="navigationBean")
@SessionScoped
public class NavigationBean implements Serializable {

    private Map<String, Boolean> pageStates;

    public NavigationBean() {
       
    }

    public Map<String, Boolean> getPageStates() {
        return pageStates;
    }

    public String goToPage(String page) {
      pageStates = new HashMap<>();        // Hedef sayfayı aktif yap
        pageStates.put(page, true);
        return page;
    }
}
