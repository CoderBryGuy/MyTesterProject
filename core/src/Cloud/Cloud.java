package Cloud;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import helpers.GameInfo;

public class Cloud extends Sprite {

    private World world;
    private Body body;

    public Cloud(Texture texture, World world) {
        super(new Texture("Cloud 1.png"));
        this.world = world;
        setPosition(GameInfo.WIDTH/2f , GameInfo.HEIGHT/2f - 130);
        createBody();
    }

    private void createBody() {

        BodyDef bodyDef = new BodyDef();
        // a static body is not affected by gravity or other forces
        //a kinematic body is not affected by gravity but is affect by other forces
        //a dynamic body is affected by gravity and other forces
        bodyDef.type = BodyDef.BodyType.StaticBody;
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
