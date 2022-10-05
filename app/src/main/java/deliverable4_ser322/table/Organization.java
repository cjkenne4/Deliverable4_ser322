package deliverable4_ser322.table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Organization {

    private final SimpleIntegerProperty organizationID = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty email = new SimpleStringProperty();
    private final SimpleStringProperty  type = new SimpleStringProperty();

    public Organization(int organizationID, String name, String email, String type)
    {
        this.organizationID.setValue(organizationID);
        this.name.setValue(name);
        this.email.setValue(email);
        this.type.setValue(type);
    }
    public Organization(Object... args)
    {
        setOrganizationID((int) args[0]);
        setName((String) args[1]);
        setEmail((String) args[2]);
        setType((String) args[3]);
    }
    public Organization(){};
    
    public int getOrganizationID()
    {
        return organizationID.get();
    }
    public void setOrganizationID(int pOrgID)
    {
        organizationID.set(pOrgID);
    }
    public SimpleIntegerProperty getOrganizationIDProperty()
    {
        return organizationID;
    }
    public String getName()
    {
        return name.get();
    }

    public void setName(String pName)
    {
        name.set(pName);
    }
        
    public SimpleStringProperty getFirstNameProperty()
    {
        return name;
    }
        
    public String getEmail()
    {
        return email.get();
    }

    public void setEmail(String pEmail)
    {
        email.set(pEmail);
    }
        
    public SimpleStringProperty getEmailProperty()
    {
        return email;
    }
    public String getType()
    {
        return type.get();
    }

    public void setType(String pEmail)
    {
        type.set(pEmail);
    }
        
    public SimpleStringProperty getTypeProperty()
    {
        return type;
    }
}
