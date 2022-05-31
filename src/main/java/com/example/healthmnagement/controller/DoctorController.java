package com.example.healthmnagement.controller;

import com.example.healthmnagement.data.dto.DoctorResponseDto;
import com.example.healthmnagement.data.dto.SignUpDoctorRequest;
import com.example.healthmnagement.data.model.Address;
import com.example.healthmnagement.exception.DoctorAlreadyExistException;
import com.example.healthmnagement.exception.DoctorNotFoundExeption;
import com.example.healthmnagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;


    @PostMapping("/registration")
    public ResponseEntity<?> registerDoctor(@RequestBody SignUpDoctorRequest signUpDoctorRequest){
        try{
            DoctorResponseDto registeredDoctor = doctorService.registerNewDoctor(signUpDoctorRequest);
            return ResponseEntity.ok().body(registeredDoctor);

        }
        catch ( DoctorAlreadyExistException e ){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
    @GetMapping("/allDoctor")
    public ResponseEntity<?> getAllStaff(){
        try{
            return ResponseEntity.ok().body(doctorService.findAllDoctor());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
    @GetMapping("/{doctorId}")
    public ResponseEntity<?> getAStaff(@PathVariable Long doctorId){
        try{
            return ResponseEntity.ok().body(doctorService.findDoctorById(doctorId));
        }
        catch(DoctorNotFoundExeption e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
    @PatchMapping("/address")
    public ResponseEntity<?> updateAddress(@PathVariable Long doctorId, Address address){
        try{
            return ResponseEntity.ok().body(doctorService.updateDoctorAddress(doctorId, address));
        }
         catch (DoctorNotFoundExeption e) {
           return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
    @DeleteMapping("/{doctorId}")
    public ResponseEntity<?> removeAStaff(@PathVariable Long doctorId){
        try{
            return ResponseEntity.ok().body(doctorService.removeDoctor(doctorId));
        }
        catch(DoctorNotFoundExeption e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
        catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
}
