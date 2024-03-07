package letuchka1;
public class Animal {
    String species;
    boolean canRun;

    public Animal(String species, boolean canRun) {
        this.species = species;
        this.canRun = canRun;
    }

    public void runAbility() {
        if (canRun) {
            System.out.println("This animal can run");
        } else {
            System.out.println("This animal cannot run");
        }
    }
}
