package sample.bbs.web;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sample.bbs.service.SampleBbs;
import sample.bbs.service.SampleBbsService;
import sample.bbs.service.SampleBbsVO;
import sample.bbs.service.SampleBbsValidator;
import sample.cmm.service.SiteVO;
import sample.cmm.util.SampleStringUtil;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.annotation.IncludedInfo;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**  
 * @Class Name : SampleBbsController.java
 * @author jhong
 * @since 2016-08-09
 * @version 1.0
 */
@Controller
public class SampleBbsController {

	/** LOGGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleBbsController.class);

//    /** tiles designType */
//    private String DESIGN_TYPE = SampleConstant.;
	
	/** sampleBbsService */
	@Resource(name = "SampleBbsService")
    private SampleBbsService sampleBbsService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

	/** sampleBbsValidator */
	@Autowired
	private SampleBbsValidator sampleBbsValidator;
    
    @Resource(name = "EgovFileMngService")
    private EgovFileMngService fileMngService;

    @Resource(name = "EgovFileMngUtil")
    private EgovFileMngUtil fileUtil;

	/**
	 * 게시판  Master 목록 화면을 조회한다.
	 * @param sampleBbsVO
	 * @param bindingResult
	 * @param model
	 * @param commandMap
	 * @return "//bbs/SampleBbsMasterList"
	 * @throws Exception
	 */
    @IncludedInfo(name="게시판테스트",order = 179 ,gid = 40)
    @RequestMapping(value="/bbs/")
	public String selectSampleBbsMasterList (
			@ModelAttribute("searchVO") SampleBbsVO sampleBbsVO
			, BindingResult bindingResult
			, ModelMap model
			, @RequestParam Map<?, ?> commandMap
			) throws Exception {

    	// 사이트정보 유지
    	SiteVO siteVO = new SiteVO(commandMap);
    	model.put("siteVO", siteVO);
    	
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	
    	return "default_blank/sample/bbs/SampleBbsMasterList.tiles";
    }

    
	/**
	 * 게시판  등록화면을 조회한다. (egov 기본 파일 업로드 사용)
	 * @param sampleBbsVO
	 * @param bindingResult
	 * @param model
	 * @param commandMap
	 * @return "//bbs/SampleBbsRegist"
	 * @throws Exception
	 */
    @RequestMapping(value="/bbs/SampleBbsEntry.do")
	public String entrySampleBbs (
			@ModelAttribute("searchVO") SampleBbsVO sampleBbsVO
			, BindingResult bindingResult
			, ModelMap model
			, @RequestParam Map<?, ?> commandMap
			) throws Exception {

    	// 사이트정보 유지
    	SiteVO siteVO = new SiteVO(commandMap);
    	model.put("siteVO", siteVO);
    	
    	SampleBbs sampleBbs = new SampleBbs();
    	sampleBbs.setBbsId(sampleBbsVO.getBbsId()); // 화면에서 넘어오는 값 세팅
    	sampleBbs = sampleBbsService.initSampleBbs(sampleBbs); // 기본 데이터 세팅
    	
    	model.put("sampleBbs", sampleBbs);
    	
//		return SampleBizUtil.getTilesView("/bbs/SampleBbsRegist", "edit", this.DESIGN_TYPE, siteVO);
    	return "default_edit/sample/bbs/SampleBbsRegist.tiles";
    }

	/**
	 * 게시판  등록화면을 조회한다. (jfile 사용)
	 * @param sampleBbsVO
	 * @param bindingResult
	 * @param model
	 * @param commandMap
	 * @return "//bbs/SampleBbsRegist"
	 * @throws Exception
	 */
    @RequestMapping(value="/bbs/SampleBbsJfileEntry.do")
	public String entrySampleBbsJfile (
			@ModelAttribute("searchVO") SampleBbsVO sampleBbsVO
			, BindingResult bindingResult
			, ModelMap model
			, @RequestParam Map<?, ?> commandMap
			) throws Exception {

    	// 사이트정보 유지
    	SiteVO siteVO = new SiteVO(commandMap);
    	model.put("siteVO", siteVO);
    	
    	
    	SampleBbs sampleBbs = new SampleBbs();
    	sampleBbs.setBbsId(sampleBbsVO.getBbsId()); // 화면에서 넘어오는 값 세팅
    	sampleBbs = sampleBbsService.initSampleBbs(sampleBbs); // 기본 데이터 세팅
    	
    	model.put("sampleBbs", sampleBbs);
    	
    	return "default_edit/sample/bbs/SampleBbsJfileRegist.tiles";
    }

