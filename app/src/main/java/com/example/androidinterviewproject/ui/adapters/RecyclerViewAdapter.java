package com.example.androidinterviewproject.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.androidinterviewproject.R;
import com.example.androidinterviewproject.mvp.model.ListOfCoupons;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Recycler Adapter for showing the ExploreTabList from Explore Fragment
 */
public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {
    private final Context mContext;
    private OnItemClickListener listener;
    private String textSwitcher;
    private List<ListOfCoupons> listOfCoupons;

    public interface OnItemClickListener {
        void onItemClick(ListOfCoupons listOfCouponsItem);
    }

    public RecyclerViewAdapter(
            Context context,
            String textSwitcher,
            List<ListOfCoupons> listOfCoupons,
            OnItemClickListener listener) {
        this.textSwitcher = textSwitcher;
        this.mContext = context;
        this.listOfCoupons = listOfCoupons;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.CustomViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup, int i) {
        View view =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.available_adapter, null);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        final ListOfCoupons feedItem = listOfCoupons.get(i);

//            Render image using Picasso library
        if (feedItem.getImageURL() != null) {
            Picasso.get().load(feedItem.getImageURL())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(customViewHolder.imageView);
        }

        customViewHolder.textViewTitle.setText(feedItem.getTitle());
        customViewHolder.tvDescription.setText(feedItem.getDescription());
        String date = dateFormatter(feedItem.getRedemptionEndDate());
        customViewHolder.tvValidDate.setText(date);
        if (textSwitcher.equals("Unclip")) {
            customViewHolder.textViewClip.setText("UNCLIP");
        }
        customViewHolder.textViewClip.setOnClickListener(v ->
                listener.onItemClick(feedItem));
    }

    @Override
    public int getItemCount() {
        return listOfCoupons.size();
    }

    public String dateFormatter(String dateInString) {
        String dateStr = "";
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            // get date object relative to server/client timezone wherever it is parsed
            Date date = dateFormat.parse(dateInString);
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            dateStr = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        protected ImageView imageView;

        @BindView(R.id.tv_description)
        protected TextView tvDescription;

        @BindView(R.id.tv_valid_date)
        protected TextView tvValidDate;

        @BindView(R.id.tv_title)
        protected TextView textViewTitle;

        @BindView(R.id.tv_Clip)
        protected TextView textViewClip;


        public CustomViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
