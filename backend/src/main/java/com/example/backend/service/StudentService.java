package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.mapper.StudentMapper;
import com.example.backend.model.StudentModel;

@Service
public class StudentService {

    private final StudentMapper dao;

    public StudentService(StudentMapper dao) {
        this.dao = dao;
    }

    public boolean insert(StudentModel student) {
        if (student.getId().equals("") || student.getName().equals("") || student.getEmail().equals("")) {
            return false;
        }
        return dao.insert(student) > 0;
    }

    public List<StudentModel> selectAll() {
        return dao.selectAll();
    }

    public StudentModel selectById(String id) {
        return dao.selectById(id);
    }

    public boolean update(StudentModel student) {
        return dao.update(student) > 0;
    }

    public boolean delete(String id) {
        return dao.delete(id) > 0;
    }

    public List<StudentModel> searchByName(String name) {
        return dao.searchByName(name);
    }

}