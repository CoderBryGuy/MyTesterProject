package player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

public class Player extends Sprite {

    private World world;
    private Body body;

    public Player(String name, float x, float y){
        super(new Texture(name));
        setPosition(x - getWidth()/2, y - getHeight()/2);

    }

    void createBody(){
        BodyDef bodyDef = new BodyDef();
        // a static body is not affected by gravity or other forces
        //a kinematic body is not affected by gravity but is affect by other forces
        //a dynamic body is affected by gravity and other forces
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(getX(), getY());
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(getWidth() / 2, getHeight() / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1;

        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
        
    }

}
