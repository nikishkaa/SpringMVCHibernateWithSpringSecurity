package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Office;

import java.util.List;

public interface OfficesDao {
    List<Office> findAllOffices();

    void deleteById(int id);

    Office findById(int id);

}
