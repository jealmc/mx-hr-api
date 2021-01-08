package com.jmcfarlane.mxhrapi.repos;

import com.jmcfarlane.mxhrapi.pojos.Employee;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableRedisRepositories
public interface EmployeeRepository extends CrudRepository<Employee, String> {

}

