package com.deepface.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.deepface.api.domain.DeepfaceSearchInformation;
import com.deepface.api.domain.DeepfaceSearchResponse;

@Repository
public class DeepfaceApiDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	protected List<String> searchInformation(DeepfaceSearchResponse data) {
		DeepfaceSearchInformation response = null;
		List<String> listDetail = new ArrayList<>();
		String searchInformation = "SELECT * FROM STUDENT_INFORMATION WHERE studentId = ?";
		String searchDetail = "SELECT * FROM DETAIL WHERE studentId = ? ORDER BY id ASC";
		
		response = jdbcTemplate.query(
				searchInformation,
		        new Object[]{data.getDeepface().getId()},
				rs-> {
					DeepfaceSearchInformation temp = null;
					if(rs.next()) {
						temp = new DeepfaceSearchInformation();
						temp.setStudentId(rs.getString("studentId"));
						temp.setFirstName(rs.getString("firstName"));
						temp.setLastName(rs.getString("lastName"));
						temp.setFaculty(rs.getString("faculty"));
						temp.setBirthDate(rs.getString("birthDate"));
						temp.setGpaX(rs.getString("gpaX"));
						return temp;
					}
					return temp;
				}
			);
		
		jdbcTemplate.query(
		        searchDetail,
		        new Object[]{data.getDeepface().getId()},
		        rs -> {
		            while (rs.next()) {
		                listDetail.add(rs.getString("detail"));
		            }
		            return null;
		        }
		   );
		
		if(response != null) {
			data.setHaveInformation(true);
		}
		if(!listDetail.isEmpty()) {
			data.setHaveDetail(true);
		}
		
		data.setInformation(response);
		
		return listDetail;
	}
	
	
}
