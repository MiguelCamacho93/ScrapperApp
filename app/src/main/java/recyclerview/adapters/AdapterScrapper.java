package recyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.camacho.scrapperapp.R;

import models.ModelRecyclerViewScrapper;
import recyclerview.viewholders.RowHolderScrapper;

/**
 * Created by slaye on 26/07/2017.
 */

public class AdapterScrapper extends RecyclerView.Adapter<RowHolderScrapper> {
    ModelRecyclerViewScrapper modelScrapper;
    Context context;

    public AdapterScrapper(ModelRecyclerViewScrapper modelScrapper, Context context) {
        this.modelScrapper = modelScrapper;
        this.context = context;
    }

    @Override
    public RowHolderScrapper onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_adapter_scrapper, null);
        RowHolderScrapper rowHolderScrapper = new RowHolderScrapper(view);

        return rowHolderScrapper;
    }

    @Override
    public void onBindViewHolder(RowHolderScrapper holder, int position) {
        holder.tvText.setText(modelScrapper.getText());
        holder.tvTitle.setText(modelScrapper.getTitle());
        holder.tvLink.setText(modelScrapper.getLink());
        Glide.with(context)
                .load(modelScrapper.getThumbnailUrl())
                .centerCrop()
                .into(holder.webThumbnail);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
