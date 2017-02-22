package studentOrientation.builder;

public class OrientationBuilder implements OrientationBuilderInterface {

	@Override
	public void construct(StudentAbstractClass stud) {
		
		stud.BookStore();
		stud.campusTour();
		stud.dormSelect();
		stud.courseRegister();
	}
}
