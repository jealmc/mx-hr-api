package com.jmcfarlane.mxhrapi.pojos;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Managers")
public class Manager extends Employee implements Serializable {
}
