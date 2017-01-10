package com.example.my.bundle_fragment;

import android.app.Activity;
import android.os.Bundle;


// вылетает  setContentView(R.layout.activity_main);   из за макета с статическим фрагментом
public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
          MyFragment fragment = MyFragment.newInstance("My data from Activity ");


    }
}
