package gson;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

public class GsonTest {


  public static void main(String[] args) {

    GsonTest gsonTest = new GsonTest();

    Gson gson = new Gson();
    User user = gsonTest.new User();

    user.userLogin("vasya").userPassword("123");

    String jsonInString = gson.toJson(user);
    System.out.println("json in string" + jsonInString);

    String jsonString = "{\"user_login\": \"vasya\", \"user_password\": \"123\"}";

    User userFromJson = gson.fromJson(jsonString, User.class);
    System.out.println("user from json " + userFromJson);

  }

  @ToString
  @Setter
  @Accessors(fluent = true)
  class User {
    @SerializedName("user_login")
    private String userLogin;
    @SerializedName("user_password")
    private String userPassword;
  }

}
