import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Dude {

  private String firstName;
  private int age;
  private boolean sex;

  public static Builder newEntity() {
    return new Dude().new Builder();
  }

  public class Builder {
    private Builder() {
    }

    public Builder withFirstName(String firstName) {
      Dude.this.firstName = firstName;
      return this;
    }

    public Builder withAge(int age) {
      Dude.this.age = age;
      return this;
    }

    public Builder withSex(boolean sex) {
      Dude.this.sex = sex;
      return this;
    }

    public Dude build() {
      return Dude.this;
    }
  }


  static Dude dude = Dude.newEntity()
          .withFirstName("Вася")
          .withAge(23)
          .withSex(true).build();

  public static void main(String[] args) {
    System.out.println(dude);
  }

}
