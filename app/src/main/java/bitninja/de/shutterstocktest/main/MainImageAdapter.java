package bitninja.de.shutterstocktest.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import bitninja.de.shutterstocktest.R;
import bitninja.de.shutterstocktest.listeners.OnRecyclerViewItemClickListener;
import bitninja.de.shutterstocktest.restHttp.pojos.ImageData;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainImageAdapter extends RecyclerView.Adapter<MainImageAdapter.MainImageHolder> implements View.OnClickListener {

    private List<ImageData> items;
    private OnRecyclerViewItemClickListener<ImageData> itemClickListener;

    public MainImageAdapter() {
        this.items = new ArrayList<>();
    }

    public MainImageAdapter(List<ImageData> items) {
        this.items = items;
    }

    @Override
    public MainImageHolder onCreateViewHolder(ViewGroup parent, int pos) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_item_image_row, parent, false);
        view.setOnClickListener(this);
        return new MainImageHolder(view);
    }

    @Override
    public void onBindViewHolder(MainImageHolder holder, int pos) {
        ImageData item = items.get(pos);
        Picasso.with(holder.itemView.getContext()).load(item.getAssets().getPreview().getUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(View v) {

    }

    public void addAll(List<ImageData> items) {
        int pos = getItemCount();
        for(ImageData item : items) {
            add(item,pos);
            pos++;
        }
    }

    public void add(ImageData item, int position) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(ImageData item) {
        int position = items.indexOf(item);
        items.remove(position);
        notifyItemRemoved(position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener<ImageData> listener) {
        this.itemClickListener = listener;
    }

    public static class MainImageHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.imageView)
        protected ImageView imageView;

        public MainImageHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }

}