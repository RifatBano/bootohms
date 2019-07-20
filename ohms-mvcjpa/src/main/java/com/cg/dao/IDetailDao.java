package com.cg.dao;
import com.cg.Exception.RoomDetailException;
import com.cg.bean.HotelDetailsDto;
import com.cg.bean.RoomDetailsDto;

public interface IDetailDao {
	  

    public String deleteDetail(int room_id) throws RoomDetailException;
 
    public String updatePrice(int roomid, double price) throws RoomDetailException;

	public String addDetail(RoomDetailsDto rooDetailsDto,HotelDetailsDto hotelDetailsDto) throws RoomDetailException;
}
