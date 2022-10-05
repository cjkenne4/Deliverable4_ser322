package deliverable4_ser322.table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CompetitionInfo {

    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty category = new SimpleStringProperty();
    private final SimpleIntegerProperty placement = new SimpleIntegerProperty();
    private final SimpleStringProperty winningStatistics = new SimpleStringProperty();

    public CompetitionInfo(String name, String category, int placement, String winningStatistics)
    {
        this.name.setValue(name);
        this.category.setValue(category);
        this.placement.setValue(placement);
        this.winningStatistics.setValue(winningStatistics);
    }
    public CompetitionInfo(Object... args)
    {
        setName((String) args[0]);
        setCategory((String) args[1]);
        setPlacement((int) args[2]);
        setWinningStatistics((String) args[3]);
    }
    public CompetitionInfo(){};

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

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String pCategory) {
        category.set(pCategory);
    }
    public SimpleStringProperty getCategoryProperty() {
        return category;
    }

    public int getPlacement() {
        return placement.get();
    }

    public void setPlacement(int pPlacement) {
        placement.set(pPlacement);
    }

    public SimpleIntegerProperty getPlacementProperty() {
        return placement;
    }

    public String getWinningStatistics() {
        return winningStatistics.get();
    }

    public void setWinningStatistics(String pWinningStatistics) {
    	winningStatistics.set(pWinningStatistics);
    }
    public SimpleStringProperty getWinningStatisticProperty() {
        return winningStatistics;
    }
}
