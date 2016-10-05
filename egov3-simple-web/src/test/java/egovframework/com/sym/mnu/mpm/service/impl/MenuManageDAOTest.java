package egovframework.com.sym.mnu.mpm.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import sample.cmm.SampleConstant;
import egovframework.com.sym.mnu.mpm.service.MenuManageVO;

/**
 * MenuManageDAO Test
 * @author jhong
 * @since 2016.01.22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath*:egovframeworktest/spring/com/**/context-*.xml" } )
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class MenuManageDAOTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuManageDAOTest.class);

	@Autowired
	MenuManageDAO dao;
	
	/**
	 * insertMenuManage() 테스트
	 * @throws Exception
	 */
	@Test
	public void insertMenuManage() throws Exception {
		// parameters
		MenuManageVO vo = new MenuManageVO();
		vo.setMenuNm("MENU_NM");
		vo.setProgrmFileNm("dir"); // 디렉토리
		vo.setMenuNo(8888888);
		vo.setUpperMenuId(0);
		vo.setMenuOrdr(0);
		vo.setMenuDc("MENU_DC");
		vo.setRelateImagePath("RELATE_IMAGE_PATH");
		vo.setRelateImageNm("RELATE_IMAGE_NM");
//		vo.setDsplySeCode("ADM"); // 관리자
		
		dao.insertMenuManage(vo);
		assertTrue(true); // smoke test
	}

	/**
	 * updateMenuManage() 테스트
	 * @throws Exception
	 */
	@Test
	public void updateMenuManage() throws Exception {
		// parameters
		MenuManageVO vo = new MenuManageVO();
		vo.setMenuNm("MENU_NM");
		vo.setProgrmFileNm("dir");
		vo.setMenuNo(8888888);
		vo.setUpperMenuId(0);
		vo.setMenuOrdr(0);
		vo.setMenuDc("MENU_DC");
		vo.setRelateImagePath("RELATE_IMAGE_PATH");
		vo.setRelateImageNm("RELATE_IMAGE_NM");
//		vo.setDsplySeCode("ADM"); // 관리자
		
		dao.updateMenuManage(vo);
		assertTrue(true); // smoke test
	}
	
	/**
	 * deleteMenuManage() 테스트
	 * @throws Exception
	 */
	@Test
	public void deleteMenuManage() throws Exception {
		// parameters
		MenuManageVO vo = new MenuManageVO();
		vo.setMenuNo(8888888);

		dao.deleteMenuManage(vo);
		assertTrue(true); // smoke test
	}
	
	/**
	 * selectMenuNoByPk() 테스트
	 * @throws Exception
	 */
	@Test
	public void selectMenuNoByPk() throws Exception {
		// parameters
		MenuManageVO vo = new MenuManageVO();
		vo.setMenuNo(0);

		int result = dao.selectMenuNoByPk(vo);
		LOGGER.debug("selectMenuNoByPk() result={}", result);
//		assertNotNull(result);
	}

	/**
	 * selectUpperMenuNoByPk() 테스트
	 * @throws Exception
	 */
	@Test
	public void selectUpperMenuNoByPk() throws Exception {
		// parameters
		MenuManageVO vo = new MenuManageVO();
		vo.setMenuNo(0);

		int result = dao.selectUpperMenuNoByPk(vo);
		LOGGER.debug("selectUpperMenuNoByPk() result={}", result);
//		assertNotNull(result);
	}

	/**
	 * selectMenuList() 테스트
	 * @throws Exception
	 */
	@Test
	public void selectMenuList() throws Exception {
		// parameters
		
		List result = dao.selectMenuList();
		assertNotNull(result); // smoke test
	}
	
	/**
	 * deleteAllMenuList() 테스트
	 * @throws Exception
	 */
	@Ignore
	public void deleteAllMenuList() throws Exception {
		// parameters

		dao.deleteAllMenuList();
		assertTrue(true); // smoke test
	}
	
	/**
	 * selectMenuListTotCnt() 테스트
	 * @throws Exception
	 */
	@Test
	public void selectMenuListTotCnt() throws Exception {
		// parameters
		
		int result = dao.selectMenuListTotCnt();
		LOGGER.debug("selectMenuListTotCnt() result={}", result);
		assertNotNull(result); // smoke test
	}
	
