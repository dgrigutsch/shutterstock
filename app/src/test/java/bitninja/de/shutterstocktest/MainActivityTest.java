package bitninja.de.shutterstocktest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import bitninja.de.shutterstocktest.main.MainActivity;
import bitninja.de.shutterstocktest.main.MainActivityFragment;

/**
 * Created by Bitninja on 30.07.2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21, manifest = "src/main/AndroidManifest.xml", application = BaseApplication.class)
public class MainActivityTest {

    private MainActivity activity;
    private MainActivityFragment fragment;

    @Before
    public void setup() {
        /*
            setupActivity runs the Activity lifecycle methods on the specified class
        */
        activity = Robolectric.setupActivity(MainActivity.class);
        fragment = (MainActivityFragment) activity.getSupportFragmentManager()
                .findFragmentByTag(MainActivityFragment.class.getSimpleName());

    }

    @Test
    public void testFetchAll() {
        assertNotNull(fragment);
    }


}
