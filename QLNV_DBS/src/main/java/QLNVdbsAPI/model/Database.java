package QLNVdbsAPI.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

@Document(collection = "Service")
public class Database {

    @Id
    private String _id;

    @Field("ServiceID")
    private int serviceID; // Sử dụng String thay vì int để phù hợp với kiểu dữ liệu trong MongoDB

    @Field("ServiceName")
    private String serviceName;

    @Field("DatabaseType")
    private String databaseType;

    @Field("DatabaseName")
    private String databaseName;

    @Field("DatabasePort")
    private String databasePort;

    @Field("Collection")
    private String collection;

    // Constructor với tham số
    public Database(int serviceID, String serviceName, String databaseType, String databaseName, String databasePort, String collection) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.databaseType = databaseType;
        this.databaseName = databaseName;
        this.databasePort = databasePort;
        this.collection = collection;
    }

    // Constructor mặc định
    public Database() {
    }

    // Getter và Setter
    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabasePort() {
        return databasePort;
    }

    public void setDatabasePort(String databasePort) {
        this.databasePort = databasePort;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }
}
