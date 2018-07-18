package com.briup.app02.dao.extend;

import java.util.List;
import com.briup.app02.vm.surveyVM;

public interface surveyVMMapper {
	List<surveyVM> findAllsurveyVM();
	
	List<surveyVM> findAllnextVM();
	
	List<surveyVM> findAllsurvey_answerVM();
}
