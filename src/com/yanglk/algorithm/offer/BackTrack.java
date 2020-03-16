package com.yanglk.algorithm.offer;

import com.sun.org.apache.regexp.internal.RE;

public class BackTrack {

    public int JumpFloor(int target) {
        if (target<=2)
            return target;
        else
            return JumpFloor(target-1)+JumpFloor(target-2);

    }

    public int JumpFloorII(int target) {
        if (target==0)
            return 1;
        else {
            int step=0;
            for (int i = target-1; i >= 0; i--) {
                step+=JumpFloorII(i);
            }
            return step;
        }

    }

    public int RectCover(int target) {
        if (target<=2)
            return target;
        else {
            return RectCover(target-1)+ RectCover(target-2);
        }
    }
}

