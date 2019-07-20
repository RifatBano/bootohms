package com.cg.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "hoteldetails")
public class HotelDetailsDto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAB_HOTEL_SEQ")
	@SequenceGenerator(name = "TAB_HOTEL_SEQ", sequenceName = "TAB_HOTEL_SEQ", allocationSize = 1)
	private int hotel_id;
	private String hotel_name;
	private String hotel_address;
	private int number_of_rooms;
	private String phone_no;

//	@OneToMany(mappedBy = "hoteldetails", cascade = CascadeType.ALL)
//	private Set<RoomDetailsDto> roomDetailsDto = new HashSet<>();

	public HotelDetailsDto() {
		super();
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_address() {
		return hotel_address;
	}

	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}

	public int getNumber_of_rooms() {
		return number_of_rooms;
	}

	public void setNumber_of_rooms(int number_of_rooms) {
		this.number_of_rooms = number_of_rooms;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

//	public Set<RoomDetailsDto> getRoomDetailsDto() {
//		return roomDetailsDto;
//	}
//
//	public void setRoomDetailsDto(Set<RoomDetailsDto> roomDetailsDto) {
//		this.roomDetailsDto = roomDetailsDto;
//	}

	//the method below will add roomdetail to hoteldetail 
		//also serves the purpose to avoid cyclic references. 
//		public void addRoomDetail(RoomDetailsDto roomdetail) {
//			roomdetail.setHoteldetails(this);		//this will avoid nested cascade
//			this.getRoomDetailsDto().add(roomdetail);
//		}
//	

}
