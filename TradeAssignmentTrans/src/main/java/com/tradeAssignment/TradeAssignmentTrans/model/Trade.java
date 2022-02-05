package com.tradeAssignment.TradeAssignmentTrans.model;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Trade {
	
	private String Trade_id;
	private int version;
	private String countryPartyId;
	private String bookId;
	private Date maturityDate;
	private Date createdDate;
	private boolean expired;
	public Trade(String trade_id, int version, String countryPartyId, String bookId, Date maturityDate,
			Date createdDate, boolean expired) {
		super();
		Trade_id = trade_id;
		this.version = version;
		this.countryPartyId = countryPartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}
	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTrade_id() {
		return Trade_id;
	}
	public void setTrade_id(String trade_id) {
		Trade_id = trade_id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCountryPartyId() {
		return countryPartyId;
	}
	public void setCountryPartyId(String countryPartyId) {
		this.countryPartyId = countryPartyId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public boolean isExpired() {
		return expired;
	}
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	@Override
	public String toString() {
		return "Trade [Trade_id=" + Trade_id + ", version=" + version + ", countryPartyId=" + countryPartyId
				+ ", bookId=" + bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate
				+ ", expired=" + expired + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Trade_id == null) ? 0 : Trade_id.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((countryPartyId == null) ? 0 : countryPartyId.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (expired ? 1231 : 1237);
		result = prime * result + ((maturityDate == null) ? 0 : maturityDate.hashCode());
		result = prime * result + version;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (Trade_id == null) {
			if (other.Trade_id != null)
				return false;
		} else if (!Trade_id.equals(other.Trade_id))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (countryPartyId == null) {
			if (other.countryPartyId != null)
				return false;
		} else if (!countryPartyId.equals(other.countryPartyId))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (expired != other.expired)
			return false;
		if (maturityDate == null) {
			if (other.maturityDate != null)
				return false;
		} else if (!maturityDate.equals(other.maturityDate))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

	
}