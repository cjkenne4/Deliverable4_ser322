package deliverable4_ser322.table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Athlete {
    private final SimpleIntegerProperty athleteID = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty email = new SimpleStringProperty();
    private final SimpleIntegerProperty organizationID = new SimpleIntegerProperty();

    public Athlete(int athleteID, String name, String email, int skill, int organizationID)
    {
        this.athleteID.setValue(athleteID);
        this.name.setValue(name);
        this.email.setValue(email);
        this.organizationID.setValue(organizationID);
    }
    public Athlete(Object... args)
    {
        setAthleteID((int) args[0]);
        setName((String) args[1]);
        setEmail((String) args[2]);
        setOrganizationID((int) args[3]);
    }
    public Athlete(){};
    
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
        
    public int getAthleteID()
    {
        return athleteID.get();
    }

    public void setAthleteID(int pAthleteID)
    {
        athleteID.set(pAthleteID);
    }

    public SimpleIntegerProperty getAthleteIDProperty()
    {
        return athleteID;
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

}
