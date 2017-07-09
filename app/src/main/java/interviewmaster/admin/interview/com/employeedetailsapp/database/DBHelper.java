package interviewmaster.admin.interview.com.employeedetailsapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interviewmaster.admin.interview.com.employeedetailsapp.model.Employee;
import interviewmaster.admin.interview.com.employeedetailsapp.model.Example;
import interviewmaster.admin.interview.com.employeedetailsapp.model.Skill;



public class DBHelper extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String DB_NAME = "employee.dp";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBVari.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }


   public void addemployee(List<Example> list) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        List<Employee> employees;
        for (int i = 0; i < list.size(); i++) {
            employees = list.get(i).getEmployee();

            for (int j = 0; j < employees.size(); j++) {
                Employee employee = employees.get(j);
                values.put(DBVari.ID, employees.get(j).getId());
                values.put(DBVari.FIRSTNAME, employee.getFirstName());
                values.put(DBVari.LASTNAME, employee.getLastName());
                values.put(DBVari.ADDRESS, employee.getAddress());
                values.put(DBVari.CITY, employee.getCity());
                values.put(DBVari.ZIPCODE, employee.getZipcode());
                values.put(DBVari.GENDER, employee.getGender());
                values.put(DBVari.DOB, employee.getDob());
                values.put(DBVari.DESIGNATION, employee.getDesignation());
                values.put(DBVari.MOBILE, employee.getMobile());
                values.put(DBVari.EMAIL, employee.getEmail());
                values.put(DBVari.NATIONALITY, employee.getNationality());
                values.put(DBVari.LANGUAGE, employee.getLanguage());
                values.put(DBVari.IMAGEURL, employee.getImageURL());
                values.put(DBVari.TECHNICALSKILL, employee.getSkills().get(0).getTechnical().toString().replace("[", "").replace("]", ""));
                values.put(DBVari.EXTRACURRICULAR, employee.getSkills().get(0).getExtraCurricular().toString().replace("[", "").replace("]", ""));

            }
        }
        database.insertWithOnConflict(DBVari.TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        database.close();
    }

    public List<Example> getemployee() {
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT*FROM" + DBVari.TABLE_NAME;
        List<Example> exampleList = null;
        List<Employee> employeeList = null;
        List<Skill> skills = new ArrayList<>();
        try {
            Cursor cursor = database.rawQuery(query, null);
            if (!cursor.isLast()) {
                employeeList = new ArrayList<Employee>();
                exampleList = new ArrayList<Example>();

                while (cursor.moveToFirst()) {
                    Employee item = new Employee();
                    item.setId(cursor.getString(cursor.getColumnIndex(DBVari.ID)));
                    item.setFirstName(cursor.getString(cursor.getColumnIndex(DBVari.FIRSTNAME)));
                    item.setLastName(cursor.getString(cursor.getColumnIndex(DBVari.LASTNAME)));
                    item.setImageURL(cursor.getString(cursor.getColumnIndex(DBVari.IMAGEURL)));
                    item.setAddress(cursor.getString(cursor.getColumnIndex(DBVari.ADDRESS)));
                    item.setCity(cursor.getString(cursor.getColumnIndex(DBVari.CITY)));
                    item.setZipcode(cursor.getString(cursor.getColumnIndex(DBVari.ZIPCODE)));
                    item.setGender(cursor.getString(cursor.getColumnIndex(DBVari.GENDER)));
                    item.setDob(cursor.getString(cursor.getColumnIndex(DBVari.DOB)));
                    item.setMobile(cursor.getString(cursor.getColumnIndex(DBVari.MOBILE)));
                    item.setEmail(cursor.getString(cursor.getColumnIndex(DBVari.EMAIL)));
                    item.setNationality(cursor.getString(cursor.getColumnIndex(DBVari.NATIONALITY)));
                    item.setLanguage(cursor.getString(cursor.getColumnIndex(DBVari.LANGUAGE)));
                    Skill skill = new Skill();
                    skill.setTechnical(Arrays.asList(cursor.getString(cursor.getColumnIndex(DBVari.TECHNICALSKILL)).split(",")));
                    skill.setExtraCurricular(Arrays.asList(cursor.getString(cursor.getColumnIndex(DBVari.EXTRACURRICULAR)).split(",")));
                    skills.add(skill);
                    item.setSkills(skills);
                    employeeList.add(item);
                }
                while (cursor.moveToNext()) ;

                Example example = new Example();
                example.setEmployee(employeeList);
                if (exampleList != null) {
                    exampleList.add(example);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.close();
        }

        return exampleList;
    }
}
