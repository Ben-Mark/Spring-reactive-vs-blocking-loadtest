package com.olympus.blocking.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olympus.blocking.couchbase.model.Building;
import com.olympus.blocking.couchbase.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BlockingController {

    private final BuildingService buildingService;

    public BlockingController(BuildingService buildingService){
        this.buildingService = buildingService;
    }


    @GetMapping("/get-object-blocking")
    @ResponseBody
    public ResponseEntity<?> get(@RequestParam String id) {
        Optional<Building> newBuilding = buildingService.findById(id);//.orElseThrow(()-> new Exception("Test failure: couchbase document doesnt exist right-after insertion"));

        if(newBuilding.isPresent()){
            return new ResponseEntity<Building>(newBuilding.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("object doesn't exist",HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(value = "/save-object-blocking", consumes = "application/json", produces = "application/json")
//    @ResponseBody
    public ResponseEntity<?> saveObject(@RequestBody Building building) {
        try {
            buildingService.save(building);
            return new ResponseEntity<String>("Item saved successfully",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}

