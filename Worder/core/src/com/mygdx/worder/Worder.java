package com.mygdx.worder;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Worder extends ApplicationAdapter {
	SpriteBatch batch;
	Stage stage;
	Texture img, title, authorName;
	TextButton start;
	TextButton.TextButtonStyle textButtonStyle;
	BitmapFont font;
	Skin skin;
	TextureAtlas buttonAtlas;
	private Label outputLabel;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("fondo2.jpg");
		title = new Texture("wordleTitle.png");
		authorName = new Texture("authorname.png");

		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		int Help_Guides = 12;
		int row_height = Gdx.graphics.getWidth() / 12;
		int col_width = Gdx.graphics.getWidth() / 12;


		Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

		Label title = new Label("Buttons with Skins",mySkin,"big-black");
		title.setSize(Gdx.graphics.getWidth(),row_height*2);
		title.setPosition(0,Gdx.graphics.getHeight()-row_height*2);
		title.setAlignment(Align.center);
		stage.addActor(title);

		Button button1 = new Button(mySkin,"big");
		button1.setSize(col_width*4, row_height);
		button1.setPosition(col_width*7, Gdx.graphics.getHeight()-row_height*3);
		button1.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Press a Button");
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Pressed Button");
				return true;
			}
		});
		stage.addActor(button1);




	}


	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		stage.act();
		stage.draw();
		batch.begin();

		batch.draw(img, 0, 0, 750, 600);
		batch.draw(title, 310, 45 );
		batch.draw(authorName,140, 10 );
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
