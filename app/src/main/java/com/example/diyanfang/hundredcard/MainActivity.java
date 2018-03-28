package com.example.diyanfang.hundredcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Question> questions;
    private QuestionsAdapter questionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialData();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        //true if adapter changes cannot affect the size of the RecyclerView.
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        questionsAdapter = new QuestionsAdapter(questions, this);
        recyclerView.setAdapter(questionsAdapter);

    }

    private void initialData(){
        questions = new ArrayList<>();
        questions.add(new Question(R.string.australia,R.string.question_australia,R.drawable.australia, true));
        questions.add(new Question(R.string.africa,R.string.question_africa,R.drawable.africa, true));
        questions.add(new Question(R.string.asia,R.string.question_asia,R.drawable.asia, true));
        questions.add(new Question(R.string.middle_east,R.string.question_mideast,R.drawable.mideast, true));
        questions.add(new Question(R.string.oceans,R.string.question_oceans,R.drawable.oceans, true));
        questions.add(new Question(R.string.americas,R.string.question_americas,R.drawable.americas, true));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu)
        getMenuInflater().inflate(R.menu.menu_main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.add:
                questions.add(getRandomQuestion());
                questionsAdapter.notifyDataSetChanged();
                return true;
            case R.id.save:
                Toast.makeText(this, "Saved",Toast.LENGTH_SHORT).show();
            case R.id.share:
                Toast.makeText(this, "Share it baby",Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private Question getRandomQuestion(){
        int num = (int) (Math.random() * 5);
        switch (num){
            case 0:
                return new Question(R.string.australia, R.string.question_australia, R.drawable.australia,true);
            case 1:
                return new Question(R.string.africa,R.string.question_africa,R.drawable.africa, true);
            case 2:
                return new Question(R.string.asia,R.string.question_asia,R.drawable.asia, true);
            case 3:
                return new Question(R.string.middle_east,R.string.question_mideast,R.drawable.mideast, true);
            case 4:
                return new Question(R.string.oceans,R.string.question_oceans,R.drawable.oceans, true);
            default:
                return new Question(R.string.americas,R.string.question_americas,R.drawable.americas, true);
        }
    }



}
