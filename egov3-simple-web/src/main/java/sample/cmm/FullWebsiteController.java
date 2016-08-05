package sample.cmm;

import java.security.Principal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.uat.uia.service.EgovLoginService;

/**
 * https://github.com/eric-mckinley/springmultihttploginforms
 *
 */
@Controller
@RequestMapping("/")
public class FullWebsiteController {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(FullWebsiteController.class);

	/** EgovLoginService */
	@Resource(name = "loginService")
	private EgovLoginService loginService;


    @RequestMapping(method = RequestMethod.GET)
    public String noRestrictionsPageDefault(HttpServletRequest request, ModelMap modelMap) {
        addUsername(request);
        return "sample/home-page";
    }

    @IncludedInfo(name = "로그인 샘플", listUrl = "/home", order = 12, gid = 12)
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String noRestrictionsPage(HttpServletRequest request, ModelMap modelMap) {
        addUsername(request);
        return "sample/home-page";
    }

    /* Member start*/
    @RequestMapping(value = "/member/home", method = RequestMethod.GET)
    public String memberPage(HttpServletRequest request, ModelMap modelMap) {
        addUsername(request);
        return "sample/member/member-page";
    }

    @RequestMapping(value = "/member/account", method = RequestMethod.GET)
    public String memberAccountPage(HttpServletRequest request, ModelMap modelMap) {
        addUsername(request);
        return "sample/member/member-account-page";
    }

    @RequestMapping(value = "/member/orders", method = RequestMethod.GET)
    public String memberOrderstPage(HttpServletRequest request, ModelMap modelMap) {
        addUsername(request);
        return "sample/member/member-order-page";
    }

    @RequestMapping(value = "/member/login", method = RequestMethod.GET)
    public String memberLoginPage(HttpServletRequest request,
    		@RequestParam(value="loginStatus", required=false) String loginStatus,
    		ModelMap modelMap) {
        addUsername(request);
        LOGGER.debug("memberLoginPage() loginStatus={}", loginStatus);
        LOGGER.debug("memberLoginPage() loginMessage={}", modelMap.get("loginMessage"));
        
        return "sample/login-forms/member-login-page";
    }

    @RequestMapping(value = "/member/login-process", method = RequestMethod.POST)
    public String memberLoginProcess(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("loginVO") LoginVO loginVO,
    		ModelMap modelMap,
    		RedirectAttributes redirectAttributes) throws Exception {
    	
    	LOGGER.debug("memberLoginProcess() start... loginVO={}", loginVO);
    	
		// 1. 일반 로그인 처리
		LoginVO resultVO = loginService.actionLogin(loginVO);
		modelMap.addAttribute("resultVO", resultVO);
		LOGGER.debug("memberLoginProcess() resultVO={}", resultVO);
		
		if (resultVO == null || StringUtils.isEmpty(resultVO.getId())) {
//			redirectAttributes.addFlashAttribute("loginMessage", "로그인 정보가 올바르지 않습니다.");
//			return "redirect:/member/login?loginStatus=login_error";
		}
    	
		
		//스프링 시큐리티 로그인
		/*
		 * 직접 redirect 수행할 경우 다음 에러 발생함
		 * Authentication request failed: org.springframework.security.authentication.AuthenticationServiceException: Authentication method not supported: GET
		 * 
//    	request.sendRedirect(request.getContextPath() + "/j_spring_security_check?j_username=" + loginVO.getUserSe() + loginVO.getId() + "&j_password=" + loginVO.getUniqId());
    	return "redirect:/j_spring_security_check?j_username=" + resultVO.getUserSe() + resultVO.getId() + "&j_password=" + resultVO.getUniqId();
    	*/
		
		// jsp 페이지에서 post 방식으로 /j_spring_security_check 호출
		modelMap.put("loginProcessingUrl", "/member/j_spring_security_check");
		return "sample/login-forms/security-login-page";
    }

	@RequestMapping(value = "/member/logout")
	public String memberLogout(HttpServletRequest request, ModelMap model) throws Exception {

		return "redirect:/j_spring_security_logout";
	}
   /* Member end*/


    /* Admin start */
    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String adminPage(HttpServletRequest request, ModelMap modelMap) {
        addUsername(request);
        return "sample/admin/admin-page";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String adminUsersPage(HttpServletRequest request, ModelMap modelMap) {
        addUsername(request);
        return "sample/admin/admin-users-page";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String adminLoginPage(HttpServletRequest request, 
    		@RequestParam(value="loginStatus", required=false) String loginStatus,
    		ModelMap modelMap) {
        addUsername(request);
        LOGGER.debug("adminLoginPage() loginStatus={}", loginStatus);
        LOGGER.debug("adminLoginPage() loginMessage={}", modelMap.get("loginMessage"));
        
        return "sample/login-forms/admin-login-page";
    }
    
    @RequestMapping(value = "/admin/login-process", method = RequestMethod.POST)
    public String adminLoginProcess(HttpServletRequest request, 
    		HttpServletResponse response,
    		@ModelAttribute("loginVO") LoginVO loginVO,
    		ModelMap modelMap,
    		RedirectAttributes redirectAttributes) throws Exception {
    	
    	LOGGER.debug("adminLoginProcess() start... loginVO={}", loginVO);
    	
		// 1. 일반 로그인 처리
		LoginVO resultVO = loginService.actionLogin(loginVO);
		modelMap.addAttribute("resultVO", resultVO);
		LOGGER.debug("adminLoginProcess() resultVO={}", resultVO);
		
		if (resultVO == null || StringUtils.isEmpty(resultVO.getId())) {
//			redirectAttributes.addFlashAttribute("loginMessage", "로그인 정보가 올바르지 않습니다.");
//			return "redirect:/admin/login?loginStatus=login_error";
		}
    	
		
		//스프링 시큐리티 로그인
		/*
		 * 직접 redirect 수행할 경우 다음 에러 발생함
		 * Authentication request failed: org.springframework.security.authentication.AuthenticationServiceException: Authentication method not supported: GET
		 * 
//    	request.sendRedirect(request.getContextPath() + "/j_spring_security_check?j_username=" + loginVO.getUserSe() + loginVO.getId() + "&j_password=" + loginVO.getUniqId());
    	return "redirect:/j_spring_security_check?j_username=" + resultVO.getUserSe() + resultVO.getId() + "&j_password=" + resultVO.getUniqId();
    	*/
		
		// jsp 페이지에서 post 방식으로 /j_spring_security_check 호출
		modelMap.put("loginProcessingUrl", "/admin/j_spring_security_check");
		return "sample/login-forms/security-login-page";
    }
    
	@RequestMapping(value = "/admin/logout")
	public String adminLogout(HttpServletRequest request, ModelMap model) throws Exception {

		return "redirect:/j_spring_security_logout";
	}

    /* Admin end */

    private void addUsername(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        if(principal != null){
            request.setAttribute("username", principal.getName());
        }
    }
}