	/**
	 * 게시판 을(를) 등록한다.
	 * @param sampleBbs
	 * @param bindingResult
	 * @return "//bbs/SampleBbsRegist"
	 * @throws Exception
	 */
    @RequestMapping(value="/bbs/SampleBbsRegist.do")
	public String insertSampleBbs (
			final MultipartHttpServletRequest multiRequest
			, @ModelAttribute("sampleBbs") SampleBbs sampleBbs
			, BindingResult bindingResult
			, RedirectAttributes redirectAttributes
			, @RequestParam Map<?, ?> commandMap
			) throws Exception {

    	// 사이트정보 유지
    	SiteVO siteVO = new SiteVO(commandMap);
    	redirectAttributes.addFlashAttribute("siteVO", siteVO);

    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
    	LOGGER.debug("insertSampleBbs() isAuthenticated={}", isAuthenticated+", user="+user);

		// validation
        this.sampleBbsValidator.validate(sampleBbs, bindingResult);
//		SampleBizUtil.loggingValidationResult(bindingResult, LOGGER);
		redirectAttributes.addFlashAttribute("errors", bindingResult); // redirect 후 validation 결과 보여주기 위해 추가

		if (bindingResult.hasErrors()){
//    		return SampleBizUtil.getTilesView("/bbs/SampleBbsRegist", "edit", this.DESIGN_TYPE, siteVO);
			return "default_edit/sample/bbs/SampleBbsRegist.tiles";
		}

		// insert 전 권한 체크
		if (isAuthenticated) {
//			if (EgovDoubleSubmitHelper.checkAndSaveToken()) { // 이중등록(Double Submit) 방지
			
			final Map<String, MultipartFile> files = multiRequest.getFileMap();
			if (!files.isEmpty()) {
				String atchFileId = sampleBbs.getAtchFileId();
				if (SampleStringUtil.isEmpty(atchFileId)) {
					List<FileVO> result = fileUtil.parseFileInf(files, "BBS_", 0, atchFileId, "");
					atchFileId = fileMngService.insertFileInfs(result);
					sampleBbs.setAtchFileId(atchFileId);
					
				} else {
					FileVO fvo = new FileVO();
					fvo.setAtchFileId(atchFileId);
					int cnt = fileMngService.getMaxFileSN(fvo);
					List<FileVO> result = fileUtil.parseFileInf(files, "BBS_", cnt, atchFileId, "");
					fileMngService.updateFileInfs(result);
				}
			}
		
				sampleBbs.setNttCn(SampleStringUtil.unscript(sampleBbs.getNttCn())); // XSS 방지
			
				sampleBbs.setFrstRegisterId(user.getUniqId());
				sampleBbsService.insertSampleBbs(sampleBbs);
				LOGGER.debug("insertSampleBbs() end... sampleBbs={}", sampleBbs);
//			}
		}
		
		return "redirect:/bbs/SampleBbsDetail.do?nttId="+sampleBbs.getNttId()+"&bbsId="+sampleBbs.getBbsId(); // 중복 등록 방지 위해 redirect 수행
    }

