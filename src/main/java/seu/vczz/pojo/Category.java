package seu.vczz.pojo;


/**
 * CREATE by vczz on 2018/3/1
 */
public class Category {

    private int id;

    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

}
