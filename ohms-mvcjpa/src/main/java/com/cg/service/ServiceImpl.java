package com.cg.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Exception.RoomDetailException;
import com.cg.bean.HotelDetailsDto;
import com.cg.bean.RoomDetailsDto;
import com.cg.dao.IDetailDao;

//this is the service class 
@Service
public class ServiceImpl implements IService{

	@Autowired
	private IDetailDao detail;
	

	public void setDetail(IDetailDao detail) {
		this.detail = detail;
	}


	//RoomDetailsDto roomdata=new RoomDetailsDto();	
	
	//add operation
	public String addDetail(RoomDetailsDto roomDetailsDto,HotelDetailsDto hotelDetailsDto) throws RoomDetailException {
		// TODO Auto-generated method stub
		String message;
		message=detail.addDetail(roomDetailsDto,hotelDetailsDto);
		return message;
	}

//delete operation
	@Override
	public String deleteDetail(int roomid) throws RoomDetailException {
		// TODO Auto-generated method stub
		String message1;
		 message1=detail.deleteDetail(roomid);
		return message1;
	}

//update price operation
	@Override
	public String updatePrice(int roomid, double price) throws RoomDetailException {
		
		String message2;
		 message2=detail.updatePrice(roomid, price);
		 return message2;
	}

	
}
