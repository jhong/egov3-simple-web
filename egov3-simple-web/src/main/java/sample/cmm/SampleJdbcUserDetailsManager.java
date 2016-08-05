package sample.cmm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.security.userdetails.jdbc.EgovJdbcUserDetailsManager;

public class SampleJdbcUserDetailsManager extends EgovJdbcUserDetailsManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleJdbcUserDetailsManager.class);
	
//	/** EgovLoginService */
//	@Resource(name = "loginService")
//	private EgovLoginService loginService;
//
//    /**
//     * EgovJdbcUserDetailsManager 클래스의 loadUsersByUsername 메소드 재정의.
//     * 사용자명(또는 ID)로 UserDetails 정보를 조회하여 리스트 형식으로 저장한다.
//     */
//    @Override
//    protected List<UserDetails> loadUsersByUsername(String username) {
//
//        ArrayList<UserDetails> newList = new ArrayList<UserDetails>();
//
//        /*
//        List<EgovUserDetails> list = usersByUsernameMapping.execute(username);
//        for (EgovUserDetails user : list) {
//        	newList.add(user);
//        }
//        */
//
////        LoginVO paramVO = new LoginVO();
////        LoginVO resultVO = loginService.actionLogin(paramVO);
//        
//        return newList;
//    }

}
