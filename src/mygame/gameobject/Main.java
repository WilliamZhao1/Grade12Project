package mygame;

import com.jme3.anim.AnimComposer;
import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimEventListener;
import com.jme3.animation.LoopMode;
import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 * Sample 7 - how to load an OgreXML model and play an animation, using
 * channels, a controller, and an AnimEventListener.
 */
public class Main extends SimpleApplication {

    AnimComposer comp;

    Node player;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        
        flyCam.setMoveSpeed(30);
        viewPort.setBackgroundColor(ColorRGBA.LightGray);
        initKeys();
        //DirectionalLight dl = new DirectionalLight();
        //dl.setDirection(new Vector3f(-0.1f, -1f, -1).normalizeLocal());
        //rootNode.addLight(dl);
        player = (Node) assetManager.loadModel("Models/Cube/Cube.mesh.xml");
        // player = (Node) assetManager.loadModel("Models/exportTest2/Cube.mesh.j3o");
        // important: mesh.xml & mesh.j3o works, nothing else works!!!
        
        
        AmbientLight al = new AmbientLight();
        rootNode.addLight(al);
        
        player.setLocalScale(0.5f);
        rootNode.attachChild(player);
        
        System.out.println(player.getControl(AnimComposer.class));
        comp = player.getControl(AnimComposer.class);
        comp.setCurrentAction("move0");
        
        
        initKeys();
        
    

    }

    public void onAnimCycleDone(AnimControl control, AnimChannel channel, String animName) {
        
    }

    public void onAnimChange(AnimControl control, AnimChannel channel, String animName) {
        // unused
    }

    /**
     * Custom Keybinding: Map named actions to inputs.
     */
    private void initKeys() {
        inputManager.addMapping("w", new KeyTrigger(KeyInput.KEY_W));
        inputManager.addListener(actionListener, "w");
        
        inputManager.addMapping("s", new KeyTrigger(KeyInput.KEY_S));
        inputManager.addListener(actionListener, "s");
    }
    
    private ActionListener actionListener = new ActionListener() {
        public void onAction(String name, boolean keyPressed, float tpf) {
            if (name.equals("w") && !keyPressed) {
                comp.setCurrentAction("move0");
            }
            if (name.equals("s") && !keyPressed) {
                comp.setCurrentAction("move1");
            }
        }
    };
}
