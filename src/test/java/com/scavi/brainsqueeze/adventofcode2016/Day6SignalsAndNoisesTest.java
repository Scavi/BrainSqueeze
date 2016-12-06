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

package com.scavi.brainsqueeze.adventofcode2016;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael Heymel
 * @since 06/12/16
 */
public class Day6SignalsAndNoisesTest {

    @Test
    public void test1() {
        String[] message =
                new String[]{"eedadn", "drvtee", "eandsr", "raavrd", "atevrs", "tsrnev", "sdttsa",
                             "rasrtv", "nssdts", "ntnada", "svetve", "tesnvt", "vntsnd", "vrdear",
                             "dvrsen", "enarar"};
        Day6SignalsAndNoises signalsAndNoises = new Day6SignalsAndNoises();
        String decryptedMessage = signalsAndNoises.decrypt(message);
        Assert.assertEquals("easter", decryptedMessage);
    }


    @Test
    public void testQuestion1() {
        String[] message = getInput();
        Day6SignalsAndNoises signalsAndNoises = new Day6SignalsAndNoises();
        String decryptedMessage = signalsAndNoises.decrypt(message);
        Assert.assertEquals("agmwzecr", decryptedMessage);
    }


    @Test
    public void testQuestion2() {
        String[] message = getInput();
        Day6SignalsAndNoises signalsAndNoises = new Day6SignalsAndNoises(false);
        String decryptedMessage = signalsAndNoises.decrypt(message);
        Assert.assertEquals("owlaxqvq", decryptedMessage);
    }


