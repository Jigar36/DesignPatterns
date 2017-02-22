package registrationScheduler.util;

import registrationScheduler.util.Logger.DebugLevel;

public class AllocateCourse {

	private int[] allocated = new int[7];
	private char[] course = new char[6];

	public AllocateCourse() {
		Logger.writeMessage("In AllocateCourse Constructor", DebugLevel.CONSTRUCTOR);
	}

	/**
	 * This method implements course scheduling algorithm, where courses are
	 * allocated according to preferences given and creates an instance of the
	 * course pool. It returns the allocated array which contents list of the
	 * courses which are assigned by the algorithm.
	 * 
	 * @param int[]
	 *            preference.
	 * @return int[] allocated.
	 */

	public int[] allocate(int[] prefIn) {

	
		// 1st course allocation

		/*
		 * int pref = 1; // System.out.println("size is: "+ prefIn.length); for
		 * (int i = 1; i < 8; i++) { if (prefIn[i] == pref) { CoursePool courses
		 * = CoursePool.getInstanceDC();
		 * 
		 * int retA = courses.courses(i); if (retA == 0) { allocated[1] = i;
		 * fill(1, i); // System.out.println("course allocated");
		 * 
		 * } else { i = 0; pref++; } } }
		 */

		for (int i = 1; i <= 8; i++) {
			if (i == 8) {
				i = 0;
			}

			CoursePool courses = CoursePool.getInstanceDC();

			int retA = courses.borrow(i);
			if (retA == 0) {
				allocated[1] = i;
				fill(1, i);
				break;
			}
		}

		// 2nd course allocation
		for (int i = 1; i <= 8; i++) {
			if (i == 8) {
				i = 0;

			}
			CoursePool courses = CoursePool.getInstanceDC();

			int retA = courses.borrow(i);
			if (retA == 0) {
				if (allocated[1] == i) {
					courses.returnCourse(i);
				} else {
					allocated[2] = i;
					fill(2, i);
					break;
				}
			}
		}

		// 3rd course allocation

		for (int i = 1; i <= 8; i++) {
			if (i == 8) {
				i = 0;
			}

			CoursePool courses = CoursePool.getInstanceDC();

			int retA = courses.borrow(i);

			if (retA == 0) {
				if (allocated[2] == i || allocated[1] == i) {
					courses.returnCourse(i);
				} else {
					allocated[3] = i;
					fill(3, i);
					break;
				}
			}
		}

		// 4th course allocation

		for (int i = 1; i <= 8; i++) {
			if (i == 8) {
				i = 0;
			}

			CoursePool courses = CoursePool.getInstanceDC();

			int retA = courses.borrow(i);

			if (retA == 0) {
				if (allocated[2] == i || allocated[1] == i || allocated[3] == i) {
					courses.returnCourse(i);

				} else {
					allocated[4] = i;
					fill(4, i);
					break;

				}
			}
		}

		// 5th course allocation

		for (int i = 1; i <= 8; i++) {
			if (i == 8) {
				i = 0;

			}

			CoursePool courses = CoursePool.getInstanceDC();

			int retA = courses.borrow(i);

			if (retA == 0) {
				if (allocated[2] == i || allocated[1] == i || allocated[3] == i || allocated[4] == i) {
					courses.returnCourse(i);

				} else {
					allocated[5] = i;
					fill(5, i);
					break;

				}
			}
		}

		allocated[6] = allocated[1] + allocated[2] + allocated[3] + allocated[4] + allocated[5];
		
		
		
		// System.out.println(Thread.currentThread().getName());
		/*
		 * System.out.println( course[1] + " " + course[2] + " " + course[3] +
		 * " " + course[4] + " " + course[5] + " " + allocated[6]);
		 */
		// System.out.println(" "+ allocated[1]+" + "+allocated[2]+"
		// +"+allocated[3]+" + "+allocated[4]+" + "+allocated[5]+"
		// ="+allocated[6]);

		return allocated;
	}

	public void fill(int k, int value) {
		switch (value) {
		case 1:
			course[k] = 'A';
			break;
		case 2:
			course[k] = 'B';
			break;
		case 3:
			course[k] = 'C';
			break;
		case 4:
			course[k] = 'D';
			break;
		case 5:
			course[k] = 'E';
			break;
		case 6:
			course[k] = 'F';
			break;
		case 7:
			course[k] = 'G';
			break;
		default:
			course[k] = 'N';
			break;
		}

	}

}
