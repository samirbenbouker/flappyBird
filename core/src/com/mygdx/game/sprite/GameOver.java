package com.mygdx.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.PlayState;
import com.mygdx.game.states.State;

public class GameOver extends State {

    private Texture gameOver;
    private Texture background;
    private Texture playBtn;

    protected GameOver(GameStateManager gsm) {
        super(gsm);

        gameOver = new Texture("gameover.png");
        playBtn = new Texture("playbtn.png");
        background = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        sb.draw(playBtn, (MyGdxGame.WIDTH / 2) - (playBtn.getWidth() / 2), MyGdxGame.HEIGHT / 2);
        sb.draw(gameOver, (MyGdxGame.WIDTH / 2) - (playBtn.getWidth() / 2), MyGdxGame.HEIGHT / 2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        gameOver.dispose();
    }
}
