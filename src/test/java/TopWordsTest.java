import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopWordsTest {
    private TopWords topWords;
    @BeforeEach
    public void setUp(){
        topWords = new TopWords();
    }

    @Test
    public void shoudReturnEDA(){
        assertEquals(Arrays.asList("e", "d", "a"),    TopWords.top3("a a a  b  c c  d d d d  e e e e e"));
    }

    @Test
    public void shoudReturnEDDDAA(){
        assertEquals(Arrays.asList("e", "ddd", "aa"), TopWords.top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
    }

    @Test
    public void shoudReturnwont(){
        assertEquals(Arrays.asList("won't", "wont"),  TopWords.top3("  //wont won't won't "));    }

    @Test
    public  void shoudReturnNothing(){
        assertEquals(Arrays.asList(), TopWords.top3("  ...  "));
        assertEquals(Arrays.asList(), TopWords.top3("  '  "));
        assertEquals(Arrays.asList(), TopWords.top3("  '''  "));
    }

    @Test
    public  void bigTest(){
        assertEquals(Arrays.asList("a", "of", "on"),  TopWords.top3(Stream
                .of("In a village of La Mancha, the name of which I have no desire to call to",
                        "mind, there lived not long since one of those gentlemen that keep a lance",
                        "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
                        "coursing. An olla of rather more beef than mutton, a salad on most",
                        "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
                        "on Sundays, made away with three-quarters of his income.")
                .collect(Collectors.joining("\n")) ));
    }

    @Test
    public void biggestTest(){
        assertEquals(Arrays.asList("tiryclmztj", "opdjieqrlp", "qwlwqanpdj"), TopWords.top3("QOsFD_FzPFnSE wADZGJo oPDJiEQrlP!QWlwqAnpDJ;LgvGtgtM FzPFnSE oPDJiEQrlP:LgvGtgtM wADZGJo!QOsFD oPDJiEQrlP.tIrycLmztj tIrycLmztj QOsFD;oPDJiEQrlP;khRiGtG tIrycLmztj QWlwqAnpDJ?wADZGJo,khRiGtG khRiGtG FzPFnSE/oPDJiEQrlP LgvGtgtM!wADZGJo_wqELK QWlwqAnpDJ khRiGtG_khRiGtG oPDJiEQrlP-FzPFnSE QWlwqAnpDJ!khRiGtG khRiGtG oPDJiEQrlP wADZGJo!tIrycLmztj khRiGtG FzPFnSE LgvGtgtM!tIrycLmztj,tIrycLmztj QWlwqAnpDJ?QWlwqAnpDJ tIrycLmztj QWlwqAnpDJ khRiGtG!QWlwqAnpDJ FzPFnSE khRiGtG oPDJiEQrlP tIrycLmztj oPDJiEQrlP!LgvGtgtM-FzPFnSE?wADZGJo FzPFnSE?oPDJiEQrlP.wADZGJo LgvGtgtM!QOsFD QWlwqAnpDJ QWlwqAnpDJ FzPFnSE;wADZGJo FzPFnSE,tIrycLmztj oPDJiEQrlP khRiGtG FzPFnSE wqELK wqELK!QWlwqAnpDJ!oPDJiEQrlP khRiGtG QWlwqAnpDJ oPDJiEQrlP khRiGtG tIrycLmztj?QWlwqAnpDJ tIrycLmztj FzPFnSE.tIrycLmztj wqELK tIrycLmztj,LgvGtgtM tIrycLmztj:tIrycLmztj/FzPFnSE wqELK!LgvGtgtM wADZGJo FzPFnSE:LgvGtgtM.LgvGtgtM oPDJiEQrlP.QWlwqAnpDJ?oPDJiEQrlP,QOsFD wADZGJo khRiGtG FzPFnSE FzPFnSE LgvGtgtM_oPDJiEQrlP;tIrycLmztj oPDJiEQrlP wADZGJo/QOsFD tIrycLmztj QOsFD/QWlwqAnpDJ wqELK FzPFnSE tIrycLmztj wADZGJo-FzPFnSE/tIrycLmztj QOsFD?FzPFnSE tIrycLmztj_tIrycLmztj FzPFnSE.FzPFnSE QOsFD wqELK QWlwqAnpDJ;QWlwqAnpDJ.tIrycLmztj FzPFnSE.LgvGtgtM;QWlwqAnpDJ LgvGtgtM QWlwqAnpDJ:QWlwqAnpDJ!wADZGJo.tIrycLmztj wqELK QOsFD-QWlwqAnpDJ_oPDJiEQrlP oPDJiEQrlP tIrycLmztj?khRiGtG QOsFD?LgvGtgtM_khRiGtG:FzPFnSE oPDJiEQrlP khRiGtG:wADZGJo khRiGtG/oPDJiEQrlP,oPDJiEQrlP:oPDJiEQrlP/QOsFD wqELK/wADZGJo LgvGtgtM wqELK/tIrycLmztj/wqELK tIrycLmztj;QWlwqAnpDJ,wqELK khRiGtG:LgvGtgtM wADZGJo khRiGtG,khRiGtG wqELK tIrycLmztj oPDJiEQrlP.LgvGtgtM LgvGtgtM,oPDJiEQrlP LgvGtgtM QWlwqAnpDJ FzPFnSE oPDJiEQrlP?QOsFD-tIrycLmztj;khRiGtG oPDJiEQrlP FzPFnSE wqELK,tIrycLmztj?QOsFD_oPDJiEQrlP QWlwqAnpDJ,LgvGtgtM oPDJiEQrlP wqELK wqELK.tIrycLmztj-wqELK oPDJiEQrlP QWlwqAnpDJ;FzPFnSE!QOsFD?QWlwqAnpDJ "));
    }
}
