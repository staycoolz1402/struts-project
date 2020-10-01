package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the organization_setup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="organization_setup"
 */

public abstract class BaseOrganizationSetup extends com.ams.mufins.model.Organization  implements Serializable {

	public static String REF = "OrganizationSetup";
	public static String PROP_SETUP_DATE = "SetupDate";
	public static String PROP_END_OF_YEAR_DATE = "EndOfYearDate";
	public static String PROP_TERMINATION_PENALTY = "TerminationPenalty";
	public static String PROP_LATE_CHARGE = "LateCharge";
	public static String PROP_GRACE_AMOUNT = "GraceAmount";
	public static String PROP_GRACE_PERIOD = "GracePeriod";
	public static String PROP_NUMBER_OF_DIGIT = "NumberOfDigit";
	public static String PROP_NEW_VEHICLE_BSM_RATE = "NewVehicleBsmRate";
	public static String PROP_OLD_VEHICLE_BSM_RATE = "OldVehicleBsmRate";
	public static String PROP_RAK_TIME_OFF = "RakTimeOff";
	public static String PROP_CENTURY_TIME_OFF = "CenturyTimeOff";
	public static String PROP_LOCKED = "Locked";
	public static String PROP_SOD_LIMIT = "SodLimit";
	public static String PROP_EOD_LIMIT = "EodLimit";
	public static String PROP_RUNNING_NUMBER_SERVICE = "RunningNumberService";
	public static String PROP_ACTIVE_USER_LOGGING = "ActiveUserLogging";
	public static String PROP_ACTIVE_HISTORY_REPORT = "ActiveHistoryReport";
	public static String PROP_DRAWDOWN_NUMBER_SERVICE = "DrawdownNumberService";
	public static String PROP_POLIS_NUMBER_SERVICE = "PolisNumberService";
	public static String PROP_AKTA_FIDUCIA_NUMBER_SERVICE = "AktaFiduciaNumberService";
	public static String PROP_DEFAULT_USER_PASS_DURATION = "defaultUserPassDuration";
	public static String PROP_USER_PASS_HISTORY = "userPassHistory";
	public static String PROP_MIN_USER_PASS_LENGTH = "minUserPassLength";
	public static String PROP_ALPHABET_USER_PASS = "alphabetUserPass";
	public static String PROP_NUMERIC_USER_PASS = "numericUserPass";
	public static String PROP_UPPER_CASE_LETTER = "upperCaseLetter";
	public static String PROP_TIMEOUT_ADMIN = "TimeoutAdmin";
	public static String PROP_TIMEOUT_USER = "TimeoutUser";
	public static String PROP_TIMEOUT_SERVER = "TimeoutServer";
	public static String PROP_MAXIMUM_UMUR = "MaximumUmur";
	public static String PROP_MINIMUM_UMUR = "MinimumUmur";
	public static String PROP_TOTAL_MAXIMUM_FOLLOWUP = "TotalMaximumFollowup";
	public static String PROP_MAXIMUM_FOLLOWUP_PER_DAY = "MaximumFollowupPerDay";
	public static String PROP_DIFF_FOLLOWUP_PER_DAY = "DiffFollowupPerDay";
	public static String PROP_BI_CHECKING_IS_DONE = "BiCheckingIsDone";
	public static String PROP_MAXIMUM_LOGIN_ATTEMPT = "MaximumLoginAttempt";


