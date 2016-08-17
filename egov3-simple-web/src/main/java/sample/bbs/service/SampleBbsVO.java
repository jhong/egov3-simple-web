package sample.bbs.service;

import java.io.Serializable;
import java.util.Date;

/**  
 * @Class Name : SampleBbsVO.java
 * @author jhong
 * @since 2016-08-11
 * @version 1.0
 */
public class SampleBbsVO extends SampleBbs implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** 검색조건 */
    private String searchCondition = "";

    /** 검색Keyword */
    private String searchKeyword = "";

	/** 검색조건2 */
    private String searchCondition2 = "";

    /** 검색Keyword2 */
    private String searchKeyword2 = "";
    
	/** 검색조건3 */
    private String searchCondition3 = "";

    /** 검색Keyword3 */
    private String searchKeyword3 = "";
    
	/** 검색조건4 */
    private String searchCondition4 = "";

    /** 검색Keyword4 */
    private String searchKeyword4 = "";

	/** 검색조건5 */
    private String searchCondition5 = "";

    /** 검색Keyword5 */
    private String searchKeyword5 = "";
    
	/** 날짜 검색조건 */
    private String searchDateCondition = "";
    
    /** 날짜 검색 시작일 */
    private Date searchStartDate = null;

    /** 날짜 검색 종료일 */
    private Date searchEndDate = null;

    /** 검색사용여부 */
    private String searchUseYn = "";
    
    /** 현재페이지 */
    private int pageIndex = 1;
    
    /** 페이지갯수 */
    private int pageUnit = 10;
    
    /** 페이지사이즈 */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;

    /** 정렬조건 */
    private String orderCondition; // sorting parameter
    
    /** 정렬순서 */
    private String orderType; // sorting parameter

	/**
	 * searchCondition attribute 를 리턴한다.
	 * @return String
	 */
	public String getSearchCondition() {
		return searchCondition;
	}

	/**
	 * searchCondition attribute 값을 설정한다.
	 * @param searchCondition String
	 */
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	/**
	 * searchKeyword attribute 를 리턴한다.
	 * @return String
	 */
	public String getSearchKeyword() {
		return searchKeyword;
	}

	/**
	 * searchKeyword attribute 값을 설정한다.
	 * @param searchKeyword String
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

    /**
     * searchCondition2 attribute 를 리턴한다.
     * @return String
     */
    public String getSearchCondition2() {
        return searchCondition2;
    }

    /**
     * searchCondition2 attribute 값을 설정한다.
     * @param searchCondition2 String
     */
    public void setSearchCondition2(String searchCondition2) {
        this.searchCondition2 = searchCondition2;
    }

    /**
     * searchKeyword2 attribute 를 리턴한다.
     * @return String
     */
    public String getSearchKeyword2() {
        return searchKeyword2;
    }

    /**
     * searchKeyword2 attribute 값을 설정한다.
     * @param searchKeyword2 String
     */
    public void setSearchKeyword2(String searchKeyword2) {
        this.searchKeyword2 = searchKeyword2;
    }

    /**
     * searchCondition3 attribute 를 리턴한다.
     * @return String
     */
    public String getSearchCondition3() {
        return searchCondition3;
    }

    /**
     * searchCondition3 attribute 값을 설정한다.
     * @param searchCondition3 String
     */
    public void setSearchCondition3(String searchCondition3) {
        this.searchCondition3 = searchCondition3;
    }

    /**
     * searchKeyword3 attribute 를 리턴한다.
     * @return String
     */
    public String getSearchKeyword3() {
        return searchKeyword3;
    }

    /**
     * searchKeyword3 attribute 값을 설정한다.
     * @param searchKeyword3 String
     */
    public void setSearchKeyword3(String searchKeyword3) {
        this.searchKeyword3 = searchKeyword3;
    }

    /**
     * searchCondition4 attribute 를 리턴한다.
     * @return String
     */
    public String getSearchCondition4() {
        return searchCondition4;
    }

    /**
     * searchCondition4 attribute 값을 설정한다.
     * @param searchCondition4 String
     */
    public void setSearchCondition4(String searchCondition4) {
        this.searchCondition4 = searchCondition4;
    }

    /**
     * searchKeyword4 attribute 를 리턴한다.
     * @return String
     */
    public String getSearchKeyword4() {
        return searchKeyword4;
    }

    /**
     * searchKeyword4 attribute 값을 설정한다.
     * @param searchKeyword4 String
     */
    public void setSearchKeyword4(String searchKeyword4) {
        this.searchKeyword4 = searchKeyword4;
    }

    /**
     * searchCondition5 attribute 를 리턴한다.
     * @return String
     */
    public String getSearchCondition5() {
        return searchCondition5;
    }

    /**
     * searchCondition5 attribute 값을 설정한다.
     * @param searchCondition5 String
     */
    public void setSearchCondition5(String searchCondition5) {
        this.searchCondition5 = searchCondition5;
    }

    /**
     * searchKeyword5 attribute 를 리턴한다.
     * @return String
     */
    public String getSearchKeyword5() {
        return searchKeyword5;
    }

    /**
     * searchKeyword5 attribute 값을 설정한다.
     * @param searchKeyword5 String
     */
    public void setSearchKeyword5(String searchKeyword5) {
        this.searchKeyword5 = searchKeyword5;
    }

	/**
	 * searchDateCondition attribute 를 리턴한다.
	 * @return String
	 */
    public String getSearchDateCondition() {
		return searchDateCondition;
	}

	/**
	 * searchDateCondition attribute 값을 설정한다.
	 * @param searchKeyword String
	 */
	public void setSearchDateCondition(String searchDateCondition) {
		this.searchDateCondition = searchDateCondition;
	}

	/**
	 * searchStartDate attribute 를 리턴한다.
	 * @return String
	 */
	public Date getSearchStartDate() {
		return searchStartDate;
	}

	/**
	 * searchStartDate attribute 값을 설정한다.
	 * @param searchKeyword String
	 */
	public void setSearchStartDate(Date searchStartDate) {
		this.searchStartDate = searchStartDate;
	}

	/**
	 * searchEndDate attribute 를 리턴한다.
	 * @return String
	 */
	public Date getSearchEndDate() {
		return searchEndDate;
	}

	/**
	 * searchEndDate attribute 값을 설정한다.
	 * @param searchKeyword String
	 */
	public void setSearchEndDate(Date searchEndDate) {
		this.searchEndDate = searchEndDate;
	}

	/**
	 * searchUseYn attribute 를 리턴한다.
	 * @return String
	 */
	public String getSearchUseYn() {
		return searchUseYn;
	}

	/**
	 * searchUseYn attribute 값을 설정한다.
	 * @param searchUseYn String
	 */
	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	/**
	 * pageIndex attribute 를 리턴한다.
	 * @return int
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * pageIndex attribute 값을 설정한다.
	 * @param pageIndex int
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * pageUnit attribute 를 리턴한다.
	 * @return int
	 */
	public int getPageUnit() {
		return pageUnit;
	}

	/**
	 * pageUnit attribute 값을 설정한다.
	 * @param pageUnit int
	 */
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	/**
	 * pageSize attribute 를 리턴한다.
	 * @return int
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * pageSize attribute 값을 설정한다.
	 * @param pageSize int
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * firstIndex attribute 를 리턴한다.
	 * @return int
	 */
	public int getFirstIndex() {
		return firstIndex;
	}

	/**
	 * firstIndex attribute 값을 설정한다.
	 * @param firstIndex int
	 */
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	/**
	 * lastIndex attribute 를 리턴한다.
	 * @return int
	 */
	public int getLastIndex() {
		return lastIndex;
	}

	/**
	 * lastIndex attribute 값을 설정한다.
	 * @param lastIndex int
	 */
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	/**
	 * recordCountPerPage attribute 를 리턴한다.
	 * @return int
	 */
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	/**
	 * recordCountPerPage attribute 값을 설정한다.
	 * @param recordCountPerPage int
	 */
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	/**
	 * orderCondition attribute 를 리턴한다.
	 * @return String
	 */
	public String getOrderCondition() {
		return orderCondition;
	}

	/**
	 * orderCondition attribute 값을 설정한다.
	 * @param orderCondition String
	 */
	public void setOrderCondition(String orderCondition) {
		this.orderCondition = orderCondition;
	}

	/**
	 * orderType attribute 를 리턴한다.
	 * @return String
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * orderType attribute 값을 설정한다.
	 * @param orderType String
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
}
