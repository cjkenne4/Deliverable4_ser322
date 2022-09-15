package deliverable4_ser322;

import java.util.ArrayList;
import java.util.Arrays;


public enum TableType {

    ATHLETE(new ArrayList<>(Arrays.asList("AthleteID", "name", "email","skill","organizationID")), Athlete.class)
    {
        @Override
        public void filterColumns(String cbVal) {
           
        }
    },
    COMPETITION(new ArrayList<>(Arrays.asList("CompetitionID", "Category","DateTime","Rank")), Athlete.class)
    {
        @Override
        public void filterColumns(String cbVal) {

        }
    },
    SPONSOR(new ArrayList<>(Arrays.asList("SponsorID", "Email", "Name")), Athlete.class)
    {
        @Override
        public void filterColumns(String cbVal) {
            
        }
    },
    ORGANIZATION(new ArrayList<>(Arrays.asList("OrganizationID", "Name", "Email", "Type","NumberOfAthletes")), Athlete.class)
    {
        @Override
        public void filterColumns(String cbVal) {
            
        }
    };


    private ArrayList<String> colNames;
    private Class<?> objClass;

    TableType(ArrayList<String> colNames, Class<?> objClass) {
        this.colNames = colNames;
        this.objClass = objClass;
    }

    public ArrayList<String> colNames() {
        return colNames;
    }

    public Class<?> objClass() {
        return objClass;
    }

    public abstract void filterColumns(String cbVal);
}
