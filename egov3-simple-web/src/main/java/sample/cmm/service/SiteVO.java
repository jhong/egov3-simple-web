package sample.cmm.service;

import java.util.Map;

import sample.cmm.util.SampleStringUtil;

/**
 * Site 정보 클래스
 *
 * @author jhong
 * @since 2016.08.09
 * @version 1.0
 */
public class SiteVO {

	/** 메뉴번호 */
	private String siteMenuNo;

	/** 메뉴번호  (top level) */
	private String siteMenuNoTop;

	/** 디자인타입 (tiles) */
	private String siteDesignType;
	
	/** 컨텐츠 구분코드 */
	private String cntntsSeCode;
	
	/**
	 * 생성자
	 */
	public SiteVO() {
	}

	/**
	 * 생성자
	 * @param param
	 */
	public SiteVO(Map param) {
		this.setSiteMenuNo(param.get("siteMenuNo") == null ? "" : param.get("siteMenuNo")+"");
		this.setSiteMenuNoTop(param.get("siteMenuNoTop") == null ? "" : param.get("siteMenuNoTop")+"");
		this.setSiteDesignType(param.get("siteDesignType") == null ? "" : param.get("siteDesignType")+"");
	}

	/**
	 * 생성자
	 * @param param
	 * @param defaultMenuNo
	 * @param defaultMenuNoTop
	 */
	public SiteVO(Map param, String defaultMenuNo, String defaultMenuNoTop) {
		this.setSiteMenuNo(param.get("siteMenuNo") == null ? "" : param.get("siteMenuNo")+"");
		this.setSiteMenuNoTop(param.get("siteMenuNoTop") == null ? "" : param.get("siteMenuNoTop")+"");
		this.setSiteDesignType(param.get("siteDesignType") == null ? "" : param.get("siteDesignType")+"");
		
		// commandMap 에 siteMenuNo 정보 없을 경우 defaultMenuNo 값 세팅
		if (SampleStringUtil.isEmpty(this.getSiteMenuNo()) && SampleStringUtil.isNotEmpty(defaultMenuNo)) {
			this.setSiteMenuNo(defaultMenuNo);
		}

		// commandMap 에 siteMenuNoTop 정보 없을 경우 defaultMenoNoTop 값 세팅
		if (SampleStringUtil.isEmpty(this.getSiteMenuNoTop()) && SampleStringUtil.isNotEmpty(defaultMenuNoTop)) {
			this.setSiteMenuNoTop(defaultMenuNoTop);
		}
	}

	public String getSiteMenuNo() {
		return siteMenuNo;
	}

	public void setSiteMenuNo(String siteMenuNo) {
		this.siteMenuNo = siteMenuNo;
	}

	public String getSiteMenuNoTop() {
		return siteMenuNoTop;
	}

	public void setSiteMenuNoTop(String siteMenuNoTop) {
		this.siteMenuNoTop = siteMenuNoTop;
	}

	public String getSiteDesignType() {
		return siteDesignType;
	}

	public void setSiteDesignType(String siteDesignType) {
		this.siteDesignType = siteDesignType;
	}

	public String getCntntsSeCode() {
		return cntntsSeCode;
	}

	public void setCntntsSeCode(String cntntsSeCode) {
		this.cntntsSeCode = cntntsSeCode;
	}

	/**
	 * toString
	 * @return String
	 */
    public String toString() {
    	return SampleStringUtil.reflectionToString(this);
    }

}
