package com.example.android.miwok;

public class Word {

    //String variable for miwok translation of a word
    private String mMiwokTranslation;

    //String variable for default translation of a word
    private String mDefaultTranslation;

    private int NO_IMAGE_PROVIDED = -1;

    //Integer variable for storing image resource id
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    //Integer variable for storing sound resource id
    private int mSoundResourceID;

    //Construct a new Word with initial values for Miwok word and default word.
    public  Word(String miwokWord, String defaultWord, int soundResourceID){
        mMiwokTranslation = miwokWord;
        mDefaultTranslation = defaultWord;
        mSoundResourceID = soundResourceID;
    }

    //Construct a new Word with initial values for Miwok and default words and corresponding image.
    public Word(String miwokWord, String defaultWord, int imageResourceID, int soundResourceID){
        mMiwokTranslation = miwokWord;
        mDefaultTranslation = defaultWord;
        mImageResourceID = imageResourceID;
        mSoundResourceID = soundResourceID;
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
    //returns true if view has image
    public boolean hasImage(){
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }

    //Get the sound resource id
    public int getSoundResourceID(){
        return mSoundResourceID;
    }
}
