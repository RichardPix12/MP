package uo.mp.util.checks;

public class ArgumentChecks {

	public static void isTrue(boolean b) {
		if ( b == true) return;
		throw new IllegalArgumentException("Condition not met");
	}
	
	public static void isNotNull(Object o) {
		if ( o == null) 
		throw new IllegalArgumentException("Parámetro null");
	}
}
