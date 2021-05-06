package com.response;

import com.model.Instance;

import java.util.List;

public class InstancesResponse {


    public List<Instance> getInstances() {
        return instances;
    }

    public void setInstances(List<Instance> instances) {
        this.instances = instances;
    }

    List<Instance> instances;

}
