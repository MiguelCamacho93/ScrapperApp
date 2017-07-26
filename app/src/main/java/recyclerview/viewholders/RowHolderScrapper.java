package recyclerview.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.camacho.scrapperapp.R;

/**
 * Created by slaye on 26/07/2017.
 */

public class RowHolderScrapper extends RecyclerView.ViewHolder {

    public TextView tvText;
    public TextView tvTitle;
    public TextView tvLink;
    public ImageView webThumbnail;

    public RowHolderScrapper(View view) {
        super(view);
        this.tvText = (TextView) view.findViewById(R.id.tvText);
        this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        this.tvLink = (TextView) view.findViewById(R.id.tvLink);
        this.webThumbnail = (ImageView) view.findViewById(R.id.webThumbnail);
    }

}
