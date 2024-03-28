package com.resort.spring_resort_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.resort.spring_resort_application.dao.RoomDao;
import com.resort.spring_resort_application.dto.Room;
import com.resort.spring_resort_application.exception.RoomIdNotFound;
import com.resort.spring_resort_application.util.ResponseStructure;

@Service
public class RoomService {

	@Autowired
	RoomDao roomDao;

	public ResponseEntity<ResponseStructure<Room>> saveRoom(Room room) {
		ResponseStructure<Room> responseStructure = new ResponseStructure<Room>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully created into DB");
		responseStructure.setData(roomDao.saveRoom(room));
		return new ResponseEntity<ResponseStructure<Room>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Room>> fetchRoomById(int roomId) {
		Room room=roomDao.fetchRoomById(roomId);
		if(room!=null)
		{
		ResponseStructure<Room> responseStructure = new ResponseStructure<Room>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched into DB");
		responseStructure.setData(roomDao.fetchRoomById(roomId));
		return new ResponseEntity<ResponseStructure<Room>>(responseStructure, HttpStatus.FOUND);
		}
		else {
			throw new RoomIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Room>> deleteRoomById(int roomId) {
		Room room=roomDao.fetchRoomById(roomId);
		if(room!=null)
		{
		ResponseStructure<Room> responseStructure = new ResponseStructure<Room>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully deleted into DB");
		responseStructure.setData(roomDao.deleteRoomById(roomId));
		return new ResponseEntity<ResponseStructure<Room>>(responseStructure, HttpStatus.OK);
		}
		else {
			throw new RoomIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Room>> updateRoomById(int oldRoomId, Room newRoom) {
		Room room=roomDao.fetchRoomById(oldRoomId);
		if(room!=null)
		{
		ResponseStructure<Room> responseStructure = new ResponseStructure<Room>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated into DB");
		responseStructure.setData(roomDao.updateRoomById(oldRoomId, newRoom));
		return new ResponseEntity<ResponseStructure<Room>>(responseStructure, HttpStatus.OK);
		}else {
			throw new RoomIdNotFound();
		}
	}
}
