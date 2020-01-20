package pers.xu.entity.base;

/**
 * @author Created by HuoXu
 */
public class Item {
    /**
     * ID
     */
    private String item_id;
    private String uid;
    /**
     * 名字
     */
    private String item_name;
    private String item_domain;
    private String item_type;
    private String last_update_time;
    private String item_description;
    private String is_del;
    private int creator;
    private int s_number;

    private Catalog menu;

    public Catalog getMenu() {
        return menu;
    }

    public void setMenu(Catalog menu) {
        this.menu = menu;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_domain() {
        return item_domain;
    }

    public void setItem_domain(String item_domain) {
        this.item_domain = item_domain;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(String last_update_time) {
        this.last_update_time = last_update_time;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public String getIs_del() {
        return is_del;
    }

    public void setIs_del(String is_del) {
        this.is_del = is_del;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public int getS_number() {
        return s_number;
    }

    public void setS_number(int s_number) {
        this.s_number = s_number;
    }
}
