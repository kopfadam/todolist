package com.helpers;

import java.sql.Date;
import java.time.LocalDate;

/**
 * 
 * Date conversion helper class. 
 *
 */
public class DateConvert {
	
	// Convert from LocalDate object to sql Date object in order to set in database.
	public static Date getSQLDate(LocalDate date) {
		return Date.valueOf(date);
	}
	
	// Convert form sql Date object to LocalDate object.
	public static LocalDate getUtilDate(Date sqlDate) {
		return sqlDate.toLocalDate();
	}

}
