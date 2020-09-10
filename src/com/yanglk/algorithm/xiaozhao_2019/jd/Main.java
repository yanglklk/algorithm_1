package com.yanglk.algorithm.xiaozhao_2019.jd;

import com.yanglk.algorithm.offer.Str;

import javax.swing.text.InternationalFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums={7962,4208,5646,4161,8142,8503,9506,2159,8809,6097,2200,2589,788,3256,9035,4425,7492,5732,61,4667,403,8362,8894,1044,162,9207,6104,114,5793,1972,9844,5007,6831,4884,3316,2632,1294,2489,9664,5826,6612,4377,1952,5498,9486,477,2829,7017,3356,952,8496,5646,5178,5592,1549,5022,8097,5945,466,8214,9081,2185,1608,7622,8333,2592,5364,3282,9984,4432,1589,35,3179,9649,4642,3389,8340,117,8935,5293,1861,2649,2580,9194,2162,5695,5319,4750,513,218,5722,9658,8785,3764,9179,6651,8879,7027,910,5184,1676,9069,3754,5850,4546,9250,6427,2223,9421,3161,7808,9546,1340,1253,6456,1836,3448,9594,7361,7940,3497,8246,410,5244,7953,5755,3586,5409,8725,6611,103,3330,8582,9008,9265,9370,2326,6515,2741,7639,9507,9472,2815,5105,5716,3191,773,5296,3080,1578,3980,4591,4204,3223,5857,2700,8844,2322,3280,6762,2702,1268,1364,5152,3838,9225,8628,2752,8227,6272,1792,2195,6333,7514,7481,3370,8991,9135,9979,2709,7075,64,4389,6277,4381,7109,2650,2188,170,5506,8598,7883,9499,2420,6886,7759,5321,9814,1497,5970,9532,7593,1062,5398,6851,1883,4458,9043,3505,5736,1257,9657,9645,4076,9695,9613,6862,5084,9665,2538,7121,1445,4518,8243,2360,4718,7130,6932,4599,1484,3187,539,9119,31,8056,6419,2717,9546,3813,1865,1692,3905,8356,3127,9723,507,1144,7267,1811,9338,1278,7772,2328,5170,8939,6125,139,9816,6340,3640,7966,9071,8148,7542,9951,2902,9546,3110,6557,7067,3004,403,1566,535,6013,2564,5449,369,1901,2470,4989,8038,3920,573,6648,5806,8884,363,21,2594,9783,5786,5412,8010,977,2349,568,5994,579,4013,5699,1642,4141,9275,8477,4018,7262,8828,1430,3544,2512,9009,7733,852,1265,1580,2886,354,1538,7604,3771,2197,986,2688,3399,1615,8187,2652,5118,6095,2744,837,8435,84,9484,2632,1605,1476,6146,7954,1481,1271,928,9466,1464,3445,1783,7344,5822,939,1489,3281,4241,3747,7275,6109,345,2822,3663,4938,2307,3232,4878,3234,7768,2574,7678,6209,1977,8790,3240,1912,8629,920,4248,1479,3202,1215,3954,9596,3935,2043,9713,3402,4372,6613,1467,1978,3885,9676,8715,6252,4697,4434,601,2271,5914,647,3032,9030,1699,3311,1890,3362,9601,1216,7970,1505,2792,4555,5537,4248,7674,1521,2829,1767,2690,6152,5684,5918,855,5332,9282,4191,2175,9964,9067,8710,6046,4726,1750,5169,8472,1154,4719,877,5846,9764,1232,8291,5671,3599,7063,4151,1187,8595,2125,5485,5057,9219,7550,7718,9063,8079,8709,9662,219,1569,7682,7475,8805,9333,7436,7522,4563,2669,4361,5472,5276,8266,6089,2136,4604,7228,5584,9076,598,8599,3523,468,1169,1402,2964,9606,1009,4061,4991,6868,7148,2510,391,5936,5781,6861,5579,4020,3345,5943,8241,5081,2256,1810,9228,1158,3449,304,6430,1223,3986,3734,4843,438,2562,7049,9867,2480,1182,9051,768,574,6852,7526,9419,2883,534,7580,1831,4167,5520,1555,1037,4576,367,9601,1984,6774,3398,1950,1452,8732,382,6833,4058,6918,4606,4730,692,2433,2260,3919,8839,6102,566,1840,2486,9546,8593,1364,6493,2508,2873,3338,6723,3005,2401,4193,3107,943,1227,4514,5280,406,791,324,6539,226,2,6269,5433,9730,4391,173,1125,4818,618,437,2119,8567,3671,8722,7253,9654,4530,9358,277,1848,356,3280,3227,4453,2056,91,6305,996,5424,1770,9555,8507,4299,7730,4075,8803,1429,6184,2478,8654,6663,7038,5348,2280,2472,9759,3703,4003,2447,8165,4968,6766,2699,1406,8639,372,2827,8527,9454,422,945,2095,516,5937,1366,3914,3145,9285,6446,8177,9630,83,3936,5841,1228,5456,4393,9709,5589,26,6925,8069,2319,339,9853,3744,9266,592,4329,6642,2416,33,3244,3587,8751,7264,5175,1124,4686,9476,4466,253,6708,7656,6025,801,7099,4280,9049,1669,4546,2744,1088,606,391,2093,3191,573,7945,7552,7435,12,6667,864,160,1903,958,7781,2516,6149,4515,103,4233,3388,2497,7701,1086,1869,8558,9125,7007,8365,5116,7727,2658,4326,8270,1221,1571,1799,4909,4236,8601,5712,194,3625,3253,7825,8514,3336,5783,1017,4978,3339,3695,4665,5935,9868,8381,7728,4985,5537,6310,3119,982,9354,8693,5494,547,3855,7549,690,2287,9704,1614,6789,1016,453,528,1733,5669,1341,189,3,8437,9275,11,5285,5093,9858,1730,8553,9541,3252,444,1639,480,7055,2567,2884,2858,7547,129,4635,6860,8046,8617,5044,6422,5926,7473,9149,333,8756,1046,5381,6529,3921,2312,7069,8202,1171,1570,3264,5388,3429,5880,1992,7600,6322,4269,5760,99,5032,3055,4383,1050,4928,4562,9274,4721,8788,513,6191,1572,4088,1997,1647,9170,5740,673,1450,883,625,7406,9531,484,5160,4521,112,9964,440,1103,374,2700,478,3758,305,8188,3811,7259,6003,9754,4717,5306,5854,6586,6415,9524,5813,7292,105,2644,488,667,8336,2574,6500,5556,6212,5754,1552,850,1516,3221,3476,6602,7737,8891,7896,2739,5962,87,4265,1871,1828,6705,4503,6479,9858,179,8116,101,6586,3977,1356,2475,4962,513,2073,2338,1281,2662,7986,8203,9451,9105,8804,9780,323,1554,499,2832,1448,3779,6328,6967,6911,1529,5365,3252,88,6129,287,3340,9918,7891,5338,5876,1731,7490,5643,3608,253,301,9693,6332,7441,1814,1584,216,3202,6834,3849,2237,902,136,3199,7440,9180,7564,9535,4562,3355,5101,2812,1006,763,1306,2591,3340,1428,9850,2583,8659,4437,7434,5828,721,6502,1015,7549,7948,1002,9006,1528,1119,2751,1060,7385,1218,7536,44,3220,2705,934,2168,7658,5384,7738,368};
        int k=new Main().Solve(0,"CAAACCCCACCCCAAACCCACCACCACCCCCCCAAACACAAAACAACAAAACACCACAACACAAACAACAACCCCACCAAAACACCACAAACAAACCAAAAAAAAACACCCCACCCCCCACACCACCAACCACCCCCCAAAAAACCAAAAACCCCCCCCAACCCCACCCAACCACCACCACCCCACCCCCACAACCACCACCACCCCACACACAACCAAACCACCCAACACACCCAAAAACAAACCAAACAAACAAACACAAAAACCCCACCAAAAACCACAACCAACAACAAACAAACAAAACACCAACCCCCAACCCCACAACAAAAACCAAAAACCAAAAACAAACAAAACACACCCAACACACCCCCCACACCAACAACACACCAAAACACAACCCCAAACACAAAACAAACCCACCCCCACCCAACAAAACCCCAAAACAAAAAACCACAAAACCAACACCAACCAAACACCCCACAAACCCCACCACAACAAAAACCAAAACAAACCACACCCAACAACAAAAAACCCAACCACACCCAAACAAACCAAACAACCAACCAAAACCAAACAACCACAAACCACCCAACCCCACAACACCCAACACACCACACCCACAAACCCCCCACCCAAAAAAACCACCCACACCACAAAACACAAAACACACCCCACAACACACAACCAAACCACACCCACACCACCCACCCACCCCAAACACCACCAAAACAAACCCAAACACACAACCCCCCAAAACCCAACAAAACCACCCAAACACACCCCCCCCCCACCAACAAAACCACCCCCCCCCCCACACCCACCACCAAACACAACAACAAAAAACCCAACAAAAAACAACAAAAAAAAACACACACAACAAACCAAACCACAAACCCCAACAAACCAAAACCCCCAAAACCAACCCACCAAAAAAACCCCCCCACCAAAACAAAAAAACCCCCCCCCACAAAACCCACACAAACACCCCCACCACCCAAAA");
        System.out.println(k);

    }
    public int GetMinDistance (String S1, String S2) {

        // write code here
        int n=S1.length();
        char[] c1=S1.toCharArray(),c2=S2.toCharArray();
        int res=n;
        for (char i='a';i<='z';i++){
            for (char j='a';j<='z';j++){
                int c=0;
                for (int k = 0; k <n; k++) {
                    if (c1[k]==i){
                        c1[k]=j;
                        if (c1[k]!=c2[k]){
                            c++;
                        }
                        c1[k]=i;
                    }
                    else {
                        if (c1[k]!=c2[k]){
                            c++;
                        }
                    }
                }
                res=Math.min(c,res);
            }
        }
        return res;
    }
    public int selectPresent (int[][] presentVolumn) {
        // write code here
        if (presentVolumn==null||presentVolumn.length==0)
            return 0;
        int n=presentVolumn.length;
        int m=presentVolumn[0].length;
        int[][] opt=new int[n][m];
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=presentVolumn[i][0];
            opt[i][0]=sum;
        }
        sum=0;
        for (int i = 0; i < m; i++) {
            sum+=presentVolumn[0][i];
            opt[0][i]=sum;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                opt[i][j]=presentVolumn[i][j]+Math.min(Math.min(opt[i-1][j],opt[i][j-1]),opt[i-1][j-1]);
            }
        }
        return opt[n-1][m-1];
    }

    public int mountainSequence (int[] numberList) {
        // write code here
        int n=numberList.length;
        int[] opt=new int[n];
        opt[0]=1;
        boolean inc=true;
        for (int i = 1; i < n; i++) {
           int max=1;
            for (int j = 0; j < i; j++) {
                if (numberList[i]>numberList[j]){
                    max=Math.max(max,opt[j]+1);
                }
            }
            opt[i]=max;
        }
        int[] opt1=new int[n];
        opt1[n-1]=1;
        for (int i = n-2; i >= 0; i--) {
            int max=1;
            for (int j = n-1; j > i; j--) {
                if (numberList[i]>numberList[j]){
                    max=Math.max(max,opt1[j]+1);
                }
            }
            opt1[i]=max;
        }

        int max2= 1;
        for (int i = 0; i < n; i++) {
            max2=Math.max(opt1[i]+opt[i]-1,max2);
        }
        //System.out.println(max2);
        return max2;
    }

    public int countLR (int[] a, int[] b) {
        int sum=0;
        int n=a.length;
        int c=0;
        for (int i = 0; i < n; i++) {
            sum=0;
            for (int j = i; j < n; j++) {
                sum+=a[j];
                if (sum==(b[i]+b[j])){
                    c++;
                }

            }
        }
        return c;


    }

    public int[] solve (int n, int q, int[] a, int[] p) {
        // write code here
        int[] res=new int[q];
        Arrays.sort(a);
        for (int i = 0; i < q; i++) {
            List<Integer> l=new ArrayList<>();
            int s=0;
            for (int i1 : a) {
                s+=i1;
                l.add(s);
            }

        }
        return null;
    }

    public int countDislocation (int n, int[] cutIn) {
        // write code here
        List<Integer> l=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(i);
        }

        for (int i : cutIn) {
            l.remove(new Integer(i-1));
            l.add(0,i-1);

        }
        int c=0;
        for (int i = 0; i < n; i++) {
            if (l.get(i)!=i)
                c++;
        }
        return c;
    }

    public int countDislocation1 (int n, int[] cutIn) {
        // write code here
        int max=Integer.MIN_VALUE;
        for (int i : cutIn) {
            max=Math.max(i,max);
        }
        Set<Integer> set=new HashSet<>();
        for (int i = cutIn.length - 1; i >= 0; i--) {
            if (!set.contains(cutIn[i])){
                if (cutIn[i]==set.size()+1)
                    max--;
                set.add(cutIn[i]);
            }
        }
        return max;
    }

    public String change (String number) {
        // write code here
        if (number==null||number.length()<=1)
            return number;
        char[] chars=number.toCharArray();
        int r=chars.length-1;
        int l=0;
        while (l<=r){
            boolean fl=(chars[l]-'0')%2==0;
            boolean fr=(chars[r]-'0')%2==0;
            if (fl==true&&fr==false){
                r--;
            }
            else if (fl==false&&fr==true){
                l++;
            }
            else if (fl&&fr){
                char t=chars[l];
                chars[l]=chars[r];
                chars[r]=t;
                r--;
                l++;
            }
            else {
                r--;
                l++;
            }

        }
        return String.valueOf(chars);
    }

    public long IncreasingArray (int[] array) {
        // write code here
        long c=0;
        for (int i = 0; i < array.length-1; i++) {
            c+=Math.max(array[i]+1-array[i+1],0);
        }
        return c;
    }

    public int Solve (int k, String s) {
        // write code here

        return Math.max(cal(s,'A',k),cal(s,'C',k));
    }
    public int cal(String s,char ch,int k){
        int l=0;
        int r=0;
        int c=0;
        int max=0;
        while (r<s.length()&&l<s.length()){
               while (r<s.length()&&c<=k){
                   if (c==k&&s.charAt(r)!=ch)
                       break;
                   if (s.charAt(r)!=ch){
                       c++;
                   }
                   max=Math.max(r-l+1,max);
                   r++;
               }
               if (s.charAt(l)!=ch){
                   c--;
               }
               l++;
        }
        return max;
    }

}
