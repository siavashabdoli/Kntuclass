package xyz.siavash.kntuclass;

public class ApiProvider {
  private static ApiProvider ourInstance;
  private static Object lock;

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
  }
}
