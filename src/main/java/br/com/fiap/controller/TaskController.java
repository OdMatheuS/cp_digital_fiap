package br.com.fiap.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.entity.Tasks;
import br.com.fiap.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/listar")
	public List<Tasks> getAllTasks() {
		return taskService.getAllTaskes();
	}

	@GetMapping("/{id}")
	public Optional<Tasks> getTask(@PathVariable Long id) {
		return taskService.getTaskesById(id);
	}

	@PostMapping("/cadastrar")
	public Tasks createTask(@RequestBody Tasks task) {
		return taskService.createTaskes(task);
	}

	@PutMapping("/{id}")
	public Tasks updateTask(@PathVariable Long id, @RequestBody Tasks task) {
		task.setId(id);
		return taskService.updateTaskes(id, task);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTaskes(id);
	}
}
