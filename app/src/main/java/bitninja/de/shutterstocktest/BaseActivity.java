package bitninja.de.shutterstocktest;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by dgrigutsch on 28.07.15.
 */
public abstract class BaseActivity<T> extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Optional
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    public abstract T createPresenter();

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        injectViews();
    }

    public BaseApplication getBaseApplication() {
        if(!(getApplication() instanceof BaseApplication))
            Log.e(TAG,"getApplicatin is not an instance of "+BaseApplication.class.getSimpleName());
        return (BaseApplication) getApplication();
    }

    protected void injectViews() {
        ButterKnife.inject(this);
        setupToolbar();
    }

    protected void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    public Toolbar getToolbar(){
        return toolbar;
    }

}
