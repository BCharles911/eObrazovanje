package com.eobrazovanje.ssluzba.utility;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;
	
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
	
		
	}

	
}
