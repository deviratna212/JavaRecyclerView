package id.ac.uty.javarecyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    public void onBindViewHolder(@NonNull final MyListAdapter.ViewHolder holder, int position) {
        final DataList dataList = listData[position];
        final int image = dataList.getImageId();
        final String title = dataList.getTitle();
        final String price = dataList.getPrice();

        holder.imageView.setImageResource(image);
        holder.textTitle.setText(title);
        holder.textPrice.setText(price);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), image + "\n" + title +"\n" + price, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("image", image);
                intent.putExtra("title", title);
                intent.putExtra("price", price);
                view.getContext().startActivity(intent);

            }
        });
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
            this.cardView = itemView.findViewById(R.id.cardView);
            this.imageView = itemView.findViewById(R.id.list_img);
            this.textTitle = itemView.findViewById(R.id.list_title);
            this.textPrice = itemView.findViewById(R.id.list_price);
        }
    }
}
