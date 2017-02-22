package studentOrientation.builder;

import studentOrientation.activities.Books;
import studentOrientation.activities.CampusTour;
import studentOrientation.activities.CourseRegistration;
import studentOrientation.activities.DomeSelection;

public abstract class StudentAbstractClass implements Books, CampusTour, CourseRegistration, DomeSelection {

	abstract public void setString(String books, String campusTour, String Dorms, String registration);

}
