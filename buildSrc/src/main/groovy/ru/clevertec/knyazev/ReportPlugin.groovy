package ru.clevertec.knyazev

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.invocation.Gradle

class ReportPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        addReportTask(project)
    }

    private void addReportTask(Project project) {

        project.task(description: 'Print information about Gradle and project', group: 'clevertec', type: DefaultTask, 'report') {

            doFirst {
                println 'This is the report task!'
                println 'Report task print information about Gradle and project!'
            }

            doLast {
                String projectName = project.displayName
                String projectPath = project.projectDir

                Gradle gradle = project.gradle
                String gradleVersion = gradle.gradleVersion
                File file = gradle.gradleHomeDir
                String gradlePath = file.absolutePath

                println 'Developing Project with name ' + projectName + ' from path ' + projectPath
                println 'using Gradle version ' + gradleVersion + ' from path ' + gradlePath
            }

        }

    }

}
