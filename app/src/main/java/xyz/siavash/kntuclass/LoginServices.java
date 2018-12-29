package xyz.siavash.kntuclass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginServices {
  @POST("/login")
  Call<MessageCall> user (@Query("name") String name, @Body User user);
}
