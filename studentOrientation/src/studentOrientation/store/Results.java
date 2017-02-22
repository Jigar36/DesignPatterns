package studentOrientation.store;

public class Results implements ResultsInterface {

	private int duration = 0;
	private int effort = 0;
	private int carbonFootprint = 0;
	private double cost = 0;

	/**
	 * This method prints all the final calculated values.
	 * 
	 */
	@Override
	public void print() {

		System.out.println("Total Duration : " + duration + " minutes");
		System.out.println("Total Effort : " + effort + " Calories");
		System.out.println("Total carbonFootprint : " + carbonFootprint + " CO2");
		System.out.println("Total Cost : $" + cost);
	}

	/**
	 * This method calculates the total of duration, efforts, carbon footprint
	 * and cost taken to complete all the activities .
	 * 
	 * @param int
	 *            Duration, Efforts, CarbonFootprint and cost.
	 * 
	 * @return Nothing.
	 */
	@Override
	public void total(int durationIn, int effortIn, int carbonFootprintIn, double cst) {

		duration += durationIn;
		effort += effortIn;
		carbonFootprint += carbonFootprintIn;
		cost += cst;

	}

}
