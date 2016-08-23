package sample.bbs.service;

import java.util.List;

/**
 * 게시판에 대한 서비스 인터페이스 클래스를 정의한다
 * @Class Name : SampleBbsService.java
 * @author jhong 
 * @since 2016-08-09
 * @version 1.0
 */
public interface SampleBbsService {

	/**
	 * 게시판 등록 화면 호출시 기본 데이터 세팅
	 * @param sampleBbs
	 * @throws Exception
	 */
	SampleBbs initSampleBbs(SampleBbs sampleBbs) throws Exception;

	/**
	 * 게시판 을(를) 등록한다.
	 * @param sampleBbs
	 * @throws Exception
	 */
	void insertSampleBbs(SampleBbs sampleBbs) throws Exception;

	/**
	 * 게시판 을(를) 수정한다.
	 * @param sampleBbs
	 * @throws Exception
	 */
	void updateSampleBbs(SampleBbs sampleBbs) throws Exception;

	/**
	 * 게시판 을(를) 삭제한다.
	 * @param sampleBbs
	 * @throws Exception
	 */
	void deleteSampleBbs(SampleBbs sampleBbs) throws Exception;
	
	/**
	 * 게시판 상세항목을 조회한다.
	 * @param sampleBbs
	 * @return SampleBbs
	 * @throws Exception
	 */
	 SampleBbs selectSampleBbsDetail(SampleBbs sampleBbs) throws Exception;
	
	/**
	 * 게시판 목록을 조회한다.
	 * @param searchVO
	 * @return List
	 * @throws Exception
	 */
	List selectSampleBbsList(SampleBbsVO searchVO) throws Exception;

    /**
	 * 게시판 총 갯수를 조회한다.
     * @param searchVO
     * @return int
     */
    int selectSampleBbsListTotCnt(SampleBbsVO searchVO) throws Exception;
    
}
