package com.renovite.transactionidmapper.interfaces;

import org.json.JSONObject;

/**
 * Created by sushil.kumar on 12-01-2018.
 */

public interface DlgInterface {
    void dismiss();
    void update(JSONObject jsonObject);
    void update (String string);
    void update ();
}
