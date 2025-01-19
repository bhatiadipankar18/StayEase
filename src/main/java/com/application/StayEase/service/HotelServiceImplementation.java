package com.application.StayEase.service;

import com.application.StayEase.dto.HotelDto;
import com.application.StayEase.entity.Hotel;
import com.application.StayEase.exception.ResouceNotFoundException;
import com.application.StayEase.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImplementation implements HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("creating a new hotel with name: {}", hotelDto.getName());
            Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
            hotel.setActive(false);
            hotel = hotelRepository.save(hotel);
            log.info("created hotel with name: {}", hotelDto.getName());
            return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("getting the hotel with id: {}", id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResouceNotFoundException("hotel not found with id: " + id));
             return modelMapper.map(hotel, HotelDto.class);
    }
}
