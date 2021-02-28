package ml.mrgonci.grants.utils.version;

import ml.mrgonci.grants.utils.interfaces.Grant;

public interface GrantVersion {

    String changeLog = new VersionChecker().getChangeLog();
    String version = new VersionChecker().getVersionString();
    Integer versionID = new VersionChecker().GetLatest();
    String updateURL = new VersionChecker().getUpdateURL();

    static boolean isOutdated() {
        return versionID > Grant.versionID;
    }

    static void sendChangeLog() {
        Grant.out.Message(changeLog);
    }


}
