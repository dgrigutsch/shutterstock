package bitninja.de.shutterstocktest.restHttp.pojos;

import com.google.gson.annotations.Expose;

/**
 * Created by dgrigutsch on 28.07.15.
 */
public class Contributor {

    @Expose
    private String id;

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

}