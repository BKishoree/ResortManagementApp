package com.resort.spring_resort_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resort.spring_resort_application.dto.Room;
import com.resort.spring_resort_application.service.RoomService;
import com.resort.spring_resort_application.util.ResponseStructure;

@RestController
public class RoomController {

	@Autowired
	RoomService roomService;
	
	@PostMapping("/saveRoom")
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@RequestBody Room room)
	{
		return roomService.saveRoom(room);
	}
	
	@GetMapping("/fetchRoomById")
	public ResponseEntity<ResponseStructure<Room>> fetchRoomById(@RequestParam int roomId)
	{
		return roomService.fetchRoomById(roomId);
	}
	
	@DeleteMapping("/deleteRoomById")
	public ResponseEntity<ResponseStructure<Room>> deleteRoomById(@RequestParam int roomId)
	{
		return roomService.deleteRoomById(roomId);
	}
	
	@PutMapping("/updateRoomById")
	public ResponseEntity<ResponseStructure<Room>> updateRoomById(@RequestParam int oldRoomId,@RequestBody Room newRoom)
	{
		return roomService.updateRoomById(oldRoomId, newRoom);
	}
}
