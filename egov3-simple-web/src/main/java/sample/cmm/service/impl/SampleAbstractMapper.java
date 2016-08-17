package sample.cmm.service.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

/**
 * SampleAbstractMapper.java 클래스
 *
 * @author jhong
 * @since 2016.08.09
 * @version 1.0
 */
public class SampleAbstractMapper extends EgovAbstractMapper {

	@Resource(name="sqlSessionEgov")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
        super.setSqlSessionFactory(sqlSession);
    }

}
