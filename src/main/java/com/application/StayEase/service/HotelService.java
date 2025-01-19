package com.application.StayEase.service;

import com.application.StayEase.dto.HotelDto;
import com.application.StayEase.entity.Hotel;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);
}
