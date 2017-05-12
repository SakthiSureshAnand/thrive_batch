package com.npb.rea.dao.rets;

import java.util.ArrayList;

import java.util.Date;
import java.math.BigInteger;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
//import javax.persistence.Column;
//import javax.persistence.Query;
//import javax.persistence.Transient;
import javax.sound.midi.SysexMessage;
import javax.sql.DataSource;
/*import javax.transaction.Transactional;*/

/*
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnitUtil;
import javax.transaction.Transactional;
import javax.persistence.Query;
*/

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.npb.rea.domain.core.RoomDetails;

@Repository("RoomDetails_Default_ActivityDao")
public class RoomDetails_Default_ActivityDao {
	private Log log = LogFactory.getLog(getClass());
	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public RoomDetails create_roomDetail(RoomDetails SurveyBuilderNoun) throws Exception {
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("id", SurveyBuilderNoun.getId());
			paramMap.put("build_name", SurveyBuilderNoun.getBuild_name());
			paramMap.put("department", SurveyBuilderNoun.getDepartment());
			paramMap.put("floor", SurveyBuilderNoun.getFloor());
			paramMap.put("roomno", SurveyBuilderNoun.getRoomno());
			paramMap.put("wing", SurveyBuilderNoun.getWing());
			String SQL_INSERT_PROPERTY = "INSERT INTO  view_ppp.room_detail(id,build_name,department,floor,roomno,wing) values (:id,:build_name,:department,:floor,:roomno,:wing)";
			namedParameterJdbcTemplate.update(SQL_INSERT_PROPERTY, paramMap);
			return SurveyBuilderNoun;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}