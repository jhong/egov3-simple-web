package sample.bbs.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import sample.bbs.service.SampleBbs;
import sample.bbs.service.SampleBbsVO;
import sample.cmm.service.impl.SampleAbstractMapper;

/**
 * 게시판에 대한 데이터 접근 클래스를 정의한다
 * @Class Name : SampleBbsMapper.java
 * @author jhong 
 * @since 2016-08-09
 * @version 1.0
 */
@Repository("SampleBbsMapper")
public class SampleBbsMapper extends SampleAbstractMapper {

	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleBbsMapper.class);

	/**
	 * 게시판 을(를) 등록한다.
	 * @param sampleBbs
	 * @throws Exception
	 */
	public void insertSampleBbs(SampleBbs sampleBbs) throws Exception {
        insert("insertSampleBbs", sampleBbs);
	}

	/**
	 * 게시판 을(를) 수정한다.
	 * @param sampleBbs
	 * @throws Exception
	 */
	public void updateSampleBbs(SampleBbs sampleBbs) throws Exception {
		update("updateSampleBbs", sampleBbs);
	}

	/**
	 * 게시판 을(를) 삭제한다.
	 * @param sampleBbs
	 * @throws Exception
	 */
	public void deleteSampleBbs(SampleBbs sampleBbs) throws Exception {
		delete("deleteSampleBbs", sampleBbs);
	}

	/**
	 * 게시판 상세항목을 조회한다.
	 * @param sampleBbs
	 * @return SampleBbs(게시판)
	 */
	public SampleBbs selectSampleBbsDetail(SampleBbs sampleBbs) throws Exception {
		return (SampleBbs)selectOne("selectSampleBbsDetail", sampleBbs);
	}


    /**
	 * 게시판 목록을 조회한다.
     * @param searchVO
     * @return List(게시판 목록)
     * @throws Exception
     */
    public List selectSampleBbsList(SampleBbsVO searchVO) throws Exception {
        return selectList("selectSampleBbsList", searchVO);
    }

    /**
	 * 게시판 총 갯수를 조회한다.
     * @param searchVO
     * @return int(게시판 총 갯수)
     */
    public int selectSampleBbsListTotCnt(SampleBbsVO searchVO) throws Exception {
        return (Integer)getSqlSession().selectOne("selectSampleBbsListTotCnt", searchVO);
    }
}
