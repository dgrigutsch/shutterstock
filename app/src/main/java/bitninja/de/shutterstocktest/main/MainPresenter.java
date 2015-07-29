package bitninja.de.shutterstocktest.main;

import android.util.Log;

import bitninja.de.shutterstocktest.BaseApplication;
import bitninja.de.shutterstocktest.BasePresenter;
import bitninja.de.shutterstocktest.restHttp.ImageService;
import bitninja.de.shutterstocktest.restHttp.pojos.ImageQuery;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by dgrigutsch on 28.07.15.
 */
public class MainPresenter extends BasePresenter<MainActivity> {

    private static final String TAG = MainPresenter.class.getSimpleName();
    private MainModel model;
    private int page = 1;

    public MainPresenter() {
        model = new MainModel();
    }

    public void search(String query, final PresenterCallback callback) {
        view.showLoader();
        view.getBaseApplication().createServiceWithBasicAuth(ImageService.class)
                .searchImages(query,page, new Callback<ImageQuery>() {
                    @Override
                    public void success(ImageQuery s, Response response) {
                        model.setImageQuery(s);
                        callback.updateData(model);
                        view.hideLoader();
                        page++;
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.e(TAG,error.toString());
                        view.hideLoader();
                    }
                }
        );
    }

    interface PresenterCallback {
        void updateData(MainModel model);
    }
}
