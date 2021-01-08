package com.jmcfarlane.mxhrapi.pojos;

import com.jmcfarlane.mxhrapi.controllers.ManagerController;
import com.jmcfarlane.mxhrapi.repos.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("TeamMembers")
public class TeamMember extends Employee implements Serializable {
    public Manager manager;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager newManager) {
        this.manager = newManager;
    }
}
