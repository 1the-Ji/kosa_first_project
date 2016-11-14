<<<<<<< HEAD
/*package com.mycompany.myweb.controller;



=======
package com.mycompany.myweb.controller;
>>>>>>> branch 'master' of https://github.com/JiSeungHoon/TeamRepository
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String index(){
		logger.info("index실행");
		return "/index";
	}
}
*/