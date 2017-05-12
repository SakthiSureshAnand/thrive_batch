package com.npb.rea.service;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npb.rea.dao.rets.RoomDetails_Default_ActivityDao;
import com.npb.rea.domain.core.RoomDetails;
import com.npb.rea.utils.CSVtoArrayList;

@Service("RoomDetails_Default_ActivityService")
public class RoomDetails_Default_ActivityService {

	@Autowired
	private RoomDetails_Default_ActivityDao roomDetails_Default_ActivityDao;

	public RoomDetails_Default_ActivityDao getRoomDetails_Default_ActivityDao() {
		return roomDetails_Default_ActivityDao;
	}

	@Resource(name = "RoomDetails_Default_ActivityDao")
	public void setRoomDetails_Default_ActivityDao(
			RoomDetails_Default_ActivityDao surveyBuilderNoun_Default_ActivityDao) {
		this.roomDetails_Default_ActivityDao = surveyBuilderNoun_Default_ActivityDao;
	}

	@SuppressWarnings("resource")
	public RoomDetails create_surveybuildernoun(String fileName) throws Exception {
		RoomDetails the_SurveyBuilderNoun = new RoomDetails();
		BufferedReader convertcsvBuffer = null;
		ArrayList<String> convertedList = new ArrayList<>();
		String data;
		convertcsvBuffer = new BufferedReader(new FileReader(fileName));
		while ((data = convertcsvBuffer.readLine()) != null) {
			convertedList = CSVtoArrayList.convertCSVtoArrayList(data);
			UUID idOne = UUID.randomUUID();
			the_SurveyBuilderNoun.setId(idOne);
			the_SurveyBuilderNoun.setBuild_name(convertedList.get(0));
			the_SurveyBuilderNoun.setDepartment(convertedList.get(1));
			the_SurveyBuilderNoun.setFloor(convertedList.get(2));
			the_SurveyBuilderNoun.setRoomno(convertedList.get(3));
			the_SurveyBuilderNoun.setWing(convertedList.get(4));
			the_SurveyBuilderNoun = roomDetails_Default_ActivityDao
					.create_roomDetail(the_SurveyBuilderNoun);
		}
		return the_SurveyBuilderNoun;
	}
}