package com.example.su.kniffel4fun;

/**
 * Created by Su on 17.03.2018.
 */

public class AvatarItem {
    private int mAvatarImage;

    /*
    * constructor to create a new AvatarItem
     */
    public AvatarItem(int avatarImage){
        mAvatarImage = avatarImage;
    }

    /*
    * method to return the AvatarImage
    * @return int, the id of the avatarImage
     */
    public int getAvatarImage() {
        return mAvatarImage;
    }
}
