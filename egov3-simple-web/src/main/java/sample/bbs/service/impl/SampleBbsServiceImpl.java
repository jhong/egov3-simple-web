package sample.bbs.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import sample.bbs.service.SampleBbs;
import sample.bbs.service.SampleBbsService;
import sample.bbs.service.SampleBbsVO;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;


/**  
 * 게시판에 대한 서비스 클래스를 구현한다
 * @Class Name : SampleBbsServiceImpl.java
 * @author jhong 
 * @since 2016-08-09
 * @version 1.0
 */
@Service("SampleBbsService")
public class SampleBbsServiceImpl extends EgovAbstractServiceImpl implements SampleBbsService {

	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleBbsServiceImpl.class);
	
	/** sampleBbsMapper */
    @Resource(name="SampleBbsMapper")
    private SampleBbsMapper sampleBbsMapper;
    
    @Resource(name = "egovNttIdGnrService")
    private EgovIdGnrService nttIdgenService;

	/**
	 * 게시판 등록 화면 호출시 기본 데이터 세팅
	 */
	public SampleBbs initSampleBbs(SampleBbs sampleBbs) throws Exception {
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();

    	sampleBbs.setNttNo(new BigDecimal(1));
    	sampleBbs.setAnswerAt("N");
    	sampleBbs.setParntscttNo(new BigDecimal(0));
    	sampleBbs.setAnswerLc(new BigDecimal(0));
//    	sampleBbs.setSortOrdr(new BigDecimal(0)); // insert query 에서 직접 생성함
    	sampleBbs.setRdcnt(new BigDecimal(0));
    	sampleBbs.setUseAt("Y");
    	sampleBbs.setNtceBgnde("10000101            ");
    	sampleBbs.setNtceEndde("99991231            ");
    	sampleBbs.setNtcrId(user.getId());
    	sampleBbs.setNtcrNm(user.getName());
    	sampleBbs.setFrstRegisterId(user.getUniqId());
//    	sampleBbs.setFrstRegistPnttm();
    	
    	return sampleBbs;
	}

	/**
	 * 게시판 을(를) 등록한다.
	 */
	public void insertSampleBbs(SampleBbs sampleBbs) throws Exception {
		// NTT_ID세팅
		int nttId = nttIdgenService.getNextIntegerId();
		LOGGER.debug("insertSampleBbs() nttId={}", nttId);
		sampleBbs.setNttId(new BigDecimal(nttId));
		
    	sampleBbsMapper.insertSampleBbs(sampleBbs);
    	LOGGER.debug("insertSampleBbs() end... sampleBbs={}", sampleBbs);
	}

	/**
	 * 게시판 을(를) 수정한다.
	 */
	public void updateSampleBbs(SampleBbs sampleBbs) throws Exception {
		sampleBbsMapper.updateSampleBbs(sampleBbs);
	}

	/**
	 * 게시판 을(를) 삭제한다.
	 */
	public void deleteSampleBbs(SampleBbs sampleBbs) throws Exception {
		sampleBbsMapper.deleteSampleBbs(sampleBbs);
	}

	/**
	 * 게시판 상세항목을 조회한다.
	 */
	public SampleBbs selectSampleBbsDetail(SampleBbs sampleBbs) throws Exception {
    	SampleBbs result = (SampleBbs)sampleBbsMapper.selectSampleBbsDetail(sampleBbs);
    	return result;
	}

	/**
	 * 게시판 목록을 조회한다.
	 */
	public List selectSampleBbsList(SampleBbsVO searchVO) throws Exception {
        return sampleBbsMapper.selectSampleBbsList(searchVO);
	}

	/**
	 * 게시판 총 갯수를 조회한다.
	 */
	public int selectSampleBbsListTotCnt(SampleBbsVO searchVO) throws Exception {
        return sampleBbsMapper.selectSampleBbsListTotCnt(searchVO);
	}

}
