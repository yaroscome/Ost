package com.yrs.ost.features.rootset;

import com.yrs.ost.models.Set;

import java.util.List;

/**
 * Created by yaros on 03/03/16.
 */
public interface RootSetContract {
    interface View {

        void showErrorDialog(String errorMessage);
        void showEpisodeDetails(String episodePath);
        void populateList(List<Set> rootSetList);
    }

    interface ActionListener {

        void getEpisodeDetails(int position);
        void startSetDownloading();

    }


}
