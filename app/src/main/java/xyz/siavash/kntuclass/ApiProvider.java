package xyz.siavash.kntuclass;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {
  private static ApiProvider ourInstance;
  private static Object lock;
  private final TvMazeService tvMazeService;

  public static ApiProvider getInstance() {
    if(ourInstance == null) {
      synchronized (lock) {
        if (ourInstance == null) {
          ourInstance = new ApiProvider();
        }
      }
    }
    return ourInstance;
  }

  private ApiProvider() {
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .build();
    Gson gson = new Gson();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(" http://api.tvmaze.com")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build();

    tvMazeService = retrofit.create(TvMazeService.class);

  }

  public TvMazeService getTvMazeService() {
    return tvMazeService;
  }
}
