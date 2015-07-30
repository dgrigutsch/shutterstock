package bitninja.de.shutterstocktest.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import bitninja.de.shutterstocktest.BaseActivity;
import bitninja.de.shutterstocktest.BasePresenter;
import bitninja.de.shutterstocktest.R;
import bitninja.de.shutterstocktest.listeners.OnRecyclerViewItemClickListener;
import bitninja.de.shutterstocktest.restHttp.pojos.ImageData;
import bitninja.de.shutterstocktest.restHttp.pojos.ImageQuery;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends BaseActivity<MainPresenter> {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadMainFragment();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    private void loadMainFragment(){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new MainActivityFragment(),MainActivityFragment.class.getSimpleName())
                .commit();
    }

    public void showLoader(){
        if(getToolbar()!= null){
            getToolbar().findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        }
    }
    public void hideLoader(){
        if(getToolbar()!= null){
            getToolbar().findViewById(R.id.progressBar).setVisibility(View.GONE);
        }
    }


}
