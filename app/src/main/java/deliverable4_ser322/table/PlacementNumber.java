package deliverable4_ser322.table;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleLongProperty;

public class PlacementNumber {

    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleLongProperty placement = new SimpleLongProperty();

    public PlacementNumber(String name, long placement)
    {
        this.name.setValue(name);
        this.placement.setValue(placement);
    }
    public PlacementNumber(Object... args)
    {
        setName((String) args[0]);
        setPlacement((long) args[1]);
    }
    public PlacementNumber(){};

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

    public long getPlacement() {
        return placement.get();
    }

    public void setPlacement(long pCount) {
    	placement.set(pCount);
    }

    public SimpleLongProperty getPlacementProperty() {
        return placement;
    }
}
