package org.byters.ldjam39.controller;

import org.byters.ldjam39.model.DialogMessage;
import org.byters.ldjam39.model.Mobile;
import org.byters.ldjam39.model.StringEnum;
import org.byters.ldjam39.model.WorldItemsEnum;

import java.util.ArrayList;
import java.util.Arrays;

public class InteractionMobile {

    private final Mobile mobile;

    public InteractionMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public void interact() {

        if (!(mobile.isShown()
                && mobile.isCurrentScreenPhonebook()
                && mobile.getCurrentScreenIndex() == Mobile.SCREEN_NANCY
                && mobile.getSelectedItem() == Mobile.ITEM_NANCY))
            return;

        mobile.setShown(false);

        if (!ControllerWorldState.getInstance().isWorldContains(WorldItemsEnum.NANCY_CALL)) {
            ControllerWorldState.getInstance().setMessageDialogPlayer(Arrays.asList(StringEnum.DIALOG_NANCY_FAIL.toString()));
            return;
        }

        ControllerWorldState.getInstance().removeWorldItem(WorldItemsEnum.NANCY_CALL);
        ArrayList<DialogMessage> dialog;
        dialog = new ArrayList<DialogMessage>();
        dialog.add(DialogMessage.newInstancePlayer(StringEnum.DIALOG_NANCY_1.toString(), 1100));
        dialog.add(DialogMessage.newInstancePlayer(StringEnum.DIALOG_NANCY_2.toString(), 1100));
        dialog.add(DialogMessage.newInstancePlayer(StringEnum.DIALOG_NANCY_3.toString(), 2000));
        dialog.add(DialogMessage.newInstancePlayer(StringEnum.DIALOG_NANCY_4.toString(), 2000));

        ControllerWorldState.getInstance().setMessagesDialog(dialog);


    }
}
