package studentOrientation.util;

public class CostClass implements Cost {

	double book_Cost = 500;
	double dorm_cost = 15000;
	double registration_cost = 25000;

	/**
	 * This method returns cost value taken for buying from UniversityBookStore
	 * which gives 5% discount than buying from mando bookstore.
	 * 
	 * @param Nothing
	 * @return Cost value
	 */
	@Override
	public double UniversityBookStoreStoreCost() {
		return (double) (book_Cost - (0.05 * book_Cost));
	}

	/**
	 * This method returns cost value taken for buying from MandoBookStore.
	 * 
	 * @param Nothing
	 * @return Cost value
	 */
	@Override
	public double MandoBookStoreCost() {
		return book_Cost;
	}

	/**
	 * This method returns cost value taken for a bus ride.
	 * 
	 * @param Nothing
	 * @return Cost value
	 */
	@Override
	public double BusRideCost() {
		return 2;
	}

	/**
	 * This method returns cost value taken for taking a Camous tour by walking.
	 * 
	 * @param Nothing
	 * @return Cost value
	 */
	@Override
	public double walkingCost() {
		return 0.10;
	}

	/**
	 * This method returns cost value taken for registering for a dorm by
	 * standing in a long queue.
	 * 
	 * @param Nothing
	 * @return Cost value
	 */
	@Override
	public double LongQueueCost() {
		return dorm_cost;
	}

	/**
	 * This method returns cost value taken for registering for a dorm by
	 * playing a gaming contest which charges 2% Surcharge.
	 * 
	 * @param Nothing
	 * @return Cost value
	 */
	@Override
	public double GamingCost() {
		return (double) (dorm_cost + (0.02 * dorm_cost));
	}

	/**
	 * This method returns cost value taken for registering for a Course by
	 * using a computer.
	 * 
	 * @param Nothing
	 * @return Cost value
	 */
	@Override
	public double viaComputerCost() {
		return registration_cost;
	}

	/**
	 * This method returns cost value taken for registering for a Course via
	 * registrar, Submitting forms requires payment via check, which makes
	 * tuition 3% cheaper .
	 * 
	 * @param Nothing
	 * @return Cost value
	 */
	@Override
	public double viaRegistrarCost() {
		return (double) (registration_cost - (0.03 * registration_cost));
	}

}
