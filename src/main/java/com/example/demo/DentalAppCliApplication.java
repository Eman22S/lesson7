package com.example.demo;


import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class DentalAppCliApplication implements CommandLineRunner {

    private final DentistService dentistService;
    private final PatientService patientService;
    private final SurgeryService surgeryService;
    private final AppointmentService appointmentService;
    private final AddressService addressService;

    public DentalAppCliApplication(DentistService dentistService,
                                   PatientService patientService,
                                   SurgeryService surgeryService,
                                   AppointmentService appointmentService,
                                   AddressService addressService) {
        this.dentistService = dentistService;
        this.patientService = patientService;
        this.surgeryService = surgeryService;
        this.appointmentService = appointmentService;
        this.addressService = addressService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DentalAppCliApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🌟 Populating database with sample appointment data...");

        // 🏥 Create Surgeries
        var s10 = surgeryService.createSurgery(new Surgery("S10", "Surgery 10", addNewAddress("10 Main St", "Fairfield", "IA", "52556")));
        var s13 = surgeryService.createSurgery(new Surgery("S13", "Surgery 13", addNewAddress("13 Elm St", "Fairfield", "IA", "52556")));
        var s15 = surgeryService.createSurgery(new Surgery("S15", "Surgery 15", addNewAddress("15 Oak St", "Fairfield", "IA", "52556")));

        // 🦷 Create Dentists
        var tonySmith = dentistService.createDentist(new Dentist(null, "Tony Smith"));
        var helenPearson = dentistService.createDentist(new Dentist(null, "Helen Pearson"));
        var robinPlevin = dentistService.createDentist(new Dentist(null, "Robin Plevin"));

        // 🧑‍⚕️ Create Patients
        var gillianWhite = patientService.createPatient(new Patient("P100", "Gillian White", addNewAddress("100 Pine St", "Fairfield", "IA", "52556")));
        var jillBell = patientService.createPatient(new Patient("P105", "Jill Bell", addNewAddress("105 Cedar St", "Fairfield", "IA", "52556")));
        var ianMacKay = patientService.createPatient(new Patient("P108", "Ian MacKay", addNewAddress("108 Maple St", "Fairfield", "IA", "52556")));
        var johnWalker = patientService.createPatient(new Patient("P110", "John Walker", addNewAddress("110 Birch St", "Fairfield", "IA", "52556")));

        // 📅 Create Appointments
        appointmentService.createAppointment(new Appointment(null, LocalDate.of(2013, 9, 12), LocalTime.of(10, 0), tonySmith, gillianWhite, s15));
        appointmentService.createAppointment(new Appointment(null, LocalDate.of(2013, 9, 12), LocalTime.of(12, 0), tonySmith, jillBell, s15));
        appointmentService.createAppointment(new Appointment(null, LocalDate.of(2013, 9, 13), LocalTime.of(10, 0), helenPearson, ianMacKay, s10));
        appointmentService.createAppointment(new Appointment(null, LocalDate.of(2013, 9, 14), LocalTime.of(14, 0), helenPearson, ianMacKay, s10));
        appointmentService.createAppointment(new Appointment(null, LocalDate.of(2013, 9, 14), LocalTime.of(16, 30), robinPlevin, jillBell, s15));
        appointmentService.createAppointment(new Appointment(null, LocalDate.of(2013, 9, 15), LocalTime.of(18, 0), robinPlevin, johnWalker, s13));

        System.out.println("✅ Sample data inserted!\n");
        appointmentService.getAllAppointments().forEach(System.out::println);
    }
    private Address addNewAddress(String street, String city, String state, String zipCode) {
        Address address = new Address(null, street, city, state, zipCode);
        return addressService.createAddress(address);
    }


}
