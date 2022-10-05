package deliverable4_ser322.table;

import javafx.beans.property.SimpleStringProperty;

public class UnrankedAthletes {

    private final SimpleStringProperty name = new SimpleStringProperty();

    public UnrankedAthletes(String name)
    {
        this.name.setValue(name);
    }
    public UnrankedAthletes(Object... args)
    {
        setName((String) args[0]);
    }
    public UnrankedAthletes(){};

    public String getName() {
        return name.get();
    }

    public void setName(String pName) {
        name.set(pName);
    }

    public SimpleStringProperty getNameProperty()
    {
        return name;
    }
}
