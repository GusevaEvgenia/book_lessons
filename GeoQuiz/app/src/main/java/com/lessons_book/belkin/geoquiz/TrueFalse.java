package com.lessons_book.belkin.geoquiz;

/**
 * Created by Belkin on 31.03.2015.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;
    private boolean mIsCheat;

    TrueFalse(int question, boolean trueQuestion){
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }

    public boolean isCheat() {
        return mIsCheat;
    }

    public void setCheat(boolean isCheat) {
        mIsCheat = isCheat;
    }
}
