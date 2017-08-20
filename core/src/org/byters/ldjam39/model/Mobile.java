package org.byters.ldjam39.model;

import java.util.ArrayList;

public class Mobile {
    public static final int SCREEN_NANCY = 3;
    public static final int ITEM_NANCY = 1;
    private static final int MAX_ITEM_POS = 3;
    private static final long INDICATOR_SHOW_TIME = 1000;
    private boolean isShown;
    private MobileScreenEnum currentScreen;
    private int selectedItem;
    private ArrayList<MobileScreenEnum> listScreenTasks;
    private ArrayList<MobileScreenEnum> listScreenPhonebook;
    private long lastIndicatorShowTime;

    public Mobile() {
        selectedItem = 0;
        currentScreen = MobileScreenEnum.SCREEN_TASKS_1;

        listScreenTasks = new ArrayList<MobileScreenEnum>();
        listScreenTasks.add(MobileScreenEnum.SCREEN_TASKS_1);
        listScreenTasks.add(MobileScreenEnum.SCREEN_TASKS_2);

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
            currentScreen = pos == listScreenTasks.size() - 1
                    ? listScreenPhonebook.get(0)
                    : listScreenTasks.get(pos + 1);
            return;
        }

        pos = listScreenPhonebook.indexOf(currentScreen);
        if (pos != -1)
            currentScreen = pos == listScreenPhonebook.size() - 1
                    ? listScreenTasks.get(0)
                    : listScreenPhonebook.get(pos + 1);
    }

    public void prevScreen() {
        int pos = listScreenTasks.indexOf(currentScreen);
        if (pos != -1) {
            currentScreen = pos == 0
                    ? listScreenPhonebook.get(listScreenPhonebook.size() - 1)
                    : listScreenTasks.get(pos - 1);
            return;
        }

        pos = listScreenPhonebook.indexOf(currentScreen);
        if (pos != -1)
            currentScreen = pos == 0
                    ? listScreenTasks.get(listScreenTasks.size() - 1)
                    : listScreenPhonebook.get(pos - 1);
    }

    public boolean isCurrentScreenPhonebook() {
        return listScreenPhonebook.contains(currentScreen);
    }

    public boolean isCurrentScreenTasks() {
        return listScreenTasks.contains(currentScreen);
    }

    public int getCurrentScreenIndex() {
        return isCurrentScreenPhonebook()
                ? listScreenPhonebook.indexOf(currentScreen)
                : listScreenTasks.indexOf(currentScreen);
    }

    public void nextItem() {
        if (!listScreenPhonebook.contains(currentScreen)) {
            nextScreen();
            return;
        }
        ++selectedItem;
        if (selectedItem > MAX_ITEM_POS) {
            selectedItem = listScreenPhonebook.indexOf(currentScreen) < listScreenPhonebook.size() - 1
                    ? 0
                    : MAX_ITEM_POS;
            nextScreen();
        }
    }

    public void prevItem() {
        if (!listScreenPhonebook.contains(currentScreen)) {
            prevScreen();
            return;
        }

        --selectedItem;
        if (selectedItem < 0) {
            selectedItem = listScreenPhonebook.indexOf(currentScreen) > 0
                    ? MAX_ITEM_POS
                    : 0;
            prevScreen();
        }
    }

    public void openTasks() {
        currentScreen = MobileScreenEnum.SCREEN_TASKS_1;
    }

    public int getSelectedItem() {
        return selectedItem;
    }

    public void showIndicator() {
        this.lastIndicatorShowTime = System.currentTimeMillis();
    }

    public boolean isIndicatorShow() {
        return System.currentTimeMillis() < lastIndicatorShowTime + INDICATOR_SHOW_TIME;
    }
}
