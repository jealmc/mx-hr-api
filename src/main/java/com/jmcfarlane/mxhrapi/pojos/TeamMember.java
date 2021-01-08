package com.jmcfarlane.mxhrapi.pojos;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash("TeamMembers")
public class TeamMember extends Employee implements Serializable {
    @Indexed
    public String managerId;

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
}
