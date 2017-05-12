package com.npb.rea;

import java.util.ArrayList;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.bigllc.retsiq.simpleclient.RETSClientException;
import com.bigllc.retsiq.simpleclient.RETSUserSession;
import com.npb.rea.service.RoomDetails_Default_ActivityService;

public class ReBatch {
	private Log log = LogFactory.getLog(getClass());
	public static void main(String[] args) {
		ReBatch rebatch = new ReBatch();
		RETSUserSession session = null;
		try {
			ApplicationContext context = new FileSystemXmlApplicationContext("spring_config.xml");
			RoomDetails_Default_ActivityService surveyBuilderNoun_Default_ActivityService = (RoomDetails_Default_ActivityService)
			context.getBean("RoomDetails_Default_ActivityService");
			System.out.println("surveyBuilderNoun_Default_ActivityService.create_surveybuildernoun(); called");
			surveyBuilderNoun_Default_ActivityService.create_surveybuildernoun(args[0]);
			System.out.println("surveyBuilderNoun_Default_ActivityService.create_surveybuildernoun(); ended");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			System.out.println("e Print trace data=>"+e.getStackTrace().toString());
		} finally {
			if (session != null) {
				try {
					session.logout();
					rebatch.log.info("###########  LOGGED OUT ############");
				} catch (RETSClientException e) {
					rebatch.log.info(e.getMessage());
				}
			}
		}

	}

}
