package com.libGDX.engine.Base;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.brashmonkey.spriter.Data;
import com.brashmonkey.spriter.Drawer;
import com.brashmonkey.spriter.Player;
import com.brashmonkey.spriter.SCMLReader;

import game.GameManager;

public class MainGameLoop extends ApplicationAdapter implements InputProcessor
{
    public static final float MS_FOR_EACH_FRAME = 1000f / 60;
    public static final int VIEWPORT_WIDTH = 1280;
    public static final int VIEWPORT_HEIGHT = 720;
    SpriteBatch spriteBatch;
    double previous = TimeUtils.millis();
    double lag = 0.0;
    public OrthographicCamera camera;
    Viewport viewport;
    public TiledMap tiledMap;
    public TiledMapRenderer tiledMapRenderer;

    // spriter
    Player player;
    Drawer<Sprite> drawer;
    LibGdxLoader loader;
    ShapeRenderer renderer;

    @Override
    public void create()
    {

        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.setToOrtho(true);
        camera.position.set(VIEWPORT_WIDTH / 2, VIEWPORT_HEIGHT / 2, 0);
        viewport = new FitViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, camera);

        // spriter
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        renderer.setProjectionMatrix(camera.combined);

        camera.update();
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
        GameManager.onGameStart();
        tiledMap = new TmxMapLoader().load("test.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap,spriteBatch);
        tiledMap.getLayers().get(1).setVisible(true);


        // spriter
        FileHandle handle = Gdx.files.internal("monster/basic_002.scml");
        Data data = new SCMLReader(handle.read()).getData();
        loader = new LibGdxLoader(data);
        loader.load(handle.file());
        drawer = new LibGdxDrawer(loader, spriteBatch, renderer);
        player = new Player(data.getEntity(0));
        player.setPosition(400,240);
        player.flip(false,true);


    }

    @Override
    public void render()
    {

        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        double current = TimeUtils.millis();
        double elapsed = current - previous;
        previous = current;
        lag += elapsed;
        while (lag >= MS_FOR_EACH_FRAME)
        {

            GameManager.update();
            lag -= MS_FOR_EACH_FRAME;
        }



        spriteBatch.setProjectionMatrix(camera.combined);
        tiledMapRenderer.setView(camera);

        // spriter player update
        player.update();

        tiledMapRenderer.render(new int[]{0});
        renderer.begin();
        spriteBatch.begin();




        // spriter player draw

        drawer.drawBoxes(player);
        drawer.draw(player);

        GameManager.paint(spriteBatch);

        renderer.end();
        spriteBatch.end();
        tiledMapRenderer.render(new int[]{1});


    }


    @Override
    public void dispose()
    {
        spriteBatch.dispose();
        renderer.dispose();
        loader.dispose();

    }


    public void Debug(String s)
    {
        Gdx.app.debug("Test", s);
    }


    @Override
    public boolean keyDown(int keycode)
    {


        if (keycode == Input.Keys.LEFT)
        {
            camera.translate(32, 0);
        }
        if (keycode == Input.Keys.RIGHT)
        {
            camera.translate(-32, 0);

        }
        if (keycode == Input.Keys.UP)
        {
            camera.translate(0, 32);
        }
        if (keycode == Input.Keys.DOWN)
        {

            camera.translate(0, -32);

        }


        GameManager.keyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        GameManager.keyUp(keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        GameManager.touchDown(screenX, screenY, pointer, button);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {

        GameManager.touchUp(screenX, screenY, pointer, button);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        GameManager.touchDragged(screenX, screenY, pointer);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        GameManager.mouseMoved(screenX, screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount)
    {
        return false;
    }

    @Override
    public void pause()
    {
        super.pause();
        GameManager.onPause();
        Debug("Paused");
    }

    @Override
    public void resize(int width, int height)
    {
       camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
        viewport.update(width, height);

    }
}
