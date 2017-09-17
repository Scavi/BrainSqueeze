/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scavi.brainsqueeze.codefight.challenge;

import com.scavi.brainsqueeze.codefight.challenge.Gangsteranos;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 6/19/2017.
 */
public class GangsteranosTest {
    @Test
    public void test1() {
        String[] input = {"Dead_Bowie Fake_Thomas_Jefferson"};
        Assert.assertTrue(new Gangsteranos().theFather(input));
    }

    @Test
    public void test2() {
        String[] input = {"Dead_Bowie Fake_Thomas_Jefferson",
                "Fake_Thomas_Jefferson Fury_Leika",
                "Fury_Leika Dead_Bowie"};
        Assert.assertFalse(new Gangsteranos().theFather(input));
    }

    @Test
    public void test3() {
        String[] input = {"Spider_Girl Blue_Snowman",
                "Blue_Snowman Roulette",
                "Roulette Spider_Girl"};
        Assert.assertFalse(new Gangsteranos().theFather(input));
    }

    @Test
    public void test4() {
        String[] input = {"Dead_Bowie Nyssa_Raatko",
                "Animora Lafety_Le_Fei",
                "Animora Mothergod",
                "Animora Nyssa_Raatko",
                "Dead_Bowie Genevieve_Savidge",
                "Dead_Bowie Lafety_Le_Fei",
                "Animora Genevieve_Savidge",
                "Dead_Bowie Mothergod"};
        Assert.assertTrue(new Gangsteranos().theFather(input));
    }

    @Test
    public void test5() {
        String[] input = {"Lady_Vic Abominatrix",
                "Harley_Quinn Trinity",
                "New_Wave Abominatrix",
                "New_Wave Trinity",
                "Lady_Vic Tigress",
                "Harley_Quinn Hypnota",
                "Harley_Quinn Tigress",
                "Hypnota Mothergod",
                "New_Wave Mothergod",
                "Hypnota Abominatrix"};
        Assert.assertFalse(new Gangsteranos().theFather(input));
    }


    @Test
    public void test6() {
        String[] input = {"Willia_Faircloth Jenee_Platero",
                "Jenee_Platero Dennis_Lukes",
                "Vanessa_Alward Colby_Leeds",
                "Retta_Hedberg Dirk_Spires",
                "Inell_Izzard Fernanda_Chappel",
                "Colby_Leeds Berta_Wittig",
                "Fernanda_Chappel Berta_Wittig",
                "Sidney_Whitlock Saundra_Cozad",
                "Lavonda_Frederickson Retta_Hedberg",
                "Jenee_Platero Christal_Pippin",
                "Dirk_Spires Retta_Hedberg",
                "Lilly_Hamp Johnathon_Arpin",
                "Saundra_Cozad Fern_Grunwald",
                "Lesa_Barnhouse Fern_Grunwald"};
        Assert.assertTrue(new Gangsteranos().theFather(input));
    }
}
