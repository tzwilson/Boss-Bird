package com.kilobolt.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bossdevelopment.BossBird2.ZBGame;
import com.kilobolt.GameWorld.GameRenderer;
import com.kilobolt.GameWorld.GameWorld;
import com.kilobolt.ZBHelpers.InputHandler;

public class GameScreen implements Screen {

	public static GameWorld world;
	private GameRenderer renderer;
	private float runTime;
	// This is the constructor, not the class declaration
	public GameScreen() {
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameWidth = 136;
		float gameHeight = screenHeight / (screenWidth / gameWidth);
		int midPointY = (int) (gameHeight / 2);

		world = new GameWorld(midPointY);
		Gdx.input.setInputProcessor(new InputHandler(world, screenWidth
				/ gameWidth, screenHeight / gameHeight));
		renderer = new GameRenderer(world, (int) gameHeight, midPointY);
		world.setRenderer(renderer);
		

	}

	@Override
	public void render(float delta) {
		runTime += delta;
		world.update(delta);
		renderer.render(delta, runTime);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		// ===============================================================================
		// Added By iERC - Begin
		if (ZBGame.getAdHandler() != null)
			ZBGame.getAdHandler().showAd(true);
		// Added By iERC - End
		// ===============================================================================
	}

	@Override
	public void hide() {
		// ===============================================================================
		// Added By iERC - Begin
		if (ZBGame.getAdHandler() != null)
			ZBGame.getAdHandler().showAd(false);
		// Added By iERC - End
		// ===============================================================================
	}

	@Override
	public void pause() {
		// ===============================================================================
		// Added By iERC - Begin
		if (ZBGame.getAdHandler() != null)
			ZBGame.getAdHandler().showAd(false);
		// Added By iERC - End
		// ===============================================================================
	}

	@Override
	public void resume() {
		// ===============================================================================
		// Added By iERC - Begin
		if (ZBGame.getAdHandler() != null)
			ZBGame.getAdHandler().showAd(true);
		// Added By iERC - End
		// ===============================================================================
	}

	@Override
	public void dispose() {
	}
	public GameWorld getWorld(){
		return world;
	}
}
