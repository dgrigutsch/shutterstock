package bitninja.de.shutterstocktest.listeners;

import android.view.View;

/**
 * Created by dgrigutsch on 28.07.15.
 */
public interface OnRecyclerViewItemClickListener<T> {
    public void onItemClick(View view, T model);
}