//	/**
//	 * selectMainMenuHead() test
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void selectMainMenuHead() throws Exception {
//		// parameters
//		MenuManageVO vo = new MenuManageVO();
//		vo.setTmpUniqId("USRCNFRM_00000000003"); // sysmanager
////		vo.setTmpDsplySeCode(SampleConstant.MENU_DSPLY_SE_CODE_ADM); // admin
//		vo.setTmpDsplySeCode(SampleConstant.MENU_DSPLY_SE_CODE_FRT); // front
//		vo.setTmpUpperMenuId(SampleConstant.MENUNO_TOP_FRONT_OVS);
//		
//		List result = dao.selectMainMenuHead(vo);
//		LOGGER.debug("selectMainMenuHead() result={}", result);
//	}
//
//	/**
//	 * selectMainMenuLeft() test
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void selectMainMenuLeft() throws Exception {
//		// parameters
//		MenuManageVO vo = new MenuManageVO();
//		vo.setTmpUniqId("USRCNFRM_00000000003"); // sysmanager
//		vo.setTmpDsplySeCode(SampleConstant.MENU_DSPLY_SE_CODE_ADM); // admin
//		
//		List result = dao.selectMainMenuLeft(vo);
//		LOGGER.debug("selectMainMenuLeft() result={}", result);
//	}
//
//	/**
//	 * selectLastMenuDetail() test - 
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void selectLastMenuDetail() throws Exception {
//		// parameters
//		MenuManageVO vo = new MenuManageVO();
//		vo.setMenuNo(new Integer(SampleConstant.MENUNO_TOP_FRONT_SPT));
//		vo.setTmpUniqId("USRCNFRM_00000000000"); // ROLE_ADMIN
//		
//		MenuManageVO result = dao.selectLastMenuDetail(vo);
//		LOGGER.debug("selectLastMenuDetail() result={}", result);
//	}
//
//	/**
//	 * selectLastMenuDetail() test
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void selectLastMenuDetail2() throws Exception {
//		// parameters
//		MenuManageVO vo = new MenuManageVO();
//		vo.setMenuNo(new Integer(SampleConstant.MENUNO_TOP_FRONT_SPT));
////		vo.setTmpUniqId("USRCNFRM_00000000000"); // ROLE_ADMIN
//		vo.setTmpAuthorCode(SampleConstant.AUTH_ROLE_ADMIN);
//		
//		MenuManageVO result = dao.selectLastMenuDetail(vo);
//		LOGGER.debug("selectLastMenuDetail2() result={}", result);
//	}

	/**
	 * selectLastMenuURL() test
	 * 
	 * @throws Exception
	 */
	@Test
	public void selectLastMenuURL() throws Exception {
		// parameters
		MenuManageVO vo = new MenuManageVO();
		vo.setMenuNo(0);
		
		String result = dao.selectLastMenuURL(vo);
		LOGGER.debug("selectLastMenuURL() result={}", result);
	}

	/**
	 * selectLastMenuNo() 테스트
	 * @throws Exception
	 */
	@Test
	public void selectLastMenuNo() throws Exception {
		// parameters
		MenuManageVO vo = new MenuManageVO();
		vo.setMenuNo(10000000); // 해외전시
		vo.setTempValue("USRCNFRM_00000000000"); // ROLE_ADMIN
		
		int result = dao.selectLastMenuNo(vo);
		LOGGER.debug("selectLastMenuNo() result={}", result);
		assertNotNull(result); // smoke test
	}

	/**
	 * selectLastMenuNoCnt() 테스트
	 * @throws Exception
	 */
	@Test
	public void selectLastMenuNoCnt() throws Exception {
		// parameters
		MenuManageVO vo = new MenuManageVO();
		vo.setMenuNo(10000000); // 해외전시
		vo.setTempValue("USRCNFRM_00000000000"); // ROLE_ADMIN
		
		int result = dao.selectLastMenuNoCnt(vo);
		LOGGER.debug("selectLastMenuNoCnt() result={}", result);
		assertNotNull(result); // smoke test
	}

//	/**
//	 * selectMainMenuHeadByAuthor() test
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void selectMainMenuHeadByAuthor() throws Exception {
//		// parameters
//		MenuManageVO vo = new MenuManageVO();
//		vo.setAuthorCode("ROLE_ANONYMOUS");
//		
//		List result = dao.selectMainMenuHeadByAuthor(vo);
//		LOGGER.debug("selectMainMenuHeadByAuthor() result={}", result);
//	}
//
//	/**
//	 * selectMainMenuLeftByAuthor() test
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void selectMainMenuLeftByAuthor() throws Exception {
//		// parameters
//		MenuManageVO vo = new MenuManageVO();
//		vo.setAuthorCode("ROLE_ANONYMOUS");
//		
//		List result = dao.selectMainMenuLeftByAuthor(vo);
//		LOGGER.debug("selectMainMenuLeftByAuthor() result={}", result);
//	}

	/**
	 * selectMainMenuAll() test
	 * 
	 * @throws Exception
	 */
	@Test
	public void selectMainMenuAll() throws Exception {
		// parameters
		MenuManageVO vo = new MenuManageVO();
		vo.setTmpUniqId("USRCNFRM_00000000000"); // ROLE_ADMIN
//		vo.setTmpDsplySeCode(SampleConstant.MENU_DSPLY_SE_CODE_FRT); // front
		vo.setTmpUpperMenuId("2000000"); // 사용자지원
//		vo.setSearchMenuNoStart("10000000");
//		vo.setSearchMenuNoEnd("50000000");
		
		List result = dao.selectMainMenuAll(vo);
		LOGGER.debug("selectMainMenuAll() result={}", result);
	}

//	/**
//	 * selectMainMenuAllByAuthor() test
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void selectMainMenuAllByAuthor() throws Exception {
//		// parameters
//		MenuManageVO vo = new MenuManageVO();
//		vo.setAuthorCode("ROLE_ANONYMOUS");
//		vo.setTmpDsplySeCode(SampleConstant.MENU_DSPLY_SE_CODE_FRT); // front
////		vo.setSearchMenuNoStart("10000000");
////		vo.setSearchMenuNoEnd("50000000");
//		
//		List result = dao.selectMainMenuAllByAuthor(vo);
//		LOGGER.debug("selectMainMenuAllByAuthor() result={}", result);
//	}

}
