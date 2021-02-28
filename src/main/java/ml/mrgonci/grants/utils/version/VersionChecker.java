package ml.mrgonci.grants.utils.version;


import ml.mrgonci.grants.utils.interfaces.Grant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class VersionChecker {

    private final List<String> replaced = new ArrayList<>();
    private int latest;
    private String version = "";
    private String dlUrl;

    /**
     * Starts retrieving the info from the html file
     */
    public VersionChecker() {
        try {
            URL url = new URL("https://mrgonci.github.io/LuckGrants/updates.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String word;
            List<String> lines = new ArrayList<>();
            while ((word = reader.readLine()) != null)
                if (!lines.contains(word)) {
                    lines.add(word);
                }
            reader.close();
            for (String str : lines) {
                str = (str.replaceAll("\\s", "").isEmpty() ? "\n" : str);
                replaced.add(str
                        .replace("[", "{open}")
                        .replace("]", "{close}")
                        .replace(",", "{comma}")
                        .replace("_", "&"));
            }
            this.latest = Integer.parseInt(replaced.get(0).replaceAll("[aA-zZ]", "").replace(".", ""));
            this.version = replaced.get(0);
            this.dlUrl = replaced.get(1);
        } catch (Throwable e) {
            e.printStackTrace();
            Grant.out.Message("Error while retrieving latest LuckGrants version data");
        }
    }

    /**
     * @return the latest version as integer
     */
    public final int GetLatest() {
        return latest;
    }

    public final String getUpdateURL() {
        return this.dlUrl;
    }

    /**
     * @return the latest version status (Beta - Alpha - Release) and his version int
     */
    public final String getVersionString() {
        String url = version.replaceAll("[A-z]", "");
        String versionTxt = version.replaceAll("[0-9]", "").replace(".", "").replace(" ", "");
        if (!versionTxt.isEmpty()) {
            return versionTxt + " / " + url.replace(" ", "");
        } else {
            return url.replace(" ", "");
        }
    }

    /**
     * Gets the changelog
     *
     * @return the latest version changelog
     */
    public final String getChangeLog() {
        List<String> replace = new ArrayList<>();

        for (int i = 0; i < replaced.size(); i++) {
            if (i == 0) {
                replace.add("&f");
                replace.add("&b--------- &eChangeLog &6: &a{version} &b---------"
                        .replace("{version}", replaced.get(0)) + "&r");
                replace.add("&f");
            } else {
                if (i != 1) {
                    replace.add(replaced.get(i).replace("-", "&8-&3"));
                }
            }
        }
        replace.add("&f");
        replace.add("&b--------- &eChangeLog &6: &a{version} &b---------"
                .replace("{version}", replaced.get(0)) + "&r");

        return replace.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "\n")
                .replace("{open}", "[")
                .replace("{close}", "]")
                .replace("{comma}", ",");
    }
}