package com.cg.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//this is my bean class whose entity will map to the database roomdetails1
@Entity
@Table(name = "roomdetails")
public class RoomDetailsDto  {
	/**
	 * here room_id is primary key and it should be system generated sequentially
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TAB_ROOM_SEQ")
	@SequenceGenerator(name = "TAB_ROOM_SEQ", sequenceName = "TAB_ROOM_SEQ", allocationSize = 1)
	private int room_id;
	public HotelDetailsDto getHoteldetails() {
		return hoteldetails;
	}

	public void setHoteldetails(HotelDetailsDto hoteldetails) {
		this.hoteldetails = hoteldetails;
	}

	private int number_of_persons;
	private double price;
	private String roomtype;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private HotelDetailsDto hoteldetails;

	
	public RoomDetailsDto() {
		
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getNumber_of_persons() {
		return number_of_persons;
	}

	public void setNumber_of_persons(int number_of_persons) {
		this.number_of_persons = number_of_persons;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "RoomDetailsDto [room_id=" + room_id + ", number_of_persons=" + number_of_persons + ", price=" + price
				+ ", roomtype=" + roomtype + "]";
	}


}
