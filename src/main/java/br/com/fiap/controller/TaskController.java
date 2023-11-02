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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.entity.Taskes;
import br.com.fiap.service.TaskService;

@RestController
@RequestMapping("/api/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/listar")
	public List<Taskes> getAllTasks() {
		return taskService.getAllTaskes();
	}

	@GetMapping("/{id}")
	public Optional<Taskes> getTask(@PathVariable Long id) {
		return taskService.getTaskesById(id);
	}

	@PostMapping("/cadastrar")
	public Taskes createTask(@RequestBody Taskes task) {
		return taskService.createTaskes(task);
	}

	@PutMapping("/{id}")
	public Taskes updateTask(@PathVariable Long id, @RequestBody Taskes task) {
		task.setId(id);
		return taskService.updateTaskes(id, task);
	}

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTaskes(id);
	}
}
