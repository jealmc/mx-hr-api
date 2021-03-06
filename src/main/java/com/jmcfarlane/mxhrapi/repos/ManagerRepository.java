package com.jmcfarlane.mxhrapi.repos;

import com.jmcfarlane.mxhrapi.pojos.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, String> {

}

