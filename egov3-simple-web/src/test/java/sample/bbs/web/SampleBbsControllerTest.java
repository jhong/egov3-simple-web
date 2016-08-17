package sample.bbs.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


/**
 * 게시판에 대한 Controller 클래스를 테스트한다
 * @Class Name : SampleBbsControllerTest.java
 * @author jhong 
 * @since 2016-08-09
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( locations = { "classpath*:egovframeworktest/springmvc/egov-com-*.xml",
									"classpath*:egovframeworktest/spring/com/**/context-*.xml" } )
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class SampleBbsControllerTest {

	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleBbsControllerTest.class);

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	/**
	 * entrySampleBbs() 테스트 - 등록화면 호출
	 * @throws Exception
	 */
	@Test
	public void entrySampleBbs() throws Exception {

		this.mockMvc.perform(post("/bbs/SampleBbsEntry.do"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("searchVO"))
		.andExpect(model().attributeExists("siteVO"))
		.andExpect(model().attributeExists("sampleBbs"))
//		.andExpect(view().name("#{tpl.tiles.type}_edit/bbs/SampleBbsRegist.tiles"))
//		.andExpect(forwardedUrl("/WEB-INF/tiles/gep/#{tpl.tiles.type}/layouts-tiles-edit.jsp"));
		.andExpect(view().name("/sample/bbs/SampleBbsRegist"))
		.andExpect(forwardedUrl("/WEB-INF/jsp/sample/bbs/SampleBbsRegist.jsp"));
	}
	
	/**
	 * insertSampleBbs() 테스트 - 등록화면 호출 (서버단 validation 오류 존재)
	 * @throws Exception
	 */
	@Test
	public void insertSampleBbs1() throws Exception {

		this.mockMvc.perform(post("/bbs/SampleBbsRegist.do")
			.param("nttId", new BigDecimal(0)+"")
			.param("bbsId", "BBS_ID"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("sampleBbs"))
		.andExpect(view().name("#{tpl.tiles.type}_edit/bbs/SampleBbsRegist.tiles"))
		.andExpect(forwardedUrl("/WEB-INF/tiles/gep/#{tpl.tiles.type}/layouts-tiles-edit.jsp"));
	}
	
	/**
	 * addSampleBbs() 테스트 - 중복 등록 체크 토큰 오류
	 * @throws Exception
	 */
	@Test
	public void insertSampleBbs2() throws Exception {

		this.mockMvc.perform(post("/bbs/SampleBbsRegist.do")
			.param("nttId", new BigDecimal(0)+"")
			.param("bbsId", "BBS_ID")
			.param("nttNo", new BigDecimal(0)+"")
			.param("nttSj", "NTT_SJ")
			.param("nttCn", "NTT_CN")
			.param("answerAt", "A")
			.param("parntscttNo", new BigDecimal(0)+"")
			.param("answerLc", new BigDecimal(0)+"")
			.param("sortOrdr", new BigDecimal(0)+"")
			.param("rdcnt", new BigDecimal(0)+"")
			.param("useAt", "U")
			.param("ntceBgnde", "NTCE_BGNDE")
			.param("ntceEndde", "NTCE_ENDDE")
			.param("ntcrId", "NTCR_ID")
			.param("ntcrNm", "NTCR_NM")
			.param("password", "PASSWORD")
			.param("atchFileId", "ATCH_FILE_ID")
			.param("frstRegistPnttm", "2016-08-09")
			.param("frstRegisterId", "FRST_REGISTER_ID")
			.param("lastUpdtPnttm", "2016-08-09")
			.param("lastUpdusrId", "LAST_UPDUSR_ID"))
		.andDo(print())
//		.andExpect(status().is(302)); // redirect
		.andExpect(status().is(200)) // 이중등록 체크 토큰 값이 없어서 에러 발생
//		.andExpect(model().attributeExists("sampleBbs"))
		.andExpect(view().name("egovframework/com/cmm/error/egovError"))
		.andExpect(forwardedUrl("/WEB-INF/jsp/egovframework/com/cmm/error/egovError.jsp"));
	}
	
	/**
	 * editSampleBbs() 테스트 - 등록화면 호출
	 * @throws Exception
	 */
	@Test
	public void editSampleBbs() throws Exception {

		this.mockMvc.perform(post("/bbs/SampleBbsEdit.do")
				
			.param("edSeq", new BigDecimal(0)+""))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("searchVO"))
		.andExpect(model().attributeExists("siteVO"))
//		.andExpect(model().attributeExists("sampleBbs"))
		.andExpect(view().name("#{tpl.tiles.type}_edit/bbs/SampleBbsModify.tiles"))
		.andExpect(forwardedUrl("/WEB-INF/tiles/gep/#{tpl.tiles.type}/layouts-tiles-edit.jsp"));
	}
	
	/**
	 * updateSampleBbs() 테스트 - 수정화면 조회
	 * @throws Exception
	 */
	@Test
	public void updateSampleBbs1() throws Exception {
	
		this.mockMvc.perform(post("/bbs/SampleBbsModify.do")
				.param("nttId", new BigDecimal(0)+"")
			.param("bbsId", "BBS_ID"))
		.andDo(print())
		.andExpect(model().attributeExists("searchVO"))
		.andExpect(model().attributeExists("siteVO"))
		.andExpect(status().isOk())
//		.andExpect(model().attributeExists("sampleBbs"))
		.andExpect(view().name("#{tpl.tiles.type}_edit/bbs/SampleBbsModify.tiles"))
		.andExpect(forwardedUrl("/WEB-INF/tiles/gep/#{tpl.tiles.type}/layouts-tiles-edit.jsp"));
	}
	
	/**
	 * updateSampleBbs() 테스트 - 수정시 validation 에러 발생
	 * @throws Exception
	 */
	@Test
	public void updateSampleBbs2() throws Exception {
	
		this.mockMvc.perform(post("/bbs/SampleBbsModify.do")
			.param("cmd", "Modify").param("nttId", new BigDecimal(0)+"")
			.param("bbsId", "BBS_ID"))
				
		.andDo(print())
		.andExpect(status().isOk())
//		.andExpect(model().attributeExists("sampleBbs"))
//		.andExpect(view().name("forward:/bbs/SampleBbsList.do"))
//		.andExpect(forwardedUrl("/bbs/SampleBbsList.do"));
		.andExpect(view().name("#{tpl.tiles.type}_edit/bbs/SampleBbsModify.tiles"))
		.andExpect(forwardedUrl("/WEB-INF/tiles/gep/#{tpl.tiles.type}/layouts-tiles-edit.jsp"));
	}
	
	/**
	 * deleteSampleBbs() 테스트
	 * @throws Exception
	 */
	@Test
	public void deleteSampleBbs() throws Exception {
	
		this.mockMvc.perform(post("/bbs/SampleBbsRemove.do")
				.param("nttId", new BigDecimal(0)+"")
			.param("bbsId", "BBS_ID"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("sampleBbs"))
		.andExpect(view().name("forward:/bbs/SampleBbsList.do"))
		.andExpect(forwardedUrl("/bbs/SampleBbsList.do"));
	}

	/**
	 * selectSampleBbsDetail() 테스트
	 * @throws Exception
	 */
	@Test
	public void selectSampleBbsDetail() throws Exception {
		
		this.mockMvc.perform(get("/bbs/SampleBbsDetail.do")
			.param("nttId", new BigDecimal(0)+"")
			.param("bbsId", "BBS_ID"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("searchVO"))
		.andExpect(model().attributeExists("siteVO"))
//		.andExpect(model().attributeExists("result"))
		.andExpect(view().name("#{tpl.tiles.type}_view/bbs/SampleBbsDetail.tiles"))
		.andExpect(forwardedUrl("/WEB-INF/tiles/gep/#{tpl.tiles.type}/layouts-tiles-view.jsp"));
	}

	/**
	 * selectSampleBbsList() 테스트
	 * @throws Exception
	 */
	@Test
	public void selectSampleBbsList() throws Exception {
		
		this.mockMvc.perform(get("/bbs/SampleBbsList.do"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("searchVO"))
		.andExpect(model().attributeExists("siteVO"))
		.andExpect(model().attributeExists("resultList"))
		.andExpect(view().name("#{tpl.tiles.type}_list/bbs/SampleBbsList.tiles"))
//		.andExpect(forwardedUrl("/WEB-INF/jsp//bbs/SampleBbs.jsp"));
		.andExpect(forwardedUrl("/WEB-INF/tiles/gep/#{tpl.tiles.type}/layouts-tiles-list.jsp"));
	}
	
}
