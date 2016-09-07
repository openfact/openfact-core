package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to associate a time period and locations (activity data) with an item
 * for inventory planning purposes.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:32 a. m.
 */
public class ActivityDataLine {

	/**
	 * An identifier for this activity data line.
	 */
	private String id;

	/**
	 * A code signifying the type of supply chain activity.
	 */
	private String supplyChainActivityTypeCode;
	private CustomerParty buyerCustomerParty;
	private Location activityOriginLocation;
	private Period activityPeriod;
	private Location activityFinalLocation;
	private List<SalesItem> salesItems = new ArrayList<>();
	private SupplierParty sellerSupplierParty;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the supplyChainActivityTypeCode
	 */
	public String getSupplyChainActivityTypeCode() {
		return supplyChainActivityTypeCode;
	}

	/**
	 * @param supplyChainActivityTypeCode
	 *            the supplyChainActivityTypeCode to set
	 */
	public void setSupplyChainActivityTypeCode(String supplyChainActivityTypeCode) {
		this.supplyChainActivityTypeCode = supplyChainActivityTypeCode;
	}

	/**
	 * @return the buyerCustomerParty
	 */
	public CustomerParty getBuyerCustomerParty() {
		return buyerCustomerParty;
	}

	/**
	 * @param buyerCustomerParty
	 *            the buyerCustomerParty to set
	 */
	public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
		this.buyerCustomerParty = buyerCustomerParty;
	}

	/**
	 * @return the activityOriginLocation
	 */
	public Location getActivityOriginLocation() {
		return activityOriginLocation;
	}

	/**
	 * @param activityOriginLocation
	 *            the activityOriginLocation to set
	 */
	public void setActivityOriginLocation(Location activityOriginLocation) {
		this.activityOriginLocation = activityOriginLocation;
	}

	/**
	 * @return the activityPeriod
	 */
	public Period getActivityPeriod() {
		return activityPeriod;
	}

	/**
	 * @param activityPeriod
	 *            the activityPeriod to set
	 */
	public void setActivityPeriod(Period activityPeriod) {
		this.activityPeriod = activityPeriod;
	}

	/**
	 * @return the activityFinalLocation
	 */
	public Location getActivityFinalLocation() {
		return activityFinalLocation;
	}

	/**
	 * @param activityFinalLocation
	 *            the activityFinalLocation to set
	 */
	public void setActivityFinalLocation(Location activityFinalLocation) {
		this.activityFinalLocation = activityFinalLocation;
	}

	/**
	 * @return the sellerSupplierParty
	 */
	public SupplierParty getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	/**
	 * @param sellerSupplierParty
	 *            the sellerSupplierParty to set
	 */
	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}

	/**
	 * @return the salesItems
	 */
	public List<SalesItem> getSalesItems() {
		return salesItems;
	}

	/**
	 * @param salesItems the salesItems to set
	 */
	public void setSalesItems(List<SalesItem> salesItems) {
		salesItems = salesItems;
	}

}