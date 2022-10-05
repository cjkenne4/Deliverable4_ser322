package deliverable4_ser322.table;

import java.time.LocalDateTime;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Competition {

    private final SimpleIntegerProperty competitionID = new SimpleIntegerProperty();
    private final SimpleStringProperty category = new SimpleStringProperty();
    private final SimpleObjectProperty<LocalDateTime> datetime = new SimpleObjectProperty<LocalDateTime>();
    
    public Competition(int competitionID, String category, LocalDateTime datetime, int skill){
        this.competitionID.setValue(competitionID);
        this.category.setValue(category);
        this.datetime.setValue(datetime);
    }
    public Competition(Object... args)
        {
            setCompetitionID((int) args[0]);
            setCategory((String) args[1]);
            setDatetime((LocalDateTime) args[2]);
        }
    public Competition(){
        
    }

    public int getCompetitionID()
    {
        return competitionID.get();
    }

    public void setCompetitionID(int pCompID)
    {
        competitionID.set(pCompID);
    }
        
    public SimpleIntegerProperty getCompetitionIDProperty()
    {
        return competitionID;
    }
    public String getCategory()
    {
        return category.get();
    }
    public void setCategory(String pCat)
    {
        category.set(pCat);
    }
    public SimpleStringProperty getCategoryProperty()
    {
        return category;
    }
    public LocalDateTime getDatetime()
    {
        return datetime.get();
    }
    public void setDatetime(LocalDateTime pDate)
    {
        datetime.set(pDate);
    }
    public SimpleObjectProperty<LocalDateTime> getDateTimeProperty()
    {
        return datetime;
    }
}
