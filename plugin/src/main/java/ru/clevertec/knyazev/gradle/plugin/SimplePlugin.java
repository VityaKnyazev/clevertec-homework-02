package ru.clevertec.knyazev.gradle.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class SimplePlugin implements Plugin<Project>{

	@Override
	public void apply(Project project) {
		project.getTasks().create("helloTask", SimpleTask.class);
	}

}