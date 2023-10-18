package ru.clevertec.knyazev.tag.git;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevWalk;
import ru.clevertec.knyazev.tag.exception.GitException;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class GitServiceImpl implements GitService {

    private  Git git;

    public GitServiceImpl(String gitPath) throws GitException {

        try {
            git = Git.open(new File(gitPath));
        } catch (IOException e) {
            throw new GitException(e);
        }

    }

    @Override
    public String determineBranch() throws GitException {

        try {
            return git.getRepository().getBranch();
        } catch (IOException e) {
            throw new GitException(e);
        }

    }

    @Override
    public String getCurrentCommitId() throws GitException {

        try {
            return git.getRepository()
                      .resolve( "HEAD" )
                      .getName();
        } catch (IOException e) {
            throw new GitException(e);
        }

    }

    //TODO fix this method!
    @Override
    public String getPublishedTagVersion() throws GitException {
        List<Ref> tags;

        try {
            tags = git.tagList().call();
        } catch (GitAPIException e) {
            throw new GitException(e);
        }

        if (tags == null || tags.isEmpty()) {
            return "v0.0";
        }

        tags = tags.stream().sorted(Comparator.comparingInt(tag -> {

            try (RevWalk walk = new RevWalk(git.getRepository())) {
                return walk.parseCommit(((Ref) tag).getObjectId()).getCommitTime();
            } catch (IOException e) {
                throw new GitException(e);
            }

        }).reversed()).toList();

        return tags.get(0).getName();

    }

    @Override
    public void publishTagVersion(String tagVersion) throws GitException {

        try {
            git.tag().setName(tagVersion).call();
        } catch (GitAPIException e) {
            throw new GitException(e);
        }

    }

    @Override
    public boolean isTagExist(String commitId) {
        ObjectId objectId = ObjectId.fromString(commitId);

        try (RevWalk walk = new RevWalk(git.getRepository())) {
            walk.parseTag(objectId);
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    @Override
    public boolean isUncommittedChanges(String commitId) throws GitException {

        try {
            return git.status().call()
                      .hasUncommittedChanges();
        } catch (GitAPIException e) {
            throw new GitException(e);
        }

    }
}
