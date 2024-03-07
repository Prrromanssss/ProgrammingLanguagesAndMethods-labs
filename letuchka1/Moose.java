package letuchka1;
class Moose extends Animal {
    boolean haveHorns;

    public Moose(String species, boolean haveHorns, boolean canRun) {
        super(species, canRun);
        this.haveHorns = haveHorns;
    }

    public void moveLimbs(String action) {
        switch (action) {
            case "kick by hoof":
                System.out.println("Moose kicks by hoof");
                break;
            case "swing":
                System.out.println("Moose swings its limbs");
                break;
            case "move":
                System.out.println("Moose moves its limbs");
                break;
            default:
                System.out.println("Invalid action");
        }
    }
}