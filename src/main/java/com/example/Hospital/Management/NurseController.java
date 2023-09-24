package com.example.Hospital.Management;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Nurse")
public class NurseController {
    NurseService nurseService = new NurseService();
    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse)
    {
        String ans = nurseService.addNurse(nurse);
        return ans;
    }
    @GetMapping("/getListOfALl")
    public List<Nurse> getList()
    {
        List<Nurse> nurses = nurseService.getList();
        return nurses;
    }

    @GetMapping("/getListByAge")
    public List<Nurse> getListByGreaterThanAge(@RequestParam("age") Integer age)
    {
        List<Nurse> nurses = nurseService.getListByGreaterThanAge(age);
        return nurses;
    }
}
