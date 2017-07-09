package interviewmaster.admin.interview.com.employeedetailsapp.database;



public class DBVari {
    public static final String ID = "id";
    public static final String TABLE_NAME = "employeedata";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String ADDRESS = "address";
    public static final String CITY = "city";
    public static final String ZIPCODE = "zipcode";
    public static final String GENDER = "gender";
    public static final String DOB = "dob";
    public static final String DESIGNATION = "designation";
    public static final String MOBILE = "mobile";
    public static final String EMAIL = "email";
    public static final String NATIONALITY = "nationality";
    public static final String LANGUAGE = "languge";
    public static final String IMAGEURL = "imageurl";
    public static final String TECHNICALSKILL = "technicalskill";
    public static final String EXTRACURRICULAR = "extracurricular";


    static String CREATE_TABLE = " create table if not exists " + TABLE_NAME +
            "(" + FIRSTNAME + "TEXT, " +
            LASTNAME + "TEXT, " +
            ADDRESS + "TEXT, " +
            CITY + "TEXT, " +
            ZIPCODE + "TEXT, " +
            GENDER + "TEXT, " +
            DOB + "TEXT," +
            DESIGNATION + "TEXT," +
            MOBILE + "TEXT" +
            EMAIL + "TEXT, " +
            NATIONALITY + "TEXT," +
            LANGUAGE + "TEXT," +
            IMAGEURL + "TEXT," +
            TECHNICALSKILL + "TEXT," +
            EXTRACURRICULAR + "TEXT" + ")";

}

