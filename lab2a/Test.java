package lab2a;

public class Test {
    public static void main(String[] args) {
        Universe.addParticle(new Particle(10, 0, 0, 0));
        Universe.addParticle(new Particle(5, 1, 1, 1));
        Universe.addParticle(new Particle(8, -1, -1, -1));
        Universe.addParticle(new Particle(20, -5, 0, 3));
        Universe.addParticle(new Particle(15, -8, 45, 3));
        Universe.addParticle(new Particle(55, 3, 1, 8));
        Universe.addParticle(new Particle(28, -5, 7, -15));
        Universe.addParticle(new Particle(30, -7, 10, 36));
        System.out.println("Total particles in the universe: " + Universe.getTotalParticles());
        System.out.println(Universe.calculateAttractionForce(new Particle(35, 6, 5, 2)));
    }
}

