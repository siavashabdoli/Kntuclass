package xyz.siavash.kntuclass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import xyz.siavash.kntuclass.model.Show;
import xyz.siavash.kntuclass.model.ShowItem;

public interface TvMazeService {
  @GET("/search/shows")
  Call<List<ShowItem>> searchMovie(@Query("q") String query);

  @GET("shows/{id}")
  Call<Show> getMovieDetail(@Path("id") String id);
}
