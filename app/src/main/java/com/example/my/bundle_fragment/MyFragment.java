package com.example.my.bundle_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by grd on 1/9/17.
 */

// вылетвет на  Caused by: java.lang.IllegalArgumentException: Must be created through newInstance(...)
// at com.my_research_app.grd.fragmet_bundle.MyFragment.onCreate(MyFragment.java:49)
public class MyFragment extends Fragment {

    final static String LOG_TAG="myLog";

        private static final String BUNDLE_CONTENT = "bundle_content";

  //  Java.lang.Class.newInstance () создает новый экземпляр класса, представленного этим объектом класса.
  // Экземпляры класса создаются как бы новое выражение с пустым списком аргументов.
  // Класс инициализируется, если он еще не был инициализирован. ,
        public static MyFragment newInstance(final String content) {


        final MyFragment fragment = new MyFragment();
        final Bundle arguments = new Bundle();
                 arguments.putString(BUNDLE_CONTENT, content);
                 fragment.setArguments(arguments);

                return fragment;
        }

       private String content;

       public MyFragment() {
        //default constructor
        }

       //В onCreate() мы прочитаем переданный Bundle
        @Override
        public void onCreate(Bundle saveInstanceState) {
          if (getArguments() != null && getArguments().containsKey(BUNDLE_CONTENT)) {
               content = getArguments().getString(BUNDLE_CONTENT);
          }
          else {
               throw new IllegalArgumentException("Must be created through newInstance(...)");
              }


          }
       // ...

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        String strtext = getArguments().getString(BUNDLE_CONTENT);

        Log.d(LOG_TAG,  "My Bundle contain "+ strtext);

        return inflater.inflate(R.layout.fragment1, container, false);


    }


}