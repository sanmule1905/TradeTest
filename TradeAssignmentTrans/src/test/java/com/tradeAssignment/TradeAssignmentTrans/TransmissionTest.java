package com.tradeAssignment.TradeAssignmentTrans;

import static org.junit.Assert.assertThrows;


import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.tradeAssignment.TradeAssignmentTrans.exception.MinorVersionException;
import com.tradeAssignment.TradeAssignmentTrans.model.Trade;

import junit.framework.Assert;

public class TransmissionTest {

	TrannmissionService service = new TrannmissionService();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	/*
	 * @Test public void doTransmissionTest() { Trade trade = new Trade();
	 * trade.setTrade_id("Trade6"); trade.setVersion(1); trade.setBookId("book4");
	 * trade.setMaturityDate(new GregorianCalendar(2015, Calendar.FEBRUARY,
	 * 22).getTime()); trade.setMaturityDate(new Date()); trade.setExpired(false);
	 * service.generateData(); service.addTrade(trade);
	 * Assert.assertTrue(service.addTrade(trade));
	 * 
	 * Assert.assertEquals(trade, service.findTrade(trade));
	 * 
	 * }
	 */

	@Test(expected = MinorVersionException.class)
	public void validateVersionLessTest(){
		
		Trade trade = new Trade();
		trade.setTrade_id("Trade6");
		trade.setVersion(2);
		trade.setBookId("book4"); 
		trade.setMaturityDate(new GregorianCalendar(2015, Calendar.FEBRUARY, 22).getTime());
		trade.setMaturityDate(new Date());
		trade.setExpired(false);
		service.generateData();
		
		Assert.assertTrue(service.addTrade(trade));
		
		Trade trade1 = new Trade();
		trade1.setTrade_id("Trade6");
		trade1.setVersion(1);
		trade1.setBookId("book5");
		trade1.setMaturityDate(new GregorianCalendar(2022, Calendar.FEBRUARY, 22).getTime());
		trade1.setMaturityDate(new Date());
		trade1.setExpired(false);
		service.addTrade(trade1);
		//Assert.assertTrue(service.addTrade(trade1));
		
		Trade trade2 = new Trade();
		trade2.setTrade_id("Trade6");
		trade2.setVersion(2);
		trade2.setBookId("book5");
		trade2.setMaturityDate(new GregorianCalendar(2022, Calendar.FEBRUARY, 22).getTime());
		trade2.setMaturityDate(new Date());
		trade2.setExpired(false);
		service.addTrade(trade2);
		
	}
	
	@Test
	public void validateVersionMoreTest(){
		
		Trade trade = new Trade();
		trade.setTrade_id("Trade6");
		trade.setVersion(2);
		trade.setBookId("book4");
		trade.setMaturityDate(new GregorianCalendar(2015, Calendar.FEBRUARY, 22).getTime());
		trade.setMaturityDate(new Date());
		trade.setExpired(false);
		service.generateData();
		
		Assert.assertTrue(service.addTrade(trade));
		
		Trade trade2 = new Trade();
		trade2.setTrade_id("Trade6");
		trade2.setVersion(2);
		trade2.setBookId("book5");
		trade2.setMaturityDate(new GregorianCalendar(2022, Calendar.FEBRUARY, 22).getTime());
		trade2.setMaturityDate(new Date());
		trade2.setExpired(false);
		service.addTrade(trade2);
		
	}
	
	@Test
	public void validateOlderMaturityDate() {
		Trade trade = new Trade();
		trade.setTrade_id("Trade6");
		trade.setVersion(2);
		trade.setBookId("book4");
		trade.setMaturityDate(new GregorianCalendar(2015, Calendar.FEBRUARY, 22).getTime());
		trade.setMaturityDate(new GregorianCalendar(2015, Calendar.JANUARY, 22).getTime());
		trade.setExpired(false);
		service.generateData();
		
		Assert.assertFalse(service.addTrade(trade));
		
	}
	
	@Test
	public void validateOlderMaturityDateAndHigerVersionTest() {
		
		Trade trade = new Trade();
		trade.setTrade_id("Trade6");
		trade.setVersion(2);
		trade.setBookId("book4");
		trade.setMaturityDate(new GregorianCalendar(2015, Calendar.FEBRUARY, 22).getTime());
		trade.setMaturityDate(new Date());
		trade.setExpired(false);
		service.generateData();
		
		Assert.assertTrue(service.addTrade(trade));
		
		
		Trade trade3 = new Trade();
		trade3.setTrade_id("Trade6");
		trade3.setVersion(2);
		trade3.setBookId("book4");
		trade3.setMaturityDate(new GregorianCalendar(2015, Calendar.FEBRUARY, 22).getTime());
		trade3.setMaturityDate(new GregorianCalendar(2015, Calendar.JANUARY, 22).getTime());
		trade3.setExpired(false);
		service.generateData();
		
		Assert.assertFalse(service.addTrade(trade3));
		
	}
	
	
	
	
}
