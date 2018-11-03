package xyz.siavash.kntuclass;

public class GoodsItem {
  private String price;
  private String priceWithDiscount;
  private String title;
  private String url;

  public GoodsItem(String price, String priceWithDiscount, String title, String url) {
    this.price = price;
    this.priceWithDiscount = priceWithDiscount;
    this.title = title;
    this.url = url;
  }

  public String getPrice() {
    return price;
  }

  public String getPriceWithDiscount() {
    return priceWithDiscount;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }
}
