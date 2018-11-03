package xyz.siavash.kntuclass;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
private List<GoodsItem> items = new ArrayList<>();

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.goods_item_layout,
        viewGroup, false);
    return new MyViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
    myViewHolder.title.setText(items.get(position).getTitle());
    myViewHolder.price.setText(items.get(position).getPrice());
    myViewHolder.priceWithDiscount.setText(items.get(position).getPriceWithDiscount());
    Glide.with(myViewHolder.imageView.getContext()).load(items.get(position).getUrl())
        .into(myViewHolder.imageView);
  }

  public void updateData(List<GoodsItem> items) {
    this.items.clear();
    this.items.addAll(items);
    notifyDataSetChanged();
  }

  public void addData(List<GoodsItem> items) {
    this.items.addAll(items);
    notifyItemRangeInserted(this.items.size() - items.size(),items.size());

  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    TextView price;
    TextView priceWithDiscount;
    ImageView imageView;
    public MyViewHolder(@NonNull View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.goods_title);
      price = itemView.findViewById(R.id.price);
      priceWithDiscount = itemView.findViewById(R.id.price_with_discount);
      imageView = itemView.findViewById(R.id.image_view_goods);
    }
  }
}
