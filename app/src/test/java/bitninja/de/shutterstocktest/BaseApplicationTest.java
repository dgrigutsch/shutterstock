package bitninja.de.shutterstocktest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import bitninja.de.shutterstocktest.BaseApplication;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21, manifest = "src/main/AndroidManifest.xml")
public class BaseApplicationTest {

    private BaseApplication baseApplication;

    @Before
    public void setUp() {
        baseApplication = new BaseApplication();
    }

    @Test
    public void testSomething() {
        assertNotNull(baseApplication.gsonFactory());
    }

}