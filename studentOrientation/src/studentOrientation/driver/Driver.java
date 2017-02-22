package studentOrientation.driver;

import studentOrientation.builder.OrientationBuilder;
import studentOrientation.builder.OrientationBuilderInterface;
import studentOrientation.builder.Student;
import studentOrientation.builder.StudentAbstractClass;
import studentOrientation.enums.Bookstr;
import studentOrientation.enums.CampusVisit;
import studentOrientation.enums.CourseReg;
import studentOrientation.enums.DormSel;
import studentOrientation.store.Results;
import studentOrientation.store.ResultsInterface;
import studentOrientation.util.CarbonFootPrint;
import studentOrientation.util.CarbonFootPrintClass;
import studentOrientation.util.Cost;
import studentOrientation.util.CostClass;
import studentOrientation.util.Duration;
import studentOrientation.util.DurationClass;
import studentOrientation.util.Efforts;
import studentOrientation.util.EffortsClass;

/**
 * A tool for student orientation program at Binghamton University.
 * 
 */

public class Driver {

	public static void main(String[] args) {

		Duration dur = new DurationClass();
		Efforts eff = new EffortsClass();
		CarbonFootPrint co = new CarbonFootPrintClass();
		Cost cst = new CostClass();
		ResultsInterface res = new Results();

		StudentAbstractClass stud = new Student(Bookstr.UniversityBookStore.name(), CampusVisit.Walking.name(),
				DormSel.LongQueue.name(), CourseReg.SubmitForm.name(), dur, eff, co, cst, res);

		OrientationBuilderInterface build = new OrientationBuilder();
		build.construct(stud);

		res.print();

	}
}
