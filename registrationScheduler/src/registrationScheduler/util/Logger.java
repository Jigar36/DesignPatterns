package registrationScheduler.util;

public class Logger {
	public static enum DebugLevel {
		CONSTRUCTOR, THREADRUNMETHOD, NEWENTRY, DATASTRUCTURECONTENT, AVERAGEPREFERENCESCORE
	};

	private static DebugLevel debuglevel;

	/**
	 * This is the static method set for the debug level.
	 * 
	 * @param int.
	 * @return Nothing.
	 */

	public static void setDebugValue(int debugLevelIn) {
		switch (debugLevelIn) {
		case 0: {
			debuglevel = DebugLevel.AVERAGEPREFERENCESCORE;
		}
			break;

		case 1: {
			debuglevel = DebugLevel.DATASTRUCTURECONTENT;
		}
			break;

		case 2: {
			debuglevel = DebugLevel.NEWENTRY;
		}
			break;

		case 3: {
			debuglevel = DebugLevel.THREADRUNMETHOD;
		}
			break;

		case 4: {
			debuglevel = DebugLevel.CONSTRUCTOR;
		}
			break;
		}
	}

	public static void setDebugValue(DebugLevel debugLevelIn) {
		debuglevel = debugLevelIn;
	}

	/**
	 * This method prints the message to the screen.
	 * 
	 * @param String
	 *            message and int debug level.
	 * @return Nothing.
	 */

	public static void writeMessage(String msg, DebugLevel debugLevelIn) {
		if (debugLevelIn == debuglevel)
			System.out.println(msg);
	}

	public String toString() {
		return "Debug Level is " + debuglevel;
	}
}
