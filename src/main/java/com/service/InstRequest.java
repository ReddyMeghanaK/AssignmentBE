package com.service;

import com.model.Instance;

import java.util.HashMap;
import java.util.Map;

public class InstRequest {
    Map<String, Instance> instanceMap = new HashMap<>();

    public Map<String, Instance> getInstanceMap() {
        return instanceMap;
    }

    public void setInstanceMap(Map<String, Instance> instanceMap) {
        this.instanceMap = instanceMap;
    }
}
