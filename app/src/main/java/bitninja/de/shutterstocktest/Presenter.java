package bitninja.de.shutterstocktest;

/**
 * Created by dgrigutsch on 28.07.15.
 */
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface Presenter<T> {
    void onDestroy();
    void bindView(T view);
    void unbindView();
}