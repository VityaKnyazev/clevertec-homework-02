package ru.clevertec.knyazev.gradle.plugin;

import java.io.File;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.invocation.Gradle;
import org.gradle.api.tasks.TaskAction;

public class SimpleTask extends DefaultTask {

	@TaskAction
	public void helloTask() {
		System.out.println("This is the hello task!");
		System.out.println("Hello task print information about Gradle and project!");
		printGradleInfo();
		printProjectInfo();
	}
	
	private void printGradleInfo() {
		Gradle gradle = getProject().getGradle();
		
		String gradleVersion = gradle.getGradleVersion();
		
		File file = gradle.getGradleUserHomeDir();
		String gradlePath = file.getAbsolutePath();
		
		System.out.println("You are using Gradle version " + gradleVersion + " from path " + gradlePath);
	}
	
	private void printProjectInfo() {
		Project project = getProject();
		
		String projectName = project.getDisplayName();
		String projectPath = project.getPath();
		
		System.out.println("You are developing Project with name " + projectName + " from path " + projectPath);		
	}
}