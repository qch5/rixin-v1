package com.rixin.wechat.bean.entity.card.type;

import com.rixin.wechat.bean.entity.card.CardType;
import com.rixin.wechat.bean.entity.card.base.Card;
import com.rixin.wechat.bean.entity.card.base.Gift;

/**
 * 兑换券.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class GiftCard extends Card {
    private Gift gift;

    public GiftCard() {
        super(CardType.GIFT.name());
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    @Override
    public String toString() {
        return "GiftCard{" +
                "cardType='" + getCardType() + '\'' +
                "gift=" + gift +
                "} " + super.toString();
    }
}
