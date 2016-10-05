package egovframework.com.sym.mnu.mpm.service.impl;

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

import sample.cmm.service.MenuNode;
import sample.cmm.util.SampleMenuUtil;
import egovframework.com.sym.mnu.mpm.service.EgovMenuManageService;
import egovframework.com.sym.mnu.mpm.service.MenuManageVO;

/**
 * 메뉴 관리에 대한 서비스 구현 클래스를 테스트한다
 * @Class Name : EgovMenuManageServiceTest.java
 * @author jhong 
 * @since 2016-01-22
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 * @
 * @ 수정일		수정자		수정내용
 * @ ---------	---------	-------------------------------
 * @ 2016-01-22	jhong	최초생성
 * 
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath*:egovframeworktest/spring/com/**/context-*.xml" } )
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class EgovMenuManageServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovMenuManageServiceTest.class);

	@Autowired
	EgovMenuManageService service;

//	/**
//	 * selectMainMenuHead() test
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void selectMainMenuHead() throws Exception {
//		// parameters
//		MenuManageVO vo = new MenuManageVO();
//		vo.setTmpUpperMenuId(SampleConstant.MENUNO_TOP_FRONT_DMT);
//		vo.setTmpUniqId("USRCNFRM_00000000004");
//		vo.setTmpDsplySeCode(SampleConstant.MENU_DSPLY_SE_CODE_FRT);
//		
//		List result = service.selectMainMenuHead(vo);
//		LOGGER.debug("selectMainMenuHead() result={}", result);
//
//		MenuManageVO vo2 = new MenuManageVO();
//		vo2.setTmpUpperMenuId(SampleConstant.MENUNO_TOP_FRONT_DMT);
//		vo2.setTmpUniqId("USRCNFRM_00000000004");
//		vo2.setTmpDsplySeCode(SampleConstant.MENU_DSPLY_SE_CODE_FRT);
//		List result2 = service.selectMainMenuHead(vo2);
//		LOGGER.debug("selectMainMenuHead() result2={}", result);
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
//		vo.setTmpUniqId("USRCNFRM_00000000004");
//		vo.setTmpDsplySeCode(SampleConstant.MENU_DSPLY_SE_CODE_FRT);
//		
//		List result = service.selectMainMenuLeft(vo);
//		LOGGER.debug("selectMainMenuLeft() result={}", result);
//
//		List result2 = service.selectMainMenuLeft(vo);
//		LOGGER.debug("selectMainMenuLeft() result2={}", result);
//}
//
//	/**
//	 * selectLastMenuDetail() test
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void selectLastMenuDetail() throws Exception {
//		// parameters
//		MenuManageVO vo = new MenuManageVO();
//		vo.setMenuNo(new Integer(SampleConstant.MENUNO_TOP_FRONT_DMT));
//		//vo.setTmpUniqId("USRCNFRM_00000000000"); // ROLE_ADMIN
//		vo.setTmpAuthorCode(SampleConstant.AUTH_ROLE_ANONYMOUS);
//		
//		MenuManageVO result = service.selectLastMenuDetail(vo);
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
//		vo.setMenuNo(new Integer(SampleConstant.MENUNO_TOP_ADMIN_OVS));
//		vo.setTmpUniqId("USRCNFRM_00000000005"); // ROLE_SUPER_ADMIN
//		
//		MenuManageVO result = service.selectLastMenuDetail(vo);
//		LOGGER.debug("selectLastMenuDetail2() result={}", result);
//	}
//
//	/**
//	 * selectLastMenuURL() test
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void selectLastMenuURL() throws Exception {
//		// parameters
//		int iMenuNo = new Integer(SampleConstant.MENUNO_TOP_FRONT_MY);
//		String sUniqId = "USRCNFRM_00000000000"; // ROLE_ADMIN
//		
//		String result = service.selectLastMenuURL(iMenuNo, sUniqId);
//		LOGGER.debug("selectLastMenuURL() result={}", result);
//	}
//
//	/**
//	 * selectLastMenuURL() test
//	 * 
//	 * @throws Exception
//	 */
//	@Test
//	public void selectLastMenuURL2() throws Exception {
//		// parameters
//		int iMenuNo = new Integer(SampleConstant.MENUNO_TOP_ADMIN_OVS);
//		String sUniqId = "USRCNFRM_00000000005"; // ROLE_SUPER_ADMIN
//		
//		String result = service.selectLastMenuURL(iMenuNo, sUniqId);
//		LOGGER.debug("selectLastMenuURL2() result={}", result);
//	}
//
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
//		List result = service.selectMainMenuHeadByAuthor(vo);
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
//		List result = service.selectMainMenuLeftByAuthor(vo);
//		LOGGER.debug("selectMainMenuLeftByAuthor() result={}", result);
//	}

	/**
	 * selectMainMenuAll() test
	 * @throws Exception
	 */
	@Test
	public void selectMainMenuAll() throws Exception {
		// parameters
//		String tmpUpperMenuId = "2000000"; // 사용자지원
		String tmpUpperMenuId = "0"; // root
		
		MenuManageVO vo = new MenuManageVO();
		vo.setTmpUniqId("USRCNFRM_00000000000"); // ROLE_ADMIN
		vo.setTmpUpperMenuId(tmpUpperMenuId);
		
		List menuList = service.selectMainMenuAll(vo);
		LOGGER.debug("selectMainMenuAll() menuList={}", menuList);

		MenuNode menu = service.makeMenuNode(menuList, tmpUpperMenuId);
		LOGGER.debug("selectMainMenuAll() menu.getChildCount()={}", menu == null ? 0 : menu.getChildCount());
		
		StringBuffer sb = new StringBuffer();
		SampleMenuUtil.displayMenuTree(menu, menu.getDepth(), sb);
		LOGGER.debug("displayMenuTree result... sb={}", sb);

//		MenuManageVO vo2 = new MenuManageVO();
//		vo2.setTmpUniqId("USRCNFRM_00000000000"); // ROLE_ADMIN
//		vo2.setTmpUpperMenuId("2000000"); // 사용자지원
//		List menuList2 = service.selectMainMenuAll(vo2);
//		LOGGER.debug("selectMainMenuAll() menuList2={}", menuList2);
	}

//	/**
//	 * selectMainMenuAllByAuthor() test
//	 * @throws Exception
//	 */
//	@Test
//	public void selectMainMenuAllByAuthor() throws Exception {
//		// parameters
//		MenuManageVO vo = new MenuManageVO();
////		vo.setAuthorCode("ROLE_ANONYMOUS");
////		vo.setAuthorCode("ROLE_ADMIN");
//		vo.setAuthorCode("ROLE_SYS_ADMIN");
//		
//		List menuList = service.selectMainMenuAllByAuthor(vo);
//		LOGGER.debug("selectMainMenuAllByAuthor() menuList={}", menuList);
//
//		List menuList2 = service.selectMainMenuAllByAuthor(vo);
//		LOGGER.debug("selectMainMenuAllByAuthor() menuList2={}", menuList2);
//
//		MenuNode menu = service.makeMenuNode(menuList);
//		LOGGER.debug("selectMainMenuAllByAuthor() menu.getChildCount()={}", menu == null ? 0 : menu.getChildCount());
//	}
//
//	/**
//	 * addLastLinkMenu() test
//	 * @throws Exception
//	 */
//	@Test
//	public void addLastLinkMenu() throws Exception {
//		// parameters
//		MenuNode root = new MenuNode();
//		
//		MenuNode child1 = new MenuNode();
//		child1.setMenuNo(new Integer(SampleConstant.MENUNO_TOP_FRONT_MY));
//		
//		MenuNode child2 = new MenuNode();
//		
//		root.add(child1);
//		child1.add(child2);
//		
//		service.addLastLinkMenu(root);
//		LOGGER.debug("addLastLinkMenu() result... root={}", root);
//	}
	
//	/**
//	 * selectMenuNode() test
//	 * @throws Exception
//	 */
//	@Test
//	public void selectMenuNode() throws Exception {
//		// parameters
//		MenuManageVO vo = new MenuManageVO();
//		vo.setTmpUniqId("USRCNFRM_00000000000"); // ROLE_ADMIN
//		vo.setTmpUpperMenuId(SampleConstant.MENUNO_TOP_FRONT_DMT);
//		
//		MenuNode menu = service.selectMenuNode(vo, SampleConstant.MENUNO_TOP_FRONT_DMT);
//		LOGGER.debug("selectMenuNode() menu.getChildCount()={}", menu == null ? 0 : menu.getChildCount());
//
//		MenuManageVO vo2 = new MenuManageVO();
//		vo2.setTmpUniqId("USRCNFRM_00000000000"); // ROLE_ADMIN
//		vo2.setTmpUpperMenuId(SampleConstant.MENUNO_TOP_FRONT_DMT);
//		
//		MenuNode menu2 = service.selectMenuNode(vo2, SampleConstant.MENUNO_TOP_FRONT_DMT);
//		LOGGER.debug("selectMenuNode() menu2.getChildCount()=={}", menu2 == null ? 0 : menu2.getChildCount());
//	}

}
