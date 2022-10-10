class Point4 {
    int x, y;
    public Point4(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class ObjectPropertyEx {
    public static void print(Object obj) {
        System.out.println(obj.getClass().getName());
        System.out.println(obj.hashCode());
        System.out.println(obj.toString());
        System.out.println(obj);
    }
    public static void main(String [] args) {
        Point4 p = new Point4(2,3);
        print(p);
    }
}