package ru.clevertec.knyazev.gradle.plugin;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class SimpleTask extends DefaultTask {

	@TaskAction
	public void helloTask() {
		System.out.println("This is the hello task!");
	}
}