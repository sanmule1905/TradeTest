package com.tradeAssignment.TradeAssignmentTrans;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import com.tradeAssignment.TradeAssignmentTrans.exception.MinorVersionException;
import com.tradeAssignment.TradeAssignmentTrans.model.Trade;

public class TrannmissionService {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	public static List<Trade> trades;

	public void generateData() {

		trades = new ArrayList<Trade>();

		trades.add(new Trade("Trade1", 1, "CP-1", "B1", new GregorianCalendar(2022, Calendar.FEBRUARY, 22).getTime(),
				new Date(), false));
		trades.add(new Trade("Trade1", 2, "CP-1", "B1", new GregorianCalendar(2022, Calendar.FEBRUARY, 11).getTime(),
				new Date(), false));
		trades.add(new Trade("Trade2", 1, "CP-2", "B1", new GregorianCalendar(2022, Calendar.FEBRUARY, 10).getTime(),
				new Date(), false));
		trades.add(new Trade("Trade2", 2, "CP-3", "B2", new GregorianCalendar(2022, Calendar.FEBRUARY, 01).getTime(),
				new Date(), false));
		trades.add(new Trade("Trade3", 1, "CP-1", "B3", new GregorianCalendar(2022, Calendar.FEBRUARY, 03).getTime(),
				new Date(), false));
		trades.add(new Trade("Trade3", 3, "CP-1", "B4", new GregorianCalendar(2022, Calendar.FEBRUARY, 18).getTime(),
				new Date(), false));
		trades.add(new Trade("Trade4", 1, "CP-1", "B5", new GregorianCalendar(2022, Calendar.FEBRUARY, 05).getTime(),
				new Date(), false));
		trades.add(new Trade("Trade5", 1, "CP-1", "B6", new GregorianCalendar(2022, Calendar.FEBRUARY, 05).getTime(),
				new Date(), false));
		trades.add(new Trade("Trade5", 2, "CP-1", "B7", new GregorianCalendar(2022, Calendar.FEBRUARY, 06).getTime(),
				new Date(), false));

	}

	public boolean addTrade(Trade trade) {

		String tradeIdLocal = trade.getTrade_id();
		int versionIdLocal = trade.getVersion();

		List<Trade> tradeLocallist = trades.stream().filter(
				trade1 -> (tradeIdLocal.equals(trade1.getTrade_id()) && (versionIdLocal <= trade1.getVersion())))
				.collect(Collectors.toList());
		
		//System.out.println("trades" + trades); 

		if (tradeLocallist.size() != 0) {

			List<Trade> tradeLocalFiltereForOverrride = trades.stream()
					.filter(tradeIdLocalForEqualVersion -> (tradeIdLocal.equals(tradeIdLocalForEqualVersion.getTrade_id())
							&& (versionIdLocal == tradeIdLocalForEqualVersion.getVersion())))
					.collect(Collectors.toList());
			
			if(tradeLocalFiltereForOverrride.size() != 0) {

				System.out.println("+++++++++++++++++Overrriding loop");
				System.out.println(" before count = " + trades.size());
				
				trades.removeAll(tradeLocalFiltereForOverrride);
				boolean status = checkMarityDateAndAddTrade(trade);

				System.out.println("after count = " + trades.size());
				return status;
			} else {
				System.out.println("+++++++++++++++++++++++Reject loop");
				throw new MinorVersionException("Trade cannot be inserted due to Minor version");
			}

		} else {
			System.out.println("++++++++++++++++++++Plain Add loop loop");
			System.out.println("before count = " + trades.size());
			
			boolean status = checkMarityDateAndAddTrade(trade);
			
			return status;
		}

	}
	
	private boolean checkMarityDateAndAddTrade(Trade trade) {
		boolean status = false;
		
		int dateCompareResult = compare(trade.getMaturityDate(),new Date());
		System.out.println("dateCompareResult = "+dateCompareResult);
		if(dateCompareResult < 0) {
			System.out.println("Matrity date is less cant accept Trade");
		}else {
			status = trades.add(trade);
		}
		return status;
	}

	public Object findTrade(Trade trade) {

		return trades.get(trades.indexOf(trade));
	}

	private int compare(Date d1, Date d2) {
	    Calendar c1 = Calendar.getInstance();
	    Calendar c2 = Calendar.getInstance();
	    c1.setTime(d1);
	    c1.set(Calendar.MILLISECOND, 0);
	    c1.set(Calendar.SECOND, 0);
	    c1.set(Calendar.MINUTE, 0);
	    c1.set(Calendar.HOUR_OF_DAY, 0);
	    c2.setTime(d2);
	    c2.set(Calendar.MILLISECOND, 0);
	    c2.set(Calendar.SECOND, 0);
	    c2.set(Calendar.MINUTE, 0);
	    c2.set(Calendar.HOUR_OF_DAY, 0);
	    return c1.getTime().compareTo(c2.getTime());
	  }
	
}

