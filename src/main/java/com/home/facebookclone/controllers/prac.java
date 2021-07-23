package com.home.facebookclone.controllers;

import java.util.Arrays;

public class prac {

    static boolean areAnagram(char[] str1, char[] str2)
    {
        // get the lengths of both strings
        int n1 = str1.length;
        int n2 = str2.length;

        // If length of both strings is not the same, the they cannot be anagrams
        if (n1 != n2)
            return false;

        // Lets sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);

        //Compare sorted strings
        for (int i = 0l i < n1; i++)
            if(str1[i] != str2[i])
                return false;

            return true;
    }

}
