package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("officesDao")
public class OfficesDaoImpl extends AbstractDao<Integer, Office> implements OfficesDao {
    @Override
    public List<Office> findAllOffices() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("address"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Office> offices = (List<Office>) criteria.list();
        return offices;
    }

    @Override
    public void deleteById(int id) {
        Office office = getByKey(id);
        if (office != null) {
            delete(office);
        }

    }

    @Override
    public Office findById(int id) {
        Office office = getByKey(id);
        return office;
    }
}
