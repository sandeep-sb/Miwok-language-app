package com.example.android.miwok;

public class Word {

    //String variable for miwok translation of a word
    private String mMiwokTranslation;

    //String variable for default translation of a word
    private String mDefaultTranslation;

    //Construct a new Word with initial values for Miwok word and default word.
    public  Word(String miwokWord, String defaultWord){
        mMiwokTranslation = miwokWord;
        mDefaultTranslation = defaultWord;
    }

    //Get the default translation of the word
    public  String getDefaultWord(){

        return mDefaultTranslation;
    }

    //Get the miwok translation of the word
    public  String getMiwoktWord(){
        return mMiwokTranslation;
    }
}
