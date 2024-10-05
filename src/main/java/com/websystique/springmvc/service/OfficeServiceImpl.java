package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.HibernateTokenRepositoryImpl;
import com.websystique.springmvc.dao.OfficesDao;
import com.websystique.springmvc.model.Office;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("OfficesServices")
@Transactional
public class OfficeServiceImpl implements OfficeService {
    @Autowired
    private OfficesDao officesDao;

    static final Logger logger = LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);

    @Override
    public List<Office> findAllOffices() {
        logger.info("Getting all offices");
        return officesDao.findAllOffices();
    }

    @Override
    public void deleteOfficeById(int id) {
        officesDao.deleteById(id);
    }

    @Override
    public void updateOffice(Office office) {
        logger.info("Updating all offices{}", office.getId());
        Office entity = officesDao.findById(office.getId());
        entity.setName(office.getName());
        entity.setAddress(office.getAddress());
        entity.setPostalCode(office.getPostalCode());
    }

    @Override
    public Office findById(int id) {
        return officesDao.findById(id);
    }
}
