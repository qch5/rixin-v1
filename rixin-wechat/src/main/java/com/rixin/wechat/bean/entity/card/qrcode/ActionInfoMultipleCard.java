package com.rixin.wechat.bean.entity.card.qrcode;

import java.util.List;

/**
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class ActionInfoMultipleCard {
    private List<ActionInfoCard> cardList;

    public List<ActionInfoCard> getCardList() {
        return cardList;
    }

    public void setCardList(List<ActionInfoCard> cardList) {
        this.cardList = cardList;
    }

    @Override
    public String toString() {
        return "ActionInfoMultipleCard{" +
                "cardList=" + cardList +
                '}';
    }
}