	/**
	 * 게시판 을(를) 등록한다. (jfile 사용)
	 * @param sampleBbs
	 * @param bindingResult
	 * @return "//bbs/SampleBbsRegist"
	 * @throws Exception
	 */
    @RequestMapping(value="/bbs/SampleBbsJfileRegist.do")
	public String insertSampleBbsJfile (
			final MultipartHttpServletRequest multiRequest
			, @ModelAttribute("sampleBbs") SampleBbs sampleBbs
			, BindingResult bindingResult
			, RedirectAttributes redirectAttributes
			, @RequestParam Map<?, ?> commandMap
			) throws Exception {

    	// 사이트정보 유지
    	SiteVO siteVO = new SiteVO(commandMap);
    	redirectAttributes.addFlashAttribute("siteVO", siteVO);

    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
    	LOGGER.debug("insertSampleBbsJfile() isAuthenticated={}", isAuthenticated+", user="+user);

		// validation
        this.sampleBbsValidator.validate(sampleBbs, bindingResult);
//		SampleBizUtil.loggingValidationResult(bindingResult, LOGGER);
		redirectAttributes.addFlashAttribute("errors", bindingResult); // redirect 후 validation 결과 보여주기 위해 추가

		if (bindingResult.hasErrors()){
//    		return SampleBizUtil.getTilesView("/bbs/SampleBbsRegist", "edit", this.DESIGN_TYPE, siteVO);
			return "default_edit/sample/bbs/SampleBbsJfileRegist.tiles";
		}

		// insert 전 권한 체크
		if (isAuthenticated) {
			
			// jfile 업로드로 화면에서 ajax 통해 진행된 후 atchFileId 세팅함
			LOGGER.debug("insertSampleBbsJfile() atchFileId={}", sampleBbs.getAtchFileId());
			
			sampleBbs.setNttCn(SampleStringUtil.unscript(sampleBbs.getNttCn())); // XSS 방지
		
			sampleBbs.setFrstRegisterId(user.getUniqId());
			sampleBbsService.insertSampleBbs(sampleBbs);
			LOGGER.debug("insertSampleBbsJfile() end... sampleBbs={}", sampleBbs);
		}
		
		return "redirect:/bbs/SampleBbsDetail.do?nttId="+sampleBbs.getNttId()+"&bbsId="+sampleBbs.getBbsId(); // 중복 등록 방지 위해 redirect 수행
    }

	/**
	 * 게시판 수정화면을 호출한다.
	 * @param sampleBbs
	 * @param bindingResult
	 * @param commandMap
	 * @param model
	 * @return "//bbs/SampleBbsModify"
	 * @throws Exception
	 */
    @RequestMapping(value="/bbs/SampleBbsEdit.do")
	public String editSampleBbs (
			@ModelAttribute("sampleBbs") SampleBbs sampleBbs
			, @ModelAttribute("searchVO") SampleBbsVO searchVO // 검색조건
			, BindingResult bindingResult
			, @RequestParam Map<String, Object> commandMap
			, ModelMap model
			) throws Exception {
			
    	// 사이트정보 유지
    	SiteVO siteVO = new SiteVO(commandMap);
    	model.put("siteVO", siteVO);
    	
		SampleBbs vo = sampleBbsService.selectSampleBbsDetail(sampleBbs);
		model.addAttribute("sampleBbs", vo);
		
//		return SampleBizUtil.getTilesView("/bbs/SampleBbsModify", "edit", this.DESIGN_TYPE, siteVO);
		return "default_edit/sample/bbs/SampleBbsModify.tiles";
    }

	/**
	 * 게시판 수정화면을 호출한다. (jfile 사용)
	 * @param sampleBbs
	 * @param bindingResult
	 * @param commandMap
	 * @param model
	 * @return "//bbs/SampleBbsJfileModify"
	 * @throws Exception
	 */
    @RequestMapping(value="/bbs/SampleBbsJfileEdit.do")
	public String editSampleBbsJfile (
			@ModelAttribute("sampleBbs") SampleBbs sampleBbs
			, @ModelAttribute("searchVO") SampleBbsVO searchVO // 검색조건
			, BindingResult bindingResult
			, @RequestParam Map<String, Object> commandMap
			, ModelMap model
			) throws Exception {
			
    	// 사이트정보 유지
    	SiteVO siteVO = new SiteVO(commandMap);
    	model.put("siteVO", siteVO);
    	
		SampleBbs vo = sampleBbsService.selectSampleBbsDetail(sampleBbs);
		model.addAttribute("sampleBbs", vo);
		
		return "default_edit/sample/bbs/SampleBbsJfileModify.tiles";
    }

