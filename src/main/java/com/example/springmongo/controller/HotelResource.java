package com.example.springmongo.controller;

import com.example.springmongo.model.Hotel;
import com.example.springmongo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hotels")
@CrossOrigin(origins = "*")
public class HotelResource {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public List<Hotel> getHotels(){
        return hotelService.getHotels();
    }

    @PostMapping
    public Boolean addHotel(@RequestBody Hotel hotel){
        try{
            hotelService.addHotel(hotel);
            return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    @PutMapping
    public Boolean updateHotel(@RequestBody Hotel hotel){
        try{
            hotelService.updateHotel(hotel);
            return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }

    @DeleteMapping(value = "/{id}")
    public Boolean deleteHotel(@PathVariable("id") String id){
        try{
            hotelService.deleteHotel(id);
            return true;
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    /*
    *
    * updated code ends here
    *
    * */

    @GetMapping(value = "/contains")
    public List<Hotel> geth(){
        return hotelService.getH();
    }

    @GetMapping(value = "/{id}")
    public Hotel getHotel(@PathVariable("id") String id){
        return hotelService.getHotel(id);
    }

    @GetMapping(value = "/price/{p}")
    public Hotel getbyprice(@PathVariable("p") int p){
        return hotelService.getbyprice(p);
    }



    @DeleteMapping(value = "/all")
    public void del(){
        hotelService.delall();
    }



}
