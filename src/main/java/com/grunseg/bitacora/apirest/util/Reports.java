package com.grunseg.bitacora.apirest.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reports {

	public static String parseFecha(Date date, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		String strDate = dateFormat.format(date);
		return strDate;
	}

}
