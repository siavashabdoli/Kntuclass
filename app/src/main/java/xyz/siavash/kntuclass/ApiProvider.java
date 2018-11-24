package xyz.siavash.kntuclass;

class ApiProvider {
  private static final ApiProvider ourInstance = new ApiProvider();

 public static ApiProvider getInstance() {
    return ourInstance;
  }

  private ApiProvider() {
  }
}
