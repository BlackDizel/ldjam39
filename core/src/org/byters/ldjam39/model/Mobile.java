package org.byters.ldjam39.model;

import java.util.ArrayList;

public class Mobile {
    private boolean isShown;
    private MobileScreenEnum currentScreen;
    private ArrayList<MobileScreenEnum> listScreenTasks;
    private ArrayList<MobileScreenEnum> listScreenPhonebook;

    public Mobile() {
        currentScreen = MobileScreenEnum.SCREEN_TASKS_1;

        listScreenTasks = new ArrayList<MobileScreenEnum>();
        listScreenTasks.add(MobileScreenEnum.SCREEN_TASKS_1);
        listScreenTasks.add(MobileScreenEnum.SCREEN_TASKS_2);
        listScreenTasks.add(MobileScreenEnum.SCREEN_TASKS_3);

        listScreenPhonebook = new ArrayList<MobileScreenEnum>();
        listScreenPhonebook.add(MobileScreenEnum.SCREEN_PHONEBOOK_1);
        listScreenPhonebook.add(MobileScreenEnum.SCREEN_PHONEBOOK_2);
        listScreenPhonebook.add(MobileScreenEnum.SCREEN_PHONEBOOK_3);
        listScreenPhonebook.add(MobileScreenEnum.SCREEN_PHONEBOOK_4);
    }

    public boolean isShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }

    public void openClosePhonebook() {
        currentScreen = listScreenPhonebook.contains(currentScreen)
                ? MobileScreenEnum.SCREEN_TASKS_1
                : MobileScreenEnum.SCREEN_PHONEBOOK_1;
    }

    public void nextScreen() {
        int pos = listScreenTasks.indexOf(currentScreen);
        if (pos != -1) {
            currentScreen = listScreenTasks.get(Math.min(pos + 1, listScreenTasks.size() - 1));
            return;
        }

        pos = listScreenPhonebook.indexOf(currentScreen);
        if (pos != -1)
            currentScreen = listScreenPhonebook.get(Math.min(pos + 1, listScreenPhonebook.size() - 1));
    }

    public void prevScreen() {
        int pos = listScreenTasks.indexOf(currentScreen);
        if (pos != -1) {
            currentScreen = listScreenTasks.get(Math.max(pos - 1, 0));
            return;
        }

        pos = listScreenPhonebook.indexOf(currentScreen);
        if (pos != -1)
            currentScreen = listScreenPhonebook.get(Math.max(pos - 1, 0));
    }

    public boolean isCurrentScreenPhonebook() {
        return listScreenPhonebook.contains(currentScreen);
    }

    public int getCurrentScreenIndex() {
        return isCurrentScreenPhonebook()
                ? listScreenPhonebook.indexOf(currentScreen)
                : listScreenTasks.indexOf(currentScreen);
    }
}
