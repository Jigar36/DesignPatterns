package registrationScheduler.util;

import registrationScheduler.util.Logger.DebugLevel;

/**
 * The Class pool works as an object pool which is implemented using a singleton
 * double check locking method.
 * 
 */

class CoursePool {

	private volatile static CoursePool _instance;

	private int courseA = 60;
	private int courseB = 60;
	private int courseC = 60;
	private int courseD = 60;
	private int courseE = 60;
	private int courseF = 60;
	private int courseG = 60;

	private CoursePool() {
		Logger.writeMessage("In CoursePool Constructor", DebugLevel.CONSTRUCTOR);
	}

	public static CoursePool getInstanceDC() {
		if (_instance == null) {
			synchronized (CoursePool.class) {
				if (_instance == null) {
					_instance = new CoursePool();

				}
			}
		}
		return _instance;
	}

	/**
	 * The borrow method borrows the course if available from the courses
	 * counter.
	 * 
	 * @param int
	 *            preference.
	 * @return 1 is the course requested is available else 0.
	 */

	public int borrow(int pref) {

		switch (pref) {
		case 1:
			if (courseA != 0 && courseA >= courseB && courseA >= courseC && courseA >= courseD && courseA >= courseE
					&& courseA >= courseF && courseA >= courseG) {
				courseA--;
				return 0;
			} else {
				if (courseA == 0) {
					// System.out.println("Course A is filled...!");
				}
				return 1;
			}

		case 2:
			if (courseB != 0 && courseB >= courseA && courseB >= courseC && courseB >= courseD && courseB >= courseE
					&& courseB >= courseF && courseB >= courseG) {
				courseB--;
				return 0;
			} else {
				if (courseB == 0) {
					// System.out.println("Course B is filled...!");
				}
				return 1;
			}

		case 3:
			if (courseC != 0 && courseC >= courseB && courseC >= courseA && courseC >= courseD && courseC >= courseE
					&& courseC >= courseF && courseC >= courseG) {
				courseC--;
				return 0;
			} else {
				if (courseC == 0) {
					// System.out.println("Course C is filled...!");
				}
				return 1;
			}

		case 4:
			if (courseD != 0 && courseD >= courseB && courseD >= courseC && courseD >= courseA && courseD >= courseE
					&& courseD >= courseF && courseD >= courseG) {
				courseD--;
				return 0;
			} else {
				if (courseD == 0) {
					// System.out.println("Course D is filled...!");
				}
				return 1;
			}
		case 5:
			if (courseE != 0 && courseE >= courseA && courseE >= courseB && courseE >= courseC && courseE >= courseD
					&& courseE >= courseF && courseE >= courseG) {
				courseE--;
				return 0;
			} else {
				if (courseE == 0) {
					// System.out.println("CourseE is filled...!");
				}
				return 1;
			}

		case 6:
			if (courseF != 0 && courseF >= courseA && courseF >= courseB && courseF >= courseC && courseF >= courseD
					&& courseF >= courseE && courseF >= courseG) {
				courseF--;
				return 0;
			} else {
				if (courseF == 0) {
					// System.out.println("Course F is filled...!");
				}
				return 1;
			}

		case 7:
			if (courseG != 0 && courseG >= courseB && courseG >= courseA && courseG >= courseD && courseG >= courseC
					&& courseG >= courseE && courseG >= courseF) {
				courseG--;
				return 0;
			} else {
				if (courseG == 0) {
					// System.out.println("Course G is filled...!");
				}
				return 1;
			}

		}
		return -1;

	}

	/**
	 * The returnCourse method return's the courses i.e it increments the
	 * counter if the courses requested is already been assigned to the student
	 * from the algorithm.
	 * 
	 * @param int courseIndex.
	 * @return Nothing.
	 */

	public void returnCourse(int courseIndex) {
		switch (courseIndex) {

		case 1:
			courseA++;
			break;
		case 2:
			courseB++;
			break;
		case 3:
			courseC++;
			break;
		case 4:
			courseD++;
			break;
		case 5:
			courseE++;
			break;
		case 6:
			courseF++;
			break;
		case 7:
			courseG++;
			break;
		default:
			break;

		}

	}

	public String remainingCourses() {
		return "CoursePool [courseA=" + courseA + ", courseB=" + courseB + ", courseC=" + courseC + ", courseD="
				+ courseD + ", courseE=" + courseE + ", courseF=" + courseF + ", courseG=" + courseG + "]";

	}

	public int getNumberActive() {

		return Thread.activeCount() - 1;
	}

}
