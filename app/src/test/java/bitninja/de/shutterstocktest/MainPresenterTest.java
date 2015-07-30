package bitninja.de.shutterstocktest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import bitninja.de.shutterstocktest.main.MainActivity;
import bitninja.de.shutterstocktest.main.MainModel;
import bitninja.de.shutterstocktest.main.MainPresenter;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Bitninja on 30.07.2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21, manifest = "src/main/AndroidManifest.xml", application = BaseApplication.class)
public class MainPresenterTest {

    private MainPresenter presenter;
    private MainActivity view;

    @Before
    public void setup() {
        presenter = new MainPresenter();
        assertNotNull(presenter);
        view = Robolectric.setupActivity(MainActivity.class);
        presenter.bindView(view);
    }

    @Test
    public void searchImages() {
        presenter.search("cat", new MainPresenter.PresenterCallback() {
            @Override
            public void updateData(MainModel model) {
                assertNotNull(model);
                assertNotNull(model.getImageQuery().getData().get(0).getAssets().getPreview().getUrl());
            }
        });
    }

}
