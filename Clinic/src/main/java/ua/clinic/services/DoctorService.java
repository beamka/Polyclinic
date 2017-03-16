package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.clinic.jpa.Doctor;
import ua.clinic.jpa.Graphic;
import ua.clinic.jpa.Userdetails;
import ua.clinic.repository.DoctorRepository;
import ua.clinic.repository.UserRepository;
import ua.clinic.repository.UserdetailsRepository;

/**
 * Created by Iryna Tkachova on 13.03.2017.
 */
@Service
public class DoctorService {
    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    UserdetailsRepository detailsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;

    public Userdetails setDoctor(Long id_user, Long tabnumber) {
        Userdetails userdetails = detailsRepository.findOne(id_user);
        if(userdetails != null) {
            Doctor doctor = new Doctor();
            doctor.setIddoctor(tabnumber);
            doctor.setUserdetails(userdetails);
            doctorRepository.save(doctor);
        }
        return detailsRepository.findOne(id_user);
    }
}
