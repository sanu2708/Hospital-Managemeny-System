package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {
    HashMap<Integer,Patient> patientDb = new HashMap<>();
    @PostMapping("/addPatientViaParam")
    public String addPatient(@RequestParam("patientId") Integer patientId, @RequestParam("name") String name, @RequestParam("disease") String disease, @RequestParam("age") Integer age){
        Patient patient = new Patient(patientId,name,disease,age); // get value of key by constructor
       patientDb.put(patientId,patient);
       return  "patient added via PARAM";
    }

    @PostMapping("/addPatientViaBody")
    public String addPatient(@RequestBody Patient patient)
    {
        int key = patient.getPatientId(); //value of key by Objects
        patientDb.put(key,patient);
        return "patient added via BODY";
    }

    @GetMapping("/getPatientInfo")
    public Patient addPatient(@RequestParam("patientId") Integer patientId){
        Patient patient = patientDb.get(patientId);
        return patient;
    }

    @GetMapping("/getAllPatients")
    public List<Patient> addPatient(){
        List<Patient> patients = new ArrayList<>();
//        for(Patient p : patientDb.values())
//        {
//            patients.add(p);
//        }
//        return patients;
        return patientDb.values().stream().toList();  // we can use this line also
    }

    @GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("name") String name)
    {
        for(Patient p : patientDb.values())
        {
            if(p.getName().equals(name))
            {
                return p;
            }

        }
        return null;
    }

    @GetMapping("/getPatientGreaterThanAgeList")
    public List<Patient> getPatient(@RequestParam("age") Integer age)
    {
        List<Patient> patients = new ArrayList<>();
        for(Patient p : patientDb.values())
        {
            if(p.getAge() > age)
            {
                patients.add(p);
            }
        }
        return patients;
    }

    @GetMapping("/getPatientViaPathVariable/{age}/{disease}")
    public List<Patient> getPatient(@PathVariable("age") Integer age , @PathVariable("disease") String disease)
    {
        List<Patient> patients = new ArrayList<>();
        for(Patient p : patientDb.values())
        {
            if(p.getAge() > age && p.getDisease().equals(disease)){
                patients.add(p);
            }
        }
        return patients;
    }
    @PutMapping("/updatePatientDetails")
    public String updatePatient(@RequestBody Patient patient)
    {
        int key = patient.getPatientId();
        if(patientDb.containsKey(key))
        {
            patientDb.put(key,patient);
        }
        return "Patient Details Updated Successfully";
    }

    @PutMapping("/updateDisease")
    public String updateDisease(@RequestParam("PatientId") Integer patientId,@RequestParam("disease") String disease)
    {
        if(patientDb.containsKey(patientId)){
            Patient patient = patientDb.get(patientId);
            patient.setDisease(disease);
            patientDb.put(patientId,patient);
        }
        return "Patient disease updated successfully";
    }

    @PutMapping("/deletePatient")
    public String deletePatient(@RequestParam("patientId") Integer patientId)
    {
        patientDb.remove(patientId);
        return "Patient Remove Successfully";
    }
}