    public String[] getInput() {
        return new String[]{"tmcezlum", "afzwmyrz", "ollxkaqs", "oqvdutkr", "ufzmsidi", "wnidhqow",
                            "efgwivmh", "endrsvkk", "nraaoczx", "yghmfumn", "fcwrdzyt", "qbbejygt",
                            "ohrzbtul", "lmrarckg", "frzhozsk", "ahvqozmk", "cnoxuqjm", "njudcxbx",
                            "xjeohiim", "sygfjxcx", "fbmchcaa", "qqggrcwq", "vbcgurox", "eujzkdmh",
                            "kbpinltk", "posxqzam", "rojnpogl", "zvhruwqw", "hvbrxcky", "iqifiukd",
                            "xetwaptt", "qvksnzoe", "nulslfja", "tphqwfte", "ddencvfp", "nhabbwcl",
                            "jefzkclw", "txstxeio", "yaaqxpdp", "efewzeqa", "teapznjk", "jylnjhnf",
                            "jumelmrz", "ziarkfwo", "vklsvaca", "uoyzpkbn", "oovggzkn", "ajvmcuon",
                            "gkztjkss", "qnwohfwg", "kxwtvaez", "jwavozvo", "qgqbbaoc", "xzdepoxu",
                            "kbxhekyv", "ceuqobnx", "qlrejrjz", "fvknhyqb", "tfwsmaei", "ofpzikkg",
                            "xggckiou", "avcoljdv", "vhzjtrwv", "dyqnywkg", "udobaedh", "gncyxisz",
                            "oedldehj", "ssmyewfv", "ciaphyxw", "fhizpimr", "bjyeqyzh", "owjojbzf",
                            "skdfqaeq", "ubspxbix", "truvdgua", "ttvftscb", "qjyxodqz", "cakskune",
                            "okojmtim", "rvrhaprz", "iezxilxh", "yalqlefr", "rxygadto", "hdszdagc",
                            "srqhzltw", "vuinwxvi", "jcunlnmn", "jxolxqid", "mnnjrghb", "jogafqpd",
                            "ixdlwxwj", "sttkgdyk", "iqfeawey", "zdlukwnn", "odghxddl", "eoflpjdw",
                            "haketaof", "ylkfukna", "pdwemhut", "ryyhsryr", "iapyhpba", "wtgsqrtt",
                            "hctctzdi", "ulnuyuex", "bpxpdeqb", "itbourhl", "dztqwptk", "gmmsltml",
                            "evnhvtiy", "asjexlfo", "sgxejmmg", "qxbhjpmp", "prauglcy", "bulipmjg",
                            "xjrkceql", "utehzgxa", "ltvfsdrj", "lnyazzkp", "ddnndirm", "bddvibpq",
                            "ajxjxdls", "uidqyood", "cjqffbdm", "nzonwmsr", "zmcesyao", "wvfwtwuc",
                            "pwuqzzvg", "eciaebxq", "vxbuvava", "yhalnneq", "pejiyegy", "tsopxjfn",
                            "ggzatxrg", "lgnpyiko", "einylipk", "cwtgfpza", "niddiicg", "ctqbwhzb",
                            "mzpgsons", "aqaxajai", "fkwufqgn", "dglewfob", "xoqdxsnr", "blxnybat",
                            "bohqqthr", "qanfhczt", "gkpxjfrb", "zmewqucy", "atuodurb", "suiitdqe",
                            "usywjzqc", "voltqnvd", "ppstzuzb", "ncxkbwul", "hgivkyyq", "bldyxpov",
                            "yvjbraai", "fhqawceq", "nrmjvhnh", "kpwxogac", "trtzfnkp", "pczcsgns",
                            "rfjdromo", "uncmnnjj", "eordqsju", "rhvpcncs", "hrokpyig", "bkszmpef",
                            "krugmwkb", "syvtsdek", "vigizldv", "vldwtfmv", "ckcbqkrf", "dtvjipcw",
                            "ampjmdpd", "kcirijwv", "zzufovbr", "olexgnqh", "llxddfsh", "wfnnkivb",
                            "dzvcoxpi", "wpcwuqoc", "nejgfqvm", "mgbjcbst", "uglwuejg", "rwfcpnpp",
                            "dbfycvwm", "hisynlnw", "gglqswni", "wpmiixuf", "rqbfxlef", "lsupxzeu",
                            "uqrzsowl", "xqmgmnyk", "gzdfdbtb", "aoyujvtz", "zmhsbsde", "xnmsgyvk",
                            "gszwzotk", "fkbphiti", "lffmpdda", "plotuwbi", "hakfuxeb", "cpqzjdjb",
                            "foqwhfis", "ctevnjly", "bbnuoohx", "zjndqgbv", "ftmrakmg", "yphljbse",
                            "vcmmtout", "ishcbwpn", "oysaacfd", "upawmrwj", "cexlaadr", "cezsoibf",
                            "yydnylal", "mieypczr", "ltbuvmfu", "ekumekic", "krbiejuo", "cyweeeht",
                            "lugkftlh", "pohkdvai", "xgoxbacm", "ingicfit", "dclavjqp", "dnzgfbrc",
                            "jssnhcfu", "txykgvhl", "uwvgyzgz", "jecfzcoi", "yaktumqx", "oqehhika",
                            "voqmtwam", "wchhskdh", "kxjzeygs", "krfjungf", "iqamjkgh", "ajaxlbcr",
                            "mfrdjjwz", "jvqfkkjt", "mupueoje", "ozvctxzd", "qneodvvw", "zisckhyc",
                            "yxgudchh", "oapmbpbc", "pyizuqnn", "ttnblbho", "xdpiahgx", "lyerpyzv",
                            "dzslbegp", "fvujdszc", "qhuhvkej", "wxktwmez", "irrqradv", "xtbqoxyg",
                            "nhlrfrgy", "gocvpvlp", "bwybesby", "rvewprlo", "elwmmcos", "fertmhyj",
                            "qhxooqtq", "gzdaipgn", "yqfmniyt", "gornoejg", "wqgsxzys", "kxqaletd",
                            "ikuvaeft", "essiqowb", "ymohhvfu", "kzjynqhe", "ooxnssfp", "hpnozozp",
                            "kdxkokxe", "rwredkrn", "znmrmswj", "svtkdsuu", "ibjqwhwi", "mknydjrv",
                            "opchsgmr", "tbyvuatt", "igevmbpk", "expjknbc", "kzboboox", "usoxsikr",
                            "fizzvucq", "rvjomwnd", "sgfcwqdl", "ocacgxpj", "mropbfvf", "xexycbuo",
                            "qngxnnud", "itmenmlm", "dyaqaifs", "jwgtqejq", "eyeaavrj", "vwyjauhk",
                            "hqajvjkh", "ddvhuacy", "gjgrgtll", "mgawuelx", "lmdgzggf", "pbtgkvxc",
                            "svwklnwu", "kvtsovnm", "oybxcuqk", "ufwkjtlj", "xkrgfyad", "kdgdjzqp",
                            "iqdgesbu", "mxpocjsl", "rmwvihpw", "bpbftisr", "kgtgxxqw", "ypwjafxu",
                            "hihxitsz", "lnntwahr", "ssecoqkz", "ynktphtd", "skwfmfpw", "bihrglvz",
                            "xzkjkgjm", "cuozrxqe", "qmcfrurm", "tphowbli", "zvzwyhrv", "vzlfbuor",
                            "vblsrrba", "lakiynlc", "afomthrw", "rbgtoyfq", "ahkqljen", "gamoerak",
                            "wumjelwi", "vqimktjy", "levvfcsq", "euwrqnjp", "fapllntx", "vyzlxslf",
                            "rwhcbrvz", "txpficpp", "mbwpimjr", "zohppwog", "zdrsdecc", "uaxqlvsh",
                            "ykerbsdc", "aecktaff", "wrtdufue", "gykyrwcv", "sesrvnsp", "hmopnqyy",
                            "tfuulvec", "jdokvsfw", "jwkhzpaf", "mjvzffxn", "pctkfrtb", "wfiwcoxg",
                            "qodzwvbg", "brcaggnu", "jjjrrtiu", "ktkobacy", "nahinlmj", "nszbvcmi",
                            "nfvbldhe", "tjweqfgt", "crabmuxk", "affxwlpf", "mpominpv", "yufjtaaa",
                            "hzzhmsyx", "plwdkozp", "ozbgwwvd", "pplerubj", "wzumeuqo", "ksynbxaf",
                            "yxeircsj", "gaqlykne", "irsltmrz", "jifivecj", "vhwsstkq", "mjiiiuab",
                            "nkimvhvg", "memuhxrh", "tjvbzypn", "glebcdpn", "zrmcpufo", "imxlujrn",
                            "acftqbcf", "symmrhuj", "lqkrybxd", "jsyxqzqt", "xbqjvjxl", "qwqsvysm",
                            "ddjypobl", "rwxyfjby", "wpoiklyi", "eiftosiu", "cabwkqhx", "yxtbhlxo",
                            "heismnzr", "yaduhfgm", "nghplvvs", "lwukrqdx", "ifjqghtk", "qclffqxm",
                            "cuszvrgk", "ocshztws", "hipeodcu", "qnbgnllz", "qsuogdmr", "eusogkvt",
                            "rddealkr", "fjrrvsco", "nugopflj", "bhgbdkxs", "fthcqpao", "tkdvyegv",
                            "tbvpgueq", "ahfagxlm", "cipkqfxj", "vqqcipuc", "mugdchdl", "wwjpnife",
                            "purpypnv", "cqzunigd", "nlnvjhbd", "hhiqrzod", "fwjhmdij", "wkpvakif",
                            "bjrytvwo", "uosbgqjb", "bdmfzjcy", "dxlqldzl", "akqbtwvs", "wbxschlg",
                            "mrzksrhs", "jmvueuih", "ebxpjnhp", "llsogwyw", "peyzimia", "mufdkyny",
                            "dlvxntre", "dyfyazrx", "aarkcrwe", "qqacegoh", "rbiqykai", "tbnkymsk",
                            "ebtsieby", "uhyjeeba", "ahpywtnx", "gyvacpuf", "frcyslud", "mwwnxofu",
                            "jzyabbkj", "cctdoztv", "jztmavpd", "sacgyoii", "gnqiydic", "ggdrerzq",
                            "lduphshn", "hctmpgih", "kqabzyjt", "ppkztsay", "pnusnowm", "ulyvxfkp",
                            "vmlapyyt", "zifxarmp", "vnpzxhjb", "raewumao", "wejyiymi", "gjbdfjzy",
                            "bxhlwziy", "rsqlgthf", "xtkaltqu", "smiarmpw", "xdypfzem", "yleuggnb",
                            "wgphfsve", "xgqmyqhq", "iyfrymtc", "bwhjkhfl", "aftctjug", "seibsuof",
                            "ngcdnmxw", "ltxyudxa", "xpwqkgdl", "hagwixkv", "lhtlmxqw", "dcineqxs",
                            "nzdrjynu", "vmytcguy", "ymsuzmox", "lkzvgcgh", "dfjgzjdn", "rvmgejgk",
                            "dcxdrgpz", "bhjsceuv", "nhpllxmo", "gkotvtsu", "uubvdkjg", "zjnerxhq",
                            "butazmez", "szzvqyzs", "fpchqsei", "xfsvriyr", "vxodutyh", "zsilhmba",
                            "rvacqpwj", "hjewdrtx", "bylcpgfs", "qtntvgfq", "ioqldhye", "wlrbwapp",
                            "nlptloss", "znnybfvl", "einvacbu", "kyziepsr", "fthuwmlv", "pmkbhvdn",
                            "xuxngboe", "tpoinkzc", "zwbnhlwp", "usuusbin", "jiulcmsq", "elcusgvu",
                            "frclhdyo", "pvmirlch", "jvrjfxmb", "sxmtcrsw", "ccfkmgmw", "mdnibgld",
                            "idmojsza", "hsjvyoua", "smhwbpax", "pgcozahq", "dstdnwle", "aiikfrxt",
                            "kmbnsppa", "wsxcbwze", "hqyunies", "mfrxeqyw", "zikpwtqz", "zckxtclz"};
    }
}
