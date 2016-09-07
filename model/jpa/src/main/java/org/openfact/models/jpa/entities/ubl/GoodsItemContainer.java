package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class defining how goods items are split across transport equipment.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:25 a. m.
 */
public class GoodsItemContainer {

	/**
	 * An identifier for this goods item container.
	 */
	private String ID;
	/**
	 * The number of goods items loaded into or onto one piece of transport
	 * equipment as a total consignment or part of a consignment.
	 */
	private BigDecimal quantity;
	private List<TransportEquipment> transportEquipments=new ArrayList<>();

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public List<TransportEquipment> getTransportEquipments() {
		return transportEquipments;
	}

	public void setTransportEquipments(List<TransportEquipment> transportEquipments) {
		this.transportEquipments = transportEquipments;
	}
}// end Goods Item Container