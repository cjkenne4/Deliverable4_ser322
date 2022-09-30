package deliverable4_ser322;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;


public enum TableType {

    ATHLETE(new ArrayList<>(Arrays.asList("athleteID", "name", "email","skill","organizationID")), Athlete.class)
    {
        @Override
        public void filterColumns(String cbVal) {
           
        }
        @Override
        public Athlete newDbObject(ResultSet rs) throws SQLException 
        {    
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++){
                Object obj = rs.getObject(colNames().get(i));
                if(obj != null) args[i] = obj;
                else args[i] = 1;
                
            }
            return new Athlete(args);
        }
    },
    COMPETITION(new ArrayList<>(Arrays.asList("competitionID", "category","datetime","skill")), Competition.class)
    {
        @Override
        public void filterColumns(String cbVal) {

        }
        @Override
        public Competition newDbObject(ResultSet rs) throws SQLException 
        {
            Competition nComp = new Competition();
            nComp.setCompetitionID(rs.getInt("competitionID"));
            nComp.setCategory(rs.getString("category"));
            nComp.setDatetime(LocalDateTime.now());
            nComp.setSkill(rs.getInt("skill"));
            
            return nComp;
        }
    },
    SPONSOR(new ArrayList<>(Arrays.asList("SponsorID", "Email", "Name")), Sponsor.class)
    {
        @Override
        public void filterColumns(String cbVal) {
            
        }
        @Override
        public Object newDbObject(ResultSet rs) throws SQLException 
        {
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++)
                args[i] = rs.getObject(colNames().get(i));

            return new Sponsor(args);
        }
    },
    ORGANIZATION(new ArrayList<>(Arrays.asList("organizationID", "name", "email", "type")), Organization.class)
    {
        @Override
        public void filterColumns(String cbVal) {
            
        }

        @Override
        public Organization newDbObject(ResultSet rs) throws SQLException {
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++)
                args[i] = rs.getObject(colNames().get(i));

            return new Organization(args);
        }
    },
    COMPETITIONS_SPONSORED(new ArrayList<>(Arrays.asList("competitionID", "sponsorID", "prize")), CompetitionSponsor.class)
    {
        @Override
        public CompetitionSponsor newDbObject(ResultSet rs) throws SQLException {
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++)
                args[i] = rs.getObject(colNames().get(i));

            return new CompetitionSponsor(args);
        }
        @Override
        public void filterColumns(String cbVal) {
            
        }
        
    },
    ATHLETE_STATS(new ArrayList<>(Arrays.asList("athleteID", "competitionID", "winningStatistics", "placement")), AthleteStats.class)
    {
        @Override
        public AthleteStats newDbObject(ResultSet rs) throws SQLException {
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++)
                args[i] = rs.getObject(colNames().get(i));

            return new AthleteStats(args);
        }
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
    public abstract <T> T newDbObject(ResultSet rs) throws SQLException;

    public abstract void filterColumns(String cbVal);
}
