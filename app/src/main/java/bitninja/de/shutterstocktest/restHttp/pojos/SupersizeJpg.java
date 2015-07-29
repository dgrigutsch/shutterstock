package bitninja.de.shutterstocktest.restHttp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dgrigutsch on 28.07.15.
 */
public class SupersizeJpg {

    @SerializedName("display_name")
    @Expose
    private String displayName;
    @Expose
    private Integer dpi;
    @SerializedName("file_size")
    @Expose
    private Integer fileSize;
    @Expose
    private String format;
    @Expose
    private Integer height;
    @SerializedName("is_licensable")
    @Expose
    private Boolean isLicensable;
    @Expose
    private Integer width;

    /**
     *
     * @return
     * The displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     *
     * @param displayName
     * The display_name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     *
     * @return
     * The dpi
     */
    public Integer getDpi() {
        return dpi;
    }

    /**
     *
     * @param dpi
     * The dpi
     */
    public void setDpi(Integer dpi) {
        this.dpi = dpi;
    }

    /**
     *
     * @return
     * The fileSize
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     *
     * @param fileSize
     * The file_size
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     *
     * @return
     * The format
     */
    public String getFormat() {
        return format;
    }

    /**
     *
     * @param format
     * The format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     *
     * @return
     * The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The isLicensable
     */
    public Boolean getIsLicensable() {
        return isLicensable;
    }

    /**
     *
     * @param isLicensable
     * The is_licensable
     */
    public void setIsLicensable(Boolean isLicensable) {
        this.isLicensable = isLicensable;
    }

    /**
     *
     * @return
     * The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

}
