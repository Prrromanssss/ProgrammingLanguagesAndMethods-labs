package lab2a;

public class Universe {
    private static final int MAX_PARTICLES = 1000; // Максимальное количество частиц
    private static Particle[] particles = new Particle[MAX_PARTICLES];
    private static int totalParticles = 0; // Текущее количество частиц во вселенной
    public static final double GRAVITATIONAL_CONSTANT = 6.67430e-11; // Гравитационная постоянная

    public static void addParticle(Particle particle) {
        if (totalParticles < MAX_PARTICLES) {
            particles[totalParticles++] = particle;
        } else {
            System.out.println("Cannot add more particles. Universe is full.");
        }
    }

    public static int getTotalParticles() {
        return totalParticles;
    }

    public static double getVectorLength(double x, double y, double z) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public static double getForceMagnitude(double m1, double m2, double r) {
        return (GRAVITATIONAL_CONSTANT * m1 * m2) / Math.pow(r, 2);

    }

    public static double calculateAttractionForce(Particle particle) {
        double totalForceX = 0.0;
        double totalForceY = 0.0;
        double totalForceZ = 0.0;
        for (int i = 0; i < totalParticles; i++) {
            Particle universeParticle = particles[i];
            if (!particle.equals(universeParticle)) {
                double deltaX = universeParticle.getX() - particle.getX();
                double deltaY = universeParticle.getY() - particle.getY();
                double deltaZ = universeParticle.getZ() - particle.getZ();
                double distance = getVectorLength(deltaX, deltaY, deltaZ);
                double forceMagnitude = getForceMagnitude(particle.getMass(), universeParticle.getMass(), distance);
                totalForceX += forceMagnitude * (deltaX / distance);
                totalForceY += forceMagnitude * (deltaY / distance);
                totalForceZ += forceMagnitude * (deltaZ / distance);
            }
        }
        return getVectorLength(totalForceX, totalForceY, totalForceZ);
    }
}