package com.verticesstudio.frogfungi;



/**
 * Created by kucrut on 1/16/2016.
 */
 class RectHitbox {
    float top;
    float left;
    float bottom;
    float right;
    float height;
    float radius;
    float radiusxcenter;
    float radiusycenter;

    boolean intersects(RectHitbox rectHitbox){
        boolean hit = false;
        if(this.right > rectHitbox.left
                && this.left < rectHitbox.right ){
            // Intersecting on x axis
            if(this.top < rectHitbox.bottom
                    && this.bottom > rectHitbox.top ){


                hit = true;


            }
        }
        return hit;
    }

    boolean intersectcircle(RectHitbox rectHitbox){
        boolean hit = false;


        if((float)(Math.sqrt(((this.radiusxcenter - rectHitbox.radiusxcenter) * (this.radiusxcenter - rectHitbox.radiusxcenter)) +
                ((this.radiusycenter - rectHitbox.radiusycenter) *  (this.radiusycenter - rectHitbox.radiusycenter)))) < rectHitbox.radius){


            hit = true;


        }

        return hit;


    }

    boolean contains(float x, float y){
        boolean hit = false;

        if(this.left < x && x < this.right){
            if(this.top < y && y < this.bottom){

                hit = true;


            }
        }

        return hit;
    }


}
