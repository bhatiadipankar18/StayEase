package com.application.StayEase.controller;

import com.application.StayEase.dto.HotelDto;
import com.application.StayEase.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/hotels")
@RequiredArgsConstructor
@Slf4j
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDto> createNewHotel(@RequestBody HotelDto hotelDto){
        log.info("attempting to create new hotel with name: " + hotelDto.getName());
        HotelDto hotel = hotelService.createNewHotel(hotelDto);
        log.info("created a hotel with name: " + hotelDto.getName());
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    @GetMapping(path= "/{hotelId}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long hotelId){
        HotelDto hotel = hotelService.getHotelById(hotelId);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }
}
