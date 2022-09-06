package deliverable4_ser322;

import javafx.beans.property.SimpleStringProperty;

public class Athlete {
    private final SimpleStringProperty firstName = new SimpleStringProperty();
    private final SimpleStringProperty lastName = new SimpleStringProperty();
    private final SimpleStringProperty email = new SimpleStringProperty();

    public Athlete(String fName, String lName, String email)
        {
            this.firstName.setValue(fName);
            this.lastName.setValue(lName);
            this.email.setValue(email);
        }
        public String getFirstName()
        {
            return firstName.get();
        }

        public void setFirstName(String fName)
        {
            firstName.set(fName);
        }
        
        public SimpleStringProperty getFirstNameProperty()
        {
            return firstName;
        }
        
        public String getLastName()
        {
            return lastName.get();
        }

        public void setLastName(String fName)
        {
            lastName.set(fName);
        }

        public SimpleStringProperty getLastNameProperty()
        {
            return lastName;
        }
        
        public String getEmail()
        {
            return email.get();
        }

        public void setEmail(String fName)
        {
            email.set(fName);
        }
        
        public SimpleStringProperty getEmailProperty()
        {
            return email;
        }
}
