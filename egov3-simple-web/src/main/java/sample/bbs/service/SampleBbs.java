package sample.bbs.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import sample.cmm.util.SampleStringUtil;


/**  
 * @Class Name : SampleBbs.java
 * @author jhong 
 * @since 2016-08-11
 * @version 1.0
 */
public class SampleBbs implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** NTT_ID */
	private BigDecimal nttId = null;
	
	/** BBS_ID */
	private String bbsId = "";
	
	/** NTT_NO */
	private BigDecimal nttNo = null;
	
	/** NTT_SJ */
	private String nttSj = "";
	
	/** NTT_CN */
	private String nttCn = "";
	
	/** ANSWER_AT */
	private String answerAt = "";
	
	/** PARNTSCTT_NO */
	private BigDecimal parntscttNo = null;
	
	/** ANSWER_LC */
	private BigDecimal answerLc = null;
	
	/** SORT_ORDR */
	private BigDecimal sortOrdr = null;
	
	/** RDCNT */
	private BigDecimal rdcnt = null;
	
	/** USE_AT */
	private String useAt = "";
	
	/** NTCE_BGNDE */
	private String ntceBgnde = "";
	
	/** NTCE_ENDDE */
	private String ntceEndde = "";
	
	/** NTCR_ID */
	private String ntcrId = "";
	
	/** NTCR_NM */
	private String ntcrNm = "";
	
	/** PASSWORD */
	private String password = "";
	
	/** ATCH_FILE_ID */
	private String atchFileId = "";
	
	/** FRST_REGIST_PNTTM */
	private Date frstRegistPnttm = null;
	
	/** FRST_REGISTER_ID */
	private String frstRegisterId = "";
	
	/** LAST_UPDT_PNTTM */
	private Date lastUpdtPnttm = null;
	
	/** LAST_UPDUSR_ID */
	private String lastUpdusrId = "";


	
	public BigDecimal getNttId() {
		return this.nttId;
	}
	
	public void setNttId(BigDecimal nttId) {
		this.nttId = nttId;
	}

	public String getBbsId() {
		return this.bbsId;
	}
	
	public void setBbsId(String bbsId) {
		this.bbsId = bbsId;
	}

	public BigDecimal getNttNo() {
		return this.nttNo;
	}
	
	public void setNttNo(BigDecimal nttNo) {
		this.nttNo = nttNo;
	}

	public String getNttSj() {
		return this.nttSj;
	}
	
	public void setNttSj(String nttSj) {
		this.nttSj = nttSj;
	}

	public String getNttCn() {
		return this.nttCn;
	}
	
	public void setNttCn(String nttCn) {
		this.nttCn = nttCn;
	}

	public String getAnswerAt() {
		return this.answerAt;
	}
	
	public void setAnswerAt(String answerAt) {
		this.answerAt = answerAt;
	}

	public BigDecimal getParntscttNo() {
		return this.parntscttNo;
	}
	
	public void setParntscttNo(BigDecimal parntscttNo) {
		this.parntscttNo = parntscttNo;
	}

	public BigDecimal getAnswerLc() {
		return this.answerLc;
	}
	
	public void setAnswerLc(BigDecimal answerLc) {
		this.answerLc = answerLc;
	}

	public BigDecimal getSortOrdr() {
		return this.sortOrdr;
	}
	
	public void setSortOrdr(BigDecimal sortOrdr) {
		this.sortOrdr = sortOrdr;
	}

	public BigDecimal getRdcnt() {
		return this.rdcnt;
	}
	
	public void setRdcnt(BigDecimal rdcnt) {
		this.rdcnt = rdcnt;
	}

	public String getUseAt() {
		return this.useAt;
	}
	
	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public String getNtceBgnde() {
		return this.ntceBgnde;
	}
	
	public void setNtceBgnde(String ntceBgnde) {
		this.ntceBgnde = ntceBgnde;
	}

	public String getNtceEndde() {
		return this.ntceEndde;
	}
	
	public void setNtceEndde(String ntceEndde) {
		this.ntceEndde = ntceEndde;
	}

	public String getNtcrId() {
		return this.ntcrId;
	}
	
	public void setNtcrId(String ntcrId) {
		this.ntcrId = ntcrId;
	}

	public String getNtcrNm() {
		return this.ntcrNm;
	}
	
	public void setNtcrNm(String ntcrNm) {
		this.ntcrNm = ntcrNm;
	}

	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAtchFileId() {
		return this.atchFileId;
	}
	
	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}

	public Date getFrstRegistPnttm() {
		return this.frstRegistPnttm;
	}
	
	public void setFrstRegistPnttm(Date frstRegistPnttm) {
		this.frstRegistPnttm = frstRegistPnttm;
	}

	public String getFrstRegisterId() {
		return this.frstRegisterId;
	}
	
	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}

	public Date getLastUpdtPnttm() {
		return this.lastUpdtPnttm;
	}
	
	public void setLastUpdtPnttm(Date lastUpdtPnttm) {
		this.lastUpdtPnttm = lastUpdtPnttm;
	}

	public String getLastUpdusrId() {
		return this.lastUpdusrId;
	}
	
	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}

	
	/**
	 * toString()
	 * @return String
	 */
    public String toString() {
    	return SampleStringUtil.reflectionToString(this);
    }
	
}
