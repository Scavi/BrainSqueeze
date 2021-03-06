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

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Scavenger on 6/11/2017.
 */
public class AlphabetExerciseTest {
    @Test
    public void test1() {
        String[] vocabulary = {
                "globe", "job", "excellent", "round", "joy", "lock", "vial",
                "knot", "wait", "waist", "great", "abuse", "academic", "accept",
                "access", "zone", "account", "accuse", "act", "turn", "come",
                "move", "leader", "query", "school", "part", "letter", "roll",
                "yield", "next", "free", "froze", "pair", "arrow", "feel", "float",
                "mean", "flash"
        };
        int minLength = new AlphabetExercise().alphabetExercise(vocabulary);
        Assert.assertEquals(109, minLength);
    }


    @Test
    public void test2() {

        String[] vocabulary = {
                "powerful",
                "leader",
                "hide",
                "japanese",
                "possess",
                "emphasize",
                "helpful",
                "memory",
                "clue",
                "male",
                "association",
                "limited",
                "ratio",
                "knowledge",
                "conclude",
                "consume",
                "off",
                "basketball",
                "hearing",
                "position",
                "success",
                "fish",
                "thousand",
                "wake",
                "bridge",
                "quarterback",
                "desperate",
                "dramatic",
                "let",
                "contact",
                "basket",
                "cloud",
                "curriculum",
                "beat",
                "error",
                "direction",
                "composition",
                "distribution",
                "effective",
                "please",
                "flame",
                "fiction",
                "grandfather",
                "thank",
                "wear",
                "self",
                "sit",
                "relate",
                "forth",
                "clinical",
                "literature",
                "youth",
                "writer",
                "publicly",
                "existing",
                "thin",
                "pepper",
                "exercise",
                "side",
                "used",
                "early",
                "life",
                "feeling",
                "permission",
                "abortion",
                "target",
                "perception",
                "simple",
                "say",
                "democrat",
                "gesture",
                "feed",
                "plenty",
                "following",
                "reference",
                "balance",
                "strategy",
                "threat",
                "trouble",
                "salad",
                "pound",
                "vs",
                "billion",
                "remember",
                "protection",
                "die",
                "tip",
                "cook",
                "future",
                "clear",
                "train",
                "glad",
                "collapse",
                "idea",
                "philosophy",
                "magazine",
                "incident",
                "contribution",
                "feature",
                "extra",
                "try",
                "anyway",
                "internal",
                "spring",
                "secretary",
                "adapt",
                "cover",
                "cheek",
                "motion",
                "shelf",
                "much",
                "officer",
                "theory",
                "people",
                "impact",
                "borrow",
                "representative",
                "mistake",
                "elementary",
                "garage",
                "crime",
                "strategic",
                "teen",
                "various",
                "differ",
                "combination",
                "barrel",
                "discrimination",
                "drive",
                "rarely",
                "afternoon",
                "ride",
                "producer",
                "killer",
                "primarily",
                "explosion",
                "scared",
                "shell",
                "seat",
                "bring",
                "guard",
                "golden",
                "university",
                "admit",
                "considerable",
                "medical",
                "best",
                "husband",
                "including",
                "body",
                "destruction",
                "artistic",
                "battery",
                "universe",
                "part",
                "negotiation",
                "beginning",
                "service",
                "progress",
                "bomb",
                "speech",
                "psychological",
                "escape",
                "baseball",
                "certain",
                "meet",
                "detect",
                "participate",
                "wooden",
                "express",
                "cope",
                "procedure",
                "efficient",
                "area",
                "must",
                "promise",
                "depict",
                "attempt",
                "left",
                "cool",
                "numerous",
                "blind",
                "republican",
                "dialogue",
                "type",
                "save",
                "post",
                "reputation",
                "may",
                "aggressive",
                "collect",
                "entire",
                "proportion",
                "complex",
                "housing",
                "shock",
                "substantial",
                "discipline",
                "fund",
                "scholar",
                "reinforce",
                "cultural",
                "anger",
                "permit",
                "ethics",
                "highly",
                "variation",
                "acknowledge",
                "ie",
                "determine",
                "existence",
                "club",
                "heat",
                "honey",
                "occur",
                "expectation",
                "win",
                "digital",
                "small",
                "rate",
                "worry",
                "story",
                "name",
                "exactly",
                "without",
                "reveal",
                "ring",
                "put",
                "menu",
                "massive",
                "discover",
                "arrival",
                "guide",
                "coast",
                "bunch",
                "assumption",
                "too",
                "day",
                "crowd",
                "approach",
                "constitute",
                "cable",
                "eye",
                "toss",
                "king",
                "fire",
                "sugar",
                "current",
                "generation",
                "ticket",
                "employment",
                "flower",
                "political",
                "afford",
                "invite",
                "media",
                "literally",
                "kick",
                "concept",
                "highway",
                "nearby",
                "blow",
                "public",
                "speak",
                "climate",
                "hotel",
                "background",
                "weapon",
                "with",
                "drink",
                "terrible",
                "square",
                "observer",
                "mark",
                "alcohol",
                "forward",
                "border",
                "draw",
                "army",
                "merely",
                "headline",
                "infection",
                "smart",
                "civil",
                "cancer",
                "author",
                "strongly",
                "edge",
                "expansion",
                "noise",
                "fear",
                "father",
                "campus",
                "relief",
                "accept",
                "regarding",
                "knock",
                "competition",
                "travel",
                "sound",
                "basic",
                "move",
                "session",
                "active",
                "nobody",
                "environmental",
                "entirely",
                "engineering",
                "law",
                "skill",
                "congressional",
                "hundred",
                "increasing",
                "united",
                "danger",
                "cash",
                "episode",
                "raw",
                "french",
                "distinguish",
                "fit",
                "close",
                "insist",
                "bus",
                "adventure",
                "therapy",
                "good",
                "achieve",
                "knee",
                "glove",
                "policy",
                "raise",
                "journal",
                "jet",
                "tactic",
                "prefer",
                "none",
                "exceed",
                "who",
                "surely",
                "surround",
                "silver",
                "tourist",
                "assistant",
                "boy",
                "go",
                "although",
                "search",
                "symbol",
                "spending",
                "enforcement",
                "engine",
                "lovely",
                "drama",
                "grow",
                "penalty",
                "handful",
                "picture",
                "community",
                "flag",
                "pant",
                "everywhere",
                "prospect",
                "versus",
                "iraqi",
                "cousin",
                "of",
                "restriction",
                "read",
                "library",
                "recommend",
                "software",
                "switch",
                "private",
                "whatever",
                "pregnant",
                "heavily",
                "know",
                "narrative",
                "arrangement",
                "awareness",
                "tissue",
                "european",
                "odd",
                "very",
                "ah",
                "total",
                "winter",
                "reason",
                "keep",
                "season",
                "employer",
                "social",
                "south",
                "trip",
                "no",
                "thinking",
                "always",
                "relation",
                "team",
                "palestinian",
                "gas",
                "extreme",
                "grocery",
                "freedom",
                "buyer",
                "amazing",
                "ten",
                "employee",
                "capability",
                "adopt",
                "native",
                "miss",
                "health",
                "upper",
                "german",
                "council",
                "wood",
                "touch",
                "tunnel",
                "twelve",
                "engineer",
                "react",
                "aside",
                "expensive",
                "national",
                "conservative",
                "politically",
                "northern",
                "snap",
                "sign",
                "courage",
                "empty",
                "mutual",
                "resist",
                "writing",
                "stone",
                "whenever",
                "into",
                "internet",
                "site",
                "these",
                "seriously",
                "motor",
                "apartment",
                "shrug",
                "bright",
                "contemporary",
                "ever",
                "send",
                "adjustment",
                "celebrity",
                "earn",
                "old",
                "neck",
                "famous",
                "handle",
                "repeat",
                "honest",
                "works",
                "item",
                "clean",
                "jacket",
                "living",
                "despite",
                "movie",
                "title",
                "consist",
                "chef",
                "whole",
                "interesting",
                "today",
                "station",
                "historian",
                "solution",
                "fairly",
                "base",
                "beauty",
                "busy",
                "mass",
                "properly",
                "genetic",
                "tea",
                "inner",
                "setting",
                "obviously",
                "bury",
                "beach",
                "shop",
                "directly",
                "major",
                "wine",
                "bite",
                "auto",
                "bombing",
                "man",
                "demonstration",
                "closely",
                "loud",
                "pool"};
        int minLength = new AlphabetExercise().alphabetExercise(vocabulary);
        Assert.assertEquals(82, minLength);
    }
}
