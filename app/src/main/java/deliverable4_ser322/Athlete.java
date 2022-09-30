package deliverable4_ser322;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Athlete {
    private final SimpleIntegerProperty athleteID = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty email = new SimpleStringProperty();
    private final SimpleIntegerProperty  skill = new SimpleIntegerProperty();
    private final SimpleIntegerProperty organizationID = new SimpleIntegerProperty();

    public Athlete(int athleteID, String name, String email, int skill, int organizationID)
        {
            this.athleteID.setValue(athleteID);
            this.name.setValue(name);
            this.email.setValue(email);
            this.skill.setValue(skill);
            this.organizationID.setValue(organizationID);
        }
    public Athlete(Object... args)
        {
            setAthleteID((int) args[0]);
            setName((String) args[1]);
            setEmail((String) args[2]);
            setSkill((int) args[3]);
            setOrganizationID((int) args[4]);
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
        
    public int getSkill()
    {
        return skill.get();
    }
    public void setSkill(int pSkill)
    {   
        skill.set(pSkill);
    }
    public SimpleIntegerProperty getSkillProperty()
    {
        return skill;
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
