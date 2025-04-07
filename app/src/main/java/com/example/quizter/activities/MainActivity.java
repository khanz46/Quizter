package com.example.quizter.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.quizter.R;
import com.example.quizter.adapters.QuizAdapter;
import com.example.quizter.models.Quiz;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MaterialToolbar appbar;
    ActionBarDrawerToggle action_toggle;
    DrawerLayout drawer;
    RecyclerView recyclerView;
    ArrayList<Quiz> quiz_data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = findViewById(R.id.mainDrawer);
        appbar = findViewById(R.id.UpperAppBar);
        recyclerView = findViewById(R.id.quizterRecyclerView);
        populateDummyData();
        setUpViews();

    }

    // Populating Dummy data
    public void populateDummyData(){
        quiz_data.add(new Quiz("10/08/2022","10/08/2022"));
        quiz_data.add(new Quiz("14/08/2022","14/08/2022"));
        quiz_data.add(new Quiz("18/08/2022","18/08/2022"));
        quiz_data.add(new Quiz("22/08/2022","22/08/2022"));
        quiz_data.add(new Quiz("26/08/2022","26/08/2022"));
        quiz_data.add(new Quiz("30/08/2022","30/08/2022"));

    }

    public void setUpViews() {
        // First View
        setUpDrawerLayout();
        // second view
        setUpRecycler();
        //

    }

    public void setUpRecycler(){
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(new QuizAdapter(this,quiz_data));
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void setUpDrawerLayout() {
        setSupportActionBar(appbar);

        // Adding 'Toggle'
        action_toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, R.string.app_name, R.string.app_name);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        action_toggle.onOptionsItemSelected(item);
        return true;
    }
}