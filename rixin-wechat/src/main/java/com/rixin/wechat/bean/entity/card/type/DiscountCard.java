package com.rixin.wechat.bean.entity.card.type;

import com.rixin.wechat.bean.entity.card.CardType;
import com.rixin.wechat.bean.entity.card.base.Card;
import com.rixin.wechat.bean.entity.card.base.Discount;

/**
 * 折扣券.
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class DiscountCard extends Card {
    private Discount discount;

    public DiscountCard() {
        super(CardType.DISCOUNT.name());
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "cardType='" + getCardType() + '\'' +
                "discount=" + discount +
                "} " + super.toString();
    }
}
