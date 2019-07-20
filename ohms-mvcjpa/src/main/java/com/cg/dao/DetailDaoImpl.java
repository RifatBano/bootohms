package com.cg.dao;

import javax.persistence.Query;
import javax.persistence.QueryHint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.Exception.RoomDetailException;
import com.cg.Exception.RoomDetailsValidationException;
import com.cg.bean.HotelDetailsDto;
import com.cg.bean.RoomDetailsDto;

//this is my repository class
@Repository
@Transactional
public class DetailDaoImpl implements IDetailDao {
	@PersistenceContext
	private EntityManager em;
	RoomDetailsDto roomdetails = new RoomDetailsDto();
	
	//adding the roomdetails which is going to persist in database
	public String addDetail(RoomDetailsDto roomdetail,HotelDetailsDto hotelDetailsDto) throws RoomDetailException {

		try {
			roomdetail.setHoteldetails(hotelDetailsDto);
			em.persist(roomdetail);
		} catch (Exception e) {
			throw new RoomDetailException(RoomDetailsValidationException.MESSAGE);
		}
		return "added";
	}

	//deleting the row information according to the room_id
	@Override
	public String deleteDetail(int room_id) throws RoomDetailException {
		// TODO Auto-generated method stub

		roomdetails = em.find(RoomDetailsDto.class, room_id);
		if (roomdetails != null) {
			try {
				 em.remove(roomdetails);
			} catch (Exception e) {
				throw new RoomDetailException(RoomDetailsValidationException.MESSAGE);
			}
		}
		return "deleted";
	}

	//updating the price in the database of particular room_id
	@Override
	public String updatePrice(int roomid, double raiseprice) throws RoomDetailException {
		// TODO Auto-generated method stub

		roomdetails = em.find(RoomDetailsDto.class, roomid);
		if (roomdetails != null) {

			try {
				roomdetails.setPrice(raiseprice);
			} catch (Exception e) {
				throw new RoomDetailException(RoomDetailsValidationException.MESSAGE);
			}

		}
		return "updated";

	}
	
	
	public Query numberOfRooms(RoomDetailsDto room)
	{
		Query q1=em.createQuery("select count(roomtype) from roomdetails1 where roomtype=type");
		return q1;
	}
	public void updateWithOffers(RoomDetailsDto room)
	{
		Query q2=em.createQuery("update roomdetails1 set price=price*0.2 where "
				+ "number_of_persons<=2 and price>=5000");
		
	}
}