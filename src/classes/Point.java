package classes;

public class Point {

	//private wegen Datenkapselung
	private double x,y;
	
	//getter und setter auf public
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	
	
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point() {
		this(0,0);
	}

	
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	public double distToOrig() {
		return Math.sqrt(Math.pow(this.getX(),2) + Math.pow(this.getY(),2));
	}
	
	public double distToPoint(Point p) {
		return Math.sqrt(Math.pow(this.getX()-p.getX(),2) + Math.pow(this.getY()-p.getY(),2));
	}
	
	public Point mirrorToOrigin() {
		Point p_ = new Point(this.getX()*-1, this.getY()*-1);
		return p_;
	}
	public Point mirrorToXAxis() {
		Point p_ = new Point(this.getX(), this.getY()*-1);
		return p_;
	}
	
	public Point mirrorToYAxis() {
		Point p_ = new Point(this.getX()*-1, this.getY());
		return p_;
	}
	
	
	public static void main(String[] args) {
		Point pointA = new Point(4.0, 2.0);
		System.out.println("A: " + pointA);
		Point pointB = new Point(-1.0, -1.0);
		System.out.println("B: " + pointB);
		System.out.println("Abstand A-O: " + pointA.distToOrig());
		System.out.println("Abstand B-O: " + pointB.distToOrig());
		System.out.println("Abstand A-B: "+ pointA.distToPoint(pointB));
		pointA = pointA.mirrorToOrigin();
		System.out.println("A': " + pointA);
		System.out.println("Abstand A’-B: "
		+ pointA.distToOrig());
		}
}
