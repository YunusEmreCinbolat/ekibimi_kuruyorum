package navigation;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Named(value = "navigationBean")
@SessionScoped
public class NavigationBean implements Serializable {

    private Map<String, Boolean> pageStates;

    public NavigationBean() {

    }

    public Map<String, Boolean> getPageStates() {
        return pageStates;
    }

    public String goToPage(String page) {
        if (pageStates == null) {
            pageStates = new HashMap<>();
        } else {
            // Eğer pageStates zaten oluşturulmuşsa, mevcut zgirdileri kontrol et
            for (Map.Entry<String, Boolean> entry : pageStates.entrySet()) {
                String key = entry.getKey();
                Boolean value = entry.getValue();

                // Eğer sayfa zaten mevcutsa, durumunu güncelleme
                if (key.contains(page)) {
                  
                } 
                else{
                      pageStates.put(page, false);
                    return page;
                }
            }
        }

        // Sayfa daha önce eklenmemişse, yeni bir giriş oluşturma
        pageStates.put(page, false);
        return page;
    }

}
