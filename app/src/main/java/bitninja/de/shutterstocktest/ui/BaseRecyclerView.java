package bitninja.de.shutterstocktest.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

public class BaseRecyclerView extends RecyclerView{

    private static final String TAG = BaseRecyclerView.class.getSimpleName();
    private View emptyView;
    private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true; // True if we are still waiting for the last set of data to load.
    private int visibleThreshold = 5; // The minimum amount of items to have below your current scroll position before loading more.
    private int drawableRes = -1;
    private int current_page = 1;
    private EventListener eventListener;
    int firstVisibleItem, visibleItemCount, totalItemCount;
    private int pageSize = 20;

    public BaseRecyclerView(Context context) {
        super(context);
        init();
    }

    public BaseRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private final RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            checkIfEmpty();
        }

        @Override
        public void onItemRangeChanged(int positionStart, int itemCount) {
            super.onItemRangeChanged(positionStart, itemCount);
            checkIfEmpty();
        }

        @Override
        public void onItemRangeInserted(int positionStart, int itemCount) {
            super.onItemRangeInserted(positionStart, itemCount);
            checkIfEmpty();
        }

        @Override
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            super.onItemRangeMoved(fromPosition, toPosition, itemCount);
            checkIfEmpty();
        }

        @Override
        public void onItemRangeRemoved(int positionStart, int itemCount) {
            super.onItemRangeRemoved(positionStart, itemCount);
            checkIfEmpty();
        }
    };

    private void checkIfEmpty() {

        if (emptyView != null && getAdapter() != null) {
            final boolean emptyViewVisible = getAdapter().getItemCount() == 0;
            Log.i(TAG, "EmptyViewVisible? " + String.valueOf(emptyViewVisible));
            emptyView.setVisibility(emptyViewVisible ? View.VISIBLE : View.GONE);
            setVisibility(emptyViewVisible ? View.GONE : View.VISIBLE);
        }
    }

    public BaseRecyclerView setEmptyView(View emptyView) {
        this.emptyView = emptyView;
        checkIfEmpty();
        return this;
    }

    public BaseRecyclerView setEmptyView(int imageViewRes, int drawableRes) {
        this.emptyView = getRootView().findViewById(imageViewRes);
        this.drawableRes = drawableRes;
        if (!(emptyView instanceof ImageView))
            throw new ClassCastException("imageViewRes is not a " + ImageView.class.getSimpleName());
        Picasso.with(getContext())
                .load(drawableRes).fit().centerCrop()
                .into((ImageView) emptyView);
        checkIfEmpty();
        return this;
    }

    public boolean isLoading() {
        RecyclerView.LayoutManager mLayoutManager = getLayoutManager();
        visibleItemCount = mLayoutManager.getChildCount();
        totalItemCount = mLayoutManager.getItemCount();
        if (totalItemCount < pageSize || visibleItemCount < pageSize / 3)
            return false;
        return loading;
    }

    public int getPageSize() {
        return pageSize;
    }

    public View loadMoreView(){
        ProgressBar indeterminate = new ProgressBar(getContext());
        indeterminate.setIndeterminate(true);
        return indeterminate;
    }

    private void init() {
        addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    LinearLayoutManager lm = (LinearLayoutManager) recyclerView.getLayoutManager();
                    int totalItemCount = lm.getItemCount() - (pageSize / 3);
                    int firstVisibleItem = lm.findFirstVisibleItemPosition();
                    if (loading) {
                        if (totalItemCount > previousTotal) {
                            loading = false;
                            previousTotal = totalItemCount;
//                            layoutManager.removeViewAt(recyclerView.getAdapter().getItemCount());
                        }
                    }
                    if (!loading && (totalItemCount - visibleItemCount)
                            <= (firstVisibleItem + visibleThreshold)) {
                        current_page++;
//                        layoutManager.addView(loadMoreView());
                        eventListener.loadMore();
                        loading = true;
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                // TODO detect scroller bounce and if new messages push scroller down a bit
            }
        });
    }

    public BaseRecyclerView setOnEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
        return this;
    }

    public interface EventListener {
        void loadMore();
    }

}
