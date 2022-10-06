package deliverable4_ser322;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import deliverable4_ser322.table.*;
/**
 * Enum for mapping database tables to a Table of the specified TableType class
 */
@SuppressWarnings("unchecked")
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
    SPONSOR(new ArrayList<>(Arrays.asList("sponsorID", "name", "email")), Sponsor.class)
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
    },
    COMPETITION_INFO(new ArrayList<>(Arrays.asList("name", "category", "placement", "winningStatistics")), CompetitionInfo.class)
    {
        @Override
        public CompetitionInfo newDbObject(ResultSet rs) throws SQLException {
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++)
                args[i] = rs.getObject(colNames().get(i));

            return new CompetitionInfo(args);
        }
        @Override
        public CompetitionInfo getRowObject(Object row) {
            return (CompetitionInfo) row;
        }
        @Override
        public void setRowObject(Object row, Object[] values) {
            ((CompetitionInfo) row).setName(((String) values[0]));
            ((CompetitionInfo) row).setCategory((String) values[1]);
            ((CompetitionInfo) row).setPlacement(Integer.valueOf((String) values[2]));
            ((CompetitionInfo) row).setWinningStatistics((String) values[3]);
        }
        @Override
        public CompetitionInfo insertRow(Object[] values) {
        	CompetitionInfo nCompInfo = new CompetitionInfo();
            setRowObject(nCompInfo, values);
            return nCompInfo;
        } 
    },
    SPONSORS_SPONSORED(new ArrayList<>(Arrays.asList("sponsorID", "name", "competitionID", "prize", "datetime")), SponsorsSponsored.class)
    {
        @Override
        public SponsorsSponsored newDbObject(ResultSet rs) throws SQLException {
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++)
                args[i] = rs.getObject(colNames().get(i));

            return new SponsorsSponsored(args);
        }
        @Override
        public SponsorsSponsored getRowObject(Object row) {
            return (SponsorsSponsored) row;
        }
        @Override
        public void setRowObject(Object row, Object[] values) {
            ((SponsorsSponsored) row).setSponsorID(Integer.valueOf((String) values[0]));
        	((SponsorsSponsored) row).setName(((String) values[1]));
            ((SponsorsSponsored) row).setCompetitionID(Integer.valueOf((String) values[2]));
            ((SponsorsSponsored) row).setPrize((String) values[3]);
            ((SponsorsSponsored) row).setDatetime(LocalDateTime.parse((String) values[4]));
        }
        @Override
        public SponsorsSponsored insertRow(Object[] values) {
        	SponsorsSponsored nSponSpon = new SponsorsSponsored();
            setRowObject(nSponSpon, values);
            return nSponSpon;
        } 
    },
    CATEGORIES_WON(new ArrayList<>(Arrays.asList("name", "category")), CategoriesWon.class)
    {
        @Override
        public CategoriesWon newDbObject(ResultSet rs) throws SQLException {
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++)
                args[i] = rs.getObject(colNames().get(i));

            return new CategoriesWon(args);
        }
        @Override
        public CategoriesWon getRowObject(Object row) {
            return (CategoriesWon) row;
        }
        @Override
        public void setRowObject(Object row, Object[] values) {
            ((CategoriesWon) row).setName(((String) values[0]));
            ((CategoriesWon) row).setCategory(((String) values[1]));
        }
        @Override
        public CategoriesWon insertRow(Object[] values) {
        	CategoriesWon nCatWon = new CategoriesWon();
            setRowObject(nCatWon, values);
            return nCatWon;
        } 
    },
    PLACEMENT_NUMBER(new ArrayList<>(Arrays.asList("name", "placement")), PlacementNumber.class)
    {
        @Override
        public PlacementNumber newDbObject(ResultSet rs) throws SQLException {
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++)
                args[i] = rs.getObject(colNames().get(i));

            return new PlacementNumber(args);
        }
        @Override
        public PlacementNumber getRowObject(Object row) {
            return (PlacementNumber) row;
        }
        @Override
        public void setRowObject(Object row, Object[] values) {
            ((PlacementNumber) row).setName(((String) values[0]));
            ((PlacementNumber) row).setPlacement(Integer.valueOf((String) values[1]));
        }
        @Override
        public PlacementNumber insertRow(Object[] values) {
        	PlacementNumber nPlaceNum = new PlacementNumber();
            setRowObject(nPlaceNum, values);
            return nPlaceNum;
        } 
    },
    UNRANKED_ATHLETES(new ArrayList<>(Arrays.asList("name")), UnrankedAthletes.class)
    {
        @Override
        public UnrankedAthletes newDbObject(ResultSet rs) throws SQLException {
            Object[] args = new Object[colNames().size()];
            for(int i = 0; i < args.length; i++)
                args[i] = rs.getObject(colNames().get(i));

            return new UnrankedAthletes(args);
        }
        @Override
        public UnrankedAthletes getRowObject(Object row) {
            return (UnrankedAthletes) row;
        }
        @Override
        public void setRowObject(Object row, Object[] values) {
            ((UnrankedAthletes) row).setName(((String) values[0]));
        }
        @Override
        public UnrankedAthletes insertRow(Object[] values) {
        	UnrankedAthletes nUnAth = new UnrankedAthletes();
            setRowObject(nUnAth, values);
            return nUnAth;
        } 
    },
    /**
     * TableType for displaying join queries in the TableView.
     * colNames is updated during runtime using ResultSetMetaData
     * @see RowObject
     */
    RESULT_SET(RowObject.colNames, RowObject.class)
    {
        @Override
        public RowObject newDbObject(ResultSet rs) throws SQLException {
            RowObject rowObj = new RowObject(rs);
            //setColNames(rowObj.getColumnNames());
            return rowObj;
        }

        @Override
        public RowObject getRowObject(Object row) {
            return (RowObject) row;
        }

        @Override
        public void setRowObject(Object row, Object[] values) {
            ((RowObject) row).setValues(values);    
        }
        @Override
        public RowObject insertRow(Object[] values) {
            RowObject rowObj = new RowObject();
            setRowObject(rowObj, values);
            return rowObj;
        }
        
    };

    private ArrayList<String> colNames;
    private Class<?> objClass;
    /**
     * TableType enums have a hardcoded arraylist of column names
     * and a Class<?> object for the corresponding java class.
     * 
     * @param colNames
     * @param objClass
     */
    TableType(ArrayList<String> colNames, Class<?> objClass) {
        this.colNames = colNames;
        this.objClass = objClass;
    }

    public ArrayList<String> colNames() {
        if(objClass().equals(RowObject.class))
            return RowObject.colNames;
        else
            return colNames;
    }

    public Class<?> objClass() {
        return objClass;
    }
    public void setColNames(ArrayList<String> colNames){
        this.colNames = colNames;
    }
    /**
     * Gets the getter method for the corresponding TableType java class and attribute name.
     * @param name
     * @return
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    public Method getMethod(String name) throws NoSuchMethodException, SecurityException{
        Method method = objClass().getMethod("get" + name.substring(0,1).toUpperCase() + name.substring(1));
        return method;
    }
    /**
     * Invokes the getter methods for TableType
     * @param o
     * @return
     */
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
    //not used
    public Object instantiate(ResultSet rs) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
        Object[] args = getArgs(rs);
        Class<?> clazz = objClass();
        return clazz.getDeclaredConstructor().newInstance(args);
    }
    //not used
    public Object[] getArgs(ResultSet rs) throws SQLException{
        Object[] args = new Object[colNames().size()];
        for(int i = 0; i < args.length; i++)
            args[i] = rs.getObject(colNames().get(i));
        return args;
    }
    /**
     * Creates a new object for the corresponding table class
     * using a ResultSet to get row values.
     * @param <T>
     * @param rs
     * @return
     * @throws SQLException
     */
    public abstract <T> T newDbObject(ResultSet rs) throws SQLException;
    /**
     * Casts a TableView row to its corresponding class.
     * @param <T>
     * @param row
     * @return
     */
    public abstract <T> T getRowObject(Object row);
    /**
     * Sets a rows value after a table is updated in the database.
     * @param row
     * @param values
     */
    public abstract void setRowObject(Object row, Object[] values);
    /**
     * Adds a new row to the TableView after a inserting a new row in the database.
     * @param <T>
     * @param values
     * @return
     */
    public abstract <T> T insertRow(Object[] values);
}
