package sample.cmm.util;

import java.util.Enumeration;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import sample.cmm.service.MenuNode;
import egovframework.com.sym.mnu.mpm.service.EgovMenuManageService;
import egovframework.com.sym.mnu.mpm.service.MenuManageVO;

@Component
public class SampleMenuUtil {

	/** LOGGER */
	private final static Logger LOGGER = LoggerFactory.getLogger(SampleMenuUtil.class);

	
	/** static 필드에 주입 start */
	protected static EgovMenuManageService menuManageService;
	
	@Resource(name = "meunManageService")
    private EgovMenuManageService menuManageServiceInstance;

    @PostConstruct
    private void init() {
    	menuManageService = menuManageServiceInstance;
    }
    /** static 필드에 주입 end */

	/**
	 * mene list 반환
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List selectMenuList() throws Exception {
		List menuList = menuManageService.selectMenuList();
		LOGGER.debug("SampleMenuUtil() selectMenuList={}", menuList);
		return menuList;
	}
	
	/**
	 * mene tree 반환
	 * 
	 * @return
	 * @throws Exception
	 */
	public static MenuNode selectMenuTree(MenuManageVO vo) throws Exception {
		
		List menuList = menuManageService.selectMainMenuAll(vo);
		LOGGER.debug("selectMenuTree() selectMenuList={}", menuList);
		
		MenuNode menuTree = menuManageService.makeMenuNode(menuList);
		return menuTree;
	}

	/**
	 * menu tree 표시
	 * 
	 * @param node
	 * @param rootDepth
	 * @param sb
	 * @throws Exception
	 */
	public static void displayMenuTree(MenuNode node, int rootDepth, StringBuffer sb) throws Exception {

//		sb.append("\n"+node.getDepth()+"\t");
		sb.append("\n");
		for (int i=node.getDepth(); i<rootDepth; i++) {
			sb.append("-- ");
		}
		sb.append(node.getMenuNo()+", "+node.getMenuNm());
		

		Enumeration children = node.children();
		while (children.hasMoreElements()) {
			MenuNode child = (MenuNode)children.nextElement();
			
			displayMenuTree(child, rootDepth, sb);
		}
	}

}
