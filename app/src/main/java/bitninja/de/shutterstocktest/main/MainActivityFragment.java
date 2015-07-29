package bitninja.de.shutterstocktest.main;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bitninja.de.shutterstocktest.BaseActivity;
import bitninja.de.shutterstocktest.R;
import bitninja.de.shutterstocktest.listeners.OnRecyclerViewItemClickListener;
import bitninja.de.shutterstocktest.main.MainPresenter.PresenterCallback;
import bitninja.de.shutterstocktest.restHttp.pojos.ImageData;
import bitninja.de.shutterstocktest.ui.BaseRecyclerView;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String TAG = MainActivityFragment.class.getSimpleName();
    private static final String KEYWORD_IMAGE_QUERY = "cat";
    @InjectView(R.id.list)
    BaseRecyclerView recyclerView;

    private MainPresenter presenter;
    private MainImageAdapter adapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycler();
        if(getActivity() instanceof MainActivity) {
            if (presenter == null)
                presenter = ((MainActivity) getActivity()).createPresenter();
            presenter.bindView((MainActivity) getActivity());
            presenter.search(KEYWORD_IMAGE_QUERY, presenterCallback);
        }else {
            Log.e(TAG,"getActivity is not an instance of MainActivity");
        }
    }

    private PresenterCallback presenterCallback = new PresenterCallback() {
        @Override
        public void updateData(MainModel model) {
            adapter.addAll(model.getImageQuery().getData());
        }
    };

    private void setupRecycler(){
        recyclerView.setAdapter(adapter = new MainImageAdapter());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.setOnItemClickListener(new OnRecyclerViewItemClickListener<ImageData>() {
            @Override
            public void onItemClick(View view, ImageData imageData) {

            }
        });
        recyclerView.setOnEventListener(new BaseRecyclerView.EventListener() {
            @Override
            public void loadMore() {
                Log.e(TAG, "loadMore()");
                presenter.search(KEYWORD_IMAGE_QUERY, presenterCallback);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.unbindView();
    }
}
