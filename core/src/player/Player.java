package player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import helpers.GameInfo;

public class Player extends Sprite {

    private World world;
    private Body body;

    public Player(World world, String name, float x, float y){
        super(new Texture(name));
        this.world = world;
        setPosition(x - getWidth()/2, y - getHeight()/2);
        createBody();
    }

    void createBody(){
        BodyDef bodyDef = new BodyDef();
        // a static body is not affected by gravity or other forces
        //a kinematic body is not affected by gravity but is affect by other forces
        //a dynamic body is affected by gravity and other forces
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(getX()/ GameInfo.PPM, getY()/ GameInfo.PPM);
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox((getWidth() / 2)/ GameInfo.PPM, (getHeight() / 2)/ GameInfo.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1;

        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
        
    }

    public void updatePlayer(){
        this.setPosition(body.getPosition().x * GameInfo.PPM, body.getPosition().y * GameInfo.PPM);

    }

}
