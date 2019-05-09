package com.rixin.wechat.bean.entity.card.type;

import com.rixin.wechat.bean.entity.card.CardType;
import com.rixin.wechat.bean.entity.card.base.Card;
import com.rixin.wechat.bean.entity.card.base.Cash;

/**
 * 代金券.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class CashCard extends Card {
    private Cash cash;

    public CashCard() {
        super(CardType.CASH.name());
    }

    public Cash getCash() {
        return cash;
    }

    public void setCash(Cash cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "CashCard{" +
                "cardType='" + getCardType() + '\'' +
                "cash=" + cash +
                "} " + super.toString();
    }
}
