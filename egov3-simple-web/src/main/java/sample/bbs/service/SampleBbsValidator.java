package sample.bbs.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**  
 * 게시판 Validator
 * @Class Name : SampleBbsValidator.java
 * @author jhong 
 * @since 2016-08-09
 * @version 1.0
 */
@Component("SampleBbsValidator")
public class SampleBbsValidator implements Validator {

	/**
	 * supports
	 */
	public boolean supports(Class clazz) {
		return clazz.equals(SampleBbs.class);
	}
    
	/**
	 * validate
	 */
	public void validate(Object obj, Errors errors) {
		SampleBbs vo = (SampleBbs) obj;

//		ValidationUtils.rejectIfEmpty(errors, "nttId", "errors.required", "nttId is required."); // NTT_ID
		ValidationUtils.rejectIfEmpty(errors, "bbsId", "errors.required", "bbsId is required."); // BBS_ID
		ValidationUtils.rejectIfEmpty(errors, "nttNo", "errors.required", "nttNo is required."); // NTT_NO
		ValidationUtils.rejectIfEmpty(errors, "nttSj", "errors.required", "nttSj is required."); // NTT_SJ
		ValidationUtils.rejectIfEmpty(errors, "nttCn", "errors.required", "nttCn is required."); // NTT_CN
		ValidationUtils.rejectIfEmpty(errors, "answerAt", "errors.required", "answerAt is required."); // ANSWER_AT
		ValidationUtils.rejectIfEmpty(errors, "parntscttNo", "errors.required", "parntscttNo is required."); // PARNTSCTT_NO
		ValidationUtils.rejectIfEmpty(errors, "answerLc", "errors.required", "answerLc is required."); // ANSWER_LC
//		ValidationUtils.rejectIfEmpty(errors, "sortOrdr", "errors.required", "sortOrdr is required."); // SORT_ORDR
		ValidationUtils.rejectIfEmpty(errors, "rdcnt", "errors.required", "rdcnt is required."); // RDCNT
		ValidationUtils.rejectIfEmpty(errors, "useAt", "errors.required", "useAt is required."); // USE_AT
		ValidationUtils.rejectIfEmpty(errors, "ntceBgnde", "errors.required", "ntceBgnde is required."); // NTCE_BGNDE
		ValidationUtils.rejectIfEmpty(errors, "ntceEndde", "errors.required", "ntceEndde is required."); // NTCE_ENDDE
		ValidationUtils.rejectIfEmpty(errors, "ntcrId", "errors.required", "ntcrId is required."); // NTCR_ID
		ValidationUtils.rejectIfEmpty(errors, "ntcrNm", "errors.required", "ntcrNm is required."); // NTCR_NM
//		ValidationUtils.rejectIfEmpty(errors, "password", "errors.required", "password is required."); // PASSWORD
//		ValidationUtils.rejectIfEmpty(errors, "atchFileId", "errors.required", "atchFileId is required."); // ATCH_FILE_ID
//		ValidationUtils.rejectIfEmpty(errors, "frstRegistPnttm", "errors.required", "frstRegistPnttm is required."); // FRST_REGIST_PNTTM
		ValidationUtils.rejectIfEmpty(errors, "frstRegisterId", "errors.required", "frstRegisterId is required."); // FRST_REGISTER_ID
//		ValidationUtils.rejectIfEmpty(errors, "lastUpdtPnttm", "errors.required", "lastUpdtPnttm is required."); // LAST_UPDT_PNTTM
//		ValidationUtils.rejectIfEmpty(errors, "lastUpdusrId", "errors.required", "lastUpdusrId is required."); // LAST_UPDUSR_ID

	}
}
