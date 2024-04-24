package com.login.login.services;


import org.springframework.stereotype.Service;
import java.util.List;
import com.login.login.model.Attendance;
import com.login.login.repository.AttendanceRepository;

@Service
public class AttendanceServices {
    public AttendanceRepository attendanceRepository;
    public AttendanceServices(AttendanceRepository attendanceRepository)
    {
        this.attendanceRepository=attendanceRepository;
    }
    public Attendance postAttendance(Attendance attendance)
    {
        return attendanceRepository.save(attendance);
    }
    public Attendance getAttendance(int id)
    {
        return attendanceRepository.findById(id).orElse(null);
    }
    public List<Attendance> getAll()
    {
        return attendanceRepository.findAll();
    }
    public List<Attendance> getPresentAttendances(String Present)
    {
        return attendanceRepository.findByPresent(Present);
    }
}
