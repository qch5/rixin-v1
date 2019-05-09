package com.rixin.wechat.bean.entity.card.type;

import com.rixin.wechat.bean.entity.card.CardType;
import com.rixin.wechat.bean.entity.card.base.Card;
import com.rixin.wechat.bean.entity.card.base.Groupon;

/**
 * 团购券.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class GrouponCard extends Card {
    private Groupon groupon;

    public GrouponCard() {
        super(CardType.GROUPON.name());
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    @Override
    public String toString() {
        return "GrouponCard{" +
                "cardType='" + getCardType() + '\'' +
                "groupon=" + groupon +
                "} " + super.toString();
    }
}
