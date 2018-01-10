package com.scavi.brainsqueeze.codefight.i.tree;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class FindSubstringsTest {

    @Test
    public void test1() {
        String[] result = new FindSubstrings().findSubstrings(
                new String[]{"Apple", "Melon", "Orange", "Watermelon"},
                new String[]{"a", "mel", "lon", "el", "An"});
        String[] expected = new String[]{"Apple", "Me[lon]", "Or[a]nge", "Water[mel]on"};
        assertThat(expected.length).isEqualTo(result.length);
        for (int i = 0; i < expected.length; ++i) {
            assertThat(result[i]).isEqualTo(expected[i]);
        }
    }


    @Test
    public void test2() {
        String[] result = new FindSubstrings().findSubstrings(
                new String[]{"neuroses",
                        "myopic",
                        "sufficient",
                        "televise",
                        "coccidiosis",
                        "gules",
                        "during",
                        "construe",
                        "establish",
                        "ethyl"},
                new String[]{"aaaaa",
                        "Aaaa",
                        "E",
                        "z",
                        "Zzzzz",
                        "a",
                        "mel",
                        "lon",
                        "el",
                        "An",
                        "ise",
                        "d",
                        "g",
                        "wnoVV",
                        "i",
                        "IUMc",
                        "P",
                        "KQ",
                        "QfRz",
                        "Xyj",
                        "yiHS"});
        String[] expected = new String[]{"neuroses",
                "myop[i]c",
                "suff[i]cient",
                "telev[ise]",
                "cocc[i]diosis",
                "[g]ules",
                "[d]uring",
                "construe",
                "est[a]blish",
                "ethyl"};
        assertThat(expected.length).isEqualTo(result.length);
        for (int i = 0; i < expected.length; ++i) {
            assertThat(result[i]).isEqualTo(expected[i]);
        }
    }
}
