package com.lessons_book.belkin.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Belkin on 01.04.2015.
 */
public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE = "com.lessons_book.belkin.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOW = "com.lessons_book.belkin.geoquiz.answer_show";
    private static final String KEY_IS_CHEATER = "is_cheat";

    private boolean mAnswerisTrue;
    private Button mShowAnswer;
    private TextView mAnswerTextView;
    private boolean mIsCheater;

    private void setAnswerTextView(){
        if(mAnswerisTrue){
            mAnswerTextView.setText(R.string.true_button);
        }else{
            mAnswerTextView.setText(R.string.false_button);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(KEY_IS_CHEATER, mIsCheater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        if(savedInstanceState != null){
            mIsCheater = savedInstanceState.getBoolean(KEY_IS_CHEATER, false);
        }

        setAnswerShowResult(mIsCheater);

        mAnswerisTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
        if(mIsCheater){
            setAnswerTextView();
        }

        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnswerTextView();
                mIsCheater = true;
                setAnswerShowResult(mIsCheater);
            }
        });
    }

    private void setAnswerShowResult(boolean isAnswerShow){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOW, isAnswerShow);
        setResult(RESULT_OK, data);
    }
}
