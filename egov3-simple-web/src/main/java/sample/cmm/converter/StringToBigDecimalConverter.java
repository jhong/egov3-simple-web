package sample.cmm.converter;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import sample.cmm.util.SampleStringUtil;

/**  
 * <pre>
 * String To BigDecimal Converter
 * </pre>
 *
 * @version 2016.08.16
 * @author jhong
 */
public class StringToBigDecimalConverter implements Converter<String, BigDecimal> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public BigDecimal convert(String text) {
		if (SampleStringUtil.isEmpty(text)) return null; // empty 처리 추가 by jhong (2013.07.31)
		
		String tmp = text.replaceAll(",", ""); // 컴마 모두 제거
		if ("NaN".equals(tmp)) return null; // NaN 처리 추가 by jhong (2013.07.22)
		
		BigDecimal result = new BigDecimal(tmp);
		
		logger.info("[StringToBigDecimalConverter] convert() end... text=[{}", text+"], result=["+result+"]");
		return result;
	}
}
