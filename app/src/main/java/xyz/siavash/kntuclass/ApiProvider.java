package xyz.siavash.kntuclass;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {
  private static ApiProvider ourInstance;
  private static Object lock = new Object();
  private final LoginServices tvMazeService;

  public static ApiProvider getInstance() {
    if (ourInstance == null) {
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
            .baseUrl("http://192.168.43.54:8090")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build();

    tvMazeService = retrofit.create(LoginServices.class);

  }

  public LoginServices getTvMazeService() {
    return tvMazeService;
  }
}
