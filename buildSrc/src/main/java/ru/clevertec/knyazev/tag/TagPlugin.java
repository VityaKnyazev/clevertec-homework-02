package ru.clevertec.knyazev.tag;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import ru.clevertec.knyazev.tag.exception.GitException;
import ru.clevertec.knyazev.tag.exception.TagInfoException;
import ru.clevertec.knyazev.tag.git.GitServiceImpl;

public class TagPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {

        project.task("tag").doFirst(task -> {
            task.setDescription("Adding a tag to current commit on specified rules");
            task.setGroup("clevertec");
        }).doLast(task -> {
            try {
                String projectDir = project.getRootProject().getRootDir().getAbsolutePath();
                String newTagVersion = new TagInfoImpl(new GitServiceImpl(projectDir)).incrementVersion();
                System.out.println("Tag plugin: new tag version=" + newTagVersion + " has been successfully applied");
            } catch (GitException | TagInfoException e) {
                System.out.println("Tag task error: " + e.getMessage());
            }
        });

    }

}
