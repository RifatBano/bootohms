package com.cg.service;

import com.cg.Exception.RoomDetailException;
import com.cg.bean.HotelDetailsDto;
import com.cg.bean.RoomDetailsDto;

public interface IService {

	  
  
   // public List<RoomDetailsDto> getAllDetails();
 
    public String deleteDetail(int roomid) throws RoomDetailException;
 
  //  public RoomDetailsDto getDetail(int room_id);
 
    public String updatePrice(int roomid,double price) throws RoomDetailException;

	public String addDetail(RoomDetailsDto roomDetailsDto,HotelDetailsDto hotelDetailsDto) throws RoomDetailException;
}
