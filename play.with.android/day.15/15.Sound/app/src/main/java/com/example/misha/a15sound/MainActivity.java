package com.example.misha.a15sound;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private AssetManager assetManager;
    private int catSound, chickenSound, cowSound, duckSound, sheepSound, dogSound;
    private int streamID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton cowImageButton = (ImageButton) findViewById(R.id.imageButtonCow);
        ImageButton catImageButton = (ImageButton) findViewById(R.id.imageButtonCat);
        ImageButton chickenImageButton = (ImageButton) findViewById(R.id.imageButtonChicken);
        ImageButton dogImageButton = (ImageButton) findViewById(R.id.imageButtonDog);
        ImageButton duckImageButton = (ImageButton) findViewById(R.id.imageButtonDuck);
        ImageButton sheepImageButton = (ImageButton) findViewById(R.id.imageButtonSheep);

        cowImageButton.setOnClickListener(onClickListener);
        catImageButton.setOnClickListener(onClickListener);
        chickenImageButton.setOnClickListener(onClickListener);
        dogImageButton.setOnClickListener(onClickListener);
        duckImageButton.setOnClickListener(onClickListener);
        sheepImageButton.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imageButtonCat:
                    playSound(catSound);
                    break;
                case R.id.imageButtonCow:
                    playSound(cowSound);
                    break;
                case R.id.imageButtonChicken:
                    playSound(chickenSound);
                    break;
                case R.id.imageButtonDog:
                    playSound(dogSound);
                    break;
                case R.id.imageButtonDuck:
                    playSound(duckSound);
                    break;
                case R.id.imageButtonSheep:
                    playSound(sheepSound);
                    break;
            }
        }
    };

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void createNewSoundPool (){
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }

    private int playSound(int sound){
        if(sound > 0){
            streamID = soundPool.play(sound, 1,1,1,0,1);
        }
        return streamID;
    }

    private int loadSound(String fileName){
        AssetFileDescriptor afd;
        try {
            afd = assetManager.openFd(fileName);
        }catch (IOException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Cannot load file " + fileName, Toast.LENGTH_SHORT).show();
            return -1;
        }
        return soundPool.load(afd, 1);
    }

    @Override
    protected void onResume(){
        super.onResume();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            createNewSoundPool();
        }else{
            //for the old versions
            //createOldSoundPool();
        }

        assetManager = getAssets();

        catSound = loadSound("cat.ogg");
        chickenSound = loadSound("chicken.ogg");
        cowSound = loadSound("cow.ogg");
        duckSound = loadSound("duck.ogg");
        sheepSound = loadSound("sheep.ogg");
        dogSound = loadSound("dog.ogg");
    }

    @Override
    protected void onPause(){
        super.onPause();

        soundPool.release();
        soundPool = null;
    }

}
