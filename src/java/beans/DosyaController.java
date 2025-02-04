package beans;

import dao.DosyaDAO;
import entity.Dosya;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "dosyaController")
@SessionScoped
public class DosyaController extends BaseController<Dosya, DosyaDAO> implements Serializable, Controller<Dosya> {

    private Dosya entity;
    private List<Dosya> list;

    @Inject
    private OgrenciController o;
    
    @EJB
    private DosyaDAO DD;
    

    private Part dosya;
    private String uploadPath = "C:\\Users\\Dell\\Desktop\\Yukle\\";

    public DosyaController() {
        super(Dosya.class, DosyaDAO.class);
    }

    @Override
    public void update() {
        try {
            System.out.println("DosyaController update method triggered.");
            InputStream in = dosya.getInputStream();
            File f = new File(uploadPath + dosya.getSubmittedFileName());
            Files.copy(in, f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Dosya d = new Dosya(o.getEntity(), uploadPath, f.getName(), dosya.getContentType());
            System.out.println(d.getOgrenci().getId() + " " + d.getFname() + " " + d.getFpath() + " " + f.getPath());
            DD.update(d);
        } catch (IOException ex) {
            Logger.getLogger(DosyaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create() {
        try {
            System.out.println("DosyaController create method triggered.");
            InputStream in = dosya.getInputStream();
            File f = new File(uploadPath + dosya.getSubmittedFileName());
            Files.copy(in, f.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Dosya d = new Dosya(o.getEntity(), uploadPath, f.getName(), dosya.getContentType());
            System.out.println(d.getOgrenci().getId() + " " + d.getFname() + " " + d.getFpath() + " " + f.getPath());
            DD.create(d);
        } catch (IOException ex) {
            Logger.getLogger(DosyaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Dosya entity) {
        DD.delete(entity);
    }

    public List<Dosya> getList() {
        if (list == null) {
            list = DD.readList(o.getEntity().getId());
        }
        return list;
    }

    public Dosya readDosya(Long id) {
        return DD.readDosya(id);
    }

    public Dosya getEntity() {
        if (this.entity == null) {
            this.entity = new Dosya();
        }
        return entity;
    }

    public String setEntity(Dosya entity) {
        this.entity = entity;
        return "/panel/dosya/dosya/DosyaGuncelle.xhtml?faces-redirect=true";
    }

    public Part getDosya() {
        return dosya;
    }

    public void setDosya(Part dosya) {
        this.dosya = dosya;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
