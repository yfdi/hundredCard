package com.example.diyanfang.hundredcard;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionViewHolder extends RecyclerView.ViewHolder {

    public CardView cardView;
    public TextView questionCountry;
    public TextView countryQuestion;
    public ImageView countryImage;
    public boolean isAnswerTrue;

    public  QuestionViewHolder(View itemView, final Context context){
        super(itemView);
        cardView = (CardView)itemView.findViewById(R.id.card_view);
        questionCountry = (TextView)itemView.findViewById(R.id.question_country);
        countryQuestion = (TextView)itemView.findViewById(R.id.country_question);
        countryImage = (ImageView)itemView.findViewById(R.id.country_image);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //Toast.makeText(context, questionCountry.getText(),Toast.LENGTH_SHORT).show();
                int messageId = 0;
                //show the correct answer
                if(isAnswerTrue){
                    messageId = R.string.true_button;
                }else{
                    messageId = R.string.false_button;
                }
                Toast.makeText(context,messageId,Toast.LENGTH_SHORT).show();
            }
        });
    }


}
