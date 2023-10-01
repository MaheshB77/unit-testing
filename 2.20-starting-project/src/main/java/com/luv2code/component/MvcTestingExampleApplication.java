package com.luv2code.component;

import com.luv2code.component.service.ApplicationService;
import com.luv2code.component.utils.ApplicationUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class MvcTestingExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcTestingExampleApplication.class, args);
	}

	/* New for Section 2.2 */
	@Bean(name = "applicationExample")
	ApplicationService getApplicationService() {
		return new ApplicationService();
	}

	/* New for Section 2.2 */
	@Bean(name = "applicationUtil")
	ApplicationUtil getApplicationUtil() {
		return new ApplicationUtil();
	}

}
