package com.bossdevelopment.BossBird2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.kilobolt.Screens.GameScreen;
import com.iERC.BossBird.Ads.IAdReqHandler;
import com.kilobolt.Screens.SplashScreen;
import com.kilobolt.ZBHelpers.AssetLoader;

public class ZBGame extends Game {
	private Preferences prefs;
	// ===============================================================================
	// Added By iERC - Begin
	private static IAdReqHandler AdHandler; // Added By iERC
	
	public ZBGame() {
		super();
	}
	public ZBGame(IAdReqHandler adHandler) {
		super();
		setAdHandler(adHandler);

	}

	// Added By iERC - End
	// ===============================================================================
	@Override
	public void create() {
		AssetLoader.load();
		prefs = Gdx.app.getPreferences("BossBird");
		prefs.getBoolean("SplashDisplayed",false);
		if(prefs.getBoolean("SplashDisplayed") == false){
			setScreen(new SplashScreen(this));
			prefs.putBoolean("SplashDisplayed", true);
			prefs.flush();
			}
		else{
			setScreen(new GameScreen());
		}
		//setScreen(new SplashScreen(this)); old splash screen call
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}

	// ===============================================================================
	// Added By iERC - Begin
	public static IAdReqHandler getAdHandler() {
		return AdHandler;
	}

	public static void setAdHandler(IAdReqHandler adHandler) {
		AdHandler = adHandler;
	}
	// Added By iERC - End
	// ===============================================================================
}