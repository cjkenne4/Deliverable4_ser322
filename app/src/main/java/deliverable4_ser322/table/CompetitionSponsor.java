package deliverable4_ser322.table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CompetitionSponsor {

    private final SimpleIntegerProperty competitionID = new SimpleIntegerProperty();
    private final SimpleIntegerProperty sponsorID = new SimpleIntegerProperty();
    private final SimpleStringProperty prize = new SimpleStringProperty();

    public CompetitionSponsor(int competitionID, int sponsorID, String prize)
    {
        this.competitionID.setValue(competitionID);
        this.sponsorID.setValue(sponsorID);
        this.prize.setValue(prize);
    }
    public CompetitionSponsor(Object... args)
    {   
        setCompetitionID((int) args[0]);
        setSponsorID((int) args[1]);
        setPrize((String) args[2]);
    }
    public CompetitionSponsor(){};
    
    public int getCompetitionID()
    {
        return competitionID.get();
    }
    public void setCompetitionID(int pID)
    {
        competitionID.set(pID);
    }
    public SimpleIntegerProperty getCompetitionIDProperty()
    {
        return competitionID;
    }
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
    public String getPrize()
    {
        return prize.get();
    }
    public void setPrize(String pPrize)
    {
        prize.set(pPrize);
    }
        
    public SimpleStringProperty getPrizeProperty()
    {
        return prize;
    }
}
