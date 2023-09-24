package com.example.Hospital.Management;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NurseService {
    NurseRepository nurseRepository = new NurseRepository();
    public String addNurse(Nurse nurse)
    {
        String ans = nurseRepository.addNurse(nurse);
        return ans;
    }

    public List<Nurse> getList()
    {
        List<Nurse> nurses = nurseRepository.getAllList();

        return nurses;
    }

    public List<Nurse> getListByGreaterThanAge(Integer age)
    {
        List<Nurse> nurses = nurseRepository.getAllList();
        for(Nurse nurse : nurses)
        {
            if(nurse.getAge()>age){
                nurses.add(nurse);
            }
        }
        return nurses;
    }
}