	/**
	 * 게시판 을(를) 수정한다.
	 * @param sampleBbs
	 * @param bindingResult
	 * @param commandMap
	 * @param model
	 * @return "//bbs/SampleBbsModify"
	 * @throws Exception
	 */
    @RequestMapping(value="/bbs/SampleBbsModify.do")
	public String updateSampleBbs (
			final MultipartHttpServletRequest multiRequest
			, @ModelAttribute("sampleBbs") SampleBbs sampleBbs
			, @ModelAttribute("searchVO") SampleBbsVO searchVO // 검색조건
			, BindingResult bindingResult
			, @RequestParam Map<String, Object> commandMap
			, ModelMap model
			) throws Exception {
			
    	// 사이트정보 유지
    	SiteVO siteVO = new SiteVO(commandMap);
    	model.put("siteVO", siteVO);
			
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
    	LOGGER.debug("updateSampleBbs isAuthenticated={}", isAuthenticated+", user="+user);
			
		String sCmd = commandMap.get("cmd") == null ? "" : (String)commandMap.get("cmd");
		LOGGER.debug("updateSampleBbs() sCmd={}", sCmd);
		
    	if (sCmd.equals("")) {
    		SampleBbs vo = sampleBbsService.selectSampleBbsDetail(sampleBbs);
    		model.addAttribute("sampleBbs", vo);

//    		return SampleBizUtil.getTilesView("/bbs/SampleBbsModify", "edit", this.DESIGN_TYPE, siteVO);
    		return "default_edit/sample/bbs/SampleBbsModify.tiles";
    		
    	} else if (sCmd.equals("Modify")) {
    	
			// validation
     		this.sampleBbsValidator.validate(sampleBbs, bindingResult);
//    		SampleBizUtil.loggingValidationResult(bindingResult, LOGGER);
    		model.addAttribute("errors", bindingResult);
 
    		if (bindingResult.hasErrors()){

//        		return SampleBizUtil.getTilesView("/bbs/SampleBbsModify", "edit", this.DESIGN_TYPE, siteVO); // 수정화면으로 돌아감
    			return "default_edit/sample/bbs/SampleBbsModify.tiles";
    		}

			// update 전 권한 체크
			if (isAuthenticated) {
				
				final Map<String, MultipartFile> files = multiRequest.getFileMap();
				if (!files.isEmpty()) {
					String atchFileId = sampleBbs.getAtchFileId();
					if (SampleStringUtil.isEmpty(atchFileId)) {
						List<FileVO> result = fileUtil.parseFileInf(files, "BBS_", 0, atchFileId, "");
						atchFileId = fileMngService.insertFileInfs(result);
						sampleBbs.setAtchFileId(atchFileId);
						
					} else {
						FileVO fvo = new FileVO();
						fvo.setAtchFileId(atchFileId);
						int cnt = fileMngService.getMaxFileSN(fvo);
						List<FileVO> result = fileUtil.parseFileInf(files, "BBS_", cnt, atchFileId, "");
						fileMngService.updateFileInfs(result);
					}
				}
    		
				sampleBbs.setNttCn(SampleStringUtil.unscript(sampleBbs.getNttCn())); // XSS 방지
	    		sampleBbs.setLastUpdusrId(user.getUniqId());
	    		
		    	sampleBbsService.updateSampleBbs(sampleBbs);
		    }
	    	
			model.addAttribute("result", sampleBbs);
//			return SampleBizUtil.getTilesView("/bbs/SampleBbsDetail", "view", this.DESIGN_TYPE, siteVO); // 상세 화면으로 이동
			return "default_view/sample/bbs/SampleBbsDetail.tiles";
	        
    	} else {
    		return "forward:/bbs/SampleBbsList.do"; // 목록으로 이동
    	}
    }

	/**
	 * 게시판 을(를) 수정한다. (jfile 사용)
	 * @param sampleBbs
	 * @param bindingResult
	 * @param commandMap
	 * @param model
	 * @return "//bbs/SampleBbsJfileModify"
	 * @throws Exception
	 */
    @RequestMapping(value="/bbs/SampleBbsJfileModify.do")
	public String updateSampleBbsJfile (
			final MultipartHttpServletRequest multiRequest
			, @ModelAttribute("sampleBbs") SampleBbs sampleBbs
			, @ModelAttribute("searchVO") SampleBbsVO searchVO // 검색조건
			, BindingResult bindingResult
			, @RequestParam Map<String, Object> commandMap
			, ModelMap model
			) throws Exception {
			
    	// 사이트정보 유지
    	SiteVO siteVO = new SiteVO(commandMap);
    	model.put("siteVO", siteVO);
			
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
			
		String sCmd = commandMap.get("cmd") == null ? "" : (String)commandMap.get("cmd");
		
    	if (sCmd.equals("")) {
    		SampleBbs vo = sampleBbsService.selectSampleBbsDetail(sampleBbs);
    		model.addAttribute("sampleBbs", vo);

    		return "default_edit/sample/bbs/SampleBbsJfileModify.tiles";
    		
    	} else if (sCmd.equals("Modify")) {
    	
			// validation
     		this.sampleBbsValidator.validate(sampleBbs, bindingResult);
//    		SampleBizUtil.loggingValidationResult(bindingResult, LOGGER);
    		model.addAttribute("errors", bindingResult);
 
    		if (bindingResult.hasErrors()){

    			return "default_edit/sample/bbs/SampleBbsJfileModify.tiles";
    		}

			// update 전 권한 체크
			if (isAuthenticated) {
				
				// jfile 업로드로 화면에서 ajax 통해 진행된 후 atchFileId 세팅함
				LOGGER.debug("updateSampleBbsJfile() atchFileId={}", sampleBbs.getAtchFileId());
    		
				sampleBbs.setNttCn(SampleStringUtil.unscript(sampleBbs.getNttCn())); // XSS 방지
	    		sampleBbs.setLastUpdusrId(user.getUniqId());
	    		
		    	sampleBbsService.updateSampleBbs(sampleBbs);
		    }
	    	
			model.addAttribute("result", sampleBbs);
			return "default_view/sample/bbs/SampleBbsDetail.tiles";
	        
    	} else {
    		return "forward:/bbs/SampleBbsList.do"; // 목록으로 이동
    	}
    }

