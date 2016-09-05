package sample.cmm.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleMenuUtil {

	/** LOGGER */
	private final static Logger LOGGER = LoggerFactory.getLogger(SampleMenuUtil.class);

	
//	/** EgovMenuManageService */
//	@Resource(name = "meunManageService")
//	private EgovMenuManageService menuManageService;

	/**
	 * mene list 반환
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List selectMenuList() throws Exception {
		List menuList = new ArrayList<String>();
		LOGGER.debug("SampleMenuUtil() selectMenuList={}", menuList);
		return menuList;
	}
}
