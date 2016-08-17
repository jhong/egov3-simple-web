package sample.bbs.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import sample.bbs.service.SampleBbs;
import sample.bbs.service.SampleBbsService;
import sample.bbs.service.SampleBbsVO;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 게시판에 대한 서비스 구현 클래스를 테스트한다
 * @Class Name : SampleBbsServiceTest.java
 * @author jhong 
 * @since 2016-08-09
 * @version 1.0
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath*:egovframeworktest/spring/com/**/context-*.xml" } )
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class SampleBbsServiceTest {

	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleBbsServiceTest.class);

	@Autowired
	SampleBbsService service;
	
	/**
	 * insertSampleBbs() 테스트
	 * @throws Exception
	 */
	@Test
	public void insertSampleBbs() throws Exception {
		// parameters
		SampleBbs vo = new SampleBbs();
		vo.setNttId(new BigDecimal(0));
		vo.setBbsId("BBSMSTR_000000000001");
		vo.setNttNo(new BigDecimal(0));
		vo.setNttSj("NTT_SJ");
		vo.setNttCn("NTT_CN");
		vo.setAnswerAt("A");
		vo.setParntscttNo(new BigDecimal(0));
		vo.setAnswerLc(new BigDecimal(0));
		vo.setSortOrdr(new BigDecimal(0));
		vo.setRdcnt(new BigDecimal(0));
		vo.setUseAt("U");
		vo.setNtceBgnde("NTCE_BGNDE");
		vo.setNtceEndde("NTCE_ENDDE");
		vo.setNtcrId("NTCR_ID");
		vo.setNtcrNm("NTCR_NM");
		vo.setPassword("PASSWORD");
		vo.setAtchFileId("ATCH_FILE_ID");
		vo.setFrstRegistPnttm(null);
		vo.setFrstRegisterId("FRST_REGISTER_ID");
		vo.setLastUpdtPnttm(null);
		vo.setLastUpdusrId("LAST_UPDUSR_ID");
		
		service.insertSampleBbs(vo);
		assertTrue(true); // smoke test
	}
	
	/**
	 * updateSampleBbs() 테스트
	 * @throws Exception
	 */
	@Test
	public void updateSampleBbs() throws Exception {
		// parameters
		SampleBbs vo = new SampleBbs();
		vo.setNttId(new BigDecimal(0));
		vo.setBbsId("BBS_ID");
		vo.setNttNo(new BigDecimal(0));
		vo.setNttSj("NTT_SJ");
		vo.setNttCn("NTT_CN");
		vo.setAnswerAt("A");
		vo.setParntscttNo(new BigDecimal(0));
		vo.setAnswerLc(new BigDecimal(0));
		vo.setSortOrdr(new BigDecimal(0));
		vo.setRdcnt(new BigDecimal(0));
		vo.setUseAt("U");
		vo.setNtceBgnde("NTCE_BGNDE");
		vo.setNtceEndde("NTCE_ENDDE");
		vo.setNtcrId("NTCR_ID");
		vo.setNtcrNm("NTCR_NM");
		vo.setPassword("PASSWORD");
		vo.setAtchFileId("ATCH_FILE_ID");
		vo.setFrstRegistPnttm(null);
		vo.setFrstRegisterId("FRST_REGISTER_ID");
		vo.setLastUpdtPnttm(null);
		vo.setLastUpdusrId("LAST_UPDUSR_ID");
		
		service.updateSampleBbs(vo);
		assertTrue(true); // smoke test
	}

	/**
	 * deleteSampleBbs() 테스트
	 * @throws Exception
	 */
	@Test
	public void deleteSampleBbs() throws Exception {
		// parameters
		SampleBbs vo = new SampleBbs();
		vo.setNttId(new BigDecimal(0));
		vo.setBbsId("BBS_ID");

		service.deleteSampleBbs(vo);
		assertTrue(true); // smoke test
	}

	/**
	 * selectSampleBbsDetail() 테스트
	 * @throws Exception
	 */
	@Test
	public void selectSampleBbsDetail() throws Exception {
		// parameters
		SampleBbs vo = new SampleBbs();
		vo.setNttId(new BigDecimal(0));
		vo.setBbsId("BBS_ID");

		SampleBbs result = service.selectSampleBbsDetail(vo);
		LOGGER.debug("selectSampleBbsDetail() result={}", result);
//		assertNotNull(result);
//		assertEquals(vo.getId(), result.getId());
	}
	
	/**
	 * selecSampleBbstList() 테스트
	 * @throws Exception
	 */
	@Test
	public void selectSampleBbsList() throws Exception {
		// parameters
		SampleBbsVO searchVO = new SampleBbsVO();
		searchVO.setSearchCondition("nttSj");
		searchVO.setSearchKeyword("NTT_SJ");
		
		List result = service.selectSampleBbsList(searchVO);
		assertNotNull(result); // smoke test
	}
	
	/**
	 * selectSampleBbsListTotCnt() 테스트
	 * @throws Exception
	 */
	@Test
	public void selectSampleBbsListTotCnt() throws Exception {
		// parameters
		SampleBbsVO searchVO = new SampleBbsVO();
		searchVO.setSearchCondition("nttSj");
		searchVO.setSearchKeyword("NTT_SJ");
		
		int result = service.selectSampleBbsListTotCnt(searchVO);
		assertNotNull(result); // smoke test
	}

}
