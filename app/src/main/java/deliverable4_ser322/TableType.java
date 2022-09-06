package deliverable4_ser322;

import java.util.ArrayList;
import java.util.Arrays;

public enum TableType {

    ATHLETE(new ArrayList<>(Arrays.asList("AthleteID", "firstName", "lastName", "email","Rank","NumberOfCompetitions")))
    {
        @Override
        public void filterColumns(String cbVal) {
           
        }
    },
    COMPETITION(new ArrayList<>(Arrays.asList("CompetitionID", "Category","DateTime","Rank")))
    {
        @Override
        public void filterColumns(String cbVal) {

        }
    },
    SPONSOR(new ArrayList<>(Arrays.asList("SponsorID", "Email", "Name")))
    {
        @Override
        public void filterColumns(String cbVal) {
            
        }
    },
    ORGANIZATION(new ArrayList<>(Arrays.asList("OrganizationID", "Name", "Email", "Type","NumberOfAthletes")))
    {
        @Override
        public void filterColumns(String cbVal) {
            
        }
    };


    private ArrayList<String> colNames;

    TableType(ArrayList<String> colNames) {
        this.colNames = colNames;
    }

    public ArrayList<String> colNames() {
        return colNames;
    }

    public abstract void filterColumns(String cbVal);
}
