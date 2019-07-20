package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.HotelDetailsDto;
import com.cg.bean.RoomDetailsDto;
import com.cg.service.IService;


/*
 * @Controller class
 */
@RestController
public class RoomDetailControl {

	//Autowiring for service class object
	@Autowired
	
	private IService service;	
    public void setService(IService service) {
		this.service = service;
	}

    //requestmapping for adding roomdetails
    
	@RequestMapping(value = "/addroomdetail", method = RequestMethod.POST,consumes="application/json", produces = "application/json")
	public String roomDetailsDto(@RequestBody RoomDetailsDto roomDetailsDto,@PathVariable("hotel_id") int hotel_id) {
	String result=null;
	//roomdata.getRoom_id();
	HotelDetailsDto hotelDetailsDto=new HotelDetailsDto();
	hotelDetailsDto.setHotel_id(hotel_id);
	roomDetailsDto.setNumber_of_persons(roomDetailsDto.getNumber_of_persons());
	roomDetailsDto.setPrice(roomDetailsDto.getPrice());
	roomDetailsDto.setRoomtype(roomDetailsDto.getRoomtype());
	try {
		
     result=service.addDetail(roomDetailsDto,hotelDetailsDto);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return result;
	}
//requestmapping for deleting the record according to the id
	
	@RequestMapping(value = "/deleteroomdetail", method = RequestMethod.DELETE,consumes="application/json", produces = "application/json")
	public String roomDetailsDto2(@RequestBody RoomDetailsDto roomDetailsDto) {
		String result=null;
		try {
	    result=service.deleteDetail(roomDetailsDto.getRoom_id());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
		}
	
	//requestmapping for updating the price of the given row by id

	@RequestMapping(value = "/updateroomdetail", method = RequestMethod.PUT,consumes="application/json")
	public String roomDetailsDto(@RequestBody RoomDetailsDto roomDetailsDto) {
		String result=null;
		try {
	        result=service.updatePrice(roomDetailsDto.getRoom_id(),roomDetailsDto.getPrice());
	    		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
		}
	
	
}
	

