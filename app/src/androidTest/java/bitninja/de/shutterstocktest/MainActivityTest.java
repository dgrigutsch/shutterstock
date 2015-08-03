package bitninja.de.shutterstocktest;

import android.app.Instrumentation;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;

import bitninja.de.shutterstocktest.main.MainActivity;
import bitninja.de.shutterstocktest.main.MainActivityFragment;
import bitninja.de.shutterstocktest.ui.BaseRecyclerView;

/**
 * Created by Bitninja on 03.08.2015.
 */
public class MainActivityTest  extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private MainActivityFragment fragment;
    private BaseRecyclerView recyclerView;
    private Instrumentation mInstrumentation;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mInstrumentation = getInstrumentation();
        mainActivity = getActivity();
        fragment = (MainActivityFragment) getActivity().getSupportFragmentManager()
                .findFragmentByTag(MainActivityFragment.class.getSimpleName());
        recyclerView = (BaseRecyclerView) getActivity().findViewById(R.id.list);
    }

    public void testLoadsDefaultFragment() throws Exception{
        assertTrue(fragment instanceof MainActivityFragment);
    }

    public void testRecyclerView() {
        assertNotNull(recyclerView);
        assertNotNull(recyclerView.getAdapter());
    }

    public void testScrollDown() {
        Instrumentation.ActivityMonitor searchActivityMonitor =
                mInstrumentation.addMonitor(MainActivity.class.getName(),
                        null, false);

        TouchUtils.dragViewToBottom(this,mainActivity,recyclerView);
        getInstrumentation().removeMonitor(searchActivityMonitor);
    }
}
