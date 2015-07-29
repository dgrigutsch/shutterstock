package bitninja.de.shutterstocktest;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.View;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<T> implements Presenter<T> {
    protected T view;
    @Override public void bindView(T view) { this.view = view; }
    @Override public void unbindView() { this.view = null; }
    @Override public void onDestroy() {};
    public T getView(){return view;}
}

