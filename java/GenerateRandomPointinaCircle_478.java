import java.util.Random;

class Solution {

    private double radius;
    private double x_center;
    private double y_center;
    private Random random;
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        double radians = random.nextDouble() * 2 * Math.PI;
        double radius = this.radius * Math.sqrt(random.nextDouble());
        return new double[]{radius*Math.cos(radians)+x_center, radius*Math.sin(radians)+y_center};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */