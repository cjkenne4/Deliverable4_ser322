package deliverable4_ser322.table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sponsor {

    private final SimpleIntegerProperty sponsorID = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty email = new SimpleStringProperty();

    public Sponsor(int sponsorID, String name, String email, String type)
    {
        this.sponsorID.setValue(sponsorID);
        this.name.setValue(name);
        this.email.setValue(email);
    }
    public Sponsor(Object... args)
    {
        setSponsorID((int) args[0]);
        setName((String) args[1]);
        setEmail((String) args[2]);
    }
    public Sponsor(){};
    
    public int getSponsorID()
    {
        return sponsorID.get();
    }
    public void setSponsorID(int pID)
    {
        sponsorID.set(pID);
    }
    public SimpleIntegerProperty getSponsorIDProperty()
    {
        return sponsorID;
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
    
}
