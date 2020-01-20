package name.xu.entity.base;

import java.util.List;

/**
 * @author Created by HuoXu
 */
public class Catalog {

    private String addtime;
    private String cat_id;
    private String cat_name;
    private List<Catalog> catalogs;
    private String item_id;
    private String level;
    private List<Page> pages;
    private String parent_cat_id;
    private String s_number;

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public List<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(List<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public String getParent_cat_id() {
        return parent_cat_id;
    }

    public void setParent_cat_id(String parent_cat_id) {
        this.parent_cat_id = parent_cat_id;
    }

    public String getS_number() {
        return s_number;
    }

    public void setS_number(String s_number) {
        this.s_number = s_number;
    }
}
