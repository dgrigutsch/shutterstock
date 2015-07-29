package bitninja.de.shutterstocktest.restHttp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dgrigutsch on 28.07.15.
 */
public class ImageQuery {
    @Expose
    private Integer page;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("search_id")
    @Expose
    private String searchId;
    @Expose
    private List<ImageData> data = new ArrayList<>();

    /**
     *
     * @return
     * The page
     */
    public Integer getPage() {
        return page;
    }

    /**
     *
     * @param page
     * The page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     *
     * @return
     * The perPage
     */
    public Integer getPerPage() {
        return perPage;
    }

    /**
     *
     * @param perPage
     * The per_page
     */
    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    /**
     *
     * @return
     * The totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     *
     * @param totalCount
     * The total_count
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     *
     * @return
     * The searchId
     */
    public String getSearchId() {
        return searchId;
    }

    /**
     *
     * @param searchId
     * The search_id
     */
    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    /**
     *
     * @return
     * The data
     */
    public List<ImageData> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<ImageData> data) {
        this.data = data;
    }

}