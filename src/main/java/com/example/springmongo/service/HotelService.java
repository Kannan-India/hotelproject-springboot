package com.example.springmongo.service;

import com.example.springmongo.model.Hotel;
import com.example.springmongo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class HotelService {

    //DAO
    @Autowired
    HotelRepository hotelRepository;

    //Saving Hotels in a list
    private List<Hotel> hotelList = new CopyOnWriteArrayList<>();

    public  Hotel addHotel(Hotel hotel){
        return hotelRepository.insert(hotel);
    }

    public List<Hotel> getHotels(){
        return hotelRepository.findAll();
    }

    public  Hotel getHotel(String id){

        Optional<Hotel> optional = hotelRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            return null;
        }
//        return hotelList.stream().filter(
//                h -> h.getId().equals(id)
//        ).findFirst().get();
    }

    public String deleteHotel(String id){
        hotelRepository.deleteById(id);


//        hotelList.stream().forEach(
//                hotel -> {
//                    if(hotel.getId().equals(id)){
//                        hotelList.remove(hotel);
//                    }
//                }
//        );

        return "Success";
    }

    public Hotel updateHotel(Hotel hotel){

        return hotelRepository.save(hotel);

    }

    public void delall(){
        hotelRepository.deleteAll();
    }

    public Hotel getbyprice(int price){
        return hotelRepository.findByPricePerNight(price);
    }

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Hotel> getH(){
        Query query = new Query();
        List<Integer> parr = new ArrayList<Integer>();
        parr.add(3250);
        parr.add(5000);
        parr.add(3000);
        parr.add(7250);
        Integer[] parr2 = {5000,3000};

        query.addCriteria(Criteria.where("pricePerNight").in(Arrays.asList(parr2)));

        return mongoTemplate.find(query, Hotel.class);
    }
}
