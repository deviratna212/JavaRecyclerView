package id.ac.uty.javarecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>  {
    private DataList[] listData;

    public MyListAdapter(DataList[] listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {
        final DataList dataList = listData[position];
        holder.imageView.setImageResource(listData[position].getImageId());
        holder.textTitle.setText(listData[position].getTitle());
        holder.textPrice.setText(listData[position].getPrice());

    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textTitle, textPrice;
        public CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cardView = (CardView) itemView.findViewById(R.id.cardView);
            this.imageView = (ImageView) itemView.findViewById(R.id.list_img);
            this.textTitle = (TextView) itemView.findViewById(R.id.list_title);
            this.textPrice = (TextView) itemView.findViewById(R.id.list_price);
        }
    }
}
