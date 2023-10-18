package ru.clevertec.knyazev.tag.git;

import ru.clevertec.knyazev.tag.exception.GitException;

public interface GitService {

    /**
     *
     * Determine the name of current branch
     *
     * @return name of current branch
     * @throws GitException if an io error occurred
     */
    String determineBranch() throws GitException;

    /**
     *
     * Get current commit hash id. Must be 40 symbols.
     *
     * @return current commit hash id
     * @throws GitException if an error occurred
     */
    String getCurrentCommitId() throws GitException;

    /**
     *
     * Get current tag version
     *
     * @return current tag version or v0.0 if no tag exists
     * @throws GitException if no tag version found
     */
    String getPublishedTagVersion() throws GitException;

    /**
     *
     * Add new tag with given version to current commit
     *
     * @param tagVersion to add
     * @throws GitException if jGit error occurred
     */
    void publishTagVersion(String tagVersion) throws GitException;

    /**
     *
     * Check if tag exists on current commit
     *
     * @param commitId commit id
     * @return true if tag already exists on current commit -
     *         otherwise - false.
     */
    boolean isTagExist(String commitId);

    /**
     *
     * Check if uncommitted  changes presents on current
     * commit id
     *
     * @param commitId commit id
     * @return true if uncommitted  changes presents on current
     *         commit id, otherwise - false
     * throws GitAPIException when jGit error
     */
    boolean isUncommittedChanges(String commitId) throws GitException;

}
