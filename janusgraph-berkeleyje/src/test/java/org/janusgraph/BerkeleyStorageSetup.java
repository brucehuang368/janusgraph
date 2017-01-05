package org.janusgraph;

import org.janusgraph.diskstorage.configuration.ModifiableConfiguration;
import org.janusgraph.diskstorage.configuration.WriteConfiguration;

import static org.janusgraph.graphdb.configuration.GraphDatabaseConfiguration.*;

public class BerkeleyStorageSetup extends StorageSetup {

    public static ModifiableConfiguration getBerkeleyJEConfiguration(String dir) {
        return buildGraphConfiguration()
                .set(STORAGE_BACKEND,"berkeleyje")
                .set(STORAGE_DIRECTORY, dir);
    }

    public static ModifiableConfiguration getBerkeleyJEConfiguration() {
        return getBerkeleyJEConfiguration(getHomeDir("berkeleyje"));
    }

    public static WriteConfiguration getBerkeleyJEGraphConfiguration() {
        return getBerkeleyJEConfiguration().getConfiguration();
    }

    public static ModifiableConfiguration getBerkeleyJEPerformanceConfiguration() {
        return getBerkeleyJEConfiguration()
                .set(STORAGE_TRANSACTIONAL,false)
                .set(TX_CACHE_SIZE,1000);
    }
}