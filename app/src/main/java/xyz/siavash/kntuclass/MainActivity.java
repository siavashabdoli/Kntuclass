package xyz.siavash.kntuclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.siavash.kntuclass.model.Show;
import xyz.siavash.kntuclass.model.ShowItem;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";
  private TextView tvHelloWorld;
  private EditText etUserInput;
  private ImageView goodsImage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    goodsImage = findViewById(R.id.image_view_goods);
    Glide.with(this).load("https://dkstatics-public.digikala.com/digikala-products/631659.jpg?x-oss-process=image/resize,m_lfit,h_600,w_600/quality,q_80")
        .into(goodsImage);

    tvHelloWorld = findViewById(R.id.textview1);
    etUserInput = findViewById(R.id.main_et_title);
    Button submitBtn = findViewById(R.id.submit_btn);
    submitBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        tvHelloWorld.setText(etUserInput.getText().toString());
      }
    });
    TvMazeService tvMazeService = ApiProvider.getInstance().getTvMazeService();
    tvMazeService.searchMovie("Batman").enqueue(new Callback<List<ShowItem>>() {
      @Override
      public void onResponse(Call<List<ShowItem>> call, Response<List<ShowItem>> response) {
        if(response.isSuccessful()) {
          response.body().get(0);
        } else {
          Toast.makeText(MainActivity.this,"error occurred", Toast.LENGTH_LONG).show();
        }
      }

      @Override
      public void onFailure(Call<List<ShowItem>> call, Throwable t) {
        Toast.makeText(MainActivity.this,"error occurred", Toast.LENGTH_LONG).show();
      }
    });

  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(TAG, "onResume() called");
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d(TAG, "onStart() called");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(TAG, "onPause() called");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(TAG, "onStop() called");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "onDestroy() called");
  }
}
