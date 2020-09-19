package org.tensorflow.lite.examples.detection;

public class PersonArea {

    private float centerX;
    private float centerY;
    private float radius;
    public PersonArea( float centerX,float centerY, float radius){
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }
    public float getRadius(){
        return radius;
    }
    public float getX(){
        return centerX;
    }
    public float getY()
    {
        return centerY;
    }

}
