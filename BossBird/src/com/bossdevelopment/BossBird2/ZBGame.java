package com.bossdevelopment.BossBird2;

import com.badlogic.gdx.Game;
import com.iERC.BossBird.Ads.IAdReqHandler;
import com.kilobolt.Screens.SplashScreen;
import com.kilobolt.ZBHelpers.AssetLoader;

public class ZBGame extends Game {

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
		setScreen(new SplashScreen(this));
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