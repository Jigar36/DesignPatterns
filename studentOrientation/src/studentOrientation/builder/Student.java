package studentOrientation.builder;

import studentOrientation.store.ResultsInterface;
import studentOrientation.util.CarbonFootPrint;
import studentOrientation.util.Cost;
import studentOrientation.util.Duration;
import studentOrientation.util.Efforts;

public class Student extends StudentAbstractClass {

	private String books = null;
	private String campusTour = null;
	private String courseRegister = null;
	private String dormSelect = null;
	private int Dur = 0;
	private int effort = 0;
	private int carbonFt = 0;
	private double total_cost = 0;
	private Duration dur;
	private Efforts eff;
	private CarbonFootPrint CO;
	private ResultsInterface res;
	private Cost cst;

	public Student(String Book, String Campus, String Dorms, String Register, Duration durIn, Efforts effIn,
			CarbonFootPrint coIn, Cost cstIn, ResultsInterface resIn) {
		setString(Book, Campus, Dorms, Register);
		dur = durIn;
		eff = effIn;
		CO = coIn;
		res = resIn;
		cst = cstIn;
	}

	/**
	 * This method assigns values which is passed by driver code.
	 * 
	 * @param String
	 *            book-store choice, campus-tour choice, Dorm selection choice,
	 *            course registration choice.
	 * @return Nothing.
	 */

	@Override
	public void setString(String booksIn, String campusTourIn, String DormsIn, String registrationIn) {

		books = booksIn;
		campusTour = campusTourIn;
		dormSelect = DormsIn;
		courseRegister = registrationIn;
	}

	/**
	 * This method checks for the bookstore entered by user and as per the
	 * choice it calculates Duration, Cost, Efforts and carbon footprints. It
	 * than sends all the calculation to result class. Or exits the application
	 * if invalid choice entered.
	 * 
	 * @return Nothing.
	 */

	@Override
	public void BookStore() {
		if (books.equals("UniversityBookStore")) {
			Dur = dur.UniversityBookStoreDuration();
			effort = eff.UniversityBookStoreEfforts();
			carbonFt = CO.UniversityBookStoreCarbonFootPrint();
			total_cost = cst.UniversityBookStoreStoreCost();
			res.total(Dur, effort, carbonFt, total_cost);
		} else if (books.equals("MandoBookStore")) {
			Dur = dur.MandoBookStoreDuration();
			effort = eff.MandoBookStoreEfforts();
			carbonFt = CO.MandoBookStoreCarbonFootPrint();
			total_cost = cst.MandoBookStoreCost();
			res.total(Dur, effort, carbonFt, total_cost);
		} else {
			System.out.println("Invalid BookStore Choice, Please Try Again...!");
			System.exit(1);
		}
	}

	/**
	 * This method checks for the Campus Tour entered by user and as per the
	 * choice it calculates Duration, Cost, Efforts and carbon footprints. It
	 * than sends all the calculation to result class. Or exits the application
	 * if invalid choice entered.
	 * 
	 * @return Nothing.
	 */

	@Override
	public void campusTour() {

		if (campusTour.equals("BusRide")) {
			Dur = dur.BusRideCampuTourDuration();
			effort = eff.BusRideCampuTourEfforts();
			carbonFt = CO.BusRideCampuTourCarbonFootPrint();
			total_cost = cst.BusRideCost();

			res.total(Dur, effort, carbonFt, total_cost);
		} else if (campusTour.equals("Walking")) {
			Dur = dur.WalkingCampusTourDuration();
			effort = eff.WalkingCampusTourEfforts();
			carbonFt = CO.WalkingCampusTourCarbonFootPrint();
			total_cost = (double) cst.walkingCost();

			res.total(Dur, effort, carbonFt, total_cost);
		} else {
			System.out.println("Invalid Campus Tour Choice, Please Try Again...!");
			System.exit(1);
		}
	}

	/**
	 * This method checks for the dorm Selection entered by user and as per the
	 * choice it calculates Duration, Cost, Efforts and carbon footprints. It
	 * than sends all the calculation to result class. Or exits the application
	 * if invalid choice entered.
	 * 
	 * @return Nothing.
	 */

	@Override
	public void dormSelect() {
		if (dormSelect.equals("PlayGame")) {
			Dur = dur.GamingContestDormDuration();
			effort = eff.GamingContestDormEfforts();
			carbonFt = CO.GamingContestDormCarbonFootPrint();
			total_cost = cst.GamingCost();
			res.total(Dur, effort, carbonFt, total_cost);
		} else if (dormSelect.equals("LongQueue")) {
			Dur = dur.LongQueueDormDuration();
			effort = eff.LongQueueDormEfforts();
			carbonFt = CO.LongQueueDormCarbonFootPrint();
			total_cost = cst.LongQueueCost();
			res.total(Dur, effort, carbonFt, total_cost);
		} else {
			System.out.println("Invalid Dorm Selection Choice, Please Try Again...!");
			System.exit(1);
		}
	}

	/**
	 * This method checks for the course registration entered by user and as per
	 * the choice it calculates Duration, Cost, Efforts and carbon footprints.
	 * It than sends all the calculation to result class. Or exits the
	 * application if invalid choice entered.
	 * 
	 * @return Nothing.
	 */
	@Override
	public void courseRegister() {
		if (courseRegister.equals("SubmitForm")) {
			Dur = dur.SubmitFormRegistrationDuration();
			effort = eff.SubmitFormRegistrationEfforts();
			carbonFt = CO.SubmitFormRegistrationCarbonFootPrint();
			total_cost = cst.viaRegistrarCost();
			res.total(Dur, effort, carbonFt, total_cost);
		} else if (courseRegister.equals("AccessComputer")) {
			Dur = dur.AccessingComputerRegistrationDuration();
			effort = eff.AccessingComputerRegistrationEfforts();
			carbonFt = CO.AccessingComputerRegistrationCarbonFootPrint();
			total_cost = cst.viaComputerCost();
			res.total(Dur, effort, carbonFt, total_cost);
		} else {
			System.out.println("Invalid Course Registration Choice, Please Try Again...!");
			System.exit(1);
		}
	}
}
