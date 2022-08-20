package com.example.springmongo.controller;

import com.example.springmongo.model.Hotel;
import com.example.springmongo.model.MReference;
import com.example.springmongo.repository.MReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reference")
@CrossOrigin(origins = "*")
public class MReferenceResource {

    @Autowired
    private MReferenceRepository mReferenceRepository;

    @GetMapping
    public MReference getReference(){
        return mReferenceRepository.findAll().get(0);
    }

    @GetMapping("/increment/hotelNum")
    public Boolean incrementHotelRef(){
        MReference mReference = mReferenceRepository.findAll().get(0);
        mReference.setHotelNum(mReference.getHotelNum()+1);
        mReferenceRepository.save(mReference);
        return true;
    }
}
