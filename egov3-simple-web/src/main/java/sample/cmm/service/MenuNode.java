package sample.cmm.service;

import javax.swing.tree.DefaultMutableTreeNode;

import sample.cmm.util.SampleStringUtil;

/**
 * 메뉴 TreeNode 클래스
 *
 * @author jhong
 * @since 2016.02.01
 * @version 1.0
 */
public class MenuNode extends DefaultMutableTreeNode {

	private static final long serialVersionUID = 1L;
	
	/** 메뉴정보 */
	/** 메뉴번호 */
	private	int		menuNo;
	/** 메뉴순서 */
	private	int		menuOrdr;
	/** 메뉴명 */
	private	String	menuNm;
	/** 상위메뉴번호 */
	private	int		upperMenuNo;
	/** 메뉴설명 */
	private	String	menuDc;
	/** 관련이미지경로 */
	private	String	relateImagePath;
	/** 관련이미지명 */
	private	String	relateImageNm;
	/** 프로그램파일명 */
	private	String	progrmFileNm;

	/** 권한정보설정 */
	/** 권한코드 */
	private	String	authorCode;

	/** chkURL */
	private	String	chkURL;

	/** LastLink 정보를 가지는 MenuNode */
	MenuNode lastLinkNode;
	
	/** LEVEL2 TOP 메뉴 정보 */
	private int menuNoLevel2;
	
	/** 링크를 걸기 위한 메뉴번호 */
	private int linkMenuNo;
	
	/** 링크를 걸기 위한 상위메뉴번호 */
	private int linkUpperMenuNo;
	
	/** 게시여부 */
	private String ntceAt;
	
	/** 외부링크여부 */
	private String extrlLinkAt;
	
	/**
	 * menuNo attribute를 리턴한다.
	 * @return int
	 */
	public int getMenuNo() {
		return menuNo;
	}
	/**
	 * menuNo attribute 값을 설정한다.
	 * @param menuNo int
	 */
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	/**
	 * menuOrdr attribute를 리턴한다.
	 * @return int
	 */
	public int getMenuOrdr() {
		return menuOrdr;
	}
	/**
	 * menuOrdr attribute 값을 설정한다.
	 * @param menuOrdr int
	 */
	public void setMenuOrdr(int menuOrdr) {
		this.menuOrdr = menuOrdr;
	}
	/**
	 * menuNm attribute를 리턴한다.
	 * @return String
	 */
	public String getMenuNm() {
		return menuNm;
	}
	/**
	 * menuNm attribute 값을 설정한다.
	 * @param menuNm String
	 */
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	/**
	 * upperMenuNo attribute를 리턴한다.
	 * @return int
	 */
	public int getUpperMenuNo() {
		return upperMenuNo;
	}
	/**
	 * upperMenuNo attribute 값을 설정한다.
	 * @param upperMenuNo int
	 */
	public void setUpperMenuNo(int upperMenuNo) {
		this.upperMenuNo = upperMenuNo;
	}
	/**
	 * menuDc attribute를 리턴한다.
	 * @return String
	 */
	public String getMenuDc() {
		return menuDc;
	}
	/**
	 * menuDc attribute 값을 설정한다.
	 * @param menuDc String
	 */
	public void setMenuDc(String menuDc) {
		this.menuDc = menuDc;
	}
	/**
	 * relateImagePath attribute를 리턴한다.
	 * @return String
	 */
	public String getRelateImagePath() {
		return relateImagePath;
	}
	/**
	 * relateImagePath attribute 값을 설정한다.
	 * @param relateImagePath String
	 */
	public void setRelateImagePath(String relateImagePath) {
		this.relateImagePath = relateImagePath;
	}
	/**
	 * relateImageNm attribute를 리턴한다.
	 * @return String
	 */
	public String getRelateImageNm() {
		return relateImageNm;
	}
	/**
	 * relateImageNm attribute 값을 설정한다.
	 * @param relateImageNm String
	 */
	public void setRelateImageNm(String relateImageNm) {
		this.relateImageNm = relateImageNm;
	}
	/**
	 * progrmFileNm attribute를 리턴한다.
	 * @return String
	 */
	public String getProgrmFileNm() {
		return progrmFileNm;
	}
	/**
	 * progrmFileNm attribute 값을 설정한다.
	 * @param progrmFileNm String
	 */
	public void setProgrmFileNm(String progrmFileNm) {
		this.progrmFileNm = progrmFileNm;
	}
	/**
	 * authorCode attribute를 리턴한다.
	 * @return String
	 */
	public String getAuthorCode() {
		return authorCode;
	}
	/**
	 * authorCode attribute 값을 설정한다.
	 * @param authorCode String
	 */
	public void setAuthorCode(String authorCode) {
		this.authorCode = authorCode;
	}
	
	public String getChkURL() {
		return chkURL;
	}
	
	public void setChkURL(String chkURL) {
		this.chkURL = chkURL;
	}
	
	public MenuNode getLastLinkNode() {
		return lastLinkNode;
	}
	
	public void setLastLinkNode(MenuNode lastLinkNode) {
		this.lastLinkNode = lastLinkNode;
	}
	
	/**
	 * menuNoLevel2 attribute를 리턴한다.
	 * @return int
	 */
	public int getMenuNoLevel2() {
		return menuNoLevel2;
	}
	/**
	 * menuNoLevel2 attribute 값을 설정한다.
	 * @param menuNoLevel2 int
	 */
	public void setMenuNoLevel2(int menuNoLevel2) {
		this.menuNoLevel2 = menuNoLevel2;
	}
	
	/**
	 * linkMenuNo attribute를 리턴한다.
	 * @return int
	 */
	public int getLinkMenuNo() {
		return linkMenuNo;
	}
	/**
	 * linkMenuNo attribute 값을 설정한다.
	 * @param linkMenuNo int
	 */
	public void setLinkMenuNo(int linkMenuNo) {
		this.linkMenuNo = linkMenuNo;
	}
	
	/**
	 * linkUpperMenuNo attribute를 리턴한다.
	 * @return int
	 */
	public int getLinkUpperMenuNo() {
		return linkUpperMenuNo;
	}
	/**
	 * linkUpperMenuNo attribute 값을 설정한다.
	 * @param linkUpperMenuNo int
	 */
	public void setLinkUpperMenuNoo(int linkUpperMenuNo) {
		this.linkUpperMenuNo = linkUpperMenuNo;
	}
	
	public String getNtceAt() {
		return ntceAt;
	}
	public void setNtceAt(String ntceAt) {
		this.ntceAt = ntceAt;
	}
	
	public String getExtrlLinkAt() {
		return extrlLinkAt;
	}
	public void setExtrlLinkAt(String extrlLinkAt) {
		this.extrlLinkAt = extrlLinkAt;
	}
	
	/**
	 * toString
	 * @return String
	 */
	 public String toString() {
	 	return SampleStringUtil.reflectionToString(this);
	 }

}
