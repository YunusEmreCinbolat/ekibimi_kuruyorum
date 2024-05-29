package navigation;



import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named(value = "navigationBean")
@ViewScoped
public class NavigationBean implements Serializable {

    private String activePage;
    private Map<String, Boolean> pageStates;

    public NavigationBean() {
        pageStates = new HashMap<>();
    }

    public Map<String, Boolean> getPageStates() {
        return pageStates;
    }

    public String goToPage(String page) {
        if (pageStates == null) {
            pageStates = new HashMap<>();
        } 

        // Gidilen sayfayı aktif yap, diğer sayfaları pasif yap
        for (Map.Entry<String, Boolean> entry : pageStates.entrySet()) {
            String key = entry.getKey();
            pageStates.put(key, key.equals(page));
        }

        return page;
    }
}