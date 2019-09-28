package extend.polymorphism.sample;

public class Simple {

  public static void main(String[] args) {

    Pet extendedCat = new Cat();
    extendedCat.doPetActions();

    if (extendedCat instanceof Cat) {
      Cat naturalCat = (Cat) extendedCat;
      naturalCat.doCatActions();
      naturalCat.doPetActions();
    }

    System.out.println("\nвызов метода doAllAction");

    Pet pet = new Tiger();
    doAllAction(pet);

    Pet pet2 = new Cat();
    doAllAction(pet2);

    Pet pet3 = new Pet();
    doAllAction(pet3);
  }

  public static void doAllAction(Pet pet) {
    if (pet instanceof Tiger) {
      Tiger tiger = (Tiger) pet;
      tiger.doTigerActions();
    }

    if (pet instanceof Cat) {
      Cat cat = (Cat) pet;
      cat.doCatActions();
    }

    pet.doPetActions();
  }

}
