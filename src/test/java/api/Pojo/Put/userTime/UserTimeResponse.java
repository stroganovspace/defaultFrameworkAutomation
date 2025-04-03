package api.Pojo.Put.userTime;

public class UserTimeResponse extends UserTime {

  private String updatedAt;

  public UserTimeResponse(String name, String job, String updatedAt) {
    super(name, job);
    this.updatedAt = updatedAt;
  }

  public UserTimeResponse() {
    super(null, null);
  }

  public String getUpdatedAt() {
    return updatedAt;
  }
}