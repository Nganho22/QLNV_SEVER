package QLNVServiceAPI.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

@Document(collection = "Service")
public class Service {

    @Id
    private String id;

    @Field("mapping")
    private String mapping;

    @Field("port")
    private String port;
    
    @Field("serviceid")
    private int serviceId;

    @Field("servicename")
    private String serviceName;

    // Constructor with parameters
    public Service(String mapping, String port, int serviceId, String serviceName) {
        this.mapping = mapping;
        this.port = port;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }

    // Default constructor
    public Service() {}

    // Getters and Setters
    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    // Dynamically generate the URL
    public String getUrl() {
        return "http://localhost:" + this.port + "/" + this.mapping;
    }
}
