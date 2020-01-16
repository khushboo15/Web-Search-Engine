package utilities;


/**
 * 
 */


import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

/**
 * 	General Class for common and usefull methods
 * 
 * 
 * @author lavish
 *
 */
public class Util {
	
	public static boolean isPrintDebugOn = false;
	
	
	/**
	 * 
	 * 	It will print messages in the Console if the Debug switch called isPrintDebugOn is set to true.
	 * 
	 * @param valueToPrint String that wants to be printed as Debug message
	 */
	public static void printDebug(String valueToPrint) {
		if (isPrintDebugOn) {
			System.out.println(valueToPrint);
		}
	}
	
	/**
	 * 
	 * 	It will print messages in the Console if the Debug switch called isPrintDebugOn is set to true.
	 * 
	 * @param valueToPrint String that wants to be printed as Debug message
	 */
	public static void printDebug(boolean isToPrint, String valueToPrint) {
		if (isToPrint) {
			System.out.println(valueToPrint);
		}
	}

	/**
	 * 
	 * 	It will print messages in the Console if the Debug switch called isPrintDebugOn is set to true.
	 * 
	 * @param valueToPrint String that wants to be printed as Debug message
	 */
	public static void printDebug(boolean isToPrint, Object[] array) {
		if (isToPrint) {
			if (array != null ) {
				System.out.println("[");
				for(Object bucket : array) {
					if (bucket != null) {
						System.out.print(bucket + ",");	
					}
				}
				System.out.println("]");
			}
		}
	}
	
	
	/**
	 * 
	 * 	It will print messages in the Console if the Debug switch called isPrintDebugOn is set to true.
	 * 
	 * @param valueToPrint String that wants to be printed as Debug message
	 */
	public static void printDebug(boolean isToPrint, long[] array) {
		if (isToPrint) {
			if (array != null ) {
				System.out.println("[");
				for(long bucket : array) {
					System.out.print(bucket + ",");	
				}
				System.out.println("]");
			}
		}
	}
	
	
	/**
	 * 	Returns de time in Milisenconds
	 * 
	 * @return Returns de Time at the momento in Milisecond
	 */
	public static long getTimeStampMilis() {
		return System.currentTimeMillis();	
	}
	
	/**
	 * 	Returns de time in Nano
	 * 
	 * @return Returns de Time at the moment in NanoTime
	 */
	public static long getTimeNanoTime() {
		return System.nanoTime();	
	}
	
	
	/**
	 * 	Copy an Array of TYPE LONG into a new one of primitige type long
	 * 
	 * 
	 * @param arrayLong
	 * @return
	 */
	public static long[] makeCopy(Long[] arrayLong) {
		long[] newArrayLong = null;
		if (arrayLong != null) {
			newArrayLong = new long[arrayLong.length];
			for (int i=0; i<arrayLong.length ;i++) {
				newArrayLong[i] = arrayLong[i].longValue();
			}
		}
		return newArrayLong;
	}
	
	

}
