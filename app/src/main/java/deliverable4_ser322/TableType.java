package deliverable4_ser322;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;


public enum TableType {

    ATHLETE(new ArrayList<>(Arrays.asList("athleteID", "name", "email","organizationID")), Athlete.class)
    {
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
        @Override
        public Athlete getRowObject(Object row) {    
            return (Athlete) row;
        }
        @Override
        public void setRowObject(Object row, Object[] values) 
        {
            ((Athlete) row).setAthleteID(Integer.valueOf((String) values[0]));
            ((Athlete) row).setName((String) values[1]);
            ((Athlete) row).setEmail((String) values[2]);
            ((Athlete) row).setOrganizationID(Integer.valueOf((String) values[3]));
        }
        @Override
        public Athlete insertRow(Object[] values) {
            Athlete nAthlete = new Athlete();
            setRowObject(nAthlete, values);
            return nAthlete;
        }
    },
    COMPETITION(new ArrayList<>(Arrays.asList("competitionID", "category","datetime")), Competition.class)
    {
        @Override
        public Competition newDbObject(ResultSet rs) throws SQLException 
        {
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++)
                args[i] = rs.getObject(colNames().get(i));

            return new Competition(args);
        }
        @Override
        public Competition getRowObject(Object row) {
            return (Competition) row;
        }
        @Override
        public void setRowObject(Object row, Object[] values) {
            ((Competition) row).setCompetitionID(Integer.valueOf((String) values[0]));
            ((Competition) row).setCategory((String) values[1]);
            ((Competition) row).setDatetime(LocalDateTime.parse((String) values[2]));
        }
        @Override
        public Competition insertRow(Object[] values) {
            Competition nComp = new Competition();
            setRowObject(nComp, values);
            return nComp;
        }
    },
    SPONSOR(new ArrayList<>(Arrays.asList("SponsorID", "Email", "Name")), Sponsor.class)
    {
        @Override
        public Object newDbObject(ResultSet rs) throws SQLException 
        {
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++)
                args[i] = rs.getObject(colNames().get(i));

            return new Sponsor(args);
        }
        @Override
        public Sponsor getRowObject(Object row) {
            return (Sponsor) row;
        }
        @Override
        public void setRowObject(Object row, Object[] values) {
            ((Sponsor) row).setSponsorID(Integer.valueOf((String) values[0]));
            ((Sponsor) row).setName((String) values[1]);
            ((Sponsor) row).setEmail((String) values[2]);
        }
        @Override
        public Sponsor insertRow(Object[] values) {
            Sponsor nSponsor = new Sponsor();
            setRowObject(nSponsor, values);
            return nSponsor;
        }
    },
    ORGANIZATION(new ArrayList<>(Arrays.asList("organizationID", "name", "email", "type")), Organization.class)
    {
        @Override
        public Organization newDbObject(ResultSet rs) throws SQLException {
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++)
                args[i] = rs.getObject(colNames().get(i));

            return new Organization(args);
        }
        @Override
        public Organization getRowObject(Object row) {
            return (Organization) row;
        }
        @Override
        public void setRowObject(Object row, Object[] values) {
            ((Organization) row).setOrganizationID(Integer.valueOf((String) values[0]));
            ((Organization) row).setName((String) values[1]);
            ((Organization) row).setEmail((String) values[2]);
            ((Organization) row).setType((String) values[3]);
        }
        @Override
        public Organization insertRow(Object[] values) {
            Organization nOrg = new Organization();
            setRowObject(nOrg, values);
            return nOrg;
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
        public CompetitionSponsor getRowObject(Object row) {
            return (CompetitionSponsor) row;
        }
        @Override
        public void setRowObject(Object row, Object[] values) {
            ((CompetitionSponsor) row).setCompetitionID(Integer.valueOf((String) values[0]));
            ((CompetitionSponsor) row).setSponsorID(Integer.valueOf((String) values[1]));
            ((CompetitionSponsor) row).setPrize((String) values[2]);
        }
        @Override
        public CompetitionSponsor insertRow(Object[] values) {
            CompetitionSponsor nCompSponsor = new CompetitionSponsor();
            setRowObject(nCompSponsor, values);
            return nCompSponsor;
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
        public AthleteStats getRowObject(Object row) {
            return (AthleteStats) row;
        }
        @Override
        public void setRowObject(Object row, Object[] values) {
            ((AthleteStats) row).setAthleteID(Integer.valueOf((String) values[0]));
            ((AthleteStats) row).setCompetitionID(Integer.valueOf((String) values[1]));
            ((AthleteStats) row).setWinningStatistics((String) values[2]);
            ((AthleteStats) row).setPlacement(Integer.valueOf((String) values[3]));
        }
        @Override
        public AthleteStats insertRow(Object[] values) {
            AthleteStats nAthStat = new AthleteStats();
            setRowObject(nAthStat, values);
            return nAthStat;
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

    public Method getMethod(String name) throws NoSuchMethodException, SecurityException{
        Method method = objClass().getMethod("get" + name.substring(0,1).toUpperCase() + name.substring(1));
        return method;
    }
    public Object[] getValues(Object o){
        Object[] values = new Object[colNames().size()];
        for(int i = 0; i < colNames().size(); i++){
            try {
                Method method = getMethod(colNames().get(i));
                values[i] = method.invoke(o);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return values;
    }
    
    public abstract <T> T newDbObject(ResultSet rs) throws SQLException;
    public abstract <T> T getRowObject(Object row);
    public abstract void setRowObject(Object row, Object[] values);
    public abstract <T> T insertRow(Object[] values);
}
