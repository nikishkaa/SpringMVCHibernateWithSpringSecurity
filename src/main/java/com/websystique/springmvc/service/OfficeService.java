package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Office;

import java.util.List;

public interface OfficeService {
    List<Office> findAllOffices();

    void deleteOfficeById(int id);

    void updateOffice(Office office);

    Office findById(int id);

}
