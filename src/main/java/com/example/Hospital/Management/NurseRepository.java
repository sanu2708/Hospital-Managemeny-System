package com.example.Hospital.Management;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class NurseRepository {
    HashMap<Integer,Nurse> nurseDb = new HashMap<>();
    public String addNurse(Nurse nurse)
    {
        int key = nurse.getNurseId();
        nurseDb.put(key,nurse);
        return "Nurse added Successfully";
    }

    public List<Nurse> getAllList()
    {
        List<Nurse> nurses = new ArrayList<>();
        return nurseDb.values().stream().toList();
    }
}
