// Implements algebraic operations and the square root function without using
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
		System.out.println(plus(2,-3));   // 2 + (-3)
		System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
		System.out.println(minus(2,-7));  // 2 - (-7)
		System.out.println(times(3,4));  // 3 * 4
		System.out.println(times(-2,-2));  // 2 * 2
		System.out.println(times(2,-2));  // 2 * 2
		System.out.println(times(-2,2));  // 2 * 2
		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
		System.out.println(pow(-3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3
   		System.out.println(div(5,5));    // 5 / 5
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
		System.out.println(mod(17,5));   // 17 % 5
		System.out.println(mod(8,5));   // 8 % 5
		System.out.println(mod(120,6));  // 120 % 6
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		if (x2 < 0) {
			for(int i = 0; i < -x2; i++) {
				x1--;
			}
			return x1;
		}

		for (int i = 0; i < x2; i++)
			x1++;
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		if (x2 < 0) {
			for(int i = 0; i < -x2; i++) {
				x1++;
			}
			return x1;
		}
		for(int i = 0; i < x2; i++) {
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		boolean isNegative =false;

		//Sets numbers to their absolute value. In case x1<0 and x2<0, it makes them both positive.
		if (x1 < 0 && x2 > 0) {
			isNegative = true;
			x1 = minus(0, x1);
		} else if (x1 > 0 && x2 < 0) {
			isNegative = true;
			x2 = minus(0, x2);
		} else if (x1 < 0 && x2 < 0) {
			x1 = minus(0, x1);
			x2 = minus(0, x2);
		}


		int result = 0;
		for(int i = 0; i < x2; i++) {
			result = plus(result, x1);
		}

		if (isNegative)
			return minus(0, result);
		else
			return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int result = 1;
		for(int i = 0; i < n; i++) {
			result = times(result, x);
		}
		return result;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		// Func will throw an exception when dividing by 0. Exception handling hasn't been taught yet.
		int sign = 1;
		if (x1 < 0) {
			x1 = times(-1,x1);
			sign = times(-1,sign);
		}
		if (x2 < 0) {
			x2 = times(-1,x2);
			sign = times(-1,sign);
		}

		int result = 0;
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			result = plus(result, 1);
		}

		return times(result, sign);
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		return x1 - times(x2, div(x1, x2));
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		// Replace the following statement with your code
		for(int i = 0; i <= x; i++) {
			if (times(i, i) == x)
				return i;
			if (times(i + 1, i + 1) > x)  // important! this function will return the floor of the square root.
				return i;
		}
		return 0; //will never reach this.
	}
}