package com.yanglk.algorithm.sort_;


import java.util.Arrays;

public class Base_sort {

    public Base_sort() {

    }

    public static void main(String[] args) {
        //int[] nums={1,-2,4,2,-3,1,15,7,2,-4,9,-10};
        int[] nums={16,7,3,17,20,8};
        nums=new Base_sort().merge_sort(nums);
        System.out.println(Arrays.toString(nums));
    }



    public int[] selection_sort(int[] nums){
        //选择排序
        //选择出最小后交换

        if (nums==null||nums.length==0)
            return null;

        for (int i=0;i<nums.length;i++){
            int min=nums[i];
            int tag=i;
            for (int j=i;j<nums.length;j++){
                if (nums[j]<=min){
                    min=nums[j];
                    tag=j;
                }
            }
            int temp=nums[i];
            nums[i]=nums[tag];
            nums[tag]=temp;
        }
        return nums;
    }

    public int[] insert_sort(int[] nums){
        //每次将一个待排序的记录，按其关键字大小插入到前面已经排好序的子文件中的适当位置，直到全部记录插入完成为止。
        if (nums==null||nums.length==0)
            return null;

        for (int i=1;i<nums.length;i++){
            int temp=nums[i];
            int j=i-1;
            while(j>=0&&nums[j]>temp){
                nums[j+1]=nums[j];
                nums[j]= temp;
                j--;
            }


        }
        return nums;
    }

    public int[] bubble_sort(int[] nums){
        // 两两比较 轻者上浮
        if (nums==null||nums.length==0)
            return null;
        for (int i = 0; i < nums.length-1; i++) {
            boolean f=true;
            for (int i1 = 0; i1 < nums.length-1-i; i1++) {
                if (nums[i1]>nums[i1+1]) {
                    int temp=nums[i1];
                    nums[i1]=nums[i1+1];
                    nums[i1+1]=temp;
                    f=false;
                }
            }
            if (f)
                return nums;
        }
        return nums;
    }

    public int[] shell_sort(int[] nums){
        int len=nums.length;
        for (int h=len/2;h>=1;h=h/2){
            for(int i=h;i<len;i++){
                int temp=nums[i];
                int j=i-h;
                while (j>=0&&nums[j]>temp){
                    nums[j+h]=nums[j];
                    nums[j]=temp;
                    j=j-h;
                }

            }
        }
        return nums;
    }

    public int[] quick_sort(int[] nums){

        return quick_sort_(nums,0,nums.length-1);
    }

    public int[] quick_sort_(int[] nums,int l1,int r1){
        if (l1>=r1)
            return nums;
        int l=l1,r=r1;
        int p=nums[l1];
        while (l<r){
            while (nums[r]>=p&&l<r)
                r--;
            while (nums[l]<=p&&l<r)
                l++;
            if (l<r){
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
            }
        }
        nums[l1]=nums[l];
        nums[l]=p;
        nums=quick_sort_(nums,l1,l);
        nums=quick_sort_(nums,l+1,r1);
        return nums;
    }

    public int[] heap_sort(int[] nums){
        for (int h=nums.length/2-1;h>=0;h--){
            nums=heapAdjust(nums,nums.length,h);
        }
        for (int i = nums.length-1; i >=0; i--) {
            int temp=nums[i];
            nums[i]=nums[0];
            nums[0]=temp;
            heapAdjust(nums,i,0);

        }
        return nums;

    }

    public int[] heapAdjust(int[] nums,int len,int i){
        /*
         * @Author yanglk
         * @Description //TODO
         * @Date 11:00 2019/10/5
         * @Param [nums, len, i]
         * len 堆排序 截止位置
         * i 要排序的节点
         * @return int[]
         **/

        int l=len/2-1;
        int id=2*i+1;

        while (i<=l){
            int temp=nums[i];
            if (nums[i]<nums[id]){
                nums[i]=nums[id];
                nums[id]=temp;
            }
            temp=nums[i];
            if (id+1<len){
                if (nums[i]<nums[id+1]){
                    nums[i]=nums[id+1];
                    nums[id+1]=temp;
                }
            }
            i++;
        }

        return  nums;


    }

    public int[] merge_sort(int[] nums){
        return merge_sort_(nums,0,nums.length-1);
    }

    public int[] merge_sort_(int[] nums,int l,int r){
        if (l>=r){
            return nums;
        }
        int mid=(l+r)/2;
        nums=merge_sort_(nums,l,mid);
        nums=merge_sort_(nums,mid+1,r);
        nums=merge_1(nums,l,r);
        return nums;
    }

    public int[] merge(int[] nums,int l,int r){
        int mid=(l+r)/2;
        for(int i=mid+1;i<=r;i++){
            int j=mid;
            int temp=nums[i];
            while (j>=l&&nums[j]>temp){
                nums[j+1]=nums[j];
                nums[j]=temp;
                j--;
            }

        }
        return nums;
    }

    public int[] merge_1(int[] nums,int l,int r){
        int mid=(l+r)/2;
        int[] temp=new int[r-l+1];
        int i=l,j=mid+1;
        int k=0;
        while (i<=mid&&j<=r){
            if (nums[i]<nums[j]) {
                temp[k]=nums[i];
                i++;
            }
            else {
                temp[k]=nums[j];
                j++;
            }
            k++;
        }
        if (k<temp.length){
            if (i<=mid){
                while (i<=mid) {
                    temp[k] = nums[i];
                    i++;
                    k++;
                }
            }

            if (j<=r){
                while (j<=r) {
                    temp[k] = nums[j];
                    j++;
                    k++;
                }
            }
        }
        k=0;
        while (k<temp.length){
            nums[l+k]=temp[k];
            k++;
        }
        return nums;
    }


}
