package sample.cmm.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

/**  
 * <pre>
 * String To Date Converter
 * </pre>
 *
 * @version 2016.08.16
 * @author jhong
 */
public class StringToDateConverter implements Converter<String, Date> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private List<DateFormat> dateFormatList = null;
	
	void initDateFormatList() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		SimpleDateFormat dateFormat3 = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy",  Locale.getDefault());
		SimpleDateFormat dateFormat4 = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy",  Locale.US);
		SimpleDateFormat dateFormat5 = new SimpleDateFormat("yyyy"); // added by jhong (2016.05.17)
		
		this.dateFormatList = new ArrayList<DateFormat>();
		dateFormatList.add(dateFormat);
		dateFormatList.add(dateFormat2);
		dateFormatList.add(dateFormat3);
		dateFormatList.add(dateFormat4);
		dateFormatList.add(dateFormat5);
	}
	
	public Date convert(String text) {
		this.initDateFormatList();
		Date result = null;
		
		logger.debug("convert() dateFormatList.size()={}", dateFormatList.size()+", dateFormatList="+dateFormatList);
		for (int i=0; i<dateFormatList.size(); i++) {
			try {
				DateFormat dateFormat = this.dateFormatList.get(i);
				if (dateFormat instanceof SimpleDateFormat) {
					String pattern = ((SimpleDateFormat)dateFormat).toLocalizedPattern();
					if (pattern.equals("yyyyMMdd")) {
						if (text.length() != pattern.length()) continue; // "1234567890" 을 변환할경우 오류 해결 위해 추가함.. by jhong (2012.07.23)
					}
				}

				result = dateFormat.parse(text);
				if (result != null) break;
			}
			catch (ParseException ex) {
//				throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
				logger.warn("Could not parse date text... ["+text+"] " + ex.getMessage());
			}
		}
		
		logger.info("[StringToDateConvert] convert() text=[{}", text+"], result=["+result+"]");
		return result;
	}
}
