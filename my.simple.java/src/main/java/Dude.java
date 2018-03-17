public class Dude {

    private String firstname;
    private int age;
    private boolean sex;

    public String getFirstname() {
        return firstname;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }

    public static Builder newEntity() {
        return new Dude().new Builder();
    }


    public class Builder {
        private Builder() {

        }

        public Builder withFirstName(String firstname) {
            Dude.this.firstname = firstname;
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
