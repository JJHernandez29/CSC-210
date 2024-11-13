package csc210;

public class LinearInterpolation {
	

	public static double interpolate(double x, double x0, double y0, double x1, double y1) {
		return y0 + (x - x0) * ((y1 - y0) / (x1 - x0));
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(LinearInterpolation.interpolate(5,  0,  0,  10,  10));
		System.out.println(LinearInterpolation.interpolate(2.5,  0,  0,  10,  10));
		System.out.println(LinearInterpolation.interpolate(7.5,  0,  0,  10,  10));
		System.out.println(LinearInterpolation.interpolate(0,  0,  0,  10,  10));
		System.out.println(LinearInterpolation.interpolate(10,  0,  0,  10,  10));
		
		System.out.println(LinearInterpolation.interpolate(15,  0,  0,  10,  10));
		System.out.println(LinearInterpolation.interpolate(-15,  0,  0,  10,  10));
		
		System.out.println(LinearInterpolation.interpolate(49, 0, 0, 89, 100));
		System.out.println(LinearInterpolation.interpolate(4, -10, 0, 10, 50));
		
		
		for (int i = 0; i < 100; i += 5) {
			for (int j = 0; j < 100; j += 5) {
				double yi = LinearInterpolation.interpolate(i, 0, -2,  99, 2);
				double yj = LinearInterpolation.interpolate(j,  0, -2.5,  99,  1.5);
				System.out.println(i + ", " + j + " -> " + yi + ", " + yj);
			}
		}
	}

}