	// constructors
	public BaseOrganizationSetup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrganizationSetup (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOrganizationSetup (
		long id,
		java.lang.String name) {

		super (
			id,
			name);
	}



	private int hashCode = Integer.MIN_VALUE;


	// fields
	private java.util.Date setupDate;
	private java.util.Date endOfYearDate;
	private double terminationPenalty;
	private double lateCharge;
	private double graceAmount;
	private int gracePeriod;
	private int numberOfDigit;
	private double newVehicleBsmRate;
	private double oldVehicleBsmRate;
	private java.util.Date rakTimeOff;
	private java.util.Date centuryTimeOff;
	private boolean locked;
	private int sodLimit;
	private int eodLimit;
	private boolean runningNumberService;
	private boolean activeUserLogging;
	private boolean activeHistoryReport;
	private boolean drawdownNumberService;
	private boolean polisNumberService;
	private boolean aktaFiduciaNumberService;
	private int defaultUserPassDuration;
	private int userPassHistory;
	private int minUserPassLength;
	private boolean alphabetUserPass;
	private boolean numericUserPass;
	private boolean upperCaseLetter;
	private int timeoutAdmin;
	private int timeoutUser;
	private int timeoutServer;
	private int maximumUmur;
	private int minimumUmur;
	private int totalMaximumFollowup;
	private int maximumFollowupPerDay;
	private int diffFollowupPerDay;
	private boolean biCheckingIsDone;
	private int maximumLoginAttempt;

	// many to one
	private com.ams.mufins.model.Lookup currencyExchangeRateType;

	/**
	 * Return the value associated with the column: setup_date
	 */
	public java.util.Date getSetupDate () {
		return setupDate;
	}

	/**
	 * Set the value related to the column: setup_date
	 * @param setupDate the setup_date value
	 */
	public void setSetupDate (java.util.Date setupDate) {
		this.setupDate = setupDate;
	}



	/**
	 * Return the value associated with the column: end_of_year_date
	 */
	public java.util.Date getEndOfYearDate () {
		return endOfYearDate;
	}

	/**
	 * Set the value related to the column: end_of_year_date
	 * @param endOfYearDate the end_of_year_date value
	 */
	public void setEndOfYearDate (java.util.Date endOfYearDate) {
		this.endOfYearDate = endOfYearDate;
	}



	/**
	 * Return the value associated with the column: termination_penalty
	 */
	public double getTerminationPenalty () {
		return terminationPenalty;
	}

	/**
	 * Set the value related to the column: termination_penalty
	 * @param terminationPenalty the termination_penalty value
	 */
	public void setTerminationPenalty (double terminationPenalty) {
		this.terminationPenalty = terminationPenalty;
	}



	/**
	 * Return the value associated with the column: late_charge
	 */
	public double getLateCharge () {
		return lateCharge;
	}

	/**
	 * Set the value related to the column: late_charge
	 * @param lateCharge the late_charge value
	 */
	public void setLateCharge (double lateCharge) {
		this.lateCharge = lateCharge;
	}



	/**
	 * Return the value associated with the column: grace_amount
	 */
	public double getGraceAmount () {
		return graceAmount;
	}

	/**
	 * Set the value related to the column: grace_amount
	 * @param graceAmount the grace_amount value
	 */
	public void setGraceAmount (double graceAmount) {
		this.graceAmount = graceAmount;
	}



	/**
	 * Return the value associated with the column: grace_period
	 */
	public int getGracePeriod () {
		return gracePeriod;
	}

	/**
	 * Set the value related to the column: grace_period
	 * @param gracePeriod the grace_period value
	 */
	public void setGracePeriod (int gracePeriod) {
		this.gracePeriod = gracePeriod;
	}



	/**
	 * Return the value associated with the column: number_of_digit
	 */
	public int getNumberOfDigit () {
		return numberOfDigit;
	}

	/**
	 * Set the value related to the column: number_of_digit
	 * @param numberOfDigit the number_of_digit value
	 */
	public void setNumberOfDigit (int numberOfDigit) {
		this.numberOfDigit = numberOfDigit;
	}



	/**
	 * Return the value associated with the column: new_vehicle_bsm_rate
	 */
	public double getNewVehicleBsmRate () {
		return newVehicleBsmRate;
	}

	/**
	 * Set the value related to the column: new_vehicle_bsm_rate
	 * @param newVehicleBsmRate the new_vehicle_bsm_rate value
	 */
	public void setNewVehicleBsmRate (double newVehicleBsmRate) {
		this.newVehicleBsmRate = newVehicleBsmRate;
	}



	/**
	 * Return the value associated with the column: old_vehicle_bsm_rate
	 */
	public double getOldVehicleBsmRate () {
		return oldVehicleBsmRate;
	}

	/**
	 * Set the value related to the column: old_vehicle_bsm_rate
	 * @param oldVehicleBsmRate the old_vehicle_bsm_rate value
	 */
	public void setOldVehicleBsmRate (double oldVehicleBsmRate) {
		this.oldVehicleBsmRate = oldVehicleBsmRate;
	}



	/**
	 * Return the value associated with the column: rak_time_off
	 */
	public java.util.Date getRakTimeOff () {
		return rakTimeOff;
	}

	/**
	 * Set the value related to the column: rak_time_off
	 * @param rakTimeOff the rak_time_off value
	 */
	public void setRakTimeOff (java.util.Date rakTimeOff) {
		this.rakTimeOff = rakTimeOff;
	}



	/**
	 * Return the value associated with the column: century_time_off
	 */
	public java.util.Date getCenturyTimeOff () {
		return centuryTimeOff;
	}

	/**
	 * Set the value related to the column: century_time_off
	 * @param centuryTimeOff the century_time_off value
	 */
	public void setCenturyTimeOff (java.util.Date centuryTimeOff) {
		this.centuryTimeOff = centuryTimeOff;
	}



	/**
	 * Return the value associated with the column: is_locked
	 */
	public boolean isLocked () {
		return locked;
	}

	/**
	 * Set the value related to the column: is_locked
	 * @param locked the is_locked value
	 */
	public void setLocked (boolean locked) {
		this.locked = locked;
	}



	/**
	 * Return the value associated with the column: sod_limit
	 */
	public int getSodLimit () {
		return sodLimit;
	}

	/**
	 * Set the value related to the column: sod_limit
	 * @param sodLimit the sod_limit value
	 */
	public void setSodLimit (int sodLimit) {
		this.sodLimit = sodLimit;
	}



	/**
	 * Return the value associated with the column: eod_limit
	 */
	public int getEodLimit () {
		return eodLimit;
	}

	/**
	 * Set the value related to the column: eod_limit
	 * @param eodLimit the eod_limit value
	 */
	public void setEodLimit (int eodLimit) {
		this.eodLimit = eodLimit;
	}



	/**
	 * Return the value associated with the column: is_running_number_service
	 */
	public boolean isRunningNumberService () {
		return runningNumberService;
	}

	/**
	 * Set the value related to the column: is_running_number_service
	 * @param runningNumberService the is_running_number_service value
	 */
	public void setRunningNumberService (boolean runningNumberService) {
		this.runningNumberService = runningNumberService;
	}



	/**
	 * Return the value associated with the column: is_active_user_logging
	 */
	public boolean isActiveUserLogging () {
		return activeUserLogging;
	}

	/**
	 * Set the value related to the column: is_active_user_logging
	 * @param activeUserLogging the is_active_user_logging value
	 */
	public void setActiveUserLogging (boolean activeUserLogging) {
		this.activeUserLogging = activeUserLogging;
	}



	/**
	 * Return the value associated with the column: is_active_history_report
	 */
	public boolean isActiveHistoryReport () {
		return activeHistoryReport;
	}

	/**
	 * Set the value related to the column: is_active_history_report
	 * @param activeHistoryReport the is_active_history_report value
	 */
	public void setActiveHistoryReport (boolean activeHistoryReport) {
		this.activeHistoryReport = activeHistoryReport;
	}



	/**
	 * Return the value associated with the column: is_drawdown_number_service
	 */
	public boolean isDrawdownNumberService () {
		return drawdownNumberService;
	}

	/**
	 * Set the value related to the column: is_drawdown_number_service
	 * @param drawdownNumberService the is_drawdown_number_service value
	 */
	public void setDrawdownNumberService (boolean drawdownNumberService) {
		this.drawdownNumberService = drawdownNumberService;
	}



	/**
	 * Return the value associated with the column: is_polis_number_service
	 */
	public boolean isPolisNumberService () {
		return polisNumberService;
	}

	/**
	 * Set the value related to the column: is_polis_number_service
	 * @param polisNumberService the is_polis_number_service value
	 */
	public void setPolisNumberService (boolean polisNumberService) {
		this.polisNumberService = polisNumberService;
	}



	/**
	 * Return the value associated with the column: is_akta_fiducia_number_service
	 */
	public boolean isAktaFiduciaNumberService () {
		return aktaFiduciaNumberService;
	}

	/**
	 * Set the value related to the column: is_akta_fiducia_number_service
	 * @param aktaFiduciaNumberService the is_akta_fiducia_number_service value
	 */
	public void setAktaFiduciaNumberService (boolean aktaFiduciaNumberService) {
		this.aktaFiduciaNumberService = aktaFiduciaNumberService;
	}



	/**
	 * Return the value associated with the column: default_user_pass_duration
	 */
	public int getDefaultUserPassDuration () {
		return defaultUserPassDuration;
	}

	/**
	 * Set the value related to the column: default_user_pass_duration
	 * @param defaultUserPassDuration the default_user_pass_duration value
	 */
	public void setDefaultUserPassDuration (int defaultUserPassDuration) {
		this.defaultUserPassDuration = defaultUserPassDuration;
	}



	/**
	 * Return the value associated with the column: user_pass_history
	 */
	public int getUserPassHistory () {
		return userPassHistory;
	}

	/**
	 * Set the value related to the column: user_pass_history
	 * @param userPassHistory the user_pass_history value
	 */
	public void setUserPassHistory (int userPassHistory) {
		this.userPassHistory = userPassHistory;
	}



	/**
	 * Return the value associated with the column: min_user_pass_length
	 */
	public int getMinUserPassLength () {
		return minUserPassLength;
	}

	/**
	 * Set the value related to the column: min_user_pass_length
	 * @param minUserPassLength the min_user_pass_length value
	 */
	public void setMinUserPassLength (int minUserPassLength) {
		this.minUserPassLength = minUserPassLength;
	}



	/**
	 * Return the value associated with the column: is_alphabet_user_pass
	 */
	public boolean isAlphabetUserPass () {
		return alphabetUserPass;
	}

	/**
	 * Set the value related to the column: is_alphabet_user_pass
	 * @param alphabetUserPass the is_alphabet_user_pass value
	 */
	public void setAlphabetUserPass (boolean alphabetUserPass) {
		this.alphabetUserPass = alphabetUserPass;
	}



	/**
	 * Return the value associated with the column: is_numeric_user_pass
	 */
	public boolean isNumericUserPass () {
		return numericUserPass;
	}

	/**
	 * Set the value related to the column: is_numeric_user_pass
	 * @param numericUserPass the is_numeric_user_pass value
	 */
	public void setNumericUserPass (boolean numericUserPass) {
		this.numericUserPass = numericUserPass;
	}



	/**
	 * Return the value associated with the column: is_upper_case_letter
	 */
	public boolean isUpperCaseLetter () {
		return upperCaseLetter;
	}

	/**
	 * Set the value related to the column: is_upper_case_letter
	 * @param upperCaseLetter the is_upper_case_letter value
	 */
	public void setUpperCaseLetter (boolean upperCaseLetter) {
		this.upperCaseLetter = upperCaseLetter;
	}



	/**
	 * Return the value associated with the column: timeout_admin
	 */
	public int getTimeoutAdmin () {
		return timeoutAdmin;
	}

	/**
	 * Set the value related to the column: timeout_admin
	 * @param timeoutAdmin the timeout_admin value
	 */
	public void setTimeoutAdmin (int timeoutAdmin) {
		this.timeoutAdmin = timeoutAdmin;
	}



	/**
	 * Return the value associated with the column: timeout_user
	 */
	public int getTimeoutUser () {
		return timeoutUser;
	}

	/**
	 * Set the value related to the column: timeout_user
	 * @param timeoutUser the timeout_user value
	 */
	public void setTimeoutUser (int timeoutUser) {
		this.timeoutUser = timeoutUser;
	}



	/**
	 * Return the value associated with the column: timeout_server
	 */
	public int getTimeoutServer () {
		return timeoutServer;
	}

	/**
	 * Set the value related to the column: timeout_server
	 * @param timeoutServer the timeout_server value
	 */
	public void setTimeoutServer (int timeoutServer) {
		this.timeoutServer = timeoutServer;
	}



	/**
	 * Return the value associated with the column: maximum_umur
	 */
	public int getMaximumUmur () {
		return maximumUmur;
	}

	/**
	 * Set the value related to the column: maximum_umur
	 * @param maximumUmur the maximum_umur value
	 */
	public void setMaximumUmur (int maximumUmur) {
		this.maximumUmur = maximumUmur;
	}



	/**
	 * Return the value associated with the column: minimum_umur
	 */
	public int getMinimumUmur () {
		return minimumUmur;
	}

	/**
	 * Set the value related to the column: minimum_umur
	 * @param minimumUmur the minimum_umur value
	 */
	public void setMinimumUmur (int minimumUmur) {
		this.minimumUmur = minimumUmur;
	}



	/**
	 * Return the value associated with the column: total_max_followup
	 */
	public int getTotalMaximumFollowup () {
		return totalMaximumFollowup;
	}

	/**
	 * Set the value related to the column: total_max_followup
	 * @param totalMaximumFollowup the total_max_followup value
	 */
	public void setTotalMaximumFollowup (int totalMaximumFollowup) {
		this.totalMaximumFollowup = totalMaximumFollowup;
	}



	/**
	 * Return the value associated with the column: max_followup_perday
	 */
	public int getMaximumFollowupPerDay () {
		return maximumFollowupPerDay;
	}

	/**
	 * Set the value related to the column: max_followup_perday
	 * @param maximumFollowupPerDay the max_followup_perday value
	 */
	public void setMaximumFollowupPerDay (int maximumFollowupPerDay) {
		this.maximumFollowupPerDay = maximumFollowupPerDay;
	}



	/**
	 * Return the value associated with the column: diff_followup_perday
	 */
	public int getDiffFollowupPerDay () {
		return diffFollowupPerDay;
	}

	/**
	 * Set the value related to the column: diff_followup_perday
	 * @param diffFollowupPerDay the diff_followup_perday value
	 */
	public void setDiffFollowupPerDay (int diffFollowupPerDay) {
		this.diffFollowupPerDay = diffFollowupPerDay;
	}



	/**
	 * Return the value associated with the column: is_bi_checking_done
	 */
	public boolean isBiCheckingIsDone () {
		return biCheckingIsDone;
	}

	/**
	 * Set the value related to the column: is_bi_checking_done
	 * @param biCheckingIsDone the is_bi_checking_done value
	 */
	public void setBiCheckingIsDone (boolean biCheckingIsDone) {
		this.biCheckingIsDone = biCheckingIsDone;
	}



	/**
	 * Return the value associated with the column: max_login_attempt
	 */
	public int getMaximumLoginAttempt () {
		return maximumLoginAttempt;
	}

	/**
	 * Set the value related to the column: max_login_attempt
	 * @param maximumLoginAttempt the max_login_attempt value
	 */
	public void setMaximumLoginAttempt (int maximumLoginAttempt) {
		this.maximumLoginAttempt = maximumLoginAttempt;
	}

	/**
	 * Return the value associated with the column: currency_exchange_type_id
	 */
	public com.ams.mufins.model.Lookup getCurrencyExchangeRateType () {
		return currencyExchangeRateType;
	}

	/**
	 * Set the value related to the column: currency_exchange_type_id
	 * @param currencyExchangeRateType the currency_exchange_type_id value
	 */
	public void setCurrencyExchangeRateType (com.ams.mufins.model.Lookup currencyExchangeRateType) {
		this.currencyExchangeRateType = currencyExchangeRateType;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.OrganizationSetup)) return false;
		else {
			com.ams.mufins.model.OrganizationSetup organizationSetup = (com.ams.mufins.model.OrganizationSetup) obj;
			return (this.getId() == organizationSetup.getId());
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			return (int) this.getId();
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}