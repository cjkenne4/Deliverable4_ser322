package deliverable4_ser322.table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AthleteStats {

    private final SimpleIntegerProperty athleteID = new SimpleIntegerProperty();
    private final SimpleIntegerProperty competitionID = new SimpleIntegerProperty();
    private final SimpleStringProperty winningStatistics = new SimpleStringProperty();
    private final SimpleIntegerProperty placement = new SimpleIntegerProperty();

    public AthleteStats(int athleteID, int competitionID, String winningStatistics, int placement)
    {
        this.athleteID.setValue(athleteID);
        this.competitionID.setValue(competitionID);
        this.winningStatistics.setValue(winningStatistics);
        this.placement.setValue(placement);
    }
    public AthleteStats(Object...args)
    {
        setAthleteID((int) args[0]);
        setCompetitionID((int) args[1]);
        setWinningStatistics((String) args[2]);
        setPlacement((int) args[3]);
    }
    public AthleteStats(){};
    
    public int getAthleteID()
    {
        return athleteID.get();
    }
    public void setAthleteID(int pID) 
    {
        athleteID.set(pID);
    }
    public SimpleIntegerProperty getAthleteIDProperty()
    {
        return athleteID;
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
    public String getWinningStatistics()
    {
        return winningStatistics.get();
    }
    public void setWinningStatistics(String pWinStat)
    {
        winningStatistics.set(pWinStat);
    }
    public SimpleStringProperty getWinningStatisticsProperty()
    {
        return winningStatistics;
    }
    public int getPlacement()
    {
        return placement.get();
    }

    public void setPlacement(int pPlacement)
    {
        placement.set(pPlacement);
    }
        
    public SimpleIntegerProperty getPlacementProperty()
    {
        return placement;
    }
    
    
}
