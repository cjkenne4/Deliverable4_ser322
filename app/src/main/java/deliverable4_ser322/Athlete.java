package deliverable4_ser322;

import javafx.beans.property.SimpleStringProperty;

public class Athlete {
    private final SimpleStringProperty athleteID = new SimpleStringProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty email = new SimpleStringProperty();
    private final SimpleStringProperty  skill = new SimpleStringProperty();
    private final SimpleStringProperty organizationID = new SimpleStringProperty();

    public Athlete(String athleteID, String name, String email, String skill, String organizationID)
        {
            this.athleteID.setValue(athleteID);
            this.name.setValue(name);
            this.email.setValue(email);
            this.skill.setValue(skill);
            this.organizationID.setValue(organizationID);
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
        
        public String getAthleteID()
        {
            return athleteID.get();
        }

        public void setAthleteID(String pAthleteID)
        {
            athleteID.set(pAthleteID);
        }

        public SimpleStringProperty getAthleteIDProperty()
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
        
        public String getSkill()
        {
            return skill.get();
        }
        public void setSkill(String pSkill)
        {
            skill.set(pSkill);
        }
        public SimpleStringProperty getSkillProperty()
        {
            return skill;
        }
        public String getOrganizationID()
        {
            return organizationID.get();
        }
        public void setOrganizationID(String pOrgID)
        {
            skill.set(pOrgID);
        }
        public SimpleStringProperty getOrganizationIDProperty()
        {
            return organizationID;
        }

}
