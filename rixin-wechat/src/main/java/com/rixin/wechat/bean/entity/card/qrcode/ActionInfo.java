package com.rixin.wechat.bean.entity.card.qrcode;

/**
 *
 * User: dairan
 * Date: 2019-04-11 16:20
 */
public class ActionInfo {
    private ActionInfoCard card;
    private ActionInfoMultipleCard multipleCard;

    public ActionInfo(ActionInfoCard card) {
        this.card = card;
    }

    public ActionInfo(ActionInfoMultipleCard multipleCard) {
        this.multipleCard = multipleCard;
    }

    public ActionInfoCard getCard() {
        return card;
    }

    public void setCard(ActionInfoCard card) {
        this.card = card;
    }

    public ActionInfoMultipleCard getMultipleCard() {
        return multipleCard;
    }

    public void setMultipleCard(ActionInfoMultipleCard multipleCard) {
        this.multipleCard = multipleCard;
    }

    @Override
    public String toString() {
        return "ActionInfo{" +
                "card=" + card +
                ", multipleCard=" + multipleCard +
                '}';
    }
}
