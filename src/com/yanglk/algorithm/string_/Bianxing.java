package com.yanglk.algorithm.string_;

import javafx.scene.control.ScrollPane;

import javax.sound.midi.MidiChannel;
import javax.swing.text.StyledEditorKit;
import java.util.HashMap;
import java.util.Map;

public class Bianxing {
    public Bianxing() {
    }

    public static void main(String[] args) {
        Bianxing bx = new Bianxing();
        String s1 = "**12*334*34*5*";
        char[] chas = s1.toCharArray();
        String[] strs1 = {null, "a", null, "a", null, "b", null, null, null, null, "c", null, "d", null, null};
        System.out.println(bx.modify(chas));

    }

    public boolean isBianxing(String s1, String s2) {
        int[] map = new int[256];
        if (s1.length() != s2.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i)] += 1;
            map[s2.charAt(i)] -= 1;
        }
        for (int i : map) {
            if (i != 0)
                return false;
        }
        return true;
    }

    public String getCountString(String s) {
        int c = 1;
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        sb.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                sb.append('_');
                sb.append(c);
                sb.append('_');
                sb.append(chars[i]);
                c = 0;
            }
            c++;
        }
        sb.append('_');
        sb.append(c);
        return sb.toString();
    }

    public char getAtChar(String s, int index) {
        char[] c = s.toCharArray();
        int i = 2;
        int count = 0;
        for (; i < s.length(); i = i + 4) {
            if (index <= count)
                return c[i - 2];
            count += (c[i] - '0');
        }
        return '\0';
    }

    public boolean isUnique(char[] chas) {
        boolean[] map = new boolean[256];
        for (int i = 0; i < chas.length; i++) {
            if (map[chas[i]]) {
                return false;
            }
            map[chas[i]] = true;
        }
        return true;
    }

    public int getIndex(String[] strs, String str) {
        /*
         * @Author yanglk
         * @Description //TODO find first str in strs
         * @Date 11:07 2019/10/5
         * @Param [strs, str]
         * @return int
         **/

        if (str == null)
            return -1;
        int l = 0;
        int r = strs.length - 1;
        int mid = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (strs[mid] == null) {
                int i = 1;
                while (true) {
                    if (mid + i <= r && strs[mid + i] != null) {
                        mid = mid + i;
                        break;
                    }
                    if (mid - i >= l && strs[mid - i] != null) {
                        mid = mid - i;
                        break;
                    }
                    if (mid + i > r || mid - i < l)
                        return -1;
                    i++;
                }
            }
            int index = mid;
            if (strs[mid].equals(str)) {
                while (mid >= l) {
                    if (strs[mid] == null) {
                        mid--;
                        continue;
                    }
                    if (strs[mid].equals(str)) {
                        index = mid;
                    }
                    mid--;
                }
                return index;
            } else if (strs[mid].compareTo(str) > 0) {
                r = mid - 1;
                mid = (l + r) / 2;
            } else {
                l = mid + 1;
                mid = (l + r) / 2;
            }
        }
        return -1;
    }

    public char[] modify(char[] chas) {
//        int f = chas.length - 1;
//        int l = f;
//        while (l >= 0) {
//            if (chas[l] == '*') {
//                while (f >= 0 && chas[f] == '*')
//                    f--;
//                if (f < 0)
//                    return chas;
//                chas[l] = chas[f];
//                chas[f] = '*';
//            } else {
//                l--;
//                if (f > l)
//                    f = l;
//            }
//        }
        System.out.println("ok");
        int j=chas.length - 1;
        for (int i = chas.length - 1; i >= 0; i--) {
            if (chas[i]!='*'){
                chas[j]=chas[i];
                j--;
            }
        }
        while (j>=0)
            chas[j--]='*';
        return chas;
    }
}





