package bitninja.de.shutterstocktest.restHttp;

import bitninja.de.shutterstocktest.restHttp.pojos.ImageQuery;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by dgrigutsch on 28.07.15.
 */
public interface ImageService {

    @GET("/images/search")
    public void searchImages(@Query("query") String query, @Query("page") int pageNumber, Callback<ImageQuery> cb);


}
