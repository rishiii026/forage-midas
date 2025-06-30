package com.jpmc.midascore;

import com.jpmc.midascore.component.DatabaseConduit;
import com.jpmc.midascore.entity.UserRecord;

public class UserPopulator {

    private final DatabaseConduit databaseConduit;

    public UserPopulator(DatabaseConduit databaseConduit) {
        this.databaseConduit = databaseConduit;
    }

    public void populate() {
        databaseConduit.saveUser(new UserRecord("bernise", 1200.23));
        databaseConduit.saveUser(new UserRecord("grommit", 2215.37));
        databaseConduit.saveUser(new UserRecord("maria", 2774.14));
        databaseConduit.saveUser(new UserRecord("mario", 12.34));
        databaseConduit.saveUser(new UserRecord("waldorf", 444.55));
        databaseConduit.saveUser(new UserRecord("whosit", 888.90));
        databaseConduit.saveUser(new UserRecord("whatsit", 777.60));
        databaseConduit.saveUser(new UserRecord("howsit", 68.70));
        databaseConduit.saveUser(new UserRecord("wilbur", 3476.21));
        databaseConduit.saveUser(new UserRecord("antonio", 2121.54));
        databaseConduit.saveUser(new UserRecord("calypso", 779421.33));
    }
}
