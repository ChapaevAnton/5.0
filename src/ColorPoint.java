class ColorPoint extends Point {
    private int color;

    public ColorPoint(double x, double y, int color) {
        super(x, y);
        this.color = color;
    }

    public static void main(String[] args) {

        ColorPoint colorPoint= new ColorPoint(2,2,256);
        colorPoint.print();
    }

    @Override
    public void print() {
        super.print();
        System.out.print(" and color " + color);
    }
}