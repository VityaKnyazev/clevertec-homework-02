package ru.clevertec.knyazev.tag;

public abstract class TagInfo {

    /**
     *
     * Increment current tag version depends on incrementing cases and
     * return new tag version on success or old tag version (if tag has been
     * stand already)
     *
     * @return new tag version on success or old tag version (if tag has been
     *         stand already)
     */
    public abstract String incrementVersion();

    Integer getMajorPartVersion(String version) {
        return parseVersion(version)[0];
    }

    Integer getMinorPartVersion(String version) {
        return parseVersion(version)[1];
    }

    /**
     *
     * Get Major and minor version parts of current tag
     *
     * @param version of current tag
     * @return Major and minor version parts of current tag.
     *         Major part - at index 0, minor - at index 1
     */
    private Integer[] parseVersion(String version) {
        version = version.substring(1);

        if (version.contains("-")) {
            version = version.substring(0, version.indexOf("-"));
        }

        String[] result = version.split("\\.");

        return new Integer[]{Integer.valueOf(result[0]), Integer.valueOf(result[1])};
    }



}
