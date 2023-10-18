package ru.clevertec.knyazev.tag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.clevertec.knyazev.tag.exception.TagInfoException;
import ru.clevertec.knyazev.tag.git.GitService;

public class TagInfoImpl extends TagInfo {

    private static final String TAG_EXISTS_ERROR = "Tag already exists on current commit";
    private static final String UNCOMMITTED_CHANGES_ERROR = "Found uncommited changes on current commit";

    private GitService gitService;
    TagInfoImpl(GitService gitService) {
        this.gitService = gitService;
    }

    @Override
    public String incrementVersion() {

        StringBuilder incrementVersion = new StringBuilder("v");

        String currentCommitId = gitService.getCurrentCommitId();

        if (gitService.isTagExist(currentCommitId)) {
            throw new TagInfoException(TAG_EXISTS_ERROR);
        }

        if (gitService.isUncommittedChanges(currentCommitId)) {
            throw new TagInfoException(UNCOMMITTED_CHANGES_ERROR);
        }

        Branch currentBranch = Branch.findByName(gitService.determineBranch());

        String lastTagVersion = gitService.getPublishedTagVersion();
        Integer majorLastTagVersion = getMajorPartVersion(lastTagVersion);
        Integer minorLastTagVersion = getMinorPartVersion(lastTagVersion);

        StringBuilder suffix = new StringBuilder();

        switch (currentBranch) {
            case dev, qa -> minorLastTagVersion++;
            case master -> {
                minorLastTagVersion = 0;
                majorLastTagVersion++;
            }
            case stage -> suffix.append("-rc");
            case undefined -> suffix.append("-SNAPSHOT");
        }

        if (minorLastTagVersion == 0 && majorLastTagVersion == 0) {
            minorLastTagVersion = 1;
        }

        String newTagVersion = incrementVersion.append(majorLastTagVersion)
                                               .append(".")
                                               .append(minorLastTagVersion)
                                               .append(suffix)
                                               .toString();

        gitService.publishTagVersion(newTagVersion);

        return newTagVersion;
    }

    private enum Branch {
        dev, qa, stage, master, undefined;

        public static Branch findByName(String name) {

            Branch result = null;
            for (Branch branch : values()) {

                if (branch.name().equalsIgnoreCase(name)) {
                    result = branch;
                    break;
                }

            }

            return result != null ? result : undefined;

        }
    }


}
