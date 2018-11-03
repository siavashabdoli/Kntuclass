package xyz.siavash.kntuclass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
  RecyclerView recyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recycler_view);
    recyclerView = findViewById(R.id.recycler_view);
    MyAdapter myAdapter = new MyAdapter();
    recyclerView.setAdapter(myAdapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    List<GoodsItem> items = new ArrayList<>();
    for (int i = 0; i < 15; i++) {
      GoodsItem goodsItem = new GoodsItem(String.valueOf(4000 * (i + 1)),
          String.valueOf(3000 * (i + 1)) , String.format("title%s" , i),
          "https://dkstatics-public.digikala.com/digikala-products/631659.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_80");
      items.add(goodsItem);
    }
    myAdapter.updateData(items);
  }
}
