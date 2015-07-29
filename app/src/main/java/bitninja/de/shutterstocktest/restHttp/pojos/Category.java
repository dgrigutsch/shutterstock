package bitninja.de.shutterstocktest.restHttp.pojos;

import com.google.gson.annotations.Expose;

/**
 * Created by dgrigutsch on 28.07.15.
 */
public class Category {

    @Expose
    private String id;
    @Expose
    private String name;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

}