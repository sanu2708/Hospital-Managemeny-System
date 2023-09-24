package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/Doctor")
public class DoctorController {
    HashMap<Integer,Doctor> doctorDb = new HashMap<>();
    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor)
    {
        int key  = doctor.getDoctorId();
        doctorDb.put(key,doctor);
        return "DOCTOR ADDED SUCCESSFULLY";
    }
}
