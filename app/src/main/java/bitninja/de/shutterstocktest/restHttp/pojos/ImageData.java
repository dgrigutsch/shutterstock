package bitninja.de.shutterstocktest.restHttp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dgrigutsch on 28.07.15.
 */
public class ImageData {
    @Expose
    private String id;
    @SerializedName("added_date")
    @Expose
    private String addedDate;
    @Expose
    private Double aspect;
    @Expose
    private Assets assets;
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @Expose
    private Contributor contributor;
    @Expose
    private String description;
    @SerializedName("image_type")
    @Expose
    private String imageType;
    @SerializedName("is_adult")
    @Expose
    private Boolean isAdult;
    @SerializedName("is_illustration")
    @Expose
    private Boolean isIllustration;
    @Expose
    private List<String> keywords = new ArrayList<String>();
    @SerializedName("media_type")
    @Expose
    private String mediaType;

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
     * The addedDate
     */
    public String getAddedDate() {
        return addedDate;
    }

    /**
     *
     * @param addedDate
     * The added_date
     */
    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    /**
     *
     * @return
     * The aspect
     */
    public Double getAspect() {
        return aspect;
    }

    /**
     *
     * @param aspect
     * The aspect
     */
    public void setAspect(Double aspect) {
        this.aspect = aspect;
    }

    /**
     *
     * @return
     * The assets
     */
    public Assets getAssets() {
        return assets;
    }

    /**
     *
     * @param assets
     * The assets
     */
    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    /**
     *
     * @return
     * The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     *
     * @return
     * The contributor
     */
    public Contributor getContributor() {
        return contributor;
    }

    /**
     *
     * @param contributor
     * The contributor
     */
    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The imageType
     */
    public String getImageType() {
        return imageType;
    }

    /**
     *
     * @param imageType
     * The image_type
     */
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    /**
     *
     * @return
     * The isAdult
     */
    public Boolean getIsAdult() {
        return isAdult;
    }

    /**
     *
     * @param isAdult
     * The is_adult
     */
    public void setIsAdult(Boolean isAdult) {
        this.isAdult = isAdult;
    }

    /**
     *
     * @return
     * The isIllustration
     */
    public Boolean getIsIllustration() {
        return isIllustration;
    }

    /**
     *
     * @param isIllustration
     * The is_illustration
     */
    public void setIsIllustration(Boolean isIllustration) {
        this.isIllustration = isIllustration;
    }

    /**
     *
     * @return
     * The keywords
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     *
     * @param keywords
     * The keywords
     */
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     *
     * @return
     * The mediaType
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     *
     * @param mediaType
     * The media_type
     */
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

}