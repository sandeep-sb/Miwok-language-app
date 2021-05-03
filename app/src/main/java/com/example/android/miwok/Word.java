package com.example.android.miwok;

public class Word {

    //String variable for miwok translation of a word
    private String mMiwokTranslation;

    //String variable for default translation of a word
    private String mDefaultTranslation;

    //Integer variable for storing image resource id
    private int mImageResourceID;

    //Construct a new Word with initial values for Miwok word and default word.
    public  Word(String miwokWord, String defaultWord){
        mMiwokTranslation = miwokWord;
        mDefaultTranslation = defaultWord;
    }

    //Construct a new Word with initial values for Miwok and default words and corresponding image.
    public Word(String miwokWord, String defaultWord, int imageResourceID){
        mMiwokTranslation = miwokWord;
        mDefaultTranslation = defaultWord;
        mImageResourceID = imageResourceID;
    }

    //Get the default translation of the word
    public  String getDefaultWord(){

        return mDefaultTranslation;
    }

    //Get the miwok translation of the word
    public  String getMiwokWord(){
        return mMiwokTranslation;
    }

    //Get the image resource id
    public int getImageResourceID(){

        return mImageResourceID;
    }
}
