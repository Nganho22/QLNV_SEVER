package QLNVdbsAPI.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "Service")

public class Database {
	@Id
	private String _id;
	private int ServiceID;
	private String ServiceName;
	private String DatabaseType;
	private String DatabaseName;
	private String DatabasePort;
	private String Collection;
	
	public int getServiceID() {
		return ServiceID;
	}
	public String getServiceName() {
		return ServiceName;
	}
	public String getDatabaseType() {
		return DatabaseType;
	}
	public String getDatabaseName() {
		return DatabaseName;
	}
	public String getDatabasePort() {
		return DatabasePort;
	}
	public String getCollection() {
		return Collection;
	}


	public Database(int ServiceID, String ServiceName, String DatabaseType,String DatabaseName,String DatabasePort, String Collection) {
		super();
		this.ServiceID = ServiceID;
		this.ServiceName = ServiceName;
		this.DatabaseType = DatabaseType;
		this.DatabaseName = DatabaseName;
		this.DatabasePort = DatabasePort;
		this.Collection = Collection;
	}
}
