package bitninja.de.shutterstocktest;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.Date;

import bitninja.de.shutterstocktest.utils.SharedPreferenceManager;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by dgrigutsch on 28.07.15.
 */
public class BaseApplication extends Application {

    private static final String TAG = BaseApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        setupPicasso();
    }

    public SharedPreferenceManager getSharedPreferenceManager(){
        return new SharedPreferenceManager(this);
    }

    public <S> S createService(Class<S> serviceClass, String baseUrl) {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(baseUrl)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(new OkHttpClient()));

        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }

    public <S> S createServiceWithBasicAuth(Class<S> serviceClass) {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(getString(R.string.baseUrl))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(new OkHttpClient()));

        builder.setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade requestFacade) {
                String clientID = getString(R.string.client_id);
                String auth = "Basic " + Base64.encodeToString(clientID.getBytes(), Base64.NO_WRAP);
                requestFacade.addHeader("Authorization", auth);
            }
        });
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }

    public Gson gsonFactory() {
        return new GsonBuilder().serializeNulls()
                .create();
    }

    public void setupPicasso() {
        OkHttpClient client = new OkHttpClient();
        Picasso p = new Picasso.Builder(this)
                .memoryCache(new LruCache(this))
                .defaultBitmapConfig(Bitmap.Config.RGB_565) // adjust if color problems
                .loggingEnabled(true)
                .downloader(new OkHttpDownloader(client))
                .build();
            try {
                Picasso.setSingletonInstance(p);
            }catch (Exception e){
                Log.d(TAG,"Picassobug: ",e);
            }
        }
}
