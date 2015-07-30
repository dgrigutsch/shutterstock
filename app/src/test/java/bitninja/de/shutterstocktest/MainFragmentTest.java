package bitninja.de.shutterstocktest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import bitninja.de.shutterstocktest.main.MainActivity;
import bitninja.de.shutterstocktest.main.MainActivityFragment;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Bitninja on 30.07.2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21, manifest = "src/main/AndroidManifest.xml", application = BaseApplication.class)
public class MainFragmentTest {

    private RecyclerView recyclerView;
    private MainActivityFragment fragment;

    @Before
    public void setup() {
        fragment = new MainActivityFragment();
        startFragment( fragment );
    }

    @Test
    public void fragmentShouldNotBeNull() {
        assertNotNull(fragment);
    }

    @Test
    public void testRecyclerView() {
        recyclerView = (RecyclerView) fragment.getActivity().findViewById(R.id.list);
        assertNotNull(recyclerView);
        recyclerView.getAdapter().registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                assertTrue(recyclerView.getChildCount() == 1);
                assertTrue(recyclerView.getAdapter().getItemCount() == 1);
            }
        });

    }

    public void startFragment( Fragment fragment ) {
        FragmentActivity activity = Robolectric.setupActivity(MainActivity.class);
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragment, null);
        fragmentTransaction.commit();
    }

}
