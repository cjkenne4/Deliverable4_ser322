package deliverable4_ser322.table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDateTime;

public class SponsorsSponsored {

    private final SimpleIntegerProperty sponsorID = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleIntegerProperty competitionID = new SimpleIntegerProperty();
    private final SimpleStringProperty prize = new SimpleStringProperty();
    private final SimpleObjectProperty<LocalDateTime> datetime = new SimpleObjectProperty<LocalDateTime>();

    public SponsorsSponsored(int sponsorID, String name, int competitionID, String prize, LocalDateTime datetime)
    {
        this.sponsorID.setValue(sponsorID);
        this.name.setValue(name);
        this.competitionID.setValue(competitionID);
        this.prize.setValue(prize);
        this.datetime.setValue(datetime);
    }
    public SponsorsSponsored(Object... args)
    {
        setSponsorID((int) args[0]);
        setName((String) args[1]);
        setCompetitionID((int) args[2]);
        setPrize((String) args[3]);
        setDatetime((LocalDateTime) args[4]);
    }
    public SponsorsSponsored(){};

    public int getSponsorID() {
        return sponsorID.get();
    }

    public void setSponsorID(int pSponsorID) {
        sponsorID.set(pSponsorID);
    }

    public SimpleIntegerProperty getSponsorIDProperty() {
        return sponsorID;
    }

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

    public int getCompetitionID() {
        return competitionID.get();
    }

    public void setCompetitionID(int pCompetitionID) {
        competitionID.set(pCompetitionID);
    }

    public SimpleIntegerProperty getCompetitionIDProperty() {
        return competitionID;
    }

    public String getPrize() {
        return prize.get();
    }

    public void setPrize(String pPrize) {
        prize.set(pPrize);
    }

    public SimpleStringProperty getPrizeProperty()
    {
        return prize;
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
