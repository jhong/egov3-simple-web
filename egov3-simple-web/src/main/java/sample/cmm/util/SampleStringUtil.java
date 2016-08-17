package sample.cmm.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleStringUtil extends StringUtils {

	/** LOGGER */
	private final static Logger LOGGER = LoggerFactory.getLogger(SampleStringUtil.class);

	/**
	 * <pre>
	 * ToStringBuilder 이용하여 객체 string 문자열 생성
	 * </pre>
	 * 
	 * @param obj
	 * @return
	 */
	public static String reflectionToString(Object obj) {
		return ToStringBuilder.reflectionToString(obj);
	}

}
