package com.poonamsk.newhr;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.technoride.erp.api.entity.Member;

import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the  activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentAdapter adapter = new SimpleFragmentAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    private com.technoride.erp.api.entity.Member buildMember() {
        Member m = new Member();
        EditText firstname=(EditText)findViewById(R.id.firstName);
        m.setFirstName(firstname.getText().toString());
        EditText middlename=(EditText)findViewById(R.id.middleName);
        m.setMiddleName(middlename.getText().toString());
        EditText lastname=findViewById(R.id.lastName);
        m.setLastName(lastname.getText().toString());
        EditText fatherfirstname=(EditText)findViewById(R.id.fatherfirsttName);
        m.setFatherFirstName(String.valueOf(fatherfirstname));
        EditText fathermiddlename=(EditText)findViewById(R.id.fathermiddleName);
        m.setFatherMiddleName(String.valueOf(fathermiddlename));
        EditText fatherlastname=(EditText)findViewById(R.id.fatherlastName);
        m.setFatherLastName(String.valueOf(fatherlastname));
        EditText motherfirstname =(EditText)findViewById(R.id.motherName);
        m.setMotherFirstName(String.valueOf(motherfirstname));
        EditText mothermiddlename=(EditText)findViewById(R.id.mothermiddleName);
        m.setMotherMiddleName(String.valueOf(mothermiddlename));
        EditText motherlasstname=(EditText)findViewById(R.id.motherlastName);
        m.setMotherLastName(String.valueOf(motherlasstname));
        EditText dateofbirth=(EditText) findViewById(R.id.dateofBirth);
       /* String datevalue = dateofbirth.getText().toString();
        DateFormat format = new SimpleDateFormat("dd, mm, yyyy", Locale.ENGLISH);
        try {
            Date date = format.parse(datevalue);
            m.setDateOfBirth(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        EditText aadharcard=(EditText)findViewById(R.id.aadhar);
        m.setAadharNumber(aadharcard.getText().toString());
        EditText pannumber=(EditText)findViewById(R.id.pan);
        m.setPanNumber(pannumber.getText().toString());
        EditText city=(EditText)findViewById(R.id.city);
        m.setCity(city.getText().toString());
        EditText state=(EditText)findViewById(R.id.state);
        m.setState(state.getText().toString());
        EditText distict=(EditText)findViewById(R.id.distinct);
        m.setDistrict(distict.getText().toString());
        EditText drivinglicence=(EditText)findViewById(R.id.drivingLicense);
        m.setDrivingLicenceNumber(drivinglicence.getText().toString());
       // EditText branch=(EditText)findViewById(R.id.branch);
        //m.setBranch(branch.getText().toString());
        EditText maritalstatus=(EditText)findViewById(R.id.maritalStatus);
        m.setMaritalStatus(maritalstatus.getText().toString());
        EditText mobile=(EditText)findViewById(R.id.mobile);
        m.setMobileNumber(mobile.getText().toString());
       // EditText role=(EditText)findViewById(R.id.role);
        //m.setRole(role.getText().toString());
        EditText housenumber=(EditText)findViewById(R.id.houseNo);
        m.setHouseNumber(housenumber.getText().toString());
        EditText streetname=(EditText)findViewById(R.id.streetName);
        m.setStreetName(String.valueOf(streetname));
        EditText companyname=(EditText)findViewById(R.id.companyName);
        m.setCompanyName(String.valueOf(companyname));
        EditText designation=(EditText)findViewById(R.id.designation);
        m.setDesignation(String.valueOf(designation));
        EditText username=(EditText)findViewById(R.id.username);
        m.setUserName(String.valueOf(username));
        EditText pinnumber=(EditText)findViewById(R.id.pinNo_);
        m.setPinNumber(String.valueOf(pinnumber));
        EditText password=(EditText)findViewById(R.id.password);
        m.setPassword(String.valueOf(password));
        return m;
    }

    public void Submit(View view) {
        Member member=buildMember();
        member.setDateOfBirth(new Date());
        MemberAddAsyncTask addAsyncTask=new MemberAddAsyncTask();
        addAsyncTask.execute(member);

    }
}