	/**
	 * 게시판 을(를) 삭제한다.
	 * @param sampleBbs
	 * @param model
     * @param commandMap
	 * @return "forward:/bbs/SampleBbsList.do"
	 * @throws Exception
	 */
    @RequestMapping(value="/bbs/SampleBbsRemove.do")
	public String deleteSampleBbs (
			SampleBbs sampleBbs
			, ModelMap model
			, @RequestParam Map<String, Object> commandMap
			) throws Exception {

    	// 사이트정보 유지
    	SiteVO siteVO = new SiteVO(commandMap);
    	model.put("siteVO", siteVO);

		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
		LOGGER.debug("deleteSampleBbs() isAuthenticated={}", isAuthenticated+", user="+user);
			
		// delete 전 권한 체크
		if (isAuthenticated) {
			sampleBbsService.deleteSampleBbs(sampleBbs);
		}
		
        return "forward:/bbs/SampleBbsList.do";
	}
  
	/**
	 * 게시판 상세항목을 조회한다.
	 * @param sampleBbs
	 * @param searchVO
	 * @param model
     * @param commandMap
	 * @return "//bbs/SampleBbsDetail"
	 * @throws Exception
	 */
	@RequestMapping(value="/bbs/SampleBbsDetail.do")
 	public String selectSampleBbsDetail (
 			SampleBbs sampleBbs
 			, @ModelAttribute("searchVO") SampleBbsVO searchVO
 			, ModelMap model
 			, @RequestParam Map<String, Object> commandMap
 			) throws Exception {
 			
    	// 사이트정보 유지
    	SiteVO siteVO = new SiteVO(commandMap);
    	model.put("siteVO", siteVO);
    	
    	// TODO: 조회수 증가
    	
 			
		SampleBbs vo = sampleBbsService.selectSampleBbsDetail(sampleBbs);
		model.addAttribute("result", vo);
		
//		return SampleBizUtil.getTilesView("/bbs/SampleBbsDetail", "view", this.DESIGN_TYPE, siteVO);
		return "default_view/sample/bbs/SampleBbsDetail.tiles";
	}

    /**
	 * 게시판 목록을 조회한다.
     * @param searchVO
     * @param model
     * @param commandMap
     * @return "//bbs/SampleBbsList"
     * @throws Exception
     */
    @RequestMapping(value="/bbs/SampleBbsList.do")
	public String selectSampleBbsList (
			@ModelAttribute("searchVO") SampleBbsVO searchVO
			, ModelMap model
			, @RequestParam Map<?, ?> commandMap
			) throws Exception {
			
        // 사이트정보 유지
        SiteVO siteVO = new SiteVO(commandMap);
        model.put("siteVO", siteVO);
			
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));

    	/** paging */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List resultList = sampleBbsService.selectSampleBbsList(searchVO);
        model.addAttribute("resultList", resultList);
        
        int totCnt = sampleBbsService.selectSampleBbsListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
//		return SampleBizUtil.getTilesView("/bbs/SampleBbsList", "list", this.DESIGN_TYPE, siteVO);
        return "default_list/sample/bbs/SampleBbsList.tiles";
	}
   
}
