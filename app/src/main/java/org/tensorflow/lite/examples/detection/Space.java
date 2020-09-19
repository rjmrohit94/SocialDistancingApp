package org.tensorflow.lite.examples.detection;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

 class Space {
    List<PersonArea> space ;
    Space(){
        space = new ArrayList<PersonArea>();
    }
    public synchronized int addPerson(PersonArea pa){
        if( space.size() == 0){
            space.add(pa);
            Log.d("DISTANCE"," Total Objects = "+ space.size());
            return 0;
        }
        for(PersonArea person: space){

            float distance = (float)Math.sqrt((float)Math.pow(person.getX()-pa.getX(),2)+(float)Math.pow(person.getY()-pa.getY(),2));
            float mindistance = pa.getRadius()+ person.getRadius();
            if(distance <= mindistance){
                Log.d("DISTANCE"," Move AWAY !!! mind="+ mindistance+" distance = "+distance);

                return -1;
            }
            else{
                Log.d("DISTANCE"," Two are safe");
                space.add(pa);
            }
        }
        Log.d("DISTANCE"," Total Objects = "+ space.size());
        return 0;
    }
}
