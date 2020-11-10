package com.web.assgiment.dormitory.service;

import com.web.assgiment.dormitory.dto.ListId;
import com.web.assgiment.dormitory.dto.PageDto;
import com.web.assgiment.dormitory.dto.RoomDto;
import com.web.assgiment.dormitory.exception.UserValidateException;

import java.util.*;

public interface RoomService {
    RoomDto saveRoom(RoomDto roomDto) throws UserValidateException;

    Map<String, Object> getAllRoom(PageDto pageDto) throws UserValidateException;

    List<RoomDto> deleteRoom(List<RoomDto> listIds) throws UserValidateException;

    RoomDto updateOneRoom(RoomDto roomDto) throws UserValidateException;

    Map<String, Object> filterByRoomCode(PageDto pageDto, String roomCode);
}