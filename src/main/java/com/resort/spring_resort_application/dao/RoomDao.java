package com.resort.spring_resort_application.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.resort.spring_resort_application.dto.Room;
import com.resort.spring_resort_application.repo.RoomRepo;

@Repository
public class RoomDao {

	@Autowired
	RoomRepo roomRepo;
	
	public Room saveRoom(Room room)
	{
		return roomRepo.save(room);
	}
	
	public Room fetchRoomById(int roomId)
	{
		Optional<Room> room=roomRepo.findById(roomId);
		if(room.isPresent())
		{
			return room.get();
		}return null;
	}
	
	public Room deleteRoomById(int roomId)
	{
		Room room = roomRepo.findById(roomId).get();
		roomRepo.delete(room);
		return room;
	}
	
	public Room updateRoomById(int oldRoomId,Room newRoom)
	{
		newRoom.setRoomId(oldRoomId);
		return roomRepo.save(newRoom);
	}
}
