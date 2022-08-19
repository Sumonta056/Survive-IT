package Intro;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.SoundManager;
import game.AirWaterScreen;

public class IntroScreen1 implements Screen {

    MyGdxGame game;
    Texture background1;

    // sound starts
    public boolean soundState;
    public boolean showMute;
    Texture mute ;
    // sound ends

    public IntroScreen1(MyGdxGame game,boolean soundState) {

        this.game = game;
        this.soundState = soundState;

        SoundManager.create();
        SoundManager.intro.setLooping(true);
        SoundManager.intro.setVolume(0.2f);     // 50% of main volume
        if(soundState)
        {
            SoundManager.intro.play();
            showMute = false;
        }
        else showMute = true;
    }


    @Override
    public void show() {

        background1 = new Texture("Intro\\1.png");
        mute = new Texture("Audio\\mute.png") ;

    }

    @Override
    public void render(float delta) {

        //ScreenUtils.clear(1, 1, 1, 1);

        if (Gdx.input.getX() >= 1430 && Gdx.input.getX() <= 1630 &&
                MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() >= 50
                && MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() <= 117) {
            if (Gdx.input.justTouched()) {
                this.dispose();
                SoundManager.intro.dispose();
                SoundManager.click.play();
                game.setScreen(new AirWaterScreen(game,soundState));
            }
        }

        if (Gdx.input.getX() >= 1544 && Gdx.input.getX() <= 1666 &&
                MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() >= 423
                && MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() <= 558) {
            if (Gdx.input.justTouched()) {
                this.dispose();
                SoundManager.click.play();
                game.setScreen(new IntroScreen2(game,soundState));
            }
        }

        game.batch.begin();

        game.batch.draw(background1,0,0);
        if(showMute) game.batch.draw(mute, 1580, 830,100,100);
        game.batch.end();

    }


    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        SoundManager.click.dispose();
    }
}