package studentOrientation.util;

public class CarbonFootPrintClass implements CarbonFootPrint {

	/**
	 * This method returns CO2 value taken for visiting UniversityBookStore.
	 * 
	 * @param Nothing
	 * @return CO2 value
	 */
	@Override
	public int UniversityBookStoreCarbonFootPrint() {
		// TODO Auto-generated method stub
		return 100;
	}

	/**
	 * This method returns CO2 value taken for visiting MandoBookStore.
	 * 
	 * @param Nothing
	 * @return CO2 value
	 */
	@Override
	public int MandoBookStoreCarbonFootPrint() {
		// TODO Auto-generated method stub
		return 300;
	}

	/**
	 * This method returns CO2 value taking Bus Ride.
	 * 
	 * @param Nothing
	 * @return CO2 value
	 */
	@Override
	public int BusRideCampuTourCarbonFootPrint() {
		// TODO Auto-generated method stub
		return 10;
	}

	/**
	 * This method returns CO2 value taken for Walking for an campus tour.
	 * 
	 * @param Nothing
	 * @return CO2 value
	 */
	@Override
	public int WalkingCampusTourCarbonFootPrint() {
		// TODO Auto-generated method stub
		return 1800;
	}

	/**
	 * This method returns CO2 value taken for standing in a long queue.
	 * 
	 * @param Nothing
	 * @return CO2 value
	 */
	@Override
	public int LongQueueDormCarbonFootPrint() {
		// TODO Auto-generated method stub
		return 200;
	}

	/**
	 * This method returns CO2 value taken for playing gaming contest.
	 * 
	 * @param Nothing
	 * @return CO2 value
	 */
	@Override
	public int GamingContestDormCarbonFootPrint() {
		// TODO Auto-generated method stub
		return 50;
	}

	/**
	 * This method returns CO2 value taken for submitting registration form.
	 * 
	 * @param Nothing
	 * @return CO2 value
	 */
	@Override
	public int SubmitFormRegistrationCarbonFootPrint() {
		// TODO Auto-generated method stub
		return 450;
	}

	/**
	 * This method returns CO2 value taken for accessing computer for
	 * registration.
	 * 
	 * @param Nothing
	 * @return CO2 value
	 */
	@Override
	public int AccessingComputerRegistrationCarbonFootPrint() {
		// TODO Auto-generated method stub
		return 40;
	}

}
