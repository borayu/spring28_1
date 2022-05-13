package com.javabora.spring_28_1.dao;

import java.util.ArrayList;

import com.javabora.spring_28_1.dto.ContentDto;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();
	public void writeDao(String mname, String mphone, String maddress, String mdate);
	public ContentDto viewDao(String mid);
	public void deleteDao(String mid);
	public void modifyDao(String mname, String mphone, String maddress, String mdate);
}